package com.dotuian.example;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dotuian.entity.UserEntity;

import com.dotuian.conf.sqlmap.UserMapper;

public class E02 {

    public static void main(String[] args) {

        String resource = "com/dotuian/conf/configuration.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            
            // 关于生命周期
            // 1.SqlSessionFactoryBuilder:一旦你创建了SqlSessionFactory后，这个类就不需要存在了
            // 2.SqlSessionFactory:一旦被创建，SqlSessionFactory应该在你的应用执行期间都存在
            // 3.SqlSession:每个线程都应该有它自己的SqlSession实例。SqlSession的实例不能被共享，也是线程不安全的。因此最佳的范围是请求或方法范围。
            // 4.Mapper:映射器是你创建绑定映射语句的接口。映射器接口的实例可以从SqlSession中获得。
            
            
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);

            SqlSession session = sqlSessionFactory.openSession();

            // 调用XML文件配置
            UserEntity user = (UserEntity) session.selectOne(
                    "com.dotuian.conf.sqlmap.UserMapper.selectUserById", 1);
            if (user != null) {
                System.out.println(user.toString());
            }

            
            // 调用映射器接口
            // 优点
            // 1.基于对象，而不是基于XML配置的文字，相对更为安全
            // 2.不需要强制类型转换
            // 3.通过接口可以保持简洁，返回值类型很安全（参数类型也很安全）
            // 4.中间的映射语句不需要通过XML来配置，可以直接使用Java注解来替换
            UserMapper mapper = session.getMapper(UserMapper.class);
            UserEntity user2 = mapper.selectUser2(2);
            if (user2 != null) {
                System.out.println(user2.toString());
            }
            
            
            session.close();

            
            
            

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

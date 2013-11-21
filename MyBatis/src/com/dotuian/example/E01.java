package com.dotuian.example;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dotuian.entity.UserEntity;

public class E01 {

    public static void main(String[] args) {

        String resource = "com/dotuian/conf/configuration.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);

            SqlSession session = sqlSessionFactory.openSession();
            
            
            try{
                // ===============================================================
                UserEntity user = (UserEntity) session.selectOne(
                        "com.dotuian.conf.sqlmap.UserMapper.selectUserById", 1);
                if (user != null) {
                    System.out.println(user.toString());
                }
                
                // ===============================================================
                HashMap map = (HashMap) session.selectOne(
                        "com.dotuian.conf.sqlmap.UserMapper.selectUser3", 3);
                Iterator<?> ite = map.keySet().iterator();
                while(ite.hasNext()){
                    String key = (String)ite.next();
                    System.out.println("key: " + key + "  value:" + map.get(key)) ;
                }
                
                // ===============================================================
                UserEntity user4 = (UserEntity) session.selectOne(
                        "com.dotuian.conf.sqlmap.UserMapper.selectUser4", 4);
                if (user4 != null) {
                    System.out.println(user4.toString());
                }
                
                // ===============================================================
                // 向数据库中添加一条记录
                UserEntity insertUser = new UserEntity();
                insertUser.setUsername("username");
                insertUser.setPassword("password");
                insertUser.setAge(27);
                insertUser.setSex("0");
                insertUser.setBirthday(new java.sql.Date(System.currentTimeMillis()));
                insertUser.setHobby("game,pc");
                insertUser.setSalary(Double.valueOf(123456));
                insertUser.setMemo("memo");
                int result = session.insert("com.dotuian.conf.sqlmap.UserMapper.insertUser", insertUser);
                System.out.println("Insert User Result : " + result);
                
                
                // ===============================================================
                // 更新数据库中的记录
                UserEntity updateUser = new UserEntity();
                updateUser.setId(Long.valueOf(1));
                updateUser.setUsername("username");
                updateUser.setPassword("password");
                updateUser.setAge(27);
                updateUser.setSex("0");
                updateUser.setBirthday(new java.sql.Date(System.currentTimeMillis()));
                updateUser.setHobby("game,pc");
                updateUser.setSalary(Double.valueOf(123456));
                updateUser.setMemo("memo");
                result = session.update("com.dotuian.conf.sqlmap.UserMapper.updateUser", updateUser);
                System.out.println("Update User Result : " + result);
                
                
                // ===============================================================
                // 删除数据库中的记录
                result = session.delete("com.dotuian.conf.sqlmap.UserMapper.deleteUser", 10);
                System.out.println("Delete User Result : " + result);
                
                
                // ===============================================================
                // 取出数据库中全部的记录
                List<UserEntity> userList = session.selectList("com.dotuian.conf.sqlmap.UserMapper.selectAllUser");
                for(int i=0;i<userList.size();i++){
                    UserEntity entity = userList.get(i);
                    System.out.println(entity.toString());
                }
                
                
                
                // session.commit提交事务，如果没有这句话，对数据库的添加修改删除操作不会生效
                session.commit();
            } catch (Exception e) {
                e.printStackTrace();
                
            } finally {
                // 确保SqlSession被关闭
                session.close();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

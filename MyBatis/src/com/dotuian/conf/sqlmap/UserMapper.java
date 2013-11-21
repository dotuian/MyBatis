package com.dotuian.conf.sqlmap;

import org.apache.ibatis.annotations.Select;

import com.dotuian.entity.UserEntity;

public interface UserMapper {
    
    // 通过接口的定义方式，此时的 @select 不写的情况下，需要再XML文件中配置，
    // 如果写了 @select 注解的话，就不要在XML文件中配置了，如果配置了会报错
    @Select("select * from USER where id = #{id}")
    public UserEntity selectUser2(int id);
    
}

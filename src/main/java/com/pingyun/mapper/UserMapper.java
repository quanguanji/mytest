package com.pingyun.mapper;

import com.pingyun.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User login(@Param("username") String username, @Param("password") String password);
    @Insert("insert into tb_user(username, password) values(#{username}, #{password})")
    void register(User user);
    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(String username);
}

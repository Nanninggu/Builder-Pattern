package com.example.BuilderPattern.mapper;

import com.example.BuilderPattern.dto.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT name, email FROM builder WHERE name = #{name}")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "email", column = "email")
    })
    User.UserBuilder findByName(String name);

    @Insert("INSERT INTO builder(name, email) VALUES(#{name}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "name")
    int insertUser(User user);

}
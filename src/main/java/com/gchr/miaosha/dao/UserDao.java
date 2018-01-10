package com.gchr.miaosha.dao;

import com.gchr.miaosha.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author gongchunru
 * @email gongchunru@gmail.com
 * Date：2018/1/10 20:17
 */
@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    public User getById(@Param("id")int id	);

    @Insert("insert into user(id, name)values(#{id}, #{name})")
    public int insert(User user);

}

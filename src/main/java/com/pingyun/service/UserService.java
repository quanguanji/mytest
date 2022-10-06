package com.pingyun.service;

import com.pingyun.mapper.UserMapper;
import com.pingyun.pojo.User;
import com.pingyun.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public User login(String username, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        return mapper.login(username, password);
    }
    public boolean register(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.selectByUsername(user.getUsername());
        if (user1 == null) {
            mapper.register(user);
            sqlSession.commit();
        }
        sqlSession.close();
        return user1 == null;
    }
}

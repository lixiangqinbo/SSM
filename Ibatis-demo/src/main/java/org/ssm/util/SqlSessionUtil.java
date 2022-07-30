package org.ssm.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("ibatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder =
                    new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory =  sqlSessionFactoryBuilder.build(inputStream);
             sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
package com.mybaits;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import com.mybaits.mapper.Person;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;


public class Main {

    public static void main(String[] args) {
        String resource = "mybatis.xml";

        File i_file = new File(resource);
        if (!i_file.exists()){
            System.out.println("file is not exist");
            return;
        }else {
            System.out.println("find files ");
        }


        SqlSession sqlSession = null;

        try {
            InputStream reader = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(reader);
            sqlSession = sqlSessionFactory.openSession();
            Person user = sqlSession.selectOne("userTest.selectUser", 1);
            System.out.println(user.getUsername());
        } catch (Exception ex){
            System.out.println(ex);
            if (sqlSession != null){
                sqlSession.close();
            }
        }



    }
}

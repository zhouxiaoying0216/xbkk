package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * DBUtils 类 - 主要用于获取 SqlSession 对象
 *
 * @author difeng
 */
public class DBUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            /**
             * 1. 读取 mybatis-config.xml 文件信息
             */
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            /**
             * 2. 加载已经读取到的 db-config.xml 文件，并获取到 SqlSessionFactory 对象
             */
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {

        /**
         * 3. 调用 SqlSessionFactory 类的 openSession() 方法，得到 SqlSession 对象（用于在测试代码中执行数据库操作）
         * autoCommit:true 设置自动提交
         */
        SqlSession session = sqlSessionFactory.openSession(true);

        return session;
    }

    public static void closeSqlSession(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}

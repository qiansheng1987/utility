package com.qiansheng.testmybatis.mapper;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class MybatisDemo {

	public static void main(String[] args) {
		DataSource dataSource = getDataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(BlogMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Blog blog = sqlSession.selectOne("selectBlog", 1);
		/*BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
		System.out.println(JSON.toJSONString(mapper.selectBlog(1)));*/
		System.out.println(JSON.toJSON(blog));
	}

	private static DataSource getDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/testmybatis?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8");
		dataSource.setPassword("root");
		dataSource.setUsername("root");
		return dataSource;
	}
}

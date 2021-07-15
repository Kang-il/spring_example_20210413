package com.example.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

//20210715 DB Annotation 옮김
//Repository 단계에 있는 클래스를 찾는 어노테이션
@MapperScan(basePackages = "com.example")

//Controller 보다 먼저 수행이 됨
@Configuration 
public class DatabaseConfig {

	
//	import org.springframework.core.io.Resource;
//	import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
	 @Bean // Spring 이 알아서 처리해주는
	 public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		 //SQL관련내용 연결해주는 객체
	     SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean(); 
	     sessionFactory.setDataSource(dataSource);

	     Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
	     //classpath:mappers/*Mapper.xml 
	     //mappers폴더 하위에/(user)Mapper.xml -- > 등등 모두 읽어온다
	     
	     
	     sessionFactory.setMapperLocations(res);

	     return sessionFactory.getObject();
	 }
	
	
}

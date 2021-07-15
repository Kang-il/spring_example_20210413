package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//DatabasConfig.class 에 DB연동로직 옮기면서 필요없어진 import문
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.core.io.Resource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) //DB설정을 안보겠다 (임시)


////20210714 DB Annotation //Repository 단계에 있는 클래스를 찾는 어노테이션
//@MapperScan(basePackages = "com.example")

//com 하위의 모든 패키지를 조회하여 Controller찾을 것 
@ComponentScan(basePackages = "com.*")

//Spring 기본 흐름의 시작
@SpringBootApplication
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
		
	}
	
	
////	import org.springframework.core.io.Resource;
////	import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//	 @Bean // Spring 이 알아서 처리해주는
//	 public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//		 //SQL관련내용 연결해주는 객체
//	     SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean(); 
//	     sessionFactory.setDataSource(dataSource);
//
//	     Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
//	     //classpath:mappers/*Mapper.xml 
//	     //mappers폴더 하위에/(user)Mapper.xml -- > 등등 모두 읽어온다
//	     
//	     
//	     sessionFactory.setMapperLocations(res);
//
//	     return sessionFactory.getObject();
//	 }
}

package com.example.springdemo;
import com.example.springdemo.entity.Course;
import com.example.springdemo.entity.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Bean
	public User user() {
		User user = new User();
		user.setPassWord("root");
		user.setCourse(course());
		return user;
	}

	@Bean
	public Course course() {
		Course course = new Course();
		return course;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		User bean = context.getBean(User.class);
		System.out.println(bean.getPassWord());
	}
}

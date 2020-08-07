package com.example.springdemo.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;

/**
 * <p>client</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/79:58
 */
public class App {

	public static void main(String[] args) {

		RailWayStation railWayStation = new RailWayStation();
		// 创建ProxyFactoryBean 用来创建指定对象的Proxy
		ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
		proxyFactoryBean.setTarget(railWayStation);
		proxyFactoryBean.setInterfaces(TicketService.class);
		// 使用jdk动态代理生成proxy对象
		proxyFactoryBean.setProxyTargetClass(true);
		TicketService ticketService = (TicketService)proxyFactoryBean.getObject();

		// 添加通知到代理对象中
		Advice beforeAdvice = new TicketServiceBeforeAdvice();
		Advice afterAdvice = new TicketServiceAfterAdvice();
		proxyFactoryBean.addAdvice(afterAdvice);
		proxyFactoryBean.addAdvice(beforeAdvice);

		//设置一个advisor,通过其内部的pointcut对advice进行过滤
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution( * sellTicket(..))");
		FilterAdvisor filterAdvisor = new FilterAdvisor(pointcut, afterAdvice);
		proxyFactoryBean.addAdvisor(filterAdvisor);

		ticketService.sellTicket();
		System.out.println("/---------------------------------------------------------/");
		ticketService.inquire();
	}
}

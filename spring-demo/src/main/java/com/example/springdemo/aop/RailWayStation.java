package com.example.springdemo.aop;

/**
 * <p>火车站服务</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/79:53
 */
public class RailWayStation implements TicketService {

	@Override
	public void sellTicket() {
		System.out.println("===============售票===================");
	}

	@Override
	public void inquire() {
		System.out.println("===============查询===================");
	}

	@Override
	public void withdraw() {
		System.out.println("===============退票===================");
	}
}

package com.example.springdemo.aop;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/79:51
 */
public interface TicketService {

	/**
	 * 售票
	 */
	void sellTicket();

	/**
	 * 查询
	 */
	void inquire();

	/**
	 * 退票
	 */
	void withdraw();
}

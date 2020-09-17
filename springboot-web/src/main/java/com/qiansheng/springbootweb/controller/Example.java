package com.qiansheng.springbootweb.controller;

import com.qiansheng.springbootweb.TrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 如何解决高并发，
 * 多线程
 * 数据库层面，读写分离，提供读取的速度，分库分表，做到非核心业务部性影响核心业务，加缓存
 * 服务层面，做负载均衡，服务容错，降级，可以水平扩种，提供并发能力，
 *
 * 分布式会遇到什么问题？
 * cap 可用性，一致性，分区容错性。
 *
 * 缓存
 * 出现数据一致问题
 * 先删缓存在，更新数据库
 *删除成功，更新失败，不影响
 * 删除失败，不操作数据库
 *
 * 更新缓存成功，更新数据库失败。
 *
 * 数据库主库和从库不一致，常见有这么几种优化方案：
 * （1）业务可以接受，系统不优化
 * （2）强制读主，高可用主库，用缓存提高读性能
 * （3）在cache里记录哪些记录发生过写请求，来路由读主还是读从
 *
 * 先缓存还是先数据库？
 * 读：先读缓存，miss，则读数据库，再维护缓存
 * 写：先删除缓存，在更新数据库
 * 	   删除缓存成功，更新数据库失败，对业务没有影响
 * 	   删除缓存失败，更新数据库成功，回滚
 */
@Controller
public class Example {

	@Autowired
	private TrService trService;

	@RequestMapping(value ="/home", method = RequestMethod.GET)
	@ResponseBody
	public String home(){
		return trService.getTxData();
	}
}

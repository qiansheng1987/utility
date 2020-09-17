package com.qs.patterns.pipeline;

/**
 * <p>管道</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/17 17:10
 */
public interface Pipeline<T> {

	/**
	 * 当前处理的流程
	 * @param piplineContext
	 * @param t
	 */
	void process(PiplineContext piplineContext, T t);

	/**
	 * 将流程转发给下一个流程
	 * @param piplineContext
	 * @param t
	 */
	void forward(PiplineContext piplineContext, T t);
}

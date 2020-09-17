package com.qs.patterns.pipeline;

/**
 * <p>DemoPipeline</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/17 17:25
 */
public class DemoPipeline extends OrdinaryPipeline<String> {

	public DemoPipeline(String name) {
		super(name);
	}

	@Override
	public void process(PiplineContext piplineContext, String s) {
		System.out.println("执行结果：" + s);
	}
}

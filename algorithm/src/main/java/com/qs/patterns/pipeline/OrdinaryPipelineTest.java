package com.qs.patterns.pipeline;

import java.util.Arrays;

/**
 * <p>OrdinaryPipeline test</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/17 17:24
 */
public class OrdinaryPipelineTest {
	public static void main(String[] args) {
		Pipeline<String> instance = OrdinaryPipeline.getInstance(Arrays.asList(new DemoPipeline("pipeline1"),
				new DemoPipeline("pipeline2"),
				new DemoPipeline("pipeline3")));
		System.out.println(instance.toString());
	}
}

package com.qs.patterns.pipeline;

import java.util.List;

/**
 * <p>普通流程</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/17 17:12
 */
public abstract class OrdinaryPipeline<T> implements Pipeline<T> {

	private final String name;
	private Pipeline<? super T> next;

	public OrdinaryPipeline(String name) {
		this.name = name;
	}

	public void setNext(Pipeline<? super T> next) {
		this.next = next;
	}

	@Override
	public void process(PiplineContext piplineContext, T t) {

	}

	@Override
	public void forward(PiplineContext piplineContext, T t) {

		if (null != next) {
			next.process(piplineContext, t);
		}
	}

	@Override
	public String toString() {
		if (next != null) {
			return name + "->" + next.toString();
		}
		return name;
	}

	public static <T> Pipeline<T> getInstance(List<? extends OrdinaryPipeline<? extends T>> pipelines) {
		if (null == pipelines || pipelines.size() == 0) {
			throw new IllegalArgumentException("empty pipelines!");
		}
		@SuppressWarnings("unchecked")
		OrdinaryPipeline<T>[] ordinaryPipelines = (OrdinaryPipeline<T>[])pipelines.toArray(new OrdinaryPipeline[0]);
		OrdinaryPipeline<T> p = ordinaryPipelines[0];
		for (int i = 1; i < ordinaryPipelines.length; i++) {
			p.setNext(ordinaryPipelines[i]);
			p = ordinaryPipelines[i];
		}
		p.setNext(null);
		return ordinaryPipelines[0];
	}
}

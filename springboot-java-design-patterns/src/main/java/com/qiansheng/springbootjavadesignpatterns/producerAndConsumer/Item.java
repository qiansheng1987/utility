package com.qiansheng.springbootjavadesignpatterns.producerAndConsumer;

/**
 * <p>item</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/1110:49
 */
public class Item {

	private String producer;

	private int id;

	public Item(String producer, int id) {
		this.producer = producer;
		this.id = id;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

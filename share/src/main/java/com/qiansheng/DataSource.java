package com.qiansheng;

public class DataSource {

	private final String userName;

	private final String passWord;

	private final String url;

	private DataSource(Builder builder) {
		this.userName = builder.userName;
		this.passWord = builder.passWord;
		this.url = builder.url;
	}

	public void printDataSource() {
		System.out.println("url:" + this.url);
		System.out.println("userName:" + this.userName);
		System.out.println("passWord:" + this.passWord);
	}

	public static class Builder {

		private String userName;

		private String passWord;

		private String url;

		public Builder ofUsername(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder ofPassword(String passWord) {
			this.passWord = passWord;
			return this;
		}

		public Builder ofUrl(String url) {
			this.url = url;
			return this;
		}

		public DataSource build() {
			return new DataSource(this);
		}
	}
}


package com.qiansheng.sharespringbootstarter.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author qiansheng
 */
@ConfigurationProperties(prefix = "qiansheng.share")
public class DataSourceProperties {

	private String userName;

	private String passWord;

	private String url;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}

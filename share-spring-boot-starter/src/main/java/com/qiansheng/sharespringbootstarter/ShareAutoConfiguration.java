package com.qiansheng.sharespringbootstarter;

import com.qiansheng.DataSource;
import com.qiansheng.sharespringbootstarter.configure.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiansheng
 */
@Configuration
@EnableConfigurationProperties(DataSourceProperties.class)
public class ShareAutoConfiguration {

	@Bean
	public DataSource getShareDemo(DataSourceProperties dataSourceProperties) {
		DataSource.Builder builder = new DataSource.Builder();
		return builder.ofPassword(dataSourceProperties.getPassWord())
				.ofUrl(dataSourceProperties.getUrl())
				.ofUsername(dataSourceProperties.getUserName()).build();
	}
}

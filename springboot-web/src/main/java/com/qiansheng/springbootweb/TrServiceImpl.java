package com.qiansheng.springbootweb;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/14 15:23
 */

@Service
public class TrServiceImpl implements TrService {


	@Override
	@Transactional(rollbackFor = Exception.class)
	public String getTxData() {
		return "ucarcms";
	}
}

package com.qs.patterns.Mediator;

/**
 * 描述:具体同事类A
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/8 10:24
 */
public class ColleagueA  extends AbstractColleague {

	@Override
	public void setNumber(int number, AbstractMediator am) {
		this.number = number;
		am.AaffectB();
	}
}

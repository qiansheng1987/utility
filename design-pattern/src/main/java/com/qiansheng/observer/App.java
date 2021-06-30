package com.qiansheng.observer;

/**
 * observer app
 *
 * @author qiansheng@yunji.ai
 * @date 2021/6/30 下午7:04
 */
public class App {

    public static void main(String[] args) {
        Behavior behavior = new Behavior();
        FatherAttention fatherAttention = new FatherAttention();
        MotherAttention motherAttention = new MotherAttention();
        behavior.addAttention(motherAttention);
        behavior.addAttention(fatherAttention);
        behavior.notifyFamily("happy");
        behavior.notifyFamily("sad");
    }

}

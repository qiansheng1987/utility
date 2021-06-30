package com.qiansheng.observer;

/**
 * TODO
 *
 * @author qiansheng@yunji.ai
 * @date 2021/6/30 下午7:11
 */
public class MotherAttention implements AttentionChild{

    public void behavior(String behavior) {
        System.out.println("mother attention....." + behavior);
    }
}

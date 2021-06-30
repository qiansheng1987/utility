package com.qiansheng.observer;

/**
 * TODO
 *
 * @author qiansheng@yunji.ai
 * @date 2021/6/30 下午7:13
 */
public class FatherAttention implements AttentionChild {

    public void behavior(String behavior) {
        System.out.println("father attention....." + behavior);
    }
}

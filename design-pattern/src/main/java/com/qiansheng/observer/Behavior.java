package com.qiansheng.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author qiansheng@yunji.ai
 * @date 2021/6/30 下午7:14
 */
public class Behavior {

    private List<AttentionChild> attentionChildren;

    public Behavior() {
        this.attentionChildren = new ArrayList<AttentionChild>();
    }

    public Behavior(List<AttentionChild> attentionChildren) {
        this.attentionChildren = attentionChildren;
    }

    public void addAttention(AttentionChild attentionChild) {
        attentionChildren.add(attentionChild);
    }

    public void removeAttention(AttentionChild attentionChild) {
        attentionChildren.remove(attentionChild);
    }

    public void notifyFamily(String behavior) {
        for (AttentionChild attentionChild : attentionChildren) {
            attentionChild.behavior(behavior);
        }
    }
}

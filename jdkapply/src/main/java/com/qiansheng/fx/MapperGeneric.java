package com.qiansheng.fx;


/**
 * <p>范型</p>
 *
 * @author zilong.qian@tuya.com
 * @version 1.0
 * @date 2021/1/24 12:57 上午
 */
public class MapperGeneric<T> {

    public static <T> MapperGeneric<T> getMapper() {
        return new MapperGeneric<>();
    }
    private T t;

    /**
     * 泛型的好处就是在编译的时候能够检查类型安全
     */
    public void noSpecifyType() {
        MapperGeneric generic = MapperGeneric.getMapper();
        generic.setT("qiansheng");
        String t = (String)generic.getT();
        System.out.println(t);
    }

    public void specifyType() {
        MapperGeneric<String> generic = MapperGeneric.getMapper();
        generic.setT("specify qs");
        String re = generic.getT();
        System.out.println(re);
    }

    public static <T> void main(String[] args) {
        MapperGeneric<Object> mapper = MapperGeneric.getMapper();
        mapper.noSpecifyType();
        mapper.specifyType();
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

package memoryleak;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * <p>mock memory leak</p>
 *
 * 可参见：https://blog.csdn.net/weter_drop/article/details/89387564
 *
 * @author 1987qiansheng@gmail.com
 * @date 2021/4/11 9:40
 */
public class App {

    static Map wMap = new WeakHashMap();
    static Map map = new HashMap();

    public static void main(String[] args) {
        init();
        testWeakHashMap();
        testHashMap();
        ThreadLocal threadLocal = new ThreadLocal() {
            @Override
            protected Object initialValue() {
                return super.initialValue();
            }
        };
        threadLocal.remove();
    }

    private static void testHashMap() {
        System.out.println("HashMap GC之前");
        for (Object o : map.entrySet()) {
            System.out.println(o);
        }
        try {
            System.gc();
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("HashMap GC之后");
        for (Object o : map.entrySet()) {
            System.out.println(o);
        }
    }

    private static void testWeakHashMap() {
        System.out.println("WeakHashMap GC 之前");
        for (Object s : wMap.entrySet()) {
            System.out.println(s);
        }
        try {
            System.gc();
            TimeUnit.SECONDS.sleep(20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("WeakHashMao GC之后");
        for (Object o : wMap.entrySet()) {
            System.out.println(o);
        }
    }

    private static void init() {
        String ref1= new String("obejct1");
        String ref2 = new String("obejct2");
        String ref3 = new String ("obejct3");
        String ref4 = new String ("obejct4");
        wMap.put(ref1, "chaheObject1");
        wMap.put(ref2, "chaheObject2");
        map.put(ref3, "chaheObject3");
        map.put(ref4, "chaheObject4");
        System.out.println("String引用ref1，ref2，ref3，ref4 消失");
    }
}

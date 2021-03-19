package cglib;

import net.sf.cglib.core.DebuggingClassWriter;

import java.lang.reflect.Field;
import java.util.Properties;

/**
 * <p>测试类</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2021/3/12 23:31
 */
public class App {


    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.dir"));
        saveGeneratedCGlibProxyFiles(System.getProperty("user.dir"));
        CglibMethodInterceptor cglibMethodInterceptor = new CglibMethodInterceptor();
        Programmer programmer = (Programmer) cglibMethodInterceptor.methodInterceptor(Programmer.class);
        System.out.println(programmer.work());

    }

    /**
     * 设置保存Cglib代理生成的类文件。
     *
     * @throws Exception
     */
    public static void saveGeneratedCGlibProxyFiles(String dir) throws Exception {
        Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        //dir为保存文件路径
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, dir);
        props.put("net.sf.cglib.core.DebuggingClassWriter.traceEnabled", "true");
    }





























}

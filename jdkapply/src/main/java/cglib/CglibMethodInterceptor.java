package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>代理拦截</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2021/3/12 23:17
 */
public class CglibMethodInterceptor implements MethodInterceptor {


    public Object methodInterceptor(Class target) {
        // 创建加强器，用来创建动态代理类
        Enhancer enhancer = new Enhancer();
        // 为代理类指定需要代理的类
        enhancer.setSuperclass(target);
        // 设置方法拦截器回调引用，对于代理类上所有方法的调用，
        // 都会调用CallBack，而Callback则需要实现intercept() 方法进行拦截
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before....");
        Object result = methodProxy.invokeSuper(obj, args);
        System.out.println("after.....");
        return result;
    }
}

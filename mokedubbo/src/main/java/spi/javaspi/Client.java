package spi.javaspi;

import java.util.ServiceLoader;

/**
 * <p></p>
 *
 * public static <S> Iterator<S> loadAll(Class<S> clazz) {
 *     ServiceLoader<S> loader = ServiceLoader.load(clazz);
 *     return loader.iterator();
 *   }
 * }
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/8/19 9:47
 */
public class Client {

	public static void main(String[] args) {
		ServiceLoader<MessageService> loader = ServiceLoader.load(MessageService.class);
		loader.forEach(t -> t.sendMsg("java spi"));
	}

	public static <T> T loadAll(Class<T> clazz) {
		ServiceLoader<T> loader = ServiceLoader.load(clazz);
		return loader.iterator().next();
	}
}

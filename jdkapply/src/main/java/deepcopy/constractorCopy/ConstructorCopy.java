package deepcopy.constractorCopy;

/**
 * <p>利用构造函数实现deepcopy</p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/24 14:59
 */
public class ConstructorCopy {

	public static void main(String[] args) {
		Address address = new Address("天津", "中国");
		User user = new User("钱胜", address);

		// 调用构造函数时进行深拷贝
		User user1 = new User(user.getName(), new Address(address.getCity(), address.getCountry()));

		System.out.println("源对象:" + user.hashCode());
		System.out.println("复制对象:" + user1.hashCode());
	}

}

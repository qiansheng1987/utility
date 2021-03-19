package deepcopy.cloneCopy;

/**
 * <p></p>
 *
 * @author 1987qiansheng@gmail.com
 * @date 2020/9/24 14:57
 */
public class Address implements Cloneable {

	private String city;
	private String country;

	public Address() {
	}

	@Override
	protected Address clone() throws CloneNotSupportedException {
		return (Address)super.clone();
	}

	public Address(String city, String country) {
		this.city = city;
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}

package springprograms;

//Bean class
//Constructor Injection
public class Address  //NO SETTER METHOD
{
	String city;//index 0
	String country;//index 1

	public Address(String city, String country)
	{
		super();
		this.city = city;
		this.country = country;
	}

}

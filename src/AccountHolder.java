public class AccountHolder	{
	private int SSN;
	private String name;
	private String phone;
	private String address;
	public AccountHolder(int ssn, String name, String phone, String address)	{
		this.SSN = SSN;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	public int getSSN()	{
		return SSN;
	}
	public void setSSN(int SSN)	{
		this.SSN = SSN;
	}
	public String getName()	{
		return name;
	}
	public void setName(String name)	{
		this.name = name;
	}
	public String getPhone()	{
		return phone;
	}
	public void setphone(String phone)	{
		this.phone = phone;
	}
	public String getAddress()	{
		return address;
	}
	public void setAddress(String address)	{
		this.address = address;
	}
}
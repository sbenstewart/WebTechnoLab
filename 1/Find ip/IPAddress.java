import java.net.*;
public class IPAddress
{
	public static void main(String[] args) throws Exception
	{
		InetAddress[] ip=InetAddress.getAllByName("google.com");
		for (InetAddress address : ip) 
                System.out.println(address);
	}
}
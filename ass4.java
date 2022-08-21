//q1
//____________________________
//q1 client
import java.net.*;
import java.io.*;

class Myclient
{
	public static void main(String args[])throws UnknownHostException,IOException
	{
		Socket s=new Socket("localhost",50710);
		System.out.println("InetAddres associated with the socket ="+s.getInetAddress());
		System.out.println("Port to which socket is connected ="+s.getPort());
		System.out.println("Local Port to which socket is connected ="+s.getLocalPort());
		System.out.println("Client closed");
		s.close();	
	}
}
//q1 server
import java.net.*;
import java.io.*;

class Myserver
{
	public static void main(String args[])throws UnknownHostException,IOException
	{	
		ServerSocket ss=new ServerSocket(50710);
		System.out.println("Server started , waiting for client connection.....");
		Socket s=ss.accept();
		System.out.println("Client connected");
		System.out.println("Server closed");
		s.close();

	}	
}
//q2
//________________________________________
//q2 client
import java.net.*;
import java.io.*;

class DateClient
{
	public static void main(String args[])throws UnknownHostException,IOException
	{
		Socket s=new Socket("localhost",50710);
		BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println("Server date and time is :"+in.readLine());
		System.out.println("Client closed");
		s.close();	
	}
}
//q2 server 
import java.net.*;
import java.io.*;
import java.util.*;

class DateServer
{
	public static void main(String args[])throws UnknownHostException,IOException
	{	
		ServerSocket ss=new ServerSocket(50710);
		System.out.println("Server started , waiting for client connection.....");
		Socket s=ss.accept();
		System.out.println("Client connected");
		
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		dos.writeUTF("Server date: "+(new Date()).toString()+"");
		
		System.out.println("Server closed");
		dos.close();		
		s.close();

	}	
}

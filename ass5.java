//q1 client
import java.net.*;
import java.io.*;

class MsgClient
{
	public static void main(String args[])throws UnknownHostException,IOException
	{
		Socket s=new Socket("localhost",50710);
		System.out.println("Client connected...");
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps=new PrintStream(s.getOutputStream());
		String str;
		System.out.println("Enter the message:");
		while(!(str=br1.readLine()).equalsIgnoreCase("END"))
		{
			ps.println(str);
			System.out.println("Enter any string:");
		}
		System.out.println("Client closed");
		ps.close();		
		s.close();	
	}
}

//q1 server

import java.net.*;
import java.io.*;
import java.util.*; 

class MsgServer
{
	public static void main(String args[])throws UnknownHostException,IOException
	{	
		ServerSocket ss=new ServerSocket(50710);
		System.out.println("Server started , waiting for client connection.....");
		Socket s=ss.accept();
		System.out.println("Client connected");
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		//PrintStream ps=new PrintStream(s.getOutputStream());
		String str;
		while((str=br.readLine())!=null)
		{
			System.out.println(str);
		}	
		System.out.println("Server closed");
				
		s.close();
		//ps.close();

	}	
}
//____________________
//q2 client
import java.io.*;
import java.net.*;
public class FileClient
{
    public static void main(String args[])
    {
        try
{
            Socket server=new Socket("localhost",50710);
            System.out.println("Client Connected");
            BufferedReader br=new BufferedReader(new InputStreamReader(server.getInputStream()));
            BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
            PrintStream ps=new PrintStream(server.getOutputStream());
            System.out.print("Enter File Name:");
            String fname=br1.readLine();
            ps.println(fname);
            String s;
            s=br.readLine();
            while (s!=null)
            {
                System.out.println(s);
                s=br.readLine();
            }
            br1.close();
            br.close();
            ps.close();
            server.close();
        }
        catch(IOException ie){}
    }
}
//q2 server
import java.io.*;
import java.net.*;
public class FileServer
{
    public static void main(String args[])
    {
        try
        {
            ServerSocket ss=new ServerSocket(50710);
            System.out.println("Server waiting for client");
            Socket client=ss.accept();
            System.out.println("Client Connected");
            BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintStream ps=new PrintStream(client.getOutputStream());
            String fname=br.readLine();
            File ferr=new File(fname);
            if(ferr.exists())
            {
            FileReader fr=new FileReader(fname);
            BufferedReader br1=new BufferedReader(fr);
            String s,rs="";
         
            while ((s=br1.readLine())!=null)
            {   
                ps.println(s);
                System.out.println(s);
            }
            fr.close();
            br1.close();
            }
            else
                ps.println("File Not Found, Enter correct path...");
             
            br.close();
            ps.close();
            client.close();
        }
        catch(IOException ie){}
    }
}
//q3 file txt
hellow I am PRabhav kharat
//_____________________________
//q3 client
import java.net.*;
import java.io.*;

class palClient
{
	public static void main(String args[])throws UnknownHostException,IOException
	{
		Socket s=new Socket("localhost",50710);
		System.out.println("Client connected...");
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		PrintStream ps=new PrintStream(s.getOutputStream());
		String str;
		System.out.println("Enter the string:");
		str=br1.readLine();
		
		ps.println(str);
		System.out.println(br.readLine());
		//System.out.println("Enter any string:");
		
		System.out.println("Client closed");
		ps.close();		
		s.close();	
	}
}
//q3 server
import java.net.*;
import java.io.*;
import java.util.*; 

class palServer
{
	public static boolean palindrom_check(String str)
	{	
		String reverse="";
		for(int i=str.length()-1;i>=0;i--)
		{
			reverse=reverse+str.charAt(i);
		}
		if(reverse.equals(str))
			return true;
		return false;
		
	} 
	public static void main(String args[])throws UnknownHostException,IOException
	{	
		ServerSocket ss=new ServerSocket(50710);
		System.out.println("Server started , waiting for client connection.....");
		Socket s=ss.accept();
		System.out.println("Client connected");
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintStream ps=new PrintStream(s.getOutputStream());
		String str=br.readLine();
		
		
		Boolean ans=palindrom_check(str);
		if(ans)
		{
			ps.println("The given string "+str+" is palindrome");
		}
		else
		{
			ps.println("The given string "+str+" is not palindrome");
			
		}
		
		System.out.println("Server closed");
				
		s.close();
		

	}	
}

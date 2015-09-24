package chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

public class ThreadedServer
{
    public static void main( String[] args) throws Exception
    {
    	HashMap<String, Socket> users = new HashMap<String, Socket>( );
    	ServerSocket server = new ServerSocket(8080);
    	System.out.println( "THE CHAT SERVER HAS STARTED! =)" );
    	while(true)
    	{
    		Socket client = server.accept();
    		ThreadedServer ser = new ThreadedServer();
    		ClientFromThread cft =ser.new ClientFromThread(client);
    		String name = cft.getUserName();
    		users.put( name, client );
    		cft.giveUsersMap( users );
    		//cft.giveOnlineUsers( ); //DOES NOT WORK YET!!!!
    		System.out.println("Threaded server connected to " 
    					+ client.getInetAddress() + "  USER: " + name );			
    	} 
    	
    }

    //***************************************************************************************************

    class ClientFromThread extends Thread
    {
    	private Socket client;
    	private Scanner fromClient;
    	private PrintWriter toClient;
    	private String userName;
    	HashMap<String, Socket> users;

    	public ClientFromThread( Socket c ) throws Exception
    	{
    		client = c;
    		fromClient = new Scanner( client.getInputStream() );
    		toClient = new PrintWriter( client.getOutputStream(), true );
    		userName = getUser();
    		start();
    	}
    	public void giveUsersMap( HashMap<String, Socket> users )
    	{
    		this.users = users;
    	}

    	//THIS DOESNT WORK YET... IT PRINTS THE FIRST LINE BUT NOT THE LIST
    	public void giveOnlineUsers()
    	{
    		toClient.println("These users are currently online:");
    		Set<String> userList = users.keySet();
    		String[] userNames = null;
    		userList.toArray( userNames );

    		for( int i = 0; i< userNames.length; i++ )
    		{
    			toClient.println(userNames[i]);
    		}
    	}

    	public String getUserName()
    	{
    		return userName;
    	}

    	private String getUser()
    	{
    		String s = "";
    		while( (s.length() < 1) || (s == null) )
    		{
    			toClient.println("What is your first name? ");
    			s=fromClient.nextLine().trim();
    		}
    		toClient.println("Thank You! Welcome to the chat room " + s + ".");
    		return s.toUpperCase();
    	}

    	public void run() 
    	{
    		String s = null;
    		String toUser;
    		String mesg;

    		while(fromClient.hasNext())
    		{
    			s = fromClient.nextLine().trim();
    			if( s.equalsIgnoreCase( "END" )) break;

    			for( int i=0; i<s.length(); i++)
    			{
    				if( s.charAt(i) == '-' )
    				{
    					toUser = s.substring( 0, i ).trim().toUpperCase();
    					mesg = s.substring( i+1 ).trim();
    					Socket client = users.get( toUser );
    					try
    					{
    						ClientToThread ctt = new ClientToThread(client);
    						ctt.sendMesg( mesg, toUser );
    						ctt.start();
    					}
    					catch(Exception e){e.printStackTrace();}
    					break;
    				}
    				if( (i+1) == s.length() )
    				{
    					toClient.println("Sorry the text was invalid. Please enter a user name " +
    							                     "followed by a dash (-) then your message.");
    				}
    			}
    		}
    		try
    		{
    			fromClient.close();
    			toClient.close();
    			client.close();
    		}
    		catch(Exception e){e.printStackTrace();}
    	}

    } //end class ClientFromThread

    //***************************************************************************************************

    class ClientToThread extends Thread
    {
    	private Socket client;
    	private PrintWriter toClient;
    	private String mesg;

    	public ClientToThread( Socket c ) throws Exception
    	{
    		client = c;
    		toClient = new PrintWriter( client.getOutputStream(), true );
    	}

    	public void sendMesg( String mesg, String userName )
    	{
    		this.mesg = userName + ": " + mesg;
    	}
    	public void run() 
    	{
    		toClient.println(mesg);

    		try
    		{
    			//toClient.close();
    			//client.close();
    		}
    		catch(Exception e){e.printStackTrace();}
    	}

    } //end class ClientToThread

    //***************************************************************************************************

} //end class ThreadedServer
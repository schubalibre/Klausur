package chat;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class ReverseClient 
{
public static void main( String[] args ) throws Exception
{
    String line = null;
    Socket server= new Socket("127.0.0.1", 8080);
    System.out.println( "Connected to host: " + server.getInetAddress() );
    BufferedReader fromServer = new BufferedReader(
    			new InputStreamReader(server.getInputStream()) );
    PrintWriter toServer = new PrintWriter( server.getOutputStream(), true );
    BufferedReader input = new BufferedReader( 
    			new InputStreamReader(System.in) );
    while( (line=input.readLine()) !=null )
    {
    	toServer.println(line);
    	System.out.println( fromServer.readLine() );
    }
    fromServer.close();
    toServer.close();
    input.close();
    server.close();

}   
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.*;
import java.io.*;

/**
 *
 * @author iltarix Amrit Bhotoia
 */
public class EchoServer {
	public static void main(String[] args) throws IOException {
            //In the main class, create a EchoServer object, and use the start() method to run the suerver.
		new EchoServer().start();
	}
        
        //the start() method is created.
	public void start() throws IOException {
                        //create a socket object using the ServerSocket class
			ServerSocket socket = new ServerSocket(1234);
                        System.out.println("Server ready");
                        
                        //create a loop 
			while (true) {
                            
                            //create a socket object, which will the client
				Socket client = socket.accept();
                                //and create a new serverThread calss object, that will take the client(socket) as it's perameter, and start the client.
                                //ServerThread object is defined in a seperate class of it's own.
				new ServerThread(client).start();
			}
        }
}
			
			
		
 

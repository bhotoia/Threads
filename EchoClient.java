//Os Assignment 3 Q2

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
public class EchoClient
{
    //declear main class
	public static void main(String[] args) thros IOException
	{
                        //declear the socket for Client.
			Socket socket = new Socket("127.0.0.1", 1234);
                        
                        //Use buffereReader class for retreving and reading user input.
			BufferedReader reader1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        
                        //Initialize a PrintWriter class for outputstream.
			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                        
                        //second bufferedreader for reading line
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
                        
                        //create a string to store lines.
			String line;
                        line = reader2.readLine();
                        writer.println(line);
                        
                        //below is the loop
			do
			{
                            //read the first line and store it to line variable.
				line = reader1.readLine();
                               
                                //then output the line
                                System.out.println(line);
                                //use the second reader to read the line
				line = reader2.readLine();
                                //writer class for output
				writer.println(line);
			}
                        
                        // if the user inputted ".(dot)", exit the loop.
			while ( !line.trim().equals(".") );
                        {

			}
		}

	}
	

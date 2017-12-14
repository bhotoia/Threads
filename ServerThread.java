
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iltarix Amrit Bhotoia
 */

//The serverThread class will extend pre-defined Thread methods.
public class ServerThread extends Thread {
    
    //this class will have a socket attribute
	Socket socket;
        
        //Running the thread.
	public void run() {
            try {
                //create a bufferedReader object, that is used to read line
                BufferedReader reader = null;
                //create a string that will store the user input
                String userInput;
                //use the reader and set its perameter using InputStreamReader
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //PrintWriter object for outputting results
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                
                //run this loop as long as user didn't type "." to stop the server
                do
                {
                    //use the reader object to read the user input and store it into the userInput string.
                    userInput = reader.readLine();
                    //a validation check, make sure the user actually inputted something.
                    if ( userInput != null )
                        //Server output
                        output.println("Server: "+ userInput);
                }
                //while condition
                while (!userInput.equals("."));
                //finally, close the socket.
                socket.close();
                //auto created exceptions handling.
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
           
		
	}
        
        
        ServerThread(Socket socket){
	this.socket = socket;
	}
	
}

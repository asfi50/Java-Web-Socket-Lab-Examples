package intermediate.lab3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        String host = "0.0.0.0";
        int port = 1711;
        
//        create a socket connection with localhost:1711
        Socket socket = new Socket(host, port);
        System.out.println("Yo! Connected with the server");
        
//        during communication data comes and goes in Stream, so we need streams
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            
//        we need some helpers to convert our string or other objects to stream or vice-versa
        BufferedReader input = new BufferedReader(inputStreamReader);
        PrintWriter output = new PrintWriter(outputStreamWriter, true); // auto flush = true, essential for sending data without delay

//        main logic section. Use input and output just like normal programming
        Scanner sc = new Scanner(System.in);
          while (true) {            
              int arr[] = {5 , 1 , 8 , 15 , 20, -1};
              String arrString = "";
              for (int i=0; i<arr.length;i++){
                  arrString+=String.valueOf(arr[i]) + " ";
              }
              output.println(arrString);
              
              String result = input.readLine();
              System.out.println("max : "+result);
              
              System.out.println("---------------------------------------------------------------");
        }
        
    }
}

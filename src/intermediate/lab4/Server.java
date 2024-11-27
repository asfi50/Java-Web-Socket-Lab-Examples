package intermediate.lab4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {        
    public static void main(String[] args) throws Exception {
        int port = 1711;
        
//        start a socket server on port 1711
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Bingo! Server is running on port: "+String.valueOf(port));
                
//        accept a socket connection from the client if they send request
        Socket socket = serverSocket.accept();
        System.out.println("Knock Knock! New Client is here.");

//        during communication data comes and goes in Stream, so we need streams
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());

//        we need some helpers to convert our string or other objects to stream or vice-versa
        BufferedReader input = new BufferedReader(inputStreamReader);
        PrintWriter output = new PrintWriter(outputStreamWriter, true); // auto flush = true, essential for sending data without delay

//         main logic section. Use input and output just like normal programming
        while (true) {            
            try {
                String msg = input.readLine();
//                 server info
                String serverIp = socket.getLocalAddress().getHostAddress();
                String serverHostname = socket.getLocalAddress().getHostName();
                int serverPort = socket.getLocalPort();
                
                output.println("Server info: \n"
                + "IP: "+ serverIp + "\n"
                + "Host: "+ serverHostname + "\n"
                + "Port: "+ serverPort +"\n\n"
                );
                
//                 client info
                String clientIp = socket.getInetAddress().getHostAddress();
                String clientHostname = socket.getInetAddress().getHostName();
                int clientPort = socket.getPort();
                
                output.println("Client info: \n"
                + "IP: "+ clientIp + "\n"
                + "Host: "+ clientHostname + "\n"
                + "Port: "+ clientPort +"\n\n"
                );
                
            } catch (Exception e) {
                e.printStackTrace();
                output.println(e.getMessage());
            }
        }
        }   
}

package network;
/*Important in Exam(Theory)
Steps for tcp client program
* 1. Open a socket
* 2. Define input and output stream to the socket
* 3. Read from socket or write to socket
* 4. Close streams and socket
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTCP {
    public static void main(String[] args) throws IOException {
        //Socket
        Socket cs = new Socket("localhost", 1254);
        //Input Stream
        Scanner ins = new Scanner(cs.getInputStream());
        //Output Stream
        PrintWriter outs = new PrintWriter(cs.getOutputStream(), true);

        Scanner clientInput = new Scanner(System.in);
        String clientMsg, serverMsg;
        while (true) {
            //reading from socket input stream
            serverMsg = ins.nextLine();
            System.out.println("Message from server: " + serverMsg);

            System.out.print("Reply to server: ");
            clientMsg = clientInput.nextLine();
            if (clientMsg.equals("bye")) {
                System.out.println("Connection ended by client");
                break;
            }
            outs.println(clientMsg);

        }
        ins.close();
        outs.close();
        cs.close();

    }
}
package network;
/* Steps for TCP server program
 * 1. Open a server socket
 * 2. Accept the connection from the client
 * 3. Get input and output stream to the socket
 * 4. Read from socket or write to socket using respective stream
 * 5. Close streams and socket
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ServerTCP {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1254);
        System.out.println("Before accept");
        Socket cs = ss.accept();
        System.out.println("After Accept");

        Scanner ins = new Scanner(cs.getInputStream());
        PrintWriter outs = new PrintWriter(cs.getOutputStream(), true);
        Scanner serverInput = new Scanner(System.in);
        String clientMsg, serverMsg;

        while (true) {
            System.out.print("Reply to client:");
            serverMsg = serverInput.nextLine();

            if (serverMsg.equals("bye")) {
                System.out.println("Connection closed by server");
                break;
            }
            outs.println(serverMsg);
            try {
                clientMsg = ins.nextLine();
            } catch (NoSuchElementException e) {
                clientMsg = "Connection ended by client";
            }
            System.out.println("Message from client: " + clientMsg);

        }
        ins.close();
        outs.close();
        cs.close();
        ss.close();
    }
}
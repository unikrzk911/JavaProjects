package network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
 * Steps for a UDP server program
 * 1. Get a datagram socket
 * 2. Receive request
 * 3. Send response
 * 4. Close socket
 * */
public class ServerUDP {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(1234);

        while (true) {
            byte[] sendBuffer = new byte[1024];
            byte[] receiveBuffer = new byte[1024];

            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(receivePacket);
            String clientData = new String(receivePacket.getData());
            System.out.println("Client: " + clientData);

            Scanner sc = new Scanner(System.in);
            System.out.print("Server: ");
            String serverData = sc.nextLine();
            sendBuffer = serverData.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receivePacket.getAddress(), receivePacket.getPort());
            serverSocket.send(sendPacket);
            if (serverData.equals("bye")) {
                System.out.println("Connection ended by server");
                break;
            }
        }
        serverSocket.close();
    }
}

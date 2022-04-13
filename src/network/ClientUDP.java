package network;

/*
 * Steps to create a client UDP program
 * 1. Get a datagram socket
 * 2. Send request
 * 3. Get response
 * 4. Display response
 * 5. Close socket
 * */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientUDP {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();

        while (true) {
            byte[] sendBuffer = new byte[1024];
            byte[] receiveBuffer = new byte[1024];

            Scanner sc = new Scanner(System.in);
            System.out.print("Client: ");
            String clientData = sc.nextLine();
            sendBuffer = clientData.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName("localhost"), 1234);
            clientSocket.send(sendPacket);

            if (clientData.equals("bye")) {
                System.out.println("Connection ended by client");
                break;
            }
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);
            String serverData = new String(receivePacket.getData());
            System.out.println("Server: " + serverData);
        }
        clientSocket.close();
    }
}

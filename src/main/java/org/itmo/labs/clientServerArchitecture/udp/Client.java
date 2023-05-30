package org.itmo.labs.clientServerArchitecture.udp;

import java.io.IOException;
import java.net.*;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    private DatagramSocket socket;
    private InetAddress address;

    private byte[] buf;
    private byte[] bufReceive = new byte[1024];

    public Client() throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
    }

    public String sendCommand(String msg) throws IOException {
        buf = msg.getBytes();
        DatagramPacket packet
                = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(packet);
        packet = new DatagramPacket(bufReceive, bufReceive.length);
        socket.receive(packet);
        String received = new String(
                packet.getData(), 0, packet.getLength());
        return received;
    }

    public void close() {
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String request = scanner.nextLine();
            if(Objects.equals(request, "quit")) break;
            System.out.println(client.sendCommand(request));
        }
        client.close();
    }
}

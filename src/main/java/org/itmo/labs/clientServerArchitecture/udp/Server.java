package org.itmo.labs.clientServerArchitecture.udp;

import org.itmo.labs.Utils;
import org.itmo.labs.commandsArchitecture.Invoker;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.List;

public class Server {
    private DatagramSocket socket;
    private final static Invoker invoker = new Invoker(Utils.getTestCollection());
    private boolean running;

    public Server() throws SocketException {
        socket = new DatagramSocket(4445);
    }

    public void run() {
        running = true;
        new Thread(() -> {
            while (running) {
                byte[] buf = new byte[1024];
                byte[] bufToAnswer = new byte[1024];
                try {
                    DatagramPacket packet
                            = new DatagramPacket(buf, buf.length);
                    socket.receive(packet);


                    InetAddress address = packet.getAddress();
                    int port = packet.getPort();
                    packet = new DatagramPacket(buf, buf.length, address, port);

                    String received = new String(packet.getData(), 0, getReceivedLength(packet.getData()));
                    if (received.equals("quit")) {
                        running = false;
                        continue;
                    }
                    bufToAnswer = commandProcessing(received).getBytes();
                    packet = new DatagramPacket(bufToAnswer, bufToAnswer.length, address, port);
                    socket.send(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            socket.close();
        }).start();

    }

    private int getReceivedLength(byte[] bytes) {
        int count = 0;
        for(byte b : bytes) {
            if (b != 0) count++;
            else break;
        }
        return count;
    }

    private static String commandProcessing(String request) {
        String command = "";
        String param = null;
        List<String> commandPair =  List.of(request.split(" +"));
        command = commandPair.get(0);
        if (commandPair.size() > 1) {
            param = commandPair.get(1);
        }
        System.out.printf("\n%s:\n", command);
        if (param != null) {
            return invoker.invoke(command, param);
        } else {
            return invoker.invoke(command, null);
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.run();
    }
}

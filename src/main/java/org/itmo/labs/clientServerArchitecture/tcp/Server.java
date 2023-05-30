package org.itmo.labs.clientServerArchitecture.tcp;

import org.itmo.labs.Utils;
import org.itmo.labs.commandsArchitecture.Invoker;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    private static final Invoker invoker = new Invoker(Utils.getTestCollection());

    public static void main(String[] args) {
        int port = 3335;
        try (ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName("localhost"))) {
            while (true) {
                Socket socket = server.accept();
                new Thread(() -> {
                    try (
                            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    ) {
                        while (true) {
                            String request = reader.readLine();
                            if (request.equals("quit")) {
                                reader.close();
                                writer.close();
                                socket.close();
                                return;
                            }
                            writer.write(commandProcessing(request));
                            writer.newLine();
                            writer.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String commandProcessing(String request) {
        String command = "";
        String param = null;
        System.out.println(request);
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
}
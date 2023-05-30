package org.itmo.labs.clientServerArchitecture.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 3335;
        Scanner scanner = new Scanner(System.in);
        try (Socket client_socket = new Socket(host, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client_socket.getOutputStream()));
        ) {
            System.out.println("connected to server");
            while (true) {
                int reloop = 0;
                String s = "";
                do {
                    try {
                        s = scanner.nextLine();
                        if (s.equals("") || s.equals("quit")) {
                            writer.write("quit");
                            writer.newLine();
                            writer.flush();
                            client_socket.close();
                            System.exit(0);
                        }
                        reloop++;
                    } catch (Exception e) {
                        System.out.println("Incorrect input, please try again!");
                    }
                }
                while (reloop == 0);
                writer.write(s);
                writer.newLine();
                writer.flush();
                StringBuilder sb = new StringBuilder();
                String answer = "";
                while (!Objects.equals(answer = reader.readLine(), "")) {
                    sb.append(answer).append("\n");
                }
                System.out.println(sb);
            }
        } catch (Exception e) {
            System.out.println("oops... something went wrong, please wait");
            e.printStackTrace();
        }

    }
}

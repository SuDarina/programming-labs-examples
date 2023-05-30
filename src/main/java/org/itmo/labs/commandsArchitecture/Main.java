package org.itmo.labs.commandsArchitecture;

import org.itmo.labs.Utils;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Invoker invoker = new Invoker(Utils.getTestCollection());
        for(Map.Entry<String, String> entry : Utils.getTestCommandsSet().entrySet()) {
            System.out.printf("\n%s:\n", entry.getKey());
            if (entry.getValue() != null) {
                invoker.invoke(entry.getKey(), entry.getValue());
            } else {
                invoker.invoke(entry.getKey(), null);
            }
        }
    }
}

package org.itmo.labs.commandsArchitecture.commands;

import lombok.NoArgsConstructor;
import org.itmo.labs.commandsArchitecture.SimpleCommand;
import org.itmo.labs.model.MusicBand;

import java.util.Map;
import java.util.TreeMap;

@NoArgsConstructor
public class ShowCommand extends SimpleCommand {

    public String execute(TreeMap<Long, MusicBand> musicBands) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Long, MusicBand> entry : musicBands.entrySet()) {
            sb.append(entry).append("\n");
            System.out.println(entry);
        }
        return sb.toString();
    }

    @Override
    public String getName() {
        return "show";
    }
}

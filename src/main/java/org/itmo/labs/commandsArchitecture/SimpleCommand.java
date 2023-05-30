package org.itmo.labs.commandsArchitecture;

import lombok.AllArgsConstructor;
import org.itmo.labs.model.MusicBand;

import java.util.TreeMap;

@AllArgsConstructor
public abstract class SimpleCommand implements Command {

    @Override
    public abstract String execute(TreeMap<Long, MusicBand> musicBands);

    @Override
    public CommandType getType() {
        return CommandType.SIMPLE_COMMAND;
    }

    @Override
    public abstract String getName();
}

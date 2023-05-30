package org.itmo.labs.commandsArchitecture;

import org.itmo.labs.model.MusicBand;

import java.util.TreeMap;

public interface Command {
    String execute(TreeMap<Long, MusicBand> musicBands);
    CommandType getType();
    String getName();
}

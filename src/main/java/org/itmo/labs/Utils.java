package org.itmo.labs;

import org.itmo.labs.model.Album;
import org.itmo.labs.model.Coordinates;
import org.itmo.labs.model.MusicBand;
import org.itmo.labs.model.MusicGenre;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Utils {
    public static TreeMap<Long, MusicBand> getTestCollection() {
        return new TreeMap<>(Map.of(1L, new MusicBand(1L, "band1", new Coordinates(1, 1),
                2L, 2L, "description", MusicGenre.SOUL, new Album("album 1", 3)),
                2L, new MusicBand(2L, "band2", new Coordinates(1, 2),
                                2L, 2L, "description", MusicGenre.BLUES, new Album("album 2", 3)),
                        3L, new MusicBand(3L, "band3", new Coordinates(1, 3),
                        2L, 2L, "description", MusicGenre.BRIT_POP, new Album("album 3", 3))));
    }

    public static Map<String, String> getTestCommandsSet() {
        Map<String, String> commands = new HashMap<>();
        commands.put("show", null);
        commands.put("remove_by_id", "1");
        return commands;
    }
}

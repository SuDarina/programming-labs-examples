package org.itmo.labs.jdbc;

import org.itmo.labs.Utils;
import org.itmo.labs.model.MusicBand;

import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws SQLException {
        MusicBandsCRUD crud = new MusicBandsCRUD();

        TreeMap<Long, MusicBand> musicBands = Utils.getTestCollection();
        for (Map.Entry<Long, MusicBand> entry : musicBands.entrySet()) {
            crud.addMusicBand(entry.getValue());
        }

        Map<Long, MusicBand> loadedMusicBands = crud.readCollection();
        System.out.println(loadedMusicBands);

        crud.deleteAllCollection();
    }
}

package org.itmo.labs.fileFormats.json;

import org.itmo.labs.Utils;
import org.itmo.labs.model.MusicBand;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String filePath = "test_json.json";
        JsonCollectionUtils.storeCollection(Utils.getTestCollection(), filePath);
        TreeMap<Long, MusicBand> musicBands = JsonCollectionUtils.readCollection(filePath);
        System.out.println(musicBands);
    }
}

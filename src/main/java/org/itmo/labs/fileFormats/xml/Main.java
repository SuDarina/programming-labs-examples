package org.itmo.labs.fileFormats.xml;

import org.itmo.labs.Utils;
import org.itmo.labs.model.MusicBand;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String filePath = "test_xml.xml";
        XmlCollectionUtils.storeCollection(Utils.getTestCollection(), filePath);
        TreeMap<Long, MusicBand> musicBands = XmlCollectionUtils.readCollection(filePath);
        System.out.println(musicBands);
    }
}

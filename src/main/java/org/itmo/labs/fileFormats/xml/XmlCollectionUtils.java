package org.itmo.labs.fileFormats.xml;

import org.itmo.labs.model.MusicBand;


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.TreeMap;

public class XmlCollectionUtils {
    public static void storeCollection(TreeMap<Long, MusicBand> musicBands, String filePath) {
        try(XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream(filePath)))) {
            encoder.writeObject(musicBands);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static TreeMap<Long, MusicBand> readCollection(String filePath) {
        try(XMLDecoder d = new XMLDecoder(
                new BufferedInputStream(
                        new FileInputStream(filePath)))) {
            return (TreeMap<Long, MusicBand>) d.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package org.itmo.labs.fileFormats.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.itmo.labs.model.MusicBand;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeMap;

public class JsonCollectionUtils {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();;


    public static void storeCollection(TreeMap<Long, MusicBand> musicBands, String filePath)  {
        String jsonContent = gson.toJson(musicBands);
        File file =  new File(filePath);
        try (PrintWriter out = new PrintWriter(file, StandardCharsets.UTF_8)){
            out.print(jsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeMap<Long, MusicBand> readCollection(String filePath) {
        String jsonContent;
          try {
              List<String> lines = Files.readAllLines(Paths.get(filePath), Charset.defaultCharset());
              jsonContent = String.join(System.lineSeparator(), lines);
              return (TreeMap<Long, MusicBand>) gson.fromJson(jsonContent, TreeMap.class);

          } catch (IOException e) {
              e.printStackTrace();
              return null;
          }
    }
}
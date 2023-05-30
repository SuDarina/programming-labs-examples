package org.itmo.labs.jdbc;

import org.itmo.labs.model.Album;
import org.itmo.labs.model.Coordinates;
import org.itmo.labs.model.MusicBand;
import org.itmo.labs.model.MusicGenre;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class MusicBandsCRUD {
    private Connection connection;

    public MusicBandsCRUD() {
        connection = DbConnection.connect();
    }

    public Map<Long, MusicBand> readCollection() {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM musicband")) {

            ResultSet resultSet = statement.executeQuery();
            Map<Long, MusicBand> musicBands = new TreeMap<>();

            while (resultSet.next()) {
                MusicBand musicBand = new MusicBand();

                long id = resultSet.getLong(1);
                String name = resultSet.getString("name");
                long x = resultSet.getLong("x");
                float y = resultSet.getFloat("y");
                long numberOfParticipants = resultSet.getLong("number_of_participants");
                long albumsCount = resultSet.getLong("albums_count");
                String description = resultSet.getString("description");
                String genre = resultSet.getString("genre");
                String bestAlbumName = resultSet.getString("best_album_name");
                int bestAlbumLength = resultSet.getInt("best_album_length");

                musicBand.setId(id);
                musicBand.setName(name);
                musicBand.setCoordinates(new Coordinates(x, y));
                musicBand.setNumberOfParticipants(numberOfParticipants);
                musicBand.setAlbumsCount(albumsCount);
                musicBand.setDescription(description);
                musicBand.setGenre(MusicGenre.valueOf(genre));
                musicBand.setBestAlbum(new Album(bestAlbumName, bestAlbumLength));

                musicBands.put(musicBand.getId(), musicBand);
            }

            return musicBands;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addMusicBand(MusicBand musicBand) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO musicBand (id, name, x, y, number_of_participants, albums_count, description, genre, best_album_name, best_album_length) VALUES (DEFAULT, (?), (?), (?), (?), (?), (?), (?), (?), (?) )")) {
            statement.setString(1, musicBand.getName());
            statement.setLong(2, musicBand.getCoordinates().getX());
            statement.setDouble(3, musicBand.getCoordinates().getY());
            statement.setLong(4, musicBand.getNumberOfParticipants());
            statement.setLong(5, musicBand.getAlbumsCount());
            statement.setString(6, musicBand.getDescription());
            statement.setString(7, musicBand.getGenre().name());
            statement.setString(8, musicBand.getBestAlbum().getName());
            statement.setLong(9, musicBand.getBestAlbum().getLength());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMusicBand(Long id) {

        try (Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM musicband WHERE id = " + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllCollection() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("DELETE FROM musicband WHERE id > " + 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

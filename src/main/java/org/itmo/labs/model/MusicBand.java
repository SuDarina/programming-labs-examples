package org.itmo.labs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Setter
@Getter
public class MusicBand {
    private Long id;
    private String name;
    private Coordinates coordinates;
    private Long numberOfParticipants;
    private Long albumsCount;
    private String description;
    private MusicGenre genre;
    private Album bestAlbum;

    public MusicBand(Long id, String name, Coordinates coordinates, Long numberOfParticipants, Long albumsCount, String description, MusicGenre genre, Album bestAlbum) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.numberOfParticipants = numberOfParticipants;
        this.albumsCount = albumsCount;
        this.description = description;
        this.genre = genre;
        this.bestAlbum = bestAlbum;
    }
}

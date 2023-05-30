package org.itmo.labs.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Album {
    private String name;
    private Integer length;

    public Album(String name, Integer length) {
        this.name = name;
        this.length = length;
    }
}

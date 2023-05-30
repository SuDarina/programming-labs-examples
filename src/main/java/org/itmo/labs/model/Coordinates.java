package org.itmo.labs.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinates {
    private long x;
    private double y;

    public Coordinates(long x, double y) {
        this.x = x;
        this.y = y;
    }
}


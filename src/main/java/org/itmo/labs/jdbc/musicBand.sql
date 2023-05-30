CREATE TABLE IF NOT EXISTS musicBand(
    id SERIAL PRIMARY KEY,
    name VARCHAR(30) UNIQUE NOT NULL,
    x INTEGER NOT NULL,
    y FLOAT NOT NULL,
    number_of_participants INTEGER NOT NULL,
    albums_count INTEGER NOT NULL,
    description VARCHAR(100),
    genre VARCHAR(30) NOT NULL,
    best_album_name VARCHAR(100) NOT NULL,
    best_album_length INTEGER NOT NULL
);

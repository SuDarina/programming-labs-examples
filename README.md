# Шпаргалка для лабораторных работ по программированию (5-7)

В данном репозитории рассмотрены некоторые сценарии, призванные помочь в написании лабораторных работ 5-7 по программированию. 
Здесь приведены примеры: 

- чтения и записи в файлы форматов xml и json.
- организации команд по паттерну проектирования "Команда".
- подключение к базе данных PostgreSQL и работа с ней из Java (создание таблиц, загрузка коллекции из таблицы). 
- создание простых многопоточных клиент-серверных приложений с обменом данных по протоколам TCP и UDP

Для всех примеров была использована коллекция `TreeMap`, содержащая объекты класса `MusicBand`

```
public class MusicBand {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int numberOfParticipants; //Значение поля должно быть больше 0
    private Long albumsCount; //Поле может быть null, Значение поля должно быть больше 0
    private String description; //Поле не может быть null
    private MusicGenre genre; //Поле не может быть null
    private Album bestAlbum; //Поле может быть null
}
public class Coordinates {
    private Long x; //Максимальное значение поля: 552, Поле не может быть null
    private float y;
}
public class Album {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long length; //Значение поля должно быть больше 0
}
public enum MusicGenre {
    PROGRESSIVE_ROCK,
    HIP_HOP,
    PSYCHEDELIC_CLOUD_RAP,
    SOUL,
    POST_PUNK;
}

```
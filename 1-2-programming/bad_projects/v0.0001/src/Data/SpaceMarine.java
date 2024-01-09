package Data;

import Managers.CollectionManager;

import java.util.Objects;

public class SpaceMarine {
    private static Long nextId = 1;
    private final Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double health; //Поле может быть null, Значение поля должно быть больше 0
    private String achievements; //Поле не может быть null
    private Weapon weaponType; //Поле может быть null
    private MeleeWeapon meleeWeapon; //Поле может быть null
    private Chapter chapter; //Поле не может быть null

    public SpaceMarine(Long id, String name, Coordinates coordinates, java.time.ZonedDateTime creationDate,
                       Double health, String achievements, Weapon weaponType, MeleeWeapon meleeWeapon, Chapter chapter) {
        this.id = nextId;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.health = health;
        this.achievements = achievements;
        this.weaponType = weaponType;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public static void updateNextId(CollectionManager collectionManager) {
        var maxId = collectionManager.getCollection().getId()
        nextId = maxId + 1;
    }

    public Long getId(){
        return id;
    }

    public void update(SpaceMarine spaceMarine){
        this.name = spaceMarine.name;
        this.coordinates = spaceMarine.coordinates;
        this.creationDate = spaceMarine.creationDate;
        this.health = spaceMarine.health;
        this.achievements = spaceMarine.achievements;
        this.weaponType = spaceMarine.weaponType;
        this.meleeWeapon = spaceMarine.meleeWeapon;
        this.chapter = spaceMarine.chapter;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public java.time.ZonedDateTime getCreationDate(){
        return creationDate;
    }

    public Double getHealth() {
        return health;
    }

    public String getAchievements() {
        return achievements;
    }

    public Weapon getWeaponType(){
        return weaponType;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public Chapter getChapter() {
        return chapter;
    }
}
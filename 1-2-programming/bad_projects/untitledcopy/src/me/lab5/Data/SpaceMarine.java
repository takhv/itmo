package me.lab5.Data;

import me.lab5.Exception.MustBeNotEmptyException;
import me.lab5.Exception.RangeException;

import java.util.Comparator;
import java.util.Date;

public class SpaceMarine implements Comparable<SpaceMarine> {
    private final Double minimalHealthPoint = 0.0;
    private final Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private final Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double health; //Поле может быть null, Значение поля должно быть больше 0
    private String achievements; //Поле не может быть null
    private Weapon weaponType; //Поле может быть null
    private MeleeWeapon meleeWeapon; //Поле может быть null
    private final Chapter chapter; //Поле не может быть null

    public SpaceMarine(Long id) {
        this.id = id;
        this.creationDate = Date.from(new Date().toInstant());
        this.coordinates = new Coordinates();
        this.chapter = new Chapter();
    }

    public long getId() {return id;}

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Double getHealth() {
        return health;
    }

    public String getAchievements() {
        return achievements;
    }

    public Weapon getWeaponType() {
        return weaponType;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public Chapter getChapter() {
        return chapter;
    }


    @Override
    public String toString() {
        return "SpaceMarine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", health=" + health +
                ", creationDate=" + creationDate +
                ", health=" + health +
                ", achievements='" + achievements + '\'' +
                ", weaponType=" + weaponType +
                ", meleeWeapon=" + meleeWeapon +
                ", chapter=" + chapter +
                '}';
    }

    public void setName(String name) throws MustBeNotEmptyException {
        if (name.equals("")) throw new MustBeNotEmptyException();
        this.name = name;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public void setHealth(double health) throws RangeException, IllegalArgumentException {
        if (health <= this.minimalHealthPoint) throw new RangeException();
        if (health == Double.POSITIVE_INFINITY) throw new IllegalArgumentException();
        this.health = health;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    public void setWeapon(String weapon) throws IllegalArgumentException{
        if (weapon.equals("")) {
            this.weaponType = null;
        } else {
            this.weaponType = Weapon.valueOf(weapon);
        }
    }

    public void setMeleeWeapon(String meleeWeapon) throws IllegalArgumentException{
        if (meleeWeapon.equals("")) this.weaponType = null;
        else {
            this.meleeWeapon = MeleeWeapon.valueOf(meleeWeapon);
        }
    }
    @Override
    public int compareTo(SpaceMarine other) {
        return id.compareTo(other.getId());
    }
}


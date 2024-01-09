package me.lab5.Data;

public enum Weapon {
    BOLT_RIFLE,
    COMBI_FLAMER,
    GRAV_GUN,
    MISSILE_LAUNCHER;
    public static String allWeapon(){
        StringBuilder allWeapons = new StringBuilder();
        for (Weapon i: Weapon.values()) {
            allWeapons.append(i).append(" ");
        }
        return allWeapons.toString();
    }
}

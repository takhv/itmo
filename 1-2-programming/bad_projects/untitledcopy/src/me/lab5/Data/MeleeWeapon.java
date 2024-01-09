package me.lab5.Data;

public enum MeleeWeapon {
    CHAIN_AXE,
    MANREAPER,
    LIGHTING_CLAW,
    POWER_BLADE;
    public static String allMeleeWeapon(){
        StringBuilder allMeleeWeapons = new StringBuilder();
        for (MeleeWeapon i: MeleeWeapon.values()) {
            allMeleeWeapons.append(i).append(" ");
        }
        return allMeleeWeapons.toString();
    }
}

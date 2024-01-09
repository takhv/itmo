package me.lab5.Utility;

import java.util.Scanner;

import me.lab5.Data.*;
import me.lab5.Exception.*;

public class SpaceMarinesAsker {
    private Double minimalHealthPoint = 0.0;
    private Scanner scanner;

    private SpaceMarine spaceMarine;
    private Mode mode;

    public SpaceMarinesAsker(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setMode(Mode mode){
        this.mode = mode;
    }

    public void setSpaceMarine(SpaceMarine spaceMarine) {
        this.spaceMarine = spaceMarine;
    }

    public SpaceMarine addSpaceMarine(long id) throws IncorrectScript {
        this.spaceMarine = new SpaceMarine(id);
        nameAsk();
        coordinatesAsk();
        healthAsk();
        achievementsAsk();
        weaponAsk();
        meleeWeaponAsk();
        chapter();
        return spaceMarine;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void nameAsk() {
        while (true) {
            try {
                System.out.println("Введите название космодесантника");
                spaceMarine.setName(scanner.nextLine().trim());
                break;
            } catch (MustBeNotEmptyException e) {
                System.out.println("Название не должно быть пустым");
            }
        }
    }

    public void coordinatesAsk() throws IncorrectScript {
        XAsk(spaceMarine.getCoordinates());
        YAsk(spaceMarine.getCoordinates());
    }

    public void XAsk(Coordinates coordinates) {
        while (true) {
            try {
                System.out.println("Введите X координату");
                coordinates.setX(Integer.parseInt(scanner.nextLine().trim()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("некорректно введено число, число должно содержать только цифры и должно быть меньше или равно " + Integer.MAX_VALUE);
            }
        }
    }

    public void YAsk(Coordinates coordinates) throws IncorrectScript {
        while (true) {
            try {
                System.out.println("Введите Y координату");
                coordinates.setY(Double.parseDouble(scanner.nextLine().trim()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("некорректно введено число, число должно содержать только цифры или '.'");
            } catch (IllegalArgumentException e) {
                System.out.println("Слишком большое число");
            }
        }
    }

    public void healthAsk() throws IncorrectScript {
        boolean flag;
        while (true) {
            try {
                System.out.println("Вы хотите добавить здоровье? Введите 'yes', если да, 'no' или нажмите 'enter', если нет");
                String line = scanner.nextLine().trim();
                if (line.equals("") | line.equals("no")) {
                    flag = false;
                    break;
                }
                if (line.equals("yes")) {
                    flag = true;
                    break;
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод");
            }
        }
        if (flag) {
            while (true) {
                try {
                    System.out.println("Введите минимальное здоровье (он должен быть больше " + minimalHealthPoint + ")");
                    spaceMarine.setHealth(Double.parseDouble(scanner.nextLine().trim()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("некорректно введено число, число должно содержать только цифры или '.'");
                } catch (RangeException e) {
                    System.out.println("минимальный балл должен быть больше 0");
                } catch (IllegalArgumentException e) {
                    System.out.println("Слишком большое число");
                }
            }
        }
    }
    public void achievementsAsk() {
        System.out.println("Введите достижения");
        spaceMarine.setAchievements(scanner.nextLine().trim());
    }
    public void weaponAsk() throws IncorrectScript {
        while (true) {
            try {
                System.out.println("Выберите оружие - " + Weapon.allWeapon());
                String aboba = scanner.nextLine().trim().toUpperCase();
                spaceMarine.setWeapon(aboba);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("нет такого оружия, повторите ввод");
            }
        }
    }
    public void meleeWeaponAsk() throws IncorrectScript {
        while (true) {
            try {
                System.out.println("Выберите оружие ближнего боя- " + MeleeWeapon.allMeleeWeapon());
                spaceMarine.setMeleeWeapon(scanner.nextLine().trim().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("нет такого оружия, повторите ввод");
            }
        }
    }
    public void chapter(){
        chapterNameAsk(spaceMarine.getChapter());
        chapterMarinesCountAsk(spaceMarine.getChapter());
    }

    private void chapterMarinesCountAsk(Chapter chapter) {
        while (true) {
            try {
                System.out.println("Введите количество солдат");
                chapter.setMarinesCounts(Long.parseLong(scanner.nextLine().trim()));
                break;
            } catch (NumberFormatException e) {
                System.out.println("некорректно введено число, число должно содержать только цифры и должно быть меньше или равно " + Long.MAX_VALUE);

            } catch (RangeException e) {
                System.out.println("выход за границы, число должно быть от 0 до 1000");
            }
        }
    }

    private void chapterNameAsk(Chapter chapter) {
        while (true) {
            try {
                System.out.println("Введите название подразделения");
                chapter.setName(scanner.nextLine().trim());
                break;
            } catch (MustBeNotEmptyException e) {
                System.out.println("Название не должно быть пустым");
            }
        }
    }

    public boolean updateById(String ask) throws IncorrectScript {
        while (true) {
            try {
                String answer;
                System.out.println(ask);
                System.out.println("Если да, введите 'yes', если нет, то введите 'no' или нажмите 'enter'");
                answer = scanner.nextLine().trim().toLowerCase();
                if (answer.equals("yes")) return true;
                if (answer.equals("") | answer.equals("no")) return false;
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод, введите только 'yes', если хотите сделать изменения, или 'no', если не хотите");

            }
        }
    }
}



package me.lab5.Data;

import me.lab5.Exception.MustBeNotEmptyException;
import me.lab5.Exception.RangeException;

public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long marinesCount; //Поле не может быть null, Значение поля должно быть больше 0, Максимальное значение поля: 1000

    public void setName(String name) throws MustBeNotEmptyException {
        if (name.equals("")) throw new MustBeNotEmptyException();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "name='" + name + '\'' +
                ", marinesCount=" + marinesCount +
                '}';
    }

    public void setMarinesCounts(Long marinesCount) throws RangeException {
        if (marinesCount <=0) throw new RangeException();
        if (marinesCount >=1000) throw new RangeException();
        this.marinesCount = marinesCount;
    }
}

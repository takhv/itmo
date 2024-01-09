package Utility;

public class BasedConsole implements Console {
    @Override
    public void println(Object obj){
        System.out.println(obj);
    }
    @Override
    public void print(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    @Override
    public void printerr(Object obj) {
        System.out.println("Error: " + obj);
    }
}

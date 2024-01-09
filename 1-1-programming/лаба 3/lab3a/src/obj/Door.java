package obj;

public class Door {
    static boolean isOpen = false;
    public void openDoor(){
        System.out.println("---=== Дверь открыта ===---");
        isOpen = true;

    }
    public void closeDoor(){
        System.out.println("---=== Дверь закрыта ===---");
        isOpen = false;
    }
}


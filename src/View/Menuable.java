package View;

public interface Menuable {
    void showMenu();
    void exit();

    default void showItems(String[] items) {
        for (String item : items) {
            System.out.println("------");
            System.out.println(item.toUpperCase());
        }
    }
}

package Model;

public class Admin {
    private static final String ADMIN_NAME = "ADMIN";
    private static final long ADMIN_PASSWORD = 0000;

    public String getName() {
        return ADMIN_NAME;
    }

    public long getPassword() {
        return ADMIN_PASSWORD;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + ADMIN_NAME + '\'' +
                ", password=" + ADMIN_PASSWORD +
                '}';
    }
}

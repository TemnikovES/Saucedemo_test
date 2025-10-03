package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withLockUserPermission() {
        return new User(PropertyReader.getProperty("saucedemo.locked"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmptyUser() {
        return new User(PropertyReader.getProperty("saucedemo.empty_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmptyPassword() {
        return new User(PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.empty_password"));
    }
}
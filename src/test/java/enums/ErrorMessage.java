package enums;

public enum ErrorMessage {
    USER_LOCK_MSG("Epic sadface: Sorry, this user has been locked out."),
    EMPTY_USER_MSG("Epic sadface: Username is required"),
    EMPTY_PASSWORD_MSG("Epic sadface: Password is required");

    private final String displayName;

    ErrorMessage(String displayName) {
        this.displayName = displayName;
    }

    public  String getDisplayName() {
        return displayName;
    }
}

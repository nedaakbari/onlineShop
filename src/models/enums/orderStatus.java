package models.enums;

public enum orderStatus {
    CANCEL("cancel"), SEAL("accept"), UNKNOWN("unknown");
    private String name;

    orderStatus(String name) {
        this.name = name;
    }
}

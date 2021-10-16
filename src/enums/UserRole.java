package enums;

public enum UserRole {
    MANAGER, CUSTOMER,Unknown_Role;


    public static UserRole getValue(String name) {
        switch (name.trim().toLowerCase()) {
            case "customer":
                return CUSTOMER;

            case "manager":
                return MANAGER;
            default:
                return Unknown_Role;
        }
    }
}

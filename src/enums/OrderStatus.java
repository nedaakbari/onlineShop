package enums;

public enum OrderStatus {
    CANCELED("cancel"), ShIPPED("accept"),ONHOLD("OnHold") ,UNKNOWN("unknown");
    private String status;

    OrderStatus(String status) {
        this.status = status;
    }


    public static OrderStatus getValue(String string) {
        for (OrderStatus status : values()) {
            if (status.status.equalsIgnoreCase(string.trim())) {
                return status;
            }
        }
        return UNKNOWN;
    }


}

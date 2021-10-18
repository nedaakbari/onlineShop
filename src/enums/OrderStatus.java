package enums;

public enum OrderStatus {
    CANCELLED("CANCELLED"), ShIPPED(" ShIPPED"), ONHOLD("ONHOLD");
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
        return CANCELLED;
    }

    public static String value(OrderStatus orderStatus) {
        switch (orderStatus) {
            case CANCELLED:
                return "CANCELLED";
            case ShIPPED:
                return "ShIPPED";
            case ONHOLD:
                return "ONHOLD";
            default:
                return "CANCELLED";
        }
    }


}

package enums;

public enum ElectronicType {
    TV("tv"), RADIO("radio"), UnknownError("unknown");
    private String name;

    ElectronicType(String name) {
        this.name = name;
    }

    public static ElectronicType getValue(String name) {
        switch (name.trim().toLowerCase()) {
            case "tv":
                return TV;

            case "radio":
                return RADIO;
            default:
                return UnknownError;
        }
    }

    public enum ReadABLEType {
        BOOK("book"),MAGAZIN("magazin");
        private String name;

        ReadABLEType(String name) {
            this.name = name;
        }
    }
}

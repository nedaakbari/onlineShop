package enums;


public enum ProductLine {
    Electronic(1, "electronic"),
    READABLE(2, "Readable"),
    SHOE(3, "shoeType"),
    UNKNOWNTYPE(10,"UNKNOWNTYPE");


    public static ProductLine getValue(String name) {
        switch (name.trim().toUpperCase()) {
            case "ELECTRONIC":
                return Electronic;
            case "READABLE":
                return READABLE;
            case "shoe":
                return SHOE;
            default:
                return UNKNOWNTYPE;
        }
    }



    ProductLine(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;
    private String name;

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }


}

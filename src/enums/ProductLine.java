package enums;

public enum ProductLine {
    ElectronicTYPE(1, "electronic"),
    READABLETYPE(2, "Readable"),
    SHOETYPE(3, "shoeType");

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

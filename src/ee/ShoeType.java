package ee;

public enum ShoeType {
    sport("Sport"), FORMAL("Formal");
    private String name;

    ShoeType(String name) {
        this.name = name;
    }

}
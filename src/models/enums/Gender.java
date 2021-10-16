package models.enums;

public enum Gender {
    MALE(1, "Male"), FEMALE(2, "Female"), NOT_SET(3, "NOT_SET");

    private int id;
    private String name;

    Gender(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Gender getVal(String name) {
        for (Gender gender : values()) {
            if (gender.name.equalsIgnoreCase(name.trim())) {
                return gender;
            }
        }
        return NOT_SET;

        /*Gender gender;
        try {
            gender = valueOf(name.trim());
        } catch (IllegalArgumentException e) {
            gender = NOT_SET;
        }
        return gender;*/

        /*switch (name.trim().toLowerCase()) {
            case "male":
                return MALE;
            case "female":
                return FEMALE;
            default:
                return NOT_SET;
        }*/
    }
}

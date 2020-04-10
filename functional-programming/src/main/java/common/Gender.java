package common;

public enum Gender {
    MALE("male"),
    FEMALE("female"),
    PREFER_NOT_TO_SAY("prefer not to say");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGenderString() {
        return gender;
    }
}

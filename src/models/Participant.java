package models;

public class Participant {

    private static int idCounter = 1;

    private final int id;
    private final String name;
    private final String email;

    public Participant(String name, String email) {
        this.id = idCounter;

        idCounter++;

        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "id:" + this.id + " " + this.name + " " + this.email;
    }

}

package models;

import java.util.Objects;

public class Participant {

    private static int idCounter = 1;

    private final int id;
    private final String name;
    private final String email;

    // init
    public Participant(String name, String email) {
        this.id = idCounter++;
        this.name = name;
        this.email = email;
    }

    // Methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Participant that = (Participant) o;
        return id == that.id || Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "id:" + this.id + " " + this.name + " " + this.email;
    }

}

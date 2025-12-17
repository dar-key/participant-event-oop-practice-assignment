package models;

public class Participant {
    
    private static int idCounter = 1;
    
    private int id;
    private String name;
    private String email;
    

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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "id:" + this.id + " " + this.name + " " + this.email;
    }

    
}

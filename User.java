import java.util.ArrayList;

public class User {
    // data members
    private String id;
    private String type;
    private String name;
    private String email;

   private TravelPass pass;


    //parameterized constructor
    public User(String id, String type, String name, String email) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.email = email;

    }

    // Accessor and Mutator
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void displayInformation()
    {
        System.out.println("User Information ");
        System.out.println(String.format("%-15s %-5s","ID",id));
        System.out.println(String.format("%-15s %-5s","Name",name));
        System.out.println(String.format("%-15s %-5s","Type",type));
        System.out.println(String.format("%-15s %-5s","Email",email));

    }
}

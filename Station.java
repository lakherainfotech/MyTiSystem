public class Station {
    // data members
    private String name;
    private int zone;

    // parametrized constructor
    public Station(String name, int zone) {
        this.name = name;
        this.zone = zone;
    }

    // Accessor And Mutator
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }


}

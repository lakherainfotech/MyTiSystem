import java.util.ArrayList;

public class TravelPass {

    private ArrayList <Journey> journey;
    private double credit;



    private String length, zone;
    private double cost;

    private static final double TWO_HOUR_ZONE1 = 2.50;
    private static final double TWO_HOUR_ZONES12 = 3.50;
    private static final double ALL_DAY_ZONE1 = 4.90;
    private static final double ALL_DAY_ZONES12 = 6.80;

    /**
     * Constructor: creates new Travel Pass, depending on input parameters
     * @param length: String, either starting with "2" or starting with "All"
     * @param zone: int, either 1 (Zone 1) or 2 (Zones 1 and 2)
     */
    public TravelPass(String length, int zone) {
        if (length.startsWith("2") && zone == 1) {
            this.length = "2 Hour";
            this.zone = "Zone 1";
            cost = TWO_HOUR_ZONE1;
        } else if (length.startsWith("2") && zone == 2){
            this.length = "2 Hour";
            this.zone = "Zones 1 and 2";
            cost = TWO_HOUR_ZONES12;
        } else if (length.startsWith("All") && zone == 1) {
            this.length = "All Day";
            this.zone = "Zone 1";
            cost = ALL_DAY_ZONE1;
        } else if (length.startsWith("All") && zone == 2) {
            this.length = "All Day";
            this.zone = "Zones 1 and 2";
            cost = ALL_DAY_ZONES12;
        }
    }

    /**
     * get the type of pass, in terms of duration
     * @return String: "2 Hour" or "All Day"
     */
    public String getLength() {
        return length;
    }

    /**
     * get the zone/s covered by this pass
     * @return String: "Zone 1" or "Zones 1 and 2"
     */
    public String getZone() {
        return zone;
    }

    /**
     * get the cost of this pass
     * @return double, which is the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * convert this class into a meaningful String, for printing purposes
     * note the use of static "format" method from String class
     */
    public String toString() {
        return String.format(getLength() + " pass for " + getZone() + " for %.2f", getCost());
    }
}

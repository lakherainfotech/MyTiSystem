import java.time.LocalDate;
import java.time.LocalTime;

public class Journey {
    // data members
    private LocalDate dateOfTravel;
    private LocalTime startTime;
    private LocalTime endTime;
    private Station startStation;
    private Station endStation;
    private double cost;

    // default constructor
    public Journey() {
        cost = 0;
    }

    // parametrized constructor
    public Journey(LocalDate dateOfTravel, LocalTime startTime, LocalTime endTime, Station startStation, Station endStation) {
        this.dateOfTravel = dateOfTravel;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startStation = startStation;
        this.endStation = endStation;
        cost = 0;
    }

    //Getter and Setter
    public LocalDate getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(LocalDate dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }
}

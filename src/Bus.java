import java.util.ArrayList;
import java.util.List;

public class Bus {
    public static List<Bus> busList = new ArrayList<>(List.of(new Bus("PakBusiness", 40, "4000", "Larkana", "Karachi"),
            new Bus("BabarCoach", 30, "2000", "Sukkur", "Lahore")
            , new Bus("AlMadina", 50, "3000", "Karachi", "Islamabad")));
    private String busNumber;
    private Integer seatCapacity;
    private String pricePerSeat;
    private String destinationCity;
    private String departureCity;


    public Bus() {

    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }


    public Bus(String busNumber, Integer seatCapacity, String pricePerSeat, String departureCity, String destinationCity) {
        this.busNumber = busNumber;
        this.seatCapacity = seatCapacity;
        this.pricePerSeat = pricePerSeat;
        this.destinationCity = destinationCity;
        this.departureCity = departureCity;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public Integer getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Integer seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public String getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(String pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busNumber='" + busNumber + '\'' +
                ", seatCapacity=" + seatCapacity +
                ", pricePerSeat='" + pricePerSeat + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", departureCity='" + departureCity + '\'' +
                '}';
    }
}


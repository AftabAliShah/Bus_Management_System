public class Booking {
    private String bookingID;
    private Passengers passengers;
    private Bus bus;

    public Booking() {
    }

    public Booking(String bookingID, Passengers passengers, Bus bus) {
        this.bookingID = bookingID;
        this.passengers = passengers;
        this.bus = bus;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Passengers getPassengers() {
        return passengers;
    }

    public void setPassengers(Passengers passengers) {
        this.passengers = passengers;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID='" + bookingID + '\'' +
                ", passengers=" + passengers +
                ", bus=" + bus +
                '}';
    }
}

import java.awt.print.Book;
import java.util.*;

public class Main {
    static List<Bus> buses = Bus.busList;
    static List<Passengers> passengers = Passengers.passengersList;
    static List<Booking> bookingList = new ArrayList<>();
    static Map<String, Integer> seatBooking = new HashMap<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String option1 = "";

        do {
            Main main = new Main();
            System.out.println("Please select the option.\n1.Add bus.\n2.Book seat.\n3.Display available buses.\n4.Cancel booking\n5.Display bookings\n" +
                    "6.Add passenger.\n7.Display passengers." );
            String option = sc.next();
            switch (option) {
                case "1":
                    System.out.print("Enter the bus details.\nEnter the bus number :");
                    String busNumber = sc.next();
                    System.out.print("Enter seat capacity : ");
                    Integer seatCapacity = sc.nextInt();
                    System.out.print("Enter the price per seat : ");
                    String pricePerSeat = sc.next();
                    System.out.print("Enter the departure city : ");
                    String departure = sc.next();
                    System.out.print("Enter the destination : ");
                    String destination = sc.next();
                    Bus bus = new Bus(busNumber, seatCapacity, pricePerSeat, departure, destination);
                    main.addBus(bus);
                    System.out.println("Your bus has been added");
                    break;
                case "2":
                    do {
                        System.out.print("Enter the bus details.\nBus name : ");
                        busNumber = sc.next();
                        bus = main.searchBusByBusBusNumber(busNumber);
                        if (bus == null) {
                            System.out.println("Bus not found with this " + busNumber);


                        } else {
                            System.out.print("Bus found with this " + bus.getBusNumber());

                        }
                    } while (bus == null);


                    System.out.print("Enter passenger details.\nName :  ");
                    String name = sc.next();
                    System.out.print("Age : ");
                    String contact = sc.next();
                    Passengers p = main.searchPassenger(name, contact);
                    if (p == null) {
                        System.out.println("Passenger is not registered in or records.\nPlease add your details.\nEnter the name : ");
                        name = sc.next();
                        System.out.print("Enter your age : ");
                        Integer age = sc.nextInt();
                        System.out.print("Enter the contact number : ");
                        String contactNumber = sc.next();
                        System.out.print("Enter the gender : ");
                        String gender = sc.next();
                        p = new Passengers(name, age, contactNumber, gender);
                        main.addPassenger(p);
                        System.out.print("Passenger added.");
                    } else {
                        System.out.print("Passenger is registered in our records " + p.getName());
                    }
                    System.out.println("How many seats do you want to book : ");
                    Integer seats = sc.nextInt();
                    if (!main.seatBooking.containsKey(busNumber + "-total")) {
                        main.seatBooking.put(busNumber + "-total", bus.getSeatCapacity());
                    }
                    Integer remaining = main.seatBooking.get(busNumber + "-total") - seats;
                    if (remaining >= 0) {
                        System.out.println("");
                        main.seatBooking.put(busNumber + "-total", remaining);
                        Booking book = main.bookTicket(p, bus);
                        if (book != null) {

                            main.bookingList.add(book);

                        }
                        System.out.println("Your" + seats + "seats booked in bus " + bus);

                    } else {
                        System.out.println("Not too much seats \nAvailable seats are : " + main.seatBooking.get(busNumber + "-total"));
                    }
                    break;
                case "3":

                    main.displayBuses();
                    break;

                case "4":
                    System.out.println("Enter Passenger Name");
                    name = sc.next();
                    main.cancelBooking(name);
                    break;
                case "5":
                    main.displayBookings();
                    System.out.println("Booked Seats are : " + seatBooking);
                    break;
                case "6":
                    System.out.print("Enter the name : ");
                    name = sc.next();
                    System.out.print("Enter the age : ");
                    Integer age = sc.nextInt();
                    System.out.print("Enter the contact number : ");
                    contact = sc.next();
                    System.out.print("Enter the gender : ");
                    String gender = sc.next();
                    p = new Passengers(name,age,contact,gender);
                    main.addPassenger(p);
                    System.out.println("Passenger added.");
                    break;
                case "7" :
                    main.displayPassengers();

                    break;


            }
            System.out.println("Want to continue : y/n ");
            option1 = sc.next();
        } while (option1.equalsIgnoreCase("y"));
    }


    public void addBus(Bus bus) {
        buses.add(bus);
    }

    public void addPassenger(Passengers passengers) {
        this.passengers.add(passengers);
    }

    public Bus searchBusByBusBusNumber(String busNumber) {
        Bus bus = null;
        for (int i = 0; i < buses.size(); i++) {
            if (buses.get(i).getBusNumber().equalsIgnoreCase(busNumber)) {
                bus = buses.get(i);
            }
        }
        return bus;
    }

    public Passengers searchPassenger(String name, String contactNumber) {
        Passengers passenger = null;
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getName().equalsIgnoreCase(name) || passengers.get(i).getContactNumber().equals(contactNumber)) {
                passenger = passengers.get(i);

            }
        }
        return passenger;

    }

    public void displayBuses() {
        for (int i = 0; i < buses.size(); i++) {
            System.out.println("Available buses are : ");
            System.out.println(buses.get(i));
        }
    }

    public Booking bookTicket(Passengers pass, Bus bu) {
        Booking book = new Booking();
        book.setBookingID(UUID.randomUUID().toString());
        book.setPassengers(pass);
        book.setBus(bu);
        return book;


    }

    public Booking searchBookingByPassengerName(String pass) {
        Booking booking = null;
        for (int i = 0; i < bookingList.size(); i++) {
            if (bookingList.get(i).getPassengers().getName().equalsIgnoreCase(pass)) {
                booking = bookingList.get(i);
            }
        }
        return booking;
    }

    public void cancelBooking(String passengerName) {
        Booking booking = searchBookingByPassengerName(passengerName);
        if (booking != null) {
            bookingList.remove(booking);
            System.out.println("Your ticket is cancelled in " + booking.getBookingID());
        } else {
            System.out.println("No Bookings found");

        }

    }

    public void displayBookings() {
        if (bookingList.isEmpty()) {
            System.out.println("No booking found");

        }
        for (Booking book : bookingList) {
            System.out.println(book);


        }
    }
    public void displayPassengers () {
        for (int i = 0; i < passengers.size(); i++) {
            System.out.println("Passengers are : ");
            System.out.println(passengers.get(i));

        }
    }

}







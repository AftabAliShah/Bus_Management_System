import java.util.ArrayList;
import java.util.List;

public class Passengers {
    public static List<Passengers> passengersList = new ArrayList<>(List.of(new Passengers("Aftab", 18, "03134322286", "Male")
            ,new Passengers("Ali", 20, "03421778136", "Male"), new Passengers("Hussain", 21, "03003299713", "Male")));
    private String name;
    private Integer age;
    private String contactNumber;
    private String gender;

    public Passengers() {

    }

    public Passengers(String name, Integer age, String contactNumber, String gender) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Passengers[" +
                "Name='" + name + '\'' +
                ", Age=" + age +
                ", ContactNumber='" + contactNumber + '\'' +
                ", Gender='" + gender + '\'' +
                ']';
    }

}

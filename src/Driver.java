import java.util.ArrayList;
import java.util.List;

public class Driver {
    private String name;
    private int age;
    private String phoneNumber;
    private List<Car> cars;

    public Driver(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car1) {
        cars.add(car1);
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

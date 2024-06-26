import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FleetStatusPage extends Region {

    private List<Driver> drivers;

    public FleetStatusPage() {
        // Initialize sample data
        initializeData();

        // Create the main layout
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);

        // Display fleet summary information
        Label titleLabel = new Label("Fleet Status Overview");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label driversLabel = new Label("Number of Drivers: " + drivers.size());
        Label carsLabel = new Label("Number of Cars: " + getTotalNumberOfCars());
        Label accidentsLabel = new Label("Number of Accidents: " + getTotalNumberOfAccidents());

        root.getChildren().addAll(titleLabel, driversLabel, carsLabel, accidentsLabel);

        getChildren().add(root);
    }

    private void initializeData() {
        drivers = new ArrayList<>();

        // Sample driver 1
        Driver driver1 = new Driver("John Doe", 35, "+1234567890");
        Car car1 = new Car("Car 1", "car1.jpg", null);
        car1.addAccident("Minor accident on highway");
        car1.addAccident("Scratch in parking lot");
        driver1.addCar(car1);
        drivers.add(driver1);

        // Sample driver 2
        Driver driver2 = new Driver("Jane Smith", 28, "+1987654321");
        Car car2 = new Car("Car 2", "car2.jpg", null);
        car2.addAccident("No major accidents reported");
        driver2.addCar(car2);
        drivers.add(driver2);
    }

    private int getTotalNumberOfCars() {
        int totalCars = 0;
        for (Driver driver : drivers) {
            totalCars += driver.getCars().size();
        }
        return totalCars;
    }

    private int getTotalNumberOfAccidents() {
        int totalAccidents = 0;
        for (Driver driver : drivers) {
            for (Car car : driver.getCars()) {
                totalAccidents +=1;
            }
        }
        return totalAccidents;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        // This method can be overridden for custom layout behavior if needed
    }

    @Override
    protected double computePrefWidth(double height) {
        return 400; // Adjust according to your preferred width
    }

    @Override
    protected double computePrefHeight(double width) {
        return 300; // Adjust according to your preferred height
    }
}

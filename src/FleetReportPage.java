import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.util.List;

public class FleetReportPage extends Region {

    public FleetReportPage() {
        // Sample driver data
        Driver driver = new Driver("John Doe", 35, "+1234567890");

        // Sample cars driven by the driver
        Car car1 = new Car("Car 1", "car1.jpg", null);
        car1.addAccident("Minor accident on highway");
        car1.addAccident("Scratch in parking lot");

        Car car2 = new Car("Car 2", "car2.jpg", null);
        car2.addAccident("No major accidents reported");

        driver.addCar(car1);
        driver.addCar(car2);

        // Create the main layout
        VBox root = new VBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);

        // Driver information section
        VBox driverInfo = new VBox();
        driverInfo.setSpacing(10);
        Label nameLabel = new Label("Name: " + driver.getName());
        Label ageLabel = new Label("Age: " + driver.getAge());
        Label phoneLabel = new Label("Phone Number: " + driver.getPhoneNumber());
        driverInfo.getChildren().addAll(nameLabel, ageLabel, phoneLabel);
        root.getChildren().add(driverInfo);

        // Cars driven section
        for (Car car : driver.getCars()) {
            VBox carCard = new VBox();
            carCard.setSpacing(10);
            carCard.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-padding: 10px;");

            // Check if the imageUrl is not null before creating ImageView
            if (car.getImageUrl() != null && !car.getImageUrl().isEmpty()) {
                ImageView imageView = new ImageView(new Image(car.getImageUrl()));
                imageView.setFitWidth(200);
                imageView.setFitHeight(120);
                carCard.getChildren().add(imageView);
            }

            Label carNameLabel = new Label("Car Name: " + car.getName());
            carNameLabel.setStyle("-fx-font-weight: bold;");
            carCard.getChildren().add(carNameLabel);
            root.getChildren().add(carCard);
        }

        getChildren().add(root);
    }
}

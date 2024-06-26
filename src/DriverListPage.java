import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class DriverListPage extends VBox {

    public DriverListPage() {
        // Sample driver data
        Driver driver = new Driver("John Doe", 35, "+1234567890");

        // Sample cars driven by the driver
        Car car1 = new Car("Car 1", "car1.jpg", null);
        car1.addAccident("Minor accident on highway");
        car1.addDrive("City A", "Commute", 300); // 300 hours
        car1.addDrive("City B", "Vacation", 50); // 50 hours

        Car car2 = new Car("Car 2", "car2.jpg", null);
        car2.addAccident("No major accidents reported");
        car2.addDrive("City C", "Business trip", 150); // 150 hours

        driver.addCar(car1);
        driver.addCar(car2);

        // Create the main layout
        setPadding(new Insets(20));
        setSpacing(20);

        // Driver information section
        VBox driverInfo = new VBox();
        driverInfo.setSpacing(10);
        Label nameLabel = new Label("Name: " + driver.getName());
        Label ageLabel = new Label("Age: " + driver.getAge());
        Label phoneLabel = new Label("Phone Number: " + driver.getPhoneNumber());
        driverInfo.getChildren().addAll(nameLabel, ageLabel, phoneLabel);

        getChildren().add(driverInfo);

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

            getChildren().add(carCard);
        }
    }
}

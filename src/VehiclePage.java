import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class VehiclePage extends Region {

    private List<VehicleCard> vehicleCards;

    public VehiclePage(Stage primaryStage) {
        // Load map background image (example map image)
        StackPane mapPane = createMapPane();

        // Create a GridPane to hold vehicle cards
        GridPane gridPane = createGridPane();

        // Sample vehicle data (replace with actual data source)
        List<VehicleData> vehicleDataList = createSampleVehicleData();

        // Create VehicleCard for each vehicle data
        vehicleCards = new ArrayList<>();
        int columnIndex = 0;
        int rowIndex = 0;
        for (VehicleData vehicleData : vehicleDataList) {
            VehicleCard vehicleCard = new VehicleCard(vehicleData);
            gridPane.add(vehicleCard, columnIndex, rowIndex);
            vehicleCards.add(vehicleCard);

            columnIndex++;
            if (columnIndex == 2) { // Two cards per row
                columnIndex = 0;
                rowIndex++;
            }
        }
        getChildren().addAll(mapPane, gridPane);
    }

    private StackPane createMapPane() {
        // Example map image setup (replace with actual map integration)
        StackPane mapPane = new StackPane();
        Rectangle mapBackground = new Rectangle(800, 600, Color.LIGHTGRAY);
        mapPane.getChildren().add(mapBackground);
        return mapPane;
    }

    private GridPane createGridPane() {
        // Create a GridPane for vehicle cards layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }

    private List<VehicleData> createSampleVehicleData() {
        // Sample vehicle data (replace with actual data source)
        List<VehicleData> vehicleDataList = new ArrayList<>();
        vehicleDataList.add(new VehicleData("CarName1", "Petrol", 12.5,
        "180 km/h"));
vehicleDataList.add(new VehicleData("CarName2", "Diesel", 10.8,
        "200 km/h"));
vehicleDataList.add(new VehicleData("CarName3", "Electric", 0.0,
        "250 km/h"));
vehicleDataList.add(new VehicleData("CarName4", "Hybrid", 8.3,
        "190 km/h"));

        // Add more sample vehicles as needed
        return vehicleDataList;
    }

    // VehicleCard class representing each vehicle's information
    private class VehicleCard extends StackPane {

        public VehicleCard(VehicleData vehicleData) {
            Rectangle background = new Rectangle(300, 180);
            background.setFill(Color.WHITE);
            background.setStroke(Color.BLACK);
            background.setArcWidth(20);
            background.setArcHeight(20);

            VBox labelsContainer = new VBox();
            labelsContainer.setPadding(new Insets(10));
            labelsContainer.setAlignment(Pos.CENTER_LEFT);

            Label nameLabel = new Label(vehicleData.getName());
            nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
            Label fuelTypeLabel = new Label("Fuel Type: " + vehicleData.getFuelType());
            Label fuelConsumptionLabel = new Label(
                    "Fuel Consumption: " + vehicleData.getFuelConsumption() + " L/100km");
            Label characteristicsLabel = new Label(vehicleData.getCharacteristics());

            labelsContainer.getChildren().addAll(nameLabel, fuelTypeLabel, fuelConsumptionLabel, characteristicsLabel);

            getChildren().addAll(background, labelsContainer);
        }
    }

    // VehicleData class representing data of each vehicle
    private static class VehicleData {
        private String name;
        private String fuelType;
        private double fuelConsumption;
        private String speed;

        public VehicleData(String name, String fuelType, double fuelConsumption, String speed) {
            this.name = name;
            this.fuelType = fuelType;
            this.fuelConsumption = fuelConsumption;
            this.speed = speed;
        }

        public String getName() {
            return name;
        }

        public String getFuelType() {
            return fuelType;
        }

        public double getFuelConsumption() {
            return fuelConsumption;
        }

        public String getCharacteristics() {
            return speed;
        }
    }
}

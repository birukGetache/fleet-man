import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CarDashBoard extends Application {

    // URLs of images to load
    private static final String[] imageUrls = {
            "https://images.pexels.com/photos/3680219/pexels-photo-3680219.jpeg?auto=compress&cs=tinysrgb&h=627&fit=crop&w=1200",
            "https://images.pexels.com/photos/104827/cat-pet-animal-domestic-104827.jpeg?auto=compress&cs=tinysrgb&h=627&fit=crop&w=1200",
            "https://images.pexels.com/photos/159621/milky-way-starry-sky-night-sky-star-159621.jpeg?auto=compress&cs=tinysrgb&h=627&fit=crop&w=1200"
    };

    private BorderPane root;
    private ImageView icon;
    private Scene scene;
    private OverviewPage overviewPage; // Assuming you have an OverviewPage class

    @Override
    public void start(Stage primaryStage) {
        // Initialize the main layout
        root = new BorderPane();

        // Creating a list of items
        ObservableList<String> items = FXCollections.observableArrayList(
                "Overview",
                "Fleet Status",
                "Performance Metrics",
                "Vehicles",
                "Drivers",
                "Routes",
                "Reports",
                "Settings");

        // Creating ListView to display items
        ListView<String> listView = new ListView<>(items);
        listView.setPrefWidth(150); // Fixed width for the ListView

        // Creating VBox to hold the ListView
        VBox sidebar = new VBox(listView);
        sidebar.setPadding(new Insets(10)); // Optional: Add padding for better appearance

        // Bind VBox height to Scene height
        sidebar.prefHeightProperty().bind(primaryStage.heightProperty());

        // Bind ListView height to VBox height
        listView.prefHeightProperty().bind(sidebar.heightProperty());

        // Create an ImageView for displaying images
        icon = new ImageView();
        icon.setFitWidth(300); // Set the width to match the scene width
        icon.setPreserveRatio(true); // Preserve aspect ratio

        // Initialize OverviewPage
        overviewPage = new OverviewPage();
        root.setCenter(overviewPage); // Initially set to OverviewPage

        FleetStatusPage fleetStatusOverview = new FleetStatusPage();
        PerformanceMetricsPage performance = new PerformanceMetricsPage();
        VehiclePage vehicles = new VehiclePage(primaryStage);
        DriverListPage driver = new DriverListPage();
        FleetReportPage fleet = new FleetReportPage();
        SettingsPage setting = new SettingsPage();
        // Event handler for ListView item clicks
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                switch (newValue) {
                    case "Overview":
                        root.setCenter(overviewPage);
                        break;
                    case "Fleet Status":
                        root.setCenter(fleetStatusOverview);
                        break;
                    case "Performance Metrics":
                        root.setCenter(performance);
                        break;
                    case "Vehicles":
                        root.setCenter(vehicles);
                        break;
                    case "Drivers":
                        root.setCenter(driver);
                        break;
                    case "Reports":
                        root.setCenter(fleet);
                        break;
                    case "Settings":
                        root.setCenter(setting);
                        break;
                    default:
                        break;
                }

                // Load corresponding image (example)
                int index = items.indexOf(newValue);
                if (index >= 0 && index < imageUrls.length) {
                    Image image = new Image(imageUrls[index]);
                    icon.setImage(image);
                }
            }
        });

        // Set sidebar to the left of BorderPane
        root.setLeft(sidebar);

        // Adding the top box to the BorderPane and setting it to the top
        root.setTop(icon);
        BorderPane.setAlignment(icon, javafx.geometry.Pos.CENTER); // Align center
        BorderPane.setMargin(icon, new Insets(10, 10, 0, 10)); // Set margins

        // Create a scene
        scene = new Scene(root, 800, 600);

        // Setting the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dashboard");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

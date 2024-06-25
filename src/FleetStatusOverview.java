import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FleetStatusOverview extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fleet Status Overview");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);

        // Title
        Label titleLabel = new Label("Fleet Status Overview");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        GridPane.setConstraints(titleLabel, 0, 0, 2, 1); // span 2 columns
        grid.getChildren().add(titleLabel);

        // Fleet Status Updates
        Label status1 = new Label("56 vehicles crashed");
        GridPane.setConstraints(status1, 0, 1);

        Label status2 = new Label("60 vehicles are in automobile");
        GridPane.setConstraints(status2, 0, 2);

        Label status3 = new Label("20 vehicles are under maintenance");
        GridPane.setConstraints(status3, 0, 3);

        Label status4 = new Label("5 vehicles are awaiting repair");
        GridPane.setConstraints(status4, 0, 4);

        Label status5 = new Label("15 vehicles are out for delivery");
        GridPane.setConstraints(status5, 0, 5);

        Label status6 = new Label("10 vehicles are in transit");
        GridPane.setConstraints(status6, 0, 6);

        Label status7 = new Label("8 vehicles are in the garage");
        GridPane.setConstraints(status7, 0, 7);

        Label status8 = new Label("3 vehicles are low on fuel");
        GridPane.setConstraints(status8, 0, 8);

        Label status9 = new Label("12 vehicles are on scheduled maintenance");
        GridPane.setConstraints(status9, 0, 9);

        Label status10 = new Label("25 vehicles are available for assignment");
        GridPane.setConstraints(status10, 0, 10);

        Label status11 = new Label("2 vehicles are awaiting inspection");
        GridPane.setConstraints(status11, 0, 11);

        Label status12 = new Label("30 vehicles are parked");
        GridPane.setConstraints(status12, 0, 12);

        // Adding labels to the grid
        grid.getChildren().addAll(
                status1, status2, status3, status4,
                status5, status6, status7, status8,
                status9, status10, status11, status12
        );

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public GridPane getGridPane() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGridPane'");
    }

    // Optionally, you can add methods here to provide functionality for FleetStatusOverview
    // For example, you could add methods to update the status information dynamically.
}

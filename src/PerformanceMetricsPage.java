import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PerformanceMetricsPage extends BorderPane {

    private TableView<PerformanceMetric> tableView;

    public PerformanceMetricsPage() {
        // Initialize the TableView
        tableView = new TableView<>();
        tableView.setPrefWidth(600);
        tableView.setPlaceholder(new Label("No data available"));

        // Define columns
        TableColumn<PerformanceMetric, String> metricColumn = new TableColumn<>("Metric");
        metricColumn.setCellValueFactory(new PropertyValueFactory<>("metricName"));

        TableColumn<PerformanceMetric, Double> valueColumn = new TableColumn<>("Value");
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

        // Add columns to TableView
        tableView.getColumns().addAll(metricColumn, valueColumn);

        // Set sample data (you can replace this with your actual data or fetch from a
        // data source)
        ObservableList<PerformanceMetric> data = FXCollections.observableArrayList(
                new PerformanceMetric("Accidents and Safety", 70.0),
                new PerformanceMetric("Asset Utilization", 85.0),
                new PerformanceMetric("Driver Assignments", 60.0),
                new PerformanceMetric("Fuel Management", 75.0),
                new PerformanceMetric("Inventory and Parts", 90.0),
                new PerformanceMetric("Odometer Data", 80.0),
                new PerformanceMetric("Preventative Maintenance", 65.0),
                new PerformanceMetric("Repair Turnover", 72.0),
                new PerformanceMetric("Technician Productivity", 78.0),
                new PerformanceMetric("Telematics", 88.0),
                new PerformanceMetric("Vehicle Replacement", 82.0));

        // Set data to TableView
        tableView.setItems(data);

        // Layout setup
        VBox content = new VBox(tableView);
        content.setPadding(new Insets(10));
        setCenter(content);
    }
}

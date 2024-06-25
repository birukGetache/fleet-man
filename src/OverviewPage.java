import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OverviewPage extends BorderPane {

    public OverviewPage() {
        // Create a VBox for the content
        VBox contentBox = new VBox();
        contentBox.setPadding(new Insets(10));
        contentBox.setSpacing(20); // Increased spacing between sections for better readability

        // Title Label
        Label titleLabel = new Label("Fleet Management System Overview");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Introduction Section as a "Card"
        VBox introductionCard = new VBox();
        introductionCard.setPadding(new Insets(10));
        introductionCard.setStyle(
                "-fx-background-color: #f0f0f0; -fx-border-color: #cccccc; -fx-border-width: 1px; -fx-border-radius: 5px;");

        Label introductionLabel = new Label("Introduction");
        introductionLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label introText = new Label("Welcome to the Fleet Management System (FMS), "
                + "a robust software solution designed to streamline the management "
                + "and operations of vehicle fleets. Developed using JavaFX, this system "
                + "provides a user-friendly interface combined with powerful functionalities "
                + "to efficiently manage vehicles, drivers, maintenance schedules, and more.");

        // Set the introText to wrap text if it exceeds its width
        introText.setWrapText(true);

        introductionCard.getChildren().addAll(introductionLabel, introText);

        // Key Features Section
        Label keyFeaturesLabel = new Label("Key Features");
        keyFeaturesLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        // Create an HBox for Vehicle Management and Driver Management side by side
        HBox vehicleDriverBox = new HBox(20); // 20 pixels spacing between cards
        vehicleDriverBox.getChildren().addAll(
                createFeatureCard("1. Vehicle Management",
                        "Vehicle Database: Maintain detailed records of all fleet vehicles, "
                                + "including make, model, year, and registration information.\n"
                                + "Real-time Tracking: Monitor vehicle locations and status updates in real-time using integrated GPS tracking.\n"
                                + "Maintenance Tracking: Schedule and track vehicle maintenance tasks, including service history and upcoming maintenance alerts.\n"
                                + "Fuel Management: Monitor fuel consumption, costs, optimize fuel usage, and track fuel efficiency metrics."),
                createFeatureCard("Driver Management",
                        "Driver Profiles: Manage driver information, licenses, certifications, and contact details.\n"
                                + "Assignment and Scheduling: Assign drivers to vehicles, track driver availability, and manage driver shifts.\n"
                                + "Performance Monitoring: Monitor driver behavior, including speed, route adherence, and compliance with safety regulations.")
        );

        // Create an HBox for Reporting and Analytics and Maintenance and Repairs side by side
        HBox reportingMaintenanceBox = new HBox(20); // 20 pixels spacing between cards
        reportingMaintenanceBox.getChildren().addAll(
                createFeatureCard("Reporting and Analytics",
                        "Customizable Reports: Generate reports on vehicle utilization, fuel consumption, maintenance costs, and driver performance.\n"
                                + "Data Visualization: Visualize fleet performance through graphs, charts, and interactive dashboards.\n"
                                + "Forecasting and Optimization: Analyze data trends to forecast maintenance needs, optimize routes, and improve operational efficiency."),
                createFeatureCard("Maintenance and Repairs",
                        "Maintenance Scheduling: Schedule regular maintenance tasks based on mileage, time intervals, or condition-based triggers.\n"
                                + "Repair History: Record and track repair history, costs, and parts replacements.\n"
                                + "Alerts and Notifications: Receive alerts for upcoming maintenance tasks, service reminders, and vehicle inspections.")
        );

        // Set the maximum width for each card
        vehicleDriverBox.setMaxWidth(Double.MAX_VALUE);
        reportingMaintenanceBox.setMaxWidth(Double.MAX_VALUE);

        // Add labels and feature VBox to content VBox
        contentBox.getChildren().addAll(
                titleLabel,
                introductionCard,
                keyFeaturesLabel,
                vehicleDriverBox,
                reportingMaintenanceBox
                // Add more features as needed
        );

        // Set content to the center of BorderPane
        this.setCenter(contentBox);
    }

    // Helper method to create a styled VBox for each feature "card"
    private VBox createFeatureCard(String title, String description) {
        VBox card = new VBox();
        card.setPadding(new Insets(10));
        card.setStyle(
                "-fx-background-color: #f0f0f0; -fx-border-color: #cccccc; -fx-border-width: 1px; -fx-border-radius: 5px;");

        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label descriptionLabel = new Label(description);
        descriptionLabel.setWrapText(true);

        card.getChildren().addAll(titleLabel, descriptionLabel);
        return card;
    }
}

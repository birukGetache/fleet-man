import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class SettingsPage extends Region {

    private BorderPane root;
    private StackPane centerPane;

    public SettingsPage() {
        root = new BorderPane();
        centerPane = new StackPane();
        centerPane.setPadding(new Insets(20));
        root.setCenter(centerPane);

        // Create a combo box for theme selection
        ComboBox<String> themeComboBox = new ComboBox<>();
        themeComboBox.getItems().addAll("Light", "Dark");
        themeComboBox.setValue("Light");
        themeComboBox.setOnAction(e -> {
            String selectedTheme = themeComboBox.getValue();
            if ("Dark".equals(selectedTheme)) {
                setDarkTheme();
            } else {
                setLightTheme();
            }
        });

        // Create a button to change background color
        Button changeColorButton = new Button("Change Color");
        changeColorButton.setOnAction(e -> {
            Color randomColor = getRandomColor();
            changeBackgroundColor(randomColor);
        });

        // Layout for settings
        StackPane settingsPane = new StackPane();
        settingsPane.setPadding(new Insets(10));
        settingsPane.getChildren().addAll(themeComboBox, changeColorButton);

        root.setTop(settingsPane);

        // Set initial light theme
        setLightTheme();

        getChildren().add(root);
    }

    private void setLightTheme() {
        root.setStyle("-fx-background-color: #f0f0f0;");
        centerPane.setStyle("-fx-background-color: white;");
    }

    private void setDarkTheme() {
        root.setStyle("-fx-background-color: #202020;");
        centerPane.setStyle("-fx-background-color: #303030;");
    }

    private void changeBackgroundColor(Color color) {
        centerPane.setBackground(new Background(new BackgroundFill(color, null, null)));
    }

    private Color getRandomColor() {
        double r = Math.random();
        double g = Math.random();
        double b = Math.random();
        return new Color(r, g, b, 1);
    }
}

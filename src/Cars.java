import java.util.ArrayList;
import java.util.List;

public class Cars {
    private String carName;
    private String image;
    private List<String> accidents;
    private List<String> driveLocations;
    private List<String> drivePurposes;
    private List<Integer> driveDurations;

    public Cars(String carName, String image) {
        this.carName = carName;
        this.image = image;
        this.accidents = new ArrayList<>();
        this.driveLocations = new ArrayList<>();
        this.drivePurposes = new ArrayList<>();
        this.driveDurations = new ArrayList<>();
    }

    public void addAccident(String accident) {
        accidents.add(accident);
    }

    public void addDrive(String location, String purpose, int duration) {
        driveLocations.add(location);
        drivePurposes.add(purpose);
        driveDurations.add(duration);
    }

    public String getCarName() {
        return carName;
    }

    public String getImage() {
        return image;
    }

    public List<String> getAccidents() {
        return accidents;
    }

    public List<String> getDriveLocations() {
        return driveLocations;
    }

    public List<String> getDrivePurposes() {
        return drivePurposes;
    }

    public List<Integer> getDriveDurations() {
        return driveDurations;
    }
}

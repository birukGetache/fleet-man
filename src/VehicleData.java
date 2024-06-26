 class VehicleData {
    private String name;
    private String fuelType;
    private double fuelConsumption;
    private String speed;
    private String mpg;
    private String range;
    private String horsepower;
    private String seat;
    private String imagePath;
    private String mileAge;
    private String oilType;
    private String driveType;

    public VehicleData(String name, String fuelType, double fuelConsumption, String speed, String mpg,
                       String range, String horsepower, String seat, String imagePath, String mileAge,
                       String oilType, String driveType) {
        this.name = name;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.speed = speed;
        this.mpg = mpg;
        this.range = range;
        this.horsepower = horsepower;
        this.seat = seat;
        this.imagePath = imagePath;
        this.mileAge = mileAge;
        this.oilType = oilType;
        this.driveType = driveType;
    }

    // Getters for all attributes
    public String getName() {
        return name;
    }

    public String getFuelType() {
        return fuelType;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public String getSpeed() {
        return speed;
    }

    public String getMpg() {
        return mpg;
    }

    public String getRange() {
        return range;
    }

    public String getHorsepower() {
        return horsepower;
    }

    public String getSeat() {
        return seat;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getMileAge() {
        return mileAge;
    }

    public String getOilType() {
        return oilType;
    }

    public String getDriveType() {
        return driveType;
    }
}

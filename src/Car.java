public class Car {
    private String name;
    private String description;
    private String imageUrl;
    private String Location;
    private String accident;
    public Car(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public String getLocation() {
        return Location;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAccidents() {
     return accident;
    }

    public boolean addAccident(String string) {
        
   return true;
    }

    public boolean addDrive(String string, String string2, int i) {
return true;
    }
    
}

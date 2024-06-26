public class PerformanceMetric {

    private String metricName;
    private Double value;

    public PerformanceMetric(String metricName, Double value) {
        this.metricName = metricName;
        this.value = value;
    }

    // Getter for metricName
    public String getMetricName() {
        return metricName;
    }

    // Setter for metricName (if needed)
    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    // Getter for value
    public Double getValue() {
        return value;
    }

    // Setter for value (if needed)
    public void setValue(Double value) {
        this.value = value;
    }
}

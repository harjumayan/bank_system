package models;

public class Appointment implements Comparable<Appointment> {
    private String customerName;
    private String serviceType;
    private String preferredTime;
    private int priority;

    public Appointment(String customerName, String serviceType, String preferredTime, int priority) {
        this.customerName = customerName;
        this.serviceType = serviceType;
        this.preferredTime = preferredTime;
        this.priority = priority;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getPreferredTime() {
        return preferredTime;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Appointment other) {
        if (this.priority != other.priority) {
            return Integer.compare(this.priority, other.priority);
        }
        return this.preferredTime.compareTo(other.preferredTime);
    }

    @Override
    public String toString() {
        return "[Customer: " + customerName +
                ", Service: " + serviceType +
                ", Time: " + preferredTime +
                ", Priority: " + priority + "]";
    }
}

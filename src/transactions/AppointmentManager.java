package transactions;

import models.Appointment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppointmentManager {
    private List<Appointment> appointments;

    public AppointmentManager() {
        this.appointments = new ArrayList<>();
    }

    public void scheduleAppointment(Appointment appointment) {
        appointments.add(appointment);
        Collections.sort(appointments); // keeps list ordered by priority and time
    }

    public List<Appointment> viewAllAppointments() {
        return new ArrayList<>(appointments);
    }

    public Appointment getNextAppointment() {
        if (appointments.isEmpty()) return null;
        return appointments.remove(0);
    }
}

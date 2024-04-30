package Ca2GroupProject;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BoundedPriorityQueue extends LinkedList<Appointment> {
    private final int capacity;
    private final String doctorFullName;

    public BoundedPriorityQueue(int capacity, String doctorFullName) {
        super();
        this.capacity = capacity;
        this.doctorFullName = doctorFullName;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getDoctorFullName() {
        return doctorFullName;
    }

    @Override
    public boolean add(Appointment appointment) {
        if (!appointment.getDoctorFullName().equalsIgnoreCase(doctorFullName)) {
            throw new IllegalArgumentException("Appointment is not for the specified doctor");
        }
        if (size() < capacity) {
            return super.add(appointment);
        } else {
            throw new IllegalStateException("Queue is full");
        }
    }

    public boolean offerSafe(Appointment appointment) {
        if (size() < capacity && appointment.getDoctorFullName().equalsIgnoreCase(doctorFullName)) {
            return super.offer(appointment);
        }
        return false;
    }

    @Override
    public Appointment remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return super.remove();
    }

    public Appointment pollSafe() {
        if (isEmpty()) {
            return null;
        }
        return super.poll();
    }
}
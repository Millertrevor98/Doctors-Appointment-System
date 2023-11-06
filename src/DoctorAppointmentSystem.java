import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Appointment {
    private String patientName;
    private String date;
    private String time;

    public Appointment(String patientName, String date, String time) {
        this.patientName = patientName;
        this.date = date;
        this.time = time;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Patient: " + patientName + " | Date: " + date + " | Time: " + time;
    }
}

public class DoctorAppointmentSystem {
    private List<Appointment> appointments = new ArrayList<>();
    private JFrame frame;

    public DoctorAppointmentSystem() {
        frame = new JFrame("Doctor Appointment System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JButton bookAppointmentButton = new JButton("Book Appointment");
        bookAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAppointmentDialog();
            }
        });

        JButton viewAppointmentsButton = new JButton("View Appointments");
        viewAppointmentsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAppointments();
            }
        });

        JPanel panel = new JPanel();
        panel.add(bookAppointmentButton);
        panel.add(viewAppointmentsButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DoctorAppointmentSystem());
    }

    private void showAppointmentDialog() {
        JFrame appointmentFrame = new JFrame("Book an Appointment");
        appointmentFrame.setSize(800, 250);

        JTextField nameField = new JTextField(20);
        JTextField dateField = new JTextField(20);
        JTextField timeField = new JTextField(20);
        JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String date = dateField.getText();
                String time = timeField.getText();

                appointments.add(new Appointment(name, date, time));
                JOptionPane.showMessageDialog(appointmentFrame, "Appointment booked successfully!");
                appointmentFrame.dispose();
            }
        });

        JPanel appointmentPanel = new JPanel();
        appointmentPanel.add(new JLabel("Patient Name: "));
        appointmentPanel.add(nameField);
        appointmentPanel.add(new JLabel("Date: "));
        appointmentPanel.add(dateField);
        appointmentPanel.add(new JLabel("Time: "));
        appointmentPanel.add(timeField);
        appointmentPanel.add(submitButton);

        appointmentFrame.add(appointmentPanel);
        appointmentFrame.setVisible(true);
    }

    private void showAppointments() {
        JFrame appointmentsFrame = new JFrame("Appointments");
        appointmentsFrame.setSize(400, 300);

        JTextArea appointmentsList = new JTextArea();
        for (Appointment appointment : appointments) {
            appointmentsList.append(appointment.toString() + "\n");
        }

        JPanel appointmentsPanel = new JPanel();
        appointmentsPanel.add(appointmentsList);

        appointmentsFrame.add(appointmentsPanel);
        appointmentsFrame.setVisible(true);
    }
}

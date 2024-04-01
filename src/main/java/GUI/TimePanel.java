package GUI;
import javax.swing.*;
import java.awt.*;

public class TimePanel extends JPanel {

    private JComboBox<String> hourComboBox;
    private JComboBox<String> minuteComboBox;
    private JComboBox<String> secondComboBox;

    public TimePanel() {
        setLayout(new FlowLayout()); // Using FlowLayout for simplicity

        // Creating hour combo box
        String[] hours = new String[24];
        for (int i = 0; i < 24; i++) {
            hours[i] = String.format("%02d", i);
        }
        hourComboBox = new JComboBox<>(hours);
        add(hourComboBox);

        // Creating minute combo box
        String[] minutes = new String[60];
        for (int i = 0; i < 60; i++) {
            minutes[i] = String.format("%02d", i);
        }
        minuteComboBox = new JComboBox<>(minutes);
        add(minuteComboBox);

        // Creating second combo box
        String[] seconds = new String[60];
        for (int i = 0; i < 60; i++) {
            seconds[i] = String.format("%02d", i);
        }
        secondComboBox = new JComboBox<>(seconds);
        add(secondComboBox);
    }

    // Method to get the selected time as a string in "hh:mm:ss" format
    public String getSelectedTime() {
        String hour = (String) hourComboBox.getSelectedItem();
        String minute = (String) minuteComboBox.getSelectedItem();
        String second = (String) secondComboBox.getSelectedItem();
        return hour + ":" + minute + ":" + second;
    }


}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField celsiusTextField;
    private JButton convertButton;
    private JLabel fahrenheitLabel;
    private JTextField fahrenheitTextField;
    private JLabel celsiusLabel;
    private JButton closeButton;

    public TemperatureConverterGUI() {
        super("Konwerter Temperatury");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String celsiusText = celsiusTextField.getText();
                try {
                    double celsius = Double.parseDouble(celsiusText);
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    fahrenheitTextField.setText(String.format("%.2f", fahrenheit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Proszę wprowadzić prawidłową liczbę dla stopni Celsjusza.", "Błąd wprowadzania", JOptionPane.ERROR_MESSAGE);
                    fahrenheitTextField.setText("");
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureConverterGUI();
            }
        });
    }
}
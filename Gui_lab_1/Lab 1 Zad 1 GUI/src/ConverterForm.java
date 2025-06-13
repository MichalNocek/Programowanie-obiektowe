import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterForm {
    public JPanel mainPanel;
    public JTextField celsiusField;
    public JButton convertButton;
    public JLabel resultLabel;

    public ConverterForm() {
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(celsiusField.getText());
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    resultLabel.setText("Wynik: " + fahrenheit + " °F");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Błędna liczba!");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Konwerter Celsjusz -> Fahrenheit");
        frame.setContentPane(new ConverterForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

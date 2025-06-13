import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays; // Do bezpiecznego porównywania char[]

public class PasswordVerifierGUI extends JFrame {
    private JPanel mainPanel;
    private JLabel enterPasswordLabel;
    private JPasswordField passwordField;
    private JLabel confirmPasswordLabel;
    private JPasswordField confirmPasswordField;
    private JButton okButton;

    // Stałe hasło do weryfikacji
    private static final String CORRECT_PASSWORD = "codejava";

    public PasswordVerifierGUI() {
        super("Swing JPasswordField Demo Program");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] passwordChars = passwordField.getPassword();
                char[] confirmPasswordChars = confirmPasswordField.getPassword();

                String password = new String(passwordChars);
                String confirmPassword = new String(confirmPasswordChars);

                // Sprawdzenie, czy hasła są zgodne (identyczne) w obu polach
                if (!Arrays.equals(passwordChars, confirmPasswordChars)) {
                    JOptionPane.showMessageDialog(mainPanel, "Passwords do not match!", "Message", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Hasła są identyczne, teraz sprawdź ich wartość
                    if (password.equals(CORRECT_PASSWORD)) {
                        JOptionPane.showMessageDialog(mainPanel, "Congratulations! You entered correct password.", "Message", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(mainPanel, "Wrong password!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

                // Wyczyść hasła z pamięci (dla bezpieczeństwa)
                Arrays.fill(passwordChars, ' ');
                Arrays.fill(confirmPasswordChars, ' ');
                passwordField.setText("");
                confirmPasswordField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordVerifierGUI();
            }
        });
    }
}
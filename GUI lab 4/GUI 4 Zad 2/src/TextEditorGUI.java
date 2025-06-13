import javax.swing.*;
import java.awt.*; // Importujemy Font i Color
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TextEditorGUI extends JFrame {
    private JPanel mainPanel;
    private JComboBox<String> colorComboBox;
    private JTextArea editorTextArea;
    private JButton boldButton;
    private JButton italicButton;
    private JButton decreaseFontButton;
    private JButton increaseFontButton;

    // Domyślny rozmiar czcionki
    private static final int DEFAULT_FONT_SIZE = 12;

    public TextEditorGUI() {
        super("Edytor Tekstu");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        // Ustawienia początkowe dla JTextArea
        editorTextArea.setBackground(Color.LIGHT_GRAY); // Domyślny kolor tła edytora - szary
        editorTextArea.setForeground(Color.BLACK); // Domyślny kolor tekstu - czarny
        editorTextArea.setFont(new Font("Monospaced", Font.PLAIN, DEFAULT_FONT_SIZE)); // Domyślna czcionka

        // Wypełnienie JComboBox kolorami
        colorComboBox.addItem("Czerwony");
        colorComboBox.addItem("Czarny");
        colorComboBox.addItem("Zielony");
        colorComboBox.addItem("Niebieski");
        colorComboBox.addItem("Żółty");
        colorComboBox.addItem("Fioletowy");
        colorComboBox.setSelectedItem("Czarny"); // Domyślnie zaznaczony kolor tekstu


        // Listener dla JComboBox - zmiana koloru tekstu
        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();
                switch (Objects.requireNonNull(selectedColor)) {
                    case "Czerwony":
                        editorTextArea.setForeground(Color.RED);
                        break;
                    case "Czarny":
                        editorTextArea.setForeground(Color.BLACK);
                        break;
                    case "Zielony":
                        editorTextArea.setForeground(Color.GREEN);
                        break;
                    case "Niebieski":
                        editorTextArea.setForeground(Color.BLUE);
                        break;
                    case "Żółty":
                        editorTextArea.setForeground(Color.YELLOW);
                        break;
                    case "Fioletowy":
                        editorTextArea.setForeground(new Color(128, 0, 128)); // Custom color for Violet
                        break;
                }
            }
        });

        // Listener dla przycisku "B" (Pogrubienie)
        boldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font currentFont = editorTextArea.getFont();
                int newStyle = currentFont.getStyle() ^ Font.BOLD; // Przełączanie między pogrubieniem a normalnym
                editorTextArea.setFont(currentFont.deriveFont(newStyle));
            }
        });

        // Listener dla przycisku "J" (Kursywa)
        italicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font currentFont = editorTextArea.getFont();
                int newStyle = currentFont.getStyle() ^ Font.ITALIC; // Przełączanie między kursywą a normalnym
                editorTextArea.setFont(currentFont.deriveFont(newStyle));
            }
        });

        // Listener dla przycisku "Z" (Zmniejszenie rozmiaru czcionki)
        decreaseFontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font currentFont = editorTextArea.getFont();
                int newSize = Math.max(1, currentFont.getSize() - 1); // Zabezpieczenie przed rozmiarem mniejszym niż 1
                editorTextArea.setFont(currentFont.deriveFont((float) newSize));
            }
        });

        // Listener dla przycisku "P" (Zwiększenie rozmiaru czcionki)
        increaseFontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font currentFont = editorTextArea.getFont();
                int newSize = currentFont.getSize() + 1;
                editorTextArea.setFont(currentFont.deriveFont((float) newSize));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextEditorGUI();
            }
        });
    }
}
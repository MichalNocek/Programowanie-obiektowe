import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector; // Używamy Vector dla łatwiejszego przenoszenia wielu elementów

public class ListTransferGUI extends JFrame {
    private JPanel mainPanel;
    private JList<String> list1;
    private JList<String> list2;
    private JButton moveRightButton;
    private JButton moveAllRightButton;
    private JButton moveLeftButton;
    private JButton moveAllLeftButton;
    private JLabel list1Label;
    private JLabel list2Label;
    private JScrollPane list1ScrollPane;
    private JScrollPane list2ScrollPane;

    private DefaultListModel<String> list1Model;
    private DefaultListModel<String> list2Model;

    public ListTransferGUI() {
        super("Przenoszenie Elementów Listy");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        // Inicjalizacja modeli list
        list1Model = new DefaultListModel<>();
        list2Model = new DefaultListModel<>();

        // Ustawienie modeli dla JList
        list1.setModel(list1Model);
        list2.setModel(list2Model);

        // Dodanie przykładowych danych do Listy 1
        list1Model.addElement("Element A");
        list1Model.addElement("Element B");
        list1Model.addElement("Element C");
        list1Model.addElement("Element D");
        list1Model.addElement("Element E");

        // Obsługa przycisku ">" (Przenieś zaznaczony z Listy 1 do Listy 2)
        moveRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pobranie zaznaczonych elementów z Listy 1
                java.util.List<String> selectedItems = list1.getSelectedValuesList();
                if (!selectedItems.isEmpty()) {
                    for (String item : selectedItems) {
                        list2Model.addElement(item); // Dodaj do Listy 2
                        list1Model.removeElement(item); // Usuń z Listy 1
                    }
                }
            }
        });

        // Obsługa przycisku ">>" (Przenieś wszystkie z Listy 1 do Listy 2)
        moveAllRightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Przenieś wszystkie elementy z Listy 1 do Listy 2
                while (!list1Model.isEmpty()) {
                    list2Model.addElement(list1Model.getElementAt(0));
                    list1Model.removeElementAt(0);
                }
            }
        });

        // Obsługa przycisku "<" (Przenieś zaznaczony z Listy 2 do Listy 1)
        moveLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pobranie zaznaczonych elementów z Listy 2
                java.util.List<String> selectedItems = list2.getSelectedValuesList();
                if (!selectedItems.isEmpty()) {
                    for (String item : selectedItems) {
                        list1Model.addElement(item); // Dodaj do Listy 1
                        list2Model.removeElement(item); // Usuń z Listy 2
                    }
                }
            }
        });

        // Obsługa przycisku "<<" (Przenieś wszystkie z Listy 2 do Listy 1)
        moveAllLeftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Przenieś wszystkie elementy z Listy 2 do Listy 1
                while (!list2Model.isEmpty()) {
                    list1Model.addElement(list2Model.getElementAt(0));
                    list2Model.removeElementAt(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListTransferGUI();
            }
        });
    }
}
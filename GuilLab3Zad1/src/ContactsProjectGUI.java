import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.ArrayList; // Można też użyć Map do przechowywania kontaktów, jeśli id jest ważne

public class ContactsProjectGUI extends JFrame {
    private JPanel mainPanel;
    private JList<Contact> contactList;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JTextField addressTextField;
    private JTextField dobTextField; // Format YYYY-MM-DD
    private JLabel ageValueLabel;
    private JButton saveNewButton;
    private JButton saveExistingButton;

    private DefaultListModel<Contact> contactListModel;
    private ArrayList<Contact> contactsData; // Prostsza lista do przechowywania danych

    public ContactsProjectGUI() {
        super("Contacts Project");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        // Inicjalizacja listy kontaktów i modelu
        contactListModel = new DefaultListModel<>();
        contactList.setModel(contactListModel);
        contactsData = new ArrayList<>();

        // Ustawienie początkowego stanu przycisku "Save Existing" 
        saveExistingButton.setEnabled(false); // 

        // Przykładowe dane początkowe
        addContactToList(new Contact("Jan Kowalski", "jan.kowalski@example.com", "111222333", "Warszawa, ul. Prosta 1", "1985-05-10"));
        addContactToList(new Contact("Marian Nowak", "m.nowak@example.com", "444555666", "Kraków, ul. Długa 5", "1990-11-20"));
        addContactToList(new Contact("Janina Urban", "j.urban@example.com", "777888999", "Gdańsk, ul. Morska 10", "1978-01-15"));
        addContactToList(new Contact("Ewelina Nowak-Maciag", "e.nowak@example.com", "123123123", "Wrocław, ul. Kwiatowa 2", "2000-03-25"));


        // Listener dla JList - wybór osoby
        contactList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && contactList.getSelectedValue() != null) {
                    Contact selectedContact = contactList.getSelectedValue();
                    displayContactDetails(selectedContact);
                    saveExistingButton.setEnabled(true); // Aktywacja przycisku po wybraniu kontaktu 
                } else {
                    // Jeśli nic nie wybrano lub odznaczono, wyczyść pola i deaktywuj przycisk
                    clearFields();
                    saveExistingButton.setEnabled(false); // 
                }
            }
        });

        // Listener dla przycisku "Save New"
        saveNewButton.addActionListener(new ActionListener() { // 
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    Contact newContact = new Contact(
                            nameTextField.getText(), // 
                            emailTextField.getText(), // 
                            phoneTextField.getText(), // 
                            addressTextField.getText(), // 
                            dobTextField.getText() // 
                    );
                    addContactToList(newContact);
                    clearFields();
                    JOptionPane.showMessageDialog(mainPanel, "Nowy kontakt został zapisany!", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Proszę wypełnić wszystkie pola i upewnić się, że data urodzenia jest w formacie YYYY-MM-DD.", "Błąd walidacji", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Listener dla przycisku "Save Existing"
        saveExistingButton.addActionListener(new ActionListener() { // 
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = contactList.getSelectedIndex();
                if (selectedIndex != -1 && validateFields()) {
                    Contact existingContact = contactListModel.getElementAt(selectedIndex);
                    // Aktualizacja danych istniejącego kontaktu 
                    existingContact.setName(nameTextField.getText()); // 
                    existingContact.setEmail(emailTextField.getText()); // 
                    existingContact.setPhoneNumber(phoneTextField.getText()); // 
                    existingContact.setAddress(addressTextField.getText()); // 
                    existingContact.setDateOfBirth(dobTextField.getText()); // 

                    // Odświeżenie elementu w JList, aby zmiany były widoczne
                    contactListModel.setElementAt(existingContact, selectedIndex);
                    JOptionPane.showMessageDialog(mainPanel, "Dane kontaktu zostały zaktualizowane!", "Sukces", JOptionPane.INFORMATION_MESSAGE);
                } else if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(mainPanel, "Proszę wybrać kontakt do edycji.", "Błąd", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Proszę wypełnić wszystkie pola i upewnić się, że data urodzenia jest w formacie YYYY-MM-DD.", "Błąd walidacji", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    // Metoda pomocnicza do dodawania kontaktu do listy i modelu
    private void addContactToList(Contact contact) {
        contactsData.add(contact);
        contactListModel.addElement(contact);
    }

    // Metoda pomocnicza do wyświetlania szczegółów wybranego kontaktu 
    private void displayContactDetails(Contact contact) {
        nameTextField.setText(contact.getName()); // 
        emailTextField.setText(contact.getEmail()); // 
        phoneTextField.setText(contact.getPhoneNumber()); // 
        addressTextField.setText(contact.getAddress()); // 
        dobTextField.setText(contact.getDateOfBirth()); // 

        try {
            LocalDate dob = LocalDate.parse(contact.getDateOfBirth());
            int age = Period.between(dob, LocalDate.now()).getYears();
            ageValueLabel.setText(age + " years"); // 
        } catch (DateTimeParseException ex) {
            ageValueLabel.setText("Invalid Date"); // 
        }
    }

    // Metoda pomocnicza do czyszczenia pól tekstowych 
    private void clearFields() {
        nameTextField.setText(""); // 
        emailTextField.setText(""); // 
        phoneTextField.setText(""); // 
        addressTextField.setText(""); // 
        dobTextField.setText(""); // 
        ageValueLabel.setText("0 years"); // 
    }

    // Metoda pomocnicza do walidacji pól
    private boolean validateFields() {
        if (nameTextField.getText().trim().isEmpty() || // 
                emailTextField.getText().trim().isEmpty() || //
                phoneTextField.getText().trim().isEmpty() || //
                addressTextField.getText().trim().isEmpty() || //
                dobTextField.getText().trim().isEmpty()) { //
            return false;
        }
        try {
            LocalDate.parse(dobTextField.getText());
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ContactsProjectGUI();
            }
        });
    }

    // Klasa wewnętrzna do przechowywania danych kontaktu
    private static class Contact {
        private String name;
        private String email;
        private String phoneNumber;
        private String address;
        private String dateOfBirth; // Przechowywana jako String "YYYY-MM-DD"

        public Contact(String name, String email, String phoneNumber, String address, String dateOfBirth) {
            this.name = name;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.dateOfBirth = dateOfBirth;
        }

        // Gettery 
        public String getName() { return name; } // 
        public String getEmail() { return email; } // 
        public String getPhoneNumber() { return phoneNumber; } // 
        public String getAddress() { return address; } // 
        public String getDateOfBirth() { return dateOfBirth; } // 

        // Settery 
        public void setName(String name) { this.name = name; } // 
        public void setEmail(String email) { this.email = email; } // 
        public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; } // 
        public void setAddress(String address) { this.address = address; } // 
        public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; } // 

        @Override
        public String toString() {
            return name; // Wyświetlanie tylko nazwy w JList
        }
    }
}
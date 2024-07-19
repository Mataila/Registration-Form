import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoPage extends JFrame {
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel genderLabel;
    private JLabel addressLabel;
    private JLabel contactLabel;
    private JButton registerButton;
    private JButton exitButton;
    private static int idCounter = 1;

    public UserInfoPage(String name, String gender, String address, String contact, String dob) {
        initComponents(name, gender, address, contact, dob);
    }

    private void initComponents(String name, String gender, String address, String contact, String dob) {
        idLabel = new JLabel("ID: " + idCounter++);
        nameLabel = new JLabel("Name: " + name);
        genderLabel = new JLabel("Gender: " + gender);
        addressLabel = new JLabel("Address: " + address);
        contactLabel = new JLabel("Contact: " + contact);
        exitButton = new JButton("Exit");
        registerButton = new JButton("Register");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(idLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(genderLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(addressLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(contactLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(registerButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(exitButton, gbc);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrationForm().setVisible(true);
                dispose();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        pack();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new UserInfoPage("", "", "", "", "").setVisible(true));
    }
}


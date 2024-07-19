import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationForm extends JFrame {
    private JTextField nameField;
    private JTextField mobileField;
    private JTextField dobField;
    private JTextField addressField;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JCheckBox termsCheckBox;
    private JButton submitButton;
    private JButton resetButton;
    private ButtonGroup genderGroup;

    public RegistrationForm() {
        initComponents();
    }

    private void initComponents() {
        nameField = new JTextField(20);
        mobileField = new JTextField(20);
        dobField = new JTextField(20);
        addressField = new JTextField(20);
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        termsCheckBox = new JCheckBox("Accept Terms And Conditions");
        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Mobile:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(mobileField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Gender:"), gbc);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(genderPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("DOB:"), gbc);
          
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(dobField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Address:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(addressField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(termsCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(submitButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        add(resetButton, gbc);

        submitButton.addActionListener(new SubmitButtonListener());
        resetButton.addActionListener(new ResetButtonListener());

        pack();
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String mobile = mobileField.getText();
            String gender = maleButton.isSelected() ? "Male" : (femaleButton.isSelected() ? "Female" : "");
            String dob = dobField.getText();
            String address = addressField.getText();
            boolean acceptedTerms = termsCheckBox.isSelected();

            if (name.isEmpty() || mobile.isEmpty() || gender.isEmpty() || dob.isEmpty() || address.isEmpty() || !acceptedTerms) {
                JOptionPane.showMessageDialog(null, "Please fill all fields and accept terms and conditions.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            new UserInfoPage(name, gender, address, mobile, dob).setVisible(true);
            dispose();
        }
    }

    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            nameField.setText("");
            mobileField.setText("");
            genderGroup.clearSelection();
            dobField.setText("");
            addressField.setText("");
            termsCheckBox.setSelected(false);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new RegistrationForm().setVisible(true));
    }
}


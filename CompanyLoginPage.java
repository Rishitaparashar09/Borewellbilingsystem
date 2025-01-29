
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompanyLoginPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Company Login Page");
        frame.setSize(500, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel headingLabel = new JLabel("Company Login Information");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headingLabel.setHorizontalAlignment(JLabel.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(headingLabel, gbc);
        gbc.gridwidth = 1;

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField("R&S Company", 20);

        JLabel idLabel = new JLabel("Company ID:");
        JTextField idField = new JTextField("1234", 20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        JPasswordField confirmPasswordField = new JPasswordField(20);

        passwordField.setEchoChar('*');
        confirmPasswordField.setEchoChar('*');

        addComponent(frame, gbc, 1, nameLabel, nameField);
        addComponent(frame, gbc, 2, idLabel, idField);
        addComponent(frame, gbc, 3, passwordLabel, passwordField);
        addComponent(frame, gbc, 4, confirmPasswordLabel, confirmPasswordField);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 5;
        frame.add(loginButton, gbc);

        JButton forgetPasswordButton = new JButton("Forget Password?");
        gbc.gridx = 1;
        gbc.gridy = 6;
        frame.add(forgetPasswordButton, gbc);

        JButton borewellEntryButton = new JButton("Borewell Entry and Billing Information");
        gbc.gridx = 1;
        gbc.gridy = 7;
        frame.add(borewellEntryButton, gbc);

        loginButton.addActionListener(e -> {
            String name = nameField.getText();
            String companyId = idField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (name.isEmpty() || companyId.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields.");
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(frame, "Passwords do not match. Please try again.");
            } else if (!name.equals("R&S Company") || !companyId.equals("1234") || !password.equals("454822")) {
                JOptionPane.showMessageDialog(frame, "Invalid Login. Please try again.");
            } else {
                JOptionPane.showMessageDialog(frame, "Login Successful!");
                openWelcomeWindow();
            }
        });

        forgetPasswordButton.addActionListener(e -> showForgetPasswordFrame());

        borewellEntryButton.addActionListener(e -> showBorewellAndBillingForm());

        frame.setVisible(true);
    }

    private static void addComponent(JFrame frame, GridBagConstraints gbc, int y, JLabel label, JTextField field) {
        gbc.gridx = 0;
        gbc.gridy = y;
        frame.add(label, gbc);

        gbc.gridx = 1;
        frame.add(field, gbc);
    }

    private static void showForgetPasswordFrame() {
        JFrame forgetPasswordFrame = new JFrame("Forget Password");
        forgetPasswordFrame.setSize(400, 250);
        forgetPasswordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        forgetPasswordFrame.setLayout(new GridBagLayout());
        forgetPasswordFrame.setLocationRelativeTo(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel passwordLabel = new JLabel("Enter New Password:");
        JPasswordField passwordField = new JPasswordField(15);
        JLabel confirmPasswordLabel = new JLabel("Confirm New Password:");
        JPasswordField confirmPasswordField = new JPasswordField(15);
        JButton resetPasswordButton = new JButton("Reset Password");

        gbc.gridx = 0;
        gbc.gridy = 0;
        forgetPasswordFrame.add(passwordLabel, gbc);
        gbc.gridx = 1;
        forgetPasswordFrame.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        forgetPasswordFrame.add(confirmPasswordLabel, gbc);
        gbc.gridx = 1;
        forgetPasswordFrame.add(confirmPasswordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        forgetPasswordFrame.add(resetPasswordButton, gbc);

        resetPasswordButton.addActionListener(e -> {
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(forgetPasswordFrame, "Please fill in both password fields.");
            } else if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(forgetPasswordFrame, "Passwords do not match. Please try again.");
            } else {
                JOptionPane.showMessageDialog(forgetPasswordFrame, "Password successfully reset!");
                forgetPasswordFrame.dispose();
            }
        });

        forgetPasswordFrame.setVisible(true);
    }

    private static void showBorewellAndBillingForm() {
        JFrame frame = new JFrame("Borewell Entry and Billing Information");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel headingLabel = new JLabel("Borewell and Billing Information Entry");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(headingLabel, gbc);
        gbc.gridwidth = 1;

        JLabel locationLabel = new JLabel("Location:");
        JTextField locationField = new JTextField(20);
        JLabel customerNameLabel = new JLabel("Customer Name:");
        JTextField customerNameField = new JTextField(20);
        JLabel depthLabel = new JLabel("Depth (in feet):");
        JTextField depthField = new JTextField(20);
        JLabel statusLabel = new JLabel("Borewell Status:");
        JTextField statusField = new JTextField(20);

        JLabel addressLabel = new JLabel("Address:");
        JTextField addressField = new JTextField(20);
        JLabel cityLabel = new JLabel("City:");
        JTextField cityField = new JTextField(20);
        JLabel pinLabel = new JLabel("Pin Code:");
        JTextField pinField = new JTextField(6);
        JLabel mobileLabel = new JLabel("Customer Mobile No:");
        JTextField mobileField = new JTextField(15);

        JLabel totalBillLabel = new JLabel("Total Bill: ");
        
        JTextField totalBillField = new JTextField(20);
        totalBillField.setEditable(false);

        JButton submitButton = new JButton("Submit");

        addComponent(frame, gbc, 1, locationLabel, locationField);
        addComponent(frame, gbc, 2, customerNameLabel, customerNameField);
        addComponent(frame, gbc, 3, depthLabel, depthField);
        addComponent(frame, gbc, 4, statusLabel, statusField);
        addComponent(frame, gbc, 5, addressLabel, addressField);
        addComponent(frame, gbc, 6, cityLabel, cityField);
        addComponent(frame, gbc, 7, pinLabel, pinField);
        addComponent(frame, gbc, 8, mobileLabel, mobileField);
        addComponent(frame, gbc, 9, totalBillLabel, totalBillField);

        gbc.gridx = 1;
        gbc.gridy = 10;
        frame.add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            try {
                double depth = Double.parseDouble(depthField.getText());
                double costPerFoot = 110;
                double totalBill = depth * costPerFoot;
                totalBillField.setText(String.valueOf(totalBill));

                JFrame billFrame = new JFrame("Bill Details");
                billFrame.setSize(400, 300);
                billFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                billFrame.setLocationRelativeTo(null);

                JPanel billPanel = new JPanel();
                billPanel.setLayout(new BoxLayout(billPanel, BoxLayout.Y_AXIS));
                billPanel.add(new JLabel("Customer Name: " + customerNameField.getText()));
                billPanel.add(new JLabel("Total Feet: " + depth));
                billPanel.add(new JLabel("Total Amount: ₹" + totalBill));
                billPanel.add(new JLabel("Congratulations! Your Borewell is done."));

                billFrame.add(billPanel);
                billFrame.setVisible(true);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid number for depth.");
            }
        });

        frame.setVisible(true);
    }

    private static void openWelcomeWindow() {
        JFrame welcomeFrame = new JFrame("Welcome");
        welcomeFrame.setSize(400, 200);
        welcomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        welcomeFrame.setLocationRelativeTo(null);

        JLabel welcomeLabel = new JLabel("Welcome, Borewell Company");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);

        welcomeFrame.add(welcomeLabel);
        welcomeFrame.setVisible(true);
    }
}

package LibManagement.View_Controller;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;

import LibManagement.Model.LibManagement;

public class UIRegister extends JFrame{
    public UIRegister() {
        super("Register");

        String strBackgroundPath = "a3.png";
        Image backgroundImage = Toolkit.getDefaultToolkit().getImage(strBackgroundPath);
        JPanel PanelBackground = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        PanelBackground.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(995, 650));

        JLabel labelLibMangement = new JLabel("Lib Management");
        labelLibMangement.setBounds(175, 45, 300, 26);
        labelLibMangement.setFont(new Font("Arial", Font.BOLD, 25));
        PanelBackground.add(labelLibMangement);

        JPanel PanelRegister = new JPanel();
        PanelRegister.setBounds(250, 100, 620, 500);
        PanelRegister.setBackground(Color.decode("#FFFFFF"));
        PanelRegister.setLayout(null);
        PanelBackground.add(PanelRegister);

        JLabel ImageLogo = new JLabel();
        String strLogoPath = "pictures\\ImageBackground\\LOGO 1.png";
        ImageLogo.setIcon(new ImageIcon(strLogoPath));
        Dimension size = ImageLogo.getPreferredSize();
        ImageLogo.setBounds(3, 10, size.width, size.height);
        PanelBackground.add(ImageLogo);

        JLabel LabelRegister = new JLabel("Register");
        LabelRegister.setBounds(250, 17, 110, 30);
        LabelRegister.setBackground(Color.decode("#D4FAFA"));
        LabelRegister.setFont(new Font("Arial", Font.BOLD, 25));
        LabelRegister.setForeground(Color.decode("#7C8BFF"));
        PanelRegister.add(LabelRegister);

        JLabel LabelUsername = new JLabel("Username*");
        LabelUsername.setFont(new Font("Arial", Font.PLAIN, 12));
        LabelUsername.setBackground(Color.decode("#D4FAFA"));
        LabelUsername.setBounds(14, 50, 120, 15);
        PanelRegister.add(LabelUsername);

        JTextField TextFieldUserName = new JTextField();
        TextFieldUserName.setBounds(10, 67, 260, 35);
        TextFieldUserName.setBackground(Color.decode("#F0F2E4"));
        PanelRegister.add(TextFieldUserName);

        JLabel LabelEmail = new JLabel("Email");
        LabelEmail.setFont(new Font("Arial", Font.PLAIN, 12));
        LabelEmail.setBackground(Color.decode("#D4FAFA"));
        LabelEmail.setBounds(324, 50, 120, 15);
        PanelRegister.add(LabelEmail);

        JTextField TextFieldEmail = new JTextField();
        TextFieldEmail.setBounds(320, 67, 260, 35);
        TextFieldEmail.setBackground(Color.decode("#F0F2E4"));
        PanelRegister.add(TextFieldEmail);

        JLabel LabelPassWord = new JLabel("Password*");
        LabelPassWord.setFont(new Font("Arial", Font.PLAIN, 12));
        LabelPassWord.setBackground(Color.decode("#D4FAFA"));
        LabelPassWord.setBounds(14, 108, 120, 15);
        PanelRegister.add(LabelPassWord);

        JPasswordField PasswordFieldPassWord = new JPasswordField();
        PasswordFieldPassWord.setBounds(10, 128, 260, 35);
        PasswordFieldPassWord.setBackground(Color.decode("#F0F2E4"));
        PanelRegister.add(PasswordFieldPassWord);

        JLabel LabelComfirmPassWord = new JLabel("Confirm Password*");
        LabelComfirmPassWord.setFont(new Font("Arial", Font.PLAIN, 12));
        LabelComfirmPassWord.setBackground(Color.decode("#D4FAFA"));
        LabelComfirmPassWord.setBounds(324, 108, 220, 15);
        PanelRegister.add(LabelComfirmPassWord);

        JPasswordField passwordFieldConfirmPasswordField = new JPasswordField();
        passwordFieldConfirmPasswordField.setBounds(320, 128, 260, 35);
        passwordFieldConfirmPasswordField.setBackground(Color.decode("#F0F2E4"));
        PanelRegister.add(passwordFieldConfirmPasswordField);

        JLabel LabelPhone = new JLabel("Phone Number*");
        LabelPhone.setFont(new Font("Arial", Font.PLAIN, 12));
        LabelPhone.setBackground(Color.decode("#D4FAFA"));
        LabelPhone.setBounds(14, 164, 120, 15);
        PanelRegister.add(LabelPhone);

        JTextField TextFieldPhone = new JTextField();
        TextFieldPhone.setBounds(10, 183, 260, 35);
        TextFieldPhone.setBackground(Color.decode("#F0F2E4"));
        PanelRegister.add(TextFieldPhone);

        JLabel LabelGender = new JLabel("Gender*");
        LabelGender.setFont(new Font("Arial", Font.PLAIN, 12));
        LabelGender.setBackground(Color.decode("#D4FAFA"));
        LabelGender.setBounds(324, 164, 120, 15);
        PanelRegister.add(LabelGender);

        ButtonGroup buttongroup = new ButtonGroup();
        JRadioButton RadioButtonMale = new JRadioButton("Male");
        RadioButtonMale.setBackground(Color.decode("#FFFFFF"));
        RadioButtonMale.setBounds(334, 177, 50, 40);
        RadioButtonMale.setHorizontalTextPosition(SwingConstants.CENTER);
        RadioButtonMale.setVerticalTextPosition(SwingConstants.BOTTOM);
        buttongroup.add(RadioButtonMale);
        PanelRegister.add(RadioButtonMale);

        JRadioButton RadioButtonFemale = new JRadioButton("Female");
        RadioButtonFemale.setBackground(Color.decode("#FFFFFF"));
        RadioButtonFemale.setBounds(434, 177, 52, 40);
        RadioButtonFemale.setHorizontalTextPosition(SwingConstants.CENTER);
        RadioButtonFemale.setVerticalTextPosition(SwingConstants.BOTTOM);
        buttongroup.add(RadioButtonFemale);
        PanelRegister.add(RadioButtonFemale);

        JRadioButton RadioButtonOther = new JRadioButton("Other");
        RadioButtonOther.setBackground(Color.decode("#FFFFFF"));
        RadioButtonOther.setSelected(true);
        RadioButtonOther.setBounds(534, 177, 50, 40);
        RadioButtonOther.setHorizontalTextPosition(SwingConstants.CENTER);
        RadioButtonOther.setVerticalTextPosition(SwingConstants.BOTTOM);
        buttongroup.add(RadioButtonOther);
        PanelRegister.add(RadioButtonOther);

        JLabel LabelFullName = new JLabel("Full name*");
        LabelFullName.setFont(new Font("Arial", Font.PLAIN, 12));
        LabelFullName.setBackground(Color.decode("#D4FAFA"));
        LabelFullName.setBounds(14, 220, 120, 15);
        PanelRegister.add(LabelFullName);

        JTextField TextFieldFullName = new JTextField();
        TextFieldFullName.setBounds(10, 243, 570, 35);
        TextFieldFullName.setBackground(Color.decode("#F0F2E4"));
        PanelRegister.add(TextFieldFullName);

        JLabel LabelBankAccount = new JLabel("Bank Account");
        LabelBankAccount.setFont(new Font("Arial", Font.PLAIN, 12));
        LabelBankAccount.setBackground(Color.decode("#D4FAFA"));
        LabelBankAccount.setBounds(14, 280, 120, 15);
        PanelRegister.add(LabelBankAccount);

        JTextField TextFieldBankAccount = new JTextField();
        TextFieldBankAccount.setBounds(10, 303, 260, 35);
        TextFieldBankAccount.setBackground(Color.decode("#F0F2E4"));
        PanelRegister.add(TextFieldBankAccount);

        JLabel LabelBankName = new JLabel("Bank name");
        LabelBankName.setFont(new Font("Arial", Font.PLAIN, 12));
        LabelBankName.setBackground(Color.decode("#D4FAFA"));
        LabelBankName.setBounds(324, 280, 120, 15);
        PanelRegister.add(LabelBankName);

        JTextField TextFieldBankName = new JTextField();
        TextFieldBankName.setBounds(320, 303, 260, 35);
        TextFieldBankName.setBackground(Color.decode("#F0F2E4"));
        PanelRegister.add(TextFieldBankName);

        JLabel LabelAddress = new JLabel("Address");
        LabelAddress.setFont(new Font("Arial", Font.PLAIN, 12));
        LabelAddress.setBackground(Color.decode("#D4FAFA"));
        LabelAddress.setBounds(14, 340, 120, 15);
        PanelRegister.add(LabelAddress);

        JTextField TextFieldAddress = new JTextField();
        TextFieldAddress.setBounds(10, 365, 570, 35);
        TextFieldAddress.setBackground(Color.decode("#F0F2E4"));
        PanelRegister.add(TextFieldAddress);

        JButton ButtonRegister = new JButton("Register");
        ButtonRegister.setBackground(Color.decode("#87C7F1"));
        ButtonRegister.setForeground(Color.decode("#FFFFFF"));
        ButtonRegister.setBounds(450, 420, 90, 50);
        ButtonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String strUsername = TextFieldUserName.getText();
                if (strUsername.equals("")){
                    JOptionPane.showMessageDialog(null, "Has no username!");
                    return;
                }

                String strPassword = String.valueOf(PasswordFieldPassWord.getPassword());
                if (strPassword.equals("")){
                    JOptionPane.showMessageDialog(null, "Has no password!");
                    return;
                }

                String strConfirmedPassword = String.valueOf(passwordFieldConfirmPasswordField.getPassword());
                if (!strConfirmedPassword.equals(strPassword)){
                    JOptionPane.showMessageDialog(null, "Not correct password!");
                    return;
                }

                String strPhoneNumber = TextFieldPhone.getText();
                if (strPhoneNumber.equals("")){
                    JOptionPane.showMessageDialog(null, "Has no phone number!");
                    return;
                }
                // Check if the text is not numeric
                try {
                    int num = Integer.parseInt(strPhoneNumber);
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Not correct phone number!");
                    return;
                }

                String strFullName = TextFieldFullName.getText();
                if (strFullName.equals("")){
                    JOptionPane.showMessageDialog(null, "Has no full name!");
                    return;
                }

                String strBankAccount = TextFieldBankAccount.getText();
                String strBankName = TextFieldBankName.getText();
                String strEmail = TextFieldEmail.getText();
                String strAddress = TextFieldAddress.getText();
                String strGender = RadioButtonMale.isSelected() ? "Male" : (
                                RadioButtonFemale.isSelected() ? "Female" : "Other");

                Connection connection = null;
                PreparedStatement pstmt = null;
                Statement stmt = null;
                ResultSet rs = null;

                try {
                    connection = LibManagement.connect();

                    //Check if Username existed
                    String strQuerry = "SELECT * FROM User WHERE Username = '" + strUsername + "';";
                    stmt = connection.createStatement();
                    rs = stmt.executeQuery(strQuerry);
                    
                    if (rs.next() == true){
                        JOptionPane.showMessageDialog(null, "Existed Username!");
                        try {
                            rs.close();
                        } catch (SQLException ex){
                            ex.printStackTrace();
                        }
    
                        try {
                            stmt.close();
                        } catch (SQLException ex){
                            ex.printStackTrace();
                        }

                        try {
                            connection.close();
                        } catch (SQLException ex){
                            ex.printStackTrace();
                        }

                        return;
                    }
                } catch (SQLException ex){
                    ex.printStackTrace();
                } finally {
                    try {
                        rs.close();
                    } catch (SQLException e1){
                        e1.printStackTrace();
                    }

                    try {
                        stmt.close();
                    } catch (SQLException e1){
                        e1.printStackTrace();
                    }

                    try {
                        connection.close();
                    } catch (SQLException e1){
                        e1.printStackTrace();
                    }
                }

                try {
                    connection = LibManagement.connect();
                    connection.setAutoCommit(false);

                    //Insert data into User Table
                    String strQuerry = "INSERT INTO User (Username, Password) VALUES (?, ?)";
                    pstmt = connection.prepareStatement(strQuerry);
                    pstmt.setString(1, strUsername);
                    pstmt.setString(2, strPassword);
                    pstmt.executeUpdate();

                    //Insert data into Client Table
                    strQuerry = "INSERT INTO Client (Fullname, PhoneNum, Email, Gender, Address, BankAccount, BankName, Username) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    pstmt = connection.prepareStatement(strQuerry);
                    pstmt.setString(1, strFullName);
                    pstmt.setString(2, strPhoneNumber);
                    pstmt.setString(3, strEmail);
                    pstmt.setString(4, strGender);
                    pstmt.setString(5, strAddress);
                    pstmt.setString(6, strBankAccount);
                    pstmt.setString(7, strBankName);
                    pstmt.setString(8, strUsername);
                    pstmt.executeUpdate();

                    connection.commit();  
                    
                    //Back to login
                    JOptionPane.showMessageDialog(null, "Signup Success! Back to Login");
                    LibManagement.getCurrFrame().dispose();
                    LibManagement.setFrame(new UILogin());
                    LibManagement.getCurrFrame().setVisible(true);
                } catch (SQLException ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Registration failed!");
                } finally{
                    try {
                        stmt.close();
                    } catch (SQLException ex){
                        ex.printStackTrace();
                    }

                    try {
                        pstmt.close();
                    } catch (SQLException ex){
                        ex.printStackTrace();
                    }

                    try {
                        connection.close();
                    } catch (SQLException ex){
                        ex.printStackTrace();
                    }
                }
            }
        });
        PanelRegister.add(ButtonRegister);

        JButton ButtonBackToLogin = new JButton("Back to login");
        ButtonBackToLogin.setBackground(Color.decode("#87C7F1"));
        ButtonBackToLogin.setForeground(Color.decode("#FFFFFF"));
        ButtonBackToLogin.setBounds(110, 420, 130, 50);
        ButtonBackToLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UILogin());
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelRegister.add(ButtonBackToLogin);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null);
    }
}

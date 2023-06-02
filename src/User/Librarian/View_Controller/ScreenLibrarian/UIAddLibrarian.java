package User.Librarian.View_Controller.ScreenLibrarian;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import LibManagement.Model.LibManagement;
import User.User.*;
import User.Librarian.View_Controller.ScreenBook.UIListBooks;
import User.Librarian.View_Controller.ScreenClient.UIListClients;
import User.Librarian.View_Controller.ScreenDashboard.UIDashboard;
import User.Librarian.View_Controller.ScreenPrivateInfo.UIShowInfos;
import User.Librarian.View_Controller.ScreenStatistic.*;

public class UIAddLibrarian extends JFrame{
    private User currUser;

    public UIAddLibrarian(User user) {
        super("Add Librarians");
        this.currUser = user;

        Image backgroundImage = Toolkit.getDefaultToolkit().getImage("pictures\\ImageBackground\\a6.png");
        JPanel PanelBackground = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        PanelBackground.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1280, 720));

        JLabel labelLibMangement = new JLabel("Lib Management");
        labelLibMangement.setBounds(170, 45, 260, 26);
        labelLibMangement.setFont(new Font("Arial", Font.BOLD, 25));
        PanelBackground.add(labelLibMangement);

        JLabel ImageLogo = new JLabel();
        ImageLogo.setIcon(new ImageIcon("pictures\\ImageBackground\\LOGO 1.png"));
        Dimension size = ImageLogo.getPreferredSize();
        ImageLogo.setBounds(0, 5, size.width, size.height);
        PanelBackground.add(ImageLogo);

        ImageIcon IconDashboard = new ImageIcon("pictures\\ImageBackground\\LOGO_Dashboard.png");
        JButton ButtonDashboard = new JButton("Dashboard", IconDashboard);
        ButtonDashboard.setHorizontalTextPosition(SwingConstants.RIGHT);
        ButtonDashboard.setIconTextGap(10);
        ButtonDashboard.setHorizontalAlignment(JButton.LEFT);
        ButtonDashboard.setBounds(0, 190, 190, 40);
        ButtonDashboard.setBackground(Color.decode("#F4FAFB"));
        ButtonDashboard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIDashboard(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonDashboard);

        ImageIcon IconBook = new ImageIcon("pictures\\ImageBackground\\LOGO_Book.png");
        JButton ButtonBook = new JButton("Book", IconBook);
        ButtonBook.setHorizontalTextPosition(SwingConstants.RIGHT);
        ButtonBook.setIconTextGap(10);
        ButtonBook.setHorizontalAlignment(JButton.LEFT);
        ButtonBook.setBounds(0, 230, 190, 40);
        ButtonBook.setBackground(Color.decode("#F4FAFB"));
        ButtonBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIListBooks(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonBook);

        ImageIcon IconClient = new ImageIcon("pictures\\ImageBackground\\LOGO_User.png");
        JButton ButtonClient = new JButton("Client", IconClient);
        ButtonClient.setHorizontalTextPosition(SwingConstants.RIGHT);
        ButtonClient.setIconTextGap(10);
        ButtonClient.setHorizontalAlignment(JButton.LEFT);
        ButtonClient.setBounds(0, 270, 190, 40);
        ButtonClient.setBackground(Color.decode("#F4FAFB"));
        ButtonClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIListClients(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonClient);

        ImageIcon IconLibrarian = new ImageIcon("pictures\\ImageBackground\\LOGO_User.png");
        JLabel LabelLibrarian = new JLabel("Librarian", IconLibrarian, JLabel.LEFT);
        LabelLibrarian.setHorizontalTextPosition(SwingConstants.RIGHT);
        LabelLibrarian.setIconTextGap(10);
        LabelLibrarian.setBounds(0, 310, 190, 40);
        LabelLibrarian.setBackground(Color.decode("#A1E7FF"));
        LabelLibrarian.setForeground(Color.decode("#FFF8F7"));
        LabelLibrarian.setOpaque(true);
        PanelBackground.add(LabelLibrarian);

        ImageIcon IconStatistic = new ImageIcon("pictures\\ImageBackground\\LOGO_Payment.png");
        JButton ButtonStatistic = new JButton("Statistic", IconStatistic);
        ButtonStatistic.setHorizontalTextPosition(SwingConstants.RIGHT);
        ButtonStatistic.setIconTextGap(10);
        ButtonStatistic.setHorizontalAlignment(JButton.LEFT);
        ButtonStatistic.setBounds(0, 350, 190, 40);
        ButtonStatistic.setBackground(Color.decode("#F4FAFB"));
        ButtonStatistic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIRevenueStatistic(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonStatistic);

        ImageIcon IconSetting = new ImageIcon("pictures\\ImageBackground\\LOGO_Setting.png");
        JButton ButtonLogout = new JButton("Log out", IconSetting);
        ButtonLogout.setHorizontalTextPosition(SwingConstants.RIGHT);
        ButtonLogout.setIconTextGap(10);
        ButtonLogout.setHorizontalAlignment(JButton.LEFT);
        ButtonLogout.setBounds(0, 572, 190, 40);
        ButtonLogout.setBackground(Color.decode("#F4FAFB"));
        ButtonLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement lib = new LibManagement();
            }
        });
        PanelBackground.add(ButtonLogout);

        JButton ButtonPrivateInfo = new JButton(currUser.getID());
        ButtonPrivateInfo.setFont(new Font("Arial", Font.BOLD, 15));
        ButtonPrivateInfo.setBackground(Color.decode("#FFFFFF"));
        ButtonPrivateInfo.setBounds(1090, 20, 90, 30);
        ButtonPrivateInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIShowInfos(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonPrivateInfo);

        //Create blanks to fill in
        JPanel PanelRegister = new JPanel();
        PanelRegister.setBounds(330, 100, 620, 500);
        PanelRegister.setBackground(Color.decode("#FFFFFF"));
        PanelRegister.setLayout(null);
        PanelBackground.add(PanelRegister);

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

        JLabel LabelEmail = new JLabel("Email*");
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

        JLabel LabelDepartment = new JLabel("Department*");
        LabelDepartment.setFont(new Font("Arial", Font.PLAIN, 12));
        LabelDepartment.setBackground(Color.decode("#D4FAFA"));
        LabelDepartment.setBounds(14, 280, 120, 15);
        PanelRegister.add(LabelDepartment);

        String arrString[] = {"", "A", "B", "C", "D"};
        JComboBox ComboBoxDepartment = new JComboBox(arrString);
        ComboBoxDepartment.setFont(new Font("Arial", Font.PLAIN, 30));
        ComboBoxDepartment.setBounds(135, 280, 50, 33);
        ComboBoxDepartment.setBackground(Color.decode("#FFFAF0"));
        PanelRegister.add(ComboBoxDepartment);

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

                String strDepartment = ComboBoxDepartment.getSelectedItem() + "";
                if (strDepartment.equals("")){
                    JOptionPane.showMessageDialog(null, "Has no department!");
                    return;
                }

                String strEmail = TextFieldEmail.getText();
                if (strEmail.equals("")){
                    JOptionPane.showMessageDialog(null, "Has no email!");
                    return;
                }

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
                    String strQuerry = "INSERT INTO User VALUES (?, ?, ?)";
                    pstmt = connection.prepareStatement(strQuerry);
                    pstmt.setString(1, strUsername);
                    pstmt.setString(2, strPassword);
                    pstmt.setInt(3, 0); //0 is a signal of librarian, 1 is a signal of client
                    pstmt.executeUpdate();

                    //Insert data into Client Table
                    strQuerry = "INSERT INTO Librarian (Fullname, PhoneNum, Email, Gender, Department, Username) " +
                                "VALUES (?, ?, ?, ?, ?, ?)";
                    pstmt = connection.prepareStatement(strQuerry);
                    pstmt.setString(1, strFullName);
                    pstmt.setString(2, strPhoneNumber);
                    pstmt.setString(3, strEmail);
                    pstmt.setString(4, strGender);
                    pstmt.setString(5, strDepartment);
                    pstmt.setString(6, strUsername);
                    pstmt.executeUpdate();

                    connection.commit();  
                    
                    //Show a notification
                    JOptionPane.showMessageDialog(null, "Signup Success!");

                    //Clear form
                    TextFieldUserName.setText("");
                    PasswordFieldPassWord.setText("");
                    passwordFieldConfirmPasswordField.setText("");
                    TextFieldFullName.setText("");
                    TextFieldEmail.setText("");
                    TextFieldPhone.setText("");
                    ComboBoxDepartment.setSelectedIndex(0);
                    RadioButtonOther.setSelected(true);
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

        JButton ButtonBack = new JButton("Back");
        ButtonBack.setBackground(Color.decode("#87C7F1"));
        ButtonBack.setForeground(Color.decode("#FFFFFF"));
        ButtonBack.setBounds(50, 420, 90, 50);
        ButtonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UILibrarian(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelRegister.add(ButtonBack);
        PanelBackground.add(PanelRegister);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }
}

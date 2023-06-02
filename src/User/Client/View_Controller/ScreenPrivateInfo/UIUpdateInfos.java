package User.Client.View_Controller.ScreenPrivateInfo;

import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

import Book.Book;
import LibManagement.Model.LibManagement;
import User.User.*;
import User.Client.Model.*;
import User.Client.View_Controller.ScreenCart.UICart;
import User.Client.View_Controller.ScreenDashboard.UIDashboard;
import User.Client.View_Controller.ScreenHistoryTransaction.UIHistory;
import User.Client.View_Controller.ScreenInteresting.UIInteresting;

public class UIUpdateInfos extends JFrame{
    private User currUser;

    public UIUpdateInfos(User user) {
        super("Update Infomation");
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
        JButton ButtonHistory = new JButton("History", IconBook);
        ButtonHistory.setHorizontalTextPosition(SwingConstants.RIGHT);
        ButtonHistory.setIconTextGap(10);
        ButtonHistory.setHorizontalAlignment(JButton.LEFT);
        ButtonHistory.setBounds(0, 230, 190, 40);
        ButtonHistory.setBackground(Color.decode("#F4FAFB"));
        ButtonHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIHistory(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonHistory);

        ImageIcon IconUser = new ImageIcon("pictures\\ImageBackground\\LOGO_User.png");
        JButton ButtonInteresting = new JButton("Interesting", IconUser);
        ButtonInteresting.setHorizontalTextPosition(SwingConstants.RIGHT);
        ButtonInteresting.setIconTextGap(10);
        ButtonInteresting.setHorizontalAlignment(JButton.LEFT);
        ButtonInteresting.setBounds(0, 271, 190, 40);
        ButtonInteresting.setBackground(Color.decode("#F4FAFB"));
        ButtonInteresting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIInteresting(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonInteresting);

        ImageIcon IconPayment = new ImageIcon("pictures\\ImageBackground\\LOGO_Payment.png");
        JButton ButtonCart = new JButton("Cart", IconPayment);
        ButtonCart.setHorizontalTextPosition(SwingConstants.RIGHT);
        ButtonCart.setIconTextGap(10);
        ButtonCart.setHorizontalAlignment(JButton.LEFT);
        ButtonCart.setBounds(0, 311, 190, 40);
        ButtonCart.setBackground(Color.decode("#F4FAFB"));
        ButtonCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UICart(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonCart);

        JLabel LabelClient = new JLabel(this.currUser.getID(), SwingConstants.CENTER);
        LabelClient.setFont(new Font("Arial", Font.BOLD, 15));
        LabelClient.setBackground(Color.decode("#A1E7FF"));
        LabelClient.setForeground(Color.decode("#FFF8F7"));
        LabelClient.setBounds(1090, 20, 90, 30);
        LabelClient.setOpaque(true);
        PanelBackground.add(LabelClient);

        ImageIcon IconSetting = new ImageIcon("pictures\\ImageBackground\\LOGO_Setting.png");
        JButton ButtonLogOut = new JButton("Log out", IconSetting);
        ButtonLogOut.setHorizontalTextPosition(SwingConstants.RIGHT);
        ButtonLogOut.setIconTextGap(10);
        ButtonLogOut.setHorizontalAlignment(JButton.LEFT);
        ButtonLogOut.setBounds(0, 572, 190, 40);
        ButtonLogOut.setBackground(Color.decode("#F4FAFB"));
        ButtonLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement lib = new LibManagement();
            }
        });
        PanelBackground.add(ButtonLogOut);

        //Update Infos
        JLabel LabelUpdateUser = new JLabel("UPDATE USER");
        LabelUpdateUser.setBounds(458, 77, 570, 70);
        LabelUpdateUser.setBackground(Color.decode("#FFFFFF"));
        LabelUpdateUser.setForeground(Color.decode("#7C8BFF"));
        LabelUpdateUser.setFont(new Font("Arial", Font.BOLD, 30));
        LabelUpdateUser.setHorizontalAlignment(JLabel.CENTER);
        LabelUpdateUser.setOpaque(true);
        PanelBackground.add(LabelUpdateUser);

        JPanel PanelUpdate = new JPanel();
        PanelUpdate.setBounds(458, 152, 570, 412);
        PanelUpdate.setBackground(Color.decode("#FFFFFF"));
        PanelUpdate.setLayout(null);
        PanelBackground.add(PanelUpdate);

        JLabel LabelFullname  = new JLabel("Full Name");
        LabelFullname.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelFullname.setBounds(18, 16, 100, 17);
        PanelUpdate.add(LabelFullname);

        JTextField TextFieldFullname = new JTextField();
        TextFieldFullname.setFont(new Font("Arial", Font.PLAIN, 30));
        TextFieldFullname.setBounds(127, 12, 370, 33);
        TextFieldFullname.setBackground(Color.decode("#FFFAF0"));
        PanelUpdate.add(TextFieldFullname);

        JLabel LabelGender = new JLabel("Gender");
        LabelGender.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelGender.setBounds(18, 67, 100, 17);
        PanelUpdate.add(LabelGender);

        ButtonGroup buttongroup = new ButtonGroup();
        JRadioButton RadioButtonMale = new JRadioButton("Male");
        RadioButtonMale.setBackground(Color.decode("#FFFFFF"));
        RadioButtonMale.setSelected(this.currUser.getGender().equals("Male"));
        RadioButtonMale.setBounds(195, 65, 50, 40);
        RadioButtonMale.setHorizontalTextPosition(SwingConstants.CENTER);
        RadioButtonMale.setVerticalTextPosition(SwingConstants.BOTTOM);
        buttongroup.add(RadioButtonMale);
        PanelUpdate.add(RadioButtonMale);

        JRadioButton RadioButtonFemale = new JRadioButton("Female");
        RadioButtonFemale.setBackground(Color.decode("#FFFFFF"));
        RadioButtonFemale.setSelected(this.currUser.getGender().equals("Female"));
        RadioButtonFemale.setBounds(296, 65, 52, 40);
        RadioButtonFemale.setHorizontalTextPosition(SwingConstants.CENTER);
        RadioButtonFemale.setVerticalTextPosition(SwingConstants.BOTTOM);
        buttongroup.add(RadioButtonFemale);
        PanelUpdate.add(RadioButtonFemale);

        JRadioButton RadioButtonOther = new JRadioButton("Other");
        RadioButtonOther.setBackground(Color.decode("#FFFFFF"));
        RadioButtonOther.setSelected(this.currUser.getGender().equals("Other"));
        RadioButtonOther.setBounds(396, 65, 50, 40);
        RadioButtonOther.setHorizontalTextPosition(SwingConstants.CENTER);
        RadioButtonOther.setVerticalTextPosition(SwingConstants.BOTTOM);
        buttongroup.add(RadioButtonOther);
        PanelUpdate.add(RadioButtonOther);

        JLabel LabelPhone = new JLabel("Phone Number");
        LabelPhone.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelPhone.setBounds(18, 125, 110, 33);
        PanelUpdate.add(LabelPhone);

        JTextField TextFieldPhone = new JTextField();
        TextFieldPhone.setFont(new Font("Arial", Font.PLAIN, 30));
        TextFieldPhone.setBounds(130, 125, 370, 33);
        TextFieldPhone.setBackground(Color.decode("#FFFAF0"));
        PanelUpdate.add(TextFieldPhone);

        JLabel LabelEmail = new JLabel("Email");
        LabelEmail.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelEmail.setBounds(18, 180, 100, 33);
        PanelUpdate.add(LabelEmail);

        JTextField TextFieldEmail = new JTextField();
        TextFieldEmail.setFont(new Font("Arial", Font.PLAIN, 30));
        TextFieldEmail.setBounds(130, 180, 370, 33);
        TextFieldEmail.setBackground(Color.decode("#FFFAF0"));
        PanelUpdate.add(TextFieldEmail);

        JLabel LabelAddress = new JLabel("Address");
        LabelAddress.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelAddress.setBounds(18, 237, 100, 33);
        PanelUpdate.add(LabelAddress);

        JTextField TextFieldAddress = new JTextField();
        TextFieldAddress.setFont(new Font("Arial", Font.PLAIN, 30));
        TextFieldAddress.setBounds(130, 237, 370, 33);
        TextFieldAddress.setBackground(Color.decode("#FFFAF0"));
        PanelUpdate.add(TextFieldAddress);

        JLabel LabelBankAccount = new JLabel("Bank Account");
        LabelBankAccount.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelBankAccount.setBounds(18, 287, 105, 33);
        PanelUpdate.add(LabelBankAccount);

        JTextField TextfieldBankAccount = new JTextField();
        TextfieldBankAccount.setFont(new Font("Arial", Font.PLAIN, 30));
        TextfieldBankAccount.setBounds(130, 287, 370, 33);
        TextfieldBankAccount.setBackground(Color.decode("#FFFAF0"));
        PanelUpdate.add(TextfieldBankAccount);

        JLabel LabelBankName = new JLabel("Bank Name");
        LabelBankName.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelBankName.setBounds(18, 344, 100, 17);
        PanelUpdate.add(LabelBankName);

        JTextField TextFieldBankName = new JTextField();
        TextFieldBankName.setFont(new Font("Arial", Font.PLAIN, 30));
        TextFieldBankName.setBounds(130, 340, 370, 33);
        TextFieldBankName.setBackground(Color.decode("#FFFAF0"));
        PanelUpdate.add(TextFieldBankName);

        JButton ButtonChange = new JButton("Change");
        ButtonChange.setBounds(900, 570, 100, 40);
        ButtonChange.setBackground(Color.decode("#85BEF9"));
        ButtonChange.setForeground(Color.decode("#F8ECBD"));
        ButtonChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Update infos of user
                Connection connection = null;
                Statement stmt = null;

                try {
                    connection = LibManagement.connect();
                    connection.setAutoCommit(false);
                    stmt = connection.createStatement();

                    String strID = currUser.getID();

                    String strPhoneNumber = TextFieldPhone.getText();
                    if (!strPhoneNumber.equals("")){ //If filling in phone number
                        try {
                            int num = Integer.parseInt(strPhoneNumber);

                            String strQuerry = "UPDATE CLIENT SET PhoneNum = '" + strPhoneNumber + "' WHERE CID = '" + strID + "';";
                            stmt.executeUpdate(strQuerry);
                        } catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(null, "Not correct phone number!");
                            return;
                        }
                    }

                    String strFullName = TextFieldFullname.getText();
                    if (!strFullName.equals("")){ //If filling in full name
                        String strQuerry = "UPDATE CLIENT SET Fullname = '" + strFullName + "' WHERE CID = '" + strID + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    String strGender = RadioButtonMale.isSelected() ? "Male" : (RadioButtonFemale.isSelected() ? "Female" : "Other");
                    if (!strGender.equals("")){ //If filling in gender
                        String strQuerry = "UPDATE CLIENT SET Gender = '" + strGender + "' WHERE CID = '" + strID + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    String strEmail = TextFieldEmail.getText();
                    if (!strEmail.equals("")){ //If filling in email
                        String strQuerry = "UPDATE CLIENT SET Email = '" + strEmail + "' WHERE CID = '" + strID + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    String strAddress = TextFieldAddress.getText();
                    if (!strAddress.equals("")){ //If filling in address
                        String strQuerry = "UPDATE CLIENT SET Address = '" + strAddress + "' WHERE CID = '" + strID + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    String strBankAccount = TextfieldBankAccount.getText();
                    if (!strBankAccount.equals("")){ //If filling in bank account
                        String strQuerry = "UPDATE CLIENT SET BankAccount = '" + strBankAccount + "' WHERE CID = '" + strID + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    String strBankName = TextFieldBankName.getText();
                    if (!strBankName.equals("")){ //If filling in bank name
                        String strQuerry = "UPDATE CLIENT SET BankName = '" + strBankName + "' WHERE CID = '" + strID + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    connection.commit();
                } catch (SQLException ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                    ex.printStackTrace();
                } catch (Exception ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                    ex.printStackTrace();
                } finally {
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
                }

                //Set this user to a new user
                ResultSet resultSet = null;
                try {
                    connection = LibManagement.connect();
                    stmt = connection.createStatement();

                    String strQuery = "SELECT * FROM CLIENT WHERE CID = '" + currUser.getID() + "';";
                    resultSet = stmt.executeQuery(strQuery);
                    resultSet.next();

                    //Get infos from database
                    String strID = resultSet.getString(1);
                    String strFullname = resultSet.getString(2);
                    String strPhoneNum = resultSet.getString(3);
                    String strEmail = resultSet.getString(4);
                    String strGender = resultSet.getString(5);
                    String strAddress = resultSet.getString(6);
                    String strBankAccount = resultSet.getString(7);
                    String strBankName = resultSet.getString(8);
                    java.util.Date dateCreatedDate = new java.util.Date(resultSet.getDate(9).getTime());

                    currUser = new Client(strID, strFullname, strPhoneNum, strEmail, strGender, dateCreatedDate,
                                        strAddress, strBankAccount, strBankName);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        resultSet.close();
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
                }

                JOptionPane.showMessageDialog(null, "Update Success! Back to see your changed infos");
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIShowInfos(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonChange);

        JButton ButtonBackToUser = new JButton("Back");
        ButtonBackToUser.setBounds(480, 570, 100, 40);
        ButtonBackToUser.setBackground(Color.decode("#85BEF9"));
        ButtonBackToUser.setForeground(Color.decode("#F8ECBD"));
        ButtonBackToUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIShowInfos(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonBackToUser);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }
}

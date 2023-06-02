package User.Librarian.View_Controller.ScreenPrivateInfo;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

import LibManagement.Model.LibManagement;
import User.User.*;
import User.Librarian.Model.*;
import User.Librarian.View_Controller.ScreenBook.UIListBooks;
import User.Librarian.View_Controller.ScreenClient.UIListClients;
import User.Librarian.View_Controller.ScreenDashboard.UIDashboard;
import User.Librarian.View_Controller.ScreenLibrarian.UILibrarian;
import User.Librarian.View_Controller.ScreenStatistic.*;

public class UIUpdateInfos extends JFrame{
    private User currUser;

    public UIUpdateInfos(User user) {
        super("Update Information");
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
        JButton ButtonLibrarian = new JButton("Librarian", IconLibrarian);
        ButtonLibrarian.setHorizontalTextPosition(SwingConstants.RIGHT);
        ButtonLibrarian.setIconTextGap(10);
        ButtonLibrarian.setHorizontalAlignment(JButton.LEFT);
        ButtonLibrarian.setBounds(0, 310, 190, 40);
        ButtonLibrarian.setBackground(Color.decode("#F4FAFB"));
        ButtonLibrarian.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UILibrarian(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonLibrarian);

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

        JLabel LabelPrivateInfo = new JLabel(currUser.getID(), JLabel.CENTER);
        LabelPrivateInfo.setHorizontalTextPosition(SwingConstants.RIGHT);
        LabelPrivateInfo.setIconTextGap(10);
        LabelPrivateInfo.setBounds(1090, 20, 90, 30);
        LabelPrivateInfo.setBackground(Color.decode("#A1E7FF"));
        LabelPrivateInfo.setForeground(Color.decode("#FFF8F7"));
        LabelPrivateInfo.setOpaque(true);
        PanelBackground.add(LabelPrivateInfo);

        //Update Infos
        JLabel LabelUpdateUser = new JLabel("UPDATE LIBRARIAN");
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
        TextFieldFullname.setBounds(130, 16, 370, 33);
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

        JLabel LabelDepartment = new JLabel("Department");
        LabelDepartment.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelDepartment.setBounds(18, 237, 100, 33);
        PanelUpdate.add(LabelDepartment);

        Character arrChar[] = {'A', 'B', 'C', 'D'};
        JComboBox ComboBoxDepartment = new JComboBox(arrChar);
        ComboBoxDepartment.setFont(new Font("Arial", Font.PLAIN, 30));
        ComboBoxDepartment.setBounds(130, 237, 50, 33);
        ComboBoxDepartment.setBackground(Color.decode("#FFFAF0"));
        char currDepartmentOfLibrarian = ((Librarian)currUser).getDepartment().charAt(0);
        ComboBoxDepartment.setSelectedIndex((int)(currDepartmentOfLibrarian - 'A'));
        PanelUpdate.add(ComboBoxDepartment);

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

                            String strQuerry = "UPDATE LIBRARIAN SET PhoneNum = '" + strPhoneNumber + "' WHERE LID = '" + strID + "';";
                            stmt.executeUpdate(strQuerry);
                        } catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(null, "Not correct phone number!");
                            return;
                        }
                    }

                    String strFullName = TextFieldFullname.getText();
                    if (!strFullName.equals("")){ //If filling in full name
                        String strQuerry = "UPDATE LIBRARIAN SET Fullname = '" + strFullName + "' WHERE LID = '" + strID + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    String strGender = RadioButtonMale.isSelected() ? "Male" : (RadioButtonFemale.isSelected() ? "Female" : "Other");
                    if (!strGender.equals("")){ //If filling in gender
                        String strQuerry = "UPDATE LIBRARIAN SET Gender = '" + strGender + "' WHERE LID = '" + strID + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    String strEmail = TextFieldEmail.getText();
                    if (!strEmail.equals("")){ //If filling in email
                        String strQuerry = "UPDATE LIBRARIAN SET Email = '" + strEmail + "' WHERE LID = '" + strID + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    int iSelectedDepartment = ComboBoxDepartment.getSelectedIndex();
                    String strDepartment = "" + ((char)('A' + iSelectedDepartment));
                    if (!strDepartment.equals("")){ //If filling in department
                        String strQuerry = "UPDATE LIBRARIAN SET Department = '" + strDepartment + "' WHERE LID = '" + strID + "';";
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

                    String strQuery = "SELECT * FROM LIBRARIAN WHERE LID = '" + currUser.getID() + "';";
                    resultSet = stmt.executeQuery(strQuery);
                    resultSet.next();

                    //Get infos from database
                    String strID = resultSet.getString("LID");
                    String strFullname = resultSet.getString("Fullname");
                    String strPhoneNum = resultSet.getString("PhoneNum");
                    String strEmail = resultSet.getString("Email");
                    String strGender = resultSet.getString("Gender");
                    String strDepartment = resultSet.getString("Department");
                    java.util.Date dateCreatedDate = new java.util.Date(resultSet.getDate("CreatedDate").getTime());

                    currUser = new Librarian(strID, strFullname, strPhoneNum, strEmail, strGender, dateCreatedDate, strDepartment);

                    JOptionPane.showMessageDialog(null, "Update Success! Back to see your changed infos");
                    LibManagement.getCurrFrame().dispose();
                    LibManagement.setFrame(new UIShowInfos(currUser));
                    LibManagement.getCurrFrame().setVisible(true);
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

package User.Librarian.View_Controller.ScreenClient;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

import LibManagement.Model.LibManagement;
import User.User.*;
import User.Librarian.View_Controller.ScreenBook.UIListBooks;
import User.Librarian.View_Controller.ScreenDashboard.UIDashboard;
import User.Librarian.View_Controller.ScreenLibrarian.UILibrarian;
import User.Librarian.View_Controller.ScreenPrivateInfo.UIShowInfos;
import User.Librarian.View_Controller.ScreenStatistic.*;

public class UIAccountOf extends JFrame{
    private User currUser;
    private User currClient;

    public UIAccountOf(User user, User selectedClient) {
        super("Info Account of Client");
        this.currUser = user;
        this.currClient = selectedClient;

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
        JLabel LabelClient = new JLabel("Client", IconClient, JLabel.LEFT);
        LabelClient.setHorizontalTextPosition(SwingConstants.RIGHT);
        LabelClient.setIconTextGap(10);
        LabelClient.setBounds(0, 270, 190, 40);
        LabelClient.setBackground(Color.decode("#A1E7FF"));
        LabelClient.setForeground(Color.decode("#FFF8F7"));
        LabelClient.setOpaque(true);
        PanelBackground.add(LabelClient);

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

        //Account of client

        JLabel LabelInfoAccount = new JLabel("Info Account of " + currClient.getID());
        LabelInfoAccount.setBounds(480, 82, 450, 70);
        LabelInfoAccount.setBackground(Color.decode("#FFFFFF"));
        LabelInfoAccount.setFont(new Font("Arial", Font.BOLD, 30));
        LabelInfoAccount.setHorizontalAlignment(JLabel.CENTER);
        LabelInfoAccount.setOpaque(true);
        PanelBackground.add(LabelInfoAccount);

        int iPosX = 500, iWidthSize = 200, iHeightSize = 25, iFontSize = 20;

        JLabel LabelUsername = new JLabel("[Username]:");
        LabelUsername.setBounds(iPosX, 179, iWidthSize, iHeightSize);
        LabelUsername.setFont(new Font("Arial", Font.BOLD, iFontSize));
        PanelBackground.add(LabelUsername);

        JLabel LabelShowUsername = new JLabel("");
        LabelShowUsername.setBounds(705, 179, iWidthSize, iHeightSize);
        LabelShowUsername.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelShowUsername);

        JLabel LabelCurrentPassword = new JLabel("[Password]:");
        LabelCurrentPassword.setBounds(iPosX, 229, iWidthSize, iHeightSize);
        LabelCurrentPassword.setFont(new Font("Arial", Font.BOLD, iFontSize));
        PanelBackground.add(LabelCurrentPassword);

        JLabel LabelShowCurrentPassword = new JLabel("*****");
        LabelShowCurrentPassword.setBounds(705, 229, iWidthSize, iHeightSize);
        LabelShowCurrentPassword.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelShowCurrentPassword);

        //Get username of client
        if (true) {
            Connection connection = null;
            Statement stmt = null;
            ResultSet resultSet = null;

            try {
                connection = LibManagement.connect();
                stmt = connection.createStatement();
                
                String strQuerry = "SELECT Username FROM CLIENT " +
                                    "WHERE CID = '" + currClient.getID() + "';";
                resultSet = stmt.executeQuery(strQuerry);
                
                while (resultSet.next()) {
                    String strUsername = resultSet.getString("Username");
                    LabelShowUsername.setText(strUsername);
                }
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

        JButton ButtonViewOrHidePassword = new JButton("View");
        ButtonViewOrHidePassword.setBounds(395, 225, 100, 40);
        ButtonViewOrHidePassword.setBackground(Color.decode("#85BEF9"));
        ButtonViewOrHidePassword.setForeground(Color.decode("#F8ECBD"));
        ButtonViewOrHidePassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ButtonViewOrHidePassword.getText().equals("Hide")) {
                    LabelShowCurrentPassword.setText("*****");
                    ButtonViewOrHidePassword.setText("View");
                } else { //Get password of client when pressing View button
                    String strSeePassword = "*****";
                    Connection connection = null;
                    Statement stmt = null;
                    ResultSet resultSet = null;

                    try {
                        connection = LibManagement.connect();
                        stmt = connection.createStatement();
                        
                        String strQuerry = "SELECT Password FROM USER u JOIN CLIENT c ON u.Username = c.Username " +
                                            "WHERE c.CID = '" + currClient.getID() + "';";
                        resultSet = stmt.executeQuery(strQuerry);
                        
                        while (resultSet.next()) {
                            strSeePassword = resultSet.getString("Password");
                        }
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

                    LabelShowCurrentPassword.setText(strSeePassword);
                    ButtonViewOrHidePassword.setText("Hide");
                }
            }
        });
        PanelBackground.add(ButtonViewOrHidePassword);

        //Change password of client
        JPanel PanelChangePassword = new JPanel();
        PanelChangePassword.setLayout(null);
        PanelChangePassword.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
        PanelChangePassword.setBorder(BorderFactory.createTitledBorder("Change Password"));
        PanelChangePassword.setBounds(480, 329, 450, 200);
        PanelBackground.add(PanelChangePassword);

        JLabel LabelNewPassword = new JLabel("New Password(*)");
        LabelNewPassword.setFont(new Font("Arial", Font.BOLD, 15));
        LabelNewPassword.setBounds(20, 40, 175, 33);
        PanelChangePassword.add(LabelNewPassword);

        JPasswordField PasswordFiledNewPassword = new JPasswordField();
        PasswordFiledNewPassword.setFont(new Font("Arial", Font.PLAIN, 30));
        PasswordFiledNewPassword.setBounds(200, 40, 200, 33);
        PasswordFiledNewPassword.setBackground(Color.decode("#FFFAF0"));
        PanelChangePassword.add(PasswordFiledNewPassword);

        JLabel LabelConfirmPassword = new JLabel("Confirm Password(*)");
        LabelConfirmPassword.setFont(new Font("Arial", Font.BOLD, 15));
        LabelConfirmPassword.setBounds(20, 85, 175, 33);
        PanelChangePassword.add(LabelConfirmPassword);

        JPasswordField PasswordFieldConfirmPassword = new JPasswordField();
        PasswordFieldConfirmPassword.setFont(new Font("Arial", Font.PLAIN, 30));
        PasswordFieldConfirmPassword.setBounds(200, 85, 200, 33);
        PasswordFieldConfirmPassword.setBackground(Color.decode("#FFFAF0"));
        PanelChangePassword.add(PasswordFieldConfirmPassword);

        JButton ButtonSubmit = new JButton("Submit");
        ButtonSubmit.setBounds(250, 140, 100, 30);
        ButtonSubmit.setBackground(Color.decode("#85BEF9"));
        ButtonSubmit.setForeground(Color.decode("#F8ECBD"));
        ButtonSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strNewPassword = String.valueOf(PasswordFiledNewPassword.getPassword());
                String strConfirmPassword = String.valueOf(PasswordFieldConfirmPassword.getPassword());

                if (strNewPassword.equals("") || strConfirmPassword.equals("")) {
                    JOptionPane.showMessageDialog(null, "Do not have any empty fields");
                    return;
                }

                //Incorrect comfirm password
                if (!strNewPassword.equals(strConfirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Confirm Password is incorrect");
                    return;
                }

                Connection connection = null;
                Statement stmt = null;

                try {
                    connection = LibManagement.connect();
                    connection.setAutoCommit(false);

                    //Check old password is correct
                    stmt = connection.createStatement();

                    String strQuerry = "";

                    //Save new password
                    strQuerry = "UPDATE USER SET Password = '" + strNewPassword + "' WHERE Username = '" + LabelShowUsername.getText() + "'";
                    stmt.executeUpdate(strQuerry);

                    connection.commit();

                    //Show a notification
                    JOptionPane.showMessageDialog(null, "Update for client " + currClient.getID() + " successfully!");
                    PasswordFiledNewPassword.setText("");
                    PasswordFieldConfirmPassword.setText("");
                    //Show updated password of client on Password Fiel6d
                    //If showing password
                    if (ButtonViewOrHidePassword.getText().equals("Hide")) {
                        LabelShowCurrentPassword.setText(strNewPassword);
                    }
                } catch (SQLException ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }

                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();

                    try {
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }
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
            }   
        });
        PanelChangePassword.add(ButtonSubmit);

        //Back to the detailed info of client
        JButton ButtonBack = new JButton("Back");
        ButtonBack.setBounds(395, 580, 100, 40);
        ButtonBack.setBackground(Color.decode("#85BEF9"));
        ButtonBack.setForeground(Color.decode("#F8ECBD"));
        ButtonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIClientDetail(currUser, currClient));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonBack);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }
}

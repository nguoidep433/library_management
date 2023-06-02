package User.Librarian.View_Controller.ScreenPrivateInfo;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

import LibManagement.Model.LibManagement;
import User.User.*;
import User.Librarian.View_Controller.ScreenBook.UIListBooks;
import User.Librarian.View_Controller.ScreenClient.UIListClients;
import User.Librarian.View_Controller.ScreenDashboard.UIDashboard;
import User.Librarian.View_Controller.ScreenLibrarian.UILibrarian;
import User.Librarian.View_Controller.ScreenStatistic.*;

public class UIChangePassword extends JFrame{
    private User currUser;

    public UIChangePassword(User user) {
        super("Change Password");
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

        //Change password
        JLabel LabelLibrarianChangePassword = new JLabel("CHANGE PASSSWORD");
        LabelLibrarianChangePassword.setBounds(480, 150, 570, 50);
        LabelLibrarianChangePassword.setBackground(Color.decode("#FFFFFF"));
        LabelLibrarianChangePassword.setForeground(Color.decode("#7C8BFF"));
        LabelLibrarianChangePassword.setFont(new Font("Arial", Font.BOLD, 30));
        LabelLibrarianChangePassword.setHorizontalAlignment(JLabel.CENTER);
        LabelLibrarianChangePassword.setOpaque(true);
        PanelBackground.add(LabelLibrarianChangePassword);

        JLabel LabelOldPassword = new JLabel("Old Password(*)");
        LabelOldPassword.setFont(new Font("Arial", Font.BOLD, 15));
        LabelOldPassword.setBounds(500, 212, 175, 33);
        PanelBackground.add(LabelOldPassword );

        JPasswordField PasswordFieldOldPassword = new JPasswordField();
        PasswordFieldOldPassword.setFont(new Font("Arial", Font.PLAIN, 30));
        PasswordFieldOldPassword.setBounds(685, 212, 270, 33);
        PasswordFieldOldPassword.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(PasswordFieldOldPassword);

        JLabel LabelNewPassword = new JLabel("New Password(*)");
        LabelNewPassword.setFont(new Font("Arial", Font.BOLD, 15));
        LabelNewPassword.setBounds(500, 312, 175, 33);
        PanelBackground.add(LabelNewPassword);

        JPasswordField PasswordFiledNewPassword = new JPasswordField();
        PasswordFiledNewPassword.setFont(new Font("Arial", Font.PLAIN, 30));
        PasswordFiledNewPassword.setBounds(685, 312, 270, 33);
        PasswordFiledNewPassword.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(PasswordFiledNewPassword);

        JLabel LabelConfirmPassword = new JLabel("Confirm Password(*)");
        LabelConfirmPassword.setFont(new Font("Arial", Font.BOLD, 15));
        LabelConfirmPassword.setBounds(500, 412, 175, 33);
        PanelBackground.add(LabelConfirmPassword);

        JPasswordField PasswordFieldConfirmPassword = new JPasswordField();
        PasswordFieldConfirmPassword.setFont(new Font("Arial", Font.PLAIN, 30));
        PasswordFieldConfirmPassword.setBounds(685, 412, 270, 33);
        PasswordFieldConfirmPassword.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(PasswordFieldConfirmPassword);

        JButton ButtonSubmit = new JButton("Submit");
        ButtonSubmit.setBounds(900, 512, 130, 40);
        ButtonSubmit.setBackground(Color.decode("#85BEF9"));
        ButtonSubmit.setForeground(Color.decode("#F8ECBD"));
        ButtonSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strID = currUser.getID();
                String strOldPassword = String.valueOf(PasswordFieldOldPassword.getPassword());
                String strNewPassword = String.valueOf(PasswordFiledNewPassword.getPassword());
                String strConfirmPassword = String.valueOf(PasswordFieldConfirmPassword.getPassword());

                if (strOldPassword.equals("") || strNewPassword.equals("") || strConfirmPassword.equals("")) {
                    JOptionPane.showMessageDialog(null, "Do not have any empty fields");
                    return;
                }

                Connection connection = null;
                Statement stmt = null;
                ResultSet resultSet = null;

                try {
                    connection = LibManagement.connect();
                    connection.setAutoCommit(false);

                    //Check old password is correct
                    stmt = connection.createStatement();

                    String strQuerry = "SELECT * FROM USER u JOIN LIBRARIAN l ON u.Username = l.Username WHERE l.LID = '" + strID + "'";
                    resultSet = stmt.executeQuery(strQuerry);
                    resultSet.next();

                    String strOP = resultSet.getString("Password");
                    String strUsername = resultSet.getString("Username");

                    if (!strOP.equals(strOldPassword)) {
                        JOptionPane.showMessageDialog(null, "Old Password is incorrect");
                        return;
                    }

                    //Incorrect comfirm password
                    if (!strNewPassword.equals(strConfirmPassword)) {
                        JOptionPane.showMessageDialog(null, "Confirm Password is incorrect");
                        return;
                    }

                    //Save new password
                    strQuerry = "UPDATE USER SET Password = '" + strNewPassword + "' WHERE Username = '" + strUsername + "'";
                    stmt.executeUpdate(strQuerry);

                    connection.commit();
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
                
                JOptionPane.showMessageDialog(null, "Update password successfully! Back to login page.");
                LibManagement.getCurrFrame().dispose();
                LibManagement lib = new LibManagement();
            }   
        });
        PanelBackground.add(ButtonSubmit);

        JButton ButtonBack = new JButton("Back");
        ButtonBack.setBounds(500, 512, 130, 40);
        ButtonBack.setBackground(Color.decode("#85BEF9"));
        ButtonBack.setForeground(Color.decode("#F8ECBD"));
        ButtonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIShowInfos(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonBack);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }
}

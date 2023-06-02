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

public class UIChangePassword extends JFrame{
    private User currUser;

    public UIChangePassword(User currUser) {
        super("Change Password");
        this.currUser = currUser;

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

        //Change password
        JLabel LabelClientChangePassword = new JLabel("CHANGE PASSSWORD");
        LabelClientChangePassword.setBounds(480, 150, 570, 50);
        LabelClientChangePassword.setBackground(Color.decode("#FFFFFF"));
        LabelClientChangePassword.setForeground(Color.decode("#7C8BFF"));
        LabelClientChangePassword.setFont(new Font("Arial", Font.BOLD, 30));
        LabelClientChangePassword.setHorizontalAlignment(JLabel.CENTER);
        LabelClientChangePassword.setOpaque(true);
        PanelBackground.add(LabelClientChangePassword);

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

                    String strQuerry = "SELECT * FROM USER u JOIN CLIENT c ON u.Username = c.Username WHERE c.CID = '" + strID + "'";
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

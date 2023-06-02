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
import User.Librarian.Model.Librarian;
import User.Librarian.View_Controller.ScreenStatistic.*;

public class UILibrarianDetail extends JFrame{
    private User currUser;
    private User currLibrarian;

    public UILibrarianDetail(User user, User selectedLibrarian) {
        super("Detailed Info of Librarian");
        this.currUser = user;
        this.currLibrarian = selectedLibrarian;

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

        //Show infos of librarian
        JLabel LabelInformationOfUser = new JLabel("Information of " + currLibrarian.getID());
        LabelInformationOfUser.setBounds(480, 82, 450, 70);
        LabelInformationOfUser.setBackground(Color.decode("#FFFFFF"));
        LabelInformationOfUser.setFont(new Font("Arial", Font.BOLD, 30));
        LabelInformationOfUser.setHorizontalAlignment(JLabel.CENTER);
        LabelInformationOfUser.setOpaque(true);
        PanelBackground.add(LabelInformationOfUser);

        int iPosX = 500, iWidthSize = 500, iHeightSize = 25, iFontSize = 20;

        JLabel LabelFullName = new JLabel("Full Name: " + currLibrarian.getFullname());
        LabelFullName.setBounds(iPosX, 189, iWidthSize, iHeightSize);
        LabelFullName.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelFullName);

        JLabel LabelGender = new JLabel("Gender: " + currLibrarian.getGender());
        LabelGender.setBounds(iPosX, 239, iWidthSize, iHeightSize);
        LabelGender.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelGender);

        JLabel LabelEmail = new JLabel("Email: " + currLibrarian.getEmailAddress());
        LabelEmail.setBounds(iPosX, 289, iWidthSize, iHeightSize);
        LabelEmail.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelEmail);

        JLabel LabelPhone = new JLabel("Phone Number: " + currLibrarian.getPhoneNumber());
        LabelPhone.setBounds(iPosX, 339, iWidthSize, iHeightSize);
        LabelPhone.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelPhone);

        JLabel LabelDepartment = new JLabel("Department: " + ((Librarian)(currLibrarian)).getDepartment());
        LabelDepartment.setBounds(iPosX, 389, iWidthSize, iHeightSize);
        LabelDepartment.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelDepartment);

        JLabel LabelUsername = new JLabel("[Username]:");
        LabelUsername.setBounds(iPosX, 439, iWidthSize, iHeightSize);
        LabelUsername.setFont(new Font("Arial", Font.BOLD, iFontSize));
        PanelBackground.add(LabelUsername);

        JLabel LabelShowUsername = new JLabel("");
        LabelShowUsername.setBounds(705, 439, iWidthSize, iHeightSize);
        LabelShowUsername.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelShowUsername);

        JLabel LabelCurrentPassword = new JLabel("[Password]:");
        LabelCurrentPassword.setBounds(iPosX, 489, iWidthSize, iHeightSize);
        LabelCurrentPassword.setFont(new Font("Arial", Font.BOLD, iFontSize));
        PanelBackground.add(LabelCurrentPassword);

        JLabel LabelShowCurrentPassword = new JLabel("*****");
        LabelShowCurrentPassword.setBounds(705, 489, iWidthSize, iHeightSize);
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
                
                String strQuerry = "SELECT Username FROM LIBRARIAN " +
                                    "WHERE LID = '" + currLibrarian.getID() + "';";
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
        ButtonViewOrHidePassword.setBounds(390, 489, 80, iHeightSize);
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
                        
                        String strQuerry = "SELECT Password FROM USER u JOIN LIBRARIAN l ON u.Username = l.Username " +
                                            "WHERE l.LID = '" + currLibrarian.getID() + "';";
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

        JButton ButtonBack = new JButton("Back");
        ButtonBack.setBounds(830, 572, 100, 40);
        ButtonBack.setBackground(Color.decode("#85BEF9"));
        ButtonBack.setForeground(Color.decode("#F8ECBD"));
        ButtonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UILibrarian(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonBack);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }
}

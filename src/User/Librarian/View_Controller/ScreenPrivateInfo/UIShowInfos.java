package User.Librarian.View_Controller.ScreenPrivateInfo;

import java.awt.*;
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

public class UIShowInfos extends JFrame{
    private User currUser;

    public UIShowInfos(User user) {
        super("Information");
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

        //Show private info of librarian
        JLabel LabelInformationOfUser = new JLabel("Information of Librarian");
        LabelInformationOfUser.setBounds(480, 82, 450, 70);
        LabelInformationOfUser.setBackground(Color.decode("#FFFFFF"));
        LabelInformationOfUser.setFont(new Font("Arial", Font.BOLD, 30));
        LabelInformationOfUser.setHorizontalAlignment(JLabel.CENTER);
        LabelInformationOfUser.setOpaque(true);
        PanelBackground.add(LabelInformationOfUser);

        int iPosX = 500, iWidthSize = 500, iHeightSize = 25, iFontSize = 20;

        JLabel LabelFullName = new JLabel("Full Name: " + this.currUser.getFullname());
        LabelFullName.setBounds(iPosX, 189, iWidthSize, iHeightSize);
        LabelFullName.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelFullName);

        JLabel LabelGender = new JLabel("Gender: " + this.currUser.getGender());
        LabelGender.setBounds(iPosX, 239, iWidthSize, iHeightSize);
        LabelGender.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelGender);

        JLabel LabelEmail = new JLabel("Email: " + this.currUser.getEmailAddress());
        LabelEmail.setBounds(iPosX, 289, iWidthSize, iHeightSize);
        LabelEmail.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelEmail);

        JLabel LabelPhone = new JLabel("Phone Number: " + this.currUser.getPhoneNumber());
        LabelPhone.setBounds(iPosX, 339, iWidthSize, iHeightSize);
        LabelPhone.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelPhone);

        JLabel LabelDepartment = new JLabel("Department: " + ((Librarian)(this.currUser)).getDepartment());
        LabelDepartment.setBounds(iPosX, 389, iWidthSize, iHeightSize);
        LabelDepartment.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelDepartment);

        JButton ButtonUpdate = new JButton("Update");
        ButtonUpdate.setBounds(780, 560, 130, 40);
        ButtonUpdate.setBackground(Color.decode("#85BEF9"));
        ButtonUpdate.setForeground(Color.decode("#F8ECBD"));
        ButtonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIUpdateInfos(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonUpdate);

        JButton ButtonChangePasswrd = new JButton("Change Password");
        ButtonChangePasswrd.setBounds(480, 560, 150, 40);
        ButtonChangePasswrd.setBackground(Color.decode("#85BEF9"));
        ButtonChangePasswrd.setForeground(Color.decode("#F8ECBD"));
        ButtonChangePasswrd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIChangePassword(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonChangePasswrd);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }
}   

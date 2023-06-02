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

public class UIShowInfos extends JFrame{
    private User currUser;

    public UIShowInfos(User user) {
        super("Infomation");
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

        //Informations
        JLabel LabelClient = new JLabel(this.currUser.getID(), SwingConstants.CENTER);
        LabelClient.setFont(new Font("Arial", Font.BOLD, 15));
        LabelClient.setBackground(Color.decode("#A1E7FF"));
        LabelClient.setForeground(Color.decode("#FFF8F7"));
        LabelClient.setBounds(1090, 20, 90, 30);
        LabelClient.setOpaque(true);
        PanelBackground.add(LabelClient);

        JLabel LabelInformationOfUser = new JLabel("Information of User");
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

        JLabel LabelAddress = new JLabel("Address: " + ((Client)(this.currUser)).getAddress());
        LabelAddress.setBounds(iPosX, 389, iWidthSize, iHeightSize);
        LabelAddress.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelAddress);

        JLabel LabelBankAccount = new JLabel("Bank Account: " + ((Client)(this.currUser)).getBankAccount());
        LabelBankAccount.setBounds(iPosX, 439, iWidthSize, iHeightSize);
        LabelBankAccount.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelBankAccount);

        JLabel LabelBankName = new JLabel("Bank Name: " + ((Client)(this.currUser)).getBankName());
        LabelBankName.setBounds(iPosX, 489, iWidthSize, iHeightSize);
        LabelBankName.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelBankName);

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

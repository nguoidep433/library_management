package User.Librarian.View_Controller.ScreenClient;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import LibManagement.Model.LibManagement;
import User.Client.Model.Client;
import User.User.*;
import User.Librarian.View_Controller.ScreenBook.UIListBooks;
import User.Librarian.View_Controller.ScreenDashboard.UIDashboard;
import User.Librarian.View_Controller.ScreenLibrarian.UILibrarian;
import User.Librarian.View_Controller.ScreenPrivateInfo.UIShowInfos;
import User.Librarian.View_Controller.ScreenStatistic.*;

public class UIClientDetail extends JFrame{
    private User currUser;
    private User currClient;

    public UIClientDetail(User user, User selectedClient) {
        super("Detailed Info of Client");
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

        //Informations
        JLabel LabelInformationOfClient = new JLabel("Information of " + currClient.getID());
        LabelInformationOfClient.setBounds(480, 82, 450, 70);
        LabelInformationOfClient.setBackground(Color.decode("#FFFFFF"));
        LabelInformationOfClient.setFont(new Font("Arial", Font.BOLD, 30));
        LabelInformationOfClient.setHorizontalAlignment(JLabel.CENTER);
        LabelInformationOfClient.setOpaque(true);
        PanelBackground.add(LabelInformationOfClient);

        int iPosX = 500, iWidthSize = 500, iHeightSize = 25, iFontSize = 20;

        JLabel LabelFullName = new JLabel("Full Name: " + currClient.getFullname());
        LabelFullName.setBounds(iPosX, 179, iWidthSize, iHeightSize);
        LabelFullName.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelFullName);

        JLabel LabelGender = new JLabel("Gender: " + currClient.getGender());
        LabelGender.setBounds(iPosX, 229, iWidthSize, iHeightSize);
        LabelGender.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelGender);

        JLabel LabelEmail = new JLabel("Email: " + currClient.getEmailAddress());
        LabelEmail.setBounds(iPosX, 279, iWidthSize, iHeightSize);
        LabelEmail.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelEmail);

        JLabel LabelPhone = new JLabel("Phone Number: " + currClient.getPhoneNumber());
        LabelPhone.setBounds(iPosX, 329, iWidthSize, iHeightSize);
        LabelPhone.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelPhone);

        JLabel LabelAddress = new JLabel("Address: " + ((Client)(currClient)).getAddress());
        LabelAddress.setBounds(iPosX, 379, iWidthSize, iHeightSize);
        LabelAddress.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelAddress);

        JLabel LabelBankAccount = new JLabel("Bank Account: " + ((Client)(currClient)).getBankAccount());
        LabelBankAccount.setBounds(iPosX, 429, iWidthSize, iHeightSize);
        LabelBankAccount.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelBankAccount);

        JLabel LabelBankName = new JLabel("Bank Name: " + ((Client)(currClient)).getBankName());
        LabelBankName.setBounds(iPosX, 479, iWidthSize, iHeightSize);
        LabelBankName.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelBankName);

        java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String strCreatedDate = dateFormat.format(((Client)(currClient)).getCreatedDate());
        JLabel LabelCreatedDate = new JLabel("Created Date: " + strCreatedDate);
        LabelCreatedDate.setBounds(iPosX, 529, iWidthSize, iHeightSize);
        LabelCreatedDate.setFont(new Font("Arial", Font.PLAIN, iFontSize));
        PanelBackground.add(LabelCreatedDate);

        //Back to the list of clients
        JButton ButtonBack = new JButton("Back");
        ButtonBack.setBounds(480, 570, 100, 40);
        ButtonBack.setBackground(Color.decode("#85BEF9"));
        ButtonBack.setForeground(Color.decode("#F8ECBD"));
        ButtonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIListClients(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonBack);

        JButton ButtonAccount = new JButton("Account");
        ButtonAccount.setBounds(670, 570, 100, 40);
        ButtonAccount.setBackground(Color.decode("#85BEF9"));
        ButtonAccount.setForeground(Color.decode("#F8ECBD"));
        ButtonAccount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIAccountOf(currUser, currClient));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonAccount);

        JButton ButtonSeeHistory = new JButton("Transaction History");
        ButtonSeeHistory.setBounds(780, 570, 175, 40);
        ButtonSeeHistory.setBackground(Color.decode("#85BEF9"));
        ButtonSeeHistory.setForeground(Color.decode("#F8ECBD"));
        ButtonSeeHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UITransactionHistoryOf(currUser, currClient));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonSeeHistory);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }
}

package User.Librarian.View_Controller.ScreenBook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Book.Book;
import LibManagement.Model.LibManagement;
import User.User.*;
import User.Librarian.View_Controller.ScreenClient.UIListClients;
import User.Librarian.View_Controller.ScreenDashboard.UIDashboard;
import User.Librarian.View_Controller.ScreenLibrarian.UILibrarian;
import User.Librarian.View_Controller.ScreenPrivateInfo.UIShowInfos;
import User.Librarian.View_Controller.ScreenStatistic.*;

public class UIBookDetail extends JFrame{
    private User currUser;
    private Book currBook;

    public UIBookDetail(User user, Book book) {
        super("Detailed Book");
        this.currBook = book;
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
        JLabel LabelBook = new JLabel("Book", IconBook, JLabel.LEFT);
        LabelBook.setHorizontalTextPosition(SwingConstants.RIGHT);
        LabelBook.setIconTextGap(10);
        LabelBook.setBounds(0, 230, 190, 40);
        LabelBook.setBackground(Color.decode("#A1E7FF"));
        LabelBook.setForeground(Color.decode("#FFF8F7"));
        LabelBook.setOpaque(true);
        PanelBackground.add(LabelBook);

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

        //Show details of book
        ImageIcon ImageIconBook = new ImageIcon(currBook.getPathImage());
        Image ImageScaleBook = ImageIconBook.getImage();    
        ImageIconBook = new ImageIcon(ImageScaleBook.getScaledInstance(200, 250, Image.SCALE_SMOOTH));
        JLabel LabelImageBook = new JLabel(ImageIconBook, SwingConstants.CENTER);
        LabelImageBook.setBounds(360, 145, 200, 250);
        PanelBackground.add(LabelImageBook);

        int iWidth = 500, iHeight = 20, iSize = 20;

        JLabel LabelTitle = new JLabel("Tittle: " + currBook.getTitle());
        LabelTitle.setBounds(720, 145, iWidth, iHeight);
        LabelTitle.setFont(new Font("Arial", Font.BOLD, iSize));
        PanelBackground.add(LabelTitle);

        JLabel LabelAuthor = new JLabel("Author: " + currBook.getAuthor());
        LabelAuthor.setBounds(720, 180, iWidth, iHeight);
        LabelAuthor.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelAuthor);

        JLabel LabelPublishingHouse = new JLabel("Publishing House: " + currBook.getPublishingHouse());
        LabelPublishingHouse.setBounds(720, 215, iWidth, iHeight);
        LabelPublishingHouse.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelPublishingHouse);

        JLabel LabelPublishingYear = new JLabel("Publishing Year: " + currBook.getYearPublic());
        LabelPublishingYear.setBounds(720, 250, iWidth, iHeight);
        LabelPublishingYear.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelPublishingYear);

        JLabel LabelGenre = new JLabel("Genre: " + currBook.getGenre());
        LabelGenre.setBounds(720, 285, iWidth, iHeight);
        LabelGenre.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelGenre);

        JLabel LabelHasLeft = new JLabel("Has Left: " + currBook.getHasLeft());
        LabelHasLeft.setBounds(720, 320, iWidth, iHeight);
        LabelHasLeft.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelHasLeft);

        JLabel LabelPlace = new JLabel("Place: " + currBook.getPlace());
        LabelPlace.setBounds(720, 355, iWidth, iHeight);
        LabelPlace.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelPlace);

        JLabel LabelPrice = new JLabel("Price: " + currBook.getPrice() + "VND");
        LabelPrice.setBounds(720, 390, iWidth, iHeight);
        LabelPrice.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelPrice);

        JLabel LabelRoutine = new JLabel("Routine: " + currBook.getRoutine() + " days");
        LabelRoutine.setBounds(720, 425, iWidth, iHeight);
        LabelRoutine.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelRoutine);

        JLabel LabelPathImage = new JLabel("Path: " + currBook.getPathImage());
        LabelPathImage.setBounds(720, 465, iWidth, iHeight);
        LabelPathImage.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelPathImage);

        double dRating = (double)Math.ceil(currBook.getRating() * 10) / 10;
        Color colorRating = dRating == 0 ? Color.BLACK : (dRating < 3 ? Color.RED : Color.GREEN);
        JLabel LabelRating = new JLabel(dRating + "/5.0", SwingConstants.CENTER);
        LabelRating.setBounds(410, 410, 100, 30);
        LabelRating.setFont(new Font("Arial", Font.BOLD, 30));
        LabelRating.setForeground(colorRating);
        PanelBackground.add(LabelRating);

        //Update the current book
        JButton ButtonUpdateBook = new JButton("Update Book");
        ButtonUpdateBook.setBounds(915, 532, 120, 40);
        ButtonUpdateBook.setBackground(Color.decode("#95D5E3"));
        ButtonUpdateBook.setForeground(Color.decode("#FFF8F7"));
        ButtonUpdateBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIUpdateBook(currUser, currBook));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonUpdateBook);

        //Back to the list of books
        JButton ButtonBack = new JButton("Back");
        ButtonBack.setBounds(360, 532, 120, 40);
        ButtonBack.setBackground(Color.decode("#95D5E3"));
        ButtonBack.setForeground(Color.decode("#FFF8F7"));
        ButtonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIListBooks(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonBack);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }
}

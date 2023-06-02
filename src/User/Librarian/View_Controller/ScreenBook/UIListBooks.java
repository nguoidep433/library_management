package User.Librarian.View_Controller.ScreenBook;

import java.awt.*;
import java.sql.*;
import java.util.*;
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

public class UIListBooks extends JFrame{
    private User currUser;
    private JTable Table;
    private JPanel PanelListBooks;

    public UIListBooks(User user) {
        super("List Of Books");
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
        ButtonStatistic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIRevenueStatistic(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        ButtonStatistic.setBackground(Color.decode("#F4FAFB"));

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

        //Show list of books
        PanelListBooks = getListBooks("");
        JScrollPane scrollPaneBooks = new JScrollPane(PanelListBooks);
        scrollPaneBooks.setBounds(200, 180, 1060, 390);
        //Speed up the scroll speed
        scrollPaneBooks.getVerticalScrollBar().setUnitIncrement(20);
        PanelBackground.add(scrollPaneBooks);

        JButton ButtonAddBook = new JButton("Add Book");
        ButtonAddBook.setBounds(1060, 572, 200, 40);
        ButtonAddBook.setBackground(Color.decode("#95D5E3"));
        ButtonAddBook.setForeground(Color.decode("#FFF8F7"));
        ButtonAddBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIAddBook(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonAddBook);

        //Searching
        JPanel PanelSearch = new JPanel();
        PanelSearch.setBounds(400, 100, 520, 70);
        PanelSearch.setBackground(Color.decode("#FFF7DB"));
        PanelSearch.setLayout(null);

        JLabel LabelSearch = new JLabel("BOOK:");
        LabelSearch.setBounds(10, 10, 100, 40);
        LabelSearch.setFont(new Font("Arial", Font.BOLD, 25));
        PanelSearch.add(LabelSearch);

        JTextField TextFieldEnterSearch = new JTextField();
        TextFieldEnterSearch.setBounds(110, 10, 350, 40);
        TextFieldEnterSearch.setFont(new Font("Arial", Font.PLAIN, 25));
        TextFieldEnterSearch.setBackground(Color.decode("#C9F0FE"));
        PanelSearch.add(TextFieldEnterSearch);

        ImageIcon IconSearch = new ImageIcon("pictures\\ImageBackground\\LOGO_Search.png");
        JButton ButtonSearch = new JButton(IconSearch);
        ButtonSearch.setBounds(470, 10, 40, 40);
        ButtonSearch.setBackground(Color.decode("#FFFFFF"));
        ButtonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                scrollPaneBooks.remove(PanelListBooks);
                String strSearch = TextFieldEnterSearch.getText();

                PanelListBooks = getListBooks(strSearch);
                scrollPaneBooks.setViewportView(PanelListBooks);
            }
        });
        PanelSearch.add(ButtonSearch);
        PanelBackground.add(PanelSearch);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }

    private JPanel getListBooks(String strSearch){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        JPanel PanelBackground = null;

        try {
            conn = LibManagement.connect();
            stmt = conn.createStatement();

            String strQuerry = "SELECT COUNT(*) AS C FROM BOOK " + 
                                "WHERE Tittle LIKE '%" + strSearch + "%' OR " +
                                "Author LIKE '%" + strSearch + "%' OR " + 
                                "PublishingHouse LIKE '%" + strSearch + "%' OR " +
                                "Genre LIKE '%" + strSearch + "%';";
            rs = stmt.executeQuery(strQuerry);
            rs.next();

            int iNumOfColumns = 5;
            int iCount = rs.getInt("C");
            int iNumOfRows = (iCount % iNumOfColumns == 0) ? (iCount / iNumOfColumns) : (iCount / iNumOfColumns) + 1;

            PanelBackground = new JPanel();
            PanelBackground.setBounds(20, 90, 500, 1000);
            // ? rows, 5 columns, 5px horizontal gap and 10 px vertical gap
            PanelBackground.setLayout(new GridLayout(iNumOfRows, iNumOfColumns, 5, 10));

            strQuerry = "SELECT * " + 
                        "FROM BOOK bk JOIN BORROWING br ON bk.BID = br.BID " +
                        "WHERE bk.Tittle LIKE '%" + strSearch + "%' OR " +
                        "bk.Author LIKE '%" + strSearch + "%' OR " + 
                        "bk.PublishingHouse LIKE '%" + strSearch + "%' OR " +
                        "bk.Genre LIKE '%" + strSearch + "%' " +
                        "ORDER BY bk.Tittle;";
            rs = stmt.executeQuery(strQuerry);

            ArrayList<Book> listBooks = new ArrayList<>();
            while (rs.next()) {
                String strID = rs.getString("BID");
                String strTitle = rs.getString("Tittle");
                String strAuthor = rs.getString("Author");
                String strPH = rs.getString("PublishingHouse");
                int iPostedYear = rs.getInt("PostedYear");
                String strGenre = rs.getString("Genre");
                int iHasLeft = rs.getInt("HasLeft");
                String strPlace = rs.getString("Place");
                int iPrice = rs.getInt("Price");
                int iRoutine = rs.getInt("Routine");
                String strPathBook = "pictures\\" + rs.getString("PathImage");

                listBooks.add(new Book(strID, strTitle, strAuthor, strPH, iPostedYear, strGenre, iHasLeft, strPlace, iPrice, iRoutine, strPathBook));
            }

            //Show the list of books
            for (Book book : listBooks) {
                JPanel PanelBook = new JPanel(new BorderLayout());
                // PanelBook.setSize(50, 1000);
                PanelBook.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                PanelBook.setBackground(Color.CYAN);

                JPanel PanelInfos = new JPanel();
                PanelInfos.setLayout(new BoxLayout(PanelInfos, BoxLayout.Y_AXIS));
                
                JLabel LabelID = new JLabel(book.getID(), SwingConstants.CENTER);
                LabelID.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                PanelInfos.add(LabelID);

                JLabel LabelPublishingHouse = new JLabel(book.getTitle(), SwingConstants.CENTER);
                LabelPublishingHouse.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                PanelInfos.add(LabelPublishingHouse);

                JLabel LabelAuthor = new JLabel(book.getAuthor(), SwingConstants.CENTER);
                LabelAuthor.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                PanelInfos.add(LabelAuthor);

                ImageIcon ImageIconBook = new ImageIcon(book.getPathImage());
                Image ImageScaleBook = ImageIconBook.getImage();    
                ImageIconBook = new ImageIcon(ImageScaleBook.getScaledInstance(170, 220, Image.SCALE_SMOOTH));
                JLabel LabelImageBook = new JLabel(ImageIconBook, SwingConstants.CENTER);
                
                PanelBook.add(PanelInfos, BorderLayout.CENTER);
                PanelBook.add(LabelImageBook, BorderLayout.NORTH);

                //Add event to PanelBook
                PanelBook.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e){
                        LibManagement.getCurrFrame().dispose();
                        LibManagement.setFrame(new UIBookDetail(currUser, book));
                        LibManagement.getCurrFrame().setVisible(true);
                    }
                });

                PanelBackground.add(PanelBook);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        
            try {
                stmt.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }

            try {
                conn.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return PanelBackground;
    }
}

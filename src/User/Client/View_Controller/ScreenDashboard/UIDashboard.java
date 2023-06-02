package User.Client.View_Controller.ScreenDashboard;

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
import User.Client.View_Controller.ScreenCart.UICart;
import User.Client.View_Controller.ScreenHistoryTransaction.UIHistory;
import User.Client.View_Controller.ScreenInteresting.UIInteresting;
import User.Client.View_Controller.ScreenPrivateInfo.UIShowInfos;
import User.User.*;

public class UIDashboard extends JFrame{
    private User currUser;
    private JPanel PanelListBooks;

    public UIDashboard(User user){
        super("Dashboard");
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
        JLabel LabelDashboard = new JLabel("Dashboard", IconDashboard, JLabel.LEFT);
        LabelDashboard.setHorizontalTextPosition(SwingConstants.RIGHT);
        LabelDashboard.setIconTextGap(10);
        LabelDashboard.setBounds(0, 190, 190, 40);
        LabelDashboard.setBackground(Color.decode("#A1E7FF"));
        LabelDashboard.setForeground(Color.decode("#FFF8F7"));
        LabelDashboard.setOpaque(true);
        PanelBackground.add(LabelDashboard);

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

        JButton ButtonClient = new JButton(this.currUser.getID());
        ButtonClient.setFont(new Font("Arial", Font.BOLD, 15));
        ButtonClient.setBackground(Color.decode("#FFFFFF"));
        ButtonClient.setBounds(1090, 20, 90, 30);
        ButtonClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIShowInfos(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonClient);

        //List of books
        PanelListBooks = getListBooks("");
        JScrollPane scrollPaneBooks = new JScrollPane(PanelListBooks);
        // JScrollPane scrollPaneBooks = new JScrollPane((new ListBooks(strSearch)).getListItems());
        scrollPaneBooks.setBounds(200, 180, 1060, 450);
        //Speed up the scroll speed
        scrollPaneBooks.getVerticalScrollBar().setUnitIncrement(20);
        PanelBackground.add(scrollPaneBooks);

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
                //scrollPaneBooks.setViewportView((new ListBooks(strSearch)).getListItems());
            }
        });
        PanelSearch.add(ButtonSearch);
        PanelBackground.add(PanelSearch);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }

    public JPanel getListBooks(String strSearch){
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

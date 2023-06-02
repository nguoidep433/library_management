package User.Client.View_Controller.ScreenInteresting;

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
import User.Client.View_Controller.ScreenDashboard.UIBookDetail;
import User.Client.View_Controller.ScreenDashboard.UIDashboard;
import User.Client.View_Controller.ScreenHistoryTransaction.UIHistory;
import User.Client.View_Controller.ScreenPrivateInfo.UIShowInfos;

public class UIInteresting extends JFrame{
    private User currUser;

    public UIInteresting(User user) {
        super("Interesting Books");
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

        JLabel LabelAboutInteresting = new JLabel("Interesting Books");
        LabelAboutInteresting.setBounds(480, 82, 450, 70);
        LabelAboutInteresting.setBackground(Color.decode("#FFFFFF"));
        LabelAboutInteresting.setFont(new Font("Arial", Font.BOLD, 30));
        LabelAboutInteresting.setHorizontalAlignment(JLabel.CENTER);
        LabelAboutInteresting.setOpaque(true);
        PanelBackground.add(LabelAboutInteresting);

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
        JLabel LabelInteresting = new JLabel("Interesting", IconUser, JLabel.LEFT);
        LabelInteresting.setHorizontalTextPosition(SwingConstants.RIGHT);
        LabelInteresting.setIconTextGap(10);
        LabelInteresting.setBounds(0, 271, 190, 40);
        LabelInteresting.setBackground(Color.decode("#A1E7FF"));
        LabelInteresting.setForeground(Color.decode("#FFF8F7"));
        LabelInteresting.setOpaque(true);
        PanelBackground.add(LabelInteresting);

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

        JPanel PanelListInterestingBooks = getListInterestingBooks();
        JScrollPane scrollPaneBooks = new JScrollPane(PanelListInterestingBooks);
        scrollPaneBooks.setBounds(200, 180, 1060, 450);
        //Speed up the scroll speed
        scrollPaneBooks.getVerticalScrollBar().setUnitIncrement(20);
        PanelBackground.add(scrollPaneBooks);


        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }

    public JPanel getListInterestingBooks() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        JPanel PanelBackground = null;

        try {
            conn = LibManagement.connect();
            stmt = conn.createStatement();

            String strQuerry = "SELECT COUNT(*) AS C FROM INTERESTING WHERE CID = '" + currUser.getID() + "';";
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
                        "FROM INTERESTING it, BOOK bk, BORROWING br " +
                        "WHERE it.CID = '" + currUser.getID() + "' AND it.BID = bk.BID AND bk.BID = br.BID " +
                        "ORDER BY bk.Tittle";
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

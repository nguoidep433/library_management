package User.Client.View_Controller.ScreenHistoryTransaction;

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
import User.Client.View_Controller.ScreenInteresting.UIInteresting;
import User.Client.View_Controller.ScreenPrivateInfo.UIShowInfos;

public class UIHistory extends JFrame{
    private User currUser;

    public UIHistory(User user) {
        super("History");
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

        JLabel LabelAboutHistory = new JLabel("History");
        LabelAboutHistory.setBounds(480, 82, 450, 70);
        LabelAboutHistory.setBackground(Color.decode("#FFFFFF"));
        LabelAboutHistory.setFont(new Font("Arial", Font.BOLD, 30));
        LabelAboutHistory.setHorizontalAlignment(JLabel.CENTER);
        LabelAboutHistory.setOpaque(true);
        PanelBackground.add(LabelAboutHistory);

        JLabel labelLibMangement = new JLabel("Lib Management");
        labelLibMangement.setBounds(170, 45, 260, 26);
        labelLibMangement.setFont(new Font("Arial", Font.BOLD, 25));
        PanelBackground.add(labelLibMangement);

        JLabel ImageLogo = new JLabel();
        ImageLogo.setIcon(new ImageIcon("pictures\\ImageBackground\\LOGO 1.png"));
        Dimension size = ImageLogo.getPreferredSize();
        ImageLogo.setBounds(0, 5, size.width, size.height);
        PanelBackground.add(ImageLogo);

        JLabel LabelHistoryBorrowBook = new JLabel("All History Borrowed Book");
        LabelHistoryBorrowBook.setFont(new Font("Arial", Font.BOLD, 25));
        LabelHistoryBorrowBook.setBounds(530, 105, 320, 26);
        PanelBackground.add(LabelHistoryBorrowBook);

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
        JLabel LabelHistory = new JLabel("History", IconBook, JLabel.LEFT);
        LabelHistory.setHorizontalTextPosition(SwingConstants.RIGHT);
        LabelHistory.setIconTextGap(10);
        LabelHistory.setBounds(0, 230, 190, 40);
        LabelHistory.setBackground(Color.decode("#A1E7FF"));
        LabelHistory.setForeground(Color.decode("#FFF8F7"));
        LabelHistory.setOpaque(true);
        PanelBackground.add(LabelHistory);

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

        //Get list of history
        JTable table = new JTable();
        table.setFont(new Font("Arial", Font.BOLD, 15));
        table.setBackground(Color.decode("#FFEDF6"));
        table.setForeground(Color.decode("#2368CF"));
        table.setRowHeight(35);
        DefaultTableModel modelTable = new DefaultTableModel();


        Object[] columnsName = {"Transaction ID", "Title", "Price", "Borrowed Date", "Return Date", "Status"};
        modelTable.setColumnIdentifiers(columnsName);

        Object[] rowDate = new Object[6];
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            String strQuerry = "SELECT * " +
                                "FROM TRANSACTION t, DETAILTRANS d, BOOK b " +
                                "WHERE t.CID = '" + currUser.getID() + "' AND " +
                                "t.TID = d.TID AND (t.Status = 'Borrowing' OR t.Status = 'Returned' OR t.Status = 'Cancel') AND " +
                                "d.BID = b.BID " + 
                                "ORDER BY t.TID;";

            connection = LibManagement.connect();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(strQuerry);

            while (rs.next()) {
                rowDate[0] = rs.getString("TID");
                rowDate[1] = rs.getString("Tittle");
                rowDate[2] = rs.getInt("CurrentPrice") + " VND";
                rowDate[3] = rs.getString("BorrowedDate");
                rowDate[4] = rs.getString("ReturnDate");
                rowDate[5] = rs.getString("Status");

                modelTable.addRow(rowDate);
            }

            table.setModel(modelTable);
            table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
            table.getTableHeader().setBackground(Color.decode("#ADE6D0"));
            table.getTableHeader().setForeground(Color.decode("#FFFFFF"));
            table.setDefaultEditor(Object.class, null);
            
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
                connection.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        
        JScrollPane scrollPaneBooks = new JScrollPane(table);
        scrollPaneBooks.setBounds(200, 180, 1060, 450);
        //Speed up the scroll speed
        scrollPaneBooks.getVerticalScrollBar().setUnitIncrement(20);
        PanelBackground.add(scrollPaneBooks);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }
}

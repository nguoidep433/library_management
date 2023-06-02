package User.Librarian.View_Controller.ScreenClient;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import LibManagement.Model.LibManagement;
import User.User.*;
import User.Librarian.View_Controller.ScreenBook.UIListBooks;
import User.Librarian.View_Controller.ScreenDashboard.UIDashboard;
import User.Librarian.View_Controller.ScreenLibrarian.UILibrarian;
import User.Librarian.View_Controller.ScreenPrivateInfo.UIShowInfos;
import User.Librarian.View_Controller.ScreenStatistic.*;

public class UITransactionHistoryOf extends JFrame{
    private User currUser;
    private User currClient;
    private JTable Table;

    public UITransactionHistoryOf(User user, User selectedClient) {
        super("Transaction History of Client");
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

        //Transaction History
        JLabel LabelTransactionHistory = new JLabel("Transaction History of " + currClient.getID());
        LabelTransactionHistory.setBounds(480, 82, 450, 70);
        LabelTransactionHistory.setBackground(Color.decode("#FFFFFF"));
        LabelTransactionHistory.setFont(new Font("Arial", Font.BOLD, 30));
        LabelTransactionHistory.setHorizontalAlignment(JLabel.CENTER);
        LabelTransactionHistory.setOpaque(true);
        PanelBackground.add(LabelTransactionHistory);

        //Show list of transaction history
        Table = getListOfTransactionHistoryOf();
        JScrollPane ScrollPaneTransactionHistory = new JScrollPane(Table);
        ScrollPaneTransactionHistory.setBounds(200, 180, 1060, 390);
        //Speed up the scroll speed
        ScrollPaneTransactionHistory.getVerticalScrollBar().setUnitIncrement(20);
        PanelBackground.add(ScrollPaneTransactionHistory);

        //Back to the detailed info of client
        JButton ButtonBack = new JButton("Back");
        ButtonBack.setBounds(300, 580, 100, 40);
        ButtonBack.setBackground(Color.decode("#85BEF9"));
        ButtonBack.setForeground(Color.decode("#F8ECBD"));
        ButtonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIClientDetail(currUser, currClient));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonBack);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }

    private JTable getListOfTransactionHistoryOf() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        JTable table = new JTable();
        table.setFont(new Font("Arial", Font.BOLD, 15));
        table.setBackground(Color.decode("#FFEDF6"));
        table.setForeground(Color.decode("#1B00CF"));
        table.setRowHeight(35);
        DefaultTableModel modelTable = new DefaultTableModel();

        Object[] columnsName = {"Transaction ID", "Book ID", "Borrowed Date", "Return Date",
                                "Price", "Total Price", "Routine", "Total Routine", "Status"};
        modelTable.setColumnIdentifiers(columnsName);

        Object[] rowValue = new Object[columnsName.length];

        try {
            conn = LibManagement.connect();
            stmt = conn.createStatement();

            String strQuerry = "SELECT * FROM TRANSACTION t JOIN DETAILTRANS d on t.TID = d.TID " +
                            "WHERE t.CID = '" + currClient.getID() + "' " +
                            "ORDER BY t.TID DESC;";
            rs = stmt.executeQuery(strQuerry);

            if (rs.next()) {
                do {
                    rowValue[0] = rs.getString("TID");
                    rowValue[1] = rs.getString("BID");
                    rowValue[2] = rs.getString("BorrowedDate");
                    rowValue[3] = rs.getString("ReturnDate");
                    rowValue[4] = rs.getString("CurrentPrice") + " VND";
                    rowValue[5] = rs.getString("TotalPrice") + " VND";
                    rowValue[6] = rs.getString("CurrentRoutine") + " days";
                    rowValue[7] = rs.getString("TotalRoutine") + " days";
                    rowValue[8] = rs.getString("Status");

                    modelTable.addRow(rowValue);
                } while (rs.next());
            }

            //Generate the table
            table.setModel(modelTable);
            table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
            table.getTableHeader().setBackground(Color.decode("#ADE6D0"));
            table.getTableHeader().setForeground(Color.decode("#FFFFFF"));
            //set uneditable for table
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
                conn.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }

        return table;
    } 
}

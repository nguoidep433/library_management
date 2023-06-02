package User.Librarian.View_Controller.ScreenDashboard;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import LibManagement.Model.LibManagement;
import User.Librarian.View_Controller.ScreenBook.UIListBooks;
import User.Librarian.View_Controller.ScreenClient.UIListClients;
import User.Librarian.View_Controller.ScreenLibrarian.UILibrarian;
import User.Librarian.View_Controller.ScreenPrivateInfo.UIShowInfos;
import User.User.*;
import User.Librarian.View_Controller.ScreenStatistic.*;

public class UIDashboard extends JFrame{
    private User currUser;
    private JTable Table;

    public UIDashboard(User user) {
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

        //Show list of borrowers
        Table = getListOfBorrowingTrans("");
        JScrollPane scrollPaneBooks = new JScrollPane(Table);
        // JScrollPane scrollPaneBooks = new JScrollPane((new ListBooks(strSearch)).getListItems());
        scrollPaneBooks.setBounds(200, 180, 1060, 390);
        //Speed up the scroll speed
        scrollPaneBooks.getVerticalScrollBar().setUnitIncrement(20);
        PanelBackground.add(scrollPaneBooks);

        //Search
        JPanel PanelSearch = new JPanel();
        PanelSearch.setBounds(400, 100, 520, 70);
        PanelSearch.setBackground(Color.decode("#FFF7DB"));
        PanelSearch.setLayout(null);

        JLabel LabelSearch = new JLabel("Search:");
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
                scrollPaneBooks.remove(Table);
                String strSearch = TextFieldEnterSearch.getText();

                Table = getListOfBorrowingTrans(strSearch);
                scrollPaneBooks.setViewportView(Table);
                //scrollPaneBooks.setViewportView((new ListBooks(strSearch)).getListItems());
            }
        });
        PanelSearch.add(ButtonSearch);
        PanelBackground.add(PanelSearch);

        JButton ButtonConfirm = new JButton("Confirm");
        ButtonConfirm.setBounds(1060, 572, 200, 40);
        ButtonConfirm.setBackground(Color.decode("#95D5E3"));
        ButtonConfirm.setForeground(Color.decode("#FFF8F7"));
        ButtonConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int iSelectedRow = Table.getSelectedRow();

                if (iSelectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Select a row, then press 'confirm'");
                    return;
                }

                //Get transaction ID
                Object objTID = Table.getValueAt(iSelectedRow, 0);
                Object objBorrower = Table.getValueAt(iSelectedRow, 1);
                String strTID = (String)objTID;
                String strBorrowerID = (String)objBorrower;
                
                int iConfirmReturnedBooks = JOptionPane.showConfirmDialog(null, "Confirm: " + strBorrowerID + " has returned books");

                //If confirm that a client has returned books
                if (iConfirmReturnedBooks == JOptionPane.YES_OPTION) {
                    Connection connection = null;
                    Statement stmt = null;

                    try {
                        connection = LibManagement.connect();
                        connection.setAutoCommit(false);
                        stmt = connection.createStatement();

                        //Client returned books
                        String strQuerry = "UPDATE TRANSACTION SET Status = 'Returned' " +
                                    "WHERE TID = '" + strTID + "';"; 
                        stmt.executeUpdate(strQuerry);

                        //Increase the number of each returned book by 1
                        strQuerry = "UPDATE BOOK SET HasLeft = HasLeft + 1 " +
                                    "WHERE BID IN (SELECT BID FROM DETAILTRANS WHERE TID = '" + strTID +"')";
                        stmt.executeUpdate(strQuerry);

                        connection.commit();

                        DefaultTableModel modelTable = (DefaultTableModel)Table.getModel();
                        modelTable.removeRow(iSelectedRow);
                    } catch (SQLException ex){
                        try {
                            connection.rollback();
                        } catch (SQLException ex1){
                            ex1.printStackTrace();
                        }

                        ex.printStackTrace();
                    } catch (Exception ex){
                        try {
                            connection.rollback();
                        } catch (SQLException ex1){
                            ex1.printStackTrace();
                        }

                        ex.printStackTrace();
                    } finally {
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
            }
        });
        PanelBackground.add(ButtonConfirm);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }

    private JTable getListOfBorrowingTrans(String strSearch) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        JTable table = new JTable();
        table.setFont(new Font("Arial", Font.BOLD, 15));
        table.setBackground(Color.decode("#FFEDF6"));
        table.setForeground(Color.decode("#2368CF"));
        table.setRowHeight(35);
        DefaultTableModel modelTable = new DefaultTableModel();

        Object[] columnsName = {"Transaction ID", "Borrower ID", "Phone Number", "Total Price", "Borrowed Date", "Return Date", "Quantity"};
        modelTable.setColumnIdentifiers(columnsName);

        Object[] rowValue = new Object[columnsName.length];

        try {
            conn = LibManagement.connect();
            stmt = conn.createStatement();

            String strQuerry = "SELECT * FROM TRANSACTION t " +
                                "JOIN CLIENT c ON t.CID = c.CID " +
                                "WHERE t.Status = 'Borrowing' AND (t.TID LIKE '%" + strSearch + "%' " + 
                                "OR t.CID LIKE '%" + strSearch + "%' " +
                                "OR c.Fullname LIKE '%" + strSearch + "%') " +
                                "ORDER BY DATEDIFF(t.ReturnDate, CURDATE());";
            rs = stmt.executeQuery(strQuerry);

            if (rs.next()) {
                do {
                    rowValue[0] = rs.getString("TID");
                    rowValue[1] = rs.getString("CID");
                    rowValue[2] = rs.getString("PhoneNum");
                    rowValue[3] = rs.getInt("TotalPrice") + " VND";
                    rowValue[4] = rs.getDate("BorrowedDate");
                    rowValue[5] = rs.getDate("ReturnDate");
                    rowValue[6] = rs.getInt("Quantity");

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

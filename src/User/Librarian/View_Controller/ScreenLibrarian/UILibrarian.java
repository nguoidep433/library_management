package User.Librarian.View_Controller.ScreenLibrarian;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import LibManagement.Model.LibManagement;
import User.User.*;
import User.Librarian.Model.*;
import User.Librarian.View_Controller.ScreenBook.UIListBooks;
import User.Librarian.View_Controller.ScreenClient.UIListClients;
import User.Librarian.View_Controller.ScreenDashboard.UIDashboard;
import User.Librarian.View_Controller.ScreenPrivateInfo.UIShowInfos;
import User.Librarian.View_Controller.ScreenStatistic.*;

public class UILibrarian extends JFrame{
    private User currUser;
    private JTable Table;

    public UILibrarian(User user) {
        super("Librarian Management");
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
        JLabel LabelLibrarian = new JLabel("Librarian", IconLibrarian, JLabel.LEFT);
        LabelLibrarian.setHorizontalTextPosition(SwingConstants.RIGHT);
        LabelLibrarian.setIconTextGap(10);
        LabelLibrarian.setBounds(0, 310, 190, 40);
        LabelLibrarian.setBackground(Color.decode("#A1E7FF"));
        LabelLibrarian.setForeground(Color.decode("#FFF8F7"));
        LabelLibrarian.setOpaque(true);
        PanelBackground.add(LabelLibrarian);

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

        //Show list of librarian, except current librarian
        Table = getListOfLibrarians("");
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

                Table = getListOfLibrarians(strSearch);
                scrollPaneBooks.setViewportView(Table);
            }
        });
        PanelSearch.add(ButtonSearch);
        PanelBackground.add(PanelSearch);

        //Add a new librarian
        JButton ButtonAddLibrarian = new JButton("Add Librarian");
        ButtonAddLibrarian.setBounds(850, 572, 200, 40);
        ButtonAddLibrarian.setBackground(Color.decode("#95D5E3"));
        ButtonAddLibrarian.setForeground(Color.decode("#FFF8F7"));
        ButtonAddLibrarian.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIAddLibrarian(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonAddLibrarian);

        //Select a librarian and see his/her detailed infos
        JButton ButtonSelect = new JButton("Select");
        ButtonSelect.setBounds(1060, 572, 200, 40);
        ButtonSelect.setBackground(Color.decode("#95D5E3"));
        ButtonSelect.setForeground(Color.decode("#FFF8F7"));
        ButtonSelect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int iSelectedRow = Table.getSelectedRow();
                int iSelectedCol = 0;

                if (iSelectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Select a librarian, then press 'Select'");
                    return;
                }

                //Get librarian id
                String strLID = Table.getValueAt(iSelectedRow, iSelectedCol) + "";
                Connection connection = null;
                Statement stmt = null;
                ResultSet resultSet = null;

                try {
                    connection = LibManagement.connect();
                    connection.setAutoCommit(false);
                    stmt = connection.createStatement();

                    String strQuerry = "SELECT * FROM LIBRARIAN WHERE LID = '" + strLID + "';";
                    resultSet = stmt.executeQuery(strQuerry);
                    
                    User selectedLibrarian = null;
                    while (resultSet.next()) {
                        String strFullname = resultSet.getString("Fullname");
                        String strPhoneNum = resultSet.getString("PhoneNum");
                        String strEmail = resultSet.getString("Email");
                        String strGender = resultSet.getString("Gender");
                        String strAddress = resultSet.getString("Department");
                        java.util.Date dateCreatedDate = new java.util.Date(resultSet.getDate("CreatedDate").getTime());

                        selectedLibrarian = new Librarian(strLID, strFullname, strPhoneNum, strEmail, strGender, dateCreatedDate, strAddress);
                    }

                    //Change current screen to detailed info screen
                    LibManagement.getCurrFrame().dispose();
                    LibManagement.setFrame(new UILibrarianDetail(currUser, selectedLibrarian));
                    LibManagement.getCurrFrame().setVisible(true);
                } catch (SQLException ex){
                    ex.printStackTrace();
                } catch (Exception ex){
                    ex.printStackTrace();
                } finally {
                    try {
                        resultSet.close();
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
            }
        });
        PanelBackground.add(ButtonSelect);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }

    private JTable getListOfLibrarians(String strSearch) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        JTable table = new JTable();
        table.setFont(new Font("Arial", Font.BOLD, 15));
        table.setBackground(Color.decode("#FFEDF6"));
        table.setForeground(Color.decode("#1B00CF"));
        table.setRowHeight(35);
        DefaultTableModel modelTable = new DefaultTableModel();

        Object[] columnsName = {"Librarian ID", "Fullname", "PhoneNumber", "Email", "Gender", "Department", "Created Date"};
        modelTable.setColumnIdentifiers(columnsName);

        Object[] rowValue = new Object[columnsName.length];

        try {
            conn = LibManagement.connect();
            stmt = conn.createStatement();

            String strQuerry = "SELECT * FROM LIBRARIAN " +
                            "WHERE LID <> '" + currUser.getID() + "' AND (" +
                            "LID LIKE '%" + strSearch + "%' OR " + 
                            "Fullname LIKE '%" + strSearch + "%')  " + 
                            "ORDER BY LID;";
            rs = stmt.executeQuery(strQuerry);

            if (rs.next()) {
                do {
                    rowValue[0] = rs.getString("LID");
                    rowValue[1] = rs.getString("Fullname");
                    rowValue[2] = rs.getString("PhoneNum");
                    rowValue[3] = rs.getString("Email");
                    rowValue[4] = rs.getString("Gender");
                    rowValue[5] = rs.getString("Department");
                    rowValue[6] = rs.getString("CreatedDate");

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

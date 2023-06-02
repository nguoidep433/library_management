package User.Client.View_Controller.ScreenCart;

import java.awt.*;
import java.sql.*;
import java.time.LocalDate;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

import LibManagement.Model.LibManagement;
import User.User.*;
import User.Client.Model.*;
import User.Client.View_Controller.ScreenDashboard.UIDashboard;
import User.Client.View_Controller.ScreenHistoryTransaction.UIHistory;
import User.Client.View_Controller.ScreenInteresting.UIInteresting;
import User.Client.View_Controller.ScreenPrivateInfo.UIShowInfos;
import InternetBanking.Bank.Bank;
import InternetBanking.Client.ClientBanking;

public class UICart extends JFrame {
    private User currUser;

    public UICart(User user) {
        super("Cart");
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

        JLabel LabelAboutCart = new JLabel("Cart");
        LabelAboutCart.setBounds(480, 82, 450, 70);
        LabelAboutCart.setBackground(Color.decode("#FFFFFF"));
        LabelAboutCart.setFont(new Font("Arial", Font.BOLD, 30));
        LabelAboutCart.setHorizontalAlignment(JLabel.CENTER);
        LabelAboutCart.setOpaque(true);
        PanelBackground.add(LabelAboutCart);

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
        JLabel LabelCart = new JLabel("Cart", IconPayment, JLabel.LEFT);
        LabelCart.setHorizontalTextPosition(SwingConstants.RIGHT);
        LabelCart.setIconTextGap(10);
        LabelCart.setBounds(0, 311, 190, 40);
        LabelCart.setBackground(Color.decode("#A1E7FF"));
        LabelCart.setForeground(Color.decode("#FFF8F7"));
        LabelCart.setOpaque(true);
        PanelBackground.add(LabelCart);

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

        JLabel LabelAllCart = new JLabel("All Cart");
        LabelAllCart.setFont(new Font("Arial", Font.BOLD, 25));
        LabelAllCart.setOpaque(true);
        LabelAllCart.setForeground(Color.decode("#22AAEB"));
        LabelAllCart.setBackground(Color.decode("#FFFFFF"));
        LabelAllCart.setBounds(630, 105, 205, 26);
        PanelBackground.add(LabelAllCart);

        // Show all total values
        JLabel LabelOrderSummary = new JLabel("Order Summary");
        LabelOrderSummary.setBounds(820, 400, 250, 30);
        PanelBackground.add(LabelOrderSummary);

        JLabel LabelTotalPrice = new JLabel("Total Price");
        LabelTotalPrice.setBounds(827, 432, 100, 30);
        PanelBackground.add(LabelTotalPrice);

        JLabel LabelGetTotalPrice = new JLabel("");
        LabelGetTotalPrice.setBounds(930, 432, 100, 30);
        PanelBackground.add(LabelGetTotalPrice);

        JLabel LabelBorrowedDate = new JLabel("Borrowed Date");
        LabelBorrowedDate.setBounds(827, 464, 100, 30);
        PanelBackground.add(LabelBorrowedDate);

        JLabel LabelGetBorrowedDate = new JLabel("");
        LabelGetBorrowedDate.setBounds(930, 464, 100, 30);
        PanelBackground.add(LabelGetBorrowedDate);

        JLabel LabelReturnDate = new JLabel("Return Date");
        LabelReturnDate.setBounds(827, 496, 100, 30);
        PanelBackground.add(LabelReturnDate);

        JLabel LabelGetReturnDate = new JLabel("");
        LabelGetReturnDate.setBounds(930, 496, 100, 30);
        PanelBackground.add(LabelGetReturnDate);

        // Show list of waiting books
        JTable table = new JTable();
        table.setFont(new Font("Arial", Font.BOLD, 15));
        table.setBackground(Color.decode("#FFEDF6"));
        table.setForeground(Color.decode("#2368CF"));
        table.setRowHeight(35);
        DefaultTableModel modelTable = new DefaultTableModel();

        Object[] columnsName = { "Transaction ID", "Title", "Price", "Routine", "Status" };
        modelTable.setColumnIdentifiers(columnsName);

        int iTotalPrice = 0;
        int iTotalRoutine = 0;

        if (true) {
            Object[] rowDate = new Object[5];
            Connection connection = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                connection = LibManagement.connect();
                stmt = connection.createStatement();

                String strQuerry = "SELECT * " +
                        "FROM TRANSACTION t, DETAILTRANS d, BOOK b, BORROWING br " +
                        "WHERE t.CID = '" + currUser.getID() + "' AND " +
                        "t.TID = d.TID AND (t.Status = 'Waiting') AND " +
                        "d.BID = b.BID AND b.BID = br.BID;";
                rs = stmt.executeQuery(strQuerry);

                // If has at least one transaction
                if (rs.next() == true) {
                    do {
                        iTotalPrice = rs.getInt("TotalPrice");
                        iTotalRoutine = rs.getInt("TotalRoutine");

                        rowDate[0] = rs.getString("TID");
                        rowDate[1] = rs.getString("Tittle");
                        rowDate[2] = rs.getInt("Price") + " VND";
                        rowDate[3] = rs.getString("Routine") + " days";
                        rowDate[4] = rs.getString("Status");

                        modelTable.addRow(rowDate);
                    } while (rs.next());

                    // Set total price:
                    LabelGetTotalPrice.setText(iTotalPrice + " VND");
                    // Set current date
                    java.time.LocalDate CurrentDate = LocalDate.now();
                    java.sql.Date DateCurrentDate = java.sql.Date.valueOf(CurrentDate);
                    LabelGetBorrowedDate.setText("" + DateCurrentDate);
                    // Set return date
                    java.time.LocalDate ReturnDate = CurrentDate.plusDays(iTotalRoutine);
                    java.sql.Date DateReturnDate = java.sql.Date.valueOf(ReturnDate);
                    LabelGetReturnDate.setText("" + DateReturnDate);
                }

                // Generate the table
                table.setModel(modelTable);
                table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
                table.getTableHeader().setBackground(Color.decode("#ADE6D0"));
                table.getTableHeader().setForeground(Color.decode("#FFFFFF"));
                // set uneditable for table
                table.setDefaultEditor(Object.class, null);
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                try {
                    stmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        JScrollPane scrollPaneBooks = new JScrollPane(table);
        scrollPaneBooks.setBounds(200, 180, 1060, 200);
        // Speed up the scroll speed
        scrollPaneBooks.getVerticalScrollBar().setUnitIncrement(20);
        PanelBackground.add(scrollPaneBooks);

        JButton ButtonCancel = new JButton("Cancel All Books");
        ButtonCancel.setBounds(200, 400, 200, 40);
        ButtonCancel.setBackground(Color.decode("#95D5E3"));
        ButtonCancel.setForeground(Color.decode("#FFF8F7"));
        ButtonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                Statement stmt = null;

                try {
                    connection = Bank.connectInternetBanking();
                    connection.setAutoCommit(false);
                    stmt = connection.createStatement();

                    String strQuerry = "UPDATE TRANSACTION SET Status = 'Cancel' " +
                            "WHERE CID = '" + currUser.getID() + "' AND Status = 'Waiting'";
                    stmt.executeUpdate(strQuerry);

                    connection.commit();
                } catch (SQLException ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }

                    ex.printStackTrace();
                } catch (Exception ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }

                    ex.printStackTrace();
                } finally {
                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                // Clear all rows of waiting books
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                dtm.setRowCount(0);

                LabelGetTotalPrice.setText("");
                LabelGetBorrowedDate.setText("");
                LabelGetReturnDate.setText("");
            }
        });
        PanelBackground.add(ButtonCancel);

        JButton ButtonContinue = new JButton("Continue to check out");
        ButtonContinue.setBounds(820, 572, 200, 40);
        ButtonContinue.setBackground(Color.decode("#95D5E3"));
        ButtonContinue.setForeground(Color.decode("#FFF8F7"));
        ButtonContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                final int MINIMUM_BALANCE = 50000;
                String strBankAccount = ((Client) currUser).getBankAccount();
                String strBankName = ((Client) currUser).getBankName();
                String strPayment = LabelGetTotalPrice.getText().replace(" VND", "");
                String strBorrowedDate = LabelGetBorrowedDate.getText();
                String strReturnDate = LabelGetReturnDate.getText();
                int iBalanceAfterTransaction = 0;
                int iPayment = 0;
                try {
                    iPayment = Integer.parseInt(strPayment);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }

                Connection connection = null;
                Statement stmt = null;
                ResultSet rs = null;

                // Make a transportation money
                try {
                    connection = Bank.connectInternetBanking();
                    connection.setAutoCommit(false);
                    stmt = connection.createStatement();

                    String strQuerry = "SELECT * FROM Bank WHERE BankAccount = '" + strBankAccount + "' AND " +
                            "BankName = '" + strBankName + "';";
                    rs = stmt.executeQuery(strQuerry);

                    // If not exists a bank account with that bank name
                    if (rs.next() == false) {
                        JOptionPane.showMessageDialog(null, "Not exists your bank account with your bank name!");
                        return;
                    }

                    // Check the bank password of client
                    String strBankPassword = "";
                    JPasswordField PasswordFieldBank = new JPasswordField(10);
                    int iAction = JOptionPane.showConfirmDialog(null, PasswordFieldBank,
                            "Enter your bank password", JOptionPane.OK_CANCEL_OPTION);

                    if (iAction == JOptionPane.OK_OPTION) {
                        strBankPassword = String.valueOf(PasswordFieldBank.getPassword());

                        if (rs.getString("Password").equals(strBankPassword) == false) {
                            JOptionPane.showMessageDialog(null, "Not correct password!");
                            return;
                        }
                        ;
                    } else {
                        return;
                    }

                    // If the balance which is after the transaction is less than the minimum
                    // balance,
                    // Show a notification
                    int iCurrMoneyInBank = rs.getInt("Money");
                    iBalanceAfterTransaction = iCurrMoneyInBank - iPayment;
                    if (iBalanceAfterTransaction < MINIMUM_BALANCE) {
                        JOptionPane.showMessageDialog(null, "The current balance is not enough to make a transaction!");
                        return;
                    }

                    // Make a transaction in Client
                    strQuerry = "UPDATE Bank SET Money = " + iBalanceAfterTransaction +
                            " WHERE BankAccount = '" + strBankAccount + "' AND " +
                            "BankName = '" + strBankName + "';";
                    stmt.executeUpdate(strQuerry);

                    connection.commit();
                } catch (SQLException ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }

                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(null, "Transaction Fail!");
                    return;
                } catch (Exception ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }

                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(null, "Transaction Fail!");
                    return;
                } finally {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                ClientBanking clientBanking = new ClientBanking(iPayment);

                // If the transaction is fail,
                // Return the money for the client
                if (clientBanking.getResultTransportationMoney().equals("FAILURE")) {
                    try {
                        connection = Bank.connectInternetBanking();
                        connection.setAutoCommit(false);
                        stmt = connection.createStatement();

                        String strQuerry = "UPDATE Bank SET Money = " + (iBalanceAfterTransaction + iPayment) +
                                " WHERE BankAccount = '" + strBankAccount + "' AND " +
                                "BankName = '" + strBankName + "';";
                        stmt.executeUpdate(strQuerry);

                        connection.commit();
                    } catch (SQLException ex) {
                        try {
                            connection.rollback();
                        } catch (SQLException ex1) {
                            ex1.printStackTrace();
                        }

                        ex.printStackTrace();
                    } catch (Exception ex) {
                        try {
                            connection.rollback();
                        } catch (SQLException ex1) {
                            ex1.printStackTrace();
                        }

                        ex.printStackTrace();
                    } finally {
                        try {
                            stmt.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                        try {
                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Transaction Fail!");
                    return;
                }

                // Transaction Success, handling logical situations:
                // Clear all rows of waiting books
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                dtm.setRowCount(0);

                LabelGetTotalPrice.setText("");
                LabelGetBorrowedDate.setText("");
                LabelGetReturnDate.setText("");

                // Decrease the number of borrowing books and set status of transaction to
                // 'Borrowing'
                try {
                    String strTID = "";
                    connection = LibManagement.connect();
                    connection.setAutoCommit(false);
                    stmt = connection.createStatement();

                    // Get the trasaction ID
                    String strQuerry = "SELECT TID FROM TRANSACTION WHERE CID = '" + currUser.getID() + "' AND " +
                            "Status = 'Waiting';";
                    rs = stmt.executeQuery(strQuerry);
                    while (rs.next()) {
                        strTID = rs.getString("TID");
                    }

                    // Decrease the number of borrowing books
                    strQuerry = "UPDATE BOOK SET HasLeft = HasLeft - 1 " +
                            "WHERE BID IN (SELECT BID FROM DETAILTRANS WHERE TID = '" + strTID + "')";
                    stmt.executeUpdate(strQuerry);

                    // Set status of transaction to 'Borrowing'
                    strQuerry = "UPDATE TRANSACTION SET Status = 'Borrowing' WHERE TID = '" + strTID + "'";
                    stmt.executeUpdate(strQuerry);

                    // Set borrowedDate and returnDate for transaction
                    strQuerry = "UPDATE TRANSACTION SET BorrowedDate = '" + strBorrowedDate + "' WHERE TID = '" + strTID
                            + "'";
                    stmt.executeUpdate(strQuerry);

                    strQuerry = "UPDATE TRANSACTION SET ReturnDate = '" + strReturnDate + "' WHERE TID = '" + strTID
                            + "'";
                    stmt.executeUpdate(strQuerry);

                    connection.commit();
                } catch (SQLException ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }

                    ex.printStackTrace();
                } catch (Exception ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }

                    ex.printStackTrace();
                } finally {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        stmt.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                // Show a notification
                JOptionPane.showMessageDialog(null, "Transaction Success!");
            }
        });
        PanelBackground.add(ButtonContinue);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null);
    }
}

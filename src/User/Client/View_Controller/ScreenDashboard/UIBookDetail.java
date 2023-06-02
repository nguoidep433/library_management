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
import User.User.*;
import User.Client.Model.*;
import User.Client.View_Controller.ScreenCart.UICart;
import User.Client.View_Controller.ScreenHistoryTransaction.UIHistory;
import User.Client.View_Controller.ScreenInteresting.UIInteresting;
import User.Client.View_Controller.ScreenPrivateInfo.UIShowInfos;

public class UIBookDetail extends JFrame{
    private User currUser;

    public UIBookDetail(User user, Book currBook) {
        super("Details Of Book");
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

        ImageIcon IconSetting = new ImageIcon("pictures\\ImageBackground\\LOGO_Setting.png");
        JButton ButtonLogOut = new JButton("Log out", IconSetting);
        ButtonLogOut.setHorizontalTextPosition(SwingConstants.RIGHT);
        ButtonLogOut.setIconTextGap(10);
        ButtonLogOut.setHorizontalAlignment(JButton.LEFT);
        ButtonLogOut.setBounds(0, 572, 190, 40);
        ButtonLogOut.setBackground(Color.decode("#F4FAFB"));
        ButtonLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement lib = new LibManagement();
            }
        });
        PanelBackground.add(ButtonLogOut);

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

        double dRating = (double)Math.ceil(currBook.getRating() * 10) / 10;
        Color colorRating = dRating == 0 ? Color.BLACK : (dRating < 3 ? Color.RED : Color.GREEN);
        JLabel LabelRating = new JLabel(dRating + "/5.0", SwingConstants.CENTER);
        LabelRating.setBounds(410, 410, 100, 30);
        LabelRating.setFont(new Font("Arial", Font.BOLD, 30));
        LabelRating.setForeground(colorRating);
        PanelBackground.add(LabelRating);

        JLabel LabelReview = new JLabel("Rating Book:");
        LabelReview.setBounds(360, 480, 150, 25);
        LabelReview.setFont(new Font("Arial", Font.BOLD, 20));
        PanelBackground.add(LabelReview);

        Integer arrInteger[] = {0, 1, 2, 3, 4, 5};
        int iIndexRatingOfUser = 0;
        JComboBox ComboBoxRating = new JComboBox(arrInteger); 
        ComboBoxRating.setBounds(520, 480, 50, 25);
        if (true) { //What did the user choose?
            Connection connection = null;
            Statement stmt = null;
            ResultSet resultSet = null;

            try {
                connection = LibManagement.connect();
                stmt = connection.createStatement();

                String strQuerry = "SELECT * FROM REVIEW WHERE CID = '" + currUser.getID() + "' AND BID = '" + currBook.getID() + "';";
                resultSet = stmt.executeQuery(strQuerry);
                
                if (resultSet.next()) {
                    iIndexRatingOfUser = resultSet.getInt("RATE"); 
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    resultSet.close();
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
        //Set the current selected rating of client
        ComboBoxRating.setSelectedIndex(iIndexRatingOfUser);
        ComboBoxRating.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int iUserRating = ComboBoxRating.getSelectedIndex();
                Connection connection = null;
                Statement stmt = null;
                ResultSet resultSet = null;

                try {
                    connection = LibManagement.connect();
                    connection.setAutoCommit(false);
                    stmt = connection.createStatement();

                    if (iUserRating == 0) {
                        String strQuerry = "DELETE FROM REVIEW WHERE CID = '" + currUser.getID() + "' AND BID = '" + currBook.getID() + "';";
                        stmt.executeUpdate(strQuerry);

                        connection.commit();
                        //Set a new average rating of book
                        strQuerry = "SELECT AVG(Rate) a FROM REVIEW GROUP BY BID HAVING BID = '" + currBook.getID() + "'";
                        resultSet = stmt.executeQuery(strQuerry);
                        double dNewAvgRating = 0.0;
                        if(resultSet.next()) {
                            dNewAvgRating = (double)Math.ceil(resultSet.getDouble("a") * 10) / 10 ;
                        }
                        
                        LabelRating.setText(dNewAvgRating + "/5.0");
                        Color colorNewRating = dNewAvgRating == 0 ? Color.BLACK : (dNewAvgRating < 3 ? Color.RED : Color.GREEN);
                        LabelRating.setForeground(colorNewRating);
                        currBook.setRating(dNewAvgRating);
                        return;
                    }

                    String strQuerry = "SELECT * FROM REVIEW WHERE CID = '" + currUser.getID() + "' AND BID = '" + currBook.getID() + "';";
                    resultSet = stmt.executeQuery(strQuerry);
                    
                    if (resultSet.next()) { //Update the rating of book on REVIEW table
                        strQuerry = "UPDATE REVIEW SET RATE = " + iUserRating +
                                    " WHERE CID = '" + currUser.getID() + "' AND BID = '" + currBook.getID() + "';";
                        stmt.executeUpdate(strQuerry);
                    } else { //Insert the rating of book into REVIEW table
                        strQuerry = "INSERT INTO REVIEW (CID, BID, RATE) VALUES " +
                                    "('" + currUser.getID() + "', '" + currBook.getID() + "', " + iUserRating + ");";
                        stmt.executeUpdate(strQuerry);
                    }

                    connection.commit();

                    //Set a new average rating of book
                    strQuerry = "SELECT AVG(Rate) a FROM REVIEW GROUP BY BID HAVING BID = '" + currBook.getID() + "'";
                    resultSet = stmt.executeQuery(strQuerry);
                    resultSet.next();

                    double dNewAvgRating = (double)Math.ceil(resultSet.getDouble("a") * 10) / 10 ;
                    LabelRating.setText(dNewAvgRating + "/5.0");
                    Color colorNewRating = dNewAvgRating == 0 ? Color.BLACK : (dNewAvgRating < 3 ? Color.RED : Color.GREEN);
                    LabelRating.setForeground(colorNewRating);
                    currBook.setRating(dNewAvgRating);
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
                        resultSet.close();
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
        });
        PanelBackground.add(ComboBoxRating);

        JButton ButtonLike = new JButton();
        ButtonLike.setBounds(705, 532, 120, 40);
        ButtonLike.setBackground(Color.decode("#95D5E3"));
        ButtonLike.setForeground(Color.decode("#FFF8F7"));
        if (true) { //Set status of like button
            Connection connection = null;
            Statement stmt = null;
            ResultSet resultSet = null;

            try {
                connection = LibManagement.connect();
                stmt = connection.createStatement();

                String strQuerry = "SELECT * FROM INTERESTING WHERE CID = '" + currUser.getID() + "' AND BID = '" + currBook.getID() + "';";
                resultSet = stmt.executeQuery(strQuerry);

                if (resultSet.next()) {
                    ButtonLike.setText("UNLIKE");
                    ButtonLike.setBackground(Color.decode("#FF5722"));
                    ButtonLike.setForeground(Color.decode("#000000"));
                } else {
                    ButtonLike.setText("LIKE");
                    ButtonLike.setBackground(Color.decode("#95D5E3"));
                    ButtonLike.setForeground(Color.decode("#FFF8F7"));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    resultSet.close();
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
        ButtonLike.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                PreparedStatement pstmt = null;

                try {
                    connection = LibManagement.connect();
                    connection.setAutoCommit(false);

                    if (ButtonLike.getText().equals("LIKE")) { //If like button is LIKE, insert data into INTERESTING table
                        String strQuerry = "INSERT INTO INTERESTING (CID, BID) VALUES (?, ?);";
                        pstmt = connection.prepareStatement(strQuerry);
                        pstmt.setString(1, currUser.getID());
                        pstmt.setString(2, currBook.getID());
                        pstmt.executeUpdate();

                        //Set the status of like button
                        ButtonLike.setText("UNLIKE");
                        ButtonLike.setBackground(Color.decode("#FF5722"));
                        ButtonLike.setForeground(Color.decode("#000000"));
                    } else { //If like button is UNLIKE, delete date from INTERESTING table
                        String strQuerry = "DELETE FROM INTERESTING WHERE CID = ? AND BID = ?;";
                        pstmt = connection.prepareStatement(strQuerry);
                        pstmt.setString(1, currUser.getID());
                        pstmt.setString(2, currBook.getID());
                        pstmt.executeUpdate();

                        //Set the status of like button
                        ButtonLike.setText("LIKE");
                        ButtonLike.setBackground(Color.decode("#95D5E3"));
                        ButtonLike.setForeground(Color.decode("#FFF8F7"));
                    }

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
                        pstmt.close();
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
        });
        PanelBackground.add(ButtonLike);

        JButton ButtonAddToCart = new JButton("Add to cart");
        ButtonAddToCart.setBounds(915, 532, 170, 40);
        ButtonAddToCart.setBackground(Color.decode("#95D5E3"));
        ButtonAddToCart.setForeground(Color.decode("#FFF8F7"));
        ButtonAddToCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currBook.getHasLeft() <= 0) {
                    JOptionPane.showMessageDialog(null, "The book is currently out of stock!");
                    return;
                }


                Connection connection = null;
                Statement stmt = null;
                PreparedStatement pstmt = null;
                ResultSet resultSet = null;

                try {
                    connection = LibManagement.connect();
                    connection.setAutoCommit(false);
                    stmt = connection.createStatement();

                    String strQuerry = "SELECT * FROM TRANSACTION WHERE CID = '" + currUser.getID() + "' AND Status = 'Waiting'";
                    resultSet = stmt.executeQuery(strQuerry);

                    
                    if (resultSet.next()) { //If exists the transaction being waiting for payment
                        int iNumOfBooks = 0;
                        String strTID = resultSet.getString("TID");
                        int iTotalPrice = resultSet.getInt("TotalPrice");
                        int iTotalRoutine = resultSet.getInt("TotalRoutine");
                        int iQuantity = resultSet.getInt("Quantity");

                        //If this book is borrowing or waiting, has no transaction
                        strQuerry = "SELECT d.* FROM DETAILTRANS d JOIN TRANSACTION t ON d.TID = t.TID " + 
                                    "WHERE t.CID = '" + currUser.getID() + "' AND (t.Status = 'Waiting' OR t.Status = 'Borrowing');";
                        resultSet = stmt.executeQuery(strQuerry);
                        while (resultSet.next()) {
                            if (resultSet.getString("BID").equals(currBook.getID())){
                                JOptionPane.showMessageDialog(null, "You got this book!");
                                return;
                            }
                        }

                        //Get the number of books of waiting transaction
                        strQuerry = "SELECT COUNT(*) c FROM DETAILTRANS WHERE TID = '" + strTID + "';";
                        resultSet = stmt.executeQuery(strQuerry);
                        resultSet.next();
                        iNumOfBooks += resultSet.getInt("c");

                        //Get the number of books of borrowing transaction
                        strQuerry = "SELECT COUNT(*) c " + 
                                    "FROM DETAILTRANS d JOIN TRANSACTION t ON d.TID = t.TID " +
                                    "WHERE t.CID = '" + currUser.getID() + "' AND t.Status = 'Borrowing'";
                        resultSet = stmt.executeQuery(strQuerry);
                        resultSet.next();
                        iNumOfBooks += resultSet.getInt("c");

                        //If the number of books is greater than or equal to 3, have no transaction
                        if (iNumOfBooks >= 3) {
                            JOptionPane.showMessageDialog(null, "You got the maximum number of book");
                            return;
                        }

                        //If the number of books is less than 3, handling database
                        //Insert this book into detailtransacion
                        strQuerry = "INSERT INTO DETAILTRANS VALUES ('" + strTID + "', '" + currBook.getID() + "', " +
                                    currBook.getPrice() + ", " + currBook.getRoutine() + ");";
                        stmt.executeUpdate(strQuerry);

                        //Update the total price in db transaction
                        iTotalPrice += currBook.getPrice();
                        strQuerry = "UPDATE TRANSACTION SET TotalPrice = " + iTotalPrice + " WHERE TID = '" + strTID + "';";
                        stmt.executeUpdate(strQuerry);

                        //Update the total routine in db transaction
                        iTotalRoutine += currBook.getRoutine();
                        strQuerry = "UPDATE TRANSACTION SET TotalRoutine = " + iTotalRoutine + " WHERE TID = '" + strTID + "';";
                        stmt.executeUpdate(strQuerry);

                        //Update the quantity in db transaction
                        iQuantity += 1;
                        strQuerry = "UPDATE TRANSACTION SET Quantity = " + iQuantity + " WHERE TID = '" + strTID + "';";
                        stmt.executeUpdate(strQuerry);

                        JOptionPane.showMessageDialog(null, "Add book to cart successfully");
                    } else { //If not exists the transaction being waiting for payment
                        int iNumOfBooks = 0;

                        //If this book is borrowing, has no transaction
                        strQuerry = "SELECT * FROM DETAILTRANS d JOIN TRANSACTION t ON d.TID = t.TID " + 
                                    "WHERE t.CID = '" + currUser.getID() + "' AND (t.Status = 'Waiting' OR t.Status = 'Borrowing');";
                        resultSet = stmt.executeQuery(strQuerry);
                        while (resultSet.next()) {
                            if (resultSet.getString("BID").equals(currBook.getID())){
                                JOptionPane.showMessageDialog(null, "You have got this book!");
                                return;
                            }
                        }

                        //Get the number of books of borrowing transaction
                        strQuerry = "SELECT COUNT(*) c " + 
                                    "FROM DETAILTRANS d JOIN TRANSACTION t ON d.TID = t.TID " +
                                    "WHERE t.CID = '" + currUser.getID() + "' AND t.Status = 'Borrowing'";
                        resultSet = stmt.executeQuery(strQuerry);
                        resultSet.next();
                        iNumOfBooks += resultSet.getInt("c");

                        //If the number of books is greater than or equal to 3, have no transaction
                        if (iNumOfBooks >= 3) {
                            JOptionPane.showMessageDialog(null, "You got the maximum number of books of borrowing");
                            return;
                        }

                        //If the number of books is less than or equal to 2, handling database
                        //Generate a new transaction
                        strQuerry = "INSERT INTO TRANSACTION (CID, TotalPrice, TotalRoutine, Quantity, Status) VALUES (?, ?, ?, ?, ?)";
                        pstmt = connection.prepareStatement(strQuerry);
                        pstmt.setString(1, currUser.getID());
                        pstmt.setInt(2, currBook.getPrice());
                        pstmt.setInt(3, currBook.getRoutine());
                        pstmt.setInt(4, 1);
                        pstmt.setString(5, "Waiting");
                        pstmt.executeUpdate();

                        //Insert this book into detailtransacion which has waiting status
                        strQuerry = "SELECT * FROM TRANSACTION WHERE CID = '" + currUser.getID() + "' AND Status = 'Waiting'";
                        resultSet = stmt.executeQuery(strQuerry);
                        resultSet.next();

                        String strTID = resultSet.getString("TID");

                        strQuerry = "INSERT INTO DETAILTRANS VALUES ('" + strTID + "', '" + currBook.getID() + "', " +
                                    currBook.getPrice() + ", " + currBook.getRoutine() + ");";
                        stmt.executeUpdate(strQuerry); 

                        JOptionPane.showMessageDialog(null, "Add book to cart successfully");
                    }

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
                        resultSet.close();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }

                    try {
                        pstmt.close();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }

                    try {
                        stmt.close();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }

                    try {
                        connection.close();
                    } catch (SQLException ex1) {
                        ex1.printStackTrace();
                    }
                }

            }
        });
        PanelBackground.add(ButtonAddToCart);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }
}

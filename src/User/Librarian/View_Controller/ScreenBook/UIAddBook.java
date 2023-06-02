package User.Librarian.View_Controller.ScreenBook;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

import LibManagement.Model.LibManagement;
import User.User.*;
import User.Librarian.View_Controller.ScreenClient.UIListClients;
import User.Librarian.View_Controller.ScreenDashboard.UIDashboard;
import User.Librarian.View_Controller.ScreenLibrarian.UILibrarian;
import User.Librarian.View_Controller.ScreenPrivateInfo.UIShowInfos;
import User.Librarian.View_Controller.ScreenStatistic.*;

public class UIAddBook extends JFrame{
    private User currUser;

    public UIAddBook(User user) {
        super("Add A Book");
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

        //Fill in the form of book
        int iX = 420, iWidth = 200, iHeight = 20, iSize = 20;

        //Book ID's form
        JLabel LabelBID = new JLabel("BookID*:");
        LabelBID.setBounds(iX, 145, iWidth, iHeight);
        LabelBID.setFont(new Font("Arial", Font.BOLD, iSize));
        PanelBackground.add(LabelBID);

        String[] arrStringLetters = {"", "A", "B", "C", "D"};
        String[] arrStringShelf = {"", "0"};
        String[] arrStringDigits = {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        JComboBox ComboBoxLetter1 = new JComboBox(arrStringLetters);
        ComboBoxLetter1.setFont(new Font("Arial", Font.BOLD, 20));
        ComboBoxLetter1.setBounds(625, 145, 40, 30);
        ComboBoxLetter1.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(ComboBoxLetter1);

        JComboBox ComboBoxLetter2 = new JComboBox(arrStringLetters);
        ComboBoxLetter2.setFont(new Font("Arial", Font.BOLD, 20));
        ComboBoxLetter2.setBounds(670, 145, 40, 30);
        ComboBoxLetter2.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(ComboBoxLetter2);

        JComboBox ComboBoxDigit1 = new JComboBox(arrStringShelf);
        ComboBoxDigit1.setFont(new Font("Arial", Font.BOLD, 20));
        ComboBoxDigit1.setBounds(715, 145, 40, 30);
        ComboBoxDigit1.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(ComboBoxDigit1);

        JComboBox ComboBoxDigit2 = new JComboBox(arrStringDigits);
        ComboBoxDigit2.setFont(new Font("Arial", Font.BOLD, 20));
        ComboBoxDigit2.setBounds(760, 145, 40, 30);
        ComboBoxDigit2.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(ComboBoxDigit2);

        JComboBox ComboBoxDigit3 = new JComboBox(arrStringDigits);
        ComboBoxDigit3.setFont(new Font("Arial", Font.BOLD, 20));
        ComboBoxDigit3.setBounds(805, 145, 40, 30);
        ComboBoxDigit3.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(ComboBoxDigit3);

        JComboBox ComboBoxDigit4 = new JComboBox(arrStringDigits);
        ComboBoxDigit4.setFont(new Font("Arial", Font.BOLD, 20));
        ComboBoxDigit4.setBounds(850, 145, 40, 30);
        ComboBoxDigit4.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(ComboBoxDigit4);

        JComboBox ComboBoxDigit5 = new JComboBox(arrStringDigits);
        ComboBoxDigit5.setFont(new Font("Arial", Font.BOLD, 20));
        ComboBoxDigit5.setBounds(895, 145, 40, 30);
        ComboBoxDigit5.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(ComboBoxDigit5);

        //Title's form
        JLabel LabelTitle = new JLabel("Title*:");
        LabelTitle.setBounds(iX, 180, iWidth, iHeight);
        LabelTitle.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelTitle);

        JTextField TextFieldTitle = new JTextField();
        TextFieldTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        TextFieldTitle.setBounds(625, 180, 310, 30);
        TextFieldTitle.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(TextFieldTitle);

        //Author's form
        JLabel LabelAuthor = new JLabel("Author*:");
        LabelAuthor.setBounds(iX, 215, iWidth, iHeight);
        LabelAuthor.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelAuthor);

        JTextField TextFieldAuthor = new JTextField();
        TextFieldAuthor.setFont(new Font("Arial", Font.PLAIN, 20));
        TextFieldAuthor.setBounds(625, 215, 310, 30);
        TextFieldAuthor.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(TextFieldAuthor);

        //Publishing House's form
        JLabel LabelPublishingHouse = new JLabel("Publishing House*:");
        LabelPublishingHouse.setBounds(iX, 250, iWidth, iHeight);
        LabelPublishingHouse.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelPublishingHouse);

        JTextField TextFieldPublishingHouse = new JTextField();
        TextFieldPublishingHouse.setFont(new Font("Arial", Font.PLAIN, 20));
        TextFieldPublishingHouse.setBounds(625, 250, 310, 30);
        TextFieldPublishingHouse.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(TextFieldPublishingHouse);

        //Publishing Year's form
        JLabel LabelPublishingYear = new JLabel("Publishing Year*:");
        LabelPublishingYear.setBounds(iX, 285, iWidth, iHeight);
        LabelPublishingYear.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelPublishingYear);

        JTextField TextFieldPublishingYear = new JTextField();
        TextFieldPublishingYear.setFont(new Font("Arial", Font.PLAIN, 20));
        TextFieldPublishingYear.setBounds(625, 285, 310, 30);
        TextFieldPublishingYear.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(TextFieldPublishingYear);

        //Genre's form
        JLabel LabelGenre = new JLabel("Genre*:");
        LabelGenre.setBounds(iX, 320, iWidth, iHeight);
        LabelGenre.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelGenre);

        String[] arrStringGenre = {"", "Biography", "Novel", "Science", "Self-help", "Drama",
                                "Encyclopedia", "Romance", "Adventure Novels", "Poetry",
                                "Mystery", "Fantasy", "History", "Horror", "Science Fiction",
                                "Memoir"};
        JComboBox ComboBoxGenre = new JComboBox(arrStringGenre);
        ComboBoxGenre.setFont(new Font("Arial", Font.PLAIN, 20));
        ComboBoxGenre.setBounds(625, 320, 310, 30);
        ComboBoxGenre.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(ComboBoxGenre);

        //Has left's form
        JLabel LabelHasLeft = new JLabel("Has Left*:");
        LabelHasLeft.setBounds(iX, 355, iWidth, iHeight);
        LabelHasLeft.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelHasLeft);

        JTextField TextFieldHasLeft = new JTextField();
        TextFieldHasLeft.setFont(new Font("Arial", Font.PLAIN, 20));
        TextFieldHasLeft.setBounds(625, 355, 310, 30);
        TextFieldHasLeft.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(TextFieldHasLeft);

        //Price's form
        JLabel LabelPrice = new JLabel("Price (VND)*:");
        LabelPrice.setBounds(iX, 390, iWidth, iHeight);
        LabelPrice.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelPrice);

        JTextField TextFieldPrice = new JTextField();
        TextFieldPrice.setFont(new Font("Arial", Font.PLAIN, 20));
        TextFieldPrice.setBounds(625, 390, 310, 30);
        TextFieldPrice.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(TextFieldPrice);

        //Routine's form
        JLabel LabelRoutine = new JLabel("Routine (days)*: ");
        LabelRoutine.setBounds(iX, 425, iWidth, iHeight);
        LabelRoutine.setFont(new Font("Arial", Font.PLAIN, iSize));
        PanelBackground.add(LabelRoutine);

        JTextField TextFieldRoutine = new JTextField();
        TextFieldRoutine.setFont(new Font("Arial", Font.PLAIN, 20));
        TextFieldRoutine.setBounds(625, 425, 310, 30);
        TextFieldRoutine.setBackground(Color.decode("#FFFAF0"));
        PanelBackground.add(TextFieldRoutine);
        
        //Add new book
        JButton ButtonAddBook = new JButton("Add");
        ButtonAddBook.setBounds(915, 532, 120, 40);
        ButtonAddBook.setBackground(Color.decode("#95D5E3"));
        ButtonAddBook.setForeground(Color.decode("#FFF8F7"));
        ButtonAddBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strBookIDLetter1 = ComboBoxLetter1.getSelectedItem() + "";
                String strBookIDLetter2 = ComboBoxLetter2.getSelectedItem() + "";
                String strBookIDDigit1 = ComboBoxDigit1.getSelectedItem() + "";
                String strBookIDDigit2 = ComboBoxDigit2.getSelectedItem() + "";
                String strBookIDDigit3 = ComboBoxDigit3.getSelectedItem() + "";
                String strBookIDDigit4 = ComboBoxDigit4.getSelectedItem() + "";
                String strBookIDDigit5 = ComboBoxDigit5.getSelectedItem() + "";
                String strBookID = strBookIDLetter1 + strBookIDLetter2 + strBookIDDigit1 + strBookIDDigit2 + 
                                strBookIDDigit3 + strBookIDDigit4 + strBookIDDigit5;
                String strPlace = "Department " + strBookIDLetter1 + " - Shelf " + strBookIDLetter2 + strBookIDDigit1 + strBookIDDigit2;
                String strPathImage = "ImageBooks\\" + strBookID + ".png";
                String strTitle = TextFieldTitle.getText();
                String strAuthor = TextFieldAuthor.getText();
                String strPublishingHouse = TextFieldPublishingHouse.getText();
                String strPublishingYear = TextFieldPublishingYear.getText();
                String strGenre = ComboBoxGenre.getSelectedItem() + "";
                String strHasLeft = TextFieldHasLeft.getText();
                String strPrice = TextFieldPrice.getText();
                String strRoutine = TextFieldRoutine.getText();

                //If has at least one empty blank, not save that book
                if (strBookID.length() != 7 || strTitle.equals("") || strAuthor.equals("") || 
                strPublishingHouse.equals("") || strPublishingYear.equals("") || strGenre.equals("") ||
                strHasLeft.equals("") || strPrice.equals("") || strRoutine.equals("")) {
                    JOptionPane.showMessageDialog(null, "Some blank is not filled in!");
                    return;
                }

                //Get the format number of some blanks
                int iPublishingYear = 0;
                try {
                    iPublishingYear = Integer.parseInt(strPublishingYear);

                    int iCurrentYear = (java.time.LocalDate.now()).getYear();
                    //Check the year correctly
                    if (iPublishingYear < 1700 || iPublishingYear > iCurrentYear) {
                        JOptionPane.showMessageDialog(null, "Not correct year! Have to be after 1700");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Not correct year!");
                    return;
                }

                int iHasLeft = 0;
                if (!TextFieldHasLeft.getText().equals("")) {
                    try {
                        iHasLeft = Integer.parseInt(strHasLeft);

                        if (iHasLeft < 0) {
                            JOptionPane.showMessageDialog(null, "Invalid Number!");
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid Number!");
                        return;
                    }
                }

                int iPrice = 0;
                try {
                    iPrice = Integer.parseInt(strPrice);

                    int iLowestListedPrice = 5000;
                    if (iPrice < iLowestListedPrice) {
                        JOptionPane.showMessageDialog(null, "Invalid Price! Have to be greater than or equal to" +
                                                    iLowestListedPrice + " VND");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Price!");
                    return;
                }

                int iRoutine = 0;
                try {
                    iRoutine = Integer.parseInt(strRoutine);

                    int iGreatestRoutine = 12;
                    int iLowestRoutine = 3;
                    if (iRoutine < iLowestRoutine || iRoutine > iGreatestRoutine) {
                        JOptionPane.showMessageDialog(null, "Invalid Routine! A book has a routine from " +
                                                    iLowestRoutine + " days to " + iGreatestRoutine + " days!");
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Routine!");
                    return;
                }

                //Save the new book
                Connection connection = null;
                Statement stmt = null;
                PreparedStatement pstmt = null;
                ResultSet resultSet = null;
                String strQuerry = "";

                try {
                    connection = LibManagement.connect();
                    connection.setAutoCommit(false);
                    stmt = connection.createStatement();

                    //Check the book's id has existed before
                    strQuerry = "SELECT * FROM BOOK WHERE BID = '" + strBookID + "';";
                    resultSet = stmt.executeQuery(strQuerry);

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(null, strBookID + " has existed!");
                        return;
                    }
                    
                    //Check the book's title has existed before
                    strQuerry = "SELECT * FROM BOOK WHERE Tittle LIKE '" + strTitle + "';";
                    resultSet = stmt.executeQuery(strQuerry);

                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(null, strTitle + " has existed!");
                        return;
                    }

                    //Insert data into BOOK TABLE
                    strQuerry = "INSERT INTO BOOK (BID, Tittle, Author, PublishingHouse, PostedYear, Genre, HasLeft, Place, PathImage) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
                    pstmt = connection.prepareStatement(strQuerry);
                    pstmt.setString(1, strBookID);
                    pstmt.setString(2, strTitle);
                    pstmt.setString(3, strAuthor);
                    pstmt.setString(4, strPublishingHouse);
                    pstmt.setInt(5, iPublishingYear);
                    pstmt.setString(6, strGenre);
                    pstmt.setInt(7, iHasLeft);
                    pstmt.setString(8, strPlace);
                    pstmt.setString(9, strPathImage);
                    pstmt.executeUpdate();

                    //Insert data into BORROWING TABLE
                    strQuerry = "INSERT INTO BORROWING VALUES (?, ?, ?);";
                    pstmt = connection.prepareStatement(strQuerry);
                    pstmt.setString(1, strBookID);
                    pstmt.setInt(2, iPrice);
                    pstmt.setInt(3, iRoutine);
                    pstmt.executeUpdate();

                    connection.commit();

                    JFrame FrameChangeScreen = new UIListBooks(currUser);
                    JOptionPane.showMessageDialog(null, "Save book " + strBookID + " successfully! Back to the list of books");
                    LibManagement.getCurrFrame().dispose();
                    LibManagement.setFrame(FrameChangeScreen);
                    LibManagement.getCurrFrame().setVisible(true);
                } catch (SQLException ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException ex2) {
                        ex2.printStackTrace();
                    }

                    ex.printStackTrace();
                } catch (Exception ex) {
                    try {
                        connection.rollback();
                    } catch (SQLException ex2) {
                        ex2.printStackTrace();
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
        PanelBackground.add(ButtonAddBook);

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

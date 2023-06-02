package User.Librarian.View_Controller.ScreenBook;

import java.awt.*;
import java.sql.*;
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

public class UIUpdateBook extends JFrame{
    private User currUser;
    private Book currBook;

    public UIUpdateBook(User user, Book book) {
        super("Update Book");
        this.currBook = book;
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

        //Update book's info
        JLabel LabelUpdateBook = new JLabel("UPDATE " + currBook.getID());
        LabelUpdateBook.setBounds(458, 77, 570, 70);
        LabelUpdateBook.setBackground(Color.decode("#FFFFFF"));
        LabelUpdateBook.setForeground(Color.decode("#7C8BFF"));
        LabelUpdateBook.setFont(new Font("Arial", Font.BOLD, 30));
        LabelUpdateBook.setHorizontalAlignment(JLabel.CENTER);
        LabelUpdateBook.setOpaque(true);
        PanelBackground.add(LabelUpdateBook);

        JPanel PanelUpdate = new JPanel();
        PanelUpdate.setBounds(458, 152, 570, 430);
        PanelUpdate.setBackground(Color.decode("#FFFFFF"));
        PanelUpdate.setLayout(null);
        PanelBackground.add(PanelUpdate);

        JLabel LabelTitle  = new JLabel("Title");
        LabelTitle.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelTitle.setBounds(18, 16, 100, 33);
        PanelUpdate.add(LabelTitle);

        JTextField TextFieldTitle = new JTextField();
        TextFieldTitle.setFont(new Font("Arial", Font.PLAIN, 25));
        TextFieldTitle.setBounds(150, 16, 370, 33);
        TextFieldTitle.setBackground(Color.decode("#FFFAF0"));
        PanelUpdate.add(TextFieldTitle);

        JLabel LabelAuthor = new JLabel("Author");
        LabelAuthor.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelAuthor.setBounds(18, 67, 100, 33);
        PanelUpdate.add(LabelAuthor);

        JTextField TextFieldAuthor = new JTextField();
        TextFieldAuthor.setFont(new Font("Arial", Font.PLAIN, 25));
        TextFieldAuthor.setBounds(150, 67, 370, 33);
        TextFieldAuthor.setBackground(Color.decode("#FFFAF0"));
        PanelUpdate.add(TextFieldAuthor);

        JLabel LabelPublishingHouse = new JLabel("Publishing House");
        LabelPublishingHouse.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelPublishingHouse.setBounds(18, 125, 120, 33);
        PanelUpdate.add(LabelPublishingHouse);

        JTextField TextFieldPublishingHouse = new JTextField();
        TextFieldPublishingHouse.setFont(new Font("Arial", Font.PLAIN, 25));
        TextFieldPublishingHouse.setBounds(150, 125, 370, 33);
        TextFieldPublishingHouse.setBackground(Color.decode("#FFFAF0"));
        PanelUpdate.add(TextFieldPublishingHouse);

        JLabel LabelPublishingYear = new JLabel("Publishing Year");
        LabelPublishingYear.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelPublishingYear.setBounds(18, 180, 120, 33);
        PanelUpdate.add(LabelPublishingYear);

        JTextField TextFieldPublishingYear = new JTextField();
        TextFieldPublishingYear.setFont(new Font("Arial", Font.PLAIN, 25));
        TextFieldPublishingYear.setBounds(150, 180, 370, 33);
        TextFieldPublishingYear.setBackground(Color.decode("#FFFAF0"));
        PanelUpdate.add(TextFieldPublishingYear);

        JLabel LabelGenre = new JLabel("Genre");
        LabelGenre.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelGenre.setBounds(18, 237, 100, 33);
        PanelUpdate.add(LabelGenre);

        String[] arrStringGenre = {"Biography", "Novel", "Science", "Self-help", "Drama",
                                "Encyclopedia", "Romance", "Adventure Novels", "Poetry",
                                "Mystery", "Fantasy", "History", "Horror", "Science Fiction",
                                "Memoir"};
        JComboBox ComboBoxGenre = new JComboBox(arrStringGenre);
        ComboBoxGenre.setFont(new Font("Arial", Font.PLAIN, 25));
        ComboBoxGenre.setBounds(150, 237, 370, 33);
        ComboBoxGenre.setBackground(Color.decode("#FFFAF0"));
        //Find out the current genre of book
        for (int i = 0; i < arrStringGenre.length; i++) {
            if (arrStringGenre[i].equals(currBook.getGenre())) {
                ComboBoxGenre.setSelectedIndex(i);
                break;
            }
        }
        PanelUpdate.add(ComboBoxGenre);

        JLabel LabelEditQuantiy = new JLabel("Edit Quantity");
        LabelEditQuantiy.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelEditQuantiy.setBounds(18, 287, 105, 33);
        PanelUpdate.add(LabelEditQuantiy);

        Character[] arrCharFrequency = {'+', '-'};
        JComboBox ComboBoxEditQuantity = new JComboBox(arrCharFrequency);
        ComboBoxEditQuantity.setBounds(150, 287, 50, 33);
        ComboBoxEditQuantity.setFont(new Font("Arial", Font.BOLD, 25));
        ComboBoxEditQuantity.setBackground(Color.decode("#FFFAF0"));
        ComboBoxEditQuantity.setSelectedIndex(0);
        PanelUpdate.add(ComboBoxEditQuantity);

        JTextField TextfieldEditQuantity = new JTextField();
        TextfieldEditQuantity.setFont(new Font("Arial", Font.PLAIN, 25));
        TextfieldEditQuantity.setBounds(205, 287, 100, 33);
        TextfieldEditQuantity.setBackground(Color.decode("#FFFAF0"));
        PanelUpdate.add(TextfieldEditQuantity);

        JLabel LabelPrice = new JLabel("Price");
        LabelPrice.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelPrice.setBounds(18, 340, 100, 17);
        PanelUpdate.add(LabelPrice);

        JTextField TextFieldPrice = new JTextField();
        TextFieldPrice.setFont(new Font("Arial", Font.PLAIN, 25));
        TextFieldPrice.setBounds(150, 340, 370, 33);
        TextFieldPrice.setBackground(Color.decode("#FFFAF0"));
        PanelUpdate.add(TextFieldPrice);

        JLabel LabelRoutine = new JLabel("Routine");
        LabelRoutine.setFont(new Font("Arial", Font.PLAIN, 15));
        LabelRoutine.setBounds(18, 390, 100, 17);
        PanelUpdate.add(LabelRoutine);

        JTextField TextFieldRoutine = new JTextField();
        TextFieldRoutine.setFont(new Font("Arial", Font.PLAIN, 25));
        TextFieldRoutine.setBounds(150, 390, 370, 33);
        TextFieldRoutine.setBackground(Color.decode("#FFFAF0"));
        PanelUpdate.add(TextFieldRoutine);

        //Update the current book
        JButton ButtonUpdateBook = new JButton("Update");
        ButtonUpdateBook.setBounds(915, 582, 120, 40);
        ButtonUpdateBook.setBackground(Color.decode("#95D5E3"));
        ButtonUpdateBook.setForeground(Color.decode("#FFF8F7"));
        ButtonUpdateBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int iPublishingYear = 0;
                if (!TextFieldPublishingYear.getText().equals("")) {
                    try {
                        iPublishingYear = Integer.parseInt(TextFieldPublishingYear.getText());

                        int iCurrentYear = (java.time.LocalDate.now()).getYear();
                        //Check the year correctly
                        if (iPublishingYear < 1700 || iPublishingYear > iCurrentYear) {
                            JOptionPane.showMessageDialog(null, "Not correct year!");
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Not correct year!");
                        return;
                    }
                }

                int iEditQuantity = 0;
                if (!TextfieldEditQuantity.getText().equals("")) {
                    try {
                        iEditQuantity = Integer.parseInt(TextfieldEditQuantity.getText());

                        if (iEditQuantity < 0) {
                            JOptionPane.showMessageDialog(null, "Invalid Number!");
                            return;
                        }

                        String strSignalFrequency = ComboBoxEditQuantity.getSelectedItem() + "";
                        if (strSignalFrequency.charAt(0) == '-' && (currBook.getHasLeft() - iEditQuantity) <= 0) {
                            JOptionPane.showMessageDialog(null, "The quantity is greater than or equal to the current number of book!");
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid Number!");
                        return;
                    }
                }

                int iPrice = 0;
                if (!TextFieldPrice.getText().equals("")) {
                    try {
                        iPrice = Integer.parseInt(TextFieldPrice.getText());

                        int iLowestListedPrice = 5000;
                        if (iPrice < iLowestListedPrice) {
                            JOptionPane.showMessageDialog(null, "Invalid Price! Have to be greater than " +
                                                        iLowestListedPrice + " VND");
                            return;
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid Price!");
                        return;
                    }
                }

                int iRoutine = 0;
                if (!TextFieldRoutine.getText().equals("")) {
                    try {
                        iRoutine = Integer.parseInt(TextFieldRoutine.getText());

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
                }

                Connection connection = null;
                Statement stmt = null;
                ResultSet rs = null;
                String strQuerry = null;

                try {
                    connection = LibManagement.connect();
                    connection.setAutoCommit(false);
                    stmt = connection.createStatement();

                    //Save the title of book
                    if (!TextFieldTitle.getText().equals("")) {
                        strQuerry = "UPDATE BOOK SET Tittle = '" + TextFieldTitle.getText() + "' WHERE BID = '" + currBook.getID() + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    //Save the author of book
                    if (!TextFieldAuthor.getText().equals("")) {
                        strQuerry = "UPDATE BOOK SET Author = '" + TextFieldAuthor.getText() + "' WHERE BID = '" + currBook.getID() + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    //Save the publishing house of book
                    if (!TextFieldPublishingHouse.getText().equals("")) {
                        strQuerry = "UPDATE BOOK SET PublishingHouse = '" + TextFieldPublishingHouse.getText() +
                                    "' WHERE BID = '" + currBook.getID() + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    //Save the publishing year of book
                    if (!TextFieldPublishingYear.getText().equals("")) {
                        strQuerry = "UPDATE BOOK SET PostedYear = " + iPublishingYear + " WHERE BID = '" + currBook.getID() + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    //Save the genre of book
                    if (!(ComboBoxGenre.getSelectedItem() + "").equals(currBook.getGenre())) {
                        strQuerry = "UPDATE BOOK SET Genre = '" + ComboBoxGenre.getSelectedItem() +
                                    "' WHERE BID = '" + currBook.getID() + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    //Save the new quantity of book
                    if (!TextfieldEditQuantity.getText().equals("")) {
                        String strSignalFrequency = ComboBoxEditQuantity.getSelectedItem() + "";

                        if (strSignalFrequency.charAt(0) == '+') {
                            strQuerry = "UPDATE BOOK SET HasLeft = " + (currBook.getHasLeft() + iEditQuantity) +
                                        " WHERE BID = '" + currBook.getID() + "';";
                            stmt.executeUpdate(strQuerry);
                        } else {
                            strQuerry = "UPDATE BOOK SET HasLeft = " + (currBook.getHasLeft() - iEditQuantity) +
                                        " WHERE BID = '" + currBook.getID() + "';";
                            stmt.executeUpdate(strQuerry);
                        }
                    }

                    //Save the price of book
                    if (!TextFieldPrice.getText().equals("")) {
                        strQuerry = "UPDATE BORROWING SET Price = " + iPrice + " WHERE BID = '" + currBook.getID() + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    //Save the rountine of book
                    if (!TextFieldRoutine.getText().equals("")) {
                        strQuerry = "UPDATE BORROWING SET Routine = " + iRoutine + " WHERE BID = '" + currBook.getID() + "';";
                        stmt.executeUpdate(strQuerry);
                    }

                    connection.commit();

                    //Show a notification
                    JOptionPane.showMessageDialog(null, "Update Success! Back to detail of " + currBook.getID());

                    strQuerry = "SELECT * FROM BOOK b JOIN BORROWING br ON b.BID = br.BID WHERE b.BID = '" + currBook.getID() + "';";
                    rs = stmt.executeQuery(strQuerry);
                    while (rs.next()) {
                        String strID = rs.getString("BID");
                        String strTitle = rs.getString("Tittle");
                        String strAuthor = rs.getString("Author");
                        String strPH = rs.getString("PublishingHouse");
                        int iPostedYear = rs.getInt("PostedYear");
                        String strGenre = rs.getString("Genre");
                        int iHasLeft = rs.getInt("HasLeft");
                        String strPlace = rs.getString("Place");
                        iPrice = rs.getInt("Price");
                        iRoutine = rs.getInt("Routine");
                        String strPathBook = "pictures\\" + rs.getString("PathImage");

                        currBook = new Book(strID, strTitle, strAuthor, strPH, iPostedYear, strGenre, iHasLeft, strPlace, iPrice, iRoutine, strPathBook);
                    }

                    LibManagement.getCurrFrame().dispose();
                    LibManagement.setFrame(new UIBookDetail(currUser, currBook));
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
        });
        PanelBackground.add(ButtonUpdateBook);

        //Back to the detail of current book
        JButton ButtonBack = new JButton("Back");
        ButtonBack.setBounds(450, 582, 120, 40);
        ButtonBack.setBackground(Color.decode("#95D5E3"));
        ButtonBack.setForeground(Color.decode("#FFF8F7"));
        ButtonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIBookDetail(currUser, currBook));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonBack);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }
}

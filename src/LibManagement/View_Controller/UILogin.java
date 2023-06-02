package LibManagement.View_Controller;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;

import LibManagement.Model.LibManagement;
import User.User.*;
import User.Client.Model.Client;
import User.Librarian.Model.Librarian;

public class UILogin extends JFrame {
    public UILogin() {
        super("Login");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1195, 650));
        getContentPane().setBackground(Color.decode("#FFFFFF"));
        pack();
        Container c = getContentPane();
        c.setLayout(null);
        // Font font = new Font("Arial", Font.BOLD, 27);

        // JButton ButtonAbout = new JButton("About");
        // ButtonAbout.setBounds(65, 74, 75, 30);
        // ButtonAbout.setBackground(Color.decode("#FFFDF6"));
        // c.add(ButtonAbout);

        JLabel LabelSignIn = new JLabel("Sign In");
        LabelSignIn.setBounds(180, 74, 85, 30);
        LabelSignIn.setBackground(Color.decode("#FFFDF6"));
        LabelSignIn.setForeground(Color.decode("#FF0000"));
        c.add(LabelSignIn);

        JButton ButtonRegister = new JButton("Register");
        ButtonRegister.setBounds(265, 74, 85, 30);
        ButtonRegister.setBackground(Color.decode("#FFFDF6"));
        ButtonRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIRegister());
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        c.add(ButtonRegister);

        JTextField TextFieldUsername = new JTextField("Enter Username");
        TextFieldUsername.setBounds(64, 253, 400, 57);
        TextFieldUsername.setBackground(Color.decode("#D4FAFA"));
        TextFieldUsername.setFont(new Font("Arial", Font.BOLD, 25));
        TextFieldUsername.setForeground(Color.decode("#ADAEB3"));
        TextFieldUsername.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (TextFieldUsername.getText().equals("Enter Username")) {
                    TextFieldUsername.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (TextFieldUsername.getText().equals("")) {
                    TextFieldUsername.setText("Enter Username");
                }
            }
        });
        c.add(TextFieldUsername);

        JPasswordField TextFieldPassWord = new JPasswordField("PassWord");
        TextFieldPassWord.setBounds(64, 343, 400, 57);
        TextFieldPassWord.setBackground(Color.decode("#D4FAFA"));
        TextFieldPassWord.setForeground(Color.decode("#ADAEB3"));
        TextFieldPassWord.setFont(new Font("Arial", Font.BOLD, 25));
        TextFieldPassWord.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (TextFieldPassWord.getText().equals("PassWord")) {
                    TextFieldPassWord.setText("");
                }
            }

            // @Override
            public void focusLost(FocusEvent e) {
                if (TextFieldPassWord.getText().equals("")) {
                    TextFieldPassWord.setText("PassWord");
                }
            }
        });
        c.add(TextFieldPassWord);

        // JButton ButtonForgetPassWord = new JButton("Forget Password?");
        // ButtonForgetPassWord.setBounds(303, 410, 142, 35);
        // ButtonForgetPassWord.setBackground(Color.decode("#FFFDF6"));
        // ButtonForgetPassWord.setForeground(Color.decode("#C7C8C9"));
        // c.add(ButtonForgetPassWord);

        JButton ButtonSignIn = new JButton("Sign In");
        ButtonSignIn.setBounds(64, 490, 400, 55);
        ButtonSignIn.setBackground(Color.decode("#000000"));
        ButtonSignIn.setForeground(Color.decode("#F8F6F7"));
        ButtonSignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strUsername = TextFieldUsername.getText();
                String strPassword = String.valueOf(TextFieldPassWord.getPassword());

                if (strUsername.equals("")){ //If have no username
                    JOptionPane.showMessageDialog(null, "Enter the username");
                } else if (strPassword.equals("")){ //If have no password
                    JOptionPane.showMessageDialog(null, "Enter the password");
                } else {
                    Connection connection = LibManagement.connect();
                    ResultSet resultSet = null;
                    Statement stmt = null;

                    if (connection == null){
                        return;
                    }
                    try{
                        stmt = connection.createStatement();
                    
                        String strQuery = "SELECT * FROM USER WHERE Username = '" + strUsername + "' AND Password = '" + strPassword + "'";

                        resultSet = stmt.executeQuery(strQuery);

                        if (resultSet.next() == false){
                            System.out.println("User does not exist");
                            JOptionPane.showMessageDialog(null, "Wrong username or password!");
                        } else {
                            //Check error lowercase in database
                            if (resultSet.getString("Username").equals(strUsername) == false){
                                System.out.println("User does not exist");
                                JOptionPane.showMessageDialog(null, "Wrong username or password!");
                                return;
                            }

                            int iTypeUser = resultSet.getInt("TypeUser");
                            User user = null;

                            if (iTypeUser == 0){ //This is a librarian
                                strQuery = "SELECT * FROM LIBRARIAN WHERE Username = '" + strUsername + "';";
                                resultSet = stmt.executeQuery(strQuery);
                                resultSet.next();

                                //Get infos from database
                                String strID = resultSet.getString(1);
                                String strFullname = resultSet.getString(2);
                                String strPhoneNum = resultSet.getString(3);
                                String strEmail = resultSet.getString(4);
                                String strGender = resultSet.getString(5);
                                String strDepartment = resultSet.getString(6);
                                java.util.Date dateCreatedDate = new java.util.Date(resultSet.getDate(7).getTime());
                                resultSet.close();
                                //Set infos to object
                                user = new Librarian(strID, strFullname, strPhoneNum, strEmail, strGender, dateCreatedDate, strDepartment);
                                
                                LibManagement.getCurrFrame().dispose();
                                LibManagement.setFrame(user.getDashBoard());
                                LibManagement.getCurrFrame().setVisible(true);
                            } else { //This is a client
                                strQuery = "SELECT * FROM CLIENT WHERE Username = '" + strUsername + "';";
                                resultSet = stmt.executeQuery(strQuery);
                                resultSet.next();

                                //Get infos from database
                                String strID = resultSet.getString(1);
                                String strFullname = resultSet.getString(2);
                                String strPhoneNum = resultSet.getString(3);
                                String strEmail = resultSet.getString(4);
                                String strGender = resultSet.getString(5);
                                String strAddress = resultSet.getString(6);
                                String strBankAccount = resultSet.getString(7);
                                String strBankName = resultSet.getString(8);
                                java.util.Date dateCreatedDate = new java.util.Date(resultSet.getDate(9).getTime());
                                //Set infos to object
                                user = new Client(strID, strFullname, strPhoneNum, strEmail, strGender, dateCreatedDate,
                                                    strAddress, strBankAccount, strBankName);
                                
                                LibManagement.getCurrFrame().dispose();
                                LibManagement.setFrame(user.getDashBoard());
                                LibManagement.getCurrFrame().setVisible(true);
                            }
                        }
                         
                    } catch (Exception ex){
                        ex.printStackTrace();
                    } finally {
                        try {
                            resultSet.close();
                        } catch (Exception ex){
                            ex.printStackTrace();
                        }

                        try {
                            stmt.close();
                        } catch (Exception ex){
                            ex.printStackTrace();
                        }

                        try {
                            connection.close();
                        } catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    
                }
            }
        });
        c.add(ButtonSignIn);

        JLabel LabelImage = new JLabel();
        String strImagePath = "pictures\\ImageBackground\\a.png"; //The path of image
        LabelImage.setIcon(new ImageIcon(strImagePath));
        Dimension size = LabelImage.getPreferredSize();
        LabelImage.setBounds(593, 179, size.width, size.height);
        c.add(LabelImage);

        JLabel LabelSignInto = new JLabel("Sign In to");
        LabelSignInto.setBounds(545, 80, 260, 45);
        LabelSignInto.setFont(new Font("Arial", Font.BOLD, 35));
        LabelSignInto.setBackground(Color.decode("#FFFFFF"));
        c.add(LabelSignInto);

        JLabel LabelLibLibrary = new JLabel("Lib Management");
        LabelLibLibrary.setBounds(555, 128, 500, 45);
        LabelLibLibrary.setFont(new Font("Arial", Font.BOLD, 35));
        LabelLibLibrary.setBackground(Color.decode("#FFFFFF"));
        c.add(LabelLibLibrary);

        setLocationRelativeTo(null);
    }
}

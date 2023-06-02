package InternetBanking.Bank;

import java.sql.*;

public class Bank {
    private String strBankAccount;
    private int iMoney;
    private String strBankName;

    public Bank(String strBankAccount, int iMoney, String strBankName) {
        this.strBankAccount = strBankAccount;
        this.strBankName = strBankName;
        this.iMoney = iMoney;
    }

    public static Connection connectInternetBanking() {
        try {
            final String DATABASE_NAME = "internetbanking";
            final String USER = "1111";
            final String PW = "1111";
            final String PATH = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;

            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Loaded driver");
            Connection con = DriverManager.getConnection(PATH, USER, PW);
            //System.out.println("Connected to MySQL");
            return con;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getBankAccount() {
        return this.strBankAccount;
    }

    public String getBankName() {
        return this.strBankName;
    }

    public int getMoney() {
        return this.iMoney;
    }
}

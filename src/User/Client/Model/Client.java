package User.Client.Model;

import javax.swing.*;

import User.User.User;
import User.Client.View_Controller.ScreenDashboard.UIDashboard;

//Class client----------------------------------------------------------------------------------------------------------
public class Client extends User{
    private String address;
    private String bankAccount;
    private String bankName;

    public Client(String id, String fullname, String phoneNumber, String emailAddress, String gender,
        java.util.Date createdDate, String address, String bankAccount, String bankName){   
        super(id, fullname, phoneNumber, emailAddress, gender, createdDate);
        this.address = address;
        this.bankAccount = bankAccount;
        this.bankName = bankName;
    }

    //Getter 
    public String getAddress() { return this.address; }

    public String getBankAccount() { return this.bankAccount; }

    public String getBankName() { return this.bankName; }
    
    @Override
    public JFrame getDashBoard(){
        return new UIDashboard(this);
    }
}
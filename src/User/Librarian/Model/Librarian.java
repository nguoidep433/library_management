package User.Librarian.Model;

import javax.swing.*;
import User.User.*;
import User.Librarian.View_Controller.ScreenDashboard.UIDashboard;

public class Librarian extends User{
    private String department;

    public Librarian(String id, String fullname, String phoneNumber, String emailAddress,
            String gender, java.util.Date createdDate, String department){
        super(id, fullname, phoneNumber, emailAddress, gender, createdDate);
        this.department = department;
    }

    public String getDepartment(){
        return this.department;
    }

    @Override
    public JFrame getDashBoard(){
        return new UIDashboard(this);
    }

    
}
package LibManagement.Model;

import java.sql.*;
import javax.swing.*;

import LibManagement.View_Controller.UILogin;

public class LibManagement {
    public static final String DATABASE_NAME = "libmanagement";
    private static JFrame currFrame;

    public LibManagement() {
        currFrame = new UILogin();
        currFrame.setVisible(true);
    }

    public static JFrame getCurrFrame() {
        return currFrame;
    }

    public static void setFrame(JFrame frame) {
        currFrame = frame;
    }

    public static Connection connect() {
        try {
            String user = "1111";
            String pw = "1111";
            String path = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;

            Class.forName("com.mysql.cj.jdbc.Driver");
            // System.out.println("Loaded driver");
            Connection con = DriverManager.getConnection(path, user, pw);
            // System.out.println("Connected to MySQL");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void createDB() throws SQLException {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/mysql?user=1111&password=1111");
            resultSet = connection.getMetaData().getCatalogs();

            while (resultSet.next()) {
                // Get database name
                String dbname = resultSet.getString(1);

                // If database existed, return this
                if (dbname.equals(DATABASE_NAME)) {
                    try {
                        resultSet.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    try {
                        connection.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    return;
                }

            }
            connection.setAutoCommit(false);
            stmt = connection.createStatement();

            // Create database
            stmt.executeUpdate("CREATE DATABASE " + DATABASE_NAME);
            // Use database
            stmt.executeUpdate("USE " + DATABASE_NAME);

            // Set commands
            String strCreateTableUser = "CREATE TABLE USER(" +
                    "Username VARCHAR(255) NOT NULL, " +
                    "Password VARCHAR(255) NOT NULL, " +
                    "TypeUser int NOT NULL DEFAULT 1, " +
                    "PRIMARY KEY (Username));";
            stmt.executeUpdate(strCreateTableUser);

            String strCreateTableLibrarian = "CREATE TABLE LIBRARIAN(" +
                    "LID VARCHAR(5) NOT NULL, " +
                    "Fullname NVARCHAR(50), " +
                    "PhoneNum VARCHAR(10), " +
                    "Email VARCHAR(255), " +
                    "Gender NVARCHAR(10) CHECK (Gender = 'Male' OR Gender = 'Female' OR Gender = 'Other'), " +
                    "Department VARCHAR(255), " +
                    "CreatedDate DATE DEFAULT (CURRENT_DATE), " +
                    "Username VARCHAR(255), " +
                    "PRIMARY KEY (LID));";
            stmt.executeUpdate(strCreateTableLibrarian);

            String strCreateTableClient = "CREATE TABLE CLIENT(" +
                    "CID VARCHAR(5) NOT NULL, " +
                    "Fullname VARCHAR(50), " +
                    "PhoneNum VARCHAR(10), " +
                    "Email VARCHAR(255), " +
                    "Gender VARCHAR(10) CHECK (Gender = 'Male' OR Gender = 'Female' OR Gender = 'Other'), " +
                    "Address VARCHAR(100), " +
                    "BankAccount VARCHAR(100), " +
                    "BankName VARCHAR(100), " +
                    "CreatedDate DATE DEFAULT (CURRENT_DATE), " +
                    "Username VARCHAR(255), " +
                    "PRIMARY KEY (CID));";
            stmt.executeUpdate(strCreateTableClient);

            String strCreateTableBook = "CREATE TABLE BOOK(" +
                    "BID VARCHAR(255) NOT NULL, " +
                    "Tittle VARCHAR(50), " +
                    "Author VARCHAR(50), " +
                    "PublishingHouse VARCHAR(50), " +
                    "PostedYear INT, " +
                    "Genre VARCHAR(50), " +
                    "HasLeft int DEFAULT 0 CHECK (HasLeft >= 0), " +
                    "Place VARCHAR(50), " +
                    "PathImage VARCHAR(30), " +
                    "PRIMARY KEY (BID));";
            stmt.executeUpdate(strCreateTableBook);

            String strCreateTableReview = "CREATE TABLE REVIEW(" +
                    "BID VARCHAR(255) NOT NULL, " +
                    "CID VARCHAR(5) NOT NULL, " +
                    "Rate int DEFAULT 0 CHECK (0 <= Rate && Rate <= 5), " +
                    "PRIMARY KEY (BID, CID));";
            stmt.executeUpdate(strCreateTableReview);

            String strCreateTableInteresting = "CREATE TABLE INTERESTING(" +
                    "CID VARCHAR(5) NOT NULL, " +
                    "BID VARCHAR(255) NOT NULL, " +
                    "PRIMARY KEY (CID, BID));";
            stmt.executeUpdate(strCreateTableInteresting);

            String strCreateTableBorrowing = "CREATE TABLE BORROWING(" +
                    "BID VARCHAR(255) NOT NULL, " +
                    "Price int NOT NULL DEFAULT 25000, " +
                    "Routine int NOT NULL DEFAULT 7, " +
                    "PRIMARY KEY (BID));";
            stmt.executeUpdate(strCreateTableBorrowing);

            String strCreateTableTransaction = "CREATE TABLE TRANSACTION(" +
                    "TID VARCHAR(255) NOT NULL, " +
                    "CID VARCHAR(5) NOT NULL, " +
                    "BorrowedDate DATE, " +
                    "ReturnDate DATE, " +
                    "TotalPrice int, " +
                    "TotalRoutine int, " +
                    "Quantity int, " +
                    "Status varchar(10) CHECK (Status = 'Borrowing' OR Status = 'Returned' OR Status = 'Waiting' OR Status = 'Cancel'), "
                    +
                    "PRIMARY KEY (TID));";
            stmt.executeUpdate(strCreateTableTransaction);

            String strCreateTableDetailTrans = "CREATE TABLE DETAILTRANS(" +
                    "TID VARCHAR(255) NOT NULL, " +
                    "BID VARCHAR(255) NOT NULL, " +
                    "CurrentPrice int NOT NULL, " +
                    "CurrentRoutine int NOT NULL, " +
                    "PRIMARY KEY (TID, BID));";
            stmt.executeUpdate(strCreateTableDetailTrans);

            // Generate triggers to create auto ID which is customized
            String strTrigger_CustomID = "CREATE TRIGGER librarian_insert_trigger BEFORE INSERT ON LIBRARIAN " +
                    "FOR EACH ROW SET new.LID = CONCAT('L', LPAD((SELECT count(*) from LIBRARIAN), 4, '0'));";
            stmt.executeUpdate(strTrigger_CustomID);

            strTrigger_CustomID = "CREATE TRIGGER client_insert_trigger BEFORE INSERT ON CLIENT " +
                    "FOR EACH ROW SET new.CID = CONCAT('C', LPAD((SELECT count(*) from CLIENT), 4, '0'));";
            stmt.executeUpdate(strTrigger_CustomID);

            strTrigger_CustomID = "CREATE TRIGGER trans_insert_trigger BEFORE INSERT ON TRANSACTION " +
                    "FOR EACH ROW SET new.TID = CONCAT('T', LPAD((SELECT count(*) from TRANSACTION), 4, '0'));";
            stmt.executeUpdate(strTrigger_CustomID);

            // Generate UNIQUE fields
            String strUC_Username = "ALTER TABLE LIBRARIAN ADD CONSTRAINT UC_Username UNIQUE (Username);";
            stmt.executeUpdate(strUC_Username);

            strUC_Username = "ALTER TABLE CLIENT ADD CONSTRAINT UC_Username UNIQUE (Username);";
            stmt.executeUpdate(strUC_Username);

            // Generate foreign keys
            String strFK_Librarian_User = "ALTER TABLE LIBRARIAN " +
                    "ADD CONSTRAINT FK_LIBRARIAN_USER " +
                    "FOREIGN KEY (Username) REFERENCES USER(Username);";
            stmt.executeUpdate(strFK_Librarian_User);

            String strFK_Client_User = "ALTER TABLE CLIENT " +
                    "ADD CONSTRAINT FK_CLIENT_USER " +
                    "FOREIGN KEY (Username) REFERENCES USER(Username);";
            stmt.executeUpdate(strFK_Client_User);

            String strFK_Review_Book = "ALTER TABLE REVIEW " +
                    "ADD CONSTRAINT FK_REVIEW_BOOK " +
                    "FOREIGN KEY (BID) REFERENCES BOOK(BID);";
            stmt.executeUpdate(strFK_Review_Book);

            String strFK_Review_Client = "ALTER TABLE REVIEW " +
                    "ADD CONSTRAINT FK_REVIEW_CLIENT " +
                    "FOREIGN KEY (CID) REFERENCES CLIENT(CID);";
            stmt.executeUpdate(strFK_Review_Client);

            String strFK_Interesting_Client = "ALTER TABLE INTERESTING " +
                    "ADD CONSTRAINT FK_INTERESTING_CLIENT " +
                    "FOREIGN KEY (CID) REFERENCES CLIENT(CID);";
            stmt.executeUpdate(strFK_Interesting_Client);

            String strFK_Interesting_Book = "ALTER TABLE INTERESTING " +
                    "ADD CONSTRAINT FK_INTERESTING_BOOK " +
                    "FOREIGN KEY (BID) REFERENCES BOOK(BID);";
            stmt.executeUpdate(strFK_Interesting_Book);

            String strFK_Borrowing_Book = "ALTER TABLE BORROWING " +
                    "ADD CONSTRAINT FK_BORROWING_BOOK " +
                    "FOREIGN KEY (BID) REFERENCES BOOK(BID);";
            stmt.executeUpdate(strFK_Borrowing_Book);

            String strFK_Transaction_Client = "ALTER TABLE TRANSACTION " +
                    "ADD CONSTRAINT FK_BORROWING_CLIENT " +
                    "FOREIGN KEY (CID) REFERENCES CLIENT(CID);";
            stmt.executeUpdate(strFK_Transaction_Client);

            String strFK_DetailTrans_Book = "ALTER TABLE DETAILTRANS " +
                    "ADD CONSTRAINT FK_DETAILTRANS_BOOK " +
                    "FOREIGN KEY (BID) REFERENCES BORROWING(BID);";
            stmt.executeUpdate(strFK_DetailTrans_Book);

            String strFK_DetailTrans_Transaction = "ALTER TABLE DETAILTRANS " +
                    "ADD CONSTRAINT FK_DETAILTRANS_TRANSACTION " +
                    "FOREIGN KEY (TID) REFERENCES TRANSACTION(TID);";
            stmt.executeUpdate(strFK_DetailTrans_Transaction);

            // Insert the first account of librarian into the database
            String strSave_LibAccount = "INSERT INTO USER VALUES ('librarian1', '12345', 0);";
            stmt.executeUpdate(strSave_LibAccount);

            String strSave_AccountInfo = "INSERT INTO LIBRARIAN (Fullname, PhoneNum, Email, Gender, Department, CreatedDate, Username) "
                    +
                    "VALUES ('Ma Cao', '0981236782', 'macao@gmail.com', 'Male', 'A', '2019-04-30', 'librarian1')";
            stmt.executeUpdate(strSave_AccountInfo);

            // Insert some books into the database
            String strBook = "INSERT INTO BOOK VALUES " +
                    "('AA00000', 'Old Path White Clouds', 'Thich Nhat Hanh', 'Phuong Nam', 2010, 'Biography', 2, 'Department A - Shelf A00', 'ImageBooks\\\\AA00000.png'),"
                    +
                    "('BA01099', 'Vingt mille lieues sous les mers', 'Jules Verne', 'Hong Duc', 2009, 'Adventure Novels', 5, 'Department B - Shelf A01', 'ImageBooks\\\\BA01099.png'),"
                    +
                    "('AC05014', 'JUSTICE What is the right thing to do?', 'Michael Sandel', 'Tre', 2016, 'Encyclopedia', 10, 'Department A - Shelf C05', 'ImageBooks\\\\AC05014.png'),"
                    +
                    "('DB03003', 'The Shining', 'Stephen King', 'Doubleday', 1977, 'Horror', 6, 'Department D - Shelf B03', 'ImageBooks\\\\DB03003.png'),"
                    +
                    "('CA02008', 'Pet Sematary', 'Stephen King', 'Doubleday', 1983, 'Horror', 7, 'Department C - Shelf A02', 'ImageBooks\\\\CA02008.png'),"
                    +
                    "('AD00038', 'Outlander', 'Diana Gabaldon', 'Delacorte Press', 1991, 'Romance', 12, 'Department A - Shelf D00', 'ImageBooks\\\\AD00038.png'),"
                    +
                    "('BD03015', 'The Notebook', 'Nicholas Sparks', 'Warner Books', 1996, 'Romance', 3, 'Department B - Shelf D03', 'ImageBooks\\\\BD03015.png'),"
                    +
                    "('CD03039', 'Dune', 'Frank Herbert', 'Chilton Books', 1965, 'Science Fiction', 19, 'Department C - Shelf D03', 'ImageBooks\\\\CD03039.png'),"
                    +
                    "('DD08062', 'Neuromancer', 'William Gibson', 'Ace Books', 1984, 'Science Fiction', 12, 'Department D - Shelf D08', 'ImageBooks\\\\DD08062.png'),"
                    +
                    "('AB07072', 'The Happiness Project', 'Gretchen Rubin', 'HarperCollins', 2009, 'Self-help', 3, 'Department A - Shelf B07', 'ImageBooks\\\\AB07072.png'),"
                    +
                    "('BC08010', 'Jade City', 'Fonda Lee', 'Orbit', 2017, 'Fantasy', 7, 'Department B - Shelf C08', 'ImageBooks\\\\BC08010.png'),"
                    +
                    "('CC00000', 'The Bone Shard Daughter', 'Andrea Stewart', 'Orbit', 2020, 'Fantasy', 12, 'Department C - Shelf C00', 'ImageBooks\\\\CC00000.png'),"
                    +
                    "('DC04002', 'The Dutch House', 'Ann Patchett', 'Harper', 2019, 'Drama', 21, 'Department D - Shelf C04', 'ImageBooks\\\\DC04002.png'),"
                    +
                    "('AC04032', 'A Little Life', 'Hanya Yanagihara', 'Doubleday', 2015, 'Drama', 19, 'Department A - Shelf C04', 'ImageBooks\\\\AC04032.png'),"
                    +
                    "('BA02047', 'Homie', 'Danez Smith', 'Graywolf Press', 2020, 'Poetry', 5, 'Department B - Shelf A02', 'ImageBooks\\\\BA02047.png'),"
                    +
                    "('CA01091', 'The Black Maria', 'Aracelis Girmay', 'BOA Editions', 2016, 'Poetry', 8, 'Department C - Shelf A01', 'ImageBooks\\\\CA01091.png'),"
                    +
                    "('DA07023', 'The Body: A Guide for Occupants', 'Bill Bryson', 'Doubleday', 2019, 'Science', 8, 'Department D - Shelf A07', 'ImageBooks\\\\DA07023.png'),"
                    +
                    "('AB07043', 'Brief Answers to the Big Questions', 'Stephen Hawking', 'Bantam Press', 2018, 'Science', 8, 'Department A - Shelf B07', 'ImageBooks\\\\AB07043.png'),"
                    +
                    "('BB03050', 'The Family Upstairs', 'Lisa Jewell', 'Atria Books', 2019, 'Mystery', 15, 'Department B - Shelf B03', 'ImageBooks\\\\BB03050.png'),"
                    +
                    "('CA03055', 'The Lost Man', 'Jane Harper', 'Flatiron Books', 2018, 'Mystery', 2, 'Department C - Shelf A03', 'ImageBooks\\\\CA03055.png'),"
                    +
                    "('DD05077', 'The Water Dancer', 'Ta-Nehisi Coates', 'One World', 2019, 'Novel', 6, 'Department D - Shelf D05', 'ImageBooks\\\\DD05077.png'),"
                    +
                    "('AA05017', 'The Underground Railroad', 'Colson Whitehead', 'Doubleday', 2016, 'Novel', 9, 'Department A - Shelf A05', 'ImageBooks\\\\AA05017.png'),"
                    +
                    "('BC09026', 'The Cold War: A World History', 'Odd Arne Westad', 'Basic Books', 2017, 'History', 17, 'Department B - Shelf C09', 'ImageBooks\\\\BC09026.png'),"
                    +
                    "('CC09087', 'Stalin: Waiting for Hitler, 1929-1941', 'Stephen Kotkin', 'Penguin Press', 2017, 'History', 10, 'Department C - Shelf C09', 'ImageBooks\\\\CC09087.png'),"
                    +
                    "('DA03000', 'Educated', 'Tara Westover', 'Random House', 2018, 'Memoir', 3, 'Department D - Shelf A03', 'ImageBooks\\\\DA03000.png');";
            stmt.executeUpdate(strBook);

            String strBorrowing = "INSERT INTO BORROWING(BID, Price, Routine) VALUES " +
                    "('AA00000', 15000, 10)," +
                    "('BA01099', 14000, 4)," +
                    "('AC05014', 6000, 6)," +
                    "('DB03003', 21000, 12)," +
                    "('CA02008', 5000, 7)," +
                    "('AD00038', 23000, 3)," +
                    "('BD03015', 18000, 8)," +
                    "('CD03039', 26000, 6)," +
                    "('DD08062', 10000, 10)," +
                    "('AB07072', 7000, 7)," +
                    "('BC08010', 20000, 5)," +
                    "('CC00000', 25000, 7)," +
                    "('DC04002', 15000, 9)," +
                    "('AC04032', 5000, 3)," +
                    "('BA02047', 20000, 5)," +
                    "('CA01091', 10000, 5)," +
                    "('DA07023', 21000, 9)," +
                    "('AB07043', 7000, 6)," +
                    "('BB03050', 12000, 4)," +
                    "('CA03055', 23000, 7)," +
                    "('DD05077', 25000, 12)," +
                    "('AA05017', 5000, 3)," +
                    "('BC09026', 7000, 4)," +
                    "('CC09087', 17000, 7)," +
                    "('DA03000', 12000, 10);";
            stmt.executeUpdate(strBorrowing);

            connection.commit();
        } catch (SQLException ex) {
            connection.rollback();
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
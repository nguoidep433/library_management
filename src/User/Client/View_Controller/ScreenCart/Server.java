package User.Client.View_Controller.ScreenCart;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

class NganHang {
    public String Stk;
    public int Tien;
    public String NganHang;

    public NganHang() {
        Stk = NganHang = "";
        Tien = 0;
    }
}

public class Server {
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String DB_NAME = "internetBanking";
    static final String USER = "1111";
    static final String PASS = "1111";

    public static void main(String[] args) throws Exception {

        /*
         * Connection conn = null;
         * Statement stmt = null;
         * try {
         * System.out.println("Connecting to database...");
         * conn = DriverManager.getConnection(DB_URL, USER, PASS);
         * System.out.println("Creating database...");
         * stmt = conn.createStatement();
         * String sql = "CREATE DATABASE if not exists " + DB_NAME;
         * stmt.executeUpdate(sql);
         * System.out.println("Database created successfully...");
         * sql = "USE " + DB_NAME;
         * stmt.executeUpdate(sql);
         * System.out.println("Creating table in given database...");
         * sql = "CREATE TABLE if not exists NganHang (\n" +
         * "  SoTaiKhoan VARCHAR(255) NOT NULL,\n" +
         * "  Tien VARCHAR(255) NOT NULL,\n" +
         * "  TenNganHang VARCHAR(255) NOT NULL,\n" +
         * "  PRIMARY KEY (SoTaiKhoan) " +
         * ");";
         * stmt.executeUpdate(sql);
         * System.out.println("Created table in given database...");
         * } catch (SQLException se) {
         * se.printStackTrace();
         * } catch (Exception ex) {
         * ex.printStackTrace();
         * } finally {
         * try {
         * if (stmt != null)
         * conn.close();
         * } catch (SQLException se) {
         * }
         * try {
         * if (conn != null)
         * conn.close();
         * } catch (SQLException se) {
         * se.printStackTrace();
         * }
         * 
         * }
         */

        int serverPort = 9999; // Cổng của server
        try {
            // Tạo socket server và lắng nghe kết nối từ client
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server đã sẵn sàng để kết nối...");

            while (true) {
                // Chấp nhận kết nối từ client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client đã kết nối đến server");

                // Tạo luồng để xử lý kết nối từ client
                Thread clientThread = new Thread(() -> {

                    try (
                            // Tạo đối tượng Connection và Statement
                            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                            Statement stmt = conn.createStatement();) {
                        // Tạo stream để nhận dữ liệu từ client
                        InputStream inputStream = clientSocket.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                        // Đọc dữ liệu từ client và hiển thị lên màn hình
                        String message = reader.readLine();
                        String array[] = message.split(",");
                        System.out.println(array[0] + " " + array[1] + " " + array[2]);
                        stmt.executeUpdate("USE " + DB_NAME);

                        // Tạo PreparedStatement để truy vấn dữ liệu
                        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM nganhang WHERE  SoTaiKhoan = ?");
                        pstmt.setString(1, array[0]);
                        ResultSet rs = pstmt.executeQuery();

                        // Lưu kết quả truy vấn vào mảng data
                        // ArrayList<NganHang> data = new ArrayList<NganHang>();
                        NganHang a = new NganHang();
                        while (rs.next()) {
                            a.Stk = rs.getString(1);
                            a.Tien = rs.getInt(2);
                            a.NganHang = rs.getString(3);
                        }
                        pstmt = conn.prepareStatement(
                                "SELECT * FROM nganhang WHERE  SoTaiKhoan = '32173871273' ");

                        rs = pstmt.executeQuery();
                        NganHang LibrarianAccount = new NganHang();
                        while (rs.next()) {
                            LibrarianAccount.Stk = rs.getString(1);
                            LibrarianAccount.NganHang = rs.getString(3);
                            LibrarianAccount.Tien = rs.getInt(2);
                        }
                        OutputStream outputStream = clientSocket.getOutputStream();
                        PrintWriter writer = new PrintWriter(outputStream, true);
                        int Money = Integer.parseInt(array[1]);
                        if (a.Tien - Money > 20000) {
                            PreparedStatement pstmt1 = conn.prepareStatement(
                                    "Update nganhang set Tien = ? where SoTaiKhoan = ?");
                            pstmt1.setInt(1, a.Tien - Money);
                            pstmt1.setString(2, array[0]);
                            pstmt1.executeUpdate();
                            pstmt1 = conn.prepareStatement(
                                    "Update nganhang set Tien = ? where  SoTaiKhoan = ? ");
                            pstmt1.setInt(1, LibrarianAccount.Tien + Money);
                            pstmt1.setString(2, LibrarianAccount.Stk);
                            pstmt1.executeUpdate();
                            String response = "Thanh toán thành công";
                            writer.println(response);
                        } else {
                            String response = "Số dư ít nhất 20000";
                            writer.println(response);
                        }
                        // Gửi phản hồi tới client

                        // Đóng ResultSet, PreparedStatement, kết nối với cơ sở dữ liệu và kết nối

                        // client
                        rs.close();
                        pstmt.close();
                        clientSocket.close();
                    } catch (IOException ex) {
                        System.err.println(ex);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                });

                // Bắt đầu chạy luồng xử lý kết nối từ client
                clientThread.start();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }
}
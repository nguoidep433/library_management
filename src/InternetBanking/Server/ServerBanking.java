package InternetBanking.Server;

import java.io.*;
import java.net.*;
import java.sql.*;

import InternetBanking.Bank.Bank;

public class ServerBanking {
    private static final String BANK_ACCOUNT = "32173871273";
    private static final String BANK_NAME = "Vietcombank";
    private int iReceivedMoney;
    private String strResponse = "FAILURE";

    public static void main(String[] args) throws Exception {
       (new ServerBanking()).generateSocket();
    }

    private void generateSocket() {
        final int serverPort = 9999; // Cổng của server
        try {
            //Generate a socket
            ServerSocket serverSocket = new ServerSocket(serverPort);
            System.out.println("Server is already to connect...");

            while (true) {
                // Chấp nhận kết nối từ client
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client connected to server");

                // Tạo luồng để xử lý kết nối từ client
                Thread clientThread = new Thread(() -> {
                    Connection connection = null;
                    Statement stmt = null;
                    BufferedReader reader = null;
                    PrintWriter writer = null;

                    //Make a transportation money
                    try {
                        connection = Bank.connectInternetBanking();
                        connection.setAutoCommit(false);
                        stmt = connection.createStatement();

                        // Tạo stream để nhận dữ liệu từ client
                        InputStream inputStream = clientSocket.getInputStream();
                        reader = new BufferedReader(new InputStreamReader(inputStream));

                        //Receive money from the client
                        iReceivedMoney = Integer.parseInt(reader.readLine());
                        System.out.println(iReceivedMoney);

                        //Make a transaction in Server
                        String strQuerry = "UPDATE Bank SET Money = Money + " + iReceivedMoney +
                                        " WHERE BankAccount = '" + BANK_ACCOUNT + "' AND " +
                                        "BankName = '" + BANK_NAME + "';";
                        stmt.executeUpdate(strQuerry);

                        connection.commit();

                        OutputStream outputStream = clientSocket.getOutputStream();
                        writer = new PrintWriter(outputStream, true);

                        //Send a response to the client
                        strResponse = "SUCCESS";
                        writer.println(strResponse);
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
                        //Send a response to the client
                        writer.println(strResponse);
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

                        try {
                            clientSocket.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                // Bắt đầu chạy luồng xử lý kết nối từ client
                clientThread.start();
                //serverSocket.close();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}

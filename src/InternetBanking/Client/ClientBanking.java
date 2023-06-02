package InternetBanking.Client;

import java.io.*;
import java.net.*;

public class ClientBanking {
    private int iTransportationMoney;
    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader reader;

    public ClientBanking(int iMoney) {
        this.iTransportationMoney = iMoney;
    }

    public String getResultTransportationMoney() {
        String serverAddress = "localhost";
        int serverPort = 9999;

        //Generate a client socket
        try {
            clientSocket = new Socket(serverAddress, serverPort);
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            writer.println(iTransportationMoney);
            String response = reader.readLine();
            
            return response;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return "FAILURE";
    }
}

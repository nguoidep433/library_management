package User.Librarian.View_Controller.ScreenStatistic;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;

import LibManagement.Model.LibManagement;
import User.User.*;
import User.Librarian.View_Controller.ScreenBook.UIListBooks;
import User.Librarian.View_Controller.ScreenClient.UIListClients;
import User.Librarian.View_Controller.ScreenDashboard.UIDashboard;
import User.Librarian.View_Controller.ScreenPrivateInfo.UIShowInfos;
import User.Librarian.View_Controller.ScreenLibrarian.*;

public class UIRevenueStatistic extends JFrame{
    private User currUser;
    private final int ESTABLISHED_YEAR = 2019;
    private final int ESTABLISHED_MONTH = 5;
    private final int CURRENT_YEAR = java.time.LocalDate.now().getYear();
    private final int CURRENT_MONTH = java.time.LocalDate.now().getMonthValue();
    private JScrollPane ScrollPaneStatistic;
    private ChartPanel ChartPanelRevenue;
    private JComboBox ComboBoxYear;
    private JComboBox ComboBoxMonth;
    private JLabel LabelAvgRevenue;
    private JLabel LabelHighestRevenue;
    private JLabel LabelLowestRevenue;

    public UIRevenueStatistic(User user) {
        super("Revenue Statistic");
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
        JButton ButtonBook = new JButton("Book", IconBook);
        ButtonBook.setHorizontalTextPosition(SwingConstants.RIGHT);
        ButtonBook.setIconTextGap(10);
        ButtonBook.setHorizontalAlignment(JButton.LEFT);
        ButtonBook.setBounds(0, 230, 190, 40);
        ButtonBook.setBackground(Color.decode("#F4FAFB"));
        ButtonBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibManagement.getCurrFrame().dispose();
                LibManagement.setFrame(new UIListBooks(currUser));
                LibManagement.getCurrFrame().setVisible(true);
            }
        });
        PanelBackground.add(ButtonBook);

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
        JLabel LabelStatistic = new JLabel("Statistic", IconStatistic, JLabel.LEFT);
        LabelStatistic.setHorizontalTextPosition(SwingConstants.RIGHT);
        LabelStatistic.setIconTextGap(10);
        LabelStatistic.setBounds(0, 350, 190, 40);
        LabelStatistic.setBackground(Color.decode("#A1E7FF"));
        LabelStatistic.setForeground(Color.decode("#FFF8F7"));
        LabelStatistic.setOpaque(true);
        PanelBackground.add(LabelStatistic);

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

        //Draw a line chart about revenue of a month
        ChartPanelRevenue = getLineChartRevenue(CURRENT_MONTH, CURRENT_YEAR);
        ScrollPaneStatistic = new JScrollPane(ChartPanelRevenue);
        ScrollPaneStatistic.setBounds(200, 100, 1040, 410);
        PanelBackground.add(ScrollPaneStatistic);

        //Analysis
        JPanel PanelAnalysis = new JPanel();
        PanelAnalysis.setLayout(null);
        PanelAnalysis.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        PanelAnalysis.setBorder(BorderFactory.createTitledBorder("Analysis"));
        PanelAnalysis.setBounds(495, 515, 450, 150);
        PanelBackground.add(PanelAnalysis);

        LabelAvgRevenue = new JLabel("Average Revenue: ");
        LabelAvgRevenue.setFont(new Font("Arial", Font.BOLD, 20));
        LabelAvgRevenue.setBounds(10, 20, 400, 30);
        PanelAnalysis.add(LabelAvgRevenue);

        LabelHighestRevenue = new JLabel(" Highest Revenue: ");
        LabelHighestRevenue.setFont(new Font("Arial", Font.BOLD, 20));
        LabelHighestRevenue.setBounds(10, 60, 300, 30);
        PanelAnalysis.add(LabelHighestRevenue);

        LabelLowestRevenue = new JLabel("  Lowest Revenue: ");
        LabelLowestRevenue.setFont(new Font("Arial", Font.BOLD, 20));
        LabelLowestRevenue.setBounds(10, 100, 300, 30);
        PanelAnalysis.add(LabelLowestRevenue);

        //Edit the month and the year
        JLabel LabelRevenue = new JLabel("Revenue:");
        LabelRevenue.setBounds(1030, 515, 80, 20);
        LabelRevenue.setFont(new Font("Arial", Font.BOLD, 15));
        PanelBackground.add(LabelRevenue);

        //Expand of Year
        ComboBoxYear = getExpandOfYear();
        ComboBoxYear.setBounds(1180, 515, 60, 20);
        PanelBackground.add(ComboBoxYear);

        //Expand of Month
        ComboBoxMonth = getExpandOfMonth(CURRENT_YEAR);
        ComboBoxMonth.setBounds(1115, 515, 60, 20);
        PanelBackground.add(ComboBoxMonth);

        //Get the analysis (avg, max, min)
        try {
            int iSelectedMonth = Integer.parseInt(ComboBoxMonth.getSelectedItem() + "");
            int iSelectedYear = Integer.parseInt(ComboBoxYear.getSelectedItem() + "");
            updateAnalysis(iSelectedMonth, iSelectedYear);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

        //Refresh the analysis and the line chart
        JButton ButtonRefresh = new JButton("Refresh");
        ButtonRefresh.setBounds(260, 515, 100, 40);
        ButtonRefresh.setBackground(Color.decode("#85BEF9"));
        ButtonRefresh.setForeground(Color.decode("#F8ECBD"));
        ButtonRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int iSelectedMonth = Integer.parseInt(ComboBoxMonth.getSelectedItem() + "");
                int iSelectedYear = Integer.parseInt(ComboBoxYear.getSelectedItem() + "");

                //Update the line chart
                ScrollPaneStatistic.remove(ChartPanelRevenue);
                ChartPanelRevenue = getLineChartRevenue(iSelectedMonth, iSelectedYear);
                ScrollPaneStatistic.setViewportView(ChartPanelRevenue);

                //Update the analysis
                updateAnalysis(iSelectedMonth, iSelectedYear);
            }
        });
        PanelBackground.add(ButtonRefresh);

        setContentPane(PanelBackground);
        pack();
        setLocationRelativeTo(null); //set center the frame on the screen
    }

    private void updateAnalysis(int iSelectedMonth, int iSelectedYear) {
        int[][] arrDaysOfMonth = {{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                                {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
        int iLeapYear = ((iSelectedYear % 400 == 0) || ((iSelectedYear % 4 == 0) && (iSelectedYear % 100 != 0))) ? 1 : 0;
        int iDaysOfMonth = arrDaysOfMonth[iLeapYear][iSelectedMonth];

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = LibManagement.connect();
            stmt = conn.createStatement();

            //Get an average revenue 
            String strQuerry = "SELECT SUM(TotalPrice) s FROM TRANSACTION " +
                                "WHERE MONTH(BorrowedDate) = " + iSelectedMonth +
                                " AND YEAR(BorrowedDate) = " + iSelectedYear + " AND " +
                                "(Status = 'Borrowing' OR Status = 'Returned')";
            rs = stmt.executeQuery(strQuerry);

            while (rs.next()) {
                double dNewAvgRevenue = rs.getInt("s") / iDaysOfMonth;
                dNewAvgRevenue = (double)Math.ceil(dNewAvgRevenue * 10) / 10 ;
                LabelAvgRevenue.setText("Average Revenue: " + dNewAvgRevenue + "VND/day");
            }

            //Get a lowest revenue and a highest revenue in month
            int iLowestRevenue = 0;
            int iHighestRevenue = 0;
            for (int days = 1; days <= iDaysOfMonth; ++days) {
                strQuerry = "SELECT COALESCE(SUM(TotalPrice), 0) s FROM TRANSACTION " +
                            "WHERE DAY(BorrowedDate) = " + days + " AND " +
                            "MONTH(BorrowedDate) = " + iSelectedMonth + " AND " +
                            "YEAR(BorrowedDate) = " + iSelectedYear + " AND " +
                            "(Status = 'Borrowing' OR Status = 'Returned');";
                rs = stmt.executeQuery(strQuerry);

                while (rs.next()) {
                    int iRevenueInDay = rs.getInt("s");
                    iHighestRevenue = (days == 1) ? iRevenueInDay : ((iHighestRevenue < iRevenueInDay) ? iRevenueInDay : iHighestRevenue);
                    iLowestRevenue = (days == 1) ? iRevenueInDay : ((iLowestRevenue > iRevenueInDay) ? iRevenueInDay : iLowestRevenue);
                }
            }

            LabelHighestRevenue.setText(" Highest Revenue: " + iHighestRevenue + "VND");
            LabelLowestRevenue.setText("  Lowest Revenue: " + iLowestRevenue + "VND");
        } catch (SQLException ex){
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        
            try {
                stmt.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }

            try {
                conn.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    private JComboBox getExpandOfMonth(int iYear) {
        String[] arrMonthsOfYear;
        if (iYear == ESTABLISHED_YEAR) {
            int iSize = (12 - ESTABLISHED_MONTH) + 1;
            arrMonthsOfYear = new String[iSize];
            for (int i = 0; i < iSize; ++i) {
                arrMonthsOfYear[i] = (i + ESTABLISHED_MONTH) + "";
            }
        } else if (iYear == CURRENT_YEAR) {
            int iSize = (CURRENT_MONTH - 1) + 1;
            arrMonthsOfYear = new String[iSize];
            for (int i = 0; i < iSize; ++i) {
                arrMonthsOfYear[i] = (i + 1) + "";
            }
        } else {
            int iSize = 12;
            arrMonthsOfYear = new String[iSize];
            for (int i = 0; i < iSize; ++i) {
                arrMonthsOfYear[i] = (i + 1) + "";
            }
        }

        JComboBox comboBox = new JComboBox(arrMonthsOfYear);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        comboBox.setBackground(Color.decode("#FFFAF0"));
        comboBox.setMaximumRowCount(5);
        comboBox.setBounds(1115, 515, 60, 20);
        //Set default is current month
        comboBox.setSelectedIndex(CURRENT_MONTH - 1);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int iSelectedMonth = Integer.parseInt(ComboBoxMonth.getSelectedItem() + "");
                int iSelectedYear = Integer.parseInt(ComboBoxYear.getSelectedItem() + "");

                //Update the line chart
                ScrollPaneStatistic.remove(ChartPanelRevenue);
                ChartPanelRevenue = getLineChartRevenue(iSelectedMonth, iSelectedYear);
                ScrollPaneStatistic.setViewportView(ChartPanelRevenue);

                //Update the analysis
                updateAnalysis(iSelectedMonth, iSelectedYear);
            }
        });
        return comboBox;
    }

    private JComboBox getExpandOfYear() {
        int iSize = (CURRENT_YEAR - ESTABLISHED_YEAR) + 1;
        String[] arrYear = new String[iSize];
        for (int i = 0; i < iSize; ++i) {
            arrYear[i] = (i + ESTABLISHED_YEAR) + "";
        }

        JComboBox comboBox = new JComboBox(arrYear);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        comboBox.setBackground(Color.decode("#FFFAF0"));
        comboBox.setMaximumRowCount(5);
        //Set default is current year
        comboBox.setSelectedIndex(CURRENT_YEAR - ESTABLISHED_YEAR);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int iSelectedYear = Integer.parseInt(ComboBoxYear.getSelectedItem() + "");
                int iSelectedMonth = Integer.parseInt(ComboBoxMonth.getSelectedItem() + "");
                String[] arrMonthsOfYear;

                if (iSelectedYear == ESTABLISHED_YEAR) { 
                    int iSize = (12 - ESTABLISHED_MONTH) + 1;
                    arrMonthsOfYear = new String[iSize];
                    for (int i = 0; i < iSize; ++i) {
                        arrMonthsOfYear[i] = (i + ESTABLISHED_MONTH) + "";
                    }

                    if (iSelectedMonth < ESTABLISHED_MONTH) {
                        //Replace the old expand of ComboBoxMonth with the new one which starts with the value 5 (May)
                        ComboBoxMonth.setModel(new DefaultComboBoxModel(arrMonthsOfYear));
                        ComboBoxMonth.setSelectedIndex(0);
                    } else {
                        //Replace the old expand of ComboBoxMonth with the new one which starts with the value 5 (May)
                        //But it keeps the previous selected month
                        ComboBoxMonth.setModel(new DefaultComboBoxModel(arrMonthsOfYear));
                        ComboBoxMonth.setSelectedIndex((iSelectedMonth - 5));
                    }
                } else if (iSelectedYear == CURRENT_YEAR) {
                    arrMonthsOfYear = new String[CURRENT_MONTH];
                    for (int i = 0; i < CURRENT_MONTH; ++i) {
                        arrMonthsOfYear[i] = (i + 1) + "";
                    }

                    if (iSelectedMonth > CURRENT_MONTH) {
                        //Replace the old expand of ComboBoxMonth with the new one which terminate with the value 4 (April)
                        ComboBoxMonth.setModel(new DefaultComboBoxModel(arrMonthsOfYear));
                        ComboBoxMonth.setSelectedIndex(arrMonthsOfYear.length - 1);
                    } else {
                        //Replace the old expand of ComboBoxMonth with the new one which terminate with the value 4 (April)
                        //But it keeps the previous selected month
                        ComboBoxMonth.setModel(new DefaultComboBoxModel(arrMonthsOfYear));
                        ComboBoxMonth.setSelectedIndex(iSelectedMonth - 1);
                    }
                } else {
                    int iSize = 12;
                    arrMonthsOfYear = new String[iSize];
                    for (int i = 0; i < iSize; ++i) {
                        arrMonthsOfYear[i] = (i + 1) + "";
                    }

                    //Replace the old expand of ComboBoxMonth with the new one which contains the months of year
                    //and keeps the previous selected month
                    ComboBoxMonth.setModel(new DefaultComboBoxModel(arrMonthsOfYear));
                    ComboBoxMonth.setSelectedIndex(iSelectedMonth - 1);
                }

                //Update line chart
                iSelectedYear = Integer.parseInt(ComboBoxYear.getSelectedItem() + "");
                iSelectedMonth = Integer.parseInt(ComboBoxMonth.getSelectedItem() + "");
                ScrollPaneStatistic.remove(ChartPanelRevenue);
                ChartPanelRevenue = getLineChartRevenue(iSelectedMonth, iSelectedYear);
                ScrollPaneStatistic.setViewportView(ChartPanelRevenue);

                //Update the analysis
                updateAnalysis(iSelectedMonth, iSelectedYear);
            }
        });
        return comboBox;
    }

    private DefaultCategoryDataset createDatasetRevenue(int iMonth, int iYear) {
        if (iMonth < 0 || iMonth > 12) {
            return null;
        }

        if ((iYear == ESTABLISHED_YEAR && iMonth < ESTABLISHED_MONTH) || (iYear < ESTABLISHED_YEAR)) {
            return null;
        }

        if ((iYear == CURRENT_YEAR && iMonth > CURRENT_MONTH) || (iYear > CURRENT_YEAR)) {
            return null;
        }

        int[][] arrDaysOfMonth = {{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                                {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
        int iLeapYear = ((iYear % 400 == 0) || ((iYear % 4 == 0) && (iYear % 100 != 0))) ? 1 : 0;
        int iDaysOfMonth = arrDaysOfMonth[iLeapYear][iMonth];

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = LibManagement.connect();
            stmt = conn.createStatement();

            for (int days = 1; days <= iDaysOfMonth; ++days) {
                String strQuerry = "SELECT COALESCE(SUM(TotalPrice), 0) s FROM TRANSACTION " +
                                "WHERE DAY(BorrowedDate) = " + days + " AND " +
                                "MONTH(BorrowedDate) = " + iMonth + " AND " +
                                "YEAR(BorrowedDate) = " + iYear + " AND " +
                                "(Status = 'Borrowing' OR Status = 'Returned');";
                rs = stmt.executeQuery(strQuerry);

                while (rs.next()) {
                    int iRevenue = rs.getInt("s") / 1000;
                    String strDay = days + "";
                    dataset.addValue(iRevenue, "Revenue", strDay);
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        
            try {
                stmt.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }

            try {
                conn.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }

        return dataset;
    }

    private ChartPanel getLineChartRevenue(int iMonth, int iYear) {
        String strChartTitle = "Revenue in " + iMonth + "/" + iYear;
        String strXAxisLabel = "Days of Month";
        String strYAxisLabel = "K VND";
        DefaultCategoryDataset datasetRevenue = createDatasetRevenue(iMonth, iYear);
        JFreeChart lineChart = ChartFactory.createLineChart(strChartTitle, strXAxisLabel, strYAxisLabel, datasetRevenue);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new Dimension(1030, 400));
        
        return chartPanel;
    }
}   

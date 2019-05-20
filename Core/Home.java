package Core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shahlin
 */
public class Home extends javax.swing.JFrame {
    
    
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        
        setLocationRelativeTo(null);
        this.setResizable(false);
        
        welcomeScreen.setVisible(false);
        welcomeScreenCloseBtn.setVisible(false);
        
        navBarScreen.setVisible(false);
        navBarNextBtn.setVisible(false);
        
        topHeaderScreen.setVisible(false);
        topHeaderCloseBtn.setVisible(false);
        
        walletUnderline.setVisible(false);
        remindersUnderline.setVisible(false);
        notesUnderline.setVisible(false);
        quickLinksUnderline.setVisible(false);
        newsUnderline.setVisible(false);
        miscUnderline.setVisible(false);
        homeUnderline.setVisible(false);
        settingsUnderline.setVisible(false);
        noFrequentsLabel.setVisible(false);
        
        setFrequentlyUsed();
        setCurrentBalance();
        setReminders();
    }
    
    public void welcomeUser(){
        String firstTime = firstTimeCheck.getText();
        
        if(firstTime.equals("firsttime")){
            //New user
            walletBtn.setEnabled(false);
            remindersBtn.setEnabled(false);
            notesBtn.setEnabled(false);
            quickLinksBtn.setEnabled(false);
            newsBtn.setEnabled(false);
            miscBtn.setEnabled(false);
            
            welcomeScreen.setVisible(true);
            welcomeScreenCloseBtn.setVisible(true);
        }
    }
    
    public void setFrequentlyUsed(){
        walletHelper wallet = new walletHelper();
        remindersHelper reminders = new remindersHelper();
        notesHelper notes = new notesHelper();
        quicklinksHelper quicklinks = new quicklinksHelper();
        pdfreaderHelper reader = new pdfreaderHelper();
        
        usersHelper user = new usersHelper();
        int user_id = user.getLoggedInUser();
        
        int walletUsage = wallet.getUsageCount(user_id);
        int remindersUsage = reminders.getUsageCount(user_id);
        int notesUsage = notes.getUsageCount(user_id);
        int quicklinksUsage = quicklinks.getUsageCount(user_id);
        int readerUsage = reader.getRecentsCount(user_id);
        
        if(walletUsage == 0 && remindersUsage == 0 && notesUsage == 0 && quicklinksUsage == 0 && readerUsage == 0){
            noFrequentsLabel.setVisible(true);
            return;
        } else {
            noFrequentsLabel.setVisible(false);
        }
        
        LinkedHashMap<String, Integer> usageCounts = new LinkedHashMap();
        LinkedHashMap<String, Integer> finalCounts = new LinkedHashMap();
        
        usageCounts.put("walletUsage", walletUsage);
        usageCounts.put("remindersUsage", remindersUsage);
        usageCounts.put("notesUsage", notesUsage);
        usageCounts.put("quicklinksUsage", quicklinksUsage);
        usageCounts.put("readerUsage", readerUsage);
        
        //Sort HashMap
        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(usageCounts.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b){
              return a.getValue().compareTo(b.getValue());
            }
        });
      
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : entries) {
          sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        Set set = sortedMap.entrySet();
     
        Iterator i = set.iterator();
      
        int counter = 0;
        
        // Display elements
        while(counter < 5) {
            Map.Entry me = (Map.Entry)i.next();
            
            if(counter >= 2){
                finalCounts.put(me.getKey().toString(), (Integer) me.getValue());
            }
            
            counter++;
        }
        
        Set finalSet = finalCounts.entrySet();
        Iterator f = finalSet.iterator();
        
        while(f.hasNext()){
            Map.Entry me = (Map.Entry)f.next();
            String key = me.getKey().toString();
            
            ImageIcon walletImage = new ImageIcon(getClass().getResource("../icons/frequentlyUsed/wallet.png"));
            ImageIcon notesImage = new ImageIcon(getClass().getResource("../icons/frequentlyUsed/notes.png"));
            ImageIcon remindersImage = new ImageIcon(getClass().getResource("../icons/frequentlyUsed/reminders.png"));
            ImageIcon quicklinksImage = new ImageIcon(getClass().getResource("../icons/frequentlyUsed/quicklinks.png"));
            ImageIcon readerImage = new ImageIcon(getClass().getResource("../icons/frequentlyUsed/pdfreader.png"));
            
            if(key.equals("walletUsage")){
                if (walletImage != null) {
                    if(frequentLabel1.getText().equals("")){
                        frequentIcon1.setIcon(walletImage);
                        frequentLabel1.setText("Wallet");
                    } else if(frequentLabel2.getText().equals("")){
                        frequentIcon2.setIcon(walletImage);
                        frequentLabel2.setText("Wallet");
                    } else {
                        frequentIcon3.setIcon(walletImage);
                        frequentLabel3.setText("Wallet");
                    }
                }
            }
            
            if(key.equals("remindersUsage")){
                if (remindersImage != null) {
                    if(frequentLabel1.getText().equals("")){
                        frequentIcon1.setIcon(remindersImage);
                        frequentLabel1.setText("Reminders");
                    } else if(frequentLabel2.getText().equals("")){
                        frequentIcon2.setIcon(remindersImage);
                        frequentLabel2.setText("Reminders");
                    } else {
                        frequentIcon3.setIcon(remindersImage);
                        frequentLabel3.setText("Reminders");
                    }
                }
            }
            
            if(key.equals("notesUsage")){
                if (notesImage != null) {
                    if(frequentLabel1.getText().equals("")){
                        frequentIcon1.setIcon(notesImage);
                        frequentLabel1.setText("Notes");
                    } else if(frequentLabel2.getText().equals("")){
                        frequentIcon2.setIcon(notesImage);
                        frequentLabel2.setText("Notes");
                    } else {
                        frequentIcon3.setIcon(notesImage);
                        frequentLabel3.setText("Notes");
                    }
                }
            }
            
            if(key.equals("quicklinksUsage")){
                if (quicklinksImage != null) {
                    if(frequentLabel1.getText().equals("")){
                        frequentIcon1.setIcon(quicklinksImage);
                        frequentLabel1.setText("Quick Links");
                    } else if(frequentLabel2.getText().equals("")){
                        frequentIcon2.setIcon(quicklinksImage);
                        frequentLabel2.setText("Quick Links");
                    } else {
                        frequentIcon3.setIcon(quicklinksImage);
                        frequentLabel3.setText("Quick Links");
                    }
                }
            }
            
            if(key.equals("readerUsage")){
                if (readerImage != null) {
                    if(frequentLabel1.getText().equals("")){
                        frequentIcon1.setIcon(readerImage);
                        frequentLabel1.setText("PDFReader");
                    } else if(frequentLabel2.getText().equals("")){
                        frequentIcon2.setIcon(readerImage);
                        frequentLabel2.setText("PDFReader");
                    } else {
                        frequentIcon3.setIcon(readerImage);
                        frequentLabel3.setText("PDFReader");
                    }
                }
            }
        }
    }

    private void setCurrentBalance(){
        walletHelper wallet = new walletHelper();
        int user_id = new usersHelper().getLoggedInUser();
        
        double expense = wallet.getTotalExpense(user_id);
        double income = wallet.getTotalIncome(user_id);
        
        double balance = income - expense;
        
        currentBalanceLabel.setText("" + balance);
    }
    
    private void setReminders(){
        remindersHelper reminders = new remindersHelper();
        int user_id = new usersHelper().getLoggedInUser();
        
        ArrayList<String> frequent = reminders.getFrequent(user_id);
        
        if(frequent == null){
            String emptyReminder = "<html>";
            emptyReminder += "<span style='font-size:15px;color:#706e69;'>Add more reminders!</span>";
            
            emptyReminder += "</html>";
            
            remindersLabel.setText(emptyReminder);
        } else {
            String outputReminder = "<html>";
        
            //First reminder title, date and time
            outputReminder += "<span style='font-size:15px;color:#706e69;'><b>" + frequent.get(0) + "</b></span><br><br>";
            outputReminder += "Due on <i><b>" + frequent.get(1) + "</i></b>";
            outputReminder += " at <i><b>" + frequent.get(2) + "</b></i><br><br><br>";

            //Second reminder
            outputReminder += "<span style='font-size:15px;color:#706e69;'><b>" + frequent.get(3) + "</b></span><br><br>";
            outputReminder += "Due on <i><b>" + frequent.get(4) + "</b></i>";
            outputReminder += " at <i><b>" + frequent.get(5) + "</b></i><br><br><br>";

            outputReminder += "</html>";

            remindersLabel.setText(outputReminder);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topHeaderCloseBtn = new javax.swing.JLabel();
        topHeaderScreen = new javax.swing.JLabel();
        navBarNextBtn = new javax.swing.JButton();
        navBarScreen = new javax.swing.JLabel();
        welcomeScreenCloseBtn = new javax.swing.JLabel();
        welcomeNextBtn = new javax.swing.JButton();
        welcomeScreen = new javax.swing.JLabel();
        remindersLabel = new javax.swing.JLabel();
        currentBalanceLabel = new javax.swing.JLabel();
        noFrequentsLabel = new javax.swing.JLabel();
        frequentLabel3 = new javax.swing.JLabel();
        frequentLabel2 = new javax.swing.JLabel();
        frequentLabel1 = new javax.swing.JLabel();
        frequentIcon3 = new javax.swing.JLabel();
        frequentIcon2 = new javax.swing.JLabel();
        frequentIcon1 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        miscBtn = new javax.swing.JButton();
        newsBtn = new javax.swing.JButton();
        quickLinksBtn = new javax.swing.JButton();
        notesBtn = new javax.swing.JButton();
        remindersBtn = new javax.swing.JButton();
        walletBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        settingsBtn = new javax.swing.JButton();
        settingsUnderline = new javax.swing.JLabel();
        homeUnderline = new javax.swing.JLabel();
        miscUnderline = new javax.swing.JLabel();
        newsUnderline = new javax.swing.JLabel();
        quickLinksUnderline = new javax.swing.JLabel();
        notesUnderline = new javax.swing.JLabel();
        remindersUnderline = new javax.swing.JLabel();
        walletUnderline = new javax.swing.JLabel();
        dropDown = new javax.swing.JComboBox<>();
        background = new javax.swing.JLabel();
        firstTimeCheck = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1040, 700));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(null);

        topHeaderCloseBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        topHeaderCloseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topHeaderCloseBtnMouseClicked(evt);
            }
        });
        getContentPane().add(topHeaderCloseBtn);
        topHeaderCloseBtn.setBounds(780, 199, 40, 49);

        topHeaderScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Extras/topHeaderScreen.png"))); // NOI18N
        getContentPane().add(topHeaderScreen);
        topHeaderScreen.setBounds(0, 0, 1040, 700);

        navBarNextBtn.setBorder(null);
        navBarNextBtn.setBorderPainted(false);
        navBarNextBtn.setContentAreaFilled(false);
        navBarNextBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        navBarNextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navBarNextBtnActionPerformed(evt);
            }
        });
        getContentPane().add(navBarNextBtn);
        navBarNextBtn.setBounds(830, 437, 80, 30);

        navBarScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Extras/navBarScreen.png"))); // NOI18N
        getContentPane().add(navBarScreen);
        navBarScreen.setBounds(0, 0, 1040, 700);

        welcomeScreenCloseBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        welcomeScreenCloseBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                welcomeScreenCloseBtnMouseClicked(evt);
            }
        });
        getContentPane().add(welcomeScreenCloseBtn);
        welcomeScreenCloseBtn.setBounds(780, 203, 40, 40);

        welcomeNextBtn.setBorder(null);
        welcomeNextBtn.setBorderPainted(false);
        welcomeNextBtn.setContentAreaFilled(false);
        welcomeNextBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        welcomeNextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                welcomeNextBtnActionPerformed(evt);
            }
        });
        getContentPane().add(welcomeNextBtn);
        welcomeNextBtn.setBounds(690, 440, 100, 30);

        welcomeScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Extras/WelcomeScreen.png"))); // NOI18N
        getContentPane().add(welcomeScreen);
        welcomeScreen.setBounds(0, 0, 1040, 700);

        remindersLabel.setVerticalAlignment(JLabel.TOP);
        remindersLabel.setHorizontalAlignment(JLabel.LEFT);
        getContentPane().add(remindersLabel);
        remindersLabel.setBounds(300, 440, 700, 180);

        currentBalanceLabel.setHorizontalAlignment(JLabel.CENTER);
        currentBalanceLabel.setVerticalAlignment(JLabel.CENTER);
        currentBalanceLabel.setFont(new java.awt.Font("Lato", 0, 36)); // NOI18N
        currentBalanceLabel.setForeground(new java.awt.Color(74, 72, 65));
        getContentPane().add(currentBalanceLabel);
        currentBalanceLabel.setBounds(790, 200, 203, 80);

        noFrequentsLabel.setFont(new java.awt.Font("Lato", 0, 24)); // NOI18N
        noFrequentsLabel.setForeground(new java.awt.Color(112, 110, 105));
        noFrequentsLabel.setText("No apps found...");
        getContentPane().add(noFrequentsLabel);
        noFrequentsLabel.setBounds(300, 190, 390, 60);

        frequentLabel3.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(frequentLabel3);
        frequentLabel3.setBounds(620, 290, 110, 30);

        frequentLabel2.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(frequentLabel2);
        frequentLabel2.setBounds(450, 290, 120, 30);

        frequentLabel1.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(frequentLabel1);
        frequentLabel1.setBounds(290, 290, 120, 30);
        getContentPane().add(frequentIcon3);
        frequentIcon3.setBounds(620, 200, 100, 80);
        getContentPane().add(frequentIcon2);
        frequentIcon2.setBounds(460, 200, 100, 80);
        getContentPane().add(frequentIcon1);
        frequentIcon1.setBounds(300, 200, 100, 80);

        logo.setFont(new java.awt.Font("Colors Of Autumn", 0, 48)); // NOI18N
        logo.setForeground(new java.awt.Color(74, 72, 65));
        logo.setText("SHELL");
        getContentPane().add(logo);
        logo.setBounds(40, 10, 210, 100);

        miscBtn.setBorder(null);
        miscBtn.setBorderPainted(false);
        miscBtn.setContentAreaFilled(false);
        miscBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        miscBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miscBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miscBtnMouseExited(evt);
            }
        });
        miscBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miscBtnActionPerformed(evt);
            }
        });
        getContentPane().add(miscBtn);
        miscBtn.setBounds(30, 510, 200, 50);

        newsBtn.setBorder(null);
        newsBtn.setBorderPainted(false);
        newsBtn.setContentAreaFilled(false);
        newsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newsBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newsBtnMouseExited(evt);
            }
        });
        newsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newsBtnActionPerformed(evt);
            }
        });
        getContentPane().add(newsBtn);
        newsBtn.setBounds(30, 440, 200, 50);

        quickLinksBtn.setBorder(null);
        quickLinksBtn.setBorderPainted(false);
        quickLinksBtn.setContentAreaFilled(false);
        quickLinksBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quickLinksBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                quickLinksBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                quickLinksBtnMouseExited(evt);
            }
        });
        quickLinksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quickLinksBtnActionPerformed(evt);
            }
        });
        getContentPane().add(quickLinksBtn);
        quickLinksBtn.setBounds(30, 380, 200, 40);

        notesBtn.setBorder(null);
        notesBtn.setBorderPainted(false);
        notesBtn.setContentAreaFilled(false);
        notesBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        notesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                notesBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                notesBtnMouseExited(evt);
            }
        });
        notesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notesBtnActionPerformed(evt);
            }
        });
        getContentPane().add(notesBtn);
        notesBtn.setBounds(30, 310, 190, 40);

        remindersBtn.setBorder(null);
        remindersBtn.setBorderPainted(false);
        remindersBtn.setContentAreaFilled(false);
        remindersBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        remindersBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                remindersBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                remindersBtnMouseExited(evt);
            }
        });
        remindersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remindersBtnActionPerformed(evt);
            }
        });
        getContentPane().add(remindersBtn);
        remindersBtn.setBounds(30, 240, 190, 50);

        walletBtn.setBorder(null);
        walletBtn.setBorderPainted(false);
        walletBtn.setContentAreaFilled(false);
        walletBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        walletBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                walletBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                walletBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                walletBtnMouseExited(evt);
            }
        });
        walletBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                walletBtnActionPerformed(evt);
            }
        });
        getContentPane().add(walletBtn);
        walletBtn.setBounds(30, 170, 160, 50);

        homeBtn.setBorder(null);
        homeBtn.setBorderPainted(false);
        homeBtn.setContentAreaFilled(false);
        homeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeBtnMouseExited(evt);
            }
        });
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(homeBtn);
        homeBtn.setBounds(388, 32, 110, 43);

        settingsBtn.setBorder(null);
        settingsBtn.setBorderPainted(false);
        settingsBtn.setContentAreaFilled(false);
        settingsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsBtnMouseExited(evt);
            }
        });
        settingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsBtnActionPerformed(evt);
            }
        });
        getContentPane().add(settingsBtn);
        settingsBtn.setBounds(585, 35, 140, 40);

        settingsUnderline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Extras/Underlines/settingsUnderline.png"))); // NOI18N
        getContentPane().add(settingsUnderline);
        settingsUnderline.setBounds(640, 73, 80, 10);

        homeUnderline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Extras/Underlines/homeUnderline.png"))); // NOI18N
        getContentPane().add(homeUnderline);
        homeUnderline.setBounds(442, 73, 80, 10);

        miscUnderline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Extras/Underlines/miscUnderline.png"))); // NOI18N
        getContentPane().add(miscUnderline);
        miscUnderline.setBounds(93, 548, 60, 20);

        newsUnderline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Extras/Underlines/newsUnderline.png"))); // NOI18N
        getContentPane().add(newsUnderline);
        newsUnderline.setBounds(95, 480, 80, 20);

        quickLinksUnderline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Extras/Underlines/quickLinksUnderline.png"))); // NOI18N
        getContentPane().add(quickLinksUnderline);
        quickLinksUnderline.setBounds(89, 413, 150, 20);

        notesUnderline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Extras/Underlines/notesUnderline.png"))); // NOI18N
        notesUnderline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                notesUnderlineMouseEntered(evt);
            }
        });
        getContentPane().add(notesUnderline);
        notesUnderline.setBounds(95, 338, 80, 20);

        remindersUnderline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Extras/Underlines/remindersUnderline.png"))); // NOI18N
        getContentPane().add(remindersUnderline);
        remindersUnderline.setBounds(90, 280, 130, 10);

        walletUnderline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Extras/Underlines/walletUnderline.jpg"))); // NOI18N
        getContentPane().add(walletUnderline);
        walletUnderline.setBounds(96, 210, 80, 10);

        dropDown.setBackground(new java.awt.Color(0, 153, 51, 0));
        usersHelper user = new usersHelper();
        dropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {user.getUsername(user.getLoggedInUser()), "Logout"}));
        dropDown.setBorder(null);
        dropDown.setOpaque(false);
        dropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropDownActionPerformed(evt);
            }
        });
        getContentPane().add(dropDown);
        dropDown.setBounds(798, 35, 186, 38);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Home.jpg"))); // NOI18N
        background.setPreferredSize(new java.awt.Dimension(900, 569));
        getContentPane().add(background);
        background.setBounds(0, 0, 1040, 700);
        getContentPane().add(firstTimeCheck);
        firstTimeCheck.setBounds(10, 680, 40, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        welcomeUser();
    }//GEN-LAST:event_formComponentShown

    private void walletBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_walletBtnActionPerformed
        // TODO add your handling code here:
        walletHelper helper = new walletHelper();
        usersHelper user = new usersHelper();
        
        helper.incrementUsageCount(user.getLoggedInUser());
        
        Wallet window = new Wallet();
        window.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_walletBtnActionPerformed

    private void remindersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remindersBtnActionPerformed
        // TODO add your handling code here:
        Reminders window = new Reminders();
        window.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_remindersBtnActionPerformed

    private void notesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notesBtnActionPerformed
        // TODO add your handling code here:
        notesHelper helper = new notesHelper();
        usersHelper user = new usersHelper();
        
        helper.incrementUsageCount(user.getLoggedInUser());
        
        Notes window = new Notes();
        window.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_notesBtnActionPerformed

    private void quickLinksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quickLinksBtnActionPerformed
        // TODO add your handling code here:
        quicklinksHelper helper = new quicklinksHelper();
        usersHelper user = new usersHelper();
        
        helper.incrementUsageCount(user.getLoggedInUser());
        
        QuickLinks window = new QuickLinks();
        window.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_quickLinksBtnActionPerformed

    private void newsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newsBtnActionPerformed
        // TODO add your handling code here:
        News window = new News();
        window.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_newsBtnActionPerformed

    private void miscBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miscBtnActionPerformed
        // TODO add your handling code here:
        Misc window = new Misc();
        window.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_miscBtnActionPerformed

    private void welcomeScreenCloseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_welcomeScreenCloseBtnMouseClicked
        // TODO add your handling code here:
        welcomeScreen.setVisible(false);
        walletBtn.setEnabled(true);
        remindersBtn.setEnabled(true);
        notesBtn.setEnabled(true);
        quickLinksBtn.setEnabled(true);
        newsBtn.setEnabled(true);
        miscBtn.setEnabled(true);
    }//GEN-LAST:event_welcomeScreenCloseBtnMouseClicked

    private void welcomeNextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_welcomeNextBtnActionPerformed
        // TODO add your handling code here:
        welcomeScreen.setVisible(false);
        welcomeScreenCloseBtn.setVisible(false);
        
        navBarScreen.setVisible(true);
        navBarNextBtn.setVisible(true);
    }//GEN-LAST:event_welcomeNextBtnActionPerformed

    private void navBarNextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navBarNextBtnActionPerformed
        // TODO add your handling code here:
        homeBtn.setVisible(false);
        settingsBtn.setVisible(false);
        dropDown.setVisible(false);
        
        navBarScreen.setVisible(false);
        navBarNextBtn.setVisible(false);
        
        topHeaderScreen.setVisible(true);
        topHeaderCloseBtn.setVisible(true);
    }//GEN-LAST:event_navBarNextBtnActionPerformed

    private void topHeaderCloseBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topHeaderCloseBtnMouseClicked
        // TODO add your handling code here:
        topHeaderScreen.setVisible(false);
        topHeaderCloseBtn.setVisible(false);
        
        homeBtn.setVisible(true);
        settingsBtn.setVisible(true);
        dropDown.setVisible(true);
        
        walletBtn.setEnabled(true);
        remindersBtn.setEnabled(true);
        notesBtn.setEnabled(true);
        quickLinksBtn.setEnabled(true);
        newsBtn.setEnabled(true);
        miscBtn.setEnabled(true);
    }//GEN-LAST:event_topHeaderCloseBtnMouseClicked

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        Home window = new Home();
        window.setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

    private void settingsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseClicked
        // TODO add your handling code here:
        Settings window = new Settings();
        window.setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_settingsBtnMouseClicked

    private void dropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropDownActionPerformed
        // TODO add your handling code here:

        if(dropDown.getSelectedItem().equals("Logout")){
            usersHelper user = new usersHelper();
            user.logout();
            this.setVisible(false);
            dispose();

            Login window = new Login();
            window.setVisible(true);
        }
    }//GEN-LAST:event_dropDownActionPerformed

    private void notesUnderlineMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notesUnderlineMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_notesUnderlineMouseEntered

    private void walletBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_walletBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_walletBtnMouseClicked

    private void walletBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_walletBtnMouseEntered
        // TODO add your handling code here:
        walletUnderline.setVisible(true);
    }//GEN-LAST:event_walletBtnMouseEntered

    private void walletBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_walletBtnMouseExited
        // TODO add your handling code here:
        walletUnderline.setVisible(false);
    }//GEN-LAST:event_walletBtnMouseExited

    private void remindersBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remindersBtnMouseEntered
        // TODO add your handling code here:
        remindersUnderline.setVisible(true);
    }//GEN-LAST:event_remindersBtnMouseEntered

    private void remindersBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remindersBtnMouseExited
        // TODO add your handling code here:
        remindersUnderline.setVisible(false);
    }//GEN-LAST:event_remindersBtnMouseExited

    private void notesBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notesBtnMouseEntered
        // TODO add your handling code here:
        notesUnderline.setVisible(true);
    }//GEN-LAST:event_notesBtnMouseEntered

    private void notesBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notesBtnMouseExited
        // TODO add your handling code here:
        notesUnderline.setVisible(false);
    }//GEN-LAST:event_notesBtnMouseExited

    private void quickLinksBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quickLinksBtnMouseEntered
        // TODO add your handling code here:
        quickLinksUnderline.setVisible(true);
    }//GEN-LAST:event_quickLinksBtnMouseEntered

    private void quickLinksBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quickLinksBtnMouseExited
        // TODO add your handling code here:
        quickLinksUnderline.setVisible(false);
    }//GEN-LAST:event_quickLinksBtnMouseExited

    private void newsBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newsBtnMouseEntered
        // TODO add your handling code here:
        newsUnderline.setVisible(true);
    }//GEN-LAST:event_newsBtnMouseEntered

    private void newsBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newsBtnMouseExited
        // TODO add your handling code here:
        newsUnderline.setVisible(false);
    }//GEN-LAST:event_newsBtnMouseExited

    private void miscBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miscBtnMouseEntered
        // TODO add your handling code here:
        miscUnderline.setVisible(true);
    }//GEN-LAST:event_miscBtnMouseEntered

    private void miscBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miscBtnMouseExited
        // TODO add your handling code here:
        miscUnderline.setVisible(false);
    }//GEN-LAST:event_miscBtnMouseExited

    private void homeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseEntered
        // TODO add your handling code here:
        homeUnderline.setVisible(true);
    }//GEN-LAST:event_homeBtnMouseEntered

    private void homeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseExited
        // TODO add your handling code here:
        homeUnderline.setVisible(false);
    }//GEN-LAST:event_homeBtnMouseExited

    private void settingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsBtnActionPerformed
        // TODO add your handling code here:
        Settings window = new Settings();
        window.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_settingsBtnActionPerformed

    private void settingsBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseEntered
        // TODO add your handling code here:
        settingsUnderline.setVisible(true);
    }//GEN-LAST:event_settingsBtnMouseEntered

    private void settingsBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseExited
        // TODO add your handling code here:
        settingsUnderline.setVisible(false);
    }//GEN-LAST:event_settingsBtnMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel currentBalanceLabel;
    private javax.swing.JComboBox<String> dropDown;
    public static javax.swing.JLabel firstTimeCheck;
    private javax.swing.JLabel frequentIcon1;
    private javax.swing.JLabel frequentIcon2;
    private javax.swing.JLabel frequentIcon3;
    private javax.swing.JLabel frequentLabel1;
    private javax.swing.JLabel frequentLabel2;
    private javax.swing.JLabel frequentLabel3;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel homeUnderline;
    private javax.swing.JLabel logo;
    private javax.swing.JButton miscBtn;
    private javax.swing.JLabel miscUnderline;
    private javax.swing.JButton navBarNextBtn;
    private javax.swing.JLabel navBarScreen;
    private javax.swing.JButton newsBtn;
    private javax.swing.JLabel newsUnderline;
    private javax.swing.JLabel noFrequentsLabel;
    private javax.swing.JButton notesBtn;
    private javax.swing.JLabel notesUnderline;
    private javax.swing.JButton quickLinksBtn;
    private javax.swing.JLabel quickLinksUnderline;
    private javax.swing.JButton remindersBtn;
    private javax.swing.JLabel remindersLabel;
    private javax.swing.JLabel remindersUnderline;
    private javax.swing.JButton settingsBtn;
    private javax.swing.JLabel settingsUnderline;
    private javax.swing.JLabel topHeaderCloseBtn;
    private javax.swing.JLabel topHeaderScreen;
    private javax.swing.JButton walletBtn;
    private javax.swing.JLabel walletUnderline;
    private javax.swing.JButton welcomeNextBtn;
    private javax.swing.JLabel welcomeScreen;
    private javax.swing.JLabel welcomeScreenCloseBtn;
    // End of variables declaration//GEN-END:variables
}

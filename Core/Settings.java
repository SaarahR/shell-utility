package Core;

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
public class Settings extends javax.swing.JFrame {

    /**
     * Creates new form Settings
     */
    public Settings() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
        setDisabledFieldValues();
        
        homeUnderline.setVisible(false);
        
        leftBarHeading.setText("<html><u>Information</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>Hover over a field to know more!<div></html>");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rulesList = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        confirmPasswordField = new javax.swing.JPasswordField();
        passwordField = new javax.swing.JPasswordField();
        saveBtn = new javax.swing.JButton();
        leftBarHeading = new javax.swing.JLabel();
        settingsBtn = new javax.swing.JButton();
        dropDown = new javax.swing.JComboBox<>();
        homeBtn = new javax.swing.JButton();
        homeUnderline = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1040, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        rulesList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(rulesList);
        rulesList.setBounds(20, 260, 220, 300);

        usernameLabel.setForeground(new java.awt.Color(74, 72, 65));
        usernameLabel.setEnabled(false);
        usernameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usernameLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                usernameLabelMouseExited(evt);
            }
        });
        getContentPane().add(usernameLabel);
        usernameLabel.setBounds(324, 151, 636, 53);

        emailLabel.setForeground(new java.awt.Color(74, 72, 65));
        emailLabel.setEnabled(false);
        emailLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emailLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emailLabelMouseExited(evt);
            }
        });
        getContentPane().add(emailLabel);
        emailLabel.setBounds(324, 250, 636, 53);

        lastNameField.setBackground(new java.awt.Color(243, 240, 231));
        lastNameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lastNameField.setForeground(new java.awt.Color(74, 72, 65));
        usersHelper user = new usersHelper();
        if(user.getLname(user.getLoggedInUser()).equals("")){
            lastNameField.setText("Last Name");
        } else {
            lastNameField.setText(user.getLname(user.getLoggedInUser()));
        }
        lastNameField.setBorder(null);
        lastNameField.setOpaque(false);
        lastNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lastNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastNameFieldFocusLost(evt);
            }
        });
        lastNameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lastNameFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lastNameFieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lastNameFieldMouseExited(evt);
            }
        });
        lastNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastNameFieldKeyTyped(evt);
            }
        });
        getContentPane().add(lastNameField);
        lastNameField.setBounds(653, 346, 307, 51);

        firstNameField.setBackground(new java.awt.Color(243, 240, 231));
        firstNameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        firstNameField.setForeground(new java.awt.Color(74, 72, 65));
        if(user.getFname(user.getLoggedInUser()).equals("")){
            firstNameField.setText("First Name");
        } else {
            firstNameField.setText(user.getFname(user.getLoggedInUser()));
        }
        firstNameField.setBorder(null);
        firstNameField.setOpaque(false);
        firstNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstNameFieldFocusLost(evt);
            }
        });
        firstNameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstNameFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                firstNameFieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                firstNameFieldMouseExited(evt);
            }
        });
        firstNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                firstNameFieldKeyTyped(evt);
            }
        });
        getContentPane().add(firstNameField);
        firstNameField.setBounds(326, 346, 310, 51);
        firstNameField.getAccessibleContext().setAccessibleName("");

        confirmPasswordField.setBackground(new java.awt.Color(243, 240, 231));
        confirmPasswordField.setForeground(new java.awt.Color(74, 72, 65));
        confirmPasswordField.setText("jPasswordField1");
        confirmPasswordField.setBorder(null);
        confirmPasswordField.setOpaque(false);
        confirmPasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirmPasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirmPasswordFieldFocusLost(evt);
            }
        });
        confirmPasswordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmPasswordFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmPasswordFieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmPasswordFieldMouseExited(evt);
            }
        });
        confirmPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                confirmPasswordFieldKeyTyped(evt);
            }
        });
        getContentPane().add(confirmPasswordField);
        confirmPasswordField.setBounds(650, 494, 310, 50);

        passwordField.setBackground(new java.awt.Color(243, 240, 231));
        passwordField.setForeground(new java.awt.Color(74, 72, 65));
        passwordField.setText("jPasswordField1");
        passwordField.setBorder(null);
        passwordField.setOpaque(false);
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });
        passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passwordFieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                passwordFieldMouseExited(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordFieldKeyTyped(evt);
            }
        });
        getContentPane().add(passwordField);
        passwordField.setBounds(324, 494, 310, 50);

        saveBtn.setBorderPainted(false);
        saveBtn.setContentAreaFilled(false);
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        getContentPane().add(saveBtn);
        saveBtn.setBounds(535, 587, 210, 62);

        leftBarHeading.setFont(new java.awt.Font("Lato", 2, 28)); // NOI18N
        leftBarHeading.setForeground(new java.awt.Color(195, 54, 70));
        getContentPane().add(leftBarHeading);
        leftBarHeading.setBounds(10, 190, 230, 50);
        leftBarHeading.setHorizontalAlignment(JLabel.CENTER);

        settingsBtn.setBorderPainted(false);
        settingsBtn.setContentAreaFilled(false);
        settingsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsBtnMouseClicked(evt);
            }
        });
        settingsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsBtnActionPerformed(evt);
            }
        });
        getContentPane().add(settingsBtn);
        settingsBtn.setBounds(585, 35, 140, 40);

        dropDown.setBackground(new java.awt.Color(0, 153, 51, 0));
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

        homeUnderline.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Extras/Underlines/homeUnderline.png"))); // NOI18N
        getContentPane().add(homeUnderline);
        homeUnderline.setBounds(442, 73, 80, 10);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Settings.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1040, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameFieldFocusGained
        // TODO add your handling code here:
        String fname = firstNameField.getText();
        
        if(fname.equals("First Name")){
            firstNameField.setText("");
        }
    }//GEN-LAST:event_firstNameFieldFocusGained

    private void firstNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameFieldFocusLost
        // TODO add your handling code here:
        String fname = firstNameField.getText();
        
        if(fname.equals("")){
            //Default username
            firstNameField.setText("First Name");
        }
    }//GEN-LAST:event_firstNameFieldFocusLost

    private void lastNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameFieldFocusGained
        // TODO add your handling code here:
        String lname = lastNameField.getText();
        
        if(lname.equals("Last Name")){
            lastNameField.setText("");
        }
    }//GEN-LAST:event_lastNameFieldFocusGained

    private void lastNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastNameFieldFocusLost
        // TODO add your handling code here:
        String lname = lastNameField.getText();
        
        if(lname.equals("")){
            //Default username
            lastNameField.setText("Last Name");
        }
    }//GEN-LAST:event_lastNameFieldFocusLost

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        // TODO add your handling code here:
        String password = new String(passwordField.getPassword());
        
        if(password.equals("jPasswordField1")){
            passwordField.setText("");
        }
    }//GEN-LAST:event_passwordFieldFocusGained

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        // TODO add your handling code here:
        String password = new String(passwordField.getPassword());
        
        if(password.equals("")){
            //Default username
            passwordField.setText("jPasswordField1");
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    private void confirmPasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmPasswordFieldFocusGained
        // TODO add your handling code here:
        String password = new String(confirmPasswordField.getPassword());
        
        if(password.equals("jPasswordField1")){
            confirmPasswordField.setText("");
        }
    }//GEN-LAST:event_confirmPasswordFieldFocusGained

    private void confirmPasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmPasswordFieldFocusLost
        // TODO add your handling code here:
        String password = new String(confirmPasswordField.getPassword());
        
        if(password.equals("")){
            //Default username
            confirmPasswordField.setText("jPasswordField1");
        }
    }//GEN-LAST:event_confirmPasswordFieldFocusLost

    private void usernameLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameLabelMouseEntered
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Information</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>That's your username!<br><br>You can't edit it though.</div></html>");
    }//GEN-LAST:event_usernameLabelMouseEntered

    private void usernameLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameLabelMouseExited
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Information</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>Hover over a field to know more!</div></html>");
    }//GEN-LAST:event_usernameLabelMouseExited

    private void emailLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailLabelMouseEntered
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Information</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>That's your email!<br><br>You can't edit it though. It's a one<br><br>time thing!</div></html>");
    }//GEN-LAST:event_emailLabelMouseEntered

    private void emailLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailLabelMouseExited
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Information</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>Hover over a field to know more!</div></html>");
    }//GEN-LAST:event_emailLabelMouseExited

    private void firstNameFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstNameFieldMouseEntered
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Information</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>Click on the text field to edit your<br><br>first name</div></html>");
    }//GEN-LAST:event_firstNameFieldMouseEntered

    private void firstNameFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstNameFieldMouseExited
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Information</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>Hover over a field to know more!</div></html>");
    }//GEN-LAST:event_firstNameFieldMouseExited

    private void lastNameFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastNameFieldMouseEntered
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Information</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>Click on the text field to edit your<br><br>last name</div></html>");
    }//GEN-LAST:event_lastNameFieldMouseEntered

    private void lastNameFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastNameFieldMouseExited
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Information</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>Hover over a field to know more!</div></html>");
    }//GEN-LAST:event_lastNameFieldMouseExited

    private void passwordFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMouseEntered
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Information</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>Click on the password field to<br><br>change your password</div></html>");
    }//GEN-LAST:event_passwordFieldMouseEntered

    private void passwordFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMouseExited
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Information</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>Hover over a field to know more!</div></html>");
    }//GEN-LAST:event_passwordFieldMouseExited

    private void confirmPasswordFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPasswordFieldMouseEntered
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Information</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>Re-enter your password here to<br><br>confirm password</div></html>");
    }//GEN-LAST:event_confirmPasswordFieldMouseEntered

    private void confirmPasswordFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPasswordFieldMouseExited
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Information</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>Hover over a field to know more!</div></html>");
    }//GEN-LAST:event_confirmPasswordFieldMouseExited

    private void firstNameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstNameFieldMouseClicked
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Rules</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>─ First name must be less than<br><br>20 characters.<br><br><br>─ First name cannot contain<br><br>numbers.<br><br><br>─ First name cannot contain<br><br> special characters.</div></html>");
    }//GEN-LAST:event_firstNameFieldMouseClicked

    private void firstNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameFieldKeyTyped
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Rules</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>─ First name must be less than<br><br>20 characters.<br><br><br>─ First name cannot contain<br><br>numbers.<br><br><br>─ First name cannot contain<br><br> special characters.</div></html>");
    }//GEN-LAST:event_firstNameFieldKeyTyped

    private void lastNameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastNameFieldMouseClicked
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Rules</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>─ Last name must be less than<br><br>20 characters.<br><br><br>─ Last name cannot contain<br><br>numbers.<br><br><br>─ Last name cannot contain<br><br> special characters.</div></html>");
    }//GEN-LAST:event_lastNameFieldMouseClicked

    private void lastNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameFieldKeyTyped
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Rules</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>─ Last name must be less than<br><br>20 characters.<br><br><br>─ Last name cannot contain<br><br>numbers.<br><br><br>─ Last name cannot contain<br><br> special characters.<div></html>");
    }//GEN-LAST:event_lastNameFieldKeyTyped

    private void passwordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMouseClicked
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Rules</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>─ Password must be 6-20<br><br>characters long.<br><br><br>─ New password cannot be the<br><br>same as old password.</div></html>");
    }//GEN-LAST:event_passwordFieldMouseClicked

    private void passwordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyTyped
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Rules</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>─ Password must be 6-20<br><br>characters long.<br><br><br>─ New password cannot be the<br><br>same as old password.</div></html>");
    }//GEN-LAST:event_passwordFieldKeyTyped

    private void confirmPasswordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPasswordFieldMouseClicked
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Rules</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>─ Password must be 6-20<br><br>characters long.<br><br><br>─ Re-entered password must<br><br>match the previously entered<br><br>password.</div></html>");
    }//GEN-LAST:event_confirmPasswordFieldMouseClicked

    private void confirmPasswordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmPasswordFieldKeyTyped
        // TODO add your handling code here:
        leftBarHeading.setText("<html><u>Rules</u></html>");
        rulesList.setVerticalAlignment(JLabel.TOP);
        rulesList.setHorizontalAlignment(JLabel.CENTER);
        
        rulesList.setText("<html><div style='text-align: center;'>─ Password must be 6-20<br><br>characters long.<br><br><br>─ Re-entered password must<br><br>match the previously entered<br><br>password.</div></html>");
    }//GEN-LAST:event_confirmPasswordFieldKeyTyped

    private void settingsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_settingsBtnMouseClicked

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        
        usersHelper user = new usersHelper();
        int user_id = user.getLoggedInUser();
        
        String fname = firstNameField.getText().trim();
        String lname = lastNameField.getText().trim();
        
        String old_password = user.getPassword(user.getLoggedInUser());
        String password = new String(passwordField.getPassword()).trim();
        String confirm_password = new String(confirmPasswordField.getPassword()).trim();
        
        Validation validate = new Validation();
        
        boolean save = true, error = true;
        
        //Check for First Name
        if(validate.stringIsEmpty(fname) == true && fname.equals("First Name")){
            save = false;
        }
        
        if(validate.validateName(fname, "First Name") == false){
            leftBarHeading.setText("<html><u>Error</u></html>");
            rulesList.setText("<html><div style='text-align: center;'>" + validate.error + "</div></html>");
            save = false;
        }
        
        if(save == true  && !fname.equals("First Name")){
            user.setFname(fname, user_id);
            //Show success
            leftBarHeading.setText("<html><u style='color:#58ad0d;'>Saved</u></html>");
            rulesList.setText("<html><div style='text-align:center;'>Your settings have been<br><br>updated!</div></html>");
            error = false;
        }
        
        //Reset flag
        save = true;
        
        //Check for Last Name
        if(validate.stringIsEmpty(lname) == true && lname.equals("Last Name")){
            save = false;
        }
        
        if(validate.validateName(lname, "Last Name") == false){
            leftBarHeading.setText("<html><u>Error</u></html>");
            rulesList.setText("<html><div style='text-align: center;'>" + validate.error + "</div></html>");
            save = false;
        }
        
        if(save == true && error == false && !lname.equals("Last Name")){
            user.setLname(lname, user_id);
            //Show success
            leftBarHeading.setText("<html><u style='color:#58ad0d;'>Saved</u></html>");
            rulesList.setText("<html><div style='text-align:center;'>Your settings have been<br><br>updated!</div></html>");
        }
        
        //Reset flag
        save = true;
        
        //Check for Password
        if(validate.validatePassword(password) == false){
            leftBarHeading.setText("<html><u>Error</u></html>");
            rulesList.setText("<html><div style='text-align:center;'>" + validate.error + "</div></html>");
            save = false;
        }
        
        if(validate.stringIsEmpty(password)){
            save = false;
        }
        
        if(password.equals(old_password)){
            leftBarHeading.setText("<html><u>Error</u></html>");
            
            //New password is same as the old password
            rulesList.setText("<html><div style='text-align:center;'>Again, new password cannot be<br><br>the same as the old one!</div></html>");
            save = false;
        }
        
        if(!password.equals(confirm_password)){
            leftBarHeading.setText("<html><u>Error</u></html>");
            rulesList.setText("<html><div style='text-align:center;'>Passwords don't match</div></html>");
            save = false;
        }
        
        if(save == true && !password.equals("jPasswordField1") && !confirm_password.equals("jPasswordField1")){
            user.setPassword(password, user_id);
            
            //Show success
            leftBarHeading.setText("<html><u style='color:#58ad0d;'>Saved</u></html>");
            rulesList.setText("<html><div style='text-align:center;'>Your settings have been<br><br>updated!</div></html>");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void homeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseEntered
        // TODO add your handling code here:
        homeUnderline.setVisible(true);
    }//GEN-LAST:event_homeBtnMouseEntered

    private void homeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseExited
        // TODO add your handling code here:
        homeUnderline.setVisible(false);
    }//GEN-LAST:event_homeBtnMouseExited

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        Home window = new Home();
        window.setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_homeBtnActionPerformed

    private void settingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_settingsBtnActionPerformed

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

    private void setDisabledFieldValues(){
        usersHelper user = new usersHelper();
        
        String username = user.getUsername(user.getLoggedInUser());
        String email = user.getEmail(user.getLoggedInUser());
        
        usernameLabel.setText(username);
        emailLabel.setText(email);
    }
        
    
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
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JComboBox<String> dropDown;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel homeUnderline;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel leftBarHeading;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel rulesList;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton settingsBtn;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}

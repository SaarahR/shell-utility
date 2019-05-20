package Core;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import org.apache.commons.io.FilenameUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shahlin
 */
public class PDFReader extends javax.swing.JFrame {

    /**
     * Creates new form PDFReader
     */
    public PDFReader() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
        recentName1.setVisible(false);
        recentName2.setVisible(false);
        recentName3.setVisible(false);
        recentName4.setVisible(false);
        
        openPDFError.setVisible(false);
        
        homeUnderline.setVisible(false);
        settingsUnderline.setVisible(false);
        
        setRecentsData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openBtn = new javax.swing.JButton();
        fileInput = new javax.swing.JTextField();
        attachBtn = new javax.swing.JButton();
        recentName4 = new javax.swing.JLabel();
        recentName3 = new javax.swing.JLabel();
        recentName2 = new javax.swing.JLabel();
        recentName1 = new javax.swing.JLabel();
        dropDown = new javax.swing.JComboBox<>();
        openPDFError = new javax.swing.JLabel();
        homeBtn = new javax.swing.JButton();
        settingsBtn = new javax.swing.JButton();
        settingsUnderline = new javax.swing.JLabel();
        homeUnderline = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1040, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        openBtn.setBorderPainted(false);
        openBtn.setContentAreaFilled(false);
        openBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openBtnActionPerformed(evt);
            }
        });
        getContentPane().add(openBtn);
        openBtn.setBounds(331, 519, 621, 61);

        fileInput.setEditable(false);
        fileInput.setBackground(new java.awt.Color(243, 240, 231));
        fileInput.setForeground(new java.awt.Color(74, 72, 65));
        fileInput.setBorder(null);
        getContentPane().add(fileInput);
        fileInput.setBounds(340, 430, 440, 50);

        attachBtn.setBorderPainted(false);
        attachBtn.setContentAreaFilled(false);
        attachBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        attachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attachBtnActionPerformed(evt);
            }
        });
        getContentPane().add(attachBtn);
        attachBtn.setBounds(796, 430, 152, 50);

        recentName4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recentName4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recentName4MouseClicked(evt);
            }
        });
        getContentPane().add(recentName4);
        recentName4.setBounds(74, 505, 147, 40);

        recentName3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recentName3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recentName3MouseClicked(evt);
            }
        });
        getContentPane().add(recentName3);
        recentName3.setBounds(74, 430, 147, 40);

        recentName2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recentName2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recentName2MouseClicked(evt);
            }
        });
        getContentPane().add(recentName2);
        recentName2.setBounds(74, 358, 147, 40);

        recentName1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recentName1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recentName1MouseClicked(evt);
            }
        });
        getContentPane().add(recentName1);
        recentName1.setBounds(74, 290, 147, 40);

        dropDown.setBackground(new java.awt.Color(0, 153, 51, 0));
        usersHelper user = new usersHelper();
        dropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {user.getUsername(user.getLoggedInUser()), "Logout"}));
        dropDown.setOpaque(false);
        dropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropDownActionPerformed(evt);
            }
        });
        getContentPane().add(dropDown);
        dropDown.setBounds(798, 35, 186, 38);

        openPDFError.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/Extras/openPDFError.png"))); // NOI18N
        getContentPane().add(openPDFError);
        openPDFError.setBounds(329, 422, 626, 64);

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

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backgrounds/PDFReader.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 1040, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openBtnActionPerformed
        // TODO add your handling code here:
        Validation validate = new Validation();
        
        String filePath = fileInput.getText();
        
        File f = new File(filePath);
        String fileName = f.getName();
        String fileExt = FilenameUtils.getExtension(filePath);
        
        if(f.exists() && !f.isDirectory() && fileExt.equals("pdf") && validate.stringIsEmpty(filePath) == false) { 
            //The file exists and is valid
            openPDFError.setVisible(false);
            
            // build a controller
            SwingController controller = new SwingController();

            // Build a SwingViewFactory configured with the controller
            SwingViewBuilder factory = new SwingViewBuilder(controller);

            // Use the factory to build a JPanel that is pre-configured
            //with a complete, active Viewer UI.
            JPanel viewerComponentPanel = factory.buildViewerPanel();

            // add copy keyboard command
            ComponentKeyBinding.install(controller, viewerComponentPanel);

            // add interactive mouse link annotation support via callback
            controller.getDocumentViewController().setAnnotationCallback(new org.icepdf.ri.common.MyAnnotationCallback(controller.getDocumentViewController()));

            // Create a JFrame to display the panel in
            JFrame window = new JFrame(filePath);
            window.getContentPane().add(viewerComponentPanel);
            window.pack();
            window.setVisible(true);

            // Open a PDF document to view
            controller.openDocument(filePath);

            pdfreaderHelper helper = new pdfreaderHelper();

            fileName = fileName.substring(0, fileName.length() - 4);
            helper.insertFile(fileName, filePath);
        } else {
            openPDFError.setVisible(true);
        }
    }//GEN-LAST:event_openBtnActionPerformed
    
    private void attachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attachBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser filePicker = new JFileChooser();
        filePicker.showOpenDialog(this);
        
        File file = null;
        String filePath = "";
        
        if(filePicker.getSelectedFile() != null){
            file = filePicker.getSelectedFile();
            filePath = file.getAbsolutePath();
        }
        
        fileInput.setText(filePath);
    }//GEN-LAST:event_attachBtnActionPerformed

    private void dropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropDownActionPerformed
        // TODO add your handling code here:

        if (dropDown.getSelectedItem().equals("Logout")) {
            usersHelper user = new usersHelper();
            user.logout();
            this.setVisible(false);
            dispose();

            Login window = new Login();
            window.setVisible(true);
        }
    }//GEN-LAST:event_dropDownActionPerformed

    private void recentName1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recentName1MouseClicked
        // TODO add your handling code here:
        pdfreaderHelper helper = new pdfreaderHelper();
        usersHelper user = new usersHelper();
        
        int user_id = user.getLoggedInUser();
        
        fileInput.setText(helper.getFilePaths(user_id)[0]);
        openBtnActionPerformed(null);
    }//GEN-LAST:event_recentName1MouseClicked

    private void recentName2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recentName2MouseClicked
        // TODO add your handling code here:
        pdfreaderHelper helper = new pdfreaderHelper();
        usersHelper user = new usersHelper();
        
        int user_id = user.getLoggedInUser();
        
        fileInput.setText(helper.getFilePaths(user_id)[1]);
        openBtnActionPerformed(null);
    }//GEN-LAST:event_recentName2MouseClicked

    private void recentName3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recentName3MouseClicked
        // TODO add your handling code here:
        pdfreaderHelper helper = new pdfreaderHelper();
        usersHelper user = new usersHelper();
        
        int user_id = user.getLoggedInUser();
        
        fileInput.setText(helper.getFilePaths(user_id)[2]);
        openBtnActionPerformed(null);
    }//GEN-LAST:event_recentName3MouseClicked

    private void recentName4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recentName4MouseClicked
        // TODO add your handling code here:
        pdfreaderHelper helper = new pdfreaderHelper();
        usersHelper user = new usersHelper();
        
        int user_id = user.getLoggedInUser();
        
        fileInput.setText(helper.getFilePaths(user_id)[3]);
        openBtnActionPerformed(null);
    }//GEN-LAST:event_recentName4MouseClicked

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

    private void settingsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseClicked
        // TODO add your handling code here:
        Settings window = new Settings();
        window.setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_settingsBtnMouseClicked

    private void settingsBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseEntered
        // TODO add your handling code here:
        settingsUnderline.setVisible(true);
    }//GEN-LAST:event_settingsBtnMouseEntered

    private void settingsBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsBtnMouseExited
        // TODO add your handling code here:
        settingsUnderline.setVisible(false);
    }//GEN-LAST:event_settingsBtnMouseExited

    private void settingsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsBtnActionPerformed
        // TODO add your handling code here:
        Settings window = new Settings();
        window.setVisible(true);
    }//GEN-LAST:event_settingsBtnActionPerformed

    private void setRecentsData(){
        pdfreaderHelper helper = new pdfreaderHelper();
        usersHelper user = new usersHelper();
        
        int user_id = user.getLoggedInUser();
        int count = helper.getRecentsCount(user_id);
        
        if(count == 1){
            recentName1.setVisible(true);
            recentName1.setText(helper.getFileNames(user_id)[0]);
        } else if(count == 2){
            recentName1.setVisible(true);
            recentName2.setVisible(true);
            
            recentName1.setText(helper.getFileNames(user_id)[0]);
            recentName2.setText(helper.getFileNames(user_id)[1]);
        } else if(count == 3){
            recentName1.setVisible(true);
            recentName2.setVisible(true);
            recentName3.setVisible(true);
            
            recentName1.setText(helper.getFileNames(user_id)[0]);
            recentName2.setText(helper.getFileNames(user_id)[1]);
            recentName2.setText(helper.getFileNames(user_id)[2]);
        } else if(count == 4){
            recentName1.setVisible(true);
            recentName2.setVisible(true);
            recentName3.setVisible(true);
            recentName4.setVisible(true);
            
            recentName1.setText(helper.getFileNames(user_id)[0]);
            recentName2.setText(helper.getFileNames(user_id)[1]);
            recentName3.setText(helper.getFileNames(user_id)[2]);
            recentName4.setText(helper.getFileNames(user_id)[3]);
        }
        
        
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
            java.util.logging.Logger.getLogger(PDFReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDFReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDFReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDFReader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PDFReader().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attachBtn;
    private javax.swing.JLabel background;
    private javax.swing.JComboBox<String> dropDown;
    private javax.swing.JTextField fileInput;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel homeUnderline;
    private javax.swing.JButton openBtn;
    private javax.swing.JLabel openPDFError;
    private javax.swing.JLabel recentName1;
    private javax.swing.JLabel recentName2;
    private javax.swing.JLabel recentName3;
    private javax.swing.JLabel recentName4;
    private javax.swing.JButton settingsBtn;
    private javax.swing.JLabel settingsUnderline;
    // End of variables declaration//GEN-END:variables
}

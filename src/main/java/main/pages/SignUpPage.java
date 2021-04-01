
package main.pages;

import main.PageManager;
import main.audio.AudioManager;
import main.database.DataManager;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class SignUpPage extends Page {
    
    /**
     * Creates new form SignUpPage
     */
    public SignUpPage(AudioManager audioManager, PageManager pageManager, String name) {
        super(name);
        initComponents();

        userIcon1.setText("");
        userIcon2.setText("");
        emailIcon.setText("");
        pswIcon.setText("");
        userIcon1.setIcon(new ImageIcon(getClass().getResource("/user-solid.png")));
        userIcon2.setIcon(new ImageIcon(getClass().getResource("/user-solid.png")));
        emailIcon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/envelope-solid.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
        pswIcon.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/lock-solid.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

        //this.initPage(audioManager, pageManager);
    }

    @Override
    public void initPage(AudioManager audioManager, PageManager pageManager, DataManager dataManager) {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        emailInputField = new javax.swing.JTextField();
        pswIcon = new javax.swing.JLabel();
        emailIcon = new javax.swing.JLabel();
        signupButton = new javax.swing.JButton();
        fPswButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        passwordInputField = new javax.swing.JPasswordField();
        cognomeInputField = new javax.swing.JTextField();
        userIcon1 = new javax.swing.JLabel();
        userIcon2 = new javax.swing.JLabel();
        nomeInputField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel3.setBackground(new java.awt.Color(0, 200, 83));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 572));

        jPanel2.setBackground(new java.awt.Color(34, 34, 34));

        jPanel1.setBackground(new java.awt.Color(34, 34, 34));

        emailInputField.setBackground(new java.awt.Color(44, 44, 44));
        emailInputField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailInputField.setForeground(new java.awt.Color(153, 153, 153));
        emailInputField.setText("Email");
        emailInputField.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 5));
        emailInputField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        emailInputField.setOpaque(true);
        emailInputField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailInputFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailInputFieldFocusLost(evt);
            }
        });

        pswIcon.setBackground(new java.awt.Color(51, 51, 51));
        pswIcon.setForeground(new java.awt.Color(204, 204, 204));
        pswIcon.setText("jLabel1");

        emailIcon.setBackground(new java.awt.Color(51, 51, 51));
        emailIcon.setForeground(new java.awt.Color(204, 204, 204));
        emailIcon.setText("jLabel1");

        signupButton.setBackground(new java.awt.Color(0, 200, 83));
        signupButton.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        signupButton.setForeground(new java.awt.Color(255, 255, 255));
        signupButton.setText("Crea account");
        signupButton.setActionCommand("login");
        signupButton.setBorder(null);
        signupButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signupButton.setOpaque(true);
        signupButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signupButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signupButtonMouseExited(evt);
            }
        });

        fPswButton.setBackground(new java.awt.Color(66, 67, 68));
        fPswButton.setForeground(new java.awt.Color(204, 204, 204));
        fPswButton.setText("Accedi");
        fPswButton.setActionCommand("fpsw");
        fPswButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fPswButton.setFocusPainted(false);

        titleLabel.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 200, 83));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Registrati");

        passwordInputField.setBackground(new java.awt.Color(44, 44, 44));
        passwordInputField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passwordInputField.setForeground(new java.awt.Color(153, 153, 153));
        passwordInputField.setText("password");
        passwordInputField.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 5));
        passwordInputField.setOpaque(true);
        passwordInputField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordInputFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordInputFieldFocusLost(evt);
            }
        });

        cognomeInputField.setBackground(new java.awt.Color(44, 44, 44));
        cognomeInputField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cognomeInputField.setForeground(new java.awt.Color(153, 153, 153));
        cognomeInputField.setText("Cognome");
        cognomeInputField.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 5));
        cognomeInputField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        cognomeInputField.setOpaque(true);
        cognomeInputField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cognomeInputFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cognomeInputFieldFocusLost(evt);
            }
        });

        userIcon1.setBackground(new java.awt.Color(51, 51, 51));
        userIcon1.setForeground(new java.awt.Color(204, 204, 204));
        userIcon1.setText("jLabel1");

        userIcon2.setBackground(new java.awt.Color(51, 51, 51));
        userIcon2.setForeground(new java.awt.Color(204, 204, 204));
        userIcon2.setText("jLabel1");

        nomeInputField.setBackground(new java.awt.Color(44, 44, 44));
        nomeInputField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nomeInputField.setForeground(new java.awt.Color(153, 153, 153));
        nomeInputField.setText("Nome");
        nomeInputField.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 5));
        nomeInputField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nomeInputField.setOpaque(true);
        nomeInputField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomeInputFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomeInputFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(userIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(userIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cognomeInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(emailIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                    .addComponent(pswIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fPswButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cognomeInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pswIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(fPswButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bentornato!");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)))
                .addGap(78, 78, 78))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void emailInputFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailInputFieldFocusGained
        if(emailInputField.getText().equals("") || emailInputField.getText().equals("Email"))
            emailInputField.setText("");
        emailInputField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)), emailInputField.getBorder()));
    }//GEN-LAST:event_emailInputFieldFocusGained

    private void emailInputFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailInputFieldFocusLost
        if(emailInputField.getText().equals(""))
            emailInputField.setText("Username");
        emailInputField.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 5));
    }//GEN-LAST:event_emailInputFieldFocusLost

    private void signupButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupButtonMouseExited
        signupButton.setBackground(new java.awt.Color(0, 200, 83));
    }//GEN-LAST:event_signupButtonMouseExited

    private void passwordInputFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordInputFieldFocusGained
        if(passwordInputField.getText().equals("") || passwordInputField.getText().equals("Password"))
            passwordInputField.setText("");
        passwordInputField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)), passwordInputField.getBorder()));
    }//GEN-LAST:event_passwordInputFieldFocusGained

    private void passwordInputFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordInputFieldFocusLost
        if(passwordInputField.getText().equals(""))
            passwordInputField.setText("Password");
        passwordInputField.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 5));
    }//GEN-LAST:event_passwordInputFieldFocusLost

    private void cognomeInputFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cognomeInputFieldFocusGained
        if(cognomeInputField.getText().equals("") || cognomeInputField.getText().equals("Cognome"))
            cognomeInputField.setText("");
        cognomeInputField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)), cognomeInputField.getBorder()));
    }//GEN-LAST:event_cognomeInputFieldFocusGained

    private void cognomeInputFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cognomeInputFieldFocusLost
        if(cognomeInputField.getText().equals(""))
            cognomeInputField.setText("Cognome");
        cognomeInputField.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 5));
    }//GEN-LAST:event_cognomeInputFieldFocusLost

    private void nomeInputFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeInputFieldFocusGained
        if(nomeInputField.getText().equals("") || nomeInputField.getText().equals("Nome"))
            nomeInputField.setText("");
        nomeInputField.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)), nomeInputField.getBorder()));
    }//GEN-LAST:event_nomeInputFieldFocusGained

    private void nomeInputFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeInputFieldFocusLost
        if(nomeInputField.getText().equals(""))
        nomeInputField.setText("Nome");
        nomeInputField.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 5));
    }//GEN-LAST:event_nomeInputFieldFocusLost

    private void signupButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupButtonMouseEntered
        signupButton.setBackground(new java.awt.Color(0, 170, 72));
    }//GEN-LAST:event_signupButtonMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cognomeInputField;
    private javax.swing.JLabel emailIcon;
    private javax.swing.JTextField emailInputField;
    private javax.swing.JButton fPswButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nomeInputField;
    private javax.swing.JPasswordField passwordInputField;
    private javax.swing.JLabel pswIcon;
    private javax.swing.JButton signupButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel userIcon1;
    private javax.swing.JLabel userIcon2;
    // End of variables declaration//GEN-END:variables
}
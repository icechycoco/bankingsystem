/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import com.c.BankAccount;
import javax.swing.JOptionPane;


/**
 *
 * @author Nann
 */
public class create_account extends javax.swing.JFrame {

    /**
     * Creates new form create_account
     */
    public create_account() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        idno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        deposit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        phone = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        first = new javax.swing.JTextField();
        last = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Create account");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 130, 120, 60);

        jLabel2.setText("Account Name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 200, 110, 30);

        jLabel3.setText("Desopit :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(400, 200, 70, 30);

        jLabel5.setText("ID number :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(400, 250, 90, 30);
        getContentPane().add(idno);
        idno.setBounds(500, 250, 190, 30);

        jLabel6.setText("Address :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(400, 360, 70, 20);
        getContentPane().add(deposit);
        deposit.setBounds(500, 200, 170, 30);

        jLabel9.setText("E-mail :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(400, 300, 60, 30);

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        getContentPane().add(name);
        name.setBounds(160, 200, 170, 30);

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email);
        email.setBounds(500, 300, 190, 30);

        address.setColumns(20);
        address.setRows(5);
        jScrollPane2.setViewportView(address);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(500, 350, 210, 70);
        getContentPane().add(phone);
        phone.setBounds(160, 350, 170, 30);

        jLabel13.setText("Phone number :");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(50, 350, 100, 30);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/back.gif"))); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(280, 450, 100, 50);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/arrow_right_black.gif"))); // NOI18N
        jButton2.setText("Next");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(380, 450, 100, 50);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI/banner1.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, 0, 800, 145);

        first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstActionPerformed(evt);
            }
        });
        getContentPane().add(first);
        first.setBounds(160, 250, 170, 30);
        getContentPane().add(last);
        last.setBounds(160, 300, 170, 30);

        jLabel15.setText("First name :");
        jLabel15.setSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel15);
        jLabel15.setBounds(50, 250, 110, 30);

        jLabel16.setText("Last name :");
        jLabel16.setPreferredSize(new java.awt.Dimension(110, 30));
        getContentPane().add(jLabel16);
        jLabel16.setBounds(50, 300, 110, 30);

        jLabel4.setText("Bath");
        jLabel4.setSize(new java.awt.Dimension(45, 30));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(680, 200, 45, 30);

        setSize(new java.awt.Dimension(799, 522));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
            displayApp profile = new displayApp();
            profile.setVisible(true);
            setVisible(false);    
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        int n = JOptionPane.showConfirmDialog(null,
//            "Sucess! your account was created",
//            "Message",
//            JOptionPane.YES_NO_OPTION);
//        System.out.print(n);
//        if(n == 1){
//            setVisible(true);  
//        }else{
//            /*
//            String gender = "";
//            if(jRadioButton1.isSelected()){
//                gender = "M";
//            }else if(jRadioButton2.isSelected()){
//                gender = "F";
//            }
//            */
//            BankAccount.openAccount(name.getText(), Double.parseDouble(deposit.getText()), email.getText(),
//                                    phone.getText(), idno.getText(), address.getText(),first.getText(),last.getText());
//            //System.out.println(jDateChooser1.getDate().toString());
//            displayApp profile = new displayApp();
//            profile.setVisible(true);
//            setVisible(false);
//        }
    
        try{
            BankAccount.openAccount(name.getText(), Double.parseDouble(deposit.getText()), email.getText(),
                                    phone.getText(), idno.getText(), address.getText(),first.getText(),last.getText());
            //System.out.println(jDateChooser1.getDate().toString());
            displayApp profile = new displayApp();
            profile.setVisible(true);
            setVisible(false);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Please fill all the form");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
 
    }//GEN-LAST:event_nameActionPerformed

    private void firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(create_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(create_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(create_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(create_account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new create_account().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea address;
    private javax.swing.JTextField deposit;
    private javax.swing.JTextField email;
    private javax.swing.JTextField first;
    private javax.swing.JTextField idno;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField last;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    // End of variables declaration//GEN-END:variables

    

   
}

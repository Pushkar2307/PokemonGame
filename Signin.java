/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbs;

import java.sql.*;
import javax.swing.JOptionPane;
import static pbs.SignUp.conn;
import newpackage.PasswordValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pushkar
 */
public class Signin extends javax.swing.JFrame {

    /**
     * Creates new form Signin
     */
    String url="jdbc:oracle:thin:@DESKTOP-08UAP4B:1521:XE";
            String username="push";
            String password="umsy0410";
    public Signin() {
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

        jLabel4 = new javax.swing.JLabel();
        User = new javax.swing.JTextField();
        Pass = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(537, 396));
        getContentPane().setLayout(null);

        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Role");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(170, 230, 25, 16);

        User.setText("Enter username");
        getContentPane().add(User);
        User.setBounds(324, 73, 97, 22);

        Pass.setText("Enter password");
        Pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassActionPerformed(evt);
            }
        });
        getContentPane().add(Pass);
        Pass.setBounds(324, 138, 95, 22);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Trainer" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(320, 230, 69, 22);

        jButton1.setText("Sign-UP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 300, 77, 25);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("SiignUP");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(231, 13, 70, 22);

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 80, 58, 16);

        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 140, 55, 16);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Pushkar\\Desktop\\images\\1_537x396.jpg")); // NOI18N
        jLabel6.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                jLabel6AncestorResized(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1, -4, 537, 400);

        setBounds(0, 0, 555, 443);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            conn=DriverManager.getConnection(url,username,password);
            Statement st= conn.createStatement();
            //String pattern="(?=.*[0-9])(?=.*[a-z])";
            String PASSWORD_PATTERN = 
              "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
            
            if(Pass.getText().matches(PASSWORD_PATTERN)){
            st.executeQuery("insert into poke_Users values('"+User.getText()+"','"+Pass.getText()+"','"+jComboBox1.getSelectedItem().toString()+"')");
            if(jComboBox1.getSelectedItem().toString().equals("Trainer"))
            {
                st.executeQuery("insert into user_trainer(trainer_id) values('"+User.getText()+"')");
                st.executeQuery("insert into trainer_inven(trainer_id) values('"+User.getText()+"')");
                st.executeQuery("insert into trainer_coins(trainer_id) values('"+User.getText()+"')");
                st.executeQuery("insert into trainer_gym(trainer_id) values('"+User.getText()+"')");
            }
            this.setVisible(false);
            new LoginForm().setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Password should contain atleast one digit,special character,one small letter,one capital letter");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel6AncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_jLabel6AncestorResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6AncestorResized

    private void PassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PassActionPerformed

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
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Pass;
    private javax.swing.JTextField User;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbs;
//import javaapplication2.ProffOak;
//import pbs.SignUp;
import newpackage.Pokemon;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahe
 */

public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    String url="jdbc:oracle:thin:@DESKTOP-08UAP4B:1521:XE";
    String username="push";
    String password="umsy0410";
    //String type="trainer";
    public LoginForm() {
        initComponents();
        this.setBounds(40, 40, 500, 500);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(416, 305));
        setPreferredSize(new java.awt.Dimension(416, 305));
        getContentPane().setLayout(null);

        jTextField1.setText("Enter Username");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(250, 40, 119, 22);

        jButton1.setText("LOGIN");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(80, 200, 110, 25);

        jButton2.setText("SIGN UP");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(80, 250, 110, 25);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PASSWORD :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 80, 80, 16);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("USER NAME :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 40, 80, 16);

        jPasswordField1.setText("jPasswordField1");
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(250, 80, 126, 22);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Pushkar\\Desktop\\images\\2_416x305.jpg")); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setMaximumSize(new java.awt.Dimension(415, 293));
        jLabel3.setMinimumSize(new java.awt.Dimension(415, 293));
        jLabel3.setPreferredSize(new java.awt.Dimension(415, 293));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1, 6, 410, 290);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String user=jTextField1.getText();
        String pass=new String(jPasswordField1.getPassword());
        
        try{
            String driverName="oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            Connection conn=DriverManager.getConnection(url,username,password);
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select name,pass,role from poke_Users where name='"+user+"'");
            if(rs.next())
            {
                String pass_correct=rs.getObject(2).toString();
                String type=rs.getObject(3).toString();
                if(pass.equals(pass_correct))
                {
                    if(type.equals("Trainer"))
                    {
                        JOptionPane.showMessageDialog(this,"Successful Login!");
                    this.setVisible(false);
                    ProffOak f = new ProffOak(user);
                    f.setVisible(true);
                    }
                    else
                    {
                    JOptionPane.showMessageDialog(this,"Successful Login!");
                    this.setVisible(false);
                    new Admin().setVisible(true);
                    
                    }
                    
                }
                else
                {
                   JOptionPane.showMessageDialog(this,"Invalid password.Try Again!"); 
                
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Invalid Username.Try Again!");
            }
            
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        new Signin().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

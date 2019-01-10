/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import newpackage.Pokemon;

/**
 *
 * @author Mahe
 */
public class BattleOptions extends javax.swing.JFrame {

    /**
     * Creates new form BattleOptions
     */
    Pokemon P1 , P2 , P3;
    int movesetLength;
    String m1 = null,m2 = null,
            m3 = null,m4 = null;
    String url="jdbc:oracle:thin:@DESKTOP-08UAP4B:1521:XE";
    String username="push";
    String password="umsy0410";
    static String user;
    public String GetMove(File f2) throws FileNotFoundException, IOException
    {
        String s =null;
        Random r = new Random();
        BufferedReader b = new BufferedReader(new FileReader(f2));
        int n = r.nextInt(movesetLength);
        int i = 0;
         while((s=b.readLine()) != null)
       {  if(n==17)
                n--;
        if(n==i)
        {s = b.readLine(); if(s==null){s = "Swift--Normal--60--100";} System.out.println(s); return s;}
         i++;
       }
         //System.out.println(s);
        return("Swift--Normal--60--100");
        
    }
    public int GetMovesetLength(File f2) throws FileNotFoundException, IOException
    {
        int size = 0;
        BufferedReader b = new BufferedReader(new FileReader(f2));
        String s = null;
        while((s=b.readLine())!=null)
            size ++;
        return size;
    }
    public String GetRandomPokemon() throws FileNotFoundException, IOException
    {   Random r = new Random();
        int n = r.nextInt(131) ;
        // 131 for 1v1 and wild
        File f = new File("D:\\PBS_Final\\PBS\\Moveset\\Random1v1.txt");
        BufferedReader b = new BufferedReader(new FileReader(f));
        String s = null;
        for(int i = 0; i <= 131 ; i++)
        {
            if(i==n)
            {
                s = b.readLine();
                File f2 = new File("D:\\PBS_Final\\PBS\\Moveset\\"+s+".txt");
            movesetLength = GetMovesetLength(f2);
            do{
            m1 = GetMove(f2);
            m2 = GetMove(f2);
            m3 = GetMove(f2);
            m4 = GetMove(f2);}while(m1.equals(m2) && m1.equals(m3) &&m1.equals(m4) &&m2.equals(m3) &&m2.equals(m4) &&m3.equals(m4));
                return(s);
            }
           
            b.readLine();
        }
         
        return(s);
    }
    public BattleOptions(String abc) {
        //this.P1 = P1;
        //this.P2 = P2;
        //this.P3 = P3;
        user=abc;
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(414, 330));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setText("1v1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(119, 30, 141, 25);

        jButton2.setText("3v3");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(119, 73, 141, 25);

        jButton3.setText("3v3 KO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(119, 116, 141, 25);

        jButton5.setText("Tournament");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(119, 168, 141, 25);

        jButton6.setText("Shop");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(119, 211, 141, 25);

        jButton4.setText("See Pokemon");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(119, 254, 141, 25);

        jButton7.setText("View League Table");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(119, 292, 141, 25);

        jButton8.setText("Logout");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(299, 13, 71, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Pushkar\\Desktop\\images\\4_414x330.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1, 6, 410, 320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(P1.GetPokemonHP()!=0)
       {Pokemon Y2 = null;   String randompokemon = null; 
        try {   randompokemon = GetRandomPokemon();
        System.out.println(randompokemon);
            Y2 = new Pokemon(randompokemon,1,m1,m2,m3,m4);
        } catch (IOException ex) {
            Logger.getLogger(BattleOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //Y2.SetPokemonType("Fire", "Flying");
            Y2.SetPokemonTypeMethod2();
            P1.SetPokemonTypeMethod2();
        } catch (IOException ex) {
            Logger.getLogger(BattleOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
       //P1.SetPokemonType("Psychic", "Type0");
        NewJFrame f = new NewJFrame(user,P1,Y2);
       f.setVisible(true);
       }
       else
       {
           JOptionPane.showMessageDialog(this,"Your Pokemon Is Fainted","Alert",JOptionPane.WARNING_MESSAGE);
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {                                         
            Pokemon Y1 = null , Y2=null , Y3=null;
            String randompokemon = null ;
            
            try {
                randompokemon = GetRandomPokemon();
            } catch (IOException ex) {
                Logger.getLogger(BattleOptions.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(randompokemon);
            Y1 = new Pokemon(randompokemon,1,m1,m2,m3,m4);
            
            try {
                randompokemon = GetRandomPokemon();
            } catch (IOException ex) {
                Logger.getLogger(BattleOptions.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(randompokemon);
            Y2 = new Pokemon(randompokemon,1,m1,m2,m3,m4);
            
            try {
                randompokemon = GetRandomPokemon();
            } catch (IOException ex) {
                Logger.getLogger(BattleOptions.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(randompokemon);
            Y3 = new Pokemon(randompokemon,1,m1,m2,m3,m4);
            
            Y1.SetPokemonTypeMethod2();P1.SetPokemonTypeMethod2();
            Y2.SetPokemonTypeMethod2();P2.SetPokemonTypeMethod2();
            Y3.SetPokemonTypeMethod2();P3.SetPokemonTypeMethod2();
            
            ThreeVsThree f =new ThreeVsThree(user,P1,P2,P3,Y1,Y2,Y3); 
            f.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(BattleOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
        new Shop(user).setVisible(true);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       try {                                         
            Pokemon Y1 = null , Y2=null , Y3=null;
            String randompokemon = null ;
            
            try {
                randompokemon = GetRandomPokemon();
            } catch (IOException ex) {
                Logger.getLogger(BattleOptions.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(randompokemon);
            Y1 = new Pokemon(randompokemon,1,m1,m2,m3,m4);
            
            try {
                randompokemon = GetRandomPokemon();
            } catch (IOException ex) {
                Logger.getLogger(BattleOptions.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(randompokemon);
            Y2 = new Pokemon(randompokemon,1,m1,m2,m3,m4);
            
            try {
                randompokemon = GetRandomPokemon();
            } catch (IOException ex) {
                Logger.getLogger(BattleOptions.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(randompokemon);
            Y3 = new Pokemon(randompokemon,1,m1,m2,m3,m4);
            
            Y1.SetPokemonTypeMethod2();P1.SetPokemonTypeMethod2();
            Y2.SetPokemonTypeMethod2();P2.SetPokemonTypeMethod2();
            Y3.SetPokemonTypeMethod2();P3.SetPokemonTypeMethod2();
            
            ThreeVsThreeKO f =new ThreeVsThreeKO(user,P1,P2,P3,Y1,Y2,Y3); 
            f.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(BattleOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try{
            Connection conn=DriverManager.getConnection(url,username,password);
            Statement stmt1=conn.createStatement();
            Statement stmt=conn.createStatement();
            
            ResultSet rs1=stmt.executeQuery("select * from trainer_pokemon where trainer_id='"+user+"' and flag=1");
            rs1.next();
                
                
                String poke_name=rs1.getObject(2).toString();
                int level=rs1.getInt(3);
                String m1=rs1.getObject(4).toString(); 
                String m2=rs1.getObject(5).toString(); 
                String m3=rs1.getObject(6).toString(); 
                String m4=rs1.getObject(7).toString();
                P1= new Pokemon(poke_name,level,m1,m2,m3,m4);
                rs1.next();
                poke_name=rs1.getObject(2).toString();
                level=rs1.getInt(3);
                m1=rs1.getObject(4).toString(); 
                m2=rs1.getObject(5).toString(); 
                m3=rs1.getObject(6).toString(); 
                m4=rs1.getObject(7).toString();
                P2= new Pokemon(poke_name,level,m1,m2,m3,m4);
                rs1.next();
                poke_name=rs1.getObject(2).toString();
                level=rs1.getInt(3);
                m1=rs1.getObject(4).toString(); 
                m2=rs1.getObject(5).toString(); 
                m3=rs1.getObject(6).toString(); 
                m4=rs1.getObject(7).toString();
                P3= new Pokemon(poke_name,level,m1,m2,m3,m4);
                
                
               
            
            
        
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_formWindowActivated

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        new SeePokemon(user).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.setVisible(false);
        new Gyms(user).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.setVisible(false);
        new League_Table().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.setVisible(false);
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(BattleOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BattleOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BattleOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BattleOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BattleOptions(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
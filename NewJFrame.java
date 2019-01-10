/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import newpackage.Pokemon;
import static pbs.ThreeVsThree.user;

/**
 *
 * @author Mahe
 */

public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    static String user;
    String url="jdbc:oracle:thin:@DESKTOP-08UAP4B:1521:XE";
    String username="push";
    String password="umsy0410";
    double[][] effect = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1} 
            ,{1,1,2,1,1,.5,.5,.5,.5,.5,2,1,1,1,.5,2,1,.5,1} 
            ,{1,1,.5,1,1,.5,.5,1,1,2,1,1,1,1,1,2,1,1,1} 
            ,{1,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,1,.5,1} 
            ,{1,1,1,.5,.5,1,1,1,2,1,.5,0,1,1,1,1,1,1,2} 
            ,{1,1,2,2,1,1,2,.5,1,1,1,1,1,1,.5,1,1,.5,1} 
            ,{1,.5,2,1,1,.5,1,1,.5,0,1,1,2,2,.5,.5,2,2,1} 
            ,{1,2,1,.5,1,1,1,.5,1,1,2,1,2,1,1,1,.5,2,.5} 
            ,{1,2,1,1,.5,1,2,1,1,1,2,1,1,1,1,1,.5,.5,1} 
            ,{1,1,.5,1,1,1,1,1,1,2,1,1,1,0,1,2,1,1,1} 
            ,{1,.5,1,.5,1,1,1,.5,.5,1,.5,2,1,1,.5,1,2,.5,2} 
            ,{1,.5,1,1,2,1,1,2,0,1,.5,1,1,1,2,1,2,2,1} 
            ,{1,1,1,2,1,1,1,.5,2,1,2,2,.5,1,1,1,1,.5,.5} 
            ,{1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,.5,.5,1} 
            ,{1,1,1,1,1,2,1,1,1,.5,2,.5,1,1,.5,1,.5,0,1} 
            ,{1,1,0,1,1,1,2,1,1,1,1,1,1,1,2,.5,1,.5,1} 
            ,{1,2,1,1,1,1,.5,2,2,1,1,.5,2,1,1,1,1,.5,1} 
            ,{1,1,1,1,.5,2,1,.5,1,1,1,1,2,1,1,1,2,.5,.5} 
            ,{1,1,1,.5,1,1,1,2,1,1,.5,2,1,1,1,1,1,1,.5}};
    
      String[] PokemonType = {"Type0" , "Bug" , "Dark" 
                , "Dragon", "Electric" , "Fairy" , "Fighting" 
                , "Fire" , "Flying" , "Ghost" , "Grass" 
                , "Ground" , "Ice" , "Normal" , "Poison" 
                , "Psychic" , "Rock" , "Steel" , "Water"};
    
    int turn = 0 , damage , n ;
    Pokemon X , Y2 ;
    String Y = "charizard" + ".png";
    
  
    public void PlayMusic() throws IOException
    {       
           String filename = "C://Users//Mahe//Desktop//Story LIne//RUP//PBS//Music//ThemeMusic2.wav";
    ContinuousAudioDataStream loop = null;
    InputStream in = null;
    try {
        in = new FileInputStream(filename);
    } catch (FileNotFoundException ex) {
        System.out.println("File not found");
    }
    try {
        AudioStream s = new AudioStream(in);
        AudioData MD ;
        
        AudioPlayer.player.start(s);
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
    }
    }
    public void GetImages()
    {
        ImageIcon icon1 = new ImageIcon("D:\\PBS_Final\\PBS\\Images\\" + X.GetName() + ".png");
        ImageIcon icon2 = new ImageIcon("D:\\PBS_Final\\PBS\\Images\\" + Y2.GetName() + ".png");
        ImageIcon icon3 = new ImageIcon("D:\\PBS_Final\\PBS\\battle_arena.jpg");
        jLabel2.setIcon(icon1);
        jLabel3.setIcon(icon2);
        //jLabel6.setIcon(icon3);
        
    }
    
    public String GetMoveAttribute(String s , int x)
    {
        int i = 0;
         StringTokenizer st= new  StringTokenizer(s,"--");
         while(st.hasMoreTokens())
           {    if(i==x)    
           {return(st.nextToken());}
            i++;st.nextToken();
           }
        return null;
    }
    
    public double Effectiveness(String movetype , String PT1 , String PT2)
    {   int t = 0 , pt1=0 , pt2=0 ;
            
            for(int i = 0 ; i < 19 ; i++)
            {
                if(PokemonType[i].equals(movetype))
                    t = i;
                if(PokemonType[i].equals(PT1))
                    pt1 = i;
                if(PokemonType[i].equals(PT2))
                    pt2 = i;
            }
            double e = effect[t][pt1] * effect[t][pt2];
        return e;
    }
    public NewJFrame(String abc,Pokemon X , Pokemon Y2)  {
        user=abc;
        this.X = X ;
        this.Y2 = Y2;
        initComponents();
        GetImages();
        
        jButton1.setText(GetMoveAttribute(X.GetMove1(),0));
        jButton2.setText(GetMoveAttribute(X.GetMove2(),0));
        jButton3.setText(GetMoveAttribute(X.GetMove3(),0));
        jButton4.setText(GetMoveAttribute(X.GetMove4(),0));
        
        jButton7.setText(GetMoveAttribute(Y2.GetMove1(),0));
        jButton8.setText(GetMoveAttribute(Y2.GetMove2(),0));
        jButton5.setText(GetMoveAttribute(Y2.GetMove3(),0));
        jButton6.setText(GetMoveAttribute(Y2.GetMove4(),0));
        
        jLabel4.setText(Integer.toString(X.GetPokemonHP()));
        jLabel1.setText(Integer.toString(Y2.GetPokemonHP()));
        
        
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(858, 413));
        setPreferredSize(new java.awt.Dimension(858, 413));
        getContentPane().setLayout(null);

        jLabel2.setText("1");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 70, 70, 50);

        jLabel3.setText("2");
        jLabel3.setMaximumSize(new java.awt.Dimension(3400, 1400));
        jLabel3.setMinimumSize(new java.awt.Dimension(3400, 1400));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(550, 70, 70, 50);

        jButton1.setText("Surf");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(44, 158, 135, 25);

        jButton2.setText("Earthquake");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(224, 158, 139, 25);

        jButton3.setText("Hydropump");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(44, 204, 135, 25);

        jButton4.setText("Ice Beam");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(224, 204, 139, 25);

        jButton5.setText("Aerial Ace");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(446, 204, 138, 25);

        jButton6.setText("Steal Wing");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(632, 204, 137, 25);

        jButton7.setText("Famethrower");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(446, 158, 138, 25);

        jButton8.setText("Fire Blast");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(632, 158, 137, 25);

        jLabel1.setText("500");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(600, 43, 169, 21);

        jLabel4.setText("500");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(44, 43, 169, 21);

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(143, 269, 544, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(turn==0) {damage = (int) (Double.parseDouble(GetMoveAttribute(X.GetMove2(), 2))*Effectiveness(GetMoveAttribute(X.GetMove2(),1),Y2.GetPokemonType1(),Y2.GetPokemonType2())); 
        turn = 1;
        jTextField1.setText(X.GetName()+" USED "+ jButton2.getText());
        }
        else damage = 0;
 int x = Integer.parseInt(jLabel1.getText()) - damage;
        if(x<=0) 
        {Y2.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You Win.","Alert",JOptionPane.WARNING_MESSAGE); this.dispose(); 
        try{
            Connection conn=DriverManager.getConnection(url,username,password);
            Statement stmt1=conn.createStatement();
            //ResultSet rs=stmt1.executeQuery("select level from trainer_pokemon where")
            
            
            stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X.PokemonName+"' and trainer_id='"+user+"'" );
            //stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X2.PokemonName+"' and trainer_id='"+user+"'" );
            //stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X3.PokemonName+"' and trainer_id='"+user+"'" );
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);
            
            
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }}
        else
        {jLabel1.setText(Integer.toString(Integer.parseInt(jLabel1.getText()) - damage));Y2.SetPokemonHP(x);}
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
         Random r = new Random();
        n = r.nextInt(4);
        if(n==0)
        {if(turn==1) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove1(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove1(),1),X.GetPokemonType1(),X.GetPokemonType2())); 
        turn = 0;
        jTextField1.setText(Y2.GetName()+" USED "+ jButton7.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose.","Alert",JOptionPane.WARNING_MESSAGE);this.dispose(); }
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        else if(n==1)
        { if(turn==1) {damage  = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove2(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove2(),1),X.GetPokemonType1(),X.GetPokemonType2())); 
        turn = 0;
         jTextField1.setText(Y2.GetName()+" USED "+ jButton8.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE); this.dispose();}
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        else if(n==2)
        {if(turn==1) {damage  = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove3(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove3(),1),X.GetPokemonType1(),X.GetPokemonType2())); ; 
        turn = 0;
         jTextField1.setText(Y2.GetName()+" USED "+ jButton5.getText());
       }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE); this.dispose(); }
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        else
        {if(turn==1) {damage  = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove4(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove4(),1),X.GetPokemonType1(),X.GetPokemonType2())); ; 
        turn = 0;
         jTextField1.setText(Y2.GetName()+" USED "+ jButton6.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE); this.dispose();}
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if(turn==0) {damage = (int) (Double.parseDouble(GetMoveAttribute(X.GetMove1(), 2))*Effectiveness(GetMoveAttribute(X.GetMove1(),1),Y2.GetPokemonType1(),Y2.GetPokemonType2())); 
        turn = 1;
        jTextField1.setText(X.GetName()+" USED "+ jButton1.getText());
        try {
            //jLabel1.setText("Bro..What Bro..");
            //jLabel1.paintImmediately(jLabel1.getVisibleRect());
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else {damage = 0;}
        int x = Integer.parseInt(jLabel1.getText()) - damage;
        if(x<=0) 
        {Y2.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You win","Alert",JOptionPane.WARNING_MESSAGE); this.dispose();
        try{
            Connection conn=DriverManager.getConnection(url,username,password);
            Statement stmt1=conn.createStatement();
            //ResultSet rs=stmt1.executeQuery("select level from trainer_pokemon where")
            
            
            stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X.PokemonName+"' and trainer_id='"+user+"'" );
            //stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X2.PokemonName+"' and trainer_id='"+user+"'" );
            //stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X3.PokemonName+"' and trainer_id='"+user+"'" );
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);
            
            
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        }
        else
        {jLabel1.setText(Integer.toString(Integer.parseInt(jLabel1.getText()) - damage));Y2.SetPokemonHP(x);}
    
        Random r = new Random();
        n = r.nextInt(4);
        if(n==0)
        {if(turn==1) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove1(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove1(),1),X.GetPokemonType1(),X.GetPokemonType2())); 
        turn = 0;
        jTextField1.setText(Y2.GetName()+" USED "+ jButton7.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE);this.dispose(); }
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        else if(n==1)
        { if(turn==1) {damage  = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove2(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove2(),1),X.GetPokemonType1(),X.GetPokemonType2())); 
        turn = 0;
         jTextField1.setText(Y2.GetName()+" USED "+ jButton8.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE); this.dispose();}
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        else if(n==2)
        {if(turn==1) {damage  = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove3(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove3(),1),X.GetPokemonType1(),X.GetPokemonType2())); ; 
        turn = 0;
         jTextField1.setText(Y2.GetName()+" USED "+ jButton5.getText());
       }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE); this.dispose(); }
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        else
        {if(turn==1) {damage  = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove4(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove4(),1),X.GetPokemonType1(),X.GetPokemonType2())); ; 
        turn = 0;
         jTextField1.setText(Y2.GetName()+" USED "+ jButton6.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE); this.dispose();}
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       
         
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
         
         
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
         
         
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
         
         
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(turn==0) {damage = damage = (int) (Double.parseDouble(GetMoveAttribute(X.GetMove4(), 2))*Effectiveness(GetMoveAttribute(X.GetMove4(),1),Y2.GetPokemonType1(),Y2.GetPokemonType2()));
        turn = 1;
      jTextField1.setText(X.GetName()+" USED "+ jButton4.getText());
        }
        else damage = 0;
        int x = Integer.parseInt(jLabel1.getText()) - damage;
        if(x<=0) 
        {Y2.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You win","Alert",JOptionPane.WARNING_MESSAGE);this.dispose(); 
        try{
            Connection conn=DriverManager.getConnection(url,username,password);
            Statement stmt1=conn.createStatement();
            //ResultSet rs=stmt1.executeQuery("select level from trainer_pokemon where")
            
            
            stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X.PokemonName+"' and trainer_id='"+user+"'" );
            //stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X2.PokemonName+"' and trainer_id='"+user+"'" );
            //stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X3.PokemonName+"' and trainer_id='"+user+"'" );
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);
            
            
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }}
        else
        {jLabel1.setText(Integer.toString(x));Y2.SetPokemonHP(0);Y2.SetPokemonHP(x);}
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
         Random r = new Random();
        n = r.nextInt(4);
        if(n==0)
        {if(turn==1) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove1(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove1(),1),X.GetPokemonType1(),X.GetPokemonType2())); 
        turn = 0;
        jTextField1.setText(Y2.GetName()+" USED "+ jButton7.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE);this.dispose(); }
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        else if(n==1)
        { if(turn==1) {damage  = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove2(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove2(),1),X.GetPokemonType1(),X.GetPokemonType2())); 
        turn = 0;
         jTextField1.setText(Y2.GetName()+" USED "+ jButton8.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE); this.dispose();}
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        else if(n==2)
        {if(turn==1) {damage  = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove3(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove3(),1),X.GetPokemonType1(),X.GetPokemonType2())); ; 
        turn = 0;
         jTextField1.setText(Y2.GetName()+" USED "+ jButton5.getText());
       }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE); this.dispose(); }
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        else
        {if(turn==1) {damage  = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove4(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove4(),1),X.GetPokemonType1(),X.GetPokemonType2())); ; 
        turn = 0;
         jTextField1.setText(Y2.GetName()+" USED "+ jButton6.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE); this.dispose();}
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(turn==0) {damage = damage = (int) (Double.parseDouble(GetMoveAttribute(X.GetMove3(), 2))*Effectiveness(GetMoveAttribute(X.GetMove3(),1),Y2.GetPokemonType1(),Y2.GetPokemonType2()));
        turn = 1; jTextField1.setText(X.GetName()+" USED "+ jButton3.getText());
       }
        else damage = 0;
        int x = Integer.parseInt(jLabel1.getText()) - damage;
        if(x<=0) 
        {Y2.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You win","Alert",JOptionPane.WARNING_MESSAGE);this.dispose(); 
        try{
            Connection conn=DriverManager.getConnection(url,username,password);
            Statement stmt1=conn.createStatement();
            //ResultSet rs=stmt1.executeQuery("select level from trainer_pokemon where")
            
            
            stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X.PokemonName+"' and trainer_id='"+user+"'" );
            //stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X2.PokemonName+"' and trainer_id='"+user+"'" );
            //stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X3.PokemonName+"' and trainer_id='"+user+"'" );
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);
            
            
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }}
        else
        {jLabel1.setText(Integer.toString(x));Y2.SetPokemonHP(0);}
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
         Random r = new Random();
        n = r.nextInt(4);
        if(n==0)
        {if(turn==1) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove1(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove1(),1),X.GetPokemonType1(),X.GetPokemonType2())); 
        turn = 0;
        jTextField1.setText(Y2.GetName()+" USED "+ jButton7.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE);this.dispose(); }
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        else if(n==1)
        { if(turn==1) {damage  = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove2(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove2(),1),X.GetPokemonType1(),X.GetPokemonType2())); 
        turn = 0;
         jTextField1.setText(Y2.GetName()+" USED "+ jButton8.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE); this.dispose();}
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        else if(n==2)
        {if(turn==1) {damage  = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove3(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove3(),1),X.GetPokemonType1(),X.GetPokemonType2())); ; 
        turn = 0;
         jTextField1.setText(Y2.GetName()+" USED "+ jButton5.getText());
       }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE); this.dispose(); }
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        else
        {if(turn==1) {damage  = (int) (Double.parseDouble(GetMoveAttribute(Y2.GetMove4(), 2))*Effectiveness(GetMoveAttribute(Y2.GetMove4(),1),X.GetPokemonType1(),X.GetPokemonType2())); ; 
        turn = 0;
         jTextField1.setText(Y2.GetName()+" USED "+ jButton6.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel4.getText()) - damage;
         if(x1<=0) 
        {X.SetPokemonHP(0);this.setVisible(false); JOptionPane.showMessageDialog(this,"You lose","Alert",JOptionPane.WARNING_MESSAGE); this.dispose();}
        else
         {jLabel4.setText(Integer.toString(x1));X.SetPokemonHP(x1);}}
        
       
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame(user,null,null).setVisible(true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

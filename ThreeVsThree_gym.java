/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import newpackage.Pokemon;

/**
 *
 * @author Pushkar
 */
public class ThreeVsThree_gym extends javax.swing.JFrame {

    String url="jdbc:oracle:thin:@DESKTOP-08UAP4B:1521:XE";
    String username="push";
    String password="umsy0410";
    static String user;
    static int gym;
    static int level;
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
    
    int turn = 0 , damage , n  ;
    Pokemon X1 , X2 , X3 , Y1 , Y2 , Y3 ;
    String Y = "charizard" + ".png";
    
       public void GetImages()
    {
////        ImageIcon icon1 = new ImageIcon("C://Users//Mahe//Desktop//Story LIne//RUP//Images//" + X1.GetName() + ".png");
//            try {
////                ImageIcon icon1 = new ImageIcon("C:\\Users\\Mahe\\Desktop\\Story LIne\\RUP\\PBS\\Images\\charizard.png");
////                jLabel1.setIcon(icon1);
//                jLabel1.setText("no");
//
//            }
//            catch (NullPointerException e) {
//                System.out.println("aaaaa");
//                e.printStackTrace();
////                jLabel1.setText("oh no");
//            }
//            
//            try {
////                ImageIcon icon2 = new ImageIcon("C:\\Users\\Mahe\\Desktop\\Story LIne\\RUP\\PBS\\Images\\charizard.png");
////                jLabel2.setIcon(icon2);
//                jLabel2.setText("no");
//            }
//            catch (NullPointerException e) {
//                System.out.println("aaaaab");
//                    e.printStackTrace();
////                jLabel1.setText("oh no");
//            }
        
            
            

//        ImageIcon icon2 = new ImageIcon("C://Users//Mahe//Desktop//Story LIne//RUP//Images//" + Y1.GetName() + ".png");
//                ImageIcon icon2 = new ImageIcon("C:\\Users\\Mahe\\Desktop\\Story LIne\\RUP\\PBS\\Images\\charizard.png");

        ImageIcon icon1 = new ImageIcon("D:\\PBS_Final\\PBS\\Images\\" + X1.GetName() + ".png");
        ImageIcon icon2 = new ImageIcon("D:\\PBS_Final\\PBS\\Images\\" + Y1.GetName() + ".png");
        //ImageIcon icon3 = new ImageIcon("C://Users//Mahe//Desktop//Story LIne//RUP//PBS//battle_arena.jpg");

        jLabel1.setIcon(icon1);
        jLabel2.setIcon(icon2);
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
    public ThreeVsThree_gym(String abc,int cde,Pokemon X1 , Pokemon X2 , Pokemon X3  ,  Pokemon Y1 , Pokemon Y2 , Pokemon Y3 ) {
        this.X1 = X1;
        this.X2 = X2;
        this.X3 = X3;
        this.Y1 = Y1;
        this.Y2 = Y2;
        this.Y3 = Y3;
        user=abc;
        gym=cde;
    
        initComponents();
            GetImages();
        
        jButton1.setText(GetMoveAttribute(X1.GetMove1(),0));
        jButton2.setText(GetMoveAttribute(X1.GetMove2(),0));
        jButton3.setText(GetMoveAttribute(X1.GetMove3(),0));
        jButton4.setText(GetMoveAttribute(X1.GetMove4(),0));
        
        jButton7.setText(GetMoveAttribute(Y1.GetMove2(),0));
        jButton8.setText(GetMoveAttribute(Y1.GetMove3(),0));
        jButton9.setText(GetMoveAttribute(Y1.GetMove4(),0));
        jButton6.setText(GetMoveAttribute(Y1.GetMove1(),0));
        
       jButton10.setText(X2.GetName());
       jButton11.setText(X3.GetName());
        
        jLabel3.setText(Integer.toString(X1.GetPokemonHP()));
        jLabel4.setText(Integer.toString(Y1.GetPokemonHP()));
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
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(619, 328));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jTextField1.setText("jTextField1");
        getContentPane().add(jTextField1);
        jTextField1.setBounds(36, 239, 527, 38);

        jButton3.setText("Move3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(12, 176, 121, 25);

        jButton4.setText("Move4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(215, 176, 117, 25);

        jButton6.setText("OppMv1");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(338, 132, 117, 25);

        jButton7.setText("OppMv2");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(338, 176, 117, 25);

        jButton8.setText("OppMv3");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(473, 132, 117, 25);

        jButton9.setText("OppMv4");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(473, 176, 117, 25);

        jButton10.setText("PK2");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10);
        jButton10.setBounds(25, 290, 53, 25);

        jLabel1.setText("1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 70, 40, 40);

        jButton11.setText("PK3");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11);
        jButton11.setBounds(96, 290, 53, 25);

        jLabel2.setText("2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(431, 63, 40, 30);

        jLabel3.setText("500");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(116, 22, 53, 16);

        jButton1.setText("Move1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(12, 132, 121, 25);

        jLabel4.setText("500");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(451, 22, 53, 16);

        jButton2.setText("Move2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(215, 132, 117, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(turn==0 && X1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(X1.GetMove3(), 2))*Effectiveness(GetMoveAttribute(X1.GetMove3(),1),Y1.GetPokemonType1(),Y1.GetPokemonType2()))*(1+level/10);
            turn = 1;
            jTextField1.setText(X1.GetName()+" USED "+jButton3.getText());
        }
        else {damage = 0;}
        int x = Integer.parseInt(jLabel4.getText()) - damage;
        if(x<=0)
        {Y1.SetPokemonHP(0);
            jLabel4.setText("0");
            JOptionPane.showMessageDialog(this,"Setting Opp To 0","Alert",JOptionPane.WARNING_MESSAGE);}
        else
        {jLabel4.setText(Integer.toString(Integer.parseInt(jLabel4.getText()) - damage));Y1.SetPokemonHP(x);}

        Random r = new Random();
        n = r.nextInt(4);
        if(Y1.GetPokemonHP()==0 && Y3.GetPokemonHP()==0 && Y2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You WIN","Alert",JOptionPane.WARNING_MESSAGE);
            try{
                Connection conn=DriverManager.getConnection(url,username,password);
                Statement stmt1=conn.createStatement();
                //ResultSet rs=stmt1.executeQuery("select level from trainer_pokemon where")

                stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X1.PokemonName+"' and trainer_id='"+user+"'" );
                stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X2.PokemonName+"' and trainer_id='"+user+"'" );
                stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X3.PokemonName+"' and trainer_id='"+user+"'" );
                if(gym==1){
                stmt1.executeQuery("update trainer_gym set g1='Badge' where trainer_id='"+user+"'");
                        }
                if(gym==2){
                stmt1.executeQuery("update trainer_gym set g2='Badge' where trainer_id='"+user+"'");
                        }
                if(gym==3){
                stmt1.executeQuery("update trainer_gym set g3='Badge' where trainer_id='"+user+"'");
                        }
                if(gym==4){
                stmt1.executeQuery("update trainer_gym set g4='Badge' where trainer_id='"+user+"'");
                        }
            }

            catch(Exception e){
                System.out.println(e.getMessage());
            }
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }

        if(Y1.GetPokemonHP()==0)
        {
            if(Y2.GetPokemonHP()!=0)
            {ThreeVsThree f =new ThreeVsThree(user,X1,X2,X3,Y2,Y1,Y3);
                this.setVisible(false);
                f.setVisible(true);}

            else if(Y3.GetPokemonHP()!=0)
            {
                ThreeVsThree f =new ThreeVsThree(user,X1,X2,X3,Y3,Y2,Y1);
                this.setVisible(false);
                f.setVisible(true);
            }
        }
        else if(n==0)
        {if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove1(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove1(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton6.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
        else if(n==1)
        { if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove3(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove3(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton8.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
        else if(n==2)
        {if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove2(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove2(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton7.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
        else
        {if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove4(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove4(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton9.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(turn==0 && X1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(X1.GetMove4(), 2))*Effectiveness(GetMoveAttribute(X1.GetMove4(),1),Y1.GetPokemonType1(),Y1.GetPokemonType2()))*(1+level/10);
            turn = 1;
            jTextField1.setText(X1.GetName()+" USED "+jButton4.getText());
        }
        else {damage = 0;}
        int x = Integer.parseInt(jLabel4.getText()) - damage;
        if(x<=0)
        {Y1.SetPokemonHP(0);
            jLabel4.setText("0");
            JOptionPane.showMessageDialog(this,"Setting Opp To 0","Alert",JOptionPane.WARNING_MESSAGE);}
        else
        {jLabel4.setText(Integer.toString(Integer.parseInt(jLabel4.getText()) - damage));Y1.SetPokemonHP(x);}

        Random r = new Random();
        n = r.nextInt(4);
        if(Y1.GetPokemonHP()==0 && Y3.GetPokemonHP()==0 && Y2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You WIN","Alert",JOptionPane.WARNING_MESSAGE);
            try{
                Connection conn=DriverManager.getConnection(url,username,password);
                Statement stmt1=conn.createStatement();
                //ResultSet rs=stmt1.executeQuery("select level from trainer_pokemon where")

                stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X1.PokemonName+"' and trainer_id='"+user+"'" );
                stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X2.PokemonName+"' and trainer_id='"+user+"'" );
                stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X3.PokemonName+"' and trainer_id='"+user+"'" );
if(gym==1){
                stmt1.executeQuery("update trainer_gym set g1='Badge' where trainer_id='"+user+"'");
                        }
                if(gym==2){
                stmt1.executeQuery("update trainer_gym set g2='Badge' where trainer_id='"+user+"'");
                        }
                if(gym==3){
                stmt1.executeQuery("update trainer_gym set g3='Badge' where trainer_id='"+user+"'");
                        }
                if(gym==4){
                stmt1.executeQuery("update trainer_gym set g4='Badge' where trainer_id='"+user+"'");
                        }
            }

            catch(Exception e){
                System.out.println(e.getMessage());
            }
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }

        if(Y1.GetPokemonHP()==0)
        {
            if(Y2.GetPokemonHP()!=0)
            {ThreeVsThree f =new ThreeVsThree(user,X1,X2,X3,Y2,Y1,Y3);
                this.setVisible(false);
                f.setVisible(true);}

            else if(Y3.GetPokemonHP()!=0)
            {
                ThreeVsThree f =new ThreeVsThree(user,X1,X2,X3,Y3,Y2,Y1);
                this.setVisible(false);
                f.setVisible(true);
            }
        }
        else if(n==0)
        {if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove1(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove1(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton6.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
        else if(n==1)
        { if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove3(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove3(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton8.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
        else if(n==2)
        {if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove2(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove2(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton7.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
        else
        {if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove4(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove4(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton9.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //     if(Y1.GetPokemonHP()==0 && Y3.GetPokemonHP()==0 && Y2.GetPokemonHP()==0)
        //        {
            //            JOptionPane.showMessageDialog(this,"You WIN","Alert",JOptionPane.WARNING_MESSAGE);
            //            this.setVisible(false);
            //            this.dispose();
            //        }
        //
        //        if(Y1.GetPokemonHP()==0)
        //        {
            //            if(Y2.GetPokemonHP()!=0)
            //            {ThreeVsThree f =new ThreeVsThree(X1,X2,X3,Y2,Y1,Y3);
                //            f.setVisible(true);}
            //        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(turn==0){ ThreeVsThree f =new ThreeVsThree(user,X2,X1,X3,Y1,Y2,Y3);
            turn = 1;
            this.setVisible(false);
            f.setVisible(true);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(turn==0){ThreeVsThree f =new ThreeVsThree(user,X3,X2,X1,Y1,Y2,Y3);
            turn = 1;
            this.setVisible(false);
            f.setVisible(true);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(turn==0 && X1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(X1.GetMove1(), 2))*Effectiveness(GetMoveAttribute(X1.GetMove1(),1),Y1.GetPokemonType1(),Y1.GetPokemonType2()))*(1+level/10);
            turn = 1;
            jTextField1.setText(X1.GetName()+" USED "+jButton1.getText());
        }
        else {damage = 0;}
        int x = Integer.parseInt(jLabel4.getText()) - damage;
        if(x<=0)
        {Y1.SetPokemonHP(0);
            jLabel4.setText("0");
            JOptionPane.showMessageDialog(this,"Setting Opp To 0","Alert",JOptionPane.WARNING_MESSAGE);}
        else
        {jLabel4.setText(Integer.toString(Integer.parseInt(jLabel4.getText()) - damage));Y1.SetPokemonHP(x);}

        Random r = new Random();
        n = r.nextInt(4);
        if(Y1.GetPokemonHP()==0 && Y3.GetPokemonHP()==0 && Y2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You WIN","Alert",JOptionPane.WARNING_MESSAGE);
            try{
                Connection conn=DriverManager.getConnection(url,username,password);
                Statement stmt1=conn.createStatement();
                //ResultSet rs=stmt1.executeQuery("select level from trainer_pokemon where")

                stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X1.PokemonName+"' and trainer_id='"+user+"'" );
                stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X2.PokemonName+"' and trainer_id='"+user+"'" );
                stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X3.PokemonName+"' and trainer_id='"+user+"'" );
                if(gym==1){
                stmt1.executeQuery("update trainer_gym set g1='Badge' where trainer_id='"+user+"'");
                        }
                if(gym==2){
                stmt1.executeQuery("update trainer_gym set g2='Badge' where trainer_id='"+user+"'");
                        }
                if(gym==3){
                stmt1.executeQuery("update trainer_gym set g3='Badge' where trainer_id='"+user+"'");
                        }
                if(gym==4){
                stmt1.executeQuery("update trainer_gym set g4='Badge' where trainer_id='"+user+"'");
                        }
                this.setVisible(false);
                new BattleOptions(user).setVisible(true);

            }

            catch(Exception e){
                System.out.println(e.getMessage());
            }

        }

        if(Y1.GetPokemonHP()==0)
        {
            if(Y2.GetPokemonHP()!=0)
            {ThreeVsThree f =new ThreeVsThree(user,X1,X2,X3,Y2,Y1,Y3);
                this.setVisible(false);
                f.setVisible(true);}

            else if(Y3.GetPokemonHP()!=0)
            {
                ThreeVsThree f =new ThreeVsThree(user,X1,X2,X3,Y3,Y2,Y1);
                this.setVisible(false);
                f.setVisible(true);
            }
        }
        else if(n==0)
        {if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove1(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove1(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton6.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
        else if(n==1)
        { if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove3(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove3(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton8.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
        else if(n==2)
        {if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove2(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove2(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton7.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
        else
        {if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove4(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove4(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton9.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(turn==0 && X1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(X1.GetMove2(), 2))*Effectiveness(GetMoveAttribute(X1.GetMove2(),1),Y1.GetPokemonType1(),Y1.GetPokemonType2()))*(1+level/10);
            turn = 1;
            jTextField1.setText(X1.GetName()+" USED "+jButton2.getText());
        }
        else {damage = 0;}
        int x = Integer.parseInt(jLabel4.getText()) - damage;
        if(x<=0)
        {Y1.SetPokemonHP(0);
            jLabel4.setText("0");
            JOptionPane.showMessageDialog(this,"Setting Opp To 0","Alert",JOptionPane.WARNING_MESSAGE);}
        else
        {jLabel4.setText(Integer.toString(Integer.parseInt(jLabel4.getText()) - damage));Y1.SetPokemonHP(x);}

        Random r = new Random();
        n = r.nextInt(4);
        if(Y1.GetPokemonHP()==0 && Y3.GetPokemonHP()==0 && Y2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You WIN","Alert",JOptionPane.WARNING_MESSAGE);
            try{
                Connection conn=DriverManager.getConnection(url,username,password);
                Statement stmt1=conn.createStatement();
                //ResultSet rs=stmt1.executeQuery("select level from trainer_pokemon where")

                stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X1.PokemonName+"' and trainer_id='"+user+"'" );
                stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X2.PokemonName+"' and trainer_id='"+user+"'" );
                stmt1.executeQuery("update trainer_pokemon set lev=lev+1 where pokemon='"+X3.PokemonName+"' and trainer_id='"+user+"'" );
                if(gym==1){
                stmt1.executeQuery("update trainer_gym set g1='Badge' where trainer_id='"+user+"'");
                        }
                if(gym==2){
                stmt1.executeQuery("update trainer_gym set g2='Badge' where trainer_id='"+user+"'");
                        }
                if(gym==3){
                stmt1.executeQuery("update trainer_gym set g3='Badge' where trainer_id='"+user+"'");
                        }
                if(gym==4){
                stmt1.executeQuery("update trainer_gym set g4='Badge' where trainer_id='"+user+"'");
                        }
                this.setVisible(false);
                new BattleOptions(user).setVisible(true);

            }

            catch(Exception e){
                System.out.println(e.getMessage());
            }

        }

        if(Y1.GetPokemonHP()==0)
        {
            if(Y2.GetPokemonHP()!=0)
            {ThreeVsThree f =new ThreeVsThree(user,X1,X2,X3,Y2,Y1,Y3);
                this.setVisible(false);
                f.setVisible(true);}

            else if(Y3.GetPokemonHP()!=0)
            {
                ThreeVsThree f =new ThreeVsThree(user,X1,X2,X3,Y3,Y2,Y1);
                this.setVisible(false);
                f.setVisible(true);
            }
        }
        else if(n==0)
        {if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove1(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove1(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton6.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
        else if(n==1)
        { if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove3(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove3(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton8.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
        else if(n==2)
        {if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove2(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove2(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton7.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
        else
        {if(turn==1 && Y1.GetPokemonHP()!=0) {damage = (int) (Double.parseDouble(GetMoveAttribute(Y1.GetMove4(), 2))*Effectiveness(GetMoveAttribute(Y1.GetMove4(),1),X1.GetPokemonType1(),X1.GetPokemonType2()));
            turn = 0;
            jTextField1.setText(Y1.GetName()+" USED "+jButton9.getText());
        }
        else damage = 0;
        int x1 = Integer.parseInt(jLabel3.getText()) - damage;
        if(x1<=0)
        {X1.SetPokemonHP(0);
            jLabel3.setText("0");
        }
        else
        {jLabel3.setText(Integer.toString(x1));X1.SetPokemonHP(x1);}

        if(X1.GetPokemonHP()==0 && X3.GetPokemonHP()==0 && X2.GetPokemonHP()==0)
        {
            JOptionPane.showMessageDialog(this,"You LOSE","Alert",JOptionPane.WARNING_MESSAGE);
            this.setVisible(false);
            new BattleOptions(user).setVisible(true);

        }}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try{
            Connection conn=DriverManager.getConnection(url,username,password);
            Statement stmt1=conn.createStatement();
            //ResultSet rs=stmt1.executeQuery("select level from trainer_pokemon where")
            
            
            ResultSet rs=stmt1.executeQuery("select lev from trainer_pokemon where trainer_id='"+user+"' and pokemon='"+X1.GetName()+"'");
            rs.next();
            level=rs.getInt(1);
            
            
            
            
            
        }
        
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(ThreeVsThree_gym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThreeVsThree_gym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThreeVsThree_gym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThreeVsThree_gym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThreeVsThree_gym(user,gym,null,null,null,null,null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

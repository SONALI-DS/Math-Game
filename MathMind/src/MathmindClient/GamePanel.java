package MathmindClient ; //Package declaration

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Project.ConnectionProvider;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.Timer;

/**
 *
 * @author soni
 */
public class GamePanel extends javax.swing.JFrame {
    public String questionId="1";
    public String answer;
    public String email;
    public String username;
    public String playerId;
    public int min=0;
    public int sec=0;
    public int score=0;
   
    
    public void answerCheck()
    {
        String playerAnsewr="";
        if(jRadioButton1.isSelected())
        {
            playerAnsewr=jRadioButton1.getText();
            
        }
        
        else if (jRadioButton2.isSelected())
        {
            playerAnsewr=jRadioButton2.getText();
            
        }
        
        else if (jRadioButton3.isSelected())
        {
            playerAnsewr=jRadioButton3.getText();
            
        }
        
        else 
        {
            playerAnsewr=jRadioButton4.getText();
            
        }
        
        //match the player answer with DB and get the score
        
        if(playerAnsewr.equals(answer))
        {
            score=score+1;
            String score1=String.valueOf(score);
            jLabel11.setText(score1);
    }
        
        //change the quiz ID
        
        int questionId1=Integer.parseInt(questionId);
        questionId1=questionId1+1;
        questionId=String.valueOf(questionId1);
        
        //clear Selected buttons
        
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        jRadioButton3.setSelected(false);
        jRadioButton4.setSelected(false);
        
        //hide the next butten when player get the last question
        
        if(questionId.equals("10"))
        {
            jButton2.setVisible(false);
        
        }
    }
    
    
    public void player(){
                System.out.println("good");

        try{
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement(); 
            ResultSet rs=st.executeQuery("select *from player where playerId='"+playerId+"'");
            while(rs.next())
            {
              System.out.println("ok");
              jLabel000.setText(rs.getString(1));            
            }
            
        }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);

        }
    }
    
    
    
    public void question()
    {
        try
    {
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement(); 
        ResultSet rset=st.executeQuery("select *from question where id='"+questionId+"'");
        while(rset.next())
        {
            System.out.println("ok");
            
            jLabel8.setText(rset.getString(1));
            jLabel3.setText(rset.getString(2));
            jRadioButton1.setText(rset.getString(3));
            jRadioButton2.setText(rset.getString(4));
            jRadioButton3.setText(rset.getString(5));
            jRadioButton4.setText(rset.getString(6));
            answer=rset.getString(7);
            
       } 
    
        
 }
    catch(Exception e)
    
    {
            JOptionPane.showMessageDialog(null, e);
    }
        
    
    }
    public void submit()
    {
        String playerId=jLabel000.getText();
        answerCheck();
         
        try
        {
            Connection con=ConnectionProvider.getCon();
            Statement st=con.createStatement();
            st.executeUpdate("update player set score='"+score+"' where playerId='"+playerId+"'");
            String score1=String.valueOf(score);

            setVisible(false);
            new scoreBoard(score1).setVisible(true);
        
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        
        }
    
    }
    

    /**
     * Creates new form GamePanel
     */
    Timer time;
    public GamePanel() {
        initComponents();
    }
    
    public GamePanel(String playerId) {
        initComponents();
        
        
        
       jLabel000.setText(playerId);
    
//        player();


    
//1st quiz & player details
    try
    {
        Connection con=ConnectionProvider.getCon();
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select *from player where playerId='"+playerId+"'");
        while(rs.next())
        {

             jLabel9.setText(rs.getString(2));
            
        }
        
        
        ResultSet rset=st.executeQuery("select *from question where id='"+questionId+"'");
        while(rset.next())
        {
            
            jLabel8.setText(rset.getString(1));
            jLabel3.setText(rset.getString(2));
            jRadioButton1.setText(rset.getString(3));
            jRadioButton2.setText(rset.getString(4));
            jRadioButton3.setText(rset.getString(5));
            jRadioButton4.setText(rset.getString(6));
            answer=rset.getString(7);
            
    }
        
 }
    catch(Exception e)
    
    {
        JOptionPane.showMessageDialog(null, e);
    }
    
    //setting timer
    
        setLocationRelativeTo(this);
        time=new Timer(1000,new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae) {
               jLabel5.setText(String.valueOf(sec));
               jLabel4.setText(String.valueOf(min));
               
               if(sec==60)
               {
                   sec=0;
                   min++;
                   
                   if(min==1);
                {
                    time.stop();
                    answerCheck();
                    submit();
                }
                
                }
                  sec++;
                  
               }
            
        });
        
        time.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameBase = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel000 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        gameBase.setBackground(new java.awt.Color(255, 204, 102));
        gameBase.setForeground(new java.awt.Color(255, 204, 153));
        gameBase.setPreferredSize(new java.awt.Dimension(790, 440));
        gameBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButton2.setBackground(new java.awt.Color(255, 204, 102));
        jRadioButton2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jRadioButton2.setText("2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        gameBase.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 80, -1));

        jRadioButton3.setBackground(new java.awt.Color(255, 204, 102));
        jRadioButton3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jRadioButton3.setText("4");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        gameBase.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 320, 80, -1));

        jRadioButton4.setBackground(new java.awt.Color(255, 204, 102));
        jRadioButton4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jRadioButton4.setText("0");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        gameBase.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 80, -1));

        jButton1.setBackground(new java.awt.Color(255, 204, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-save-25 (1).png"))); // NOI18N
        jButton1.setText("SUBMIT ");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton1.setMaximumSize(new java.awt.Dimension(35, 21));
        jButton1.setMinimumSize(new java.awt.Dimension(35, 21));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gameBase.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, 110, 32));

        jButton2.setBackground(new java.awt.Color(255, 204, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-arrow-25.png"))); // NOI18N
        jButton2.setText("NEXT");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gameBase.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 110, 32));

        jButton3.setBackground(new java.awt.Color(255, 204, 102));
        jButton3.setForeground(new java.awt.Color(255, 204, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-exit-18.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gameBase.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 30, 30));

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel3.setText("question");
        gameBase.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 440, 150));

        jPanel1.setBackground(new java.awt.Color(249, 219, 158));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 5));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/doll.1.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("soni");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("UserName              :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Question Number :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("00");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("00");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Score                       :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("00");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("00");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Time:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Player ID                :");

        jLabel000.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel000.setText("000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel10))
                                .addGap(38, 38, 38))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(39, 39, 39)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(jLabel000))
                        .addGap(39, 39, 39))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel000))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        gameBase.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 440));

        jRadioButton1.setBackground(new java.awt.Color(255, 204, 102));
        jRadioButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jRadioButton1.setText("1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        gameBase.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 320, 80, -1));

        jLabel12.setFont(new java.awt.Font("Showcard Gothic", 0, 40)); // NOI18N
        jLabel12.setText("MATH MIND");
        gameBase.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(gameBase, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gameBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

          JFrame jf= new JFrame();
        int a=JOptionPane.showConfirmDialog(jf,"Do you really want to Exit?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            setVisible(false);
            new GameHome().setVisible(true);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        answerCheck();
        question();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int a=JOptionPane.showConfirmDialog(null, "Do you want to submit?","Select",JOptionPane.YES_NO_OPTION);
        if(a==0)
        {
            answerCheck();
            submit();
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        
        if(jRadioButton4.isSelected())
        {
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        
        if(jRadioButton3.isSelected())
        {
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);
            jRadioButton4.setSelected(false);
            
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        
        if(jRadioButton2.isSelected())
        {
            jRadioButton1.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton4.setSelected(false);
            
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        
        if(jRadioButton1.isSelected())
        {
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            jRadioButton4.setSelected(false);
            
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GamePanel().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gameBase;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel000;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanminimizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author LOLU
 */
public class AppInterface extends javax.swing.JFrame {
    /**
     * Creates new form AppInterface
     */
    ArrayList<Integer> canonicalTerms = new ArrayList<>();
    ArrayList<Integer> dontCares = new ArrayList<>();
    boolean isMaxTerms = false;
    boolean isPOS = false;
    public ArrayList<String> variables = new ArrayList<>();
    
    public AppInterface() {
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

        labelVariables = new javax.swing.JLabel();
        editVariables = new javax.swing.JTextField();
        radioMaxterms = new javax.swing.JRadioButton();
        labelTerms = new javax.swing.JLabel();
        editTerms = new javax.swing.JTextField();
        labelDC = new javax.swing.JLabel();
        editDC = new javax.swing.JTextField();
        btnRandom = new javax.swing.JButton();
        radioPOS = new javax.swing.JRadioButton();
        btnMinimize = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textResult = new javax.swing.JTextArea();
        btnClose = new javax.swing.JButton();
        editNumOfLiterals = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelVariables.setText("Enter Variables");

        radioMaxterms.setText("MaxTerms");
        radioMaxterms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioMaxtermsActionPerformed(evt);
            }
        });

        labelTerms.setText("Enter Terms");

        editTerms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTermsActionPerformed(evt);
            }
        });

        labelDC.setText("Enter Don't Cares");

        btnRandom.setText("Random");
        btnRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandomActionPerformed(evt);
            }
        });

        radioPOS.setText("Product of Sums");

        btnMinimize.setText("Minimize");
        btnMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizeActionPerformed(evt);
            }
        });

        textResult.setColumns(20);
        textResult.setLineWrap(true);
        textResult.setRows(5);
        jScrollPane2.setViewportView(textResult);

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        editNumOfLiterals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editNumOfLiteralsActionPerformed(evt);
            }
        });

        jLabel1.setText("Complexity(Number of Literals)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelTerms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelDC, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editDC))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(radioMaxterms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(labelVariables, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(editVariables, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(editTerms)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioPOS)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRandom, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editNumOfLiterals, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(btnClose)))
                        .addGap(5, 5, 5))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVariables, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editVariables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioMaxterms)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTerms)
                    .addComponent(editTerms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRandom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDC)
                    .addComponent(editDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioPOS)
                    .addComponent(btnMinimize))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(editNumOfLiterals)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioMaxtermsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioMaxtermsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioMaxtermsActionPerformed

    private void btnMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizeActionPerformed
        textResult.setText("");
        isMaxTerms = radioMaxterms.isSelected();
        isPOS = radioPOS.isSelected();  
        getDontCares();
        String result = "";
        if(getTerms() && getVariables()){
            BooleanMinimizer m = new BooleanMinimizer(numberOfVariables(), canonicalTerms
                    , dontCares, isMaxTerms, isPOS,variables);
            result = m.minimize();
            textResult.setText(result);
            
        }
        int numOfLiterals = result.length();
        editNumOfLiterals.setText(String.valueOf(BooleanMinimizer.numOfLiterals));
        
    }//GEN-LAST:event_btnMinimizeActionPerformed

    private void editTermsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTermsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editTermsActionPerformed

    private void btnRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandomActionPerformed
           Set<Integer> randomTerms = new HashSet<>();
           Set<Integer> randomDontCares = new HashSet<>();
           List<Integer> sortedTerms;
           List<Integer> sortedDontCares;
           Random random = new Random();
           randomTerms.clear();
           int max_num = random.nextInt((int)Math.pow(2, numberOfVariables()));
           for (int i = 0; i < max_num; i++){
               randomTerms.add(random.nextInt((int)Math.pow(2, numberOfVariables())));
           }
           
           int numOfDontCares = random.nextInt((int)Math.pow(2, numberOfVariables()));
           for(int i = 0; i < numOfDontCares; i++){
               int j = random.nextInt((int)Math.pow(2, numberOfVariables()));
               if (!randomTerms.contains(j)){
                   randomDontCares.add(j);
               }
           }
   
           sortedTerms = new ArrayList<>(randomTerms);
           Collections.sort(sortedTerms);
           sortedDontCares = new ArrayList<>(randomDontCares);
           Collections.sort(sortedDontCares);
           
           String resultTerms = "";
           if (!(sortedTerms.size() < 1)){
               for(int i = 0; i < sortedTerms.size()-1; i++){
                    resultTerms += String.valueOf(sortedTerms.get(i)) + ",";
               }
               resultTerms += sortedTerms.get(sortedTerms.size()-1);
           }
           
           String resultDontCares = "";
           if (!(sortedDontCares.size() < 1)){
               for(int i = 0; i < sortedDontCares.size()-1; i++){
                    resultDontCares += String.valueOf(sortedDontCares.get(i)) + ",";
               }
               resultDontCares += sortedDontCares.get(sortedDontCares.size()-1);
           }
           
           
           editTerms.setText(resultTerms);
           editDC.setText(resultDontCares);
           
    }//GEN-LAST:event_btnRandomActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void editNumOfLiteralsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editNumOfLiteralsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editNumOfLiteralsActionPerformed
    public int numberOfVariables(){
        String numOfVars = editVariables.getText();
        String[] temp = numOfVars.split(",");
        
        return temp.length;
        
    }
    private boolean getTerms(){
        String terms = editTerms.getText();
        String[] temp = terms.split(",");
        canonicalTerms.clear();
        if (!terms.equals("")){
            for (String s : temp){
                if ((Integer.parseInt(s) > (Math.pow(2, numberOfVariables())-1)) && numberOfVariables() > 1){
                    JOptionPane.showMessageDialog(this, "Invalid term greater than 2^" + numberOfVariables());
                    return false;
                }else{
                    canonicalTerms.add(Integer.parseInt(s));
                }
                
            }  
        }
        else{
            JOptionPane.showMessageDialog(this, "Enter the list of canonical terms");
            return false;
        }
        return true;
          
    }
    private void getDontCares(){
        String dcterms = editDC.getText();
        String[] temp = dcterms.split(",");
        dontCares.clear();
        if (!dcterms.equals("")){
            for (String s : temp){
                dontCares.add(Integer.parseInt(s));
            }
        }    
    }
    public boolean getVariables(){
        String vars = editVariables.getText();
        String[] temp = vars.split(",");
        variables.clear();
        if (!vars.equals("")){
           for (String s : temp){
                variables.add(s);
            } 
        }
        else{
            JOptionPane.showMessageDialog(this, "Enter Variables");
            return false;
        }
        return true;
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
            java.util.logging.Logger.getLogger(AppInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AppInterface a = new AppInterface();
                a.setTitle("Quine McCluskey Minimizer");
                a.setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnMinimize;
    private javax.swing.JButton btnRandom;
    private javax.swing.JTextField editDC;
    private javax.swing.JTextField editNumOfLiterals;
    private javax.swing.JTextField editTerms;
    private javax.swing.JTextField editVariables;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDC;
    private javax.swing.JLabel labelTerms;
    private javax.swing.JLabel labelVariables;
    private javax.swing.JRadioButton radioMaxterms;
    private javax.swing.JRadioButton radioPOS;
    private javax.swing.JTextArea textResult;
    // End of variables declaration//GEN-END:variables
}

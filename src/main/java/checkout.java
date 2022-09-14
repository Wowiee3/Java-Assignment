
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author wowiee
 */
public class checkout extends javax.swing.JFrame {
String cartfile = "/home/wowiee/Desktop/School/Sem 5/java/JavaAssignment/src/main/java/cart.txt";
    /**
     * Creates new form checkout
     */
    public checkout() throws IOException {
        initComponents();
        // Loading items from the txt file
        File file = new File(cartfile);
        String firstline = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            firstline = br.readLine().trim();
            DefaultTableModel model = (DefaultTableModel)shoppingcart.getModel();
            Object[] tableLines = br.lines().toArray();
            
            // adding lines from txt file to the table
            for (Object tableLine : tableLines) {
                String line = tableLine.toString().trim();
                String[] row = line.split("/");
                model.addRow(row);
            }
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(manageitems.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        subtotal.setText(firstline);
        int pricetotal = Integer.parseInt(firstline.replaceAll("[^0-9]", ""))+ 4;
        total.setText("Total price: $" + pricetotal);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        shoppingcart = new javax.swing.JTable();
        subtotal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cash = new javax.swing.JTextField();
        payment = new javax.swing.JButton();
        change = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel.setFont(new java.awt.Font("Tahoma", 3, 28)); // NOI18N
        jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel.setText("Thank you for shopping with us!");

        total.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        total.setText("Total price:");

        shoppingcart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Price", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(shoppingcart);

        subtotal.setFont(new java.awt.Font("sansserif", 0, 15)); // NOI18N
        subtotal.setText("Item subtotal:");

        jLabel1.setText("Online fee: $1");

        jLabel2.setText("Service tax: $3");

        payment.setText("Pay");
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });

        change.setText("Change:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(subtotal)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(payment))
                            .addComponent(change))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(subtotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cash, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(payment, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(change)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        int paid = Integer.parseInt(cash.getText());
        int pricetotal = Integer.parseInt(total.getText().replaceAll("[^0-9]", ""));
        int extra = paid - pricetotal;
        if (extra < 0) {
            JOptionPane.showMessageDialog(null, "Please enter an amount more than or equal to the total price!");
        }
        else {
            change.setText("Change: $" + extra);
        }
    }//GEN-LAST:event_paymentActionPerformed

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
            java.util.logging.Logger.getLogger(checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new checkout().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(checkout.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cash;
    private javax.swing.JLabel change;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton payment;
    private javax.swing.JTable shoppingcart;
    private javax.swing.JLabel subtotal;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
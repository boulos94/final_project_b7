/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses;

import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.JFrame;

public class courses_option extends javax.swing.JDialog {

     private Connection con;
    private int crsid;
    
    public courses_option(java.awt.Frame parent, boolean modal, Connection con, int crsid) {
        super(parent, modal);
        initComponents();
        this.setTitle("Course");
        this.setLocationRelativeTo(this);
        this.con = con;
        this.crsid = crsid;
        populate();
    }

    

    
    private void populate() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs
                    = stmt.executeQuery("Select * "
                            + "From tbl_course Where crs_id =" + crsid);
            if (rs.next()) {
                txtCourseCode.setText(rs.getString("crs_code"));
                txtCourseName.setText(rs.getString("crs_name"));
                txtDescription.setText(rs.getString("crs_descriptiom"));
                cbxType.setSelectedItem(rs.getString("crs_type"));
                cbxNumberOfCredits.setSelectedItem(rs.getString("crs_numberOfCredits"));
                if(rs.getString("crs_lab").equals("Yes")){
                    chkLab.setSelected(true);
                }else{
                    chkLab.setSelected(false);
                }
                
               
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtCourseCode = new javax.swing.JTextField();
        txtCourseName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbxType = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbxNumberOfCredits = new javax.swing.JComboBox();
        chkLab = new javax.swing.JCheckBox();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("course code :");

        jLabel2.setText("course name :");

        jLabel3.setText("description :");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        txtDescription.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescriptionKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescription);

        txtCourseCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCourseCodeActionPerformed(evt);
            }
        });
        txtCourseCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCourseCodeKeyTyped(evt);
            }
        });

        txtCourseName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCourseNameKeyTyped(evt);
            }
        });

        jLabel4.setText("type :");

        cbxType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "major", "electibe" }));

        jLabel5.setText("number of credits :");

        cbxNumberOfCredits.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3", "2", "1" }));

        chkLab.setText("lab");

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCourseCode))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxNumberOfCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCourseName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkLab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCourseCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxNumberOfCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkLab)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCourseCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseCodeActionPerformed
    
        
    }//GEN-LAST:event_txtCourseCodeActionPerformed

    private void txtCourseCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCourseCodeKeyTyped
     if ((!Character.isDigit(evt.getKeyChar())|| txtCourseCode.getText().length() > 5)
             &&(Character.isDigit(evt.getKeyChar())|| txtCourseCode.getText().length() > 5)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCourseCodeKeyTyped

    private void txtCourseNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCourseNameKeyTyped
      if ((!Character.isDigit(evt.getKeyChar())|| txtCourseName.getText().length() > 29)
            &&(Character.isDigit(evt.getKeyChar())|| txtCourseName.getText().length() > 29)  ) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCourseNameKeyTyped

    private void txtDescriptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescriptionKeyTyped
     if ((!Character.isDigit(evt.getKeyChar())|| txtDescription.getText().length() > 249)
          &&(Character.isDigit(evt.getKeyChar())|| txtDescription.getText().length() > 249)   ) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescriptionKeyTyped

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    if (txtCourseCode.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Enter a course code", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } else if (txtCourseName.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Enter a course name", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            String courseCode = txtCourseCode.getText();
            String courseName = txtCourseName.getText();
            String description = txtDescription.getText();
            String type= cbxType.getSelectedItem().toString();
            int numberOfCredits= Integer.parseInt(cbxNumberOfCredits.getSelectedItem().toString());
            String lab;
            if (chkLab.isSelected()) {
                lab = "Yes";
            } else {
                lab = "No";
            }
            
            try {
                PreparedStatement pstmt;
                if(crsid==0){
                       pstmt = con.prepareStatement("Insert Into "
                                + "tbl_course (crs_code,"
                                + "crs_name, crs_descriptiom, "
                                + "crs_type, crs_numberOfCredits, "
                                + "crs_lab) "
                                + "Values ( '" + courseCode + "', "
                                + "'" + courseName + "', '" + description+ "', '"
                                + type + "', " + numberOfCredits + ", '"
                                + lab + "')");
                }else{
                    pstmt = con.prepareStatement("Update tbl_course "
                            + "Set crs_code = '" + courseCode + "', "
                            + "crs_name = '" + courseName + "', "
                            + "crs_descriptiom = '" + description + "', "
                            + "crs_type = '" + type + "', "
                            + "crs_numberOfCredits= " + numberOfCredits + ", "
                            + "crs_lab = '" + lab + "'" 
                            + "Where crs_id = " + crsid);
                }
                pstmt.execute();
                this.dispose();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(courses_option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(courses_option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(courses_option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(courses_option.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                courses_option dialog = new courses_option(new javax.swing.JFrame(), true,null,0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbxNumberOfCredits;
    private javax.swing.JComboBox cbxType;
    private javax.swing.JCheckBox chkLab;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCourseCode;
    private javax.swing.JTextField txtCourseName;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables
}

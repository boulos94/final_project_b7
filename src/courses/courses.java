/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses;

import java.sql.*;
import javax.swing.JOptionPane;

public class courses extends javax.swing.JFrame {

   public Connection con;
   
    public courses() {
        initComponents();
        this.setTitle("LCU Courses");
        this.setLocationRelativeTo(this);
        tblCourses.getColumnModel().getColumn(0).setMinWidth(0);
        tblCourses.getColumnModel().getColumn(0).setMaxWidth(0);
        getConnection();
    }

    private void getConnection() {
        try {
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/course";
            String USERNAME = "root";
            String PASSWORD = "mysql";
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        coursePUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("coursePU").createEntityManager();
        tblCourseQuery = java.beans.Beans.isDesignTime() ? null : coursePUEntityManager.createQuery("SELECT t FROM TblCourse t");
        tblCourseList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : tblCourseQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCourses = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblCourseList, tblCourses);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${crsId}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${crsCode}"));
        columnBinding.setColumnName("Code");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${crsName}"));
        columnBinding.setColumnName("Name");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${crsDescriptiom}"));
        columnBinding.setColumnName("Descriptiom");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${crsType}"));
        columnBinding.setColumnName("Type");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${crsnumberOfCredits}"));
        columnBinding.setColumnName("number Of Credits");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${crsLab}"));
        columnBinding.setColumnName("Lab");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(tblCourses);

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnModify.setText("MODIFY");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnModify)
                    .addComponent(btnDelete)))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
     int selectedRow = tblCourses.getSelectedRow();
        if (selectedRow > -1) {
            int crsid = Integer.parseInt(tblCourses.getValueAt(selectedRow, 0).toString());
            try {
                Statement stmt = con.createStatement();
                stmt.execute("Delete From tbl_course Where crs_id =" + crsid);
                refreshTable();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a record to delete",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
       courses_option newCourses_option = new courses_option(this, true, con, 0);
        newCourses_option.setVisible(true);
        refreshTable();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
     int selectedRow = tblCourses.getSelectedRow();
        if (selectedRow > -1) {
            int crsid = Integer.parseInt(tblCourses.getValueAt(selectedRow, 0).toString());
            courses_option newCourses_option = new courses_option(this, true, con, crsid);
            newCourses_option.setVisible(true);
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Select a record to modify",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModifyActionPerformed

     private void refreshTable() {
        coursePUEntityManager.getTransaction().begin();
        java.util.Collection data = tblCourseQuery.getResultList();
        for (Object entity : data) {
            coursePUEntityManager.refresh(entity);
        }
        tblCourseList.clear();
        tblCourseList.addAll(data);
        coursePUEntityManager.getTransaction().commit();
        bindingGroup.unbind();
        bindingGroup.bind();
        tblCourses.getColumnModel().getColumn(0).setMinWidth(0);
        tblCourses.getColumnModel().getColumn(0).setMaxWidth(0);
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
            java.util.logging.Logger.getLogger(courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(courses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new courses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnModify;
    private javax.persistence.EntityManager coursePUEntityManager;
    private javax.swing.JScrollPane jScrollPane1;
    private java.util.List<courses.TblCourse> tblCourseList;
    private javax.persistence.Query tblCourseQuery;
    private javax.swing.JTable tblCourses;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private static class TblCourse {

        public TblCourse() {
        }
    }
}

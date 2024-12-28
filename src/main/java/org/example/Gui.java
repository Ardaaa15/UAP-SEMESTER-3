package org.example;
import javax.swing.JOptionPane;

import static java.lang.Integer.*;

public class Gui extends javax.swing.JFrame {

    public PengunjungController pc = new PengunjungController();
    private boolean tag = true;

    public Gui() {
        initComponents();
        read();
    }

    private void clear() {
        tag = true;
        tfno.setText("");
        tfno.setEnabled(true);
        tfnama.setText("");
        buttonGroup1.clearSelection();
        cbtujuan.setSelectedIndex(0);
        read();
    }

    private void read() {
        pc.read(tblpengunjung);
    }

    boolean validation() {
        if (tfno.getText().isEmpty() ||
                tfnama.getText().isEmpty() ||
                !isKendaraanSelected() ||
                cbtujuan.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    private boolean isKendaraanSelected() {
        return rbmotor.isSelected() || rbmobil.isSelected() || rbother.isSelected();
    }

    private void save() {
        if (validation()) {
            try {
                Integer nomor = valueOf(tfno.getText());
                createOrUpdate(nomor);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "Nomor Pengunjung harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Isi Dulu Datanya !!!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
        clear();
    }


    void createOrUpdate(int nomor) {
        if (isValidName(tfnama.getText())) {
            Pengunjung p = new Pengunjung();
            p.setNomer(nomor);
            p.setNama(tfnama.getText());
            p.setKendaraan(getSelectedKendaraan());
            p.setTujuan(cbtujuan.getSelectedItem().toString());

            if (tag) {
                pc.create(p);
            } else {
                pc.update(p);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nama Pengunjung hanya boleh mengandung huruf!");
        }
    }

    public String getSelectedKendaraan() {
        if (rbmotor.isSelected()) {
            return rbmotor.getText();
        } else if (rbmobil.isSelected()) {
            return rbmobil.getText();
        } else {
            return rbother.getText();
        }
    }

    public boolean isValidName(String name) {
        return name.matches("[A-Za-z ]+");
    }

    private void loadData() {
        try {
            int count = tblpengunjung.getSelectedRowCount();
            if (count > 0) {
                int pilihan = JOptionPane.showConfirmDialog(rootPane, "Yakin Ingin Mengubah ??", "Informasi", JOptionPane.YES_NO_OPTION, 1);
                if (pilihan == JOptionPane.YES_OPTION) {
                    int row = tblpengunjung.getSelectedRow();
                    tfno.setText(tblpengunjung.getValueAt(row, 0).toString());
                    tfnama.setText(tblpengunjung.getValueAt(row, 1).toString());
                    setKendaraanSelection(tblpengunjung.getValueAt(row, 2).toString());
                    cbtujuan.setSelectedItem(tblpengunjung.getValueAt(row, 3).toString());
                    tag = false;
                    tfno.setEnabled(false);
                }
            } else {
                throw new Exception("Data belum dipilih!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void setKendaraanSelection(String kendaraan) {
        if (kendaraan.equals("Motor")) {
            rbmotor.setSelected(true);
        } else if (kendaraan.equals("Mobil")) {
            rbmobil.setSelected(true);
        } else {
            rbother.setSelected(true);
        }
    }

    private void delete() {
        try {
            int count = tblpengunjung.getSelectedRowCount();
            if (count > 0) {
                int pilihan = JOptionPane.showConfirmDialog(rootPane, "Yakin Ingin Menghapus !!", "Informasi", JOptionPane.YES_NO_OPTION, 1);
                if (pilihan == JOptionPane.YES_OPTION) {
                    int row = tblpengunjung.getSelectedRow();
                    pc.delete(valueOf(tblpengunjung.getValueAt(row, 0).toString()));
                    clear();
                }
            } else {
                throw new Exception("Data belum dipilih!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void search() {
        try {
            if (tfcari.getText().isEmpty()) {
                clear();
            } else {
                int nomor = valueOf(tfcari.getText()); // Kemungkinan NumberFormatException
                pc.search(tblpengunjung, nomor);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Nomor yang dicari harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbmotor = new javax.swing.JRadioButton();
        rbmobil = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblpengunjung = new javax.swing.JTable();
        rbother = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        cbtujuan = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfcari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(230, 230, 250));

        jPanel2.setBackground(new java.awt.Color(176, 196, 222));

        jLabel1.setBackground(new java.awt.Color(250, 240, 230));
        jLabel1.setFont(new java.awt.Font("Caviar Dreams", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Antrian Pengunjung Kebun Binatang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)
                                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel2.setText("No. Kunjungan");

        tfno.setFont(new java.awt.Font("Caviar Dreams", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel3.setText("Nama Pengunjung");

        tfnama.setFont(new java.awt.Font("Caviar Dreams", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel4.setText("Jenis Kendaraan");

        buttonGroup1.add(rbmotor);
        rbmotor.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        rbmotor.setText("Motor");

        buttonGroup1.add(rbmobil);
        rbmobil.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        rbmobil.setText("Mobil");
        rbmobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbmobilActionPerformed(evt);
            }
        });

        tblpengunjung.setFont(new java.awt.Font("Caviar Dreams", 0, 12)); // NOI18N
        tblpengunjung.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        tblpengunjung.setToolTipText("");
        jScrollPane1.setViewportView(tblpengunjung);

        buttonGroup1.add(rbother);
        rbother.setFont(new java.awt.Font("Caviar Dreams", 1, 12)); // NOI18N
        rbother.setText("Lain-Lain");

        jLabel5.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel5.setText("Tujuan");

        cbtujuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Tujuan--", "Jalan-Jalan", "Study Akademik", "bisnis", "Lain-Lain" }));
        cbtujuan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbtujuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtujuanActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 0));
        jButton1.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Caviar Dreams", 1, 14)); // NOI18N
        jLabel6.setText("Search");

        tfcari.setFont(new java.awt.Font("Caviar Dreams", 0, 12)); // NOI18N
        tfcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfcariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(557, 557, 557))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(180, 180, 180)
                                                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(cbtujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(tfno, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(56, 56, 56)
                                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(tfcari, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(tfnama, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(135, 135, 135)
                                                                .addComponent(rbmotor)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(rbmobil)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(rbother))))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(tfno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(tfcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6))))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(tfnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(rbmotor)
                                                .addComponent(rbmobil)
                                                .addComponent(rbother))
                                        .addComponent(jLabel4))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(cbtujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbmobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmobilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbmobilActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tfcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfcariKeyReleased
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_tfcariKeyReleased

    private void cbtujuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtujuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtujuanActionPerformed

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
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> cbtujuan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JRadioButton rbmobil;
    public javax.swing.JRadioButton rbmotor;
    public javax.swing.JRadioButton rbother;
    public javax.swing.JTable tblpengunjung;
    public javax.swing.JTextField tfcari;
    public javax.swing.JTextField tfnama;
    public javax.swing.JTextField tfno;
    // End of variables declaration//GEN-END:variables
}

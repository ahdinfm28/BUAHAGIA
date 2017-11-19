/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Farisya
 */
public class insupermarket extends javax.swing.JFrame {

    /**
     * Creates new form tokoku
     */
    public insupermarket() {
        initComponents();
        popup.setLocationRelativeTo(this);

    }

    public void klikBahan(ActionListener g, ActionListener mi, ActionListener ma,
            ActionListener me, ActionListener si, ActionListener su, ActionListener t,
            ActionListener tt, ActionListener tb, ActionListener p) {
        this.btngula.addActionListener(g);
        this.btnminyak.addActionListener(mi);
        this.btnmayo.addActionListener(ma);
        this.btnmentega.addActionListener(me);
        this.btnsirup.addActionListener(si);
        this.btnsusu.addActionListener(su);
        this.btntelur.addActionListener(t);
        this.btntepungt.addActionListener(tt);
        this.btntepungb.addActionListener(tb);
        this.btnpengembang.addActionListener(p);

    }

    public void setJmlBahan(int gula, int minyak, int mayo, int mentega, int sirup, int telur,
            int tepungt, int tepungb, int sp, int susu) {
        setjmlgula(gula);
        setjmlminyak(minyak);
        setjmltelur(telur);
        setjmlsusu(susu);
        setjmlsirup(sirup);
        setjmlpengembang(sp);
        setjmlmentega(mentega);
        setjmlmayo(mayo);
        setjmltepungt(tepungt);
        setjmltepungb(tepungb);
    }

    public int setjmlgula(int text) {
        this.jmlgula.setText(text + "");
        return text;
    }

    public int setjmlmayo(int text) {
        this.jmlmayo.setText(text + "");
        return text;
    }

    public int setjmlmentega(int text) {
        this.jmlmentega.setText(text + "");
        return text;
    }

    public int setjmlminyak(int text) {
        this.jmlminyak.setText(text + "");
        return text;
    }

    public int setjmlsirup(int text) {
        this.jmlsirup.setText(text + "");
        return text;
    }

    public int setjmlsusu(int text) {
        this.jmlsusu.setText(text + "");
        return text;
    }

    public int setjmltelur(int text) {
        this.jmltelur.setText(text + "");
        return text;
    }

    public int setjmltepungt(int text) {
        this.jmltepung2.setText(text + "");
        return text;
    }

    public int setjmltepungb(int text) {
        this.jmltepung.setText(text + "");
        return text;
    }

    public int setjmlpengembang(int text) {
        this.jmlpengembang.setText(text + "");
        return text;
    }

    public int setUang(int jmluang) {
        this.uang.setText(jmluang + "");
        return jmluang;
    }

    public String getjmlminyak() {
        return jmlminyak.getText();
    }

    public String getjmlmayo() {
        return jmlmayo.getText();
    }

    public String getjmltepungt() {
        return jmltepung2.getText();
    }

    public String getjmltepungb() {
        return jmltepung.getText();
    }

    public String getjmlpengembang() {
        return jmlpengembang.getText();
    }

    public String getjmlsusu() {
        return jmlsusu.getText();
    }

    public String getjmlgula() {
        return jmlgula.getText();
    }

    public String getjmlmentega() {
        return jmlmentega.getText();
    }

    public String getjmlsirup() {
        return jmlminyak.getText();
    }

    public String getjmltelur() {
        return jmltelur.getText();
    }

    public void back(ActionListener a) {
        this.back.addActionListener(a);
    }

    // POP UP
    public JLabel setGambar() {
        return bahan;
    }

    public void tombolTambah(ActionListener action) {
        this.add.addActionListener(action);
    }

    public void tombolMin(ActionListener action) {
        this.min.addActionListener(action);
    }

    public void tombolBeli(ActionListener action) {
        this.beli.addActionListener(action);
    }

    public void tombolBatal(ActionListener action) {
        this.batal.addActionListener(action);
    }

    public int getTeksJumlah() {
        String hasil = tf_jml.getText();
        return Integer.valueOf(hasil);
    }

    public void setTeksJumlah(String jml) {
        tf_jml.setText(jml);
    }

    public JFrame popup() {
        return popup;
    }

    public JButton beliButton() {
        return beli;
    }

    public JButton cancelButton() {
        return batal;
    }

    public void tampilPesan(String pesan) {
        JOptionPane.showMessageDialog(this, pesan);
    }
    public void tampilPesan2(String pesan) {
        JOptionPane.showMessageDialog(popup, pesan);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new javax.swing.JFrame();
        add = new javax.swing.JButton();
        min = new javax.swing.JButton();
        beli = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        bahan = new javax.swing.JLabel();
        tf_jml = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        uang = new javax.swing.JLabel();
        jmlmayo = new javax.swing.JLabel();
        jmlsirup = new javax.swing.JLabel();
        jmlminyak = new javax.swing.JLabel();
        jmlpengembang = new javax.swing.JLabel();
        jmlmentega = new javax.swing.JLabel();
        jmltelur = new javax.swing.JLabel();
        jmlsusu = new javax.swing.JLabel();
        jmlgula = new javax.swing.JLabel();
        jmltepung = new javax.swing.JLabel();
        btnmentega = new javax.swing.JButton();
        btnpengembang = new javax.swing.JButton();
        btntelur = new javax.swing.JButton();
        btnsusu = new javax.swing.JButton();
        btnminyak = new javax.swing.JButton();
        btnsirup = new javax.swing.JButton();
        btngula = new javax.swing.JButton();
        btntepungb = new javax.swing.JButton();
        btnmayo = new javax.swing.JButton();
        back = new javax.swing.JButton();
        btntepungt = new javax.swing.JButton();
        jmltepung2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        popup.setUndecorated(true);
        popup.setSize(new java.awt.Dimension(550, 610));
        popup.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add.setBorder(null);
        add.setBorderPainted(false);
        add.setContentAreaFilled(false);
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        popup.getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 293, 60, 70));

        min.setBorder(null);
        min.setBorderPainted(false);
        min.setContentAreaFilled(false);
        min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        popup.getContentPane().add(min, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 70, 60));

        beli.setBorder(null);
        beli.setBorderPainted(false);
        beli.setContentAreaFilled(false);
        beli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        popup.getContentPane().add(beli, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 500, 160, 70));

        batal.setBorder(null);
        batal.setBorderPainted(false);
        batal.setContentAreaFilled(false);
        batal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        popup.getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 503, 150, 70));

        bahan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/tepung.png"))); // NOI18N
        bahan.setText("jLabel4");
        popup.getContentPane().add(bahan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 70, 90));

        tf_jml.setBackground(new java.awt.Color(255, 255, 153));
        tf_jml.setFont(new java.awt.Font("DFPOP1-W9", 0, 30)); // NOI18N
        tf_jml.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_jml.setText("1");
        tf_jml.setBorder(null);
        popup.getContentPane().add(tf_jml, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 230, 90));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/popupsupermarket.png"))); // NOI18N
        popup.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 610));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        uang.setFont(new java.awt.Font("DFPOP1-W9", 0, 24)); // NOI18N
        uang.setText("100000");
        getContentPane().add(uang, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 120, 40));

        jmlmayo.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        jmlmayo.setText("0");
        getContentPane().add(jmlmayo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 240, 40, 40));

        jmlsirup.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        jmlsirup.setText("0");
        getContentPane().add(jmlsirup, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 304, 40, 50));

        jmlminyak.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        jmlminyak.setText("0");
        getContentPane().add(jmlminyak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 380, 40, 30));

        jmlpengembang.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        jmlpengembang.setText("0");
        getContentPane().add(jmlpengembang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 440, 40, 50));

        jmlmentega.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        jmlmentega.setText("0");
        getContentPane().add(jmlmentega, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 520, 40, 40));

        jmltelur.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        jmltelur.setText("0");
        getContentPane().add(jmltelur, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 450, 30, 40));

        jmlsusu.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        jmlsusu.setText("0");
        getContentPane().add(jmlsusu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 380, 40, 40));

        jmlgula.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        jmlgula.setText("0");
        getContentPane().add(jmlgula, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 310, 40, 30));

        jmltepung.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        jmltepung.setText("0");
        getContentPane().add(jmltepung, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 240, 40, 40));

        btnmentega.setBorder(null);
        btnmentega.setBorderPainted(false);
        btnmentega.setContentAreaFilled(false);
        btnmentega.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnmentega, new org.netbeans.lib.awtextra.AbsoluteConstraints(903, 193, 150, 150));

        btnpengembang.setBorder(null);
        btnpengembang.setBorderPainted(false);
        btnpengembang.setContentAreaFilled(false);
        btnpengembang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnpengembang, new org.netbeans.lib.awtextra.AbsoluteConstraints(713, 403, 150, 150));

        btntelur.setBorder(null);
        btntelur.setBorderPainted(false);
        btntelur.setContentAreaFilled(false);
        btntelur.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btntelur, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 193, 160, 150));

        btnsusu.setBorder(null);
        btnsusu.setBorderPainted(false);
        btnsusu.setContentAreaFilled(false);
        btnsusu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsusu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsusuActionPerformed(evt);
            }
        });
        getContentPane().add(btnsusu, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 193, 160, 150));

        btnminyak.setBorder(null);
        btnminyak.setBorderPainted(false);
        btnminyak.setContentAreaFilled(false);
        btnminyak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnminyak, new org.netbeans.lib.awtextra.AbsoluteConstraints(513, 403, 150, 150));

        btnsirup.setBorder(null);
        btnsirup.setContentAreaFilled(false);
        btnsirup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnsirup, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 403, 160, 150));

        btngula.setBorder(null);
        btngula.setBorderPainted(false);
        btngula.setContentAreaFilled(false);
        btngula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btngula, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 193, 160, 150));

        btntepungb.setBorder(null);
        btntepungb.setContentAreaFilled(false);
        btntepungb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btntepungb, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 160, 150));

        btnmayo.setBorder(null);
        btnmayo.setBorderPainted(false);
        btnmayo.setContentAreaFilled(false);
        btnmayo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnmayo, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 403, 150, 150));

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/back.png"))); // NOI18N
        back.setBorder(null);
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 140, 100));

        btntepungt.setBorder(null);
        btntepungt.setBorderPainted(false);
        btntepungt.setContentAreaFilled(false);
        btntepungt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btntepungt, new org.netbeans.lib.awtextra.AbsoluteConstraints(903, 403, 160, 150));

        jmltepung2.setFont(new java.awt.Font("DFPOP1-W9", 0, 14)); // NOI18N
        jmltepung2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jmltepung2.setText("0");
        jmltepung2.setToolTipText("");
        getContentPane().add(jmltepung2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 520, 40, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/insupermarket.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsusuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsusuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsusuActionPerformed

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        ImageIcon awal = new ImageIcon(getClass().getResource("/ui export/backhover.png"));
        back.setIcon(awal);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        ImageIcon awal = new ImageIcon(getClass().getResource("/ui export/back.png"));
        back.setIcon(awal);         // TODO add your handling code here:
    }//GEN-LAST:event_backMouseExited

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
            java.util.logging.Logger.getLogger(insupermarket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(insupermarket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(insupermarket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(insupermarket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new insupermarket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JLabel bahan;
    private javax.swing.JButton batal;
    private javax.swing.JButton beli;
    private javax.swing.JButton btngula;
    private javax.swing.JButton btnmayo;
    private javax.swing.JButton btnmentega;
    private javax.swing.JButton btnminyak;
    private javax.swing.JButton btnpengembang;
    private javax.swing.JButton btnsirup;
    private javax.swing.JButton btnsusu;
    private javax.swing.JButton btntelur;
    private javax.swing.JButton btntepungb;
    private javax.swing.JButton btntepungt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jmlgula;
    private javax.swing.JLabel jmlmayo;
    private javax.swing.JLabel jmlmentega;
    private javax.swing.JLabel jmlminyak;
    private javax.swing.JLabel jmlpengembang;
    private javax.swing.JLabel jmlsirup;
    private javax.swing.JLabel jmlsusu;
    private javax.swing.JLabel jmltelur;
    private javax.swing.JLabel jmltepung;
    private javax.swing.JLabel jmltepung2;
    public javax.swing.JButton min;
    private javax.swing.JFrame popup;
    private javax.swing.JTextField tf_jml;
    public javax.swing.JLabel uang;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;

import java.awt.Component;
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
public class inkedaibuah2 extends javax.swing.JFrame {

    /**
     * Creates new form inkedaibuah2
     */
    public inkedaibuah2() {
        initComponents();
        popup.setLocationRelativeTo(this);
    }

    public int setUang(int text) {
        this.uang.setText(text + "");
        return text;
    }

    public void setJmlBuah(int mangga, int semangka, int melon, int apel, int pisang) {
        setJmlMangga(mangga);
        setJmlApel(apel);
        setJmlPisang(pisang);
        setJmlSemangka(semangka);
        setJmlMelon(melon);
    }

    public int setJmlMangga(int text) {
        this.jmlmangga.setText(text + "");
        return text;
    }

    public int setJmlSemangka(int text) {
        this.jmlsemangka.setText(text + "");
        return text;
    }

    public int setJmlMelon(int text) {
        this.jmlmelon.setText(text + "");
        return text;
    }

    public int setJmlPisang(int text) {
        this.jmlpisang.setText(text + "");
        return text;
    }

    public int setJmlApel(int text) {
        this.jmlapel.setText(text + "");
        return text;
    }

    public void btnMelon(ActionListener a) {
        this.btnmelon.addActionListener(a);
    }

    public void btnMangga(ActionListener a) {
        this.btnmangga.addActionListener(a);
    }

    public void btnSemangka(ActionListener a) {
        this.btnsemangka.addActionListener(a);
    }

    public void btnPisang(ActionListener a) {
        this.btnpisang.addActionListener(a);
    }

    public void btnApel(ActionListener a) {
        this.btnapel.addActionListener(a);
    }

    public void klikKembali(ActionListener a) {
        this.back.addActionListener(a);
    }

    // POP UP
    public JLabel setGambar() {
        return gambarbuah;
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

    public void tombolKanan(ActionListener action) {
        this.rightbutton.addActionListener(action);
    }

    public void tombolKiri(ActionListener action) {
        this.leftbutton.addActionListener(action);
    }

    public int getTeksJumlah() {
        String hasil = jml.getText();
        return Integer.valueOf(hasil);
    }

    public int getTeksHarga() {
        String hasil = labelharga.getText();
        return Integer.valueOf(hasil);
    }

    public String getTeksKualitas() {
        return labelkualitas.getText();
    }

    public void setTeksJumlah(String teks) {
        jml.setText(teks);
    }

    public void setTeksHarga(String teks) {
        labelharga.setText(teks);
    }

    public void setTeksKualitas(String teks) {
        labelkualitas.setText(teks);
    }

    public JButton beliButton() {
        return beli;
    }

    public JFrame popup() {
        return popup;
    }

    public JButton cancelButton() {
        return batal;
    }

    public void tampilPesan(Component a, String pesan) {
        JOptionPane.showMessageDialog(a, pesan);
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
        batal = new javax.swing.JButton();
        beli = new javax.swing.JButton();
        add = new javax.swing.JButton();
        min = new javax.swing.JButton();
        labelharga = new javax.swing.JLabel();
        gambarbuah = new javax.swing.JLabel();
        leftbutton = new javax.swing.JButton();
        rightbutton = new javax.swing.JButton();
        labelkualitas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jml = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        uang = new javax.swing.JLabel();
        btnapel = new javax.swing.JButton();
        btnpisang = new javax.swing.JButton();
        btnmangga = new javax.swing.JButton();
        btnmelon = new javax.swing.JButton();
        btnsemangka = new javax.swing.JButton();
        jmlmangga = new javax.swing.JLabel();
        jmlsemangka = new javax.swing.JLabel();
        jmlapel = new javax.swing.JLabel();
        jmlmelon = new javax.swing.JLabel();
        jmlpisang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        popup.setUndecorated(true);
        popup.setSize(new java.awt.Dimension(526, 627));
        popup.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        batal.setBorder(null);
        batal.setBorderPainted(false);
        batal.setContentAreaFilled(false);
        batal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        popup.getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 493, 150, 70));

        beli.setBorder(null);
        beli.setBorderPainted(false);
        beli.setContentAreaFilled(false);
        beli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        popup.getContentPane().add(beli, new org.netbeans.lib.awtextra.AbsoluteConstraints(323, 493, 150, 70));

        add.setBorder(null);
        add.setBorderPainted(false);
        add.setContentAreaFilled(false);
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        popup.getContentPane().add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 323, 70, 60));

        min.setBorder(null);
        min.setBorderPainted(false);
        min.setContentAreaFilled(false);
        min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        popup.getContentPane().add(min, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 323, 70, 60));

        labelharga.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        labelharga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        popup.getContentPane().add(labelharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 120, 20));
        popup.getContentPane().add(gambarbuah, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 170, 140));

        leftbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/left.png"))); // NOI18N
        leftbutton.setBorder(null);
        leftbutton.setBorderPainted(false);
        leftbutton.setContentAreaFilled(false);
        leftbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        popup.getContentPane().add(leftbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        rightbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/right.png"))); // NOI18N
        rightbutton.setBorder(null);
        rightbutton.setBorderPainted(false);
        rightbutton.setContentAreaFilled(false);
        rightbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        popup.getContentPane().add(rightbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, -1, -1));

        labelkualitas.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        labelkualitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        popup.getContentPane().add(labelkualitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 190, 30));

        jLabel2.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        jLabel2.setText("Kualitas");
        popup.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        jml.setBackground(new java.awt.Color(255, 255, 153));
        jml.setFont(new java.awt.Font("DFPOP1-W9", 0, 30)); // NOI18N
        jml.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jml.setText("1");
        jml.setBorder(null);
        popup.getContentPane().add(jml, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 230, 90));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/popupbuah2.png"))); // NOI18N
        popup.getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, -1, -1));

        uang.setFont(new java.awt.Font("DFPOP1-W9", 0, 24)); // NOI18N
        uang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(uang, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 310, 50));

        btnapel.setBorder(null);
        btnapel.setBorderPainted(false);
        btnapel.setContentAreaFilled(false);
        btnapel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnapel, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 173, 190, 180));

        btnpisang.setBorder(null);
        btnpisang.setBorderPainted(false);
        btnpisang.setContentAreaFilled(false);
        btnpisang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnpisang, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 173, 190, 180));

        btnmangga.setBorder(null);
        btnmangga.setBorderPainted(false);
        btnmangga.setContentAreaFilled(false);
        btnmangga.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnmangga, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 173, 190, 180));

        btnmelon.setBorder(null);
        btnmelon.setBorderPainted(false);
        btnmelon.setContentAreaFilled(false);
        btnmelon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnmelon, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 393, 190, 170));

        btnsemangka.setBorder(null);
        btnsemangka.setBorderPainted(false);
        btnsemangka.setContentAreaFilled(false);
        btnsemangka.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnsemangka, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 393, 190, 170));

        jmlmangga.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        jmlmangga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlmangga.setText("0");
        getContentPane().add(jmlmangga, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 259, 90, 30));

        jmlsemangka.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        jmlsemangka.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlsemangka.setText("0");
        getContentPane().add(jmlsemangka, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 340, 90, -1));

        jmlapel.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        jmlapel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlapel.setText("0");
        getContentPane().add(jmlapel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 409, 130, 30));

        jmlmelon.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        jmlmelon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlmelon.setText("0");
        getContentPane().add(jmlmelon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 490, 80, -1));

        jmlpisang.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        jmlpisang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlpisang.setText("0");
        getContentPane().add(jmlpisang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 560, 110, -1));

        jLabel1.setFont(new java.awt.Font("DFPOP1-W9", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/inpasarbuah2.png"))); // NOI18N
        jLabel1.setText("0");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        ImageIcon awal = new ImageIcon(getClass().getResource("/ui export/backhover.png"));
        back.setIcon(awal);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        ImageIcon awal = new ImageIcon(getClass().getResource("/ui export/back.png"));
        back.setIcon(awal);
    }//GEN-LAST:event_backMouseExited

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inkedaibuah2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JButton batal;
    private javax.swing.JButton beli;
    private javax.swing.JLabel bg;
    private javax.swing.JButton btnapel;
    private javax.swing.JButton btnmangga;
    private javax.swing.JButton btnmelon;
    private javax.swing.JButton btnpisang;
    private javax.swing.JButton btnsemangka;
    private javax.swing.JLabel gambarbuah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jml;
    private javax.swing.JLabel jmlapel;
    private javax.swing.JLabel jmlmangga;
    private javax.swing.JLabel jmlmelon;
    private javax.swing.JLabel jmlpisang;
    private javax.swing.JLabel jmlsemangka;
    private javax.swing.JLabel labelharga;
    private javax.swing.JLabel labelkualitas;
    public javax.swing.JButton leftbutton;
    public javax.swing.JButton min;
    private javax.swing.JFrame popup;
    public javax.swing.JButton rightbutton;
    private javax.swing.JLabel uang;
    // End of variables declaration//GEN-END:variables
}

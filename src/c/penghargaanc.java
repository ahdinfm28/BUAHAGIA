/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import m.aset;
import m.player;
import v.achievement;

/**
 *
 * @author Farisya
 */
public class penghargaanc {

    String username;
    achievement v;
    aset maset;
    player mplayer;
    int achv = 0;
    boolean maniakapel, maniakmangga, maniakmelon, simanis, sigembul, sisehat, tukangblender, kriuk, ramerasanya,
            juraganroti, pebisnisesbuah, pengusahasale, legend, saudagar;
    boolean maniakapel2, maniakmangga2, maniakmelon2, simanis2, sigembul2, sisehat2, tukangblender2, kriuk2, ramerasanya2,
            juraganroti2, pebisnisesbuah2, pengusahasale2, legend2, saudagar2;
    boolean maniakapel1, maniakmangga1, maniakmelon1, simanis1, sigembul1, sisehat1, tukangblender1, kriuk1, ramerasanya1,
            juraganroti1, pebisnisesbuah1, pengusahasale1, legend1, saudagar1;

    public penghargaanc(String username) throws SQLException {
        this.username = username;
        this.v = new achievement();
        v.setVisible(true);
        this.maset = new aset();
        this.mplayer = new player();
        cekPenghargaan();
        cekPenghargaanKhusus();
        acctombolDetail();
        v.klikOke(new acttombolOke());
        v.klikTutup(new acttombolTutup());
    }

    private class acttombolTutup implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                new mapc(username);
                v.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(penghargaanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolOke implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().dispose();
            v.setVisible(true);
            v.enable();
        }
    }

    public void getPenghargaan() throws SQLException {
        maniakapel = maset.cekAchv(username, "maniakapel",1);
        maniakmangga = maset.cekAchv(username, "maniakmangga",1);
        maniakmelon = maset.cekAchv(username, "maniakmelon",1);
        simanis = maset.cekAchv(username, "simanis",1);
        sigembul = maset.cekAchv(username, "sigembul",1);
        sisehat = maset.cekAchv(username, "sisehat",1);
        tukangblender = maset.cekAchv(username, "tukangblender",1);
        kriuk = maset.cekAchv(username, "kriuk",1);
        ramerasanya = maset.cekAchv(username, "ramerasanya",1);
        juraganroti = maset.cekAchv(username, "juraganroti",1);
        pebisnisesbuah = maset.cekAchv(username, "pebisnisesbuah",1);
        pengusahasale = maset.cekAchv(username, "pengusahasale",1);
        saudagar = maset.cekAchv(username, "saudagar",1);
        legend = maset.cekAchv(username, "legend",1);

        maniakapel2 = maset.cekAchv(username, "maniakapel",2);
        maniakmangga2 = maset.cekAchv(username, "maniakmangga",2);
        maniakmelon2 = maset.cekAchv(username, "maniakmelon",2);
        simanis2 = maset.cekAchv(username, "simanis",2);
        sigembul2 = maset.cekAchv(username, "sigembul",2);
        sisehat2 = maset.cekAchv(username, "sisehat",2);
        tukangblender2 = maset.cekAchv(username, "tukangblender",2);
        kriuk2 = maset.cekAchv(username, "kriuk",2);
        ramerasanya2 = maset.cekAchv(username, "ramerasanya",2);
        juraganroti2 = maset.cekAchv(username, "juraganroti",2);
        pebisnisesbuah2 = maset.cekAchv(username, "pebisnisesbuah",2);
        pengusahasale2 = maset.cekAchv(username, "pengusahasale",2);
        saudagar2 = maset.cekAchv(username, "saudagar",2);
        legend2 = maset.cekAchv(username, "legend",2);

        maniakapel1 = maset.cekAchv(username, "maniakapel",3);
        maniakmangga1 = maset.cekAchv(username, "maniakmangga",3);
        maniakmelon1 = maset.cekAchv(username, "maniakmelon",3);
        simanis1 = maset.cekAchv(username, "simanis",3);
        sigembul1 = maset.cekAchv(username, "sigembul",3);
        sisehat1 = maset.cekAchv(username, "sisehat",3);
        tukangblender1 = maset.cekAchv(username, "tukangblender",3);
        kriuk1 = maset.cekAchv(username, "kriuk",3);
        ramerasanya1 = maset.cekAchv(username, "ramerasanya",3);
        juraganroti1 = maset.cekAchv(username, "juraganroti",3);
        pebisnisesbuah1 = maset.cekAchv(username, "pebisnisesbuah",3);
        pengusahasale1 = maset.cekAchv(username, "pengusahasale",3);
        saudagar1 = maset.cekAchv(username, "saudagar",3);
        legend1 = maset.cekAchv(username, "legend",3);
    }

    public void cekPenghargaan() throws SQLException {
        getPenghargaan();
        if (maniakapel) {
            v.maniakapel.setEnabled(true);
            achv++;
        } else {
            v.maniakapel.setEnabled(false);
        }
        if (maniakmangga) {
            v.maniakmangga.setEnabled(true);
            achv++;
        } else {
            v.maniakmangga.setEnabled(false);
        }
        if (maniakmelon) {
            v.maniakmelon.setEnabled(true);
            achv++;
        } else {
            v.maniakmelon.setEnabled(false);
        }
        if (simanis) {
            v.simanis.setEnabled(true);
            achv++;
        } else {
            v.simanis.setEnabled(false);
        }
        if (sigembul) {
            v.sigembul.setEnabled(true);
            achv++;
        } else {
            v.sigembul.setEnabled(false);
        }
        if (sigembul2) {
            v.sigembul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/tepung.png")));
            v.sigembul.setEnabled(true);
        } else {
            v.sigembul.setEnabled(true);
        }
        if (sisehat) {
            v.sisehat.setEnabled(true);
            achv++;
        } else {
            v.sisehat.setEnabled(false);
        }
        if (tukangblender) {
            v.tukangblender.setEnabled(true);
            achv++;
        } else {
            v.tukangblender.setEnabled(false);
        }
        if (kriuk) {
            v.kriuk.setEnabled(true);
            achv++;
        } else {
            v.kriuk.setEnabled(false);
        }
        if (ramerasanya) {
            v.ramerasanya.setEnabled(true);
            achv++;
        } else {
            v.ramerasanya.setEnabled(false);
        }
        if (pebisnisesbuah) {
            v.pebisnisesbuah.setEnabled(true);
            achv++;
        } else {
            v.pebisnisesbuah.setEnabled(false);
        }
        if (pengusahasale) {
            v.pengusahasale.setEnabled(true);
            achv++;
        } else {
            v.pengusahasale.setEnabled(false);
        }
        if (juraganroti) {
            v.juraganroti.setEnabled(true);
            achv++;
        } else {
            v.juraganroti.setEnabled(false);
        }
    }

    public void cekPenghargaanKhusus() throws SQLException {
        int uang = maset.getUang(username);

        if (achv >= 8) {
            v.saudagar.setEnabled(true);
            if (achv == 8) {
                maset.updateUang((uang + 1500000), mplayer.getIdPlayer(username));
            }
        } else {
            v.saudagar.setEnabled(false);
        }
        if (achv >= 12) {
            v.legend.setEnabled(true);
            if (achv == 12) {
                maset.updateUang((uang + 2000000), mplayer.getIdPlayer(username));
            }
        } else {
            v.legend.setEnabled(false);
        }
    }

    private class acttombolManiakApel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/maniakapel.png")));
        }
    }

    private class acttombolManiakMangga implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/maniakmangga.png")));
        }
    }

    private class acttombolManiakMelon implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/maniakmelon.png")));
        }
    }

    private class acttombolSiManis implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/simanis.png")));
        }
    }

    private class acttombolSiGembul implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/sigembul.png")));
        }
    }

    private class acttombolSiSehat implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/sisehat.png")));
        }
    }

    private class acttombolTukangBlender implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/tukangblender.png")));
        }
    }

    private class acttombolPengolahRoti implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/pengolahroti.png")));
        }
    }

    private class acttombolKriuk implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/kriuk.png")));
        }
    }

    private class acttombolJuraganRoti implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/juragan roti.png")));
        }
    }

    private class acttombolPenguasaKriuk implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/penguasakriuk.png")));
        }
    }

    private class acttombolPengusahaSale implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/pengusahasale.png")));
        }
    }

    private class acttombolSaudagar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/saudagar.png")));
        }
    }

    private class acttombolPenjualBiasa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/penjualbiasa.png")));
        }
    }

    private class acttombolLegend implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            v.popup().setVisible(true);
            v.disable();
            v.setGambar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui export/legend.png")));
        }
    }

    public void acctombolDetail() {
        v.klikJuraganRoti(new acttombolJuraganRoti());
        v.klikKriuk(new acttombolKriuk());
        v.klikLegend(new acttombolLegend());
        v.klikManiakApel(new acttombolManiakApel());
        v.klikManiakMangga(new acttombolManiakMangga());
        v.klikManiakMelon(new acttombolManiakMelon());
        v.klikPengolahRoti(new acttombolPengolahRoti());
        v.klikPenguasaKriuk(new acttombolPenguasaKriuk());
        v.klikPengusahaSale(new acttombolPengusahaSale());
        v.klikSaudagar(new acttombolSaudagar());
        v.klikSiGembul(new acttombolSiGembul());
        v.klikSiManis(new acttombolSiManis());
        v.klikSiSehat(new acttombolSiSehat());
        v.klikTukangBlender(new acttombolTukangBlender());
    }
}

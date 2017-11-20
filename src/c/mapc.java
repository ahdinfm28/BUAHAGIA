/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import m.aset;
import m.pembelian;
import m.pengolahan;
import m.player;
import v.mainmenu;
import v.map;
import v.pasarmap;

/**
 *
 * @author Farisya
 */
public class mapc {

    map vmap;
    pasarmap vmappasar;
    String username;
    aset maset;
    pembelian mbeli;
    int number;
    player mplayer;
    pengolahan molah;

    public mapc(String username) throws SQLException {
        this.username = username;
        this.maset = new aset();
        this.vmap = new map();
        this.mplayer = new player();
        this.mbeli = new pembelian();
        this.molah = new pengolahan();
        vmap.setVisible(true);
        vmap.enabledAll();
        vmap.klikKembali(new acttombolkembali());
        vmap.klikGudang(new actTombolGudang());
        vmap.klikPasar(new actTombolPasar());
        vmap.klikPabrik(new actTombolPabrik());
        vmap.klikPenghargaan(new acttombolPenghargaan());
        vmap.setUang(maset.getUang(username) + "");
        vmap.setNama(username);
        System.out.println(username);
        vmap.invisibleTombol();
    }

    public mapc(String username, map v) throws SQLException {
        this.vmap = v;
        v.setVisible(true);
        this.username = username;
        this.maset = new aset();
        this.mplayer = new player();
        this.mbeli = new pembelian();
        this.molah = new pengolahan();
        v.klikKembali(new acttombolkembali());
        v.klikLanjut(new acttombollanjut());
        v.klikPermainanBaru(new acttombolnewgame());
        v.setNama(username);
        v.disabledAll();
    }

    private class acttombolkembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            // mainmenu v = new mainmenu();
            // cmenu c = new cmenu(v);
            vmap.dispose();
        }
    }

    private class acttombollanjut implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                new mapc(username);
                vmap.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(mapc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolnewgame implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                mbeli.resetPembelianBahan(mplayer.getIdPlayer(username));
                mbeli.resetPembelianBuah(mplayer.getIdPlayer(username));
                molah.resetHasilPengolahan(mplayer.getIdPlayer(username));
                maset.resetUang(mplayer.getIdPlayer(username));
                maset.resetPenghargaan(mplayer.getIdPlayer(username));
                maset.resetResep(mplayer.getIdPlayer(username));
                maset.insertResep(mplayer.getIdPlayer(username), "jusbuah");
                maset.insertResep(mplayer.getIdPlayer(username), "brownis");
                mbeli.resetBeliBahan(mplayer.getIdPlayer(username));//gausa
                mbeli.resetBeliBuah(mplayer.getIdPlayer(username));//gausa
                molah.resetOlah(mplayer.getIdPlayer(username));//gausa
                new mapc(username);
                // vmap.setUang(maset.getUang(username) + "");
            } catch (SQLException ex) {
                Logger.getLogger(mapc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolPenghargaan implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                new penghargaanc(username);
                vmap.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(mapc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class actTombolPasar implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            try {
                pasarmap v = new pasarmap();
                pasarc c = new pasarc(username);
                RandomHarga();
                vmap.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(mapc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            ImageIcon awal = new ImageIcon(getClass().getResource("/ui export/pasarh.png"));
            vmap.pasar.setIcon(awal);
        }

        @Override
        public void mouseExited(MouseEvent me) {
            ImageIcon awal = new ImageIcon(getClass().getResource("/ui export/pasar.png"));
            vmap.pasar.setIcon(awal);
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }
    }

    private class actTombolGudang implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            try {
                new gudangc(username);
                vmap.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(mapc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            ImageIcon awal = new ImageIcon(getClass().getResource("/ui export/gudangh.png"));
            vmap.gudang.setIcon(awal);
        }

        @Override
        public void mouseExited(MouseEvent me) {
            ImageIcon awal = new ImageIcon(getClass().getResource("/ui export/gudang.png"));
            vmap.gudang.setIcon(awal);
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }
    }

    private class actTombolPabrik implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent me) {
            try {
                new pengolahanc(username);
                vmap.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(mapc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            ImageIcon awal = new ImageIcon(getClass().getResource("/ui export/rumahover.png"));
            vmap.pabrik.setIcon(awal);
        }

        @Override
        public void mouseExited(MouseEvent me) {
            ImageIcon awal = new ImageIcon(getClass().getResource("/ui export/pabrik.png"));
            vmap.pabrik.setIcon(awal);
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }
    }

    public int RandomHarga() {
        Random random = new Random();
        for (int counter = 1; counter <= 1; counter++) {
            number = 1 + random.nextInt(3);
        }
        System.out.println(number);
        if (number == 1) {
            mbeli.deleteHarga();
            mbeli.insertHarga1();
            System.out.println("harga1 diinputkan");
        } else if (number == 2) {
            mbeli.deleteHarga();
            mbeli.insertHarga2();
            System.out.println("harga2 diinputkan");
        } else if (number == 3) {
            mbeli.deleteHarga();
            mbeli.insertHarga3();
            System.out.println("harga3 diinputkan");
        }
        return number;
    }
}

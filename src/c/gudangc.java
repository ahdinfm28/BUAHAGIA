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
import v.ingudang;
import v.map;
//cek coba anu

/**
 *
 * @author Farisya
 */
public class gudangc {

    map vmap;
    String username;
    aset maset;
    ingudang vgudang;
    int apel1, apel2, apel3, semangka1, semangka2, semangka3, melon1, melon2, melon3, mangga1, mangga2, mangga3, pisang1, pisang2, pisang3;
    int brownisapel1, brownisapel2, brownisapel3, brownissemangka1, brownissemangka2, brownissemangka3, brownismelon1,
            brownismelon2, brownismelon3, brownismangga1, brownismangga2, brownismangga3, brownispisang1, brownispisang2, brownispisang3;
    int jusapel1, jusapel2, jusapel3, jusmelon1, jusmelon2, jusmelon3, jusmangga1, jusmangga2, jusmangga3, jussemangka1, jussemangka2,
            jussemangka3, juspisang1, juspisang2, juspisang3;
    int kripikapel1, kripikapel2, kripikapel3, kripikpisang1, kripikpisang2, kripikpisang3, kripikmangga1, kripikmangga2, kripikmangga3;
    int esbuah1, esbuah2, esbuah3, salad1, salad2, salad3, sale1, sale2, sale3;
    int mayo,susu,telur,mentega,tepungterigu,tepungberas,sirup,minyak,pengembang,gula;

    public gudangc(String username) throws SQLException {
        this.username = username;
        this.maset = new aset();
        this.vgudang = new ingudang();
        vgudang.setVisible(true);
        setStokProduk();
        setStokBuah();
        setStokBahan();
        vgudang.klikKembali(new acttombolkembali());
        vgudang.klikNexttoBahan(new acttombolnexttoBahan());
        vgudang.klikPreviousBahan(new acttombolprevioustoBahan());
        vgudang.klikNexttoProduk(new acttombolnexttoProduk());
        vgudang.klikPreviousBuah(new acttombolprevioustoBuah());
    }

    private class acttombolkembali implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                map v = new map();
                mapc c = new mapc(username);
                vgudang.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(pengolahanc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class acttombolnexttoBahan implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            vgudang.setVisible(false);
            vgudang.showbahan().setVisible(true);
        }
    }
    private class acttombolnexttoProduk implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            vgudang.showbahan().setVisible(false);
            vgudang.showproduk().setVisible(true);
        }
    }

    private class acttombolprevioustoBuah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            vgudang.setVisible(true);
            vgudang.showbahan().setVisible(false);
        }
    }
    private class acttombolprevioustoBahan implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            vgudang.showbahan().setVisible(true);
            vgudang.showproduk().setVisible(false);
        }
    }

    public void setStokBuah() throws SQLException {
        apel1 = vgudang.setJmlApel1(maset.getJmlBuah(username, 1, 1));
        apel2 = vgudang.setJmlApel2(maset.getJmlBuah(username, 1, 2));
        apel3 = vgudang.setJmlApel3(maset.getJmlBuah(username, 1, 3));
        pisang1 = vgudang.setJmlPisang1(maset.getJmlBuah(username, 2, 1));
        pisang2 = vgudang.setJmlPisang2(maset.getJmlBuah(username, 2, 2));
        pisang3 = vgudang.setJmlPisang3(maset.getJmlBuah(username, 2, 3));
        mangga1 = vgudang.setJmlMangga1(maset.getJmlBuah(username, 3, 1));
        mangga2 = vgudang.setJmlMangga2(maset.getJmlBuah(username, 3, 2));
        mangga3 = vgudang.setJmlMangga3(maset.getJmlBuah(username, 3, 3));
        semangka1 = vgudang.setJmlSemangka1(maset.getJmlBuah(username, 4, 1));
        semangka2 = vgudang.setJmlSemangka2(maset.getJmlBuah(username, 4, 2));
        semangka3 = vgudang.setJmlSemangka3(maset.getJmlBuah(username, 4, 3));
        melon1 = vgudang.setJmlMelon1(maset.getJmlBuah(username, 5, 1));
        melon2 = vgudang.setJmlMelon2(maset.getJmlBuah(username, 5, 2));
        melon3 = vgudang.setJmlMelon3(maset.getJmlBuah(username, 5, 3));
    }

    public void setStokBahan() throws SQLException {
        mayo=vgudang.setJmlMayo(maset.getJmlBahan(username, 6));
        susu=vgudang.setJmlSusu(maset.getJmlBahan(username,8));
        gula=vgudang.setJmlGula(maset.getJmlBahan(username, 1));
        tepungberas = vgudang.setJmlTepungB(maset.getJmlBahan(username, 2));
        minyak=vgudang.setJmlMinyak(maset.getJmlBahan(username,3));
        mentega = vgudang.setJmlMentega(maset.getJmlBahan(username,4));
        sirup=vgudang.setJmlSirup(maset.getJmlBahan(username, 5));
        telur=vgudang.setJmlTelur(maset.getJmlBahan(username, 7));
        pengembang=vgudang.setJmlPengembang(maset.getJmlBahan(username, 9));
        tepungterigu=vgudang.setJmlTepungT(maset.getJmlBahan(username,10));
                
    }

    public void setStokProduk() throws SQLException {
        brownispisang1 = vgudang.setJmlBrownisPisang1(maset.getJmlProduk(username, 9, 1));
        brownispisang2 = vgudang.setJmlBrownisPisang2(maset.getJmlProduk(username, 9, 2));
        brownispisang3 = vgudang.setJmlBrownisPisang3(maset.getJmlProduk(username, 9, 3));
        brownisapel1 = vgudang.setJmlBrownisA1(maset.getJmlProduk(username, 10, 1));
        brownisapel2 = vgudang.setJmlBrownisA2(maset.getJmlProduk(username, 10, 2));
        brownisapel3 = vgudang.setJmlBrownisA3(maset.getJmlProduk(username, 10, 3));
        brownismangga1 = vgudang.setJmlBrownisMangga1(maset.getJmlProduk(username, 13, 1));
        brownismangga2 = vgudang.setJmlBrownisMangga2(maset.getJmlProduk(username, 13, 2));
        brownismangga3 = vgudang.setJmlBrownisMangga3(maset.getJmlProduk(username, 13, 3));
        brownismelon1 = vgudang.setJmlBrownisMelon1(maset.getJmlProduk(username, 11, 1));
        brownismelon2 = vgudang.setJmlBrownisMelon2(maset.getJmlProduk(username, 11, 2));
        brownismelon3 = vgudang.setJmlBrownisMelon3(maset.getJmlProduk(username, 11, 3));
        brownissemangka1 = vgudang.setJmlBrownisSemangka1(maset.getJmlProduk(username, 12, 1));
        brownissemangka2 = vgudang.setJmlBrownisSemangka2(maset.getJmlProduk(username, 12, 2));
        brownissemangka3 = vgudang.setJmlBrownisSemangka3(maset.getJmlProduk(username, 12, 3));
        jusapel1 = vgudang.setJmlJusApel1(maset.getJmlProduk(username, 1, 1));
        jusapel2 = vgudang.setJmlJusApel2(maset.getJmlProduk(username, 1, 2));
        jusapel3 = vgudang.setJmlJusApel3(maset.getJmlProduk(username, 1, 3));
        juspisang1 = vgudang.setJmlJusPisang1(maset.getJmlProduk(username, 2, 1));
        juspisang2 = vgudang.setJmlJusPisang2(maset.getJmlProduk(username, 2, 2));
        juspisang3 = vgudang.setJmlJusPisang3(maset.getJmlProduk(username, 2, 3));
        jusmangga1 = vgudang.setJmlJusMangga1(maset.getJmlProduk(username, 3, 1));
        jusmangga2 = vgudang.setJmlJusMangga2(maset.getJmlProduk(username, 3, 2));
        jusmangga3 = vgudang.setJmlJusMangga3(maset.getJmlProduk(username, 3, 3));
        jusmelon1 = vgudang.setJmlJusMelon1(maset.getJmlProduk(username, 4, 1));
        jusmelon2 = vgudang.setJmlJusMelon2(maset.getJmlProduk(username, 4, 2));
        jusmelon3 = vgudang.setJmlJusMelon3(maset.getJmlProduk(username, 4, 3));
        jussemangka1 = vgudang.setJmlJusSemangka1(maset.getJmlProduk(username, 5, 1));
        jussemangka2 = vgudang.setJmlJusSemangka2(maset.getJmlProduk(username, 5, 2));
        jussemangka3 = vgudang.setJmlJusSemangka3(maset.getJmlProduk(username, 5, 3));
        kripikapel1 = vgudang.setJmlKripikApel1(maset.getJmlProduk(username, 6, 1));
        kripikapel2 = vgudang.setJmlKripikApel2(maset.getJmlProduk(username, 6, 2));
        kripikapel3 = vgudang.setJmlKripikApel3(maset.getJmlProduk(username, 6, 3));
        kripikmangga1 = vgudang.setJmlKripikMangga1(maset.getJmlProduk(username, 7, 1));
        kripikmangga2 = vgudang.setJmlKripikMangga2(maset.getJmlProduk(username, 7, 2));
        kripikmangga3 = vgudang.setJmlKripikMangga3(maset.getJmlProduk(username, 7, 3));
        kripikpisang1 = vgudang.setJmlKripikPisang1(maset.getJmlProduk(username, 8, 1));
        kripikpisang2 = vgudang.setJmlKripikPisang2(maset.getJmlProduk(username, 8, 2));
        kripikpisang3 = vgudang.setJmlKripikPisang3(maset.getJmlProduk(username, 8, 3));
        esbuah1 = vgudang.setJmlEsbuah1(maset.getJmlProduk(username, 15, 1));
        esbuah2 = vgudang.setJmlEsbuah2(maset.getJmlProduk(username, 15, 2));
        esbuah3 = vgudang.setJmlEsbuah3(maset.getJmlProduk(username, 15, 3));
        salad1 = vgudang.setJmlSaladbuah1(maset.getJmlProduk(username, 16, 1));
        salad2 = vgudang.setJmlSaladbuah2(maset.getJmlProduk(username, 16, 2));
        salad3 = vgudang.setJmlSaladbuah3(maset.getJmlProduk(username, 16, 3));
        sale1 = vgudang.setJmlSale1(maset.getJmlProduk(username, 14, 1));
        sale2 = vgudang.setJmlSale2(maset.getJmlProduk(username, 14, 2));
        sale3 = vgudang.setJmlSale3(maset.getJmlProduk(username, 14, 3));
    }
}

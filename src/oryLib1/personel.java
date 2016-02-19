/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oryLib1;


import dbcLib1.vtbaglatisi;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import static oryLib1.otel.SecilenOtel;

/**
 *
 * @author Xsence
 */
    
public class personel {
    /*
            int personelNo
            String isim
            String soyisim
            String gorev
            int maas
            date izinBaslangıc
            date izinBitis
            int toplamIzin
            int otelNo
    */
    public int personelNo;
    public static int secilenPersonel=0;
    vtbaglatisi baglanti=new vtbaglatisi();
    
    public ResultSet GetPersonelElemanListe() throws SQLException{
        String sql = "SELECT * FROM personel WHERE 1";
        ResultSet data = baglanti.sqlSorgu(sql);
        return data;
}
    public void PersonelEkle( String isim, String soyisim, String gorev,
            int maas, String izinBaslangic, String izinBitis, 
            int toplamIzin) throws SQLException{
            /*
            int personelNo
            String isim
            String soyisim
            String gorev
            int maas
            date izinBaslangıc
            date izinBitis
            int toplamIzin
            int otelNo
            */
        String sqlekle = "INSERT INTO `personel`(`personelNo`, `isim`, `soyisim`, `gorev`, `maas`, `izinBaslangic`, `izinBitis`, `toplamIzin`, `otelNo`) VALUES "
                + "(NULL,'"+ isim +"','"+ soyisim +"','"+ gorev +"','"+ maas +"','"+ izinBaslangic +"','"+ izinBitis+"','"+toplamIzin+"','"+SecilenOtel+"')";
        baglanti.sqlislem(sqlekle);
    }
    
    public void personelDuzenle(String isim,
            String soyisim,
            String gorev,
            int maas,
            String izinBaslangic,
            String izinBitis,
            int toplamIzin,
            int otelNo) throws SQLException{
            String sqlduzenle = "UPDATE `otelrezervasyonsistemi`.`personel` SET" +
                    
                    " `isim`='" + isim +
                    "', `soyisim`='" + soyisim + 
                    "', `gorev`='" + gorev + 
                    "', `maas`='" + maas + 
                    "', `izinBaslangic`='" + izinBaslangic + 
                    "', `izinBitis`='" + izinBitis + 
                    "', `toplamIzin`='" + toplamIzin + 
                    "', `otelNo`='" + otelNo + 
                    "' WHERE `personel`.`personelNo`=" +secilenPersonel;
            baglanti.sqlislem(sqlduzenle);
    }
    public void personelSil(int per) throws SQLException{
        String sqlsil = "DELETE FROM otelrezervasyonsistemi.personel WHERE personel.personelNo = " + per;
        baglanti.sqlislem(sqlsil);
    }

    public ResultSet GetPersonelElemanListe(int ID) throws SQLException {
         String sql = "SELECT * FROM `personel` WHERE `personelNo` = "+ID ;
        ResultSet sonuc=baglanti.sqlSorgu(sql);
        sonuc.next();
        return sonuc;
    }

}
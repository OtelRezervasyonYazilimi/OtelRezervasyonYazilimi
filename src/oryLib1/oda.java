/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oryLib1;

import dbcLib1.vtbaglatisi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mehmet
 */
public class oda {

    private int OtelNo;
    public static int SecilenOda=0;
    vtbaglatisi baglanti=new vtbaglatisi();

    public void setSecilenOda(int SecilenOda) {
        oda.SecilenOda = SecilenOda;
    }

    public int getOtelNo() {
        return OtelNo;
    }
      public ResultSet GetOdaElemanListeAra(int ks) throws SQLException{
        String sql = "SELECT * FROM `odalar` WHERE `kisiSayisi` = " + ks ;
        ResultSet sonuc=baglanti.sqlSorgu(sql);
        sonuc.next();
        return sonuc;
    }
    
    public ResultSet GetOdaElemanListe(int ID) throws SQLException{
        String sql = "SELECT * FROM `odalar` WHERE `odaNo` = " + ID ;
        ResultSet sonuc=baglanti.sqlSorgu(sql);
        sonuc.next();
        return sonuc;
    }
    public ResultSet GetOdaElemanListe() throws SQLException{
        String sql = "SELECT * FROM odalar WHERE otelNo = " + OtelNo;
        ResultSet data = baglanti.sqlSorgu(sql);
        return data;
    }
    public void OdaEkle(String tip, int kisiSayisi, int otelNo,int gu,int durum) throws SQLException{
        String sqlekle = "INSERT INTO `otelrezervasyonsistemi`.`odalar` (`odaNo`, `tip`, `kisiSayisi`, `otelNo`, `GunlukUcret`, `durum`) VALUES (NULL, '" +tip+ "', '"+kisiSayisi+"', '"+otelNo+"', '"+gu+"', '"+durum+"')";
        baglanti.sqlislem(sqlekle);
    }
    public void OdaDuzenle(String tip, int kisiSayisi, int otelNo, int OdaNo,int gu,int durum) throws SQLException{
        String sqlduzenle = "UPDATE `otelrezervasyonsistemi`.`odalar` SET `tip` = '"+tip+"', `kisiSayisi` = '"+kisiSayisi+"', `otelNo` = '"+otelNo+"', `GunlukUcret` = '"+gu+"', `durum` = '"+durum+"' WHERE `odalar`.`odaNo` = "+OdaNo;
          baglanti.sqlislem(sqlduzenle);
    }
    public void OdaSil(int odano) throws SQLException{
        String sqlsil = "DELETE FROM otelrezervasyonsistemi.odalar WHERE odalar.odaNo = " + odano;
        baglanti.sqlislem(sqlsil);
    }
    

    public oda() {
    }

    public oda(int otelno) {
        this.OtelNo = otelno;
    }

}

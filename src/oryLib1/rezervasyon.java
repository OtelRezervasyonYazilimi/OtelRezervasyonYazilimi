/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oryLib1;

import dbcLib1.vtbaglatisi;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mehmet
 */
public class rezervasyon {
    private int OtelNo;
    public static int SecilenRezervasyon=0;
    vtbaglatisi baglanti=new vtbaglatisi();

    public rezervasyon() {
    }

   
    public rezervasyon(int otelno) {
        this.OtelNo = otelno;
    }
    
    
    public void setSecilenRezevasyon(int SecilenRezevasyon) {
        rezervasyon.SecilenRezervasyon = SecilenRezevasyon;
    }

  
    
    
    
        public ResultSet GetRezevasyonElemanListe(int ID) throws SQLException{
        String sql = "SELECT * FROM `rezervasyonlar` WHERE `rezervasyonNo` = "+ID ;
        ResultSet sonuc=baglanti.sqlSorgu(sql);
        sonuc.next();
        return sonuc;
    }
    public ResultSet GetRezevasyonElemanListe() throws SQLException{
        String sql = "SELECT * FROM rezervasyonlar WHERE otelNo = " + OtelNo;
        ResultSet data = baglanti.sqlSorgu(sql);
        return data;
    }
    
    
    public void RezervasyonEkle(int odaNo,int musteriNo,String gt,String ct) throws SQLException{
        
        String sqlekle = "INSERT INTO `rezervasyonlar`(`rezervasyonNo`, `odaNo`, `musteriNo`, `girisTarihi`, `cikisTarihi`, `otelNo`) VALUES (NULL, '" +odaNo+ "', '" +musteriNo+ "', '" +gt+ "', '" +ct+ "', '" +OtelNo+ "')";
        baglanti.sqlislem(sqlekle);
        
        
    }
    public void RezervasyonDuzenle(String tip, int kisiSayisi, int otelNo, int OdaNo) throws SQLException{
        String sqlduzenle = "UPDATE `otelrezervasyonsistemi`.`rezervasyon` SET `tip` = '"+tip+"', `kisiSayisi` = '"+kisiSayisi+"', `otelNo` = '"+otelNo+"' WHERE `odalar`.`odaNo` = "+OdaNo;
          baglanti.sqlislem(sqlduzenle);
    }
    public void RezervasyonSil(int RezervasyonNo) throws SQLException{
        String sqlsil = "DELETE FROM otelrezervasyonsistemi.rezervasyon WHERE odalar.rezervasyonNo = " + RezervasyonNo;
        baglanti.sqlislem(sqlsil);
    }
    
}

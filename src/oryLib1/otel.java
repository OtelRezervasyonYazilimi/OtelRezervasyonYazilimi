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
 * @author Xsence
 */
public class otel {
    
    public int OtelNo;
    public static int SecilenOtel=0;
    vtbaglatisi baglanti=new vtbaglatisi();
    
    
    public static int getSecilenOtel() {
        return SecilenOtel;
    }

    public void setSecilenOtel(int SecilenOtel) {
        otel.SecilenOtel = SecilenOtel;
    }

    public int getOtelNo() {
        return OtelNo;
    }

    public otel() {
    }

    public otel(int otelno) {
        this.OtelNo = otelno;
    }   
    
        public ResultSet GetOtelElemanListe(int ID) throws SQLException{
        String sql = "SELECT * FROM `otel` WHERE `otelNo` = "+ID ;
        ResultSet sonuc=baglanti.sqlSorgu(sql);
        sonuc.next();
        return sonuc;
    }
    public ResultSet GetOtelElemanListe() throws SQLException{
        String sql = "SELECT * FROM otel WHERE 1";
        ResultSet data = baglanti.sqlSorgu(sql);
        return data;
    }
    
    public void OtelEkle( String otelAdi, String adres, String telefon, String email) throws SQLException{
        String sqlekle = "INSERT INTO `otelrezervasyonsistemi`.`otel` ( `otelNo`, `otelAdi`, `adres`, `telefon`, `email`) VALUES (NULL, '"  +  otelAdi + "', '" + adres + "', '" + telefon + "', '" + email +"')";
        baglanti.sqlislem(sqlekle);
    }
    public void OtelDuzenle(String otelAdi, String adres, String telefon, String email, int OtelNo) throws SQLException{
        String sqlduzenle = "UPDATE `otelrezervasyonsistemi`.`otel` SET `otelAdi` = '"+otelAdi+"', `adres` = '"+adres+"', `telefon` = '"+telefon+"', `email` = '"+email+"' WHERE `otel`.`otelNo` = "+OtelNo;
          baglanti.sqlislem(sqlduzenle);
    }
    public void OtelSil(int otelNo) throws SQLException{
        String sqlsil = "DELETE FROM otelrezervasyonsistemi.otel WHERE otel.otelNo = " + otelNo;
        baglanti.sqlislem(sqlsil);
    }
  
}

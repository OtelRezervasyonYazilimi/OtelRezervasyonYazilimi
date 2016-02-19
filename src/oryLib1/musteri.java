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
public class musteri {
    static public int secilenmusteri;
    private int OtelNo;
    vtbaglatisi baglanti=new vtbaglatisi();
    
    
    
   
      
      
      
      public ResultSet GetMusteriElemanListeAra(int tc) throws SQLException{
        OtelNo=otel.SecilenOtel; 
        String sql = "SELECT * FROM musteriler WHERE musteriNo = " + tc;
        ResultSet data = baglanti.sqlSorgu(sql);
        return data;
    } 
      
        public ResultSet GetMusteriElemanListe(int ID) throws SQLException {
        String sql = "SELECT * FROM musteriler WHERE  musteriNo =" + ID;
        ResultSet data = baglanti.sqlSorgu(sql);
        data.next();
        return data; //To change body of generated methods, choose Tools | Templates.
    }
         
     public ResultSet GetMusteriElemanListe() throws SQLException{
        OtelNo=otel.SecilenOtel; 
        String sql = "SELECT * FROM musteriler WHERE otelNo = " + OtelNo;
        ResultSet data = baglanti.sqlSorgu(sql);
        return data;
    }
     
   public void MusteriEkle(String text,
            String text1,
            String text2,
            String text3,
            String text4,
            String text5,
            String text6
            ) throws SQLException{
        String sqlekle = "INSERT INTO `otelrezervasyonsistemi`.`musteriler` (`musteriNo`, `isim`, `soyisim`, `rezervasyonNo`, `odaNo`, `ozel`, `kalinanSure`, `otelNo`) VALUES "
                + "(NULL, '" + text
                + "', '" +text1
                + "', '" +text2
                + "', '" +text3
                + "', '" +text4
                + "', '" +text5
                + "', '" +text6
                + "')";
        baglanti.sqlislem(sqlekle);
    }
    public void MusteriDuzenle(String isim,
            String soyisim,
            String rezervasyonNo,
            String odaNo,
            String ozel,
            String kalinanSure,
            String otelNo) throws SQLException{
        String sqlduzenle = "UPDATE `otelrezervasyonsistemi`.`musteriler` SET `isim` = '"+isim+"', `soyisim` = '"+soyisim+"', `rezervasyonNo` = '"+rezervasyonNo+"', `odaNo` = '"+odaNo+"', `ozel` = '"+ozel+"', `kalinanSure` = '"+kalinanSure+"', `otelNo` = '"+otelNo+"' WHERE `musteriler`.`musteriNo` = "+secilenmusteri;
          baglanti.sqlislem(sqlduzenle);
    }
    public void MusteriSil(int musteriNo) throws SQLException{
        String sqlsil = "DELETE FROM otelrezervasyonsistemi.musteriler WHERE musteriler.musteriNo = " + secilenmusteri;
        baglanti.sqlislem(sqlsil);
    }
    
    
}

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
public class servis {
private int OdaNo;
public static int SecilenServis=0;
vtbaglatisi baglanti=new vtbaglatisi();

    public servis() {
    }
      public ResultSet GetServisElemanListe(int ID) throws SQLException{
        String sql = "SELECT * FROM `servisler` WHERE `servisNo` = "+ID ;
        ResultSet sonuc=baglanti.sqlSorgu(sql);
        sonuc.next();
        return sonuc;
    }

   public ResultSet GetServisElemanListe() throws SQLException{
        String sql = "SELECT * FROM servisler WHERE odaNo = " + OdaNo;
        ResultSet data = baglanti.sqlSorgu(sql);
        return data;
    }
   public void servisEkle(String adi, int maliyet) throws SQLException{
        String sqlekle = "INSERT INTO `servisler`(`servisNo`, `otelNo`, `odaNo`, `servisAdi`, `maliyet`) VALUES (NULL, '"+otel.SecilenOtel+"', '"+oda.SecilenOda+"', '"+adi+"', '"+maliyet+"')";
        baglanti.sqlislem(sqlekle);
    }
   
    public void servisDuzenle(String adi, int maliyet, int servisno) throws SQLException{
        String sqlduzenle = "UPDATE `otelrezervasyonsistemi`.`servisler` SET `servisAdi` = '"+adi+"', `maliyet` = '"+maliyet+"' WHERE `servisler`.`servisNo` = "+servisno;
        baglanti.sqlislem(sqlduzenle);
    } 
     public void servisSil(int servisno) throws SQLException{
        String sqlsil = "DELETE FROM `otelrezervasyonsistemi`.`servisler` WHERE `servisler`.`servisNo` = "+servisno;
        baglanti.sqlislem(sqlsil);
    }
   
   
 public servis(int odano) {
        this.OdaNo = odano;
    }

}

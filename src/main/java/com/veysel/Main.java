package com.veysel;

import com.veysel.enums.ECinsiyet;
import com.veysel.repository.entity.Musteri;
import com.veysel.util.HibernateUtility;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Session ss=HibernateUtility.getSessionFactory().openSession();
        Transaction tt=ss.beginTransaction();


       Musteri musteri= new Musteri();
       musteri.setAd("Muhammet");
       musteri.setSoyad("Karakaya");
       musteri.setAdsoyad(musteri.getAd()+" "+musteri.getSoyad());
       musteri.setAdres("İstanbul");
       musteri.setDogumTarihi(new Date());
       musteri.setKayitTarihi(new Timestamp(System.currentTimeMillis()));
       musteri.setCinsiyet(ECinsiyet.ERKEK);
       musteri.setCreateAt(System.currentTimeMillis());
       musteri.setTelefonListesi(Arrays.asList("1234564789","8797987987"));


       ss.save(musteri);
       tt.commit();
       ss.close();
    }
}
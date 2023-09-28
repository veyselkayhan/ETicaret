package com.veysel;

import com.veysel.enums.ECinsiyet;
import com.veysel.repository.entity.BaseEntity;
import com.veysel.repository.entity.Iletisim;
import com.veysel.repository.entity.Musteri;
import com.veysel.repository.entity.Satis;
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
//
//
//        Satis satis=Satis.builder().musteriid(2L).id(1L).build();

        BaseEntity baseEntity= BaseEntity.builder()
                .state(1)
                .createAt(System.currentTimeMillis())
                .updateAt(System.currentTimeMillis())
                .isActive(true)
                .build();
        Iletisim iletisim=Iletisim.builder()
                .adres("Ankara")
                .cepTelefonu("5378470633")
                .email("v@gmail.com")
                .build();


       Musteri musteri= new Musteri();
       musteri.setAd("Muhammet");
       musteri.setSoyad("Karakaya");
       musteri.setAdsoyad(musteri.getAd()+" "+musteri.getSoyad());
       musteri.setBaseEntity(baseEntity);
       musteri.setIletisim(iletisim);
//       musteri.setAdres("İstanbul");
       musteri.setDogumTarihi(new Date());
       musteri.setKayitTarihi(new Timestamp(System.currentTimeMillis()));
       musteri.setCinsiyet(ECinsiyet.ERKEK);
//       musteri.setCreateAt(System.currentTimeMillis());
       musteri.setTelefonListesi(Arrays.asList("1234564789","8797987987"));



       ss.save(musteri);
       tt.commit();
       ss.close();
    }
}
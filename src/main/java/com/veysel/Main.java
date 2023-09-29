package com.veysel;

import com.veysel.criteriaornekleri.CriteriaOrnekleri;
import com.veysel.enums.ECinsiyet;
import com.veysel.repository.MusteriRepository;
import com.veysel.repository.UrunRepository;
import com.veysel.repository.entity.*;
import com.veysel.util.HibernateUtility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
//
//        Session ss=HibernateUtility.getSessionFactory().openSession();
//        Transaction tt=ss.beginTransaction();
//
//        BaseEntity baseEntity= BaseEntity.builder()
//                .isActive(true)
//                .state(1)
//                .updateAt(System.currentTimeMillis())
//                .createAt(System.currentTimeMillis())
//                .build();
//
//        UrunRepository urunRepository=new UrunRepository();
//        urunRepository.save(Urun.builder()
//                        .baseEntity(baseEntity)
//                        .ad("Bilgisayar")
//                        .stok(300)
//                        .fiyat(BigDecimal.valueOf(2_300))
//                        .barkod("4245746546")
//                        .marka("Asus")
//                        .model("X550v")
//                .build());
//
//        MusteriRepository musteriRepository=new MusteriRepository();

//        musteriRepository.save(Musteri.builder().build());


//
//        Urun urunSeker= Urun.builder()
//                .ad("Şeker")
//                .fiyat(BigDecimal.valueOf(20))
//                .stok(100)
//                .baseEntity(baseEntity)
//                .build();
//
//        Urun urunYag=Urun.builder()
//                .ad("Yağ")
//                .fiyat(BigDecimal.valueOf(200))
//                .baseEntity(baseEntity)
//                .build();
//        ss.save(urunSeker);
//        ss.save(urunYag);
//
//        Satis satis= Satis.builder()
//                .musteriid(1L)
//                .date(System.currentTimeMillis())
//                .baseEntity(baseEntity)
//                .toplamTutar(BigDecimal.valueOf(500))
//                .build();
//
//        ss.save(satis);
//
//        SatisDetay satisDetaySeker= SatisDetay.builder()
//                .urunId(1L)
//                .fiyat(BigDecimal.valueOf(20))
//                .adet(5)
//                .toplamFiyat(BigDecimal.valueOf(100))
//                .baseEntity(baseEntity)
//                .satisId(1L)
//                .build();
//
//        SatisDetay satisDetayYag= SatisDetay.builder()
//                .urunId(2L)
//                .fiyat(BigDecimal.valueOf(200))
//                .adet(2)
//                .toplamFiyat(BigDecimal.valueOf(400))
//                .baseEntity(baseEntity)
//                .satisId(1L)
//                .build();
//
//
//        ss.save(satisDetaySeker);
//        ss.save(satisDetayYag);





//        Satis satis=Satis.builder().musteriid(2L).id(1L).build();
//
//        BaseEntity baseEntity= BaseEntity.builder()
//                .state(1)
//                .createAt(System.currentTimeMillis())
//                .updateAt(System.currentTimeMillis())
//                .isActive(true)
//                .build();
//        Iletisim iletisim=Iletisim.builder()
//                .adres("Ankara")
//                .cepTelefonu("5378470633")
//                .email("v@gmail.com")
//                .build();
//
//
//       Musteri musteri= new Musteri();
//       musteri.setAd("Muhammet");
//       musteri.setSoyad("Karakaya");
//       musteri.setAdsoyad(musteri.getAd()+" "+musteri.getSoyad());
//       musteri.setBaseEntity(baseEntity);
//       musteri.setIletisim(iletisim);
////       musteri.setAdres("İstanbul");
//       musteri.setDogumTarihi(new Date());
//       musteri.setKayitTarihi(new Timestamp(System.currentTimeMillis()));
//       musteri.setCinsiyet(ECinsiyet.ERKEK);
////       musteri.setCreateAt(System.currentTimeMillis());
//       musteri.setTelefonListesi(Arrays.asList("1234564789","8797987987"));
//       ss.save(musteri);


//        new CriteriaOrnekleri().findAll();

        new CriteriaOrnekleri().selectOneColumn();



    }
}
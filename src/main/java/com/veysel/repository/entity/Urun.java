package com.veysel.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/*
NamedQuery,
Onbellekleme yapabiliyoruz.Bu nedenle aynı sorgu tekrar çağrıldığında ön bellekte değer döndüğü için daha hızlı cevap verir.

HQL,JPQL,NativeSQL
HQL -> Hibernate Query Language        -> from musteri

JPQL -> Java Persistence Query Language -> Select m from musteri m

NativeSQL -> Native Structured Query Language-> Select * FROM tbl_musteri
 */

@NamedQueries({
        @NamedQuery(name = " Urun.findAll",query = "SELECT u FROM Urun u"),
        @NamedQuery(name = "Urun.findByAd", query = "SELECT u FROM Urun u WHERE u.ad LIKE :urunadi"),
        @NamedQuery(name = "Urun.getTotalPrice", query = "SELECT SUM(u.fiyat) AS totalprice FROM Urun u")

})

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_urun")

public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long id;

    String ad;

    String barkod;

    String marka;

    String model;

    BigDecimal fiyat;

    Integer stok;

    @Embedded
    BaseEntity baseEntity;

}

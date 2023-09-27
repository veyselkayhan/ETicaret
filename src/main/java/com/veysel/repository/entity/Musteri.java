package com.veysel.repository.entity;

import com.veysel.enums.ECinsiyet;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tblmusteri")
public class Musteri {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)//sq_tblmusteri_id -> initial=1,increment = 1

    /*
    Entity olusturulacak ise mutlaka ve mutlaka ID alma zorundadir.
    Tablolarımızda benzesiz bir alan alsa nasıl tanımlanır.
    1->Otomatik olusturma Id Olusturma (IDENTITY,TABlE,SEQUENCE,AUTO)
    2->Elle SQ yazılabilir.
    3->UUID kullanılabilir.
    4->

     */
    long id;

    @SequenceGenerator(name = "seq_musteri_id",sequenceName = "seq_musteri_id",initialValue = 100,allocationSize = 1)
    @GeneratedValue(generator = "seq_musteri_id")//tanımlanmış olan sq i ilgili alana atamasını yapıyoruz.
    Long m_id;

    @GenericGenerator(name="uuid_musteri",strategy = "uuid2")
    @GeneratedValue(generator = "uuid_musteri")
    UUID uuid;


    /*
    Tabloların biliyorsunuz ki kolonlar kullanılmakta alan alanı ifade eder ve siz SQL ile bir kolon olusturacaksınız
    bazı özellikleri tanımlarsınız
    ad varchar(50) not null default ' ' gibi
     */

    /*
    Veritabanında bir kolon yani tablodaki bir alanın özelliklerini
    belirtmek için @column anatasyonu kullanilir.Bu anatasyon ile birlikte olusacak kolonun özellikleri belirlenecektir.

     */

    /*
    NOT: updatable ve insertable ifadeleri sadece ilgili alan icin gecerlidir.Yani DB deki bir kayıt güncelleniyorken güncellenemez
    denilen kolondaki veri güncellenemez.Diğer kolonlar güncellenebilir.
     */

    @Column (
            name = "musteri_adi",//kolonun DB deki adı özelleştiriyor.
            length = 60,//kolonun boyutunu belirliyorum.
            nullable = false,//bu alanın boş gecilmeyeceğini belirliyorum. false-> null gecilemez true-> gecilebilir.
            unique = false, //-> bu alanın benzersiz olup olmadığını belirliyorsunuz. true-> bu kayıttan bir tane daha kayıt edilemez.
            insertable = true,//-> bu alana ekleme yapılmasını kısıtlamak için kullanırız.Eğer false ise bu alana kayit ekleyemezsiniz.
            updatable = false//-> bu alana güncellemesi durumunu kısıtlamak için kullanırız. eğer false ise bu alana güncelleme yapamazsınız.
    )

    String ad;

    @Column(length = 100)
    String soyad;

    /*
    DİKKAT!!!
    mesela veri tabanında alan belli alanların birleştirilmesi çarpılıp bölünmesi gibi durumlar olabilir.
    ancak DB nin şişmemesi için bu alanların DB de tutulmasi istenilmez.Bunu yapabilmek adına bir anatasyon
    kullanılır.@Transient
     */
    @Transient
    String adsoyad;

    /*
    Adres bilgisini detaylandıralım.
     */

    @Column(length = 500)
    String adres;

    /*
    Zaman tanımlamaları özel tanımlanan alanlardır.
    Tarih[Date]->2021-01-01
    Zaman[TIME]->12:00:00
    Tarih ve Zaman[TIMESTAMP] -> 2021-01-01 12:00:00 +3(TIME ZONE)->Zaman damgası
     */

    @Temporal(TemporalType.DATE)//-> bunu belirtmezsek orm aracı bu yazmış olduğumuz aracı tanımalamz ve exception fırlatır.

    Date dogumTarihi;

    @Temporal(TemporalType.TIMESTAMP)
    Date kayitTarihi;

    /*
    DIKKAT!!!!!!!!!!!
    tarih ve zaman ve zaman damgası için ben kullandığım ve tavsiye ettiğim veri tipi
    Long time , date vs...
    Zamanı ms cinsinden tutarız.
     */
    Long createAt;
    /*
    Bir kullanıcıya ait birden fazla telefon numarası olabilir.Bu nedenle burada tek bir değer
    almak yerine bir liste talep edebiliriz.Bu liste islemi ORM aracı icin özel bir tanımdır.Bu nedenle
    özel olarak işaretlenmelidir.
    NOT:Eğer entity içinde bir collection tanımlayacaksanız mutlaka @ElementCollection anatasyonu eklemelisiniz.
     */

    @ElementCollection
    List<String>telefonListesi;

    /*
    Cinsiyet Bilgisi enum olsun
    Enum->Degeri int-> görünen kısım String
     */

    @Enumerated(EnumType.STRING)
    ECinsiyet cinsiyet;

    public ECinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(ECinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
/*
    Her tabloda olmasi gerekli 3 alan bulunur bunlarin üzerinde duralim.
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getM_id() {
        return m_id;
    }

    public void setM_id(Long m_id) {
        this.m_id = m_id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public Date getKayitTarihi() {
        return kayitTarihi;
    }

    public void setKayitTarihi(Timestamp kayitTarihi) {
        this.kayitTarihi = kayitTarihi;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public List<String> getTelefonListesi() {
        return telefonListesi;
    }

    public void setTelefonListesi(List<String> telefonListesi) {
        this.telefonListesi = telefonListesi;
    }
}

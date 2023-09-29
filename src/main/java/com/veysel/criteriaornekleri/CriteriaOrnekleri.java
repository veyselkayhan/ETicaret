package com.veysel.criteriaornekleri;

import com.veysel.repository.entity.Musteri;
import com.veysel.repository.entity.Urun;
import com.veysel.util.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.List;

public class CriteriaOrnekleri {

    //sorguların yapıldığı class burasidir.

    private EntityManager entityManager;

    private CriteriaBuilder criteriaBuilder;

    public CriteriaOrnekleri(){
        /*
        Sorgu işlemlerinde criterler belirlendikten sonra DB üzerinde
        işlemek üzere çalıştırılır.
        Bu işlemlerin yönetimini EntityManager yapar.
         */
        entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        criteriaBuilder= entityManager.getCriteriaBuilder();

    }

    /*
    Select * from tblmusteri ->
     */


    public List <Musteri> findAll(){
        /*
        Kriter belirlerken kullanılacak sınıfın adını vererek
        tanımlama yapıyorsunuz.

        Bir sınıfın içinde bulunan alanlari sorgularla kullanabilmesi için ve
        o alanları sorgulara eklenmesi için tersine mühendislik
        Java Reflection kullanarak yapılmaktadır.Bu nedenle Query olustururken
        kullanılacak sınıf parametre alarak verilir.
         */


        CriteriaQuery<Musteri> criteria = criteriaBuilder.createQuery(Musteri.class);
       //Select işlemi için kullanılacak table belirlenir ve tablodaki alanların hangilerinin kullanılacağını tanımlar
        Root<Musteri>root=criteria.from(Musteri.class);
        //select* işlemini tanımlanıyor.
        criteria.select(root);
        //sorgu çalıştırılıyor.
        List<Musteri> musteriList= entityManager.createQuery(criteria).getResultList();
        musteriList.forEach(System.out::println);
        return  musteriList;
    }

    /*
    Select ad from tbl_musteri
     */

    public List<String> selectOneColumn(){
        //sorgu çalıştıgında String listesi dönecek
        CriteriaQuery<String> criteria=criteriaBuilder.createQuery(String.class);
        Root<Urun>root=criteria.from(Urun.class);//root bunu analiz edicek içinden alıcak
        //select ad kısmını belirlemek lazım
        criteria.select(root.get("ad"));
        List<String> resultList =entityManager.createQuery(criteria).getResultList();
        resultList.forEach(System.out::println);
        return resultList;
    }


    /*
    Select ad tbl_urun where id=?
     */
    public List<String> selectOneColumnById(Long id){
        //sorgu çalıştıgında String listesi dönecek
        CriteriaQuery<String> criteria=criteriaBuilder.createQuery(String.class);
        Root<Urun>root=criteria.from(Urun.class);//root bunu analiz edicek içinden alıcak
        //select ad kısmını belirlemek lazım
        criteria.select(root.get("ad"));
        //where id=? kısmını olusturduk..
        criteria.where(criteriaBuilder.equal(root.get("id"),id));
        List<String> resultList =entityManager.createQuery(criteria).getResultList();
        resultList.forEach(System.out::println);
        return resultList;
    }
    /*
    Bir tabloda select*from tblurun where id=3 yazdığımızda
    geriye dönen değer kaç tanedir?
    Bu değeri javada ne olacak dönmeliyiz?
     */

    public Urun findById(long id){
        CriteriaQuery<Urun>criteria=criteriaBuilder.createQuery(Urun.class);
        Root<Urun>root=criteria.from(Urun.class);
        criteria.select(root);

        criteria.where(criteriaBuilder.equal(root.get("id"),id));

        Urun result=entityManager.createQuery(criteria).getSingleResult();
        System.out.println(result);

        return result;
    }

    /*
    Eger birden fazla alanı okuma ihtiyacı duysakdık ne yapardık?

    select id,ad,fiyat from tblurun

     */

    public List<Object[]> selectManyColumn(){
        CriteriaQuery<Object[]> criteria = criteriaBuilder.createQuery(Object[].class);
        Root<Urun> root = criteria.from(Urun.class);

        Path<Long> id = root.get("id");
        Path<String> ad = root.get("ad");
        Path<BigDecimal> fiyat = root.get("fiyat");

        criteria.select(criteriaBuilder.array(id,ad,fiyat));

        List<Object[]> result = entityManager.createQuery(criteria).getResultList();
        result.forEach(System.out::println);
        return result;

    }

    /*
    select * from tbl_urun where ad like '%n%' and fiyat>600
    urunAdi
    fiyat
    return
     */
    public List<Urun>findAllByNameLikeAndFiyatGre(String urunAdi,BigDecimal fiyat){
        CriteriaQuery<Urun>criteria=criteriaBuilder.createQuery(Urun.class);
        Root<Urun>root=criteria.from(Urun.class);
        criteria.select(root);
        Predicate s1=criteriaBuilder.like(root.get("ad"),urunAdi);
        Predicate s2=criteriaBuilder.greaterThan(root.get("fiyat"),fiyat);
        criteria.where(criteriaBuilder.and(s1,s2));
        List<Urun>result=entityManager.createQuery(criteria).getResultList();
        return result;
    }

}

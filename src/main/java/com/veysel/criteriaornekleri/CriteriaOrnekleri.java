package com.veysel.criteriaornekleri;

import com.veysel.repository.entity.Musteri;
import com.veysel.repository.entity.Urun;
import com.veysel.util.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.text.html.parser.Entity;
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

}

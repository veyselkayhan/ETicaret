package com.veysel.repository;

import com.veysel.repository.entity.Urun;
import com.veysel.util.HibernateUtility;
import com.veysel.util.ICrud;
import com.veysel.util.MyFactoryRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UrunRepository extends MyFactoryRepository <Urun,Long> {

    public UrunRepository() {
        super(new Urun());
    }
}

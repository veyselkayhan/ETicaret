package com.veysel.repository;

import com.veysel.repository.entity.SatisDetay;
import com.veysel.util.MyFactoryRepository;

public class SatisDetayRepository extends MyFactoryRepository<SatisDetay,Long> {

    public SatisDetayRepository() {
        super(new SatisDetay());
    }
}

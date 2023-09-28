package com.veysel.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

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

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
@Table(name = "tbl_SatisDetay")

public class SatisDetay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long id;
    Long satisId;
    Long urunId;
    Integer adet;
    BigDecimal fiyat;
    BigDecimal toplamFiyat;

    @Embedded
    BaseEntity baseEntity;

}

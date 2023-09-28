package com.veysel.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Satis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long id;
    Long musteriid;
    Long date;
    BigDecimal toplamTutar;
    @Embedded
    BaseEntity baseEntity;
}

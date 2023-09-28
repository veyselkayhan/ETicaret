package com.veysel.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "tbl_satis")
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

package com.veysel.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_sepet")
public class Sepet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    long id;
    /*
    Bu bilgi müsteri tablosunda ki müsteri id ile ilişkilendirilmelidir.
     */

    Long musteriId;

    /*
    Key->Urunid,Value->adet
     */
    @ElementCollection
    Map<Long,Integer>urunIds;

    /*
    Urun var ama kac adet var belli degil.
     */




}

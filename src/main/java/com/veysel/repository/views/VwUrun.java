package com.veysel.repository.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VwUrun {
    @Id
    Long id;
    String ad;
    Double fiyat;

}

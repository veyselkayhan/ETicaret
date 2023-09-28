package com.veysel.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Iletisim {

    String cepTelefonu;

    String evTelefonu;

    String isTelefonu;

    String email;

    String website;

    @Column(length = 500)
    String adres;

}

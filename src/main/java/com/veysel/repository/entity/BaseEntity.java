package com.veysel.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder



public class BaseEntity {

    Long createAt;

    Long updateAt;

    Integer state;

    boolean isActive;

}

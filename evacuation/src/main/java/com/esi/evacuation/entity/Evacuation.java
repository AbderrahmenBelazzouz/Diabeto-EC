package com.esi.evacuation.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "EVACUATION_TBL")
public class Evacuation {
    @Id
    @GeneratedValue
    private int id;
    private String objet;
    private String zonetxt;
}

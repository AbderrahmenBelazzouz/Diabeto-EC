package com.esi.orientation.entity;


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
@Table(name = "ORIENTATION_TBL")
public class Orientation {
    @Id
    @GeneratedValue
    private int id;
    //private String titre;
    private String zonetxt;
}

package com.delivery.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "area")
@Getter
@Setter
@ToString
public class Area {

    @Id
    @Column(name = "area_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long areaId;

    @Column(name = "area_nm")
    private String areaNm;

    @Column(name = "area_manager")
    private String areaManager;
}

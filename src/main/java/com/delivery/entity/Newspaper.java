package com.delivery.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity @Table(name = "newspaper")
@Getter @Setter @ToString
public class Newspaper {

    @Id @Column(name = "newspaper_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "newspaper_nm")
    private String newspaperNm;

    @Column(name = "newspaper_desc")
    private String newspaperDesc;

    @Column(name = "count")
    private int count;
}

package com.delivery.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity @Table(name = "news")
@Getter @Setter @ToString
public class News {

    @Id @Column(name = "news_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "news_nm")
    private String newsNm;
}

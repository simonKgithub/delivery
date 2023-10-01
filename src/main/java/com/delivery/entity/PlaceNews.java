package com.delivery.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity @Table(name = "place_news")
@Getter @Setter @ToString
public class PlaceNews {

    @Id @Column(name = "place_news_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "place_news_nm")
    private String placeNewsNm;

    @Column(name = "place_news_desc")
    private String placeNewsDesc;

    @Column(name = "place_new_count")
    private int placeNewsCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "news_id")
    private News news;
}

package com.delivery.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name = "place")
@Getter @Setter @ToString
public class Place {

    @Id @Column(name = "place_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "place_nm")
    private String placeNm;

    @Column(name = "place_desc")
    private String placeDesc;

    @Column(name = "order_num")
    private int orderNum;

    @CreatedDate
    private LocalDateTime regTime;

    @LastModifiedDate
    private LocalDateTime updateTime;
}

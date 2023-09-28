package com.delivery.entity;

import com.delivery.constant.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity @Table(name = "place")
@Getter @Setter @ToString
public class Place {

    @Id @Column(name = "place_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "x_point")
    private String xPoint;

    @Column(name = "y_point")
    private String yPoint;

    @Column(name = "place_nm")
    private String placeNm;

    @Column(name = "place_desc")
    private int placeDesc;

    @Column(name = "delivery_order")
    private int deliveryOrder;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "newspaper_id")
    private List<Newspaper> newspaperList;

    @CreatedDate
    private LocalDateTime regTime;

    @LastModifiedDate
    private LocalDateTime updateTime;
}

package com.delivery.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class NewspaperFormDto {
    private String newspaperNm;

    private String newspaperDesc;

    private int count;
}

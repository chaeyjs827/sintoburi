package com.sintoburi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class TestDto {
    private String name;
    private String product;
    private Integer price;
    private String address;
    private String img;
    private LocalDateTime orderedTime;
}

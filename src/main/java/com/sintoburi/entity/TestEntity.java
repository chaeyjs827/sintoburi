package com.sintoburi.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class TestEntity {
	private Long id;
	private String name;
	private String product;
	private Integer price;
	private String address;
	private LocalDateTime orderedTime;
}

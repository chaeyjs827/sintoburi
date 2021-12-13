package com.sintoburi.filter;

import lombok.Data;

/**
 * @author seongnamfc
 * @package com.sintoburi.filter
 * @file CustomerFilterDto
 * @description
 * @date 2021/12/13
 */
@Data
public class CustomerFilterDto {

    private Long id;
    private String startDate;
    private String endDate;
    private String orderBy;

}

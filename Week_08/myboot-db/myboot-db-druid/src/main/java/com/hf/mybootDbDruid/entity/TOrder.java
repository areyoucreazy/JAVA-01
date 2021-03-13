package com.hf.mybootDbDruid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hfzhang
 * @date 2021/3/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TOrder {
    private Integer userId;
    private String status;
}

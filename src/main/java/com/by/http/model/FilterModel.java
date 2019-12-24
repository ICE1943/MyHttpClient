package com.by.http.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author idea
 * @date 2019/4/30
 * @Version V1.0
 */
@Data
@AllArgsConstructor
public class FilterModel {

    private int order;

    private String name;

    private Object filter;
}

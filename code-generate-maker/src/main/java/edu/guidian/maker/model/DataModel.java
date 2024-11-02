package edu.guidian.maker.model;

import lombok.Data;

@Data
public class DataModel {

    /**
     * 是否输出循环
     */
    private boolean loop;

    /**
     * 作者
     */
    private String author;

    /**
     * 输出信息
     */
    private String outputText = "sum = ";
}

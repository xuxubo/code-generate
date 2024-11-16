package edu.guidian.maker.meta;

import lombok.Getter;

/**
 * 文件类型
 */
@Getter
public enum FileTypeEnum {

    DIR("目录", "dir"),
    FILE("文件", "file");

    private final String text;

    private final String value;

    FileTypeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

}

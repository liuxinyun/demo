package com.lxy.springbootdemo.enums;

/**
 * @author 刘新运
 * @date 2019/8/8 11:06
 */
public enum SexEnum {
    /**
     * 性别枚举
     */
    UNKNOWN(0, "未知"),
    MALE(1, "男"),
    FEMALE(2, "女")
    ;

    private int value;
    private String desc;

    SexEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static SexEnum parse(int value) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.value == value) {
                return sexEnum;
            }
        }
        return UNKNOWN;
    }

}

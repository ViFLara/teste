package com.teste.teste.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TopicStatus {

    NOT_ANSWERED(1),
    NOT_SOLVED(2),
    SOLVED(3),
    CLOSED(4);

    private int code;

    public static TopicStatus valueOf(int code) {
        for (TopicStatus value : TopicStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TopicStatus code");
    }
}

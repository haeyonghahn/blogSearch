package com.example.blog.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INVALID_INPUT_VALUE(400, "BLOG_001", "잘못된 입력 값입니다."),
    ILLEGAL_ARGUMENT(400, "BLOG_002", "유효하지 않은 파라미터가 있습니다."),
    EXCEPTION(500, "BLOG_003", "서버에서 요청 처리 중 에러가 발생했습니다.");

    private final String code;
    private final String message;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}

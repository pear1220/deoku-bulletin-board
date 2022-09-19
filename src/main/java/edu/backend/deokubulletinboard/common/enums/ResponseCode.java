package edu.backend.deokubulletinboard.common.enums;

import lombok.Getter;

/**
 * packageName     : edu.backend.deokubulletinboard.common.enums
 * fileName        : ResponseCode
 * author          : jungwon.lee
 * date            : 2022-09-16
 * version         : v0.1
 */
@Getter
public enum ResponseCode {

    OK(200, "OK"),
    BAD_REQUEST(400, "badRequest"),
    NOT_AUTHRORIZATION(401, "noAuthrorization"),
    ACCESS_DENY(403, "accessDeny"),
    NOT_FOUND(404, "notFound"),
    SERVER_ERROR(500, "internalServerError");

    private final int code;
    private final String description;

    ResponseCode(int code, String description) {
        this.code = code;
        this.description = description;
    }
}

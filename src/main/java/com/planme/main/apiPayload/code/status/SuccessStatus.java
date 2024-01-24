package com.planme.main.apiPayload.code.status;

import com.planme.main.apiPayload.code.BaseCode;
import com.planme.main.apiPayload.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    // 일반적인 응답
    _OK(HttpStatus.OK, "COMMON200", "성공입니다."),

    // 멤버 관련 응답
    MEMBER_FOUND(HttpStatus.OK,"MEMBER2001", "회원을 조회했습니다."),

    // 카테고리 관련 응답
    CATEGORY_CREATED(HttpStatus.OK,"CATEGORY2001","카테고리가 추가되었습니다."),
    CATEGORY_DELETED(HttpStatus.OK,"CATEGORY2002","카테고리가 삭제되었습니다."),
    CATEGORY_UPDATED(HttpStatus.OK,"CATEGORY2003","카테고리가 수정되었습니다."),
    CATEGORY_STATUS_CHANGED(HttpStatus.OK,"CATEGORY2004","카테고리 숨김 설정이 변경되었습니다."),
    CATEGORY_FOUND(HttpStatus.OK,"CATEGORY2005","카테고리를 조회했습니다.")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
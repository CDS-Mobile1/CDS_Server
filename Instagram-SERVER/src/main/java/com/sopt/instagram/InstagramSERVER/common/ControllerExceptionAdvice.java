package com.sopt.instagram.InstagramSERVER.common;

import com.sopt.instagram.InstagramSERVER.common.dto.ApiResponseDto;
import com.sopt.instagram.InstagramSERVER.exception.BusinessException;
import com.sopt.instagram.InstagramSERVER.exception.ErrorStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ControllerExceptionAdvice {

    /*
     * 400 BAD_REQUEST
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDto handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ApiResponseDto.error(ErrorStatus.VALIDATION_EXCEPTION);
    }

    @ExceptionHandler(BusinessException.class)
    protected ApiResponseDto handleBusinessException(final BusinessException e) {
        return ApiResponseDto.error(e.getErrorStatus());
    }
}

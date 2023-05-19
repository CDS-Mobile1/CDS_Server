package com.sopt.instagram.InstagramSERVER.common.exception;

import com.sopt.instagram.InstagramSERVER.common.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice {

    /*
     * 400 BAD_REQUEST
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ApiResponseDto handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        return ApiResponseDto.error(ErrorStatus.VALIDATION_EXCEPTION);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingRequestHeaderException.class)
    protected ApiResponseDto handleMissingRequestHeaderException(final MissingRequestHeaderException e) {
        return ApiResponseDto.error(ErrorStatus.MISSING_REQUEST_HEADER);
    }

    @ExceptionHandler(BusinessException.class)
    protected ApiResponseDto handleBusinessException(final BusinessException e) {
        return ApiResponseDto.error(e.getErrorStatus());
    }
}

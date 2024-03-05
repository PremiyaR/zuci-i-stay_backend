package com.zuci.ZuciIStay.exception;

import com.zuci.ZuciIStay.model.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
@Configuration
public class GlobalExceptionHandler {
    @ExceptionHandler(NoHotelPresentException.class)
    public String hotelException() {
        return "No Hotel Found!";
    }
    @ExceptionHandler(NoRoomAvailableException.class)
    public String roomException(){
        return "No Room Available!";
    }
    @ExceptionHandler(HotelBookingNotFoundException.class)
    public ApiError add(HotelBookingNotFoundException e, HttpServletRequest request)
    {
        List<String> stringList=new ArrayList<>();
        stringList.add(e.getMessage());
        ApiError apiError=ApiError.builder().Path(request.getRequestURI())
                .message(stringList.toString())
                .date(new java.util.Date())
                .build();
        return apiError;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError show(HttpServletRequest request, BindingResult bindingResult)
    {
        List<FieldError> field=bindingResult.getFieldErrors();
        StringBuilder sb=new StringBuilder();
        for(FieldError f:field)
        {
            sb.append(f.getField()+":"+f.getDefaultMessage());
        }
        ApiError apiError= ApiError.builder().Path(request.getRequestURI()).message(sb.toString()).date(new Date()).build();
        return apiError;
    }
    @ExceptionHandler(NoBookingRecordsFoundException.class)
    public ApiError add(NoBookingRecordsFoundException e, HttpServletRequest request){
        List<String> stringList=new ArrayList<>();
        stringList.add(e.getMessage());
        ApiError apiError=ApiError.builder().Path(request.getRequestURI())
                .message(stringList.toString())
                .date(new Date())
                .build();
        return apiError;
    }
}

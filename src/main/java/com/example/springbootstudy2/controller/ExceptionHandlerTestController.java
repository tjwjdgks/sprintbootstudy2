package com.example.springbootstudy2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionHandlerTestController {
    @GetMapping("/exception")
    public String exception(){
        throw new SampleException();
    }
    // ExceptionHandlerTestController 안에서 SampleException이 발생했을 경우 핸들링

    @ExceptionHandler(SampleException.class)
    // ResponseEntity 감싸지 않는 방법
    // app에서 만든 커스텀 error 정보를 담고 있는 class가 있으면 좋음
    // 메서드 파리미터로 해당 exception을 받아 올 수 있음
    public @ResponseBody AppError sampleError(SampleException e){
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("IDK");
        return appError;
    }


    //public @RequestBody ResponseEntity<>


    private class SampleException extends RuntimeException {

    }
    // app의 특정 에러를 담고 있는 class
    private class AppError {
        private String message;
        private String reason;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }
}

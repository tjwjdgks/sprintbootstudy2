package com.example.springbootstudy2.Listener;


import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// 어떤 이벤트의 listener를 만들지
// bean으로 등록시 해당하는 event에 대한 Listener 알아서 실행 해준다
// event의 시점이 중요 application context 이후의 event들은 자동 호출
// but 이전의 event는 listener bean으로 등록해도 자동 동작되지 않음 직접 등록해야한다
public class SimpleListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        System.out.println("==========================");
        System.out.println("Application Start");
        System.out.println("==========================");

    }
}

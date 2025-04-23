package com.study.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@Component
@Slf4j
@EnableAsync  // 비동기적으로 처리하도록 제공하는 스프링 어노테이션
              // 각기 다른 쓰레드에서 실행된다.
public class Scheduler {
    /* @Scheduled(fixedRate = 1000)
    public void task1() {
        // currentTimeMillis() : time stamp - 1970.00.00.00.00부터 시작된 밀리초
        // log.info("FixedRate task - {}", System.currentTimeMillis() / 1000);
        log.info("FixedRate task - {}", LocalTime.now());
    } */

    /* @Scheduled(fixedRate = 1000)
    public void task2() throws InterruptedException {
        log.info("FixedRate task2 - {}", LocalTime.now());
        Thread.sleep(5000);  // 5초동안 멈춤
        log.info("dead!");
    } */

    @Scheduled(fixedRate = 1000*60*60*24, initialDelay = 5000)
    public void task3() throws InterruptedException {
        log.info("FixedRate task3 - {}", LocalTime.now());
        Thread.sleep(5000);  // 5초동안 멈춤
        log.info("dead!");
    }
    // @Scheduled(cron = "0 28 10 21 * ?")
    // @Scheduled(cron = "* * * * * *")
    @Scheduled(cron = "0 45 11 * * *")
    public void task4() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String strDate = sdf.format(now);
        log.info("cron task - {}", strDate);
    }
}

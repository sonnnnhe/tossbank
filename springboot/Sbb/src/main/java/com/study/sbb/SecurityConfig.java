package com.study.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration  // 스프링의 환경 설정 파일임을 의미하는 애너테이션
@EnableWebSecurity  // 모든 요청 url이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션
                    // 내부적으로 SecurityFilterChain 클래스 동작
                    // => 모든 요청 URL에 이 클래스가 필터로 적용되어 URL별로 특별한 설정을 할 수 있게 된다.
                    // 스프링 시큐리티의 세부 설정은 @Bean 애너테이션을 통해 SecurityFilterChain 빈을 생성하여 설정할 수 있다.
public class SecurityConfig {
    // 빈 : 스프링에 의해 생성 또는 관리되는 객체
    //      컨트롤러, 서비스, 리포지터리 등
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 인증되지 않은 모든 페이지의 요청을 허락한다는 의미
        http
                .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll());
        return http.build();
    }
}

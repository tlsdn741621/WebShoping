package com.busanit501.webshoping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // 비밀번호 암호화에 사용될 Bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // ✅ 보안 필터 체인 설정 (접근 권한, 로그인/로그아웃 설정 등)
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // 개발 단계에서는 CSRF 비활성화 (운영에선 true)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/login", "/css/**", "/js/**", "/images/**").permitAll() // 로그인 없이 접근 허용
                        .anyRequest().authenticated() // 그 외 모든 요청은 인증 필요
                )
                .formLogin(form -> form
                        .loginPage("/login") // 커스텀 로그인 페이지 경로 (없으면 기본 로그인 페이지 사용됨)
                        .defaultSuccessUrl("/", true) // 로그인 성공 시 이동할 기본 경로
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout") // 로그아웃 성공 시 이동할 경로
                        .invalidateHttpSession(true)
                );

        return http.build();
    }
}

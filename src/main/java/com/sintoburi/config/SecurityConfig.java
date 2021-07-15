package com.sintoburi.config;

//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//import lombok.AllArgsConstructor;
//
//@Configuration
//@EnableWebSecurity
//@AllArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	http.authorizeRequests()
//	    	.antMatchers("/**").permitAll()
//		    .antMatchers("/h2-console/**").permitAll()
//	    .and()
//		// h2-console 페이지 처리
//			.csrf().disable()
//			.headers().frameOptions().disable();;
//	}
//	/*
//	private MemberService memberService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception
//    {
//        // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
//        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////    	http.authorizeRequests().antMatchers("/").permitAll();
//        http.authorizeRequests()
//		    // 페이지 권한 설정
//		    .antMatchers("/admin/**").hasRole("ADMIN")
//	    	.antMatchers("/user/myinfo").hasRole("MEMBER")
//		    .antMatchers("/**").permitAll()
//		    // h2-console 페이지 처리
//		    .antMatchers("/h2-console/**").permitAll()
//		.and() // 로그인 설정
//		    .formLogin()
//		    .loginPage("/user/login")
//		    .defaultSuccessUrl("/user/login/result")
//		    .permitAll()
//		.and() // 로그아웃 설정
//		   .logout()
//		    .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
//		    .logoutSuccessUrl("/user/logout/result")
//		    .invalidateHttpSession(true)
//		.and()
//		    // 403 예외처리 핸들링
//		   .exceptionHandling().accessDeniedPage("/user/denied")
//		.and()
//			// h2-console 페이지 처리
//			.csrf().disable()
//			.headers().frameOptions().disable();
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
//    }
//
//    */
//}

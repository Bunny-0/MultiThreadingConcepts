//package org.example.Revision.OOP;
//
//import java.beans.BeanProperty;
//
//public class SecurityConfig {
//
//
//    @Autowired
//    public void authManager(AuthenticationManagerBuilder builder) throws Exception {
//       auth.userDetailsService(userDetailService)
//               .passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }
//
//    @BeanProperty
//    public SecurityFilterChain security(HttpSecurity http){
//        http.authorizeHttpRequests((res)->{
//            res.antMatcher("/hi").permitAll().anyRequest().authenticated();
//        }).formLogn()
//                http.build();
//    }
//
//
//}

package br.com.bulovask.atarefados;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //Helder íamos implementar a autenticação, na verdade, eu tentei e estava indo mais ou menos bem, mas como eu
        //não estava entendendo muita coisa, resolvi remover de vez para não atrasar a entrega :/, mas é a vida...
        //maaas pelo menos as senhas estão sendo salvas com um pouco de segurança kkkk
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

package my.home.catalogue.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityBeans {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
//                                .requestMatchers(HttpMethod.POST, "/catalogue-api/products")
//                                .hasAnyAuthority("SCOPE_edit_catalogue")
//                                .requestMatchers(HttpMethod.PATCH, "/catalogue-api/products/{productId:\\d}")
//                                .hasAnyAuthority("SCOPE_edit_catalogue")
//                                .requestMatchers(HttpMethod.DELETE, "/catalogue-api/products/{productId:\\d}")
//                                .hasAnyAuthority("SCOPE_edit_catalogue")
//                                .requestMatchers(HttpMethod.GET)
//                                .hasAnyAuthority("SCOPE_view_catalogue")
//                        .anyRequest().denyAll()

                        //Врменно....
                                .anyRequest().permitAll()

                )
                .sessionManagement(sm -> sm
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(
                        oauth2RS -> oauth2RS.jwt(Customizer.withDefaults())
                )
                .build();
    }
}

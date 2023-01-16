
  package com.microservices.apigatewayservice.config; import
  org.springframework.context.annotation.Bean; import
  org.springframework.context.annotation.Configuration; import
  org.springframework.security.config.annotation.web.reactive.
  EnableWebFluxSecurity; import
  org.springframework.security.config.web.server.ServerHttpSecurity; import
  org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
  
  @Configuration
  
  @EnableWebFluxSecurity 
  public class SecurityConfig {
  
  @Bean public SecurityWebFilterChain
  springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
  serverHttpSecurity .csrf().disable()
  .authorizeExchange(exchange ->
  exchange.pathMatchers("/eureka/**")
  .permitAll() .anyExchange()
  .authenticated())
  .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt)
  .cors(cors -> cors.disable());
  return serverHttpSecurity.build(); }

 
  }
 
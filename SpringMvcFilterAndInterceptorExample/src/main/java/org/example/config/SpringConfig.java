package org.example.config;

import org.example.message.MessageGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class SpringConfig {
// предположим что сесия это один пользователь и пока он ее не покинул - это будет тот же самый
    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
//    @SessionScope
    public MessageGenerator sessionMessageGenerator() {
        return new MessageGenerator();
    }

}

package com.startup.loginservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Slf4j
@Component
public class BasicAuthHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy;

    @PostConstruct
    public void init(){
        redirectStrategy = new DefaultRedirectStrategy();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(
                auth -> {
                    switch (auth.getAuthority()) {
                        case "ROLE_USER":
                            try {
                                redirectStrategy.sendRedirect(request, response, "/success");
                            } catch (Exception e) {
                                log.warn("FAILED TO REDIRECT USER TO MAIN PAGE");
                            }
                            break;
                        case "ADMIN":
                            try {
                                redirectStrategy.sendRedirect(request, response, "/admin");
                            } catch (Exception e) {
                                log.warn("FAILED TO LOGIN AS AN ADMIN");
                            }
                            break;
                        default:
                            throw new IllegalStateException();
                    }
                }
        );
    }
}

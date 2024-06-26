package com.project.shop.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.shop.customer.dto.AuthDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("--- LoginSuccessHandler ---");
        AuthDTO authDTO =  (AuthDTO)authentication.getPrincipal();
        response.setContentType("application/json;charset=UTF-8");

        Map<String, Object> claims = authDTO.getClaims();

        response.getWriter().write(objectMapper.writeValueAsString(claims));
    }
}

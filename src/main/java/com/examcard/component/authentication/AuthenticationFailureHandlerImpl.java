package com.examcard.component.authentication;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(jakarta.servlet.http.HttpServletRequest request,
			jakarta.servlet.http.HttpServletResponse response, AuthenticationException exception)
			throws IOException, jakarta.servlet.ServletException {
		String loginId = request.getParameter("mailAddress");
		log.info("ログインに失敗しました。ログインID：" + loginId + " エラーメッセージ：" + exception.getMessage());
		response.sendRedirect(request.getContextPath() + "/login?mailAddress=" + loginId);
	}
}

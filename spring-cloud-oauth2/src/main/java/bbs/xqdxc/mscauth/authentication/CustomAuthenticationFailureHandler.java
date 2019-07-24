package bbs.xqdxc.mscauth.authentication;

import bbs.xqdxc.mscauth.properties.LoginType;
import bbs.xqdxc.mscauth.properties.SecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("authenticationFailureHandler")
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {
        // TODO: Auto-generated method stub
        logger.info("login failed");

        super.onAuthenticationFailure(request, response, exception);

//        if(LoginType.JSON.equals(securityProperties.getWeb().getLoginType())) {
//            // 设置状态码 500
//            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//            // 设置contentType
//            response.setContentType("application/json;charset=UTF-8");
//            response.getWriter().write(objectMapper.writeValueAsString(exception));
//        } else {
//            super.onAuthenticationFailure(request, response, exception);
//        }

    }
}

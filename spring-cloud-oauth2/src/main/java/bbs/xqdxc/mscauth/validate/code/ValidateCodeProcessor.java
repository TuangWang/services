package bbs.xqdxc.mscauth.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 校验码处理器，封装不同的校验码
 *
 * @author wangxiaofeng
 * */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     * */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建校验码
     * @param request
     * @throws Exception
     * */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     *
     * @param servletWebRequest
     * @throws Exception
     */
    void validate(ServletWebRequest servletWebRequest);


}

package bbs.xqdxc.mscauth.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * The interface Validate code repository.
 */
public interface ValidateCodeRepository {


    /**
     * 保存验证码.
     *
     * @param request the request
     * @param code    the code
     * @param type    the type
     */
    void save(ServletWebRequest request, ValidateCode code, ValidateCodeType type);


    /**
     * 获取验证码.
     *
     * @param request the request
     * @param type    the type
     * @return the validate code
     */
    ValidateCode get(ServletWebRequest request, ValidateCodeType type);

    /**
     * 移除验证码.
     *
     * @param request the request
     * @param type    the type
     */
    void remove(ServletWebRequest request, ValidateCodeType type);
}

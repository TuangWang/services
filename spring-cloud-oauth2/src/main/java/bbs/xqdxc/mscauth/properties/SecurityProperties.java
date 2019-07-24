package bbs.xqdxc.mscauth.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="bbs.xqdxc")
public class SecurityProperties {
    /**
     * 图形验证码配置项
     * ValidateCodeProperties code: bbs.xqdxc.code.image 来进行相关配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    /**
     * OAuth2 配置
     * */

    private OAuth2Properties oauth2 = new OAuth2Properties();

    public OAuth2Properties getOauth2() {
        return oauth2;
    }

    public void setOauth2(OAuth2Properties oauth2) {
        this.oauth2 = oauth2;
    }
}

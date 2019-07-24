package bbs.xqdxc.mscauth.validate.code;

import bbs.xqdxc.mscauth.properties.SecurityProperties;
import bbs.xqdxc.mscauth.validate.code.image.ImageCodeGenerator;
import bbs.xqdxc.mscauth.validate.code.sms.DefaultSmsCodeSender;
import bbs.xqdxc.mscauth.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 如果Spring容器中有名称为imageCodeGenerator的Bean，将不会初始化下面的Bean了
     * */
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
        imageCodeGenerator.setSecurityProperties(securityProperties);
        return imageCodeGenerator;
    }


    @Bean
    @ConditionalOnMissingBean(SmsCodeSender.class)
    public SmsCodeSender smsCodeSender() {
        return new DefaultSmsCodeSender();
    }
}

package bbs.xqdxc.mscauth.validate.code.sms;

public class DefaultSmsCodeSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("发送短信验证码" + mobile + " : " + code);
    }
}

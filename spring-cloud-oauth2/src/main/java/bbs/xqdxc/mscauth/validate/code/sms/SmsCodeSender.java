package bbs.xqdxc.mscauth.validate.code.sms;

public interface SmsCodeSender {
    void send(String mobile, String code);
}

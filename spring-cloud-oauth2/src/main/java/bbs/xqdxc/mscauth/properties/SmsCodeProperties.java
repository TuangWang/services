package bbs.xqdxc.mscauth.properties;

public class SmsCodeProperties {
    // 验证码长度
    private int length = 6;
    // 验证码过期时间
    private int expiredIn = 60;

    private String url;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpiredIn() {
        return expiredIn;
    }

    public void setExpiredIn(int expiredIn) {
        this.expiredIn = expiredIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package bbs.xqdxc.mscauth.properties;

public class ImageCodeProperties extends SmsCodeProperties{

    public ImageCodeProperties(){
        // 设置图片验证码默认长度
        setLength(4);
    }

    // 验证码高度
    private int height = 23;
    // 验证码宽度
    private int width = 67;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}

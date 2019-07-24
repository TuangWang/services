package bbs.xqdxc.mscauth.validate.code.image;


import bbs.xqdxc.mscauth.validate.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ImageCode extends ValidateCode {
    // 图片
    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, LocalDateTime expiredTime) {
        super(code, expiredTime);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, int expiredIn) {
        super(code, expiredIn);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }


}

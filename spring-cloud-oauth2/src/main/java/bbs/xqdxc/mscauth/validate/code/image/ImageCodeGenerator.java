package bbs.xqdxc.mscauth.validate.code.image;

import bbs.xqdxc.mscauth.properties.SecurityProperties;
import bbs.xqdxc.mscauth.validate.code.ValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class ImageCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    static Random r = new Random();

    @Override
    public ImageCode generate(ServletWebRequest request) {
        // 参数可配置
        int width = ServletRequestUtils.getIntParameter(
                request.getRequest(),
                "width",
                securityProperties.getCode().getImage().getWidth()
        );
        int height = ServletRequestUtils.getIntParameter(
                request.getRequest(),
                "height",
                securityProperties.getCode().getImage().getHeight()
        );

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        Random random = new Random();

        g.setColor(getRandColor(200, 250));
        g.fillRect(0,0, width, height);
        Font mFont = new Font("Arial", Font.BOLD|Font.ITALIC, 20);
        g.setFont(mFont);
        g.setColor(getRandColor(160, 200));

        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);

            int x1 = random.nextInt(12);
            int y1 = random.nextInt(12);

            g.drawLine(x, y, x+x1, y+y1);
        }

        String sRand = "";

        // 通过配置获取需要生成的验证码长度
        for (int i=0; i<securityProperties.getCode().getImage().getLength(); i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13*i+6, 20);
        }
        g.dispose();

        // 获取配置过期时间
        return new ImageCode(image, sRand, securityProperties.getCode().getImage().getExpiredIn());
    }

    public static Color getRandColor(int min, int max) {

        if (min > 255)
            min = 255;
        if (max > 255)
            max = 255;
        int red = r.nextInt(max - min) + min;
        int green = r.nextInt(max - min) + min;
        int blue = r.nextInt(max - min) + min;
        return new Color(red, green, blue);
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}

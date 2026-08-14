package com.heaven7.gui.api;

import com.heaven7.gui.Api;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ImageViewApi extends BaseApi<JLabel> implements Api.IImage{

    private final ImageIcon icon = new ImageIcon();

    public ImageViewApi() {
        super(new JLabel());
        addMouseClickListener();
    }

    @Override
    public void setBounds(int x, int y, int w, int h) {
        getActor().setBounds(x, y, w, h);
    }

    @Override
    public void setImageFile(String path) {
        Rectangle bounds = getActor().getBounds();
        try {
            BufferedImage image = ImageIO.read(new File(path));
            BufferedImage img1 = resize(image, bounds.width, bounds.height);
            icon.setImage(img1);
        } catch (IOException e) {
            System.err.println("path: " + path);
            throw new RuntimeException(e);
        }
        getActor().setIcon(icon);
    }
    private static BufferedImage resize(BufferedImage source, int targetW,
                                        int targetH) {
        // targetW，targetH分别表示目标长和宽
        int type = source.getType();
        BufferedImage target = null;
        double sx = (double) targetW / source.getWidth();
        double sy = (double) targetH / source.getHeight();
        // 这里想实现在targetW，targetH范围内实现等比缩放。如果不需要等比缩放
        // 则将下面的if else语句注释即可
        if (sx < sy) {
            sx = sy;
            targetW = (int) (sx * source.getWidth());
        } else {
            sy = sx;
            targetH = (int) (sy * source.getHeight());
        }
        if (type == BufferedImage.TYPE_CUSTOM) { // handmade
            ColorModel cm = source.getColorModel();
            WritableRaster raster = cm.createCompatibleWritableRaster(targetW,
                    targetH);
            boolean alphaPremultiplied = cm.isAlphaPremultiplied();
            target = new BufferedImage(cm, raster, alphaPremultiplied, null);
        } else
            target = new BufferedImage(targetW, targetH, type);
        Graphics2D g = target.createGraphics();
        // smoother than exlax:
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
        g.dispose();
        return target;
    }
}

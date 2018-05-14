/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author Adrian Simionescu
 */
public class FancyScrollbar
    extends BasicScrollBarUI
{
    private Image imageThumb, imageTrack;
    private JButton b = new JButton() {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(0, 0);
        }
    };
    
    public FancyScrollbar(int width, Color colorThumb, Color colorTrack)
    {
        //imageThumb = ImageIO.read(new File("./resources/img/thumb.png"));
        //imageTrack = ImageIO.read(new File("./resources/img/track.png"));

        imageThumb = FauxImage.create(width, 6, colorThumb);
        imageTrack = FauxImage.create(width, 6, colorTrack);
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds)
    {
        int w = thumbBounds.width;
        int h = thumbBounds.height;
        
        g.translate(thumbBounds.x, thumbBounds.y);
        g.drawRect(0, 0, w - 2, h - 1);
        AffineTransform transform = AffineTransform.getScaleInstance((double)w/imageThumb.getWidth(null),(double)h/imageThumb.getHeight(null));
        
        ((Graphics2D)g).drawImage(imageThumb, transform, null);
        
        g.translate( -thumbBounds.x, -thumbBounds.y );
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds)
    {
        int w = trackBounds.width;
        int h = trackBounds.height;
        
        g.translate(trackBounds.x, trackBounds.y);
        ((Graphics2D)g).drawImage(imageTrack,AffineTransform.getScaleInstance(1,(double)h/imageTrack.getHeight(null)),null);
        g.translate( -trackBounds.x, -trackBounds.y );
    }
    
    @Override
    protected JButton createDecreaseButton(int orientation)
    {
        return b;
    }

    @Override
    protected JButton createIncreaseButton(int orientation)
    {
        return b;
    }
    
    
    private static class FauxImage
    {
        static public Image create(int w, int h, Color c)
        {
            BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.setPaint(c);
            g2d.fillRect(0, 0, w, h);
            g2d.dispose();
            return bi;
        }
    }
}

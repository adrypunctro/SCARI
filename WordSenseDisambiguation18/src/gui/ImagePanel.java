/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Adrian Simionescu
 */
public class ImagePanel
    extends JPanel
{
    public ImagePanel()
    {
        
    }
    
    public ImagePanel(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    
    public ImagePanel(BufferedImage imageBuff)
    {
        changePic(imageBuff);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
    }
    
    public void changePic(BufferedImage imageBuff)
    {
        if (imageBuff != null)
        {
            BufferedImage resized = resize(imageBuff, width, height);
            image = resized;
            repaint();
        }
    }
    
    public static BufferedImage resize(BufferedImage img, int newW, int newH)
    { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }  
    
    public void setDimension(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    
    private BufferedImage image;
    private int width, height;
}

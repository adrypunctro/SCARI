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
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author asimionescu
 */
public class RoundedPanel
    extends JPanel
{
    private int radiusTopLeft = 0;
    private int radiusTopRight = 0;
    private int radiusBottomRight = 0;
    private int radiusBottomLeft = 0;
    private int strokeSize = 0;
    private Color borderColor;
    
    public RoundedPanel()
    {
       super();
       setOpaque(false);
   }
    
    public void setBorderRadius(int radius)
    {
        radiusTopLeft = radius;
        radiusTopRight = radius;
        radiusBottomRight = radius;
        radiusBottomLeft = radius;
    }
    
    public void setBorderRadius(int topLeft, int topRight, int bottomRight, int bottomLeft)
    {
        radiusTopLeft = topLeft;
        radiusTopRight = topRight;
        radiusBottomRight = bottomRight;
        radiusBottomLeft = bottomLeft;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Dimension arcs = new Dimension(radiusTopLeft,radiusTopLeft);// Border corners arcs {width,height}
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        
        //Sets antialiasing if HQ.
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draws the rounded panel with borders.
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
        if (strokeSize > 0)// NOT IMPLEMENTED
        {
            graphics.setColor(borderColor);
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border
        }
    }
}

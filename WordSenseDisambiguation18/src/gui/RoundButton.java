/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.border.Border;

/**
 *
 * @author Adrian Simionescu
 */
public class RoundButton
    extends JButton
{
    private final int radius;
    private Color colFill;
    private Color colBorder;

    public RoundButton(String label, int radius)
    {
        super(label);
        
        this.radius = radius;
        
        // These statements enlarge the button so that it 
        // becomes a circle rather than an oval.
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);

        // This call causes the JButton not to paint 
       // the background.
        // This allows us to paint a round background.
        setContentAreaFilled(false);
    }

    public void setBorderColor(Color col)
    {
        colBorder = col;
        revalidate();
    }
    
    @Override
    public void paintBorder(Graphics g)
    {
        g.setColor(colBorder);
        g.drawRoundRect(0, 0, getSize().width-1, getSize().height-1, radius, radius);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            // You might want to make the highlight color 
            // a property of the RoundButton class.
            g.setColor(colFill);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getSize().width-1, getSize().height-1, radius, radius);
        
        super.paintComponent(g);
    }
    
    // Hit detection.
  Shape shape;
  @Override
  public boolean contains(int x, int y) {
    // If the button has changed size, 
    // make a new shape object.
    if (shape == null || !shape.getBounds().equals(getBounds())) {
       shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
    }
    return shape.contains(x, y);
  }
}
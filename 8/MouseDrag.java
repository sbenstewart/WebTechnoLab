/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.applet.Applet;
import java.awt.event.*;
import java.awt.*;


/**
 *
 * @author sf52
 */
public class MouseDrag extends Applet implements MouseMotionListener {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    public void init() {
       addMouseMotionListener(this);
       setBackground(Color.red);
    }
    public void mouseDragged(MouseEvent me)
    {
        Graphics g=getGraphics();
        g.setColor(Color.white);
        g.fillOval(me.getX(),me.getY(),20,20);
    }
    public void mouseMoved(MouseEvent me){}

    // TODO overwrite start(), stop() and destroy() methods
}

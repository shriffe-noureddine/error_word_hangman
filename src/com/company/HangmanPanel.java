
package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class HangmanPanel extends JPanel   implements KeyListener
{

    char[]  txt     =   "hello world".toCharArray();
    char[]  Z       =   "-----------".toCharArray();
    int     errors  =   0;

    public HangmanPanel()
    {
        setFocusable(true);
        grabFocus();
        addKeyListener(this);
        setBackground(Color.yellow);
    }


    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D  G2  =   (Graphics2D) g;

        G2.drawString(new String(Z),150,350);
        G2.drawLine(100,350,100,100);
        G2.drawLine(100,100,200,100);
        G2.drawLine(200,100,200,120);
        G2.drawString("Errors : "+errors, 20, 20);

        // CHANGE THE FOLLOWING CODE

        if  (errors>0)  {
            System.out.println("draw Head");
            G2.drawOval(175, 120, 50,50);
        }
        if  (errors>1)  {
            G2.drawLine(200,170,200,250);
        }
        if  (errors>2)  {
            G2.drawLine(200,200,170,230);
        }
        if  (errors>3) {
            G2.drawLine(200,200,240,230);
        }
        if  (errors>4)  {
            G2.drawLine(200,250,170,280);
        }
        if  (errors>5) {
            G2.drawLine(200,250,240,280);
            setBackground(Color.red);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e)
    {
        char c  =   e.getKeyChar();
        System.out.println("key "+c);
        boolean found   =   false;
        for(int i=0 ; i<txt.length ; i++)
        {
            if (c==txt[i])  {Z[i]=c; found=true;}
        }
        if(!found)  errors++;
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}

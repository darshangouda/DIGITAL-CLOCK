package date;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
 public class DigitalClock extends JApplet
{   
    public void init() 
    { 
        setSize(1500, 600); 
        repaint(); 
    } 
    public void paint(Graphics g) 
    {   int h,m,s;
        GregorianCalendar date = new GregorianCalendar();
        h = date.get(Calendar.HOUR);
        m = date.get(Calendar.MINUTE);
        s = date.get(Calendar.SECOND);
        int a[]= {(h/10),(h%10),(m/10),(m%10),(s/10),(s%10)};
        //int a[]= {(s/10),(s%10),((s+40)/10),((s+40)%10),(s/10),(s%10)};
        for(int j=0;j<6;j++)
    	mode(g,a[j],j);
        //j--;
        g.setColor(Color.red);
        g.fillRect(380, 140, 40, 40);
        g.fillRect(380, 240, 40, 40);
        g.fillRect(740, 140, 40, 40);
        g.fillRect(740, 240, 40, 40);
        try {
			Thread.sleep(1000);
		} 
        catch (InterruptedException e) {
			e.printStackTrace();
		}
        clear();
    }
    public void clear() 
    { 
    Graphics g = getGraphics(); 
    Dimension d = getSize(); 
    Color c = getBackground(); 
    g.setColor(c); 
    g.fillRect(0,0,d.width,d.height); 
    repaint(); 
    }
	//graphics,digit,pos
	public void mode(Graphics g,int digi,int pos)
	{
		int a[][]= {{1,1,1,0,1,1,1},
				    {0,0,0,0,0,1,1},
				    {0,1,1,1,1,1,0},
				    {0,0,1,1,1,1,1},
				    {1,0,0,1,0,1,1},
				    {1,0,1,1,1,0,1},
				    {1,1,1,1,1,0,1},
				    {0,0,1,0,0,1,1},
				    {1,1,1,1,1,1,1},
				    {1,0,1,1,1,1,1}};
		int x[]= {80,80,80,80,80,170,170};
		int y[]= {80,200,80,200,320,80,200};
		int w[]= {40,40,130,130,130,40,40};
		int h[]= {150,150,30,30,30,150,150};
		int p[]= {0,150,360,510,720,870};
		int i;
		//g.setColor(c[j]);
		g.setColor(Color.RED);
		for(i=0;i<7;i++)
		{
			 if(a[digi][i]==1)
			 {  
				 g.fillRect(x[i]+p[pos],y[i],w[i],h[i]);
			 }
		}
	}
} 

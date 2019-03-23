package date;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

public class DigitalClock extends JApplet
{   
    static  class Param
    {       static int a[][]= {{1,1,1,0,1,1,1},
					    	    {0,0,0,0,0,1,1},
					    	    {0,1,1,1,1,1,0},
					    	    {0,0,1,1,1,1,1},
					    	    {1,0,0,1,0,1,1},
					    	    {1,0,1,1,1,0,1},
					    	    {1,1,1,1,1,0,1},
					    	    {0,0,1,0,0,1,1},
					    	    {1,1,1,1,1,1,1},
					    	    {1,0,1,1,1,1,1}};
    	    static int x[]= {80,80,80,80,80,170,170};
    	    static int y[]= {80,200,80,200,320,80,200};
    	    static int w[]= {40,40,130,130,130,40,40};
    	    static int h[]= {150,150,30,30,30,150,150};
    	    static int p[]= {0,150,360,510,720,870};
    	    static int CON=30;
    	    static int xPlusPos(int i,int pos)
    	    {
    	    	return (x[i]+p[pos]);
    	    }
    }
    public void init() 
    { 
        setSize(1500, 600); 
        repaint(); 
    } 
    public void paint(Graphics g) 
	 {      
    	    int h,m,s;
	        GregorianCalendar date = new GregorianCalendar();
	        h = date.get(Calendar.HOUR);
	        m = date.get(Calendar.MINUTE);
	        s = date.get(Calendar.SECOND);
	        int a[]= {(h/10),(h%10),(m/10),(m%10),(s/10),(s%10)};
	        //int a[]= {(s/10),(s%10),((s+40)/10),((s+40)%10),(s/10),(s%10)};
	        for(int j=0;j<6;j++)
	    	digitRect(g,a[j],j);
	        colonRect(g);
	        waitForOneSec();
	        clear(g);
    }
    public void clear(Graphics g) 
    {  
    	g.setColor(getBackground()); 
    	g.fillRect(0,0,getSize().width,getSize().height); 
    	repaint(); 
    }
	//graphics,digit,pos
	static public void digitRect(Graphics g,int digi,int pos)
	{
		g.setColor(Color.RED);
		for(int i=0;i<7;i++)
		{
			 if(Param.a[digi][i]==1)
			 {  
				 g.fillRoundRect(Param.xPlusPos(i,pos),Param.y[i],Param.w[i],Param.h[i],Param.CON,Param.CON);
			 }
		}
	}
	
	static public void colonRect(Graphics g)
	{
		g.setColor(Color.red);
        g.fillRect(380, 140, 40, 40);
        g.fillRect(380, 240, 40, 40);
        g.fillRect(740, 140, 40, 40);
        g.fillRect(740, 240, 40, 40);
	}
	
	static public void waitForOneSec()
	 {
		try {
	 
			Thread.sleep(1000);
		} 
     catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
} 

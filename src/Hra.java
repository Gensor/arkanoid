import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class Hra extends JComponent {


    private Ellipse2D.Double lopta= new Ellipse2D.Double(100,100,15,15);
    private RoundRectangle2D.Double hrac=new RoundRectangle2D.Double(200,450,100,10,20,20);
    private double rychlost =6;
    private int xSmerLopty=1;
    private int ySmerLopty=1;



    public Hra(){
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {

                 switch(e.getKeyCode()){
                    case KeyEvent.VK_LEFT:posunHraca(-1);break;
                    case KeyEvent.VK_RIGHT:posunHraca(+1);break;

                 }

             return false;
            }
        });
          
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2= (Graphics2D) g;

        //vymaluj pozadie
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,getWidth(),getHeight());

        //vykresli loptu
        g2.setColor(Color.red);
        g2.fill(lopta); 

        //vykresli hraca
        g2.setColor(Color.BLUE);
        g2.fill(hrac);
    }

    public void zmenPoziciu(){

        lopta.x+= xSmerLopty*rychlost;
        lopta.y+= ySmerLopty*rychlost;

        if(lopta.x<0)
            {
                System.out.println("lopta je VLAVO");
                xSmerLopty=1;
                lopta.x=0;
            }
            
            else if(lopta.x> getWidth()-lopta.getBounds().width)
            {
                System.out.println("lopta je VPRAVO");
                xSmerLopty=-1;
                lopta.x = getWidth()-lopta.getBounds().width;
            }

            else if(lopta.y<0)
            {
                System.out.println("lopta je HORE");
                ySmerLopty=1;
                lopta.y=0;
            }
                                                                  
            else if(poziciaHraca())
            {
                System.out.println("hracX:"+hrac.x+"   loptaX:"+lopta.x +" lopta udrela");
                ySmerLopty=-1;
                lopta.y = (getHeight()-lopta.getBounds().height)-21;
            }
    
            else if((lopta.y> getHeight()-lopta.getBounds().height ))
            {
                System.out.println(" lopta je DOLE");                            //miesto na restart hry <--------------
                ySmerLopty=-1;
                lopta.y = getHeight()-lopta.getBounds().height;
            }


     repaint();
    }

/*
* ak sa lopta stretne s hracom vyhodnoti to ako true
*
* */
    private boolean poziciaHraca(){

        if((lopta.y>=hrac.y-hrac.getBounds().height)&&((lopta.x>=hrac.x-20)&&(lopta.x<=hrac.x+105)))
            return true;

            return false;
    }




    public void posunHraca(int smer){
        if(smer<0){

            hrac.x-=20;
            if(hrac.x<0)hrac.x=0;

        }else{
            hrac.x+=20;
            if(hrac.x>395)hrac.x=395;
        }

    repaint();


    }










}

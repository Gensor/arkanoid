import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {


        private Timer timer;
        private Hra hra;

    public Main() {
            super("arkanoid");

            timer = new Timer(18,this);
            setVisible(true);
            setSize(500,500);
            setResizable(false);

            add(hra =new Hra());

            timer.start();
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

    public static void main(String[] args) {

        new Main();
    }


     @Override
     public void actionPerformed(ActionEvent e)
     {
        hra.zmenPoziciu();
     }














    }





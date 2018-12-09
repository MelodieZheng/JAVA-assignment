package class13;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class myThread implements Runnable{
	public JPanel jpanel1;
	String pst;
	JLabel show;
	static int speed;
	int fail;
	
	public myThread(JPanel jpanel,String str,JLabel show,int fail){
		this.jpanel1=jpanel;
		this.pst=str;
		this.show=show;
		myThread.speed=900;
		this.fail=fail;
	}
	public static void setSpeed(int s){
		if(speed+s>0){
			speed+=s;			
		}
	}
	
	public void run(){
		show.setFont(new java.awt.Font("宋体",Font.PLAIN, 33));		
		show.setText(pst);
		jpanel1.add(show);
		
		int x=(int)(Math.random()*400);
		int y= 0; 
		boolean fo = true;

		while(fo)
		{	if(show.isVisible()==false)
				{break;}
			y=y+10;
			show.setBounds(x, y+2, 33, 33); 
			
		try{
			Thread.sleep(speed); 
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	
		if(y >= 350){  
			game1.fail++;
			
			break;
			}
		}
		

	}
}

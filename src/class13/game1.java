package class13;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;



public class game1 extends JFrame implements KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	public static JPanel jpanel1 = new JPanel();
	public static Vector<Bean>number=new Vector<Bean>();
	public static int score=0;
	public static int fail;
	public game1(){
		
		gameInit();
		
		for(int i=0;i<10;i++){
			String pst = "";
			pst = pst+(char)(Math.random()*26+'A');
			JLabel show=new JLabel();
			myThread my=new myThread(jpanel1,pst,show,fail);	
			new Thread(my).start();
			Bean bean=new Bean();
			bean.setStr(pst);
			bean.setShow(show);
			number.add(bean);
			try{
				Thread.sleep((int)(Math.random()*1500)); 
			}catch(InterruptedException e){
				e.printStackTrace();
			}	
		}
	}
	
	private void gameInit(){
		contentPane = (JPanel)getContentPane();
		contentPane.setLayout(null);
		setSize(new Dimension(500, 500));
		setTitle("alphabet game");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jpanel1.setBounds(new Rectangle(4, 4, 400, 400));
		contentPane.add(jpanel1);
	}


	


public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyCode()==33){
		myThread.setSpeed(-50);
	}
	else if(e.getKeyCode()==34){
    	//System.out.println("DOWN");
    	myThread.setSpeed(+50);
    }
	else{
		//char key=e.getKeyChar();
		String key = (char) e.getKeyCode() + "";
		for(int i=0;i<game1.number.size();i++){
			Bean bean=(Bean)game1.number.get(i);
			if(bean.getStr().equals(key)){
				game1.jpanel1.remove(bean.getLabel());
				game1.jpanel1.repaint();
				bean.getLabel().setVisible(false);
				game1.number.removeElementAt(i);
				game1.scoreUp();
				break;
			}
		}
		
		if(game1.score==10){
			JOptionPane.showMessageDialog(null,"You win!","Win",JOptionPane.PLAIN_MESSAGE);	
			System.exit(0);
		}
		
		else if(game1.fail==10){
			JOptionPane.showMessageDialog(null,"You fail!","Fail",JOptionPane.PLAIN_MESSAGE);	
			System.exit(0);
		}
	}
}

public static void scoreUp() {
	// TODO Auto-generated method stub
	score++;
}

public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub	
}

public static void main(String[] args){
	new game1();
}
}
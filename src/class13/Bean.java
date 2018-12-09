package class13;

import javax.swing.JLabel;

public class Bean {
	JLabel jbl = null;
	String pstr = null;
   
   public void setShow(JLabel show){
      this.jbl = show;
   }
   
   public void setStr(String pstr){
      this.pstr = pstr;
   }
   
   public JLabel getLabel(){
      return this.jbl;
   }
   
   public String getStr(){
      return pstr;
   }
}

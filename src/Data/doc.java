package Data;

public class doc {
	String Y_Name;
	boolean exper;
	String YSBH;
    String KSBH;
    
    void setY_Name(String Y_Name ) {
    	this.Y_Name=Y_Name;
    }
    
    void setYSBH(String YSBH ) {
    	this.YSBH=YSBH;
    }
    void setKSBH(String KSBH ) {
    	this.KSBH=KSBH;
    }
    void setexper(boolean exper) {
    	this.exper=exper;
    }
    
    String getY_Name( ) {
    	return Y_Name;
    }
    
    String getYSBH() {
    	return YSBH;
    }
    String getKSBH() {
    	return KSBH;
    }
    boolean getExper() {
    	return exper;
    }
    
}

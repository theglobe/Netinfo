package netinfo;

import java.lang.*;
import javax.microedition.lcdui.*;

class NiMonitor implements Runnable {

    private Form mainForm;
    private Display display;
    private int delayTime = 1000; // ms
    private String mccmnc = "", lac = "", cellid = "";
    //    private String mccmncG = "", lacG = "", cellidG = "";

    public Thread monitor = new Thread(this);

    // Constructor
    NiMonitor(Form f, Display d) {
	mainForm = f;
	display = d;
	//	delayTime = delay;
    }


    public void run() {
	while (true) {
	    try {
		Thread.sleep(delayTime);
	    }
	    catch (InterruptedException e) {
		break; // exit while statement
	    }

	    String cellid2  = System.getProperty("com.sonyericsson.net.cellid");
	    if (cellid2 == null) cellid2 = "";

	    String mccmnc2 = System.getProperty("com.sonyericsson.net.cmcc") + 
		System.getProperty("com.sonyericsson.net.cmnc");
	    if (mccmnc2 == null) mccmnc2 = "";
	    
	    String lac2    = System.getProperty("com.sonyericsson.net.lac");
	    if (lac2 == null) lac2 = "";

	    // Check if lac or cellid has changed
	    
	    //	    StringItem item = new StringItem(null, cellid + ";" + cellid2);
	    //	    mainForm.append(item);

	    if (cellid.compareTo(cellid2) != 0 ||
		mccmnc.compareTo(mccmnc2) != 0 || 
		lac.compareTo(lac2)       != 0)  {
		
		
		lac = lac2;
		cellid = cellid2;
		mccmnc = mccmnc2;
 
		StringItem item = new StringItem(null, mccmnc + ";" + lac + ";" + cellid);
		mainForm.append(item);
		
		// Scroll down to the added line
		display.setCurrentItem(item);
	    }
	}
    }
}
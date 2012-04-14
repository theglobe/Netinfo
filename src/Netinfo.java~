package netinfo;

import java.lang.*;
import java.util.*;

import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;


public class Netinfo
    extends MIDlet
    implements CommandListener {

    private Display display;
    private Form mainForm;
    //    private final static Command CMD_GO = new Command("Go", Command.ITEM, 1);
    //    private final static Command CMD_PRESS = new Command("Press", Command.ITEM, 1);
    private final static Command CMD_EXIT = new Command("Exit", Command.EXIT, 1);
    private final static Command CMD_UPDATE = new Command("Update", Command.ITEM, 1);
    
    private NiMonitor mon;

    /**
     * Signals the MIDlet to start and enter the Active state.
     */
    protected void startApp() {
// 	SecurityManager sm = System.getSecurityManager(); //new NiSecurityManager();
// 	System.setSecurityManager(sm);


	display = Display.getDisplay(this);
        mainForm = new Form("Netinfo");
	mainForm.addCommand(CMD_UPDATE);
        mainForm.addCommand(CMD_EXIT);
        mainForm.setCommandListener(this);

	displayInfo();

        display.setCurrent(mainForm);

	mon = new NiMonitor(mainForm, display);
    }

    public void commandAction(Command c, Displayable d) {
	if (c == CMD_UPDATE) {
	    //	    displayInfoLine();
	    mon.monitor.start();
	    mainForm.removeCommand(CMD_UPDATE);
	}
	else {
            destroyApp(false);
            notifyDestroyed();
	}
    }
    
    /**
     * Signals the MIDlet to terminate and enter the Destroyed state.
     */
    protected void destroyApp(boolean unconditional) {
    }

    /**
     * Signals the MIDlet to stop and enter the Paused state.
     */
    protected void pauseApp() {
    }           

    protected void displayInfo() {

	mainForm.append(new StringItem("Status:", System.getProperty("com.sonyericsson.net.status")));
	mainForm.append(new StringItem("RAT:", System.getProperty("com.sonyericsson.net.rat")));
	mainForm.append(new StringItem("Using home network:", System.getProperty("com.sonyericsson.net.isonhomeplmn")));

	String mccmnc =  System.getProperty("com.sonyericsson.net.cmcc") + " " 
	    + System.getProperty("com.sonyericsson.net.cmnc");
	String lac    = System.getProperty("com.sonyericsson.net.lac");
	String cellid = System.getProperty("com.sonyericsson.net.cellid");


	mainForm.append(new StringItem("MCC MNC:", mccmnc));
	mainForm.append(new StringItem("LAC:", lac));
	mainForm.append(new StringItem("CellID:", cellid));

	//	mainForm.append("Decimal values:");

	int lacDec, cellidDec;
	if (lac != null) { lacDec = Integer.parseInt(lac,16); }
	else { lacDec = 0; }
	if (cellid != null) { cellidDec = Integer.parseInt(cellid,16); }
	else { cellidDec = 0; }

	mainForm.append("In decimal:\n");
	mainForm.append(new StringItem("LAC:", Integer.toString(lacDec)));;
	mainForm.append(new StringItem("CellID:", Integer.toString(cellidDec)));

    
    }
    
    void displayInfoLine() {

	String mccmnc =  System.getProperty("com.sonyericsson.net.cmcc") + 
	    System.getProperty("com.sonyericsson.net.cmnc");
	String lac     = System.getProperty("com.sonyericsson.net.lac");
	String cellid  = System.getProperty("com.sonyericsson.net.cellid");
	
	StringItem item = new StringItem(null, mccmnc + ";" + lac + ";" + cellid);
	mainForm.append(item);

	// Scroll down to the added line
	display.setCurrentItem(item);
    }

}

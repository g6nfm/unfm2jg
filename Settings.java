import java.applet.Applet;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Put a menu bar for things
 * 
 * @author Kaffeinated
 */
public class Settings extends Applet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3096969581463346958L;
	/**
	 * change this is false to hide the bar
	 */
	final static boolean showMenubar = true; 
	/**
	 * no good way to get it automagically...
	 * 21 if showmenubar is true
	 * 0 if it's false
	 */
	public final static int menubarHeight = (showMenubar) ? 21:0;
	
	public static boolean quickhide = false;
	static MenuBar menubar = new MenuBar();
    static Menu debug = new Menu("Debug");
    //static Menu submenu1 = new Menu("Open");
    static MenuItem debugWindow = new MenuItem("Show Window");
    //static MenuItem item2 = new MenuItem("URL");
    //static Menu submenu2 = new Menu("Save As");
    //static MenuItem item3 = new MenuItem("text");
    //static MenuItem item4 = new MenuItem("html");
	
    static Component c = null;          
    
    public Settings(){
    	//submenu1.add(item1);
	    //submenu1.add(item2);
	    debug.add(debugWindow);
	    //submenu2.add(item3);
	    //submenu2.add(item4);
	    //menu.add(submenu2);
	    menubar.add(debug);
		
		debugWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!ConsoleFrame.frameVisible){
					ConsoleFrame.showUNFM2Console();
					System.out.println("debugWindow enabled");
				}else{
					ConsoleFrame.hideUNFM2Console();
					System.out.println("debugWindow disabled");
				}				
			}
		});	
    }
    
    private static void initialize(Component instIn){
    	while (instIn != null && !(c instanceof Frame)) {
            c = instIn.getParent();
	    }	    
	}
    
	public static void showMenu(Component instIn){
		if(showMenubar){
			initialize(instIn);
			((Frame)c).setMenuBar(menubar);      		
		}		
	}
	
	public static void hideMenu(Component instIn){
		initialize(instIn);
		((Frame)c).setMenuBar(null);		
	}
}
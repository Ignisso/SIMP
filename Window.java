import javax.swing.*;

abstract class Window
extends JFrame {
	public Window(String title) {
		
	}
	
	public void wDisplay() {
		this.setVisible(true);
	}
	
	public void wHide() {
		this.setVisible(false);
	}
}
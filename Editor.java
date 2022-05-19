public class Editor {
	private History  history;
	private Settings settings;
	private Window   mainWindow;
	
	public Editor() {
		
	}
	
	public void launch() {
		
	}
	
	public Settings getSettings() {
		return this.settings;
	}
	
	public History getHistory() {
		return this.history;
	}
	
	public Window getWindow() {
		return this.mainWindow;
	}
	
	public static void main(String[] args) {
		Editor editor = new Editor();
		editor.launch();
	}
}
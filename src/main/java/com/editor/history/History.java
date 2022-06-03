package com.editor.history;

import java.util.Stack;
import com.editor.window.Entry;

public class History {
	private Stack<Command> commandHistory;
	private Integer        historyPointer;
	private Entry          redo;
	private Entry          undo;
	
	public History() {
		this.commandHistory = new Stack<Command>();
		this.historyPointer = -1;
		this.redo           = null;
		this.undo           = null;
	}
	
	private void removeAfterPointer(int pointer) {
		if (commandHistory.size() < 1)
			return;
		while (commandHistory.size() - 1 > pointer)
			commandHistory.pop();
	}
	
	public void insert(Command command) {
		removeAfterPointer(historyPointer);
		commandHistory.push(command);
		historyPointer++;
		if (historyPointer > 0) {
			this.undo.setEnabled(true);
			this.undo.setText("Undo \"" + commandHistory.get(historyPointer) + "\"");
		}
		this.redo.setEnabled(false);
	}
	
	public void setUndo(Entry undo) {
		this.undo = undo;
		this.undo.setEnabled(false);
	}
	
	public void setRedo(Entry redo) {
		this.redo = redo;
		this.redo.setEnabled(false);
	}
	
	public void undo() {
		if (historyPointer < 1)
			return;
		historyPointer--;
		System.out.println("UNDO" + historyPointer);
		Command command = commandHistory.get(historyPointer);
		command.restore();
		this.redo.setEnabled(true);
		this.redo.setText("Redo \"" + commandHistory.get(historyPointer + 1) + "\"");
		if (historyPointer > 0) {
			this.undo.setEnabled(true);
			this.undo.setText("Undo \"" + commandHistory.get(historyPointer) + "\"");
		}
		else {
			this.undo.setEnabled(false);
			this.undo.setText("Undo");
		}
	}
	
	public void redo() {
		if(historyPointer > commandHistory.size())
			return;
		historyPointer++;
		System.out.println("REDO" + historyPointer);
		Command command = commandHistory.get(historyPointer);
		command.restore();
		this.undo.setEnabled(true);
		this.undo.setText("Undo \"" + commandHistory.get(historyPointer));
		if (historyPointer < commandHistory.size() - 1) {
			this.redo.setEnabled(true);
			this.redo.setText("Redo \"" + commandHistory.get(historyPointer + 1) + "\"");
		}
		else {
			this.redo.setEnabled(false);
			this.redo.setText("Redo");
		}
	}
}

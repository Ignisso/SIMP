package com.editor.history;

import java.util.Stack;

public class History {
	Stack<Command> commandHistory;
	int historyPointer;

	public History() {
		this.commandHistory = new Stack<Command>();
		this.historyPointer = -1;
	}

	private void removeAfterPointer(int pointer) {
		if(commandHistory.size() < 1) return;

		while(commandHistory.size() - 1 > pointer) {
			commandHistory.pop();
		}
	}

	public void insert(Command command) {
		removeAfterPointer(historyPointer);
		command.execute();
		commandHistory.push(command);
		historyPointer++;
	}

	public void undo() {
		Command command = commandHistory.get(historyPointer);
		command.unExecute();
		historyPointer--;
	}

	public void redo() {
		if(historyPointer == commandHistory.size() - 1)
			return;
		historyPointer++;
		Command command = commandHistory.get(historyPointer);
		command.execute();
	}

}

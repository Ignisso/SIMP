package com.editor.window;

import javax.swing.*;
import java.awt.event.*;

public class EntryExit
extends JMenuItem {
	public EntryExit() {
		super("Exit");
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
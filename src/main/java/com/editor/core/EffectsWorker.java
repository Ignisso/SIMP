package com.editor.core;

import com.editor.effects.*;
import javax.swing.*;

public class EffectsWorker
extends SwingWorker<Void, Integer> {
	private Effect e;
	
	public EffectsWorker(Effect e) {
		this.e = e;
	}
	
	@Override
	protected Void doInBackground() {
		try {
			e.process();
		} catch (InterruptSignal i) {
			return null;
		}
		return null;
	}
	
	@Override
	protected void done() {
		e.closeDialog();
	}
}
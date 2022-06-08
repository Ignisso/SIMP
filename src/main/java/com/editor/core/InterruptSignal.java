package com.editor.core;

public class InterruptSignal
extends RuntimeException {
	public InterruptSignal() {
		super("Thread interrupted");
	}
}
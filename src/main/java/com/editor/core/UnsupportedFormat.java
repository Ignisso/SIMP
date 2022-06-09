package com.editor.core;

public class UnsupportedFormat
extends Exception {
	public UnsupportedFormat() {
		super("This conversion/file format is not supported");
	}
}
package com.editor.core;

public class RGBA {
	private byte r;
	private byte g;
	private byte b;
	private byte a;
	
	public RGBA(int rgba) {
		this.r = (byte)((rgba >> 24) & 0xFF);
		this.g = (byte)((rgba >> 16) & 0xFF);
		this.b = (byte)((rgba >> 8) & 0xFF);
		this.a = (byte)(rgba & 0xFF);
	}
	
	public byte getRed() {
		return this.r;
	}
	
	public void setRed(byte r) {
		this.r = r;
	}
	
	public byte getGreen() {
		return this.g;
	}
	
	public void setGreen(byte g) {
		this.g = g;
	}
	
	public byte getBlue() {
		return this.b;
	}
	
	public void setBlue(byte b) {
		this.b = b;
	}
	
	public byte getAlpha() {
		return this.a;
	}
	
	public void setAplha(byte a) {
		this.a = a;
	}
	
	public int getRGBA() {
		int result = 0x00000000;
		result |= this.r;
		result <<= 8;
		result |= (this.g & 0xFF);
		result <<= 8;
		result |= (this.b & 0xFF);
		result <<= 8;
		result |= (this.a & 0xFF);
		return result;
	}
}
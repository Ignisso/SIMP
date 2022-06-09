package com.editor.core;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileFilter {
	public static void addFilters(JFileChooser chooser) {
		chooser.addChoosableFileFilter(
			new FileNameExtensionFilter("BitMap file", "bmp"));
		chooser.addChoosableFileFilter(
			new FileNameExtensionFilter("JPEG file", "jpg", "jpeg"));
		chooser.addChoosableFileFilter(
			new FileNameExtensionFilter("PNG file", "png"));
		chooser.addChoosableFileFilter(
			new FileNameExtensionFilter("TIFF file", "tif", "tiff"));
		chooser.addChoosableFileFilter(
			new FileNameExtensionFilter("GIF file", "gif"));
		chooser.setFileFilter(new FileNameExtensionFilter(
			"All graphics files", "bmp", "jpg", "jpeg", "png", "gif", "tif", "tiff"));
	}
}
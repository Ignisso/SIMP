package com.editor.window;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DialogBox
extends JDialog {
	public static final Integer
	MB_NONE   = 0x00,
	MB_APPLY  = 0x01,
	MB_CANCEL = 0x02;
	
	private JPanel  panel;
	private Window  parent;
	private JButton apply;
	private Integer buttons;
	
	public DialogBox(Window window, String title) {
		super(window, title, false);
		this.panel  = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.parent = window;
		this.buttons = MB_NONE;
	}
	
	public DialogBox(Window window, String title, Integer buttons) {
		super(window, title, false);
		this.panel  = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
		this.parent = window;
		this.buttons = buttons;
	}
	
	public void addApplet(JComponent applet) {
		JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		row.add(applet);
		this.panel.add(row);
	}
	
	public void addApplet(JComponent[] applets) {
		JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		for (JComponent jc : applets)
			row.add(jc);
		this.panel.add(row);
	}
	
	public void doApply(ActionListener listener) {
		this.apply.addActionListener(listener);
	}
	
	public void doCancel(ActionListener listener) {
		this.apply.addActionListener(listener);
	}
	
	public void close() {
		this.setVisible(false);
		this.dispose();
	}
	
	public void finish() {
		if (this.buttons != MB_NONE) {
			JPanel row = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
			if ((this.buttons & MB_APPLY) != 0) {
				this.apply = new JButton("Apply");
				row.add(this.apply);
			}
			if ((this.buttons & MB_CANCEL) != 0) {
				JButton cancel = new JButton("Canel");
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				row.add(cancel);
			}
			this.panel.add(row);
		}
		this.add(this.panel);
		this.pack();
		double x = parent.getLocation().getX() - this.getSize().getWidth() / 2;
		double y = parent.getLocation().getY() - this.getSize().getHeight() / 2;
		x += parent.getSize().getWidth() / 2;
		y += parent.getSize().getHeight() / 2;
		this.setLocation((int)x, (int)y);
		setVisible(true);
	}
}
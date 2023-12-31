package com.editor.window.themes;

import javax.swing.*;
import com.editor.core.*;
import com.editor.window.*;

public class MenuTheme
extends JMenu {
	public MenuTheme(EditorRuntime root) {
		super("Theme");
		ButtonGroup group = new ButtonGroup();
		EntryRadio e01 = new EntryLight(root);
		this.add(e01);
		group.add(e01);
		EntryRadio e02 = new EntryDark(root);
		this.add(e02);
		group.add(e02);
		EntryRadio e03 = new EntryIntelliJ(root);
		this.add(e03);
		group.add(e03);
		EntryRadio e04 = new EntryDarcula(root);
		this.add(e04);
		group.add(e04);
		/*
		this.addSeparator();
		EntryRadio e05 = new EntryFlatArcIJ(root);
		this.add(e05);
		group.add(e05);
		EntryRadio e06 = new EntryFlatArcOrangeIJ(root);
		this.add(e06);
		group.add(e06);
		EntryRadio e07 = new EntryFlatArcDarkIJ(root);
		this.add(e07);
		group.add(e07);
		EntryRadio e08 = new EntryFlatCarbonIJ(root);
		this.add(e08);
		group.add(e08);
		EntryRadio e09 = new EntryFlatCobalt2IJ(root);
		this.add(e09);
		group.add(e09);
		EntryRadio e10 = new EntryFlatCyanLightIJ(root);
		this.add(e10);
		group.add(e10);
		EntryRadio e11 = new EntryFlatDarkFlatIJ(root);
		this.add(e11);
		group.add(e11);
		EntryRadio e12 = new EntryFlatDarkPurpleIJ(root);
		this.add(e12);
		group.add(e12);
		EntryRadio e13 = new EntryFlatDraculaIJ(root);
		this.add(e13);
		group.add(e13);
		EntryRadio e14 = new EntryFlatGradiantoDarkFuchsiaIJ(root);
		this.add(e14);
		group.add(e14);
		EntryRadio e15 = new EntryFlatGradiantoDeepOceanIJ(root);
		this.add(e15);
		group.add(e15);
		EntryRadio e16 = new EntryFlatGradiantoMidnightBlueIJ(root);
		this.add(e16);
		group.add(e16);
		EntryRadio e17 = new EntryFlatGradiantoNatureGreenIJ(root);
		this.add(e17);
		group.add(e17);
		EntryRadio e18 = new EntryFlatGrayIJ(root);
		this.add(e18);
		group.add(e18);
		EntryRadio e19 = new EntryFlatGruvboxDarkHardIJ(root);
		this.add(e19);
		group.add(e19);
		EntryRadio e20 = new EntryFlatGruvboxDarkMediumIJ(root);
		this.add(e20);
		group.add(e20);
		EntryRadio e21 = new EntryFlatGruvboxDarkSoftIJ(root);
		this.add(e21);
		group.add(e21);
		EntryRadio e22 = new EntryFlatHiberbeeDarkIJ(root);
		this.add(e22);
		group.add(e22);
		EntryRadio e23 = new EntryFlatHighContrastIJ(root);
		this.add(e23);
		group.add(e23);
		EntryRadio e24 = new EntryFlatLightFlatIJ(root);
		this.add(e24);
		group.add(e24);
		EntryRadio e25 = new EntryFlatMaterialDesignDarkIJ(root);
		this.add(e25);
		group.add(e25);
		EntryRadio e26 = new EntryFlatMonocaiIJ(root);
		this.add(e26);
		group.add(e26);
		EntryRadio e27 = new EntryFlatMonokaiProIJ(root);
		this.add(e27);
		group.add(e27);
		EntryRadio e28 = new EntryFlatNordIJ(root);
		this.add(e28);
		group.add(e28);
		EntryRadio e29 = new EntryFlatOneDarkIJ(root);
		this.add(e29);
		group.add(e29);
		EntryRadio e30 = new EntryFlatSolarizedDarkIJ(root);
		this.add(e30);
		group.add(e30);
		EntryRadio e31 = new EntryFlatSolarizedLightIJ(root);
		this.add(e31);
		group.add(e31);
		EntryRadio e32 = new EntryFlatSpacegrayIJ(root);
		this.add(e32);
		group.add(e32);
		EntryRadio e33 = new EntryFlatVuesionIJ(root);
		this.add(e33);
		group.add(e33);
		EntryRadio e34 = new EntryFlatXcodeDarkIJ(root);
		this.add(e34);
		group.add(e34);
		*/
	}
}
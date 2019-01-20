package com.fosagri.utils;

public enum PrestationStringUtils {

	PRESTATION_CHOIX1("COIX 1"),
	PRESTATION_PERIODE1("PERIODE !"),
	PRESTATION_CODAG("PPR"),
	PRESTATION_BENIFICIAIRE("BENIFICAIRE"),
	SAVE_BUTTON("Save"),
	CLEAR_BUTTON("Clear");
   	private final String string;

	private PrestationStringUtils(String string) {
		this.string = string;
	}
	
	public String getString() {
		return this.string;
	}

}

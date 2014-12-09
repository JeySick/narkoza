package com.example.jsfdemo.domain;

import javax.validation.constraints.Size;

public class Drug {
	private String drugName = "";
	private Integer drugId;
	private String rodzaj = "";
	private String symptomy = "";
	private String opisDzialania = "";
	private String rodzina = "";

	@Size(min=2, max=11)
	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public Integer getDrugId() {
		return drugId;
	}

	public void setDrugId(Integer drugId) {
		this.drugId = drugId;
	}

	public String getRodzaj() {
		return rodzaj;
	}

	public void setRodzaj(String rodzaj) {
		this.rodzaj = rodzaj;
	}

	public String getSymptomy() {
		return symptomy;
	}

	public void setSymptomy(String symptomy) {
		this.symptomy = symptomy;
	}

	public String getOpisDzialania() {
		return opisDzialania;
	}

	public void setOpisDzialania(String opisDzialania) {
		this.opisDzialania = opisDzialania;
	}

	public String getRodzina() {
		return rodzina;
	}

	public void setRodzina(String rodzina) {
		this.rodzina = rodzina;
	}

}

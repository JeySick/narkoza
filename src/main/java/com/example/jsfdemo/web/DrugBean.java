package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Drug;
import com.example.jsfdemo.domain.Person;
import com.example.jsfdemo.service.Dealer;
import com.example.jsfdemo.service.PersonManager;

@SessionScoped
@Named("drugBean")
public class DrugBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Drug drug = new Drug();
	private Drug drugToUpdate = new Drug();
	
	private ListDataModel<Drug> drugs = new ListDataModel<Drug>();

	
	@Inject
	private Dealer dealer;



	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	
	
	public Drug getDrugToUpdate() {
		return drugToUpdate;
	}

	public void setDrugToUpdate(Drug drugToUpdate) {
		this.drugToUpdate = drugToUpdate;
	}

	public ListDataModel<Drug> getAllDrugs() {
		drugs.setWrappedData(dealer.getAllDrugs());
		return drugs;
	}

	// Actions
	public String addDrug() {
		dealer.addDrug(drug);
		return "showDrugs";
		//return null;
	}

	public String deleteDrug() {
		Drug drugToUse = drugs.getRowData();
		dealer.deleteDrug(drugToUse);
		return null;
	}
	
	public String updateDrug() {
		Drug drugToUpdate = drugs.getRowData();
		this.drugToUpdate = drugToUpdate;
		return "updateDrug";
		
	}
	
	public String updateThisDrug() {
		dealer.updateDrug(drugToUpdate);
		return "showDrugs";
	}
	
	
	public void uniqueId(FacesContext context, UIComponent component,
			Object value) {

		String pin = value.toString();

		for (Drug drug : dealer.getAllDrugs()) {
			if (drug.getDrugId().toString().equalsIgnoreCase(pin)) {
				FacesMessage message = new FacesMessage(
						"You've already used this drug. You can't think right now. You are high.");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
	
}
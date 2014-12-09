package com.example.jsfdemo.web;

import java.io.Serializable;
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

	private ListDataModel<Drug> drugs = new ListDataModel<Drug>();

	@Inject
	private Dealer dealer;

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
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

	// Validators
//
//	// Business logic validation
//	public void uniquePin(FacesContext context, UIComponent component,
//			Object value) {
//
//		String pin = (String) value;
//
//		for (Person person : dealer.getAllPersons()) {
//			if (person.getPin().equalsIgnoreCase(pin)) {
//				FacesMessage message = new FacesMessage(
//						"Person with this PIN already exists in database");
//				message.setSeverity(FacesMessage.SEVERITY_ERROR);
//				throw new ValidatorException(message);
//			}
//		}
//	}
//
//	// Multi field validation with <f:event>
//	// Rule: first two digits of PIN must match last two digits of the year of
//	// birth
//	public void validatePinDob(ComponentSystemEvent event) {
//
//		UIForm form = (UIForm) event.getComponent();
//		UIInput pin = (UIInput) form.findComponent("pin");
//		UIInput dob = (UIInput) form.findComponent("dob");
//
//		if (pin.getValue() != null && dob.getValue() != null
//				&& pin.getValue().toString().length() >= 2) {
//			String twoDigitsOfPin = pin.getValue().toString().substring(0, 2);
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(((Date) dob.getValue()));
//
//			String lastDigitsOfDob = ((Integer) cal.get(Calendar.YEAR))
//					.toString().substring(2);
//
//			if (!twoDigitsOfPin.equals(lastDigitsOfDob)) {
//				FacesContext context = FacesContext.getCurrentInstance();
//				context.addMessage(form.getClientId(), new FacesMessage(
//						"PIN doesn't match date of birth"));
//				context.renderResponse();
//			}
//		}
//	}
}
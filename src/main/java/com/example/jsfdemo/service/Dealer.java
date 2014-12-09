package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Drug;

@ApplicationScoped
public class Dealer {
	private List<Drug> db = new ArrayList<Drug>();

	public void addDrug(Drug drug) {
		Drug newDrug = new Drug();

		newDrug.setDrugName(drug.getDrugName());
		newDrug.setDrugId(drug.getDrugId());
		newDrug.setRodzaj(drug.getRodzaj());
		newDrug.setOpisDzialania(drug.getOpisDzialania());
		newDrug.setRodzina(drug.getRodzina());
		newDrug.setSymptomy(drug.getSymptomy());

		db.add(newDrug);
	}

	// Removes the person with given PIN
	public void deleteDrug(Drug drug) {
		Drug drugToUse = null;
		for (Drug d : db) {
			if (drug.getDrugId().equals(d.getDrugId())) {
				drugToUse = d;
				break;
			}
		}
		if (drugToUse != null)
			db.remove(drugToUse);
	}
	
	public void updateDrug(Drug drug) {
//		Drug drugToUpdate = null;
//		for (Drug d : db) {
//			if (drug.getDrugId().equals(d.getDrugId())) {
//				drugToUpdate = d;
//				break;
//			}
//		}
//		if (drugToUpdate != null) {
//			drugToUpdate.setDrugName(drug.getDrugName());
//		}
//		
	}

	public List<Drug> getAllDrugs() {
		return db;
	}
}
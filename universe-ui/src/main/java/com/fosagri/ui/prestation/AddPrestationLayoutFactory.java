package com.fosagri.ui.prestation;

import com.fosagri.model.entity.Prestation;
import com.fosagri.service.addPrestationService.AddPrestationService;
import com.fosagri.utils.*;
import com.google.gwt.i18n.server.testing.Gender;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Component
public class AddPrestationLayoutFactory {
	
	@Autowired
	AddPrestationService addPrestationService;
	
	private class AddPrestationLayout extends VerticalLayout implements Button.ClickListener {
		
		private TextField benificiare;
		private TextField codAg;
		private ComboBox choix1;
		private ComboBox periode1;
		private Button saveButton;
		private Prestation prestation;
		private BeanFieldGroup<Prestation> fieldGroup;
		private PrestationSavedListener prestationSavedListener;

		public AddPrestationLayout(PrestationSavedListener prestationSavedListener) {
			this.prestationSavedListener = prestationSavedListener;
		}
		
		public AddPrestationLayout init() {

			fieldGroup = new BeanFieldGroup<Prestation>(Prestation.class);
 			prestation = new Prestation();

			benificiare = new TextField(PrestationStringUtils.PRESTATION_BENIFICIAIRE.getString());
			codAg = new TextField(PrestationStringUtils.PRESTATION_CODAG.getString());
			choix1  = new ComboBox(PrestationStringUtils.PRESTATION_CHOIX1.getString());
			periode1  = new ComboBox(PrestationStringUtils.PRESTATION_PERIODE1.getString());

			saveButton = new Button(PrestationStringUtils.SAVE_BUTTON.getString(), this);
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);


			System.out.println(Periode.PERIODE1.toString());
			System.out.println(Gender.MALE.toString());
			periode1.addItem(Periode.PERIODE1.toString());
			periode1.addItem(Periode.PERIODE2.toString());
			periode1.addItem(Periode.PERIODE3.toString());

			choix1.addItem(Choix.CHOIX1.toString());
			choix1.addItem(Choix.CHOIX2.toString());
			return this;
		}
		
		public AddPrestationLayout bind() {
		//	fieldGroup = new BeanFieldGroup<Prestation>(Prestation.class);
			fieldGroup.bindMemberFields(this);
			fieldGroup.setItemDataSource(prestation);
			return this;
		}


		
		public Component layout() {
			setWidth("100%");
			
			GridLayout grid = new GridLayout(1, 5);
			grid.setHeightUndefined();
			grid.setSpacing(true);
			grid.addComponent(benificiare, 0,0);
			grid.addComponent(codAg, 0,1);
			grid.addComponent(choix1, 0,2);
			grid.addComponent(periode1, 0, 3);
			grid.addComponent(saveButton, 0, 4);

			return grid;
		}
		
		

		public void buttonClick(ClickEvent event) {
			try {
				fieldGroup.commit();
			} catch (CommitException exception) {
				Notification.show(NotificationMessages.UNIVERSITY_SAVED_VALIDATION_ERROR_TITLE.getString(), 
						NotificationMessages.UNIVERSITY_SAVED_VALIDATION_ERROR_DESCRIPTION.getString(), Type.ERROR_MESSAGE );
				return;
			}
			clearFields();
			addPrestationService.addPrestation(prestation);
			System.out.println(prestation);
			prestationSavedListener.prestationSaved();
			Notification.show("SAVE", "prestation saved successfully", Type.WARNING_MESSAGE);
		}
		
		private void clearFields() {
			choix1.setValue(null);
			periode1.setValue(null);
			codAg.setValue(null);
			 benificiare.setValue(null); 
		}
	}
	
	public Component createComponent(PrestationSavedListener prestationSavedListener) {
		return new AddPrestationLayout(prestationSavedListener).init().bind().layout();
	}

}

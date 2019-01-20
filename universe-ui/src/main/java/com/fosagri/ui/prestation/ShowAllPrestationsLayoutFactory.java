package com.fosagri.ui.prestation;

import com.fosagri.model.entity.Prestation;
import com.fosagri.service.showPrestationService.ShowAllPrestationsService;
import com.fosagri.ui.commonns.UIComponentBuilder;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Component
public class ShowAllPrestationsLayoutFactory implements UIComponentBuilder{

	private List<Prestation> adherents;
	private BeanItemContainer<Prestation> container;

	public void refreshTable() {
		adherents = showAllPrestationsService.getAllPrestations();
		container.removeAllItems();
		container.addAll(adherents);
	}


	private class ShowAllPrestationsLayout extends VerticalLayout {
		private Grid adherentsTable;

		public ShowAllPrestationsLayout init() {
			setMargin(true);

			container = new BeanItemContainer<Prestation>(Prestation.class, adherents);
			adherentsTable = new Grid(container);
			adherentsTable.setColumnOrder("codAg", "benificiare","choix1", "periode1");
			adherentsTable.removeColumn("prestationId");
 			adherentsTable.setImmediate(true);


			return this;
		}

		public ShowAllPrestationsLayout load() {
			adherents = showAllPrestationsService.getAllPrestations();
			return this;
		}

		public ShowAllPrestationsLayout layout() {
			addComponent(adherentsTable);
			return this;
		}
	}

	@Autowired
	private ShowAllPrestationsService showAllPrestationsService;

	public Component createComponent() {
		return new ShowAllPrestationsLayout().init().load().layout();
	}



}

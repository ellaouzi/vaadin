package com.matt.ui.commonns;

import com.matt.navigator.UniverseNavigator;
import com.matt.utils.StringUtils;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class UniversMenuFactory implements UIComponentBuilder {
	
	private class UniversMenu extends VerticalLayout implements  Property.ValueChangeListener {
		
		private Tree mainMenu;
		
		public UniversMenu init() {
			mainMenu = new Tree();
			mainMenu.addValueChangeListener(this);
			return this;
		}
		
		public UniversMenu layout() {
			setWidth("100%");
			setHeightUndefined();
			
			mainMenu.addItem(StringUtils.MENU_STUDENT.getString());
			mainMenu.addItem(StringUtils.MENU_UNIVERSITY.getString());
			
			mainMenu.expandItem(StringUtils.MENU_STUDENT.getString());
			mainMenu.expandItem(StringUtils.MENU_UNIVERSITY.getString());
			
			mainMenu.addItem(StringUtils.MENU_ADD_STUDENT.getString());
			mainMenu.addItem(StringUtils.MENU_REMOVE_STUDENT.getString());
			mainMenu.setChildrenAllowed(StringUtils.MENU_ADD_STUDENT.getString(), false);
			mainMenu.setChildrenAllowed(StringUtils.MENU_REMOVE_STUDENT.getString(), false);
			mainMenu.setParent(StringUtils.MENU_ADD_STUDENT.getString(),  StringUtils.MENU_STUDENT.getString());
			mainMenu.setParent(StringUtils.MENU_REMOVE_STUDENT.getString(), StringUtils.MENU_STUDENT.getString());
			
			mainMenu.addItem(StringUtils.MENU_CREATIONS.getString());
			mainMenu.setChildrenAllowed(StringUtils.MENU_CREATIONS.getString(), false);
			mainMenu.setParent(StringUtils.MENU_CREATIONS.getString(), StringUtils.MENU_UNIVERSITY.getString());
			
			addComponent(mainMenu);
			return this;
		}

		public void valueChange(ValueChangeEvent event) {
			String selectedItemPath = (String)event.getProperty().getValue();
			if(selectedItemPath == null) {
				return ;
			}
			
			String path = selectedItemPath.toLowerCase().replaceAll("\\s+", "");
			UniverseNavigator.navigate(path);
		}
		
	}

	public Component createComponent() {
		return new UniversMenu().init().layout();
	}

}

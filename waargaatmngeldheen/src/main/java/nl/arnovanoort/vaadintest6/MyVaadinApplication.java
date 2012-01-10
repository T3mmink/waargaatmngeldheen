/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package nl.arnovanoort.vaadintest6;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import nl.arnovanoort.ui.vaadin.SearchView;
import nl.arnovanoort.ui.vaadin.ViewStatistics;
import nl.arnovanoort.ui.vaadin.tree.NavigationTree;
import nl.arnovanoort.wgmgh.domain.Category;
import nl.arnovanoort.wgmgh.domain.Rekening;
import nl.arnovanoort.wgmgh.gui.views.UploadView;
import nl.arnovanoort.wgmgh.readers.impl.TriodosReader;
import nl.arnovanoort.wgmgh.services.CategoryService;
import nl.arnovanoort.wgmgh.services.RekeningService;
import nl.arnovanoort.wgmgh.services.impl.CategoryServiceImpl;
import nl.arnovanoort.wgmgh.upload.UploadReciever;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.Application;
import com.vaadin.data.Item;
import com.vaadin.data.util.POJOContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Select;
import com.vaadin.ui.SplitPanel;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application implements Button.ClickListener  {
	private Window window;


	@Inject 
	SearchView searchView;

	@Inject 
	UploadView uploadView;

	@Inject 
	ViewStatistics viewStatistics;

	@Inject
	private CategoryService categoryService;

	// gui stuff.
	private Button newContact = new Button("Add contact");
	private Button view = new Button("bekijk");
	private Button categorieen = new Button("categorieen bewerken");
	private Button readMutaties = new Button("Inlezen mutaties");
	private SplitPanel horizontalSplit = new SplitPanel(
			SplitPanel.ORIENTATION_HORIZONTAL);
	private NavigationTree tree = new NavigationTree();

	@Override
	public void init() {
		setTheme("waargaatmngeldheen");
		buildMainLayout();
	}

	private void buildMainLayout() {
		window = new Window("My Vaadin Application");
		setMainWindow(window);

		window.setContent(viewStatistics.create());
		/*
		 * Set the initial split position so we can have a 200 pixel menu to the
		 * left
		 */
		horizontalSplit.setSplitPosition(200, SplitPanel.UNITS_PIXELS);
		horizontalSplit.setFirstComponent(tree);
		horizontalSplit.setSecondComponent(searchView.create());

	}

	private VerticalLayout createMainLayout() {
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();

		layout.addComponent(createToolbar());
		layout.addComponent(horizontalSplit);

		/* Allocate all available extra space to the horizontal split panel */

		layout.setExpandRatio(horizontalSplit, 1);
		return layout;
	}
	
//	VerticalLayout createContentStartScreen(){
//		final VerticalLayout mainPanel = new VerticalLayout();
//
//		List<Category> categories = categoryService.getCategories();
//		POJOContainer<Category> container = new POJOContainer(categories,"naam", "vasteLasten");
//		final Select select = new Select("Categorieen", container);
//		select.setItemCaptionMode(Select.ITEM_CAPTION_MODE_PROPERTY);
//		select.setItemCaptionPropertyId("naam");
//
//
//		mainPanel.addComponent(select);
//
//		return mainPanel;
//	}

	public HorizontalLayout createToolbar() {

		HorizontalLayout lo = new HorizontalLayout();
		lo.addComponent(newContact);
		lo.addComponent(view);
		lo.addComponent(categorieen);
		lo.addComponent(readMutaties);
		view.addListener((Button.ClickListener) this);
		readMutaties.addListener((Button.ClickListener) this);
		

		return lo;

	}

	public void buttonClick(ClickEvent event) {
		final Button source = event.getButton();
		if (source == view) {
			horizontalSplit.setSecondComponent(searchView.create());		
		}
		if (source == readMutaties) {
			horizontalSplit.setSecondComponent(uploadView.create());		
		}
	}

}

package com.rocio.hoodfinder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.applayout.AppLayout.Section;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

import utils.ControladorDiccionario;
import views.InterfaceCuriosidades;
import views.InterfaceFormulario;
import views.InterfaceMain;
import views.InterfaceQuestions;

/**
 * The main view contains a button and a click listener.
 */
@CssImport(value = "./styles/shared-styles.css", themeFor = "vaadin-app-layout")
@JsModule("./styles/estilos-web.js")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base", enableInstallPrompt = false)
//@CssImport("./styles/shared-styles.css")
//@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
@Theme(value = Lumo.class)

public class MainView extends AppLayout {

	private final Tabs menu;

//Creamos los labels
	/*
	public static Label menu_principal = new Label("HoodFinder");
	public static Label barrio_ideal = new Label("");
	public static Label curiosidades = new Label("");
	public static Label questions = new Label("");
*/
	public MainView() throws UnsupportedEncodingException {

		//Inicio_idioma();
		
		menu = createMenuTabs();
		Images logo = new Images("https://i.imgur.com/rTrRktv.png?1", "imgur.com");
		logo.setHeight("54px");

		HorizontalLayout horizontal_logo = new HorizontalLayout();
		HorizontalLayout horizontal_menu = new HorizontalLayout();

		VerticalLayout verticalMenu = new VerticalLayout();
		horizontal_logo.add(logo);
		horizontal_logo.setAlignItems(Alignment.START);

		Tab tab = new Tab(2);

		horizontal_menu.setSizeFull();
		horizontal_menu.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
		horizontal_menu.setAlignItems(FlexComponent.Alignment.CENTER);
		horizontal_menu.add(tab, menu);

		addToNavbar(horizontal_logo, horizontal_menu);

		logo.addClickListener(e -> {
			this.getUI().ifPresent(view -> view.navigate("main"));
		});

	}

	private static Tabs createMenuTabs() throws UnsupportedEncodingException {
		final Tabs tabs = new Tabs();
		// tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
		tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
		tabs.setId("tabs");
		Component[] availableTabs = getAvailableTabs();
		tabs.add(availableTabs);
		tabs.add(getAvailableTabs());
		tabs.add(availableTabs);
		return tabs;
	}


	private static Tab[] getAvailableTabs() throws UnsupportedEncodingException {
		// Creamos los iconos
		Icon icon_home = new Icon(VaadinIcon.HOME);
		Icon icon_form = new Icon(VaadinIcon.WORKPLACE);
		Icon icon_curiosidades = new Icon(VaadinIcon.LINE_BAR_CHART);
		Icon icon_questions = new Icon(VaadinIcon.QUESTION);

		// Creamos los horizontal layout
		HorizontalLayout layout_home = new HorizontalLayout();
		HorizontalLayout layout_form = new HorizontalLayout();
		HorizontalLayout layout_curiosidades = new HorizontalLayout();
		HorizontalLayout layout_question = new HorizontalLayout();

		/*
    	barrio_ideal.setText(ControladorDiccionario.Traducir("main.barrioIdeal"));
    	curiosidades.setText(ControladorDiccionario.Traducir("main.curiosidades"));
    	questions.setText(ControladorDiccionario.Traducir("main.preguntas"));
*/
		Label menu_principal = new Label("HoodFinder");
		Label barrio_ideal = new Label("Barrio ideal");
		Label curiosidades = new Label("Blog");
		Label questions = new Label("FAQ");
	
		
		// Añadimos los elementos
		layout_home.add(icon_home, menu_principal);
		layout_form.add(icon_form, barrio_ideal);
		layout_curiosidades.add(icon_curiosidades, curiosidades);
		layout_question.add(icon_questions, questions);

		// Alineamos los layout
		layout_home.setAlignItems(Alignment.CENTER);
		layout_form.setAlignItems(Alignment.CENTER);
		layout_curiosidades.setAlignItems(Alignment.CENTER);
		layout_question.setAlignItems(Alignment.CENTER);

		// Creamos una lista con los tabs
		final List<Tab> tabs = new ArrayList<>();

		// Creamos las tabs
		tabs.add(createTab(layout_home, InterfaceMain.class, 1));
		tabs.add(createTab(layout_form, InterfaceFormulario.class, 1));
		tabs.add(createTab(layout_curiosidades, InterfaceCuriosidades.class, 1));
		tabs.add(createTab(layout_question, InterfaceQuestions.class, 1));

		return tabs.toArray(new Tab[tabs.size()]);

	}

	private static Tab createTab(HorizontalLayout layout, Class<? extends Component> viewClass, int estado) {
		return createTab(populateLink(new RouterLink(null, viewClass), layout), estado);
	}

	private static Tab createTab(Component content, int estado) {
		// Creamos el tab
		final Tab tab = new Tab();

		// Si el estado es 0, establecemos que esta deshabilitado
		if (estado == 0) {
			tab.setEnabled(false);
		}

		// Añadimos el contenido
		tab.add(content);

		// Devolvemos el tab
		return tab;
	}

	private static <T extends HasComponents> T populateLink(T a, HorizontalLayout layout) {
		a.add(layout);
		return a;
	}

	@Override
	protected void afterNavigation() {
		super.afterNavigation();
		selectTab();
	}
	@Override
	private int inventedMethod() {
		System.out.println("nada")
	}

	private void selectTab() {
		String target = RouteConfiguration.forSessionScope().getUrl(getContent().getClass());
		Optional<Component> tabToSelect = menu.getChildren().filter(tab -> {
			Component child = tab.getChildren().findFirst().get();
			return child instanceof RouterLink && ((RouterLink) child).getHref().equals(target);
		}).findFirst();
		tabToSelect.ifPresent(tab -> menu.setSelectedTab((Tab) tab));
	}

	private Component createDrawerContent(Tabs menu) {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSizeFull();
		layout.setPadding(false);
		layout.setSpacing(false);
		layout.getThemeList().set("spacing-s", true);
		layout.setAlignItems(FlexComponent.Alignment.CENTER);
		layout.add(menu);
		return layout;
	}
	
    private void Inicio_idioma () {
    	try {
    		ControladorDiccionario.EstablecerIdioma("lang_ES");
    		//RefrescarDisenoIdioma();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /*
    private void RefrescarDisenoIdioma() {
		try {
	    	barrio_ideal.setText(ControladorDiccionario.Traducir("main.barrioIdeal"));
	    	curiosidades.setText(ControladorDiccionario.Traducir("main.curiosidades"));
	    	questions.setText(ControladorDiccionario.Traducir("main.preguntas"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}*/
}

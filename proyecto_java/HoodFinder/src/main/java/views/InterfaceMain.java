package views;

import com.vaadin.flow.templatemodel.TemplateModel;
import clases.TablaBarrios;
import utils.ControladorDiccionario;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import com.rocio.hoodfinder.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.dom.Element;

@CssImport("./styles/shared-styles.css")
@JsModule("./styles/estilos-web.js")
@PreserveOnRefresh
@Route(value = "main", layout = MainView.class)
@PageTitle("HoodFinder")
@RouteAlias(value = "", layout = MainView.class)
@Tag("interface-main")
@JsModule("./interface-main.js")
public class InterfaceMain extends PolymerTemplate<InterfaceMain.InterfaceMainModel> {

	private static final long serialVersionUID = 1L;

	@Id("title-main")
	private H1 titleMain;
	@Id("descripcion-main")
	private H3 descripcionMain;
	@Id("p-distritos")
	private H3 pDistritos;
	@Id("boton-continuar")
	private Button botonContinuar;
	@Id("vaadin-vertical-layout")
	private VerticalLayout vaadinVerticalLayout;
	@Id("vertical-image")
	private VerticalLayout verticalImage;
	@Id("vaadinHorizontalLayout")
	private HorizontalLayout vaadinHorizontalLayout;
	@Id("vertical-text-distritos")
	private VerticalLayout verticalTextDistritos;
	@Id("pDistritos2")
	private H3 pDistritos2;
	@Id("horizontal-footer")
	private HorizontalLayout horizontalFooter;
	@Id("vertical-logo")
	private VerticalLayout verticalLogo;
	@Id("horizontal-icon-database")
	private HorizontalLayout horizontalIconDatabase;
	@Id("vertical-icons")
	private VerticalLayout verticalIcons;
	@Id("horizontal-icon-mail")
	private HorizontalLayout horizontalIconMail;
	@Id("icono-mail")
	private HorizontalLayout iconoMail;
	@Id("vertical-footer")
	private VerticalLayout verticalFooter;
	@Id("horizontal-icon-recycle")
	private HorizontalLayout horizontalIconRecycle;
	@Id("vertical-icons-2")
	private VerticalLayout verticalIcons2;
	@Id("horizontal-icon-phone")
	private HorizontalLayout horizontalIconPhone;
	@Id("icono-phone")
	private HorizontalLayout iconoPhone;

	/*Checkbox check_esp = new Checkbox("Español");
	Checkbox check_ingles = new Checkbox("Inglés");*/

	ComboBox<String> combo_idioma = new ComboBox();
	
	H3 idLbl = new H3();
	H3 distritosLbl = new H3();
	H3 habitantesLbl = new H3();
	Label objetivosfooter = new Label();
	Label derechosreservados = new Label();
	H4 prueba = new H4();
	
	@Id("vertical-idioma")
	private VerticalLayout verticalIdioma;

	@Id("vertical-madridcielo")
	private VerticalLayout verticalMadridcielo;

	@Id("horizontal-idioma")
	private HorizontalLayout horizontalIdioma;


	public InterfaceMain() throws UnsupportedEncodingException {

		Inicio_idioma();

		combo_idioma.getElement().setAttribute("theme", "small");
        
        
        combo_idioma.setItems("Español/Spanish", "Inglés/English");
        combo_idioma.setValue("Español/Spanish");

        verticalIdioma.add(combo_idioma);
        verticalIdioma.setWidth("35%");

        titleMain.setText(ControladorDiccionario.Traducir("main.title"));
		titleMain.getStyle().set("color", "MidnightBlue");
		titleMain.setWidth("70%");
		horizontalIdioma.setAlignItems(Alignment.CENTER);
		/*
		 * descripcionMain.
		 * add("¿Vas a venir a vivir a Madrid o lo estás pensando? ¿No tienes información sobre qué zona "
		 * + "se ajusta más a tus necesidades?\n" +
		 * "\nEn HoodFinder queremos ayudarte a encontrar un ambiente que " +
		 * "encaje contigo para que te sientas en tu zona de confort. ");
		 */

		descripcionMain.setText(ControladorDiccionario.Traducir("main.descripcionMain"));

		Image imagesss = new Image("https://i.imgur.com/jkXHZ8r.jpg", "imgur.com");
		verticalMadridcielo.add(imagesss);
		verticalMadridcielo.setAlignItems(Alignment.CENTER);
		vaadinHorizontalLayout.setWidthFull();

		Image image = new Image("https://i.imgur.com/i6tInzc.png", "imgur.com");
		verticalImage.add(image);

		
		pDistritos.setText(ControladorDiccionario.Traducir("main.pdistritos"));
		pDistritos2.setText(ControladorDiccionario.Traducir("main.pdistritos2"));

		botonContinuar.setText(ControladorDiccionario.Traducir("main.botonContinuar"));

		List<TablaBarrios> datos_barrios = new ArrayList<>();
		datos_barrios.add(new TablaBarrios(1, "Centro", "140.645"));
		datos_barrios.add(new TablaBarrios(2, "Arganzuela", "155.498"));
		datos_barrios.add(new TablaBarrios(3, "Retiro", "119.643"));
		datos_barrios.add(new TablaBarrios(4, "Salamanca", "146.626"));
		datos_barrios.add(new TablaBarrios(5, "Chamartín", "146.892"));
		datos_barrios.add(new TablaBarrios(6, "Tetuán", "160.886"));
		datos_barrios.add(new TablaBarrios(7, "Chamberí", "139.930"));
		datos_barrios.add(new TablaBarrios(8, "Fuencarral-El Pardo", "249.435"));
		datos_barrios.add(new TablaBarrios(9, "Moncloa-Aravaca", "121.439"));
		datos_barrios.add(new TablaBarrios(10, "Latina", "241.715"));
		datos_barrios.add(new TablaBarrios(11, "Carabanchel", "260.247"));
		datos_barrios.add(new TablaBarrios(12, "Usera", "143.118"));
		datos_barrios.add(new TablaBarrios(13, "Puente de Vallecas", "240.745"));
		datos_barrios.add(new TablaBarrios(14, "Moratalaz", "94.785"));
		datos_barrios.add(new TablaBarrios(15, "Ciudad Lineal", "218.960"));
		datos_barrios.add(new TablaBarrios(16, "Hortaleza", "194.140"));
		datos_barrios.add(new TablaBarrios(17, "Villaverde", "155.390"));
		datos_barrios.add(new TablaBarrios(18, "Villa de Vallecas", "115.275"));
		datos_barrios.add(new TablaBarrios(19, "Vicálvaro", "74.971"));
		datos_barrios.add(new TablaBarrios(20, "San Blas-Canillejas", "161.233"));
		datos_barrios.add(new TablaBarrios(21, "Barajas", "50.228"));

		/*
		 * Grid<TablaBarrios> gridDistritos = new Grid<>(TablaBarrios.class);
		 * gridDistritos.setItems(datos_barrios); gridDistritos.setColumns("id",
		 * "distrito", "habitantes");
		 * gridDistritos.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
		 * 
		 * gridDistritos.getColumnByKey("id").setWidth("40px").setHeader(new H2("Nº"));
		 * gridDistritos.getColumnByKey("distrito").setFlexGrow(3).setFooter("Total: " +
		 * datos_barrios.size() + " distritos").setHeader(new H2("Distrito"));
		 * gridDistritos.getColumnByKey("habitantes").setHeader(new H2("Habitantes"));
		 */

		Grid<TablaBarrios> gridDistritos = new Grid<>();
		// gridDistritos.setItems(datos_barrios);

		ListDataProvider<TablaBarrios> dataP = new ListDataProvider<>(datos_barrios);
		gridDistritos.setDataProvider(dataP);

		idLbl.setText(ControladorDiccionario.Traducir("main.idTabla"));
		distritosLbl.setText(ControladorDiccionario.Traducir("main.distritoTabla"));
		habitantesLbl.setText(ControladorDiccionario.Traducir("main.habitantesTabla"));

		Grid.Column<TablaBarrios> c_id = gridDistritos.addColumn(TablaBarrios::getId, "Id").setHeader(idLbl);
		Grid.Column<TablaBarrios> c_distrito = gridDistritos.addColumn(TablaBarrios::getDistrito, "Distritos")
				.setHeader(distritosLbl);
		Grid.Column<TablaBarrios> c_habitantes = gridDistritos.addColumn(TablaBarrios::getHabitantes, "Habitantes")
				.setHeader(habitantesLbl);

		// gridDistritos.setColumns("id", "distrito", "habitantes");
		gridDistritos.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS,
				GridVariant.LUMO_ROW_STRIPES);

		c_id.setWidth("40px");
		c_distrito.setFlexGrow(3);
		// gridDistritos.getColumnByKey("distrito").setFlexGrow(3);

		verticalTextDistritos.add(gridDistritos);

		verticalTextDistritos.setAlignItems(Alignment.START);
		verticalImage.setAlignItems(Alignment.END);

		botonContinuar.addClickListener(e -> {
			this.getUI().ifPresent(view -> view.navigate("formulario"));
		});

		botonContinuar.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_PRIMARY);

		// FOOTER
		verticalFooter.getStyle().set("background-color", "Snow");
		verticalFooter.setSizeFull();
		horizontalFooter.setSizeFull();
		horizontalIconDatabase.add(new Icon(VaadinIcon.DATABASE));
		horizontalIconDatabase.add(new Anchor("https://datos.madrid.es/portal/site/egob/", "datos.madrid.es         "));
		iconoMail.add(new Icon(VaadinIcon.COMMENTS));
		horizontalIconMail.setAlignItems(Alignment.AUTO);
		iconoPhone.add(new Icon(VaadinIcon.MOBILE));
		horizontalIconPhone.setAlignItems(Alignment.AUTO);
		horizontalIconRecycle.add(new Icon(VaadinIcon.RECYCLE));
		objetivosfooter.setText(ControladorDiccionario.Traducir("footer.objetivos"));
     	horizontalIconRecycle.add(new Anchor("https://www.undp.org/content/undp/es/home/sustainable-development-goals.html", objetivosfooter));
		verticalIcons2.setWidth("500px");
		verticalIcons.setWidth("2000px");
		horizontalIconDatabase.setWidth("350px");
		horizontalIconPhone.setWidth("300");
		derechosreservados.setText(ControladorDiccionario.Traducir("footer.derechosreservados"));
		verticalFooter.add(derechosreservados);
		
		Image logo2 = new Image("https://i.imgur.com/rTrRktv.png?1", "imgur.com");
		logo2.setHeight("100px");
		verticalLogo.add(logo2);
		verticalIcons.setAlignItems(Alignment.START);
		verticalIcons2.setAlignItems(Alignment.CENTER);
		verticalLogo.setAlignItems(Alignment.END);
		verticalFooter.setAlignItems(Alignment.CENTER);
		
/*
		verticalFooter.add(check_esp, check_ingles);

		check_esp.addClickListener(e -> {
			if (check_esp.getValue().equals(true)
					|| (check_esp.getValue().equals(false) && check_ingles.getValue().equals(false))) {
				check_ingles.setValue(false);
				check_esp.setValue(true);
				try {
					ControladorDiccionario.EstablecerIdioma("lang_ES");
					RefrescarDisenoIdioma();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		check_ingles.addClickListener(e -> {
			if (check_ingles.getValue().equals(true)
					|| (check_esp.getValue().equals(false) && check_ingles.getValue().equals(false))) {
				check_esp.setValue(false);
				check_ingles.setValue(true);
				try {
					ControladorDiccionario.EstablecerIdioma("lang_EN");
					RefrescarDisenoIdioma();
				} catch (IOException e1) {

					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});*/
		
		combo_idioma.addValueChangeListener(e-> {
			if(e.getValue().equals("Español/Spanish")) {
				try {
					ControladorDiccionario.EstablecerIdioma("lang_ES");
					RefrescarDisenoIdioma();
					
					
				} catch (IOException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (e.getValue().equals("Inglés/English")) {
				try {
					ControladorDiccionario.EstablecerIdioma("lang_EN");
					RefrescarDisenoIdioma();
					
				} catch (IOException e1) {
					
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
	});

	}

	private void Inicio_idioma() {
		try {
			ControladorDiccionario.EstablecerIdioma("lang_ES");
			//RefrescarDisenoIdioma();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void RefrescarDisenoIdioma() {
		try {
			titleMain.setText(ControladorDiccionario.Traducir("main.title"));
			descripcionMain.setText(ControladorDiccionario.Traducir("main.descripcionMain"));
			pDistritos.setText(ControladorDiccionario.Traducir("main.pdistritos"));
			pDistritos2.setText(ControladorDiccionario.Traducir("main.pdistritos2"));
			botonContinuar.setText(ControladorDiccionario.Traducir("main.botonContinuar"));
			idLbl.setText(ControladorDiccionario.Traducir("main.idTabla"));
			distritosLbl.setText(ControladorDiccionario.Traducir("main.distritoTabla"));
			habitantesLbl.setText(ControladorDiccionario.Traducir("main.habitantesTabla"));
			objetivosfooter.setText(ControladorDiccionario.Traducir("footer.objetivos"));
			derechosreservados.setText(ControladorDiccionario.Traducir("footer.derechosreservados"));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

	/**
	 * This model binds properties between InterfaceMain and interface-main
	 */
	public interface InterfaceMainModel extends TemplateModel {
		// Add setters and getters for template properties here.
	}
}

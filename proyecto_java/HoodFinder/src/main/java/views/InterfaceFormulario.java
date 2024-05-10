package views;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.server.ExternalResource;

import clases.Comentarios;
import clases.TablaBarrios;
import clases.TablaBarrios.*;
import data.BarriosService;
import data.ComentariosService;
import data.InsertComentarios;
import utils.ControladorDiccionario;
import com.vaadin.flow.component.checkbox.Checkbox;
import java.io.UnsupportedEncodingException;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import javax.swing.plaf.ButtonUI;
import com.rocio.hoodfinder.MainView;
import com.vaadin.componentfactory.maps.*;
import com.vaadin.data.Item;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.html.H2;

@Route(value = "formulario" layout = MainView.class)
@PageTitle("HoodFinder")
@Tag("interface-formulario")
@CssImport(value = "./styles/shared-styles.css", themeFor = "vaadin-grid")
@CssImport(value = "./styles/shared-styles.css")
@JsModule("./interface-formulario.js")
public class InterfaceFormulario extends PolymerTemplate<InterfaceFormulario.InterfaceFormularioModel> {

	private static final long serialVersionUID = 1L;

	// Variables
	@Id("vaadinVerticalLayout")
	private VerticalLayout vaadinVerticalLayout;
	@Id("text-form")
	private H3 textForm;
	@Id("titulo-form")
	private H1 tituloForm;
	@Id("vertical-titulo")
	private VerticalLayout verticalTitulo;
	@Id("vertical-clear")
	private VerticalLayout verticalClear;
	@Id("vertical-grid")
	private VerticalLayout verticalGrid;

	private ComboBox <EdadPos> comboBoxEdad;
	private ComboBox <NacionalidadPos> comboBoxNacionalidad;
	private ComboBox <RentaPos> comboBoxRenta;
	private ComboBox <MetroPos> comboBoxValorm2;
	
	private Checkbox checkboxHosteleria;
	private Checkbox checkboxAreasVerdes;
	private Checkbox checkboxColegios;
	private Checkbox checkboxEstaciones;
	private Checkbox checkboxBibliotecas;
	private Checkbox checkboxCentrosDeportivos;
	private Checkbox checkboxCentrosSanitarios;
	private Checkbox checkboxAparcamientos;

	private ComboBox <AgePos> comboBoxEdadI;
	private ComboBox <NacionalityPos> comboBoxNacionalidadI;
	private ComboBox <RentPos> comboBoxRentaI;
	private ComboBox <MetroIPos> comboBoxValorm2I;
	
	private Checkbox checkboxHosteleriaI;
	private Checkbox checkboxAreasVerdesI;
	private Checkbox checkboxColegiosI;
	private Checkbox checkboxEstacionesI;
	private Checkbox checkboxBibliotecasI;
	private Checkbox checkboxCentrosDeportivosI;
	private Checkbox checkboxCentrosSanitariosI;
	private Checkbox checkboxAparcamientosI;

	private Dialog imagenes_barrios;

	List<TablaBarrios> datos_barrios = getBarrios();
	List<Comentarios> datos_comentarios = getComentarios();
	List<TablaBarrios> copia = new ArrayList<>(datos_barrios);
	List<Comentarios> copiacoment = new ArrayList<>(datos_comentarios);

	Grid<TablaBarrios> gridBarrios = new Grid<>();
	Grid<Comentarios> gridComentarios = new Grid<>();
	ListDataProvider<TablaBarrios> dataP = new ListDataProvider<>(copia);
	ListDataProvider<Comentarios> dataC = new ListDataProvider<>(copiacoment);

	Button cerrar = new Button();

	Notification notification = new Notification();
	Label label = new Label();
	Button cerrar2 = new Button();
	@Id("vertical-footer")
	private VerticalLayout verticalFooter;
	@Id()
	private HorizontalLayout horizontalFooter;
	@Id("vertical-icons")
	private VerticalLayout verticalIcons;
	@Id("horizontal-icon-mail")
	private HorizontalLayout horizontalIconMail;
	@Id("icono-mail")
	private HorizontalLayout iconoMail;
	@Id("horizontal-icon-phone")
	private HorizontalLayout horizontalIconPhone;
	@Id("icono-phone")
	private HorizontalLayout iconoPhone;
	@Id("vertical-icons-2")
	private VerticalLayout verticalIcons2;
	@Id("horizontal-icon-database")
	private HorizontalLayout horizontalIconDatabase;
	@Id("horizontal-icon-recycle")
	private HorizontalLayout horizontalIconRecycle;
	@Id("vertical-logo")
	private VerticalLayout verticalLogo;
	@Id("comments")
	private VerticalLayout comments;
	@Id("vertical-print-comments")
	private VerticalLayout verticalPrintComments;
	@Id("vertical-comments")
	private VerticalLayout verticalComments;
	@Id("horizontal-text-transportes")
	private HorizontalLayout horizontalTextTransportes;
	@Id("metro-text")
	private VerticalLayout metroText;
	@Id("cercanias-text")
	private VerticalLayout cercaniasText;
	@Id("bus-text")
	private VerticalLayout busText;
	@Id("titulo-transporte")
	private VerticalLayout tituloTransporte;
	@Id("vertical-transportes")
	private VerticalLayout verticalTransportes;

	@Id("verticalForm")
	private VerticalLayout verticalForm;

	@Id("form-area")
	private FormLayout formArea;

	@Id("form-area2")
	private FormLayout formArea2;

	@Id2("vertical-vecinos")
	private VerticalLayout verticalVecinos;

	@Id("vertical-presupuesto")
	private VerticalLayout verticalPresupuesto;

	@Id("vertical-servicios")
	private VerticalLayout verticalServicios;

	@Id("form-area3")
	private FormLayout formArea3;
	

	@SuppressWarnings("deprecation")
	public InterfaceFormulario() throws UnsupportedEncodingException {

		// Explicación filtros y tabla
		tituloForm.setText(ControladorDiccionario.Traducir("form.title"));
		tituloForm.getStyle().set("color", "MidnightBlue");
		// vaadinVerticalLayout.setVerticalComponentAlignment(Alignment.CENTER,
		// tituloForm);

		textForm.setText(ControladorDiccionario.Traducir("form.descripcion"));
		verticalTitulo.setAlignItems(Alignment.CENTER);

		// TRANSFORMACION
		if (tituloForm.getText().equals("¡Dejame ayudarte a encontrar tu barrio ideal!")) {
			for (int i = 0; i < datos_barrios.size(); i++) {

				String edad_bbdd = datos_barrios.get(i).getEdad_media();
				int edad_int = Integer.parseInt(edad_bbdd);

				if (edad_int >= 31 && edad_int <= 41) {
					datos_barrios.get(i).setEdadPos(EdadPos.Joven);
				} else if (edad_int > 41 && edad_int <= 49) {
					datos_barrios.get(i).setEdadPos(EdadPos.Adulta);
				}

				String nacionalidad_bbdd = datos_barrios.get(i).getNacionalidad_extranjera();
				int nacionalidad_int = Integer.parseInt(nacionalidad_bbdd);

				if (nacionalidad_int >= 4 && nacionalidad_int <= 19) {
					datos_barrios.get(i).setNacionalidadPos(NacionalidadPos.Baja);
				} else if (nacionalidad_int >= 20 && nacionalidad_int < 34) {
					datos_barrios.get(i).setNacionalidadPos(NacionalidadPos.Alta);
				}

				String renta_bbdd = datos_barrios.get(i).getRenta_anual();
				int renta_int = Integer.parseInt(renta_bbdd);

				if (renta_int >= 19700 && renta_int <= 42800) {
					datos_barrios.get(i).setRentaPos(RentaPos.Baja);
				} else if (renta_int >= 42801 && renta_int <= 65900) {
					datos_barrios.get(i).setRentaPos(RentaPos.Media);
				} else if (renta_int >= 65901) {
					datos_barrios.get(i).setRentaPos(RentaPos.Alta);
				}

				String verdes_bbdd = datos_barrios.get(i).getAreas_verdes();
				int verdes_int = Integer.parseInt(verdes_bbdd);

				if (verdes_int >= 50000 && verdes_int <= 17000000) {
					datos_barrios.get(i).setVerdesPos("true");
				} 

				String metro_bbdd = datos_barrios.get(i).getValor_m2();
				int metro_int = Integer.parseInt(metro_bbdd);

				if (metro_int >= 420 && metro_int <= 1050) {
					datos_barrios.get(i).setMetroPos(MetroPos.Bajo);
				} else if (metro_int >= 1051 && metro_int <= 1672) {
					datos_barrios.get(i).setMetroPos(MetroPos.Medio);
				} else if (metro_int >= 1673) {
					datos_barrios.get(i).setMetroPos(MetroPos.Alto);
				}

				String hosteleria_bbdd = datos_barrios.get(i).getHosteleria();
				int hosteleria_int = Integer.parseInt(hosteleria_bbdd);

				if (hosteleria_int >= 50 && hosteleria_int <= 200) {
					datos_barrios.get(i).setHosteleriaPos("true");
				}

				String colegios_bbdd = datos_barrios.get(i).getColegios();
				int colegios_int = Integer.parseInt(colegios_bbdd);

				if (colegios_int >= 11 && colegios_int <= 25) {
					datos_barrios.get(i).setColegiosPos("true");
				}

				String estaciones_bbdd = datos_barrios.get(i).getEstaciones();
				int estaciones_int = Integer.parseInt(estaciones_bbdd);

				if (estaciones_int >= 3 && estaciones_int <= 10) {
					datos_barrios.get(i).setEstacionesPos("true");
				}

				String bibliotecas_bbdd = datos_barrios.get(i).getBibliotecas();
				int bibliotecas_int = Integer.parseInt(bibliotecas_bbdd);

				if (bibliotecas_int >= 1 && bibliotecas_int <= 3) {
					datos_barrios.get(i).setBibliotecasPos("true");
				}

				String centrosDeportivos_bbdd = datos_barrios.get(i).getCentros_deportivos();
				int centrosDeportivos_int = Integer.parseInt(centrosDeportivos_bbdd);

				if (centrosDeportivos_int >= 1 && centrosDeportivos_int <= 6) {
					datos_barrios.get(i).setCentrosDeportivosPos("true");
				}
				
				String centrosSanitarios_bbdd = datos_barrios.get(i).getCentros_sanitarios();
				int centrosSanitarios_int = Integer.parseInt(centrosSanitarios_bbdd);

				if (centrosSanitarios_int >= 3 && centrosDeportivos_int <= 8) {
					datos_barrios.get(i).setCentrosSanitariosPos("true");
				}
				
				String aparcamientos_bbdd = datos_barrios.get(i).getAparcamientos();
				int aparcamientos_int = Integer.parseInt(aparcamientos_bbdd);

				if (aparcamientos_int >= 300 && aparcamientos_int <= 4000) {
					datos_barrios.get(i).setAparcamientoPos("true");
				}
				
			}
		} else {
			for (int i = 0; i < datos_barrios.size(); i++) {
				
				String edad_bbdd = datos_barrios.get(i).getEdad_media();
				int edad_int = Integer.parseInt(edad_bbdd);

				if (edad_int >= 31 && edad_int <= 41) {
					datos_barrios.get(i).setAgePos(AgePos.Young);
				} else if (edad_int > 41 && edad_int <= 49) {
					datos_barrios.get(i).setAgePos(AgePos.Adult);
				}

				String nacionalidad_bbdd = datos_barrios.get(i).getNacionalidad_extranjera();
				int nacionalidad_int = Integer.parseInt(nacionalidad_bbdd);

				if (nacionalidad_int >= 4 && nacionalidad_int <= 19) {
					datos_barrios.get(i).setNacionalityPos(NacionalityPos.Low);
				} else if (nacionalidad_int >= 20 && nacionalidad_int < 34) {
					datos_barrios.get(i).setNacionalityPos(NacionalityPos.High);
				}

				String renta_bbdd = datos_barrios.get(i).getRenta_anual();
				int renta_int = Integer.parseInt(renta_bbdd);

				if (renta_int <= 19700 && renta_int >= 42800) {
					datos_barrios.get(i).setRentPos(RentPos.Low);
				} else if (renta_int >= 42801 && renta_int <= 65900) {
					datos_barrios.get(i).setRentPos(RentPos.Average);
				} else if (renta_int >= 65901) {
					datos_barrios.get(i).setRentPos(RentPos.High);
				}

				String verdes_bbdd = datos_barrios.get(i).getAreas_verdes();
				int verdes_int = Integer.parseInt(verdes_bbdd);

				if (verdes_int >= 50000 && verdes_int <= 17000000) {
					datos_barrios.get(i).setGreenPos("true");
				} 

				String metro_bbdd = datos_barrios.get(i).getValor_m2();
				int metro_int = Integer.parseInt(metro_bbdd);

				if (metro_int >= 420 && metro_int <= 1050) {
					datos_barrios.get(i).setMetroIPos(MetroIPos.Low);
				} else if (metro_int >= 1051 && metro_int <= 1672) {
					datos_barrios.get(i).setMetroIPos(MetroIPos.Average);
				} else if (metro_int >= 1673) {
					datos_barrios.get(i).setMetroIPos(MetroIPos.High);
				}

				String hosteleria_bbdd = datos_barrios.get(i).getHosteleria();
				int hosteleria_int = Integer.parseInt(hosteleria_bbdd);

				if (hosteleria_int >= 50 && hosteleria_int <= 200) {
					datos_barrios.get(i).setRestaurantPos("true");
				}
				
				String colegios_bbdd = datos_barrios.get(i).getColegios();
				int colegios_int = Integer.parseInt(colegios_bbdd);

				if (colegios_int >= 11 && colegios_int <= 25) {
					datos_barrios.get(i).setCollegePos("true");
				}

				String estaciones_bbdd = datos_barrios.get(i).getEstaciones();
				int estaciones_int = Integer.parseInt(estaciones_bbdd);

				if (estaciones_int >= 3 && estaciones_int <= 10) {
					datos_barrios.get(i).setStationsPos("true");
				}
				
				String bibliotecas_bbdd = datos_barrios.get(i).getBibliotecas();
				int bibliotecas_int = Integer.parseInt(bibliotecas_bbdd);

				if (bibliotecas_int >= 1 && bibliotecas_int <= 3) {
					datos_barrios.get(i).setLibraryPos("true");
				}

				String centrosDeportivos_bbdd = datos_barrios.get(i).getCentros_deportivos();
				int centrosDeportivos_int = Integer.parseInt(centrosDeportivos_bbdd);

				if (centrosDeportivos_int >= 1 && centrosDeportivos_int <= 6) {
					datos_barrios.get(i).setScentersPos("false");
				}
				
				String centrosSanitarios_bbdd = datos_barrios.get(i).getCentros_sanitarios();
				int centrosSanitarios_int = Integer.parseInt(centrosSanitarios_bbdd);

				if (centrosSanitarios_int >= 3 && centrosDeportivos_int <= 8) {
					datos_barrios.get(i).setHealthCentersPos("true");
				}
				
				String aparcamientos_bbdd = datos_barrios.get(i).getAparcamientos();
				int aparcamientos_int = Integer.parseInt(aparcamientos_bbdd);

				if (aparcamientos_int >= 300 && aparcamientos_int <= 4000) {
					datos_barrios.get(i).setParkingPos("true");
				}
			}
		}

		// TABLA

		// Introducimos en la tabla los datos de los barrios
		gridBarrios.setDataProvider(dataP);

		H2 titlebarrios = new H2();
		titlebarrios.setText(ControladorDiccionario.Traducir("form.gridtitlebarrios"));
		titlebarrios.getStyle().set("color", "MidnightBlue");
		H2 titledistritos = new H2();
		titledistritos.setText(ControladorDiccionario.Traducir("form.gridtitledistritos"));
		titledistritos.getStyle().set("color", "MidnightBlue");
		// Añadimos las columnas que nos interesan para la tabla
		Grid.Column<TablaBarrios> barriosC = gridBarrios.addColumn(TablaBarrios::getBarrio, "Barrios")
				.setHeader(titlebarrios).setAutoWidth(true).setTextAlign(ColumnTextAlign.CENTER);
		Grid.Column<TablaBarrios> distritosC = gridBarrios.addColumn(TablaBarrios::getDistrito, "Distritos")
				.setHeader(titledistritos).setAutoWidth(true).setTextAlign(ColumnTextAlign.CENTER);
		
		if (tituloForm.getText().equals("\u00A1Dejame ayudarte a encontrar tu barrio ideal!") ) {
			gridBarrios.addComponentColumn(item -> createDetailsButton(item, 0)).setTextAlign(ColumnTextAlign.CENTER);
		} else if(tituloForm.getText().equals("Let me help you find the perfect neighborhood for you!")) {
			gridBarrios.addComponentColumn(item -> createDetailsButton(item, 1)).setTextAlign(ColumnTextAlign.CENTER);
		}
		

		
		gridBarrios.setSelectionMode(Grid.SelectionMode.NONE);

		gridBarrios.setColumnReorderingAllowed(true);
		gridBarrios.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
		gridBarrios.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
		gridBarrios.getStyle().set("background-color", "#FCFCE2");
		cambiarColor();

		verticalGrid.add(gridBarrios);
		verticalGrid.setWidth("800px");
		verticalGrid.setAlignItems(Alignment.CENTER);

		// DETAILS

		cerrar.addClickListener(e -> {
			imagenes_barrios.close();
		});

		///////////////////////////////////// FILTROS PARA LA
		///////////////////////////////////// TABLA///////////////////////////////////////////////////////

		if (tituloForm.getText().equals("\u00A1Dejame ayudarte a encontrar tu barrio ideal!")) {

			// Filtro edad media de la población
			comboBoxEdad = new ComboBox<>();
			comboBoxEdad.setLabel("Edad media de la población");
			comboBoxEdad.getStyle().set("font-weight", "bold");
			comboBoxEdad.setPlaceholder("Sin selección");
			comboBoxEdad.setItems(EdadPos.values());
			comboBoxEdad.setWidthFull();
			comboBoxEdad.addValueChangeListener(e -> {
				applyFilter(dataP);
			});
		
			comboBoxNacionalidad = new ComboBox<>();
			comboBoxNacionalidad.setLabel("Presencia de población extranjera");
			comboBoxNacionalidad.setPlaceholder(ControladorDiccionario.Traducir("form.seleccion"));
			comboBoxNacionalidad.setItems(NacionalidadPos.values());
			comboBoxNacionalidad.setWidthFull();
			comboBoxNacionalidad.addValueChangeListener(e -> {
				applyFilter(dataP);
			});

			comboBoxRenta = new ComboBox<>();
			comboBoxRenta.setLabel("Renta neta media anual");
			H4 rentabaja = new H4("- Baja: ≤ 42.000 €");
			rentabaja.getStyle().set("color", "MidnightBlue");
			H4 rentamedia = new H4("- Media: 42.001 - 66.000 €");
			rentamedia.getStyle().set("color", "MidnightBlue");
			H4 rentaalta = new H4("- Alta: > 66.000 €");
			rentaalta.getStyle().set("color", "MidnightBlue");
			Dialog dialogrenta = new Dialog(rentabaja, rentamedia, rentaalta);
			Button cerrar4 = new Button("Cerrar", e -> dialogrenta.close());
			cerrar4.setWidthFull();
			dialogrenta.add(cerrar4);
			Icon iconRenta = new Icon(VaadinIcon.INFO_CIRCLE);
			iconRenta.addClickListener(e -> dialogrenta.open());
			comboBoxRenta.getElement().appendVirtualChild(iconRenta.getElement());
			comboBoxRenta.getElement().executeJs(
			        "this.$.input.insertBefore($0, this.$.toggleButton)", iconRenta);
			iconRenta.getElement().setAttribute("slot", "suffix");
			iconRenta.getElement().getStyle().set("cursor", "default");
			iconRenta.getElement().executeJs(
			        "this.addEventListener('click',function(e){e.stopPropagation();})");
			iconRenta.getStyle().set("padding-bottom", "0.35em");
			comboBoxRenta.setPlaceholder(ControladorDiccionario.Traducir("form.seleccion"));
			comboBoxRenta.setItems(RentaPos.values());
			comboBoxRenta.setWidthFull();
			comboBoxRenta.addValueChangeListener(e -> {
				applyFilter(dataP);
			});

			checkboxAreasVerdes = new Checkbox();
			checkboxAreasVerdes.setLabel(ControladorDiccionario.Traducir("form.areasverdesPregunta"));
			checkboxAreasVerdes.getStyle().set("font-weight", "bold");
			checkboxAreasVerdes.setWidthFull();
			checkboxAreasVerdes.addValueChangeListener(e -> {
				applyFilter(dataP);
			});

			comboBoxValorm2 = new ComboBox<>();
			comboBoxValorm2.setLabel("Valor medio del inmueble por m²");
			H4 valorm2baja = new H4("- Bajo: ≤ 1.050 €");
			valorm2baja.getStyle().set("color", "MidnightBlue");
			H4 valorm2media = new H4("- Medio: 1.051 - 1.700 €");
			valorm2media.getStyle().set("color", "MidnightBlue");
			H4 valorm2alta = new H4("- Alto: > 1.700 €");
			valorm2alta.getStyle().set("color", "MidnightBlue");
			
			Dialog dialogvalorm2 = new Dialog(valorm2baja, valorm2media, valorm2alta);
			Button cerrar3 = new Button("Cerrar", e -> dialogvalorm2.close());
			cerrar3.setWidthFull();
			dialogvalorm2.add(cerrar3);
			Icon iconvalorm2 = new Icon(VaadinIcon.INFO_CIRCLE);
			iconvalorm2.addClickListener(e -> dialogvalorm2.open());
			comboBoxValorm2.getElement().appendVirtualChild(iconvalorm2.getElement());
			comboBoxValorm2.getElement().executeJs(
			        "this.$.input.insertBefore($0, this.$.toggleButton)", iconvalorm2);
			iconvalorm2.getElement().setAttribute("slot", "suffix");
			iconvalorm2.getElement().getStyle().set("cursor", "default");
			iconvalorm2.getElement().executeJs(
			        "this.addEventListener('click',function(e){e.stopPropagation();})");
			iconvalorm2.getStyle().set("padding-bottom", "0.35em");
			comboBoxValorm2.setPlaceholder(ControladorDiccionario.Traducir("form.seleccion"));
			comboBoxValorm2.setItems(MetroPos.values());
			comboBoxValorm2.setWidthFull();
			comboBoxValorm2.addValueChangeListener(e -> {
				applyFilter(dataP);
			});
			

			checkboxHosteleria = new Checkbox();
			checkboxHosteleria.setLabel("Restaurantes");
			checkboxHosteleria.getStyle().set("font-weight", "bold");
			checkboxHosteleria.setWidthFull();
			checkboxHosteleria.addValueChangeListener(e -> {
				applyFilter(dataP);
			});

			checkboxColegios = new Checkbox();
			checkboxColegios.setLabel("Colegios");
			checkboxColegios.getStyle().set("font-weight", "bold");
			checkboxColegios.setWidthFull();
			checkboxColegios.addValueChangeListener(e -> {
				applyFilter(dataP);
			});

			checkboxEstaciones = new Checkbox();
			checkboxEstaciones.setLabel("Estaciones de metro");
			checkboxEstaciones.getStyle().set("font-weight", "bold");
			checkboxEstaciones.setWidthFull();
			checkboxEstaciones.addValueChangeListener(e -> {
				applyFilter(dataP);
			});

			checkboxBibliotecas = new Checkbox();
			checkboxBibliotecas.setLabel("Bibliotecas");
			checkboxBibliotecas.getStyle().set("font-weight", "bold");
			checkboxBibliotecas.setWidthFull();
			checkboxBibliotecas.addValueChangeListener(e -> {
				applyFilter(dataP);
			});

			checkboxCentrosDeportivos = new Checkbox();
			checkboxCentrosDeportivos.setLabel("Centros deportivos");
			checkboxCentrosDeportivos.getStyle().set("font-weight", "bold");
			checkboxCentrosDeportivos.setWidthFull();
			checkboxCentrosDeportivos.addValueChangeListener(e -> {
				applyFilter(dataP);
			});
			
			checkboxCentrosSanitarios = new Checkbox();
			checkboxCentrosSanitarios.setLabel("Centros sanitarios");
			checkboxCentrosSanitarios.getStyle().set("font-weight", "bold");
			checkboxCentrosSanitarios.setWidthFull();
			checkboxCentrosSanitarios.addValueChangeListener(e -> {
				applyFilter(dataP);
			});
			
			checkboxAparcamientos = new Checkbox();
			checkboxAparcamientos.setLabel("Plazas de aparcamiento");
			checkboxAparcamientos.getStyle().set("font-weight", "bold");
			checkboxAparcamientos.setWidthFull();
			checkboxAparcamientos.addValueChangeListener(e -> {
				applyFilter(dataP);
			});
			
			
			verticalVecinos.add(new H3("¿Cómo te gustaría que fueran tus vecinos?"));
			verticalVecinos.getStyle().set("color", "MidnightBlue");
			verticalVecinos.setHeight("15px");
			verticalVecinos.setAlignItems(Alignment.CENTER);
			
			verticalPresupuesto.add(new H3("¿Qué características económicas buscas?"));
			verticalPresupuesto.getStyle().set("color", "MidnightBlue");
			verticalPresupuesto.setHeight("15px");
			verticalPresupuesto.setAlignItems(Alignment.CENTER);
			
			verticalServicios.add(new H3("¿Cuáles de los siguientes servicios necesitas?"));
			verticalServicios.getStyle().set("color", "MidnightBlue");
			verticalServicios.setHeight("15px");
			verticalServicios.setAlignItems(Alignment.CENTER);

		} else if (tituloForm.getText().equals("Let me help you find the perfect neighborhood for you!")) {
			// Filtro edad media de la población
			comboBoxEdadI = new ComboBox<>();
			comboBoxEdadI.setLabel("Average Age: ");
			comboBoxEdadI.setPlaceholder("No selection");
			comboBoxEdadI.getStyle().set("font-weight", "bold");
			comboBoxEdadI.setItems(AgePos.values());
			comboBoxEdadI.setWidthFull();
			comboBoxEdadI.addValueChangeListener(e -> {
				applyFilterI(dataP);
			});

			comboBoxNacionalidadI = new ComboBox<>();
			comboBoxNacionalidadI.setLabel("Nationality: ");
			comboBoxNacionalidadI.setPlaceholder("No selection");
			comboBoxNacionalidadI.setItems(NacionalityPos.values());
			comboBoxNacionalidadI.setWidthFull();
			comboBoxNacionalidadI.addValueChangeListener(e -> {
				applyFilterI(dataP);
			});

			comboBoxRentaI = new ComboBox<>();
			comboBoxRentaI.setLabel("Average net income of the population: ");
			H4 rentabaja = new H4("- Low: ≤ 42.000 €");
			rentabaja.getStyle().set("color", "MidnightBlue");
			H4 rentamedia = new H4("- Average: 42.001 - 66.000 €");
			rentamedia.getStyle().set("color", "MidnightBlue");
			H4 rentaalta = new H4("- High: > 66.000 €");
			rentaalta.getStyle().set("color", "MidnightBlue");
			Dialog dialogrenta = new Dialog(rentabaja, rentamedia, rentaalta);
			Button cerrar4 = new Button("Close", e -> dialogrenta.close());
			cerrar4.setWidthFull();
			dialogrenta.add(cerrar4);
			Icon iconRenta = new Icon(VaadinIcon.INFO_CIRCLE);
			iconRenta.addClickListener(e -> dialogrenta.open());
			comboBoxRentaI.getElement().appendVirtualChild(iconRenta.getElement());
			comboBoxRentaI.getElement().executeJs(
			        "this.$.input.insertBefore($0, this.$.toggleButton)", iconRenta);
			iconRenta.getElement().setAttribute("slot", "suffix");
			iconRenta.getElement().getStyle().set("cursor", "default");
			iconRenta.getElement().executeJs(
			        "this.addEventListener('click',function(e){e.stopPropagation();})");
			iconRenta.getStyle().set("padding-bottom", "0.35em");
			comboBoxRentaI.setPlaceholder("No selection");
			comboBoxRentaI.getStyle().set("font-weight", "bold");
			comboBoxRentaI.setItems(RentPos.values());
			comboBoxRentaI.setWidthFull();
			comboBoxRentaI.addValueChangeListener(e -> {
				applyFilterI(dataP);
			});

			checkboxAreasVerdesI = new Checkbox();
			checkboxAreasVerdesI.setLabel("Green areas: ");
			checkboxAreasVerdesI.getStyle().set("font-weight", "bold");
			checkboxAreasVerdesI.setWidthFull();
			checkboxAreasVerdesI.addValueChangeListener(e -> {
				applyFilterI(dataP);
			});

			comboBoxValorm2I = new ComboBox<>();
			comboBoxValorm2I.setLabel("Property value per m2: ");
			
			H4 valorm2baja = new H4("- Low: ≤ 1.050 €");
			valorm2baja.getStyle().set("color", "MidnightBlue");
			H4 valorm2media = new H4("- Average: 1.051 - 1.700 €");
			valorm2media.getStyle().set("color", "MidnightBlue");
			H4 valorm2alta = new H4("- High: > 1.700 €");
			valorm2alta.getStyle().set("color", "MidnightBlue");
			Dialog dialogvalorm2 = new Dialog(valorm2baja, valorm2media, valorm2alta);
			Button cerrar3 = new Button("Cerrar", e -> dialogvalorm2.close());
			cerrar3.setWidthFull();
			dialogvalorm2.add(cerrar3);
			Icon iconvalorm2 = new Icon(VaadinIcon.INFO_CIRCLE);
			iconvalorm2.addClickListener(e -> dialogvalorm2.open());
			comboBoxValorm2I.getElement().appendVirtualChild(iconvalorm2.getElement());
			comboBoxValorm2I.getElement().executeJs(
			        "this.$.input.insertBefore($0, this.$.toggleButton)", iconvalorm2);
			iconvalorm2.getElement().setAttribute("slot", "suffix");
			iconvalorm2.getElement().getStyle().set("cursor", "default");
			iconvalorm2.getElement().executeJs(
			        "this.addEventListener('click',function(e){e.stopPropagation();})");
			iconvalorm2.getStyle().set("padding-bottom", "0.35em");
			
			comboBoxValorm2I.getStyle().set("font-weight", "bold");
			comboBoxValorm2I.setPlaceholder("No selection");
			comboBoxValorm2I.setItems(MetroIPos.values());
			comboBoxValorm2I.setWidthFull();
			comboBoxValorm2I.addValueChangeListener(e -> {
				applyFilterI(dataP);
			});

			checkboxHosteleriaI = new Checkbox();
			checkboxHosteleriaI.setLabel("Restaurants: ");
			checkboxHosteleriaI.getStyle().set("font-weight", "bold");
			checkboxHosteleriaI.setWidthFull();
			checkboxHosteleriaI.addValueChangeListener(e -> {
				applyFilterI(dataP);
			});

			checkboxColegiosI = new Checkbox();
			checkboxColegiosI.setLabel("Schools: ");
			checkboxColegiosI.getStyle().set("font-weight", "bold");
			checkboxColegiosI.setWidthFull();
			checkboxColegiosI.addValueChangeListener(e -> {
				applyFilterI(dataP);
			});

			checkboxEstacionesI = new Checkbox();
			checkboxEstacionesI.setLabel("Metro stations: ");
			checkboxEstacionesI.getStyle().set("font-weight", "bold");
			checkboxEstacionesI.setWidthFull();
			checkboxEstacionesI.addValueChangeListener(e -> {
				applyFilterI(dataP);
			});

			checkboxBibliotecasI = new Checkbox();
			checkboxBibliotecasI.setLabel("Libraries: ");
			checkboxBibliotecasI.getStyle().set("font-weight", "bold");
			checkboxBibliotecasI.setWidthFull();
			checkboxBibliotecasI.addValueChangeListener(e -> {
				applyFilterI(dataP);
			});

			checkboxCentrosDeportivosI = new Checkbox();
			checkboxCentrosDeportivosI.setLabel("Sports centres: ");
			checkboxCentrosDeportivosI.getStyle().set("font-weight", "bold");
			checkboxCentrosDeportivosI.setWidthFull();
			checkboxCentrosDeportivosI.addValueChangeListener(e -> {
				applyFilterI(dataP);
			});
					
			checkboxCentrosSanitariosI = new Checkbox();
			checkboxCentrosSanitariosI.setLabel("Health Centers");
			checkboxCentrosSanitariosI.getStyle().set("font-weight", "bold");
			checkboxCentrosSanitariosI.setWidthFull();
			checkboxCentrosSanitariosI.addValueChangeListener(e -> {
				applyFilterI(dataP);
			});
			
			checkboxAparcamientosI = new Checkbox();
			checkboxAparcamientosI.setLabel("Parkings");
			checkboxAparcamientosI.getStyle().set("font-weight", "bold");
			checkboxAparcamientosI.setWidthFull();
			checkboxAparcamientosI.addValueChangeListener(e -> {
				applyFilterI(dataP);
			});
			
			
			verticalVecinos.add(new H3("What kind of neighbors wold you like to have?"));
			verticalVecinos.getStyle().set("color", "MidnightBlue");
			verticalVecinos.setHeight("15px");
			verticalVecinos.setAlignItems(Alignment.CENTER);
			
			verticalPresupuesto.add(new H3("What economic characteristics are you looking for?"));
			verticalPresupuesto.getStyle().set("color", "MidnightBlue");
			verticalPresupuesto.setHeight("15px");
			verticalPresupuesto.setAlignItems(Alignment.CENTER);
			
			verticalServicios.add(new H3("Which of the following services do you need?"));
			verticalServicios.getStyle().set("color", "MidnightBlue");
			verticalServicios.setHeight("15px");
			verticalServicios.setAlignItems(Alignment.CENTER);
		}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    	
		// Botón para borrar todos los filtros seleccionados
		Button clearButton = new Button("Limpiar todos los filtros", event -> {
			comboBoxEdad.clear();
			comboBoxNacionalidad.clear();
			comboBoxRenta.clear();
			checkboxAreasVerdes.clear();
			comboBoxValorm2.clear();
			checkboxHosteleria.clear();
			checkboxColegios.clear();
			checkboxEstaciones.clear();
			checkboxBibliotecas.clear();
			checkboxCentrosDeportivos.clear();
			checkboxCentrosSanitarios.clear();
			checkboxAparcamientos.clear();

			dataP.clearFilters();
		});

		Button clearButtonI = new Button("Clean all filters", event -> {

			comboBoxEdadI.clear();
			comboBoxNacionalidadI.clear();
			comboBoxRentaI.clear();
			checkboxAreasVerdesI.clear();
			comboBoxValorm2I.clear();
			checkboxHosteleriaI.clear();
			checkboxColegiosI.clear();
			checkboxEstacionesI.clear();
			checkboxBibliotecasI.clear();
			checkboxCentrosDeportivosI.clear();
			checkboxCentrosSanitariosI.clear();
			checkboxAparcamientosI.clear();

			dataP.clearFilters();
		});

		verticalForm.getStyle().set("background-color", "#F0F6FB");
		verticalForm.getStyle().set("border-radius", "30px");
		
		clearButton.addClickShortcut(Key.KEY_L, KeyModifier.ALT).listenOn(formArea);
		clearButton.addClickShortcut(Key.KEY_L, KeyModifier.ALT).listenOn(formArea2);
		clearButton.addClickShortcut(Key.KEY_L, KeyModifier.ALT).listenOn(formArea3);

		clearButton.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_PRIMARY);

		clearButtonI.addClickShortcut(Key.KEY_L, KeyModifier.ALT).listenOn(formArea);
		clearButtonI.addClickShortcut(Key.KEY_L, KeyModifier.ALT).listenOn(formArea2);
		clearButtonI.addClickShortcut(Key.KEY_L, KeyModifier.ALT).listenOn(formArea3);

		clearButtonI.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_PRIMARY);

		// botones para borrar los datos en cada combobox
		Button boton_edad = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE_O), e -> {
			comboBoxEdad.clear();
			dataP.refreshAll();
		});

		Button boton_nacionalidad = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE_O), e -> {
			comboBoxNacionalidad.clear();
			dataP.refreshAll();
		});

		Button boton_renta = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE_O), e -> {
			comboBoxRenta.clear();
			dataP.refreshAll();
		});

		Button boton_metro = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE_O), e -> {
			comboBoxValorm2.clear();
			dataP.refreshAll();
		});

		Button boton_edadI = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE_O), e -> {
			comboBoxEdadI.clear();
			dataP.refreshAll();
		});

		Button boton_nacionalidadI = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE_O), e -> {
			comboBoxNacionalidadI.clear();
			dataP.refreshAll();
		});

		Button boton_rentaI = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE_O), e -> {
			comboBoxRentaI.clear();
			dataP.refreshAll();
		});

		Button boton_metroI = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE_O), e -> {
			comboBoxValorm2I.clear();
			dataP.refreshAll();
		});

	

		if (tituloForm.getText().equals("\u00A1Dejame ayudarte a encontrar tu barrio ideal!")) {
			HorizontalLayout horizontal_edad = new HorizontalLayout();
			horizontal_edad.setAlignItems(Alignment.BASELINE);
			horizontal_edad.setWidthFull();
			horizontal_edad.add(comboBoxEdad, boton_edad);

			HorizontalLayout horizontal_nacionalidad = new HorizontalLayout();
			horizontal_nacionalidad.setAlignItems(Alignment.BASELINE);
			horizontal_nacionalidad.setWidthFull();
			horizontal_nacionalidad.add(comboBoxNacionalidad, boton_nacionalidad);

			HorizontalLayout horizontal_renta = new HorizontalLayout();
			horizontal_renta.setAlignItems(Alignment.BASELINE);
			horizontal_renta.setWidthFull();
			horizontal_renta.add(comboBoxRenta, boton_renta);

			HorizontalLayout horizontal_verdes = new HorizontalLayout();
			horizontal_verdes.setAlignItems(Alignment.BASELINE);
			horizontal_verdes.setWidthFull();
			horizontal_verdes.add(checkboxAreasVerdes);

			HorizontalLayout horizontal_metro = new HorizontalLayout();
			horizontal_metro.setAlignItems(Alignment.BASELINE);
			horizontal_metro.setWidthFull();
			horizontal_metro.add(comboBoxValorm2, boton_metro);

			HorizontalLayout horizontal_hosteleria = new HorizontalLayout();
			horizontal_hosteleria.setAlignItems(Alignment.BASELINE);
			horizontal_hosteleria.setWidthFull();
			horizontal_hosteleria.add(checkboxHosteleria);

			HorizontalLayout horizontal_colegios = new HorizontalLayout();
			horizontal_colegios.setAlignItems(Alignment.BASELINE);
			horizontal_colegios.setWidthFull();
			horizontal_colegios.add(checkboxColegios);

			HorizontalLayout horizontal_estaciones = new HorizontalLayout();
			horizontal_estaciones.setAlignItems(Alignment.BASELINE);
			horizontal_estaciones.setWidthFull();
			horizontal_estaciones.add(checkboxEstaciones);

			HorizontalLayout horizontal_centrosDeportivos = new HorizontalLayout();
			horizontal_centrosDeportivos.setAlignItems(Alignment.BASELINE);
			horizontal_centrosDeportivos.setWidthFull();
			horizontal_centrosDeportivos.add(checkboxCentrosDeportivos);

			HorizontalLayout horizontal_bibliotecas = new HorizontalLayout();
			horizontal_bibliotecas.setAlignItems(Alignment.BASELINE);
			horizontal_bibliotecas.setWidthFull();
			horizontal_bibliotecas.add(checkboxBibliotecas);
			
			HorizontalLayout horizontal_centrosSanitarios = new HorizontalLayout();
			horizontal_centrosSanitarios.setAlignItems(Alignment.BASELINE);
			horizontal_centrosSanitarios.setWidthFull();
			horizontal_centrosSanitarios.add(checkboxCentrosSanitarios);

			HorizontalLayout horizontal_aparcamientos = new HorizontalLayout();
			horizontal_aparcamientos.setAlignItems(Alignment.BASELINE);
			horizontal_aparcamientos.setWidthFull();
			horizontal_aparcamientos.add(checkboxAparcamientos);
			
			// Añadimos los filtros al layout del formulario
			formArea.add(horizontal_edad, horizontal_nacionalidad);
			formArea2.add(horizontal_renta, horizontal_metro);
			VerticalLayout horizontalPrueba = new VerticalLayout();
			horizontalPrueba.add(horizontal_hosteleria, horizontal_colegios, horizontal_aparcamientos, horizontal_centrosSanitarios);
			horizontalPrueba.setAlignItems(Alignment.CENTER);
			horizontalPrueba.getElement().getStyle().set("align-items", "center");
			VerticalLayout horizontalPrueba2 = new VerticalLayout();
			horizontalPrueba2.add(horizontal_verdes, horizontal_bibliotecas, horizontal_estaciones, horizontal_centrosDeportivos);
			formArea3.add(horizontalPrueba, horizontalPrueba2);
			formArea3.getElement().getStyle().set("align-items", "center");
			/*formArea3.add(horizontal_hosteleria,horizontal_verdes, 
					horizontal_colegios, horizontal_bibliotecas,
					horizontal_aparcamientos, horizontal_estaciones, 
					horizontal_centrosSanitarios, horizontal_centrosDeportivos);
			
			*/

			verticalForm.add(clearButton);
			verticalForm.setAlignItems(Alignment.CENTER);

		} else if (tituloForm.getText().equals("Let me help you find the perfect neighborhood for you!")) {
			HorizontalLayout horizontal_edad = new HorizontalLayout();
			horizontal_edad.setAlignItems(Alignment.BASELINE);
			horizontal_edad.setWidthFull();
			horizontal_edad.add(comboBoxEdadI, boton_edadI);

			HorizontalLayout horizontal_nacionalidad = new HorizontalLayout();
			horizontal_nacionalidad.setAlignItems(Alignment.BASELINE);
			horizontal_nacionalidad.setWidthFull();
			horizontal_nacionalidad.add(comboBoxNacionalidadI, boton_nacionalidadI);

			HorizontalLayout horizontal_renta = new HorizontalLayout();
			horizontal_renta.setAlignItems(Alignment.BASELINE);
			horizontal_renta.setWidthFull();
			horizontal_renta.add(comboBoxRentaI, boton_rentaI);

			HorizontalLayout horizontal_verdes = new HorizontalLayout();
			horizontal_verdes.setAlignItems(Alignment.BASELINE);
			horizontal_verdes.setWidthFull();
			horizontal_verdes.add(checkboxAreasVerdesI);

			HorizontalLayout horizontal_metro = new HorizontalLayout();
			horizontal_metro.setAlignItems(Alignment.BASELINE);
			horizontal_metro.setWidthFull();
			horizontal_metro.add(comboBoxValorm2I, boton_metroI);

			HorizontalLayout horizontal_hosteleria = new HorizontalLayout();
			horizontal_hosteleria.setAlignItems(Alignment.BASELINE);
			horizontal_hosteleria.setWidthFull();
			horizontal_hosteleria.add(checkboxHosteleriaI);

			HorizontalLayout horizontal_colegios = new HorizontalLayout();
			horizontal_colegios.setAlignItems(Alignment.BASELINE);
			horizontal_colegios.setWidthFull();
			horizontal_colegios.add(checkboxColegiosI);

			HorizontalLayout horizontal_estaciones = new HorizontalLayout();
			horizontal_estaciones.setAlignItems(Alignment.BASELINE);
			horizontal_estaciones.setWidthFull();
			horizontal_estaciones.add(checkboxEstacionesI);

			HorizontalLayout horizontal_centrosDeportivos = new HorizontalLayout();
			horizontal_centrosDeportivos.setAlignItems(Alignment.BASELINE);
			horizontal_centrosDeportivos.setWidthFull();
			horizontal_centrosDeportivos.add(checkboxCentrosDeportivosI);

			HorizontalLayout horizontal_bibliotecas = new HorizontalLayout();
			horizontal_bibliotecas.setAlignItems(Alignment.BASELINE);
			horizontal_bibliotecas.setWidthFull();
			horizontal_bibliotecas.add(checkboxBibliotecasI);
			
			HorizontalLayout horizontal_centrosSanitarios = new HorizontalLayout();
			horizontal_centrosSanitarios.setAlignItems(Alignment.BASELINE);
			horizontal_centrosSanitarios.setWidthFull();
			horizontal_centrosSanitarios.add(checkboxCentrosSanitariosI);

			HorizontalLayout horizontal_aparcamientos = new HorizontalLayout();
			horizontal_aparcamientos.setAlignItems(Alignment.BASELINE);
			horizontal_aparcamientos.setWidthFull();
			horizontal_aparcamientos.add(checkboxAparcamientosI);
			
			
			// Añadimos los filtros al layout del formulario
			formArea.add(horizontal_edad, horizontal_nacionalidad);
			formArea2.add(horizontal_renta, horizontal_metro);
			VerticalLayout horizontalPrueba = new VerticalLayout();
			horizontalPrueba.add(horizontal_hosteleria, horizontal_colegios, horizontal_aparcamientos, horizontal_centrosSanitarios);
			horizontalPrueba.setAlignItems(Alignment.CENTER);
			horizontalPrueba.getElement().getStyle().set("align-items", "center");
			VerticalLayout horizontalPrueba2 = new VerticalLayout();
			horizontalPrueba2.add(horizontal_verdes, horizontal_bibliotecas, horizontal_estaciones, horizontal_centrosDeportivos);
			formArea3.add(horizontalPrueba, horizontalPrueba2);
			formArea3.getElement().getStyle().set("align-items", "center");

			verticalForm.add(clearButtonI);
			verticalForm.setAlignItems(Alignment.CENTER);
		}

		// TRANSPORTES
		H1 transporth2 = new H1();
		transporth2.setText(ControladorDiccionario.Traducir("form.transportes"));
		transporth2.getStyle().set("color", "MidnightBlue");
		tituloTransporte.add(transporth2);
		tituloTransporte.setAlignItems(Alignment.CENTER);

		// METRO
		Button botonMetro = new Button();
		botonMetro.setText(ControladorDiccionario.Traducir("form.botonMetro"));

		botonMetro.addClickListener(e -> {
			UI.getCurrent().getPage().executeJavaScript(
					"window.open(\"https://www.metromadrid.es/sites/default/files/documentos/Viaja%20en%20Metro/Planos/Planoesquematico.pdf\", \"_self\");");
		});
		Image metroLogo = new Image("https://i.imgur.com/YrfLUHI.png", "imgur.com");
		metroLogo.setWidth("200px");
		metroLogo.setHeight("100px");
		metroText.add(metroLogo);
		metroText.add(new H4(ControladorDiccionario.Traducir("form.textMetro")));
		metroText.setAlignItems(Alignment.CENTER);
		metroText.getStyle().set("text-align", "justify");
		metroText.add(botonMetro);

		botonMetro.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_PRIMARY);

		// CERCANIAS
		Button botonCercanias = new Button();
		botonCercanias.setText(ControladorDiccionario.Traducir("form.botonCercanias"));
		botonCercanias.getStyle().set("margin-top", "40px");
		botonCercanias.addClickListener(e -> {
			UI.getCurrent().getPage().executeJavaScript(
					"window.open(\"https://barriosdemadrid.net/wp-content/uploads/2013/02/mapa-cercanias-madrid.jpg\", \"_self\");");
		});

		Image cercaniasLogo = new Image("https://i.imgur.com/lEs7MRf.png", "imgur.com");
		cercaniasLogo.setWidth("100px");
		cercaniasLogo.setHeight("100px");
		cercaniasText.add(cercaniasLogo);
		cercaniasText.add(new H4(ControladorDiccionario.Traducir("form.textCercanias")));
		cercaniasText.setAlignItems(Alignment.CENTER);
		cercaniasText.getStyle().set("text-align", "justify");
		cercaniasText.add(botonCercanias);

		botonCercanias.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_PRIMARY);

		// BUS
		Button botonBus = new Button();
		
		botonBus.setText(ControladorDiccionario.Traducir("form.botonBus"));
		
		botonBus.getStyle().set("margin-top", "40px");
		botonBus.addClickListener(e -> {
			UI.getCurrent().getPage().executeJavaScript(
					"window.open(\"https://www.crtm.es/media/147671/serie_3_madrid_plano_es.pdf\", \"_self\");");
		});

		Image busLogo = new Image("https://i.imgur.com/nwPOm0R.png", "imgur.com");
		busLogo.setWidth("200px");
		busLogo.setHeight("100px");
		busText.add(busLogo);
		busText.add(new H4(ControladorDiccionario.Traducir("form.textBus")));
		busText.setAlignItems(Alignment.CENTER);
		busText.getStyle().set("text-align", "justify");
		busText.add(botonBus);
		// Image metroLogo = new Image("https://i.imgur.com/YrfLUHI.png", "imgur.com");

		botonBus.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_PRIMARY);
		
		
		verticalTransportes.setAlignItems(Alignment.CENTER);

		InsertComentarios incom = new InsertComentarios();

		// COMMENTS
		Comentarios com = new Comentarios();
		H1 h2Titulo = new H1(ControladorDiccionario.Traducir("form.parrafoopinion"));
		h2Titulo.getStyle().set("align-self", "center");
		h2Titulo.getStyle().set("color", "MidnightBlue");
		Paragraph pc2 = new Paragraph(ControladorDiccionario.Traducir("form.parrafoopinion2"));
		pc2.getStyle().set("color", "Red");
		TextField nameField = new TextField();
		nameField.setLabel(ControladorDiccionario.Traducir("form.nameopinion"));
		nameField.setPlaceholder("Marta");

		TextField barrioCField = new TextField();
		barrioCField.setLabel(ControladorDiccionario.Traducir("form.barrioopinion"));
		barrioCField.setPlaceholder("Ibiza / Retiro");

		TextArea textArea = new TextArea(ControladorDiccionario.Traducir("form.textopinion"));
		textArea.getStyle().set("minWidth", "800px");
		textArea.getStyle().set("minHeight", "150px");
		textArea.setPlaceholder(ControladorDiccionario.Traducir("form.placeholderopinion"));

		Notification comentario = new Notification(
		        "Comentario enviado", 3000);
		
		VerticalLayout prueba = new VerticalLayout();

		gridComentarios.setDataProvider(dataC);

		// Icon iconUser = new Icon(VaadinIcon.USER);
		gridComentarios.addComponentColumn(item -> {
			Icon icon;
			icon = VaadinIcon.USER.create();
			icon.setColor("MidnightBlue");
			icon.setSize("30px");
			icon.getStyle().set("padding", "10px");
			return icon;
		});
		
		gridComentarios.getElement().getStyle().set("border-radius", "30px");
		
		H2 nombreHeader = new H2(ControladorDiccionario.Traducir("form.nombregridopinion"));
		nombreHeader.getStyle().set("color", "MidnightBlue");
		H2 barrioHeader = new H2(ControladorDiccionario.Traducir("form.barriogridopinion"));
		barrioHeader.getStyle().set("color", "MidnightBlue");
		H2 opinionHeader = new H2(ControladorDiccionario.Traducir("form.opiniongridopinion"));
		opinionHeader.getStyle().set("color", "MidnightBlue");
		VerticalLayout barrioContent = new VerticalLayout();
		VerticalLayout opinionContent = new VerticalLayout();
		barrioContent.setSizeFull();
		opinionContent.setSizeFull();
		barrioContent.setPadding(false);
		opinionContent.setPadding(false);
		barrioContent.setSpacing(false);
		opinionContent.setSpacing(false);
		barrioContent.setMargin(false);
		opinionContent.setMargin(false);
		barrioContent.add(barrioHeader);
		opinionContent.add(opinionHeader);
		barrioContent.setHorizontalComponentAlignment(Alignment.CENTER, barrioHeader);
		opinionContent.setHorizontalComponentAlignment(Alignment.CENTER, opinionHeader);

		// Añadimos las columnas que nos interesan para la tabla
		Grid.Column<Comentarios> nombreC = gridComentarios.addColumn(Comentarios::getNombre, "Nombre")
				.setHeader(nombreHeader).setAutoWidth(true)
				.setFooter("Total: " + datos_comentarios.size() + " comentarios");
		;
		Grid.Column<Comentarios> barrioC = gridComentarios.addColumn(Comentarios::getBarrioC, "Barrio / Distrito")
				.setAutoWidth(true).setHeader(barrioContent);
		Grid.Column<Comentarios> comentarioC = gridComentarios.addColumn(Comentarios::getComentario, "Opinión")
				.setHeader(opinionContent).setWidth("400px");

		gridComentarios.setItemDetailsRenderer(TemplateRenderer.<Comentarios>of(
				"<div class='custom-details' style='border: 1px solid gray; padding: 10px; width: 100%; box-sizing: border-box;'>"
						+ "<div><b>[[item.comentarioC]]!</b></div>" + "</div>")
				.withProperty("comentarioC", Comentarios::getComentario)
				// This is now how we open the details
				.withEventHandler("handleClick", person -> {
					gridComentarios.getDataProvider().refreshItem(person);
				}));

		gridComentarios.setDetailsVisibleOnClick(false);

		gridComentarios.addColumn(new NativeButtonRenderer<>(ControladorDiccionario.Traducir("form.leermasgrid"),
				item -> gridComentarios.setDetailsVisible(item, !gridComentarios.isDetailsVisible(item))));

		gridComentarios.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS,
				GridVariant.LUMO_ROW_STRIPES);

		Button sendComment = new Button(ControladorDiccionario.Traducir("form.enviaropinion"), e -> {
			if (nameField.isEmpty() || textArea.isEmpty()) {
				Dialog dialog = new Dialog();
				try {
					dialog.add((ControladorDiccionario.Traducir("form.dialogcampos")));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dialog.setCloseOnEsc(false);
				dialog.setCloseOnOutsideClick(true);

				Button cancelButton = new Button("Cerrar", event -> {
					dialog.close();
				});
				cancelButton.getStyle().set("align-self", "center");
				cancelButton.setWidthFull();
				dialog.add(cancelButton);
				dialog.open();
			} else {
				incom.InsertarComentarios(nameField.getValue(), barrioCField.getValue(), textArea.getValue());
				dataC.refreshAll();
				gridComentarios.setItems(getComentarios());
				nameField.setValue("");
				barrioCField.setValue("");
				textArea.setValue("");
				comentario.setPosition(Position.MIDDLE);
				comentario.open();
			}

		});
		gridComentarios.setHeightByRows(true);

		Button resetComment = new Button(ControladorDiccionario.Traducir("form.borrarcampos"), e -> {
			nameField.setValue("");
			barrioCField.setValue("");
			textArea.setValue("");
		});

		HorizontalLayout actions = new HorizontalLayout();
		actions.add(sendComment, resetComment);

		sendComment.addThemeVariants(ButtonVariant.LUMO_SMALL, ButtonVariant.LUMO_PRIMARY);

		Board bc = new Board();
		verticalComments.add(h2Titulo, nameField, barrioCField, textArea, pc2, actions, prueba);

		HeaderRow filterRow = gridComentarios.appendHeaderRow();
		// First filter
		TextField barrioField = new TextField();
		barrioField.setValueChangeMode(ValueChangeMode.EAGER);
		filterRow.getCell(barrioC).setComponent(barrioField);
		barrioField.setSizeFull();
		barrioField.setPlaceholder(ControladorDiccionario.Traducir("form.placeholdergridopinion"));
		barrioField.getStyle().set("align-content", "flex-start");
		barrioField.addValueChangeListener(event -> dataC
				.addFilter(person -> StringUtils.containsIgnoreCase(person.getBarrioC(), barrioField.getValue())));

		gridComentarios.setVerticalScrollingEnabled(true);
		gridComentarios.setSizeFull();
		verticalPrintComments.add(gridComentarios);

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
		Text objetivosfooter = new Text(ControladorDiccionario.Traducir("footer.objetivos"));
		horizontalIconRecycle.add(new Anchor(
				"https://www.undp.org/content/undp/es/home/sustainable-development-goals.html", objetivosfooter));
		verticalIcons2.setWidth("500px");
		verticalIcons.setWidth("2000px");
		horizontalIconDatabase.setWidth("350px");
		horizontalIconPhone.setWidth("300");
		verticalFooter.add(ControladorDiccionario.Traducir("footer.derechosreservados"));

		Image logo2 = new Image("https://i.imgur.com/rTrRktv.png?1", "imgur.com");
		logo2.setHeight("100px");
		verticalLogo.add(logo2);
		verticalIcons.setAlignItems(Alignment.START);
		verticalIcons2.setAlignItems(Alignment.CENTER);
		verticalLogo.setAlignItems(Alignment.END);
		verticalFooter.setAlignItems(Alignment.CENTER);
	}

	private void cambiarColor() {
		// TODO Auto-generated method stub
		gridBarrios.setClassNameGenerator((v) -> {
			return "grid";
		});

	}

	public interface InterfaceFormularioModel extends TemplateModel {

	}

	// Función para obtener los barrios
	public List<TablaBarrios> getBarrios() {

		BarriosService service = new BarriosService();
		List<TablaBarrios> datos_barrios = service.fetchAll();
		return datos_barrios;

	}

	// Función para obtener los barrios
	public List<Comentarios> getComentarios() {

		ComentariosService service = new ComentariosService();
		List<Comentarios> datos_comentarios = service.fetchAll();
		return datos_comentarios;

	}

	private Button createDetailsButton(TablaBarrios item, int idioma) {
	
		Button detalles = new Button();
		if (idioma == 0)
		{
			detalles.setText("Detalles");
			cerrar.setText("Cerrar");
		} else if(idioma == 1) {
			detalles.setText("Details");
			cerrar.setText("Close");
		}
		

		// detalles.setClassName("boton");
		// detalles.setId("boton");
		detalles.getStyle().set("background-color", "#284367").set("color", "#FFF");

		detalles.addClickListener(clickEvent -> {

			cerrar.setWidthFull();

			imagenes_barrios = new Dialog();

			Image imagen = item.getImagen();
			imagen.setWidth("380px");
			imagen.setHeight("500px");

			VerticalLayout verticalFicha = new VerticalLayout();

			verticalFicha.add(imagen);
			imagenes_barrios.open();
			imagenes_barrios.add(verticalFicha, cerrar);
			gridBarrios.setDetailsVisibleOnClick(true);
		});

		return detalles;
	}

	private void applyFilter(ListDataProvider<TablaBarrios> dataProvider){
		dataProvider.clearFilters();
		if (comboBoxEdad.getValue() != null) {
			dataProvider.addFilter(barrio -> comboBoxEdad.getValue() == barrio.getEdadPos());
		}

		if (comboBoxNacionalidad.getValue() != null) {
			dataProvider.addFilter(barrio -> comboBoxNacionalidad.getValue() == barrio.getNacionalidadPos());
		}

		if (comboBoxRenta.getValue() != null) {
			dataProvider.addFilter(barrio -> comboBoxRenta.getValue() == barrio.getRentaPos());
		}

		if (checkboxAreasVerdes.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxAreasVerdes.getValue()) == barrio.getVerdesPos());
		}

		if (comboBoxValorm2.getValue() != null) {
			dataProvider.addFilter(barrio -> comboBoxValorm2.getValue() == barrio.getMetroPos());
		}

		if (checkboxHosteleria.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxHosteleria.getValue()) == barrio.getHosteleriaPos());
		}

		if (checkboxColegios.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxColegios.getValue()) == barrio.getColegiosPos());
		}

		if (checkboxEstaciones.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxEstaciones.getValue()) == barrio.getEstacionesPos());
		}

		if (checkboxCentrosDeportivos.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxCentrosDeportivos.getValue()) == barrio.getCentrosDeportivosPos());
		}

		if (checkboxBibliotecas.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxBibliotecas.getValue()) == barrio.getBibliotecasPos());
		}
		
		if (checkboxCentrosSanitarios.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxCentrosSanitarios.getValue()) == barrio.getCentrosSanitariosPos());
		}
		
		if (checkboxAparcamientos.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxAparcamientos.getValue()) == barrio.getAparcamientoPos());
		}

		notification.setPosition(Position.MIDDLE);
		cerrar2.setText("Cerrar");
		cerrar2.setWidthFull();
		
		cerrar2.addClickListener(event -> notification.close());

		int cantidad_datos = dataProvider.size(new Query<>(dataProvider.getFilter()));

		if (cantidad_datos == 0) {
			label.setText("Lo siento, no existe ningún barrio con esas características. Prueba a eliminar o cambiar algún filtro.\n");
			cerrar2.setText("Cerrar");
			notification.add(label, cerrar2);
			notification.open();
		}

	}

	private void applyFilterI(ListDataProvider<TablaBarrios> dataProvider) {
		dataProvider.clearFilters();
		if (comboBoxEdadI.getValue() != null) {
			dataProvider.addFilter(barrio -> comboBoxEdadI.getValue() == barrio.getAgePos());
		}

		if (comboBoxNacionalidadI.getValue() != null) {
			dataProvider.addFilter(barrio -> comboBoxNacionalidadI.getValue() == barrio.getNacionalityPos());
		}

		if (comboBoxRentaI.getValue() != null) {
			dataProvider.addFilter(barrio -> comboBoxRentaI.getValue() == barrio.getRentPos());
		}

		if (checkboxAreasVerdesI.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxAreasVerdesI.getValue()) == barrio.getGreenPos());
		}

		if (comboBoxValorm2I.getValue() != null) {
			dataProvider.addFilter(barrio -> comboBoxValorm2I.getValue() == barrio.getMetroIPos());
		}

		if (checkboxHosteleriaI.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxHosteleriaI.getValue()) == barrio.getRestaurantPos());
		}

		if (checkboxColegiosI.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxColegiosI.getValue()) == barrio.getCollegePos());
		}

		if (checkboxEstacionesI.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxEstacionesI.getValue()) == barrio.getStationsPos());
		}

		if (checkboxCentrosDeportivosI.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxCentrosDeportivosI.getValue()) == barrio.getScentersPos());
		}

		if (checkboxBibliotecasI.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxBibliotecasI.getValue()) == barrio.getLibraryPos());
		}
		
		if (checkboxCentrosSanitariosI.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxCentrosSanitariosI.getValue()) == barrio.getHealthCentersPos());
		}
		
		if (checkboxAparcamientosI.getValue() != false) {
			dataProvider.addFilter(barrio -> String.valueOf(checkboxAparcamientosI.getValue()) == barrio.getParkingPos());
		}

		notification.setPosition(Position.MIDDLE);
		
		cerrar2.setWidthFull();
		
		cerrar2.addClickListener(event -> notification.close());

		int cantidad_datos = dataProvider.size(new Query<>(dataProvider.getFilter()));

		if (cantidad_datos == 0) {
			label.setText("Sorry, there is no neighborhood with those features. Try removing or changing some filter.\n");
			cerrar2.setText("Close");
			notification.add(label, cerrar2);
			notification.open();
		}
	}
}

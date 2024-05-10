package views;

import com.vaadin.flow.templatemodel.TemplateModel;
import clases.DivsResponsive;
import utils.ControladorDiccionario;

import java.io.UnsupportedEncodingException;

import com.rocio.hoodfinder.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
/**
 * A Designer generated component for the interface-curiosidades template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */

@Route(value="curiosidades", layout=MainView.class)
@PageTitle("HoodFinder")
@PreserveOnRefresh
@Tag("interface-curiosidades")
@JsModule("./interface-curiosidades.js")
public class InterfaceCuriosidades extends PolymerTemplate<InterfaceCuriosidades.InterfaceCuriosidadesModel> {

    @Id("vaadinVerticalLayout")
	private VerticalLayout vaadinVerticalLayout;
	@Id("title-datos-curiosos")
	private H1 titleDatosCuriosos;
	@Id("vertical-footer")
	private VerticalLayout verticalFooter;
	@Id("horizontal-footer")
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
	@Id("descripcion-datos-curiosos")
	private Paragraph descripcionDatosCuriosos;
	@Id("vertical-grafica-superficie")
	private VerticalLayout verticalGraficaSuperficie;
	@Id("vertical-text-superficie")
	private VerticalLayout verticalTextSuperficie;
	@Id("vertical-grafica-densidad")
	private VerticalLayout verticalGraficaDensidad;
	@Id("vertical-text-densidad")
	private VerticalLayout verticalTextDensidad;
	@Id("horizontal-graficasD")
	private HorizontalLayout horizontalGraficasD;
	@Id("horizontal-graficas-S")
	private HorizontalLayout horizontalGraficasS;
	@Id("vertical-text-sexo")
	private VerticalLayout verticalTextSexo;
	@Id("vertical-grafica-sexo")
	private VerticalLayout verticalGraficaSexo;
	@Id("vertical-graficasS")
	private VerticalLayout verticalGraficasS;
	@Id("vertical-tabb")
	private VerticalLayout verticalTabb;
	@Id("vertical-text-lgtbi")
	private VerticalLayout verticalTextLgtbi;
	@Id("vertical-grafica-lgtbi")
	private VerticalLayout verticalGraficaLgtbi;
	@Id("horizontal-graficaL")
	private HorizontalLayout horizontalGraficaL;
	@Id("vertical-textL")
	private VerticalLayout verticalTextL;
	@Id("vertical-graficaP")
	private VerticalLayout verticalGraficaP;
	@Id("vertical-grafica-politica")
	private VerticalLayout verticalGraficaPolitica;
	@Id("vertical-text-politica")
	private VerticalLayout verticalTextPolitica;
	@Id("vertical-textP")
	private VerticalLayout verticalTextP;
	@Id("vertical-backtopL")
	private VerticalLayout verticalBacktopL;
	@Id("vertical-backtopSe")
	private VerticalLayout verticalBacktopS;
	@Id("vertical-textS")
	private VerticalLayout verticalTextS;
	@Id("vertical-backtopP")
	private VerticalLayout verticalBacktopP;
	@Id("vertical-textD")
	private VerticalLayout verticalTextD;
	@Id("verticalBacktopD")
	private VerticalLayout verticalBacktopD;
	@Id("vertical-text-sup")
	private VerticalLayout verticalTextSup;
	@Id("vertical-backtop-sup")
	private VerticalLayout verticalBacktopSup;
	@Id("vertical-backtopSe")
	private VerticalLayout verticalBacktopSe;
	@Id("vertical-kaggle")
	private VerticalLayout verticalKaggle;

 
	public InterfaceCuriosidades() throws UnsupportedEncodingException {
		
		titleDatosCuriosos.add(ControladorDiccionario.Traducir("curiosidades.title"));
		
    	Tab tab1 = new Tab(ControladorDiccionario.Traducir("curiosidades.tab1"));
    	Tab tab2 = new Tab(ControladorDiccionario.Traducir("curiosidades.tab2"));
    	Tab tab3 = new Tab(ControladorDiccionario.Traducir("curiosidades.tab3"));
    	Tab tab4 = new Tab(ControladorDiccionario.Traducir("curiosidades.tab4"));
    	Tab tab5 = new Tab(ControladorDiccionario.Traducir("curiosidades.tab5"));
    	Tabs tabs = new Tabs(false, tab1, tab2, tab3, tab4, tab5);
    
    	verticalTabb.setAlignItems(Alignment.CENTER);
    	verticalTabb.add(tabs);
    	tabs.addSelectedChangeListener(event -> {
    		if (event.getSelectedTab() == tab1) {
    			horizontalGraficasS.getElement().callJsFunction("scrollIntoView", true);
    		} else if (event.getSelectedTab() == tab2) {
        		horizontalGraficasD.getElement().callJsFunction("scrollIntoView", true);
    		} else if (event.getSelectedTab() == tab3) {
        		verticalGraficasS.getElement().callJsFunction("scrollIntoView", true);

    		} else if (event.getSelectedTab() == tab4) {
    			horizontalGraficaL.getElement().callJsFunction("scrollIntoView", true);
    		} else if (event.getSelectedTab() == tab5 ) {
    			verticalGraficaP.getElement().callJsFunction("scrollIntoView", true);
    		}
    	});
  
    	
    	// Creamos una instancia a la clase de Creacion_divs
    	DivsResponsive responsive = new DivsResponsive();
    	// Creamos un board donde introducir la grafica
    	Board board_grafica = new Board();
    			
    	titleDatosCuriosos.getStyle().set("color", "MidnightBlue");
    	descripcionDatosCuriosos.add(new H3(ControladorDiccionario.Traducir("curiosidades.descripcion")));
    	descripcionDatosCuriosos.add(new Icon(VaadinIcon.SMILEY_O));
    	
    	// SUPERFICIE
    	Image graficaSuperficieES = new Image("https://i.imgur.com/OqyGRzy.png", "imgur.com");
    	Image graficaSuperficieEN = new Image("https://i.imgur.com/3AaJuwv.png", "imgur.com");
    	graficaSuperficieES.setWidth("750px");
    	graficaSuperficieEN.setWidth("750px");
    	// Creamos los elementos que tendrá el board
    	if (titleDatosCuriosos.getText().equals("Datos curiosos de los distritos de Madrid")) {
    		Div elemento_board_graficaES = responsive.Anadir_imagenes(graficaSuperficieES);
    		board_grafica.addRow(elemento_board_graficaES);
    		verticalGraficaSuperficie.add(board_grafica);
    		verticalGraficaSuperficie.add("Fuente: elaboración propia, HoodFinder");
    		verticalGraficaSuperficie.getStyle().set("color", "MidnightBlue");
    		verticalGraficaSuperficie.getStyle().set("font-style", "oblique");
    		verticalGraficaSuperficie.getStyle().set("font-weight", "bold");
    		verticalGraficaSuperficie.setAlignItems(Alignment.CENTER);
    	} else {
    		Div elemento_board_graficaEN = responsive.Anadir_imagenes(graficaSuperficieEN);
    		board_grafica.addRow(elemento_board_graficaEN);
    		verticalGraficaSuperficie.add(board_grafica);
    		verticalGraficaSuperficie.add("Source: authors' own creation, HoodFinder");
    		verticalGraficaSuperficie.getStyle().set("color", "MidnightBlue");
    		verticalGraficaSuperficie.getStyle().set("font-style", "oblique");
    		verticalGraficaSuperficie.getStyle().set("font-weight", "bold");
    		verticalGraficaSuperficie.setAlignItems(Alignment.CENTER);
    	}
		
    			
		verticalTextSup.add(new H4(ControladorDiccionario.Traducir("curiosidades.superficietext")));
		verticalTextSup.getStyle().set("line-height" , "20pt");
		verticalTextSup.getStyle().set("border-radius", "30px");
    	verticalTextSup.getStyle().set("background-color", "Cornsilk");
    	
    	
    	horizontalGraficasS.setAlignItems(Alignment.CENTER);

    	// DENSIDAD
    	Image graficaDensidadES = new Image("https://i.imgur.com/qKhiUWR.png", "imgur.com");
    	Image graficaDensidadEN = new Image("https://i.imgur.com/BdtGZWi.png", "imgur.com");
    	graficaDensidadES.setWidth("650px");
    	graficaDensidadEN.setWidth("650px");
    	
    	if (titleDatosCuriosos.getText().equals("Datos curiosos de los distritos de Madrid")) {
    		verticalGraficaDensidad.add(graficaDensidadES);
    		verticalGraficaDensidad.add("Fuente: elaboración propia, HoodFinder");
    		verticalGraficaDensidad.getStyle().set("color", "MidnightBlue");
    		verticalGraficaDensidad.getStyle().set("font-style", "oblique");
    		verticalGraficaDensidad.getStyle().set("font-weight", "bold");
    		verticalGraficaDensidad.setAlignItems(Alignment.CENTER);
    	} else {
    		verticalGraficaDensidad.add(graficaDensidadEN);
    		verticalGraficaDensidad.add("Source: authors' own creation, HoodFinder");
    		verticalGraficaDensidad.getStyle().set("color", "MidnightBlue");
    		verticalGraficaDensidad.getStyle().set("font-style", "oblique");
    		verticalGraficaDensidad.getStyle().set("font-weight", "bold");
    		verticalGraficaDensidad.setAlignItems(Alignment.CENTER);
    	}
    	
    	verticalTextD.add(new H4(ControladorDiccionario.Traducir("curiosidades.densidadtext")));
    	verticalTextD.getStyle().set("line-height" , "20pt");
    	verticalTextD.getStyle().set("border-radius", "30px");
    	verticalTextD.getStyle().set("background-color", "Cornsilk");
    	horizontalGraficasD.setAlignItems(Alignment.CENTER);

    	// SEXO 
    	Image graficaSexoES = new Image("https://i.imgur.com/gbn2FZZ.png", "imgur.com");
    	Image graficaSexoEN = new Image("https://i.imgur.com/Ao48J3c.png", "imgur.com");
    	if (titleDatosCuriosos.getText().equals("Datos curiosos de los distritos de Madrid")) {
    		verticalGraficaSexo.add(graficaSexoES);
    		verticalGraficaSexo.add("Fuente: elaboración propia, HoodFinder");
    		verticalGraficaSexo.getStyle().set("color", "MidnightBlue");
    		verticalGraficaSexo.getStyle().set("font-style", "oblique");
    		verticalGraficaSexo.getStyle().set("font-weight", "bold");
        	verticalGraficaSexo.setAlignItems(Alignment.CENTER);
    	} else {
    		verticalGraficaSexo.add(graficaSexoEN);
    		verticalGraficaSexo.add("Source: authors' own creation, HoodFinder");
    		verticalGraficaSexo.getStyle().set("color", "MidnightBlue");
    		verticalGraficaSexo.getStyle().set("font-style", "oblique");
    		verticalGraficaSexo.getStyle().set("font-weight", "bold");
        	verticalGraficaSexo.setAlignItems(Alignment.CENTER);
    	}
    	
    	verticalTextS.add(new H4(ControladorDiccionario.Traducir("curiosidades.sexostext")));
    	verticalTextS.getStyle().set("line-height" , "20pt");
    	verticalTextS.getStyle().set("border-radius", "30px");
    	verticalTextS.getStyle().set("background-color", "Cornsilk");
    	verticalGraficasS.setAlignItems(Alignment.CENTER);

    	// LGTBI
    	Image graficaLgtbiES= new Image("https://i.imgur.com/MINi7AP.png", "imgur.com");
    	Image graficaLgtbiEN= new Image("https://i.imgur.com/MINi7AP.png", "imgur.com");
    	graficaLgtbiES.setWidth("800px");
    	graficaLgtbiEN.setWidth("800px");
    	if (titleDatosCuriosos.getText().equals("Datos curiosos de los distritos de Madrid")) {
    		verticalGraficaLgtbi.add(graficaLgtbiES);
    		verticalGraficaLgtbi.add("Fuente: elaboración propia, HoodFinder");
    		verticalGraficaLgtbi.getStyle().set("color", "MidnightBlue");
    		verticalGraficaLgtbi.getStyle().set("font-style", "oblique");
    		verticalGraficaLgtbi.getStyle().set("font-weight", "bold");
    		verticalGraficaLgtbi.setAlignItems(Alignment.CENTER);
    	} else {
    		verticalGraficaLgtbi.add(graficaLgtbiEN);
    		verticalGraficaLgtbi.add("Source: authors' own creation, HoodFinder");
    		verticalGraficaLgtbi.getStyle().set("color", "MidnightBlue");
    		verticalGraficaLgtbi.getStyle().set("font-style", "oblique");
    		verticalGraficaLgtbi.getStyle().set("font-weight", "bold");
    		verticalGraficaLgtbi.setAlignItems(Alignment.CENTER);
    	}
    	
    	verticalTextL.add(new H4(ControladorDiccionario.Traducir("curiosidades.lgtbitext")));
    	verticalTextL.getStyle().set("line-height" , "20pt");
    	verticalTextL.getStyle().set("border-radius", "30px");
    	verticalTextL.getStyle().set("background-color", "Cornsilk");
    	horizontalGraficaL.setAlignItems(Alignment.CENTER);
 
    	// POLITICA
    	Image graficaPoliticaES = new Image("https://i.imgur.com/cLx2Afu.png", "imgur.com");
    	Image graficaPoliticaEN = new Image("https://i.imgur.com/gj7XX5K.png", "imgur.com");
    	graficaPoliticaES.setWidth("950px");
    	graficaPoliticaEN.setWidth("950px");
    	if (titleDatosCuriosos.getText().equals("Datos curiosos de los distritos de Madrid")) {
    		verticalGraficaPolitica.add(graficaPoliticaES);
    		verticalGraficaPolitica.add("Fuente: elaboración propia, HoodFinder");
    		verticalGraficaPolitica.getStyle().set("color", "MidnightBlue");
    		verticalGraficaPolitica.getStyle().set("font-style", "oblique");
    		verticalGraficaPolitica.getStyle().set("font-weight", "bold");
        	verticalGraficaPolitica.setAlignItems(Alignment.CENTER);
    	} else {
    		verticalGraficaPolitica.add(graficaPoliticaEN);
    		verticalGraficaPolitica.add("Source: authors' own creation, HoodFinder");
    		verticalGraficaPolitica.getStyle().set("color", "MidnightBlue");
    		verticalGraficaPolitica.getStyle().set("font-style", "oblique");
    		verticalGraficaPolitica.getStyle().set("font-weight", "bold");
        	verticalGraficaPolitica.setAlignItems(Alignment.CENTER);
    	}
    	
    	verticalTextP.add(new H4(ControladorDiccionario.Traducir("curiosidades.politicatext")));
    	verticalTextP.getStyle().set("line-height" , "20pt");
    	verticalTextP.getStyle().set("border-radius", "30px");
    	verticalTextP.getStyle().set("background-color", "Cornsilk");
    	verticalGraficaP.setAlignItems(Alignment.CENTER);
    	
    	// Back to top
    	Image backtoTopSup= new Image("https://i.imgur.com/ZaR0X52.png", "imgur.com");
    	Image backtoTopD= new Image("https://i.imgur.com/ZaR0X52.png", "imgur.com");
    	Image backtoTopSe= new Image("https://i.imgur.com/ZaR0X52.png", "imgur.com");
    	Image backtoTopL= new Image("https://i.imgur.com/ZaR0X52.png", "imgur.com");
    	Image backtoTopP= new Image("https://i.imgur.com/ZaR0X52.png", "imgur.com");
    	verticalBacktopSup.add(backtoTopSup);
    	verticalBacktopD.add(backtoTopD);
    	verticalBacktopSe.add(backtoTopSe);
    	verticalBacktopL.add(backtoTopL);
    	verticalBacktopP.add(backtoTopP);
    	verticalBacktopSup.setAlignItems(Alignment.CENTER);
    	verticalBacktopD.setAlignItems(Alignment.CENTER);
    	verticalBacktopSe.setAlignItems(Alignment.CENTER);
    	verticalBacktopL.setAlignItems(Alignment.CENTER);
    	verticalBacktopP.setAlignItems(Alignment.CENTER);
    	backtoTopSup.setWidth("50px");
    	backtoTopSup.setHeight("50px");
    	backtoTopSup.addClickListener(e -> {
    		titleDatosCuriosos.getElement().callJsFunction("scrollIntoView", true);
    	});
    	backtoTopD.setWidth("50px");
    	backtoTopD.setHeight("50px");
    	backtoTopD.addClickListener(e -> {
    		titleDatosCuriosos.getElement().callJsFunction("scrollIntoView", true);
    	});
    	backtoTopSe.setWidth("50px");
    	backtoTopSe.setHeight("50px");
    	backtoTopSe.addClickListener(e -> {
    		titleDatosCuriosos.getElement().callJsFunction("scrollIntoView", true);
    	});
    	backtoTopL.setWidth("50px");
    	backtoTopL.setHeight("50px");
    	backtoTopL.addClickListener(e -> {
    		titleDatosCuriosos.getElement().callJsFunction("scrollIntoView", true);
    	});
    	backtoTopP.setWidth("50px");
    	backtoTopP.setHeight("50px");
    	backtoTopP.addClickListener(e -> {
    		titleDatosCuriosos.getElement().callJsFunction("scrollIntoView", true);
    	});
    	
    	// Sección kaggle
    	HorizontalLayout horizontalkaggle = new HorizontalLayout();
    	VerticalLayout verticalenlaceskaggle = new VerticalLayout();
    	verticalKaggle.getStyle().set("background-color", "LightCyan");
    	verticalKaggle.getStyle().set("border-radius", "30px");
    	Image imkaggle = new Image("https://i.imgur.com/IPG1LId.png", "imgur.com");
    	imkaggle.addClickListener(e -> {
			UI.getCurrent().getPage().executeJavaScript(
					"window.open(\"https://www.kaggle.com/\", \"_self\");");
		});
    	Anchor profilelinkaggle = new Anchor("https://www.kaggle.com/rochsos", "Kaggle profile");
    	Icon iconprofile = new Icon(VaadinIcon.USER);
    	HorizontalLayout profilehorizontal = new HorizontalLayout();
    	Anchor notebooklinkaggle = new Anchor("https://www.kaggle.com/rochsos/estudio-sociodemogr-fico-barrios-madrid", "Notebook");
    	Icon iconnotebook = new Icon(VaadinIcon.NOTEBOOK);
    	HorizontalLayout notebookhorizontal = new HorizontalLayout();
    	Anchor datasetlinkaggle = new Anchor("https://www.kaggle.com/rochsos/hoodfinder-estudio-madrid", "Dataset");
    	Icon icondataset = new Icon(VaadinIcon.DATABASE);
    	HorizontalLayout databasehorizontal = new HorizontalLayout();
    	
    	H3 h4kaggle = new H3(ControladorDiccionario.Traducir("curiosidades.kaggle"));
    	h4kaggle.getStyle().set("text-align", "justify");
    	h4kaggle.getStyle().set("padding-top", "25px");
    	h4kaggle.getStyle().set("padding-left", "70px");
    	h4kaggle.getStyle().set("padding-right", "70px");
    	imkaggle.setWidth("250px");
    	profilehorizontal.add(iconprofile, profilelinkaggle);
    	profilehorizontal.getStyle().set("margin-right", "80px");
    	notebookhorizontal.add(iconnotebook, notebooklinkaggle);
    	databasehorizontal.add(icondataset, datasetlinkaggle);
    	databasehorizontal.getStyle().set("margin-left", "90px");
    	horizontalkaggle.add(profilehorizontal, notebookhorizontal, databasehorizontal);
    	verticalenlaceskaggle.add(horizontalkaggle);
    	verticalenlaceskaggle.setAlignItems(Alignment.CENTER);
    	verticalKaggle.add(imkaggle, h4kaggle, verticalenlaceskaggle);
    	verticalKaggle.setAlignItems(Alignment.CENTER);
    	
    	
    	
    	
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
     	horizontalIconRecycle.add(new Anchor("https://www.undp.org/content/undp/es/home/sustainable-development-goals.html", objetivosfooter));
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


    /**
     * This model binds properties between InterfaceCuriosidades and interface-curiosidades
     */
    public interface InterfaceCuriosidadesModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

	
}

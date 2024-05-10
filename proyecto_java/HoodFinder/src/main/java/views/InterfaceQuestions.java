package views;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.server.ThemeResource;

import utils.ControladorDiccionario;

import java.io.UnsupportedEncodingException;

import com.rocio.hoodfinder.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;

@CssImport(value = "./styles/shared-styles.css")
@Route(value="questions", layout=MainView.class)
@PageTitle("HoodFinder")
@Tag("interface-questions")
@JsModule("./interface-questions.js")
public class InterfaceQuestions extends PolymerTemplate<InterfaceQuestions.InterfaceQuestionsModel> {

	private static final long serialVersionUID = 1L;
	
    @Id("vaadinVerticalLayout")
	private VerticalLayout vaadinVerticalLayout;
	@Id("vertical-footer")
	private VerticalLayout verticalFooter;
	@Id("horizontal-footer")
	private HorizontalLayout horizontalFooter;
	@Id("vertical-icons")
	private VerticalLayout verticalIcons;
	@Id("vertical-icons-2")
	private VerticalLayout verticalIcons2;
	@Id("horizontal-icon-mail")
	private HorizontalLayout horizontalIconMail;
	@Id("horizontal-icon-phone")
	private HorizontalLayout horizontalIconPhone;
	@Id("icono-mail")
	private HorizontalLayout iconoMail;
	@Id("icono-phone")
	private HorizontalLayout iconoPhone;
	@Id("horizontal-icon-database")
	private HorizontalLayout horizontalIconDatabase;
	@Id("horizontal-icon-recycle")
	private HorizontalLayout horizontalIconRecycle;
	@Id("vertical-logo")
	private VerticalLayout verticalLogo;
	@Id("vertical-titulo")
	private VerticalLayout verticalTitulo;
	@Id("titulo-form")
	private H1 tituloForm;
	@Id("vertical-image-question")
	private VerticalLayout verticalImageQuestion;
	@Id("vertical-text-question")
	private VerticalLayout verticalTextQuestion;
	@Id("horizontal-preguntas")
	private HorizontalLayout horizontalPreguntas;
	
	Label labelPrimeraP = new Label();
	Label textoInsidePrimera = new Label();
	H3 respuestaPrimera = new H3();
	
	Label labelSegundaP = new Label();
	Label textoInsideSegunda = new Label();
	H3 respuestaSegunda = new H3();
	
	Label labelterceraP = new Label();
	Label textoInsideTercera = new Label();
	H3 respuestaTercera = new H3();
	
	Label labelcuartaP = new Label();
	Label textoInsidecuarta = new Label();
	H3 respuestaCuarta = new H3();
	
	Label labelquintaP = new Label();
	Label textoInsideQuinta = new Label();
	H3 respuestaQuinta = new H3();
	
	Label labelsextaP = new Label();
	Label textoInsideSexta = new Label();
	H3 respuestaSexta = new H3();
	
	Label labelseptimaP = new Label();
	Label textoInsideseptima = new Label();
	H3 respuestaSeptima = new H3();
	
    public InterfaceQuestions() throws UnsupportedEncodingException {
        
    	//RefrescarDisenoIdioma();
    	
    	// TITULO
    	tituloForm.setText(ControladorDiccionario.Traducir("questions.title"));
    	tituloForm.getStyle().set("color", "MidnightBlue");
    	verticalTitulo.setAlignItems(Alignment.CENTER);
    	
    	//IMAGEN PREGUNTAS FRECUENTES
    	Image questionfrecuentes = new Image("https://i.imgur.com/Ybp5iU4.png", "imgur.com");
    	questionfrecuentes.setWidth("400px");
    	questionfrecuentes.setHeight("300px");
    	verticalImageQuestion.add(questionfrecuentes);
    	verticalImageQuestion.setAlignItems(Alignment.START);
    	verticalImageQuestion.setWidth("480px");
    	
    	// TEXTO PREGUNTAS FRECUENTES
    	
    	// Primera pregunta
    	HorizontalLayout primeraLayout = new HorizontalLayout();
    	Icon primeraIcon = new Icon(VaadinIcon.HEADSET);
    	
    	labelPrimeraP.setText(ControladorDiccionario.Traducir("questions.primeraP"));
    	labelPrimeraP.getStyle().set("font-size", "25px");
    	labelPrimeraP.getStyle().set("color", "white");
    	Details primeraPregunta = new Details();
    	primeraPregunta.setSummary(labelPrimeraP);
    	textoInsidePrimera.setText(ControladorDiccionario.Traducir("questions.textoinsideprimera"));
    	textoInsidePrimera.getStyle().set("text-align", "justify");
    	respuestaPrimera.setText(ControladorDiccionario.Traducir("questions.respuestaprimeraP"));
    	respuestaPrimera.getStyle().set("color", "white");
    	textoInsidePrimera.getElement().getStyle().set("color", "white");
    	primeraPregunta.addContent(respuestaPrimera, textoInsidePrimera);
    	primeraPregunta.getElement().getStyle().set("background-color", "MidnightBlue");
    	primeraPregunta.addThemeVariants(DetailsVariant.REVERSE, DetailsVariant.FILLED);
    	primeraLayout.add(primeraIcon, primeraPregunta);
    	primeraLayout.setAlignItems(Alignment.BASELINE);
    	
    	// Segunda pregunta
    	HorizontalLayout segundaLayout = new HorizontalLayout();
    	Icon segundaIcon = new Icon(VaadinIcon.CHAT);
    	labelSegundaP.setText(ControladorDiccionario.Traducir("questions.segundaP"));
    	labelSegundaP.getStyle().set("font-size", "25px");
    	labelSegundaP.getStyle().set("color", "white");
    	Details segundaPregunta = new Details();
    	segundaPregunta.setSummary(labelSegundaP);
    	textoInsideSegunda.setText(ControladorDiccionario.Traducir("questions.textoinsidesegunda"));
    	textoInsideSegunda.getStyle().set("text-align", "justify");
    	textoInsideSegunda.getElement().getStyle().set("color", "white");
    	respuestaSegunda.setText(ControladorDiccionario.Traducir("questions.respuestasegundaP"));
    	respuestaSegunda.getStyle().set("color", "white");
    	segundaPregunta.addContent(respuestaSegunda, textoInsideSegunda);
    	segundaPregunta.getElement().getStyle().set("background-color", "MidnightBlue");
    	segundaPregunta.addThemeVariants(DetailsVariant.REVERSE, DetailsVariant.FILLED);
    	segundaLayout.add(segundaIcon, segundaPregunta);
    	segundaLayout.setAlignItems(Alignment.BASELINE);
    	
    	// tercera pregunta
    	HorizontalLayout terceraLayout = new HorizontalLayout();
    	Icon terceraIcon = new Icon(VaadinIcon.PIE_BAR_CHART);
    	labelterceraP.setText(ControladorDiccionario.Traducir("questions.terceraP"));
    	labelterceraP.getStyle().set("font-size", "25px");
    	labelterceraP.getStyle().set("color", "white");
    	Details terceraPregunta = new Details();
    	terceraPregunta.setSummary(labelterceraP);
    	textoInsideTercera.setText(ControladorDiccionario.Traducir("questions.textoinsidetercera"));
    	textoInsideTercera.getStyle().set("text-align", "justify");
    	textoInsideTercera.getElement().getStyle().set("color", "white");
    	respuestaTercera.setText(ControladorDiccionario.Traducir("questions.respuestaterceraP"));
    	respuestaTercera.getStyle().set("color", "white");
    	terceraPregunta.addContent(respuestaTercera, textoInsideTercera);
    	terceraPregunta.getElement().getStyle().set("background-color", "MidnightBlue");
    	terceraPregunta.addThemeVariants(DetailsVariant.REVERSE, DetailsVariant.FILLED);
    	terceraLayout.add(terceraIcon, terceraPregunta);
    	terceraLayout.setAlignItems(Alignment.BASELINE);
    	
    	// cuarta pregunta
    	HorizontalLayout cuartaLayout = new HorizontalLayout();
    	Icon cuartaIcon = new Icon(VaadinIcon.REFRESH);
    	labelcuartaP.setText(ControladorDiccionario.Traducir("questions.cuartaP"));
    	labelcuartaP.getStyle().set("font-size", "25px");
    	labelcuartaP.getStyle().set("color", "white");
    	Details cuartaPregunta = new Details();
    	cuartaPregunta.setSummary(labelcuartaP);
    	textoInsidecuarta.setText(ControladorDiccionario.Traducir("questions.textoinsidecuarta"));
    	textoInsidecuarta.getStyle().set("text-align", "justify");
    	textoInsidecuarta.getElement().getStyle().set("color", "white");
    	respuestaCuarta.setText(ControladorDiccionario.Traducir("questions.respuestacuartaP"));
    	respuestaCuarta.getStyle().set("color", "white");
    	cuartaPregunta.addContent(respuestaCuarta, textoInsidecuarta);
    	cuartaPregunta.getElement().getStyle().set("background-color", "MidnightBlue");
    	cuartaPregunta.addThemeVariants(DetailsVariant.REVERSE, DetailsVariant.FILLED);
    	cuartaLayout.add(cuartaIcon, cuartaPregunta);
    	cuartaLayout.setAlignItems(Alignment.BASELINE);
    	
    	// quinta pregunta
    	HorizontalLayout quintaLayout = new HorizontalLayout();
    	Icon quintaIcon = new Icon(VaadinIcon.PHONE);
    	labelquintaP.setText(ControladorDiccionario.Traducir("questions.quintaP"));
    	labelquintaP.getStyle().set("font-size", "25px");
    	labelquintaP.getStyle().set("color", "white");
    	Details quintaPregunta = new Details();
    	quintaPregunta.setSummary(labelquintaP);
    	textoInsideQuinta.setText(ControladorDiccionario.Traducir("questions.textoinsidequinta"));
    	textoInsideQuinta.getElement().getStyle().set("color", "white");
    	respuestaQuinta.setText(ControladorDiccionario.Traducir("questions.respuestaquintaP"));
    	textoInsideQuinta.getStyle().set("text-align", "justify");
    	respuestaQuinta.getStyle().set("color", "white");
    	quintaPregunta.addContent(respuestaQuinta, textoInsideQuinta);
    	quintaPregunta.getElement().getStyle().set("background-color", "MidnightBlue");
    	quintaPregunta.addThemeVariants(DetailsVariant.REVERSE, DetailsVariant.FILLED);
    	quintaLayout.add(quintaIcon, quintaPregunta);
    	quintaLayout.setAlignItems(Alignment.BASELINE);
    	
    	// sexta pregunta
    	HorizontalLayout sextaLayout = new HorizontalLayout();
    	Icon sextaIcon = new Icon(VaadinIcon.TEXT_LABEL);
    	labelsextaP.setText(ControladorDiccionario.Traducir("questions.sextaP"));
    	labelsextaP.getStyle().set("font-size", "25px");
    	labelsextaP.getStyle().set("color", "white");
    	Details sextaPregunta = new Details();
    	sextaPregunta.setSummary(labelsextaP);
    	textoInsideSexta.setText(ControladorDiccionario.Traducir("questions.textoinsidesexta"));
    	textoInsideSexta.getStyle().set("text-align", "justify");
    	textoInsideSexta.getElement().getStyle().set("color", "white");
    	respuestaSexta.setText(ControladorDiccionario.Traducir("questions.respuestasextaP"));
    	respuestaSexta.getStyle().set("color", "white");
    	sextaPregunta.addContent(respuestaSexta, textoInsideSexta);
    	sextaPregunta.getElement().getStyle().set("background-color", "MidnightBlue");
    	sextaPregunta.addThemeVariants(DetailsVariant.REVERSE, DetailsVariant.FILLED);
    	sextaLayout.add(sextaIcon, sextaPregunta);
    	sextaLayout.setAlignItems(Alignment.BASELINE);
    	
    	// septima pregunta
    	HorizontalLayout septimaLayout = new HorizontalLayout();
    	Icon septimaIcon = new Icon(VaadinIcon.BUILDING);
    	labelseptimaP.setText(ControladorDiccionario.Traducir("questions.septimaP"));
    	labelseptimaP.getStyle().set("font-size", "25px");
    	labelseptimaP.getStyle().set("color", "white");
    	Details septimaPregunta = new Details();
    	septimaPregunta.setSummary(labelseptimaP);
    	textoInsideseptima.setText(ControladorDiccionario.Traducir("questions.textoinsideseptima"));
    	textoInsideseptima.getStyle().set("text-align", "justify");
    	textoInsideseptima.getElement().getStyle().set("text-align", "justify");
    	textoInsideseptima.getElement().getStyle().set("color", "white");
    	respuestaSeptima.setText(ControladorDiccionario.Traducir("questions.respuestaseptimaP"));
    	respuestaSeptima.getStyle().set("color", "white");
    	septimaPregunta.addContent(respuestaSeptima, textoInsideseptima);
    	septimaPregunta.getElement().getStyle().set("background-color", "MidnightBlue");
    	septimaPregunta.addThemeVariants(DetailsVariant.REVERSE, DetailsVariant.FILLED);
    	septimaLayout.add(septimaIcon, septimaPregunta);
    	septimaLayout.setAlignItems(Alignment.BASELINE);
    	
    	//¿Son fiables los datos de la página?
    	
    	verticalTextQuestion.add(septimaLayout, cuartaLayout, quintaLayout, primeraLayout, segundaLayout, terceraLayout, sextaLayout);
    	verticalTextQuestion.setAlignItems(Alignment.START);
    	
   
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
   
    public interface InterfaceQuestionsModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}

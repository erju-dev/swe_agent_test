package clases;

import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tabs;


public class DivsResponsive {

	public Div Anadir_h1(H1 h) {
		Div div = new Div();
		div.add(h);
		return div;
	}
	
	public Div Anadir_tabs(Tabs tabs) {
		Div div = new Div();
		div.add(tabs);
		return div;
	}
	
	public Div Anadir_imagenes(Image image) {
		Div div = new Div();
		div.add(image);
		return div;
	}
	
	public Div Anadir_board(Board board) {
		Div div = new Div();
		div.add(board);
		return div;
	}
	
	public Div Anadir_grid(Grid<TablaBarrios> grid) {
		Div div = new Div();
		div.add(grid);
		return div;
	}
	
	public Div Anadir_horizontal(HorizontalLayout horizontal) {
		Div div = new Div();
		div.add(horizontal);
		return div;
	}
	
	public Div Aniadir_div(String texto) {
		Div div = new Div();
		div.add(texto);
		return div;
	}
	
	public Div Aniadir_vertical(VerticalLayout vertical) {
		Div div = new Div();
		div.add(vertical);
		return div;
	}
}

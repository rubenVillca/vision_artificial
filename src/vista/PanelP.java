package vista;

import java.awt.Color;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelP extends JPanel{

	private static final long serialVersionUID = 1L;
	private Controlador ctrl;
	//P1=PANEL IMAGEN //P2=PANEL BOTONES //P3=PANEL PLACA
	private PanelImagen p1;
	private PanelBotones p2;
	private PanelPlaca p3;
	
	public PanelP(Controlador ctrl){
		this.ctrl=ctrl;	
		confIni();
		crearContenido();
		confFin();
	}

	private void crearContenido() {
		crearBordeImagen();
		crearBotones();
		crearPlaca();
	}

	private void crearBordeImagen() {
		p1=new PanelImagen(ctrl);
		add(p1);
	}

	private void crearBotones() {
		p2=new PanelBotones(ctrl);
		add(p2);
	}

	private void crearPlaca() {
		p3=new PanelPlaca(ctrl);
		add(p3);
	}
	
	private void confIni() {
		setBackground(new Color(102,102,102));
		setLayout(null);
		setBounds(0,22, ctrl.getX(),ctrl.getY());
	}
	
	private void confFin() {
		setVisible(true);
	}
	public PanelImagen getPanelImagen(){
		return p1;
	}
	public PanelPlaca getPanelPlaca(){
		return p3;
	}
}

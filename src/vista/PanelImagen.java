package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

import controlador.Controlador;

public class PanelImagen extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controlador ctrl;
	
	public PanelImagen(Controlador ctrl){
		this.ctrl=ctrl;
		crearContenido();
	}

	private void crearContenido() {
		setLayout(new FlowLayout(0,5,5));
		setBackground(new Color(194,189,189));
		cambiarTam();
	}
	private void cambiarTam(){
		setBounds(5,5,ctrl.getFrame().getContentPane().getWidth()-190,ctrl.getFrame().getContentPane().getHeight()-110);
	}
	public void paintComponent(Graphics g){
		cambiarTam();
		super.paintComponent(g);
	}
	public void limpiar() {
		try{
			removeAll();
		}catch (Exception e) {
			System.out.println("No se pudo eliminar imagen");
		}	
		updateUI();
	}
	public Component add(Component c){
		limpiar();
		super.add(c);
		updateUI();
		return c;
	}
}

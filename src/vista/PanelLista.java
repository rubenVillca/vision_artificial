package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controlador.Controlador;

public class PanelLista extends JPanel{

	private static final long serialVersionUID = 1L;
	private Controlador ctrl;
	private JTextArea area;
	private JScrollPane scroll;
	
	public PanelLista(Controlador ctrl){
		this.ctrl=ctrl;
		confiIni();
		crearContenido();
		confFin();
	}

	private void crearContenido() {
		area=new JTextArea(20,15);
		scroll=new JScrollPane(area);
		add(scroll);
	}

	private void confFin() {
		setVisible(true);
	}

	private void confiIni() {
		setBackground(new Color(153,153,153));
		cambiarTam();
	}
	
	private void cambiarTam() {
		setBounds(ctrl.getFrame().getContentPane().getWidth()-180,
				  ctrl.getFrame().getContentPane().getHeight()/2,
				  180,
				  ctrl.getFrame().getContentPane().getHeight()/2);	
	}
	public void paintComponent(Graphics g){
		cambiarTam();
		super.paintComponent(g);
	}
	public void setTexto(ArrayList<String> lista){
		area.setText(getLista(lista));
	}
	public String getLista(ArrayList<String> lista){
		String res="";
		for(String l:lista)
			res+=l+"\n";
		return res;
	}
}

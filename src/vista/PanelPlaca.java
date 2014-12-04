package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelPlaca extends JPanel{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controlador ctrl;
	private JLabel id,placa;
	
	public PanelPlaca(Controlador ctrl){
		this.ctrl=ctrl;
		confiIni();
		crearContenido();
		conFin();
	}

	private void crearContenido() {
		Font font=new Font("DigifaceWide",1,48);
		JPanel p=new JPanel();
		p.setBounds(200, 15, 350,70);
		p.setBackground(new Color(0,0,0));
		
		id=new JLabel("111 AAA");
		id.setFont(font);
		id.setBackground(new Color(0,204,255));
		id.setBounds(0, 0,p.getWidth(),p.getHeight());
		p.add(id);
		add(p);
		
		placa=new JLabel("PLACA");
		placa.setFont(font);
		placa.setBounds(600, 15, 350,70);
		placa.setForeground(new Color(0,204,255));
		add(placa);
	}

	private void confiIni() {
		setLayout(null);
		setBackground(new Color(102,102,102));
		cambiarTam();
	}
	private void cambiarTam(){
		setBounds(0,ctrl.getFrame().getContentPane().getHeight()-100,ctrl.getFrame().getContentPane().getWidth()-180,100);
	}
	public void paintComponent(Graphics g){
		cambiarTam();
		super.paintComponent(g);
	}

	private void conFin() {
		setVisible(true);
	}

	public String getPlaca() {
		return id.getText();
	}
	
}

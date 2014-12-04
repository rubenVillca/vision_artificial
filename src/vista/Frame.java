package vista;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controlador.Controlador;

public class Frame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private Controlador ctrl;
	
	public Frame(Controlador ctrl){
		super("Control de Placas por Vision Artificial");
		this.ctrl=ctrl;
		confiIni();	
		confiFin();
		
	}
	private void confiFin() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);	
	}
	private void confiIni() {
		setLayout(null);
		setSize(ctrl.getX(), ctrl.getY());
		//setResizable(false);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(2);
		setMinimumSize(new Dimension(800,600));
		addWindowListener(new WindowAdapter() {  
		       public void windowClosing(WindowEvent e) {
		    	   ctrl.cerrar();
		       }  
		     });  
		
		ImageIcon icono=new ImageIcon(getClass().getResource("/iconos/ojo.png"));
	   	setIconImage(icono.getImage());
	}
}
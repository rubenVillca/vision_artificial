package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelBotones extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Controlador ctrl;
	private JButton botAbrir,botAnalizar,botGuardar,botLimpiar,cerrar;
	
	public PanelBotones(Controlador ctrl){
		this.ctrl=ctrl;
		confiIni();
		crearContenido();
		confFin();
	}

	private void confFin() {
		setVisible(true);
	}

	private void confiIni() {
		setLayout(new GridLayout(8, 1,45,55));
		setBackground(new Color(153,153,153));
		cambiarTam();
	}
	
	private void cambiarTam() {
		setBounds(ctrl.getFrame().getContentPane().getWidth()-180,0,180,ctrl.getFrame().getContentPane().getHeight());	
	}
	public void paintComponent(Graphics g){
		cambiarTam();
		super.paintComponent(g);
	}
	private void crearContenido() {
		JLabel label=new JLabel("Botones");
		add(label);
		
		botAbrir=new JButton("CARGAR IMAGEN");
		botAbrir.addActionListener(this);
		add(botAbrir);

		botAnalizar=new JButton("ANALIZAR PLACA");
		botAnalizar.addActionListener(this);
		add(botAnalizar);
		
		botGuardar=new JButton("GUARDAR PLACA");
		botGuardar.addActionListener(this);
		add(botGuardar);
		
		botLimpiar=new JButton("LIMPIAR VENTANA");
		botLimpiar.addActionListener(this);
		add(botLimpiar);
		
		cerrar=new JButton("Cerrar");
		cerrar.addActionListener(this);
		add(cerrar);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String res=e.getActionCommand();
		if(res.equals(botAbrir.getText()))
			ctrl.abrirImagen();
		if(res.equals(botAnalizar.getText()))
			ctrl.analizarImagen();
		if(res.equals(botGuardar.getText()))
			ctrl.guardarPlaca();
		if(res.equals(cerrar.getText()))
			ctrl.cerrar();
		if(res.equals(botLimpiar.getText()))
			ctrl.limpiarVentana();
	}
}

package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.Controlador;

public class PanelBotones extends JPanel implements ActionListener{

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
		setLayout(new GridLayout(9, 1,0,10));
		setBackground(new Color(153,153,153));
		cambiarTam();
	}
	
	private void cambiarTam() {
		setBounds(ctrl.getFrame().getContentPane().getWidth()-180,0,180,ctrl.getFrame().getContentPane().getHeight()/2);	
	}
	public void paintComponent(Graphics g){
		cambiarTam();
		super.paintComponent(g);
	}
	private void crearContenido() {
		Font font=new Font("Engravers MT", 1, 24);
		Color ct=Color.CYAN;
		
		JLabel label=new JLabel("Botones");
		label.setFont(font);
		label.setForeground(ct);
		add(label);
		
		Font fontB=new Font("Engravers MT", 1, 10);
		Color c=Color.gray;
		
		botAbrir=new JButton("CARGAR IMAGEN");
		botAbrir.setFont(fontB);
		botAbrir.setForeground(c);
		botAbrir.addActionListener(this);
		add(botAbrir);

		botAnalizar=new JButton("ANALIZAR PLACA");
		botAnalizar.setFont(fontB);
		botAnalizar.setForeground(c);
		botAnalizar.addActionListener(this);
		add(botAnalizar);
		
		botGuardar=new JButton("EXPORTAR PLACAS");
		botGuardar.setFont(fontB);
		botGuardar.setForeground(c);
		botGuardar.addActionListener(this);
		add(botGuardar);
		
		botLimpiar=new JButton("LIMPIAR VENTANA");
		botLimpiar.setFont(fontB);
		botLimpiar.setForeground(c);
		botLimpiar.addActionListener(this);
		add(botLimpiar);
		
		cerrar=new JButton("Cerrar");
		cerrar.setFont(fontB);
		cerrar.setForeground(c);
		cerrar.addActionListener(this);
		add(cerrar);
		
		Font font1=new Font("Engravers MT", 1, 11);
		
		JLabel etiq1=new JLabel("          LISTA DE");
		etiq1.setFont(font1);
		etiq1.setForeground(ct);
		add(etiq1);
		
		JLabel etiq2=new JLabel("PLACAS ANALIZADAS");
		etiq2.setFont(font1);
		etiq2.setForeground(ct);
		add(etiq2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String res=e.getActionCommand();
		if(res.equals(botAbrir.getText()))
			ctrl.abrirImagen();
		if(res.equals(botAnalizar.getText())){
			ctrl.analizarImagen();
			ctrl.cargarLista();
		}
		if(res.equals(botGuardar.getText()))
			ctrl.guardarPlaca();
		if(res.equals(cerrar.getText()))
			ctrl.cerrar();
		if(res.equals(botLimpiar.getText()))
			ctrl.limpiarVentana();
	}
}

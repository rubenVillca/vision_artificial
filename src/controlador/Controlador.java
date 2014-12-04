package controlador;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;

import vista.Frame;
import vista.PanelImagen;
import vista.PanelP;

public class Controlador {
	private int ancho,alto;
	private Frame frame;
	private PanelP panelP;
	private JFileChooser guardar;
	private String url;
	
	private ArrayList<String> imagenes;
	
	public Controlador(){
		ancho=1200;
		alto=700;
		crearContenido();
		
	}
	private void crearContenido() {
		frame=new Frame(this);
		panelP=new PanelP(this);
		frame.setContentPane(panelP);
		panelP.updateUI();
	}
	public int getX() {
		return ancho;
	}
	public int getY() {
		return alto;
	}
	public Frame getFrame(){
		return frame;
	}
	public void abrirImagen() {
		url="/imAutos/auto"+14+".jpg";
		
		PanelImagen pI=panelP.getPanelImagen();
		imagenes=new ArrayList<String>();
		imagenes.add(url);
		JLabel imag=new JLabel();
		ImageIcon icon=new ImageIcon(getClass().getResource(imagenes.get(0)));
		imag.setIcon(icon);
		pI.add(imag);	
	}
	public void analizarImagen() {
		JOptionPane.showMessageDialog(null, "Analizando Imagen...");
		
		URL urls=getClass().getResource(imagenes.get(0));
		url=urls.getPath();
		System.out.println("Welcome to OpenCV " + Core.VERSION);
		//System.loadLibrary("opencv_java244");
		Mat imagen = Highgui.imread(url,Highgui.CV_LOAD_IMAGE_COLOR);
		    
		if(!imagen.empty()){
            Image imagenMostrar = convertir(imagen);
            /*int width=imagenMostrar.getWidth(null);
            int height=imagenMostrar.getHeight(null);
            */
           /* ventana = new Ventana(imagenMostrar);
            ventana.setSize(width,height);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);*/
        }
		
		//System.out.println("Welcome to OpenCV " + Core.VERSION);
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //Mat m  = Mat.eye(5, 5, CvType.CV_8SC1);
        //Mat m=Highgui.imread(imagenes.get(0));
        //System.out.println("m =\n " + m.dump());
	}
	private Image convertir(Mat imagen) {
        MatOfByte matOfByte = new MatOfByte();
        Highgui.imencode(".jpg", imagen, matOfByte);
        byte[] byteArray = matOfByte.toArray();
        BufferedImage bufImage = null;
        try {
            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (Image)bufImage;
    }
	/*private BufferedImage bufferImagen(Mat matrix) {
		int cols = matrix.cols();  
	    int rows = matrix.rows();  
	    int elemSize = (int)matrix.elemSize();  
	    byte[] data = new byte[cols * rows * elemSize];  
	    int type;  
	    matrix.get(0, 0, data);  
	    switch (matrix.channels()) {  
	       case 1:  type = BufferedImage.TYPE_BYTE_GRAY;         break;  
	       case 3:  type = BufferedImage.TYPE_3BYTE_BGR;        // bgr to rgb  
			         byte b;  
			         for(int i=0; i<data.length; i=i+3) {  
			           b = data[i];  
			           data[i] = data[i+2];  
			           data[i+2] = b;  
			         }  
			         break;  
	       default:        return null;
	     }
        BufferedImage image = new BufferedImage(cols, rows, type);  
        image.getRaster().setDataElements(0, 0, cols, rows, data);  
        return image;   
	}*/
	@SuppressWarnings("static-access")
	public void guardarPlaca() {
		String codigo=panelP.getPanelPlaca().getPlaca();
		guardar=new JFileChooser();
		guardar.setDialogTitle("Guardar Imagen");
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("TEXTO", "txt" );
		guardar.setFileFilter(filtro);
        int guardoArchivo = guardar.showSaveDialog(frame);

        if(guardoArchivo == guardar.APPROVE_OPTION) {
            File archivo = guardar.getSelectedFile();
            FileOutputStream miArchivo;
            String contenidoTexto = new String();
            try {
                miArchivo = new FileOutputStream(archivo.getPath());
                contenidoTexto = codigo;
                miArchivo.write(contenidoTexto.getBytes());
                miArchivo.close();
            }
            catch(IOException ex) {
                System.out.println("Error : "+ex.getMessage());
            }
          }
	}
	public void cerrar() {
		JOptionPane.showMessageDialog(null, "Saliendo");
		System.exit(0);
	}
	public void limpiarVentana() {
		PanelImagen p2=panelP.getPanelImagen();
		p2.limpiar();
	}
}	
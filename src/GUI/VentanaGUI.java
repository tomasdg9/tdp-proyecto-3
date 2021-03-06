package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Entidad;
import Entidades.Moviles.Blinky;
import Entidades.Moviles.Clyde;
import Entidades.Moviles.Inky;
import Entidades.Moviles.Pinky;
import Logica.Juego;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

public class VentanaGUI extends JFrame implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private Juego miJuego;
	private JLabel lblPuntaje;
	private JLabel lblVida1;
	private JLabel lblVida2;
	private JLabel lblVida3;
	private int puntaje;
	private JLabel labelSonido;
	private boolean sonidoActivo;

	private VentanaFinJuego finJuego = new VentanaFinJuego(this);
	
	
	/**
	 * Create the frame.
	 */
	
	public VentanaGUI(int tema) {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		this.setSize(750, 806);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaGUI.class.getResource("/imagenes/logo-sirena.png")));
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(31, 72, 672, 672);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		if(tema == 1)
			panel.setBackground(Color.GRAY);
		else
			panel.setBackground(new Color(0, 191, 255));
		
		JLabel lblScore = new JLabel("SCORE:");
		lblScore.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
		lblScore.setForeground(Color.WHITE);
		lblScore.setBounds(30, 39, 69, 25);
		contentPane.add(lblScore);
		
		lblPuntaje = new JLabel("0");
		lblPuntaje.setFont(new Font("Bauhaus 93", Font.PLAIN, 20));
		lblPuntaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setBounds(109, 36, 150, 30);
		contentPane.add(lblPuntaje);
		
		lblVida1 = new JLabel("");
		lblVida1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVida1.setForeground(Color.RED);
		lblVida1.setBounds(286, 29, 32, 32);
		contentPane.add(lblVida1);
		
		lblVida2 = new JLabel("");
		lblVida2.setForeground(Color.RED);
		lblVida2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVida2.setBounds(341, 29, 32, 32);
		contentPane.add(lblVida2);
		
		lblVida3 = new JLabel("");
		lblVida3.setForeground(Color.RED);
		lblVida3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVida3.setBounds(393, 29, 32, 32);
		contentPane.add(lblVida3);
		
		miJuego = new Juego(tema, this);
		ImageIcon img;
		ImageIcon icon;
		
		if(tema == 1) {
			icon= new ImageIcon(getClass().getResource("/imagenesA/autoDerecha.png"));
			img= new ImageIcon(icon.getImage().getScaledInstance(lblVida1.getWidth(), lblVida1.getHeight(), Image.SCALE_SMOOTH));
		}else {
			icon= new ImageIcon(getClass().getResource("/imagenesB/barco_der.png"));
			img= new ImageIcon(icon.getImage().getScaledInstance(lblVida1.getWidth(), lblVida1.getHeight(), Image.SCALE_SMOOTH));
		}
			
		lblVida1.setIcon(img);
		lblVida2.setIcon(img);
		lblVida3.setIcon(img);
		
		labelSonido = new JLabel("");
		labelSonido.setIcon(new ImageIcon(VentanaGUI.class.getResource("/imagenes/musicaActivada.png")));
		labelSonido.setForeground(Color.WHITE);
		labelSonido.setBounds(636, 10, 50, 50);
		contentPane.add(labelSonido);
		
		sonidoActivo=false;
		labelSonido.setIcon(new ImageIcon(VentanaGUI.class.getResource("/imagenes/musicaDesactivada.png")));
		
		addKeyListener(this);
	}
	

	public void moverEntidad(int posX, int posY, int posXFin, int posYFin, Entidad e) {
		e.setBounds(posXFin, posYFin, e.getWidth(), e.getHeight());
	}

	public void inicializarNivel(HashSet<Entidad> nivel, Entidad protagonista, Blinky blinky, Clyde clyde, Pinky pinky, Inky inky) {
		ImageIcon imagen;
		
		protagonista.setBounds(protagonista.getX(), protagonista.getY(), 32, 32);
		panel.add(protagonista);
		protagonista.setIcon(new ImageIcon(VentanaGUI.class.getResource(protagonista.getRepresentacion())));
		
		blinky.setBounds(blinky.getX(), blinky.getY(), 32, 32);
		panel.add(blinky);
		blinky.setIcon(new ImageIcon(VentanaGUI.class.getResource(blinky.getRepresentacion())));
		
		pinky.setBounds(pinky.getX(), pinky.getY(), 32, 32);
		panel.add(pinky);
		pinky.setIcon(new ImageIcon(VentanaGUI.class.getResource(pinky.getRepresentacion())));
		
		clyde.setBounds(clyde.getX(), clyde.getY(), 32, 32);
		panel.add(clyde);
		clyde.setIcon(new ImageIcon(VentanaGUI.class.getResource(clyde.getRepresentacion())));
		
		inky.setBounds(inky.getX(), inky.getY(), 32, 32);
		panel.add(inky);
		inky.setIcon(new ImageIcon(VentanaGUI.class.getResource(inky.getRepresentacion())));
		for(Entidad e : nivel) {
			e.setBounds(e.getX(), e.getY(), 32, 32);
			panel.add(e);
			imagen = new ImageIcon(VentanaGUI.class.getResource(e.getRepresentacion()));
			e.setIcon(imagen);
		}
		
		reiniciarVidas();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		switch(code) {
		case KeyEvent.VK_RIGHT:
			miJuego.moverDerAction();
			break;
		case KeyEvent.VK_LEFT: 
			miJuego.moverIzqAction();
			break;
		case KeyEvent.VK_DOWN:
			miJuego.moverAbajoAction();
			break;
		case KeyEvent.VK_UP:
			miJuego.moverArribaAction();
			break;
		case KeyEvent.VK_SPACE:
			miJuego.colocarBomba();
			break;
		case KeyEvent.VK_M:
			sonidoActivo = !sonidoActivo;
			miJuego.setearSonido(sonidoActivo);
			if(sonidoActivo)
				labelSonido.setIcon(new ImageIcon(VentanaGUI.class.getResource("/imagenes/musicaActivada.png")));
			else 
				labelSonido.setIcon(new ImageIcon(VentanaGUI.class.getResource("/imagenes/musicaDesactivada.png")));
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actualizarPuntaje(int puntaje) {
		this.puntaje=puntaje;
		lblPuntaje.setText(""+puntaje);
	}

	public void eliminarVidas(int vidas) {
		switch(vidas) {
		case 1: lblVida1.setVisible(false);
		break;
		case 2: lblVida2.setVisible(false);
		break;
		case 3: lblVida3.setVisible(false);
		break;
		}
		
	}

	public void reiniciarVidas() {
		lblVida1.setVisible(true);
		lblVida2.setVisible(true);
		lblVida3.setVisible(true);
	}
	
	public void reiniciarJuego() {
        labelSonido.setIcon(new ImageIcon(VentanaGUI.class.getResource("/imagenes/musicaDesactivada.png")));
        limpiar();
        reiniciarVidas();
        actualizarPuntaje(0);
        miJuego.inicializarNivel1();
    }
	
	public void cerrarJuego() {
		miJuego.cerrarJuego();
		dispose();
	}
	public void finJuego(String texto) {
		finJuego.setResultado(texto);
		finJuego.setPuntuacion(puntaje);
		finJuego.setVisible(true);
	}

	public String getPuntaje() {
		return puntaje+"";
	}

	public void limpiar() {
		panel.removeAll();
		panel.repaint();
	}
	
	public boolean getSonido() {
		return sonidoActivo;
	}
}

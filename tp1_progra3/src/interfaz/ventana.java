package interfaz;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ventana {

	private static JFrame menu;
	App juego;
	private JTextField cantidadDeTurnos;
//	 private static DatosJuego data=new DatosJuego();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final ventana window = new ventana();
					window.menu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ventana() {
		initialize();
	}

	public static int mostrarse() {
		menu.setVisible(true);
		return 0;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final ArrayList<JButton> interfazMenu = new ArrayList<JButton>();
		final ArrayList<JButton> interfazdificultad = new ArrayList<JButton>();
		final ArrayList<JComponent> interfazPersonalizado = new ArrayList<>();
		menu = new JFrame();
		menu.setResizable(false);
		menu.setIconImage(Toolkit.getDefaultToolkit().getImage(ventana.class.getResource("/imagenes/icono_lights_out.png")));
		//acomodado de la ventana
		
		int anchoFrame=450;
		int alto = 300;
		
		centrarVentana(anchoFrame, alto, menu);
		
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.getContentPane().setLayout(null);
		// botones de menu-----------------------------------
		
		JButton nuevoJuego = new JButton("Nuevo Juego");
		nuevoJuego.setAlignmentX(Component.CENTER_ALIGNMENT);
		nuevoJuego.setFocusable(false);
		nuevoJuego.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nuevoJuego.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		nuevoJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ocultarBotones(interfazMenu);
				mostrarBotones(interfazdificultad);
			}
		});

		nuevoJuego.setBounds(0, 73, 150, 35);
		menu.getContentPane().add(nuevoJuego);
		
		JButton personalizado = new JButton("Personalizado");
		personalizado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		personalizado.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		personalizado.setFocusable(false);
		personalizado.setBounds(0, 120, 150, 33);
		personalizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ocultarBotones(interfazMenu);
				mostrarUI(interfazPersonalizado);
			}
		});
		menu.getContentPane().add(personalizado);

		
		JButton ranking = new JButton("ranking");
		ranking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ranking.setFocusable(false);
		ranking.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		ranking.setBounds(0, 170, 130, 30);
		menu.getContentPane().add(ranking);
		ranking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane muestraRanking = new JOptionPane();
				ArrayList<Integer> rankingActual=Principal.devolverRanking();
				Integer primerPuesto=(rankingActual.size()>=1)?rankingActual.get(0):0;
				Integer segundoPuesto=(rankingActual.size()>=2)?rankingActual.get(1):0;
				Integer tercerPuesto=(rankingActual.size()>=3)?rankingActual.get(2):0;
				Integer cuartoPuesto=(rankingActual.size()>=4)?rankingActual.get(3):0;
				muestraRanking.showMessageDialog(menu, "Ranking: \nPrimer Puesto: " + primerPuesto +" Turnos"
						+ "\nSegundo Puesto: " + segundoPuesto + " Turnos"
						+ "\nTercer Puesto: " + tercerPuesto + " Turnos"
						+ "\nCuarto Puesto: " + cuartoPuesto + " Turnos");
			}
		});
		
		JButton salir = new JButton("salir");
		salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		salir.setFocusable(false);
		salir.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menu.dispose();
				System.exit(0);
			}
		});

		salir.setBounds(0, 227, 150, 23);
		menu.getContentPane().add(salir);
		
		//botones de dificultad-------------------------------
		
		JButton volver = new JButton("volver");
		volver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volver.setFocusable(false);
		volver.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		volver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ocultarBotones(interfazdificultad);
				ocultarUI(interfazPersonalizado);
				mostrarBotones(interfazMenu);
			}
		});
		volver.setBounds(0, 227, 150, 23);
		menu.getContentPane().add(volver);
		
		JButton facil = new JButton("Facil");
		facil.setAlignmentX(Component.CENTER_ALIGNMENT);
		facil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		facil.setFocusable(false);
		facil.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		facil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJuego(3);
			}
		});
		facil.setBounds(0, 73, 90, 23);
		menu.getContentPane().add(facil);
		
		JButton normal = new JButton("Normal");
		normal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		normal.setFocusable(false);
		normal.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJuego(4);
			}
		});
		normal.setBounds(0, 121, 90, 23);
		menu.getContentPane().add(normal);
		
		JButton dificil = new JButton("Dificil");
		dificil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dificil.setFocusable(false);
		dificil.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		dificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJuego(5);
			}
		});
		dificil.setBounds(0, 171, 90, 23);
		menu.getContentPane().add(dificil);
		
		//interfaz de juego personalizado----------------------------------------------
		cantidadDeTurnos = new JTextField();
		cantidadDeTurnos.setBounds(167, 176, 86, 20);
		menu.getContentPane().add(cantidadDeTurnos);
		cantidadDeTurnos.setColumns(10);
		
		JLabel labelCantidadTurnos = new JLabel("Cantidad de turnos:");
		labelCantidadTurnos.setLabelFor(cantidadDeTurnos);
		labelCantidadTurnos.setHorizontalAlignment(SwingConstants.CENTER);
		labelCantidadTurnos.setHorizontalTextPosition(SwingConstants.CENTER);
		labelCantidadTurnos.setBounds(129, 158, 160, 14);
		menu.getContentPane().add(labelCantidadTurnos);
		
		JLabel tutorialPersonalizado = new JLabel("<html>En el modo de juego personalizado ingresas la cantidad de turnos maxima para que se resuelva el juego</html>");
		tutorialPersonalizado.setHorizontalTextPosition(SwingConstants.CENTER);
		tutorialPersonalizado.setHorizontalAlignment(SwingConstants.TRAILING);
		tutorialPersonalizado.setBounds(100, 63, 269, 102);
		menu.getContentPane().add(tutorialPersonalizado);
		
		interfazPersonalizado.add(tutorialPersonalizado);
		interfazPersonalizado.add(cantidadDeTurnos);
		interfazPersonalizado.add(labelCantidadTurnos);
		interfazPersonalizado.add(volver);
		//agrego los botones a una lista para poder mostrarlos y ocultarlos 
		
		interfazMenu.add(nuevoJuego);
		interfazMenu.add(ranking);
		interfazMenu.add(salir);
		interfazMenu.add(personalizado);
		
		interfazdificultad.add(dificil);
		interfazdificultad.add(facil);
		interfazdificultad.add(normal);
		interfazdificultad.add(volver);
		
		centrarBotones(interfazMenu, anchoFrame);
		centrarBotones(interfazdificultad, anchoFrame);
		
		//se empieza con el menu mostrado y la dificultad ocultada
		ocultarBotones(interfazdificultad);
		ocultarUI(interfazPersonalizado);
		
		JLabel titulo = new JLabel("Lights Out!");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
		titulo.setBounds(conseguirxCentro(anchoFrame, 200), 11, 200, 44);
		menu.getContentPane().add(titulo);
		
		

	}
	
	private void ocultarBotones (ArrayList<JButton> botones) {
		for (JButton boton : botones) {
			boton.setVisible(false);
		}
	}
	private void ocultarUI(ArrayList<JComponent> component) {
		for (JComponent jComponent : component) {
			jComponent.setVisible(false);
		}
	}
	private void mostrarUI(ArrayList<JComponent> component) {
		for (JComponent jComponent : component) {
			System.out.println("a");
			jComponent.setVisible(true);
		}
	}
	private void mostrarBotones (ArrayList<JButton> botones) {
		for (JButton boton : botones) {
			boton.setVisible(true);
		}
	}
	
	private void iniciarJuego(int i) {
		juego = new App(i);
		juego.mostrarse();
		menu.dispose();
	}
	
	public void centrarVentana(int ancho , int alto , JFrame frame) {
		Dimension tamanioventana = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((tamanioventana.width/2)-(ancho/2), (tamanioventana.height/2)-(alto/2), ancho, alto);
	}
	private int conseguirxCentro(int ancho,int anchoComponente) {
		return ((ancho/2)-(anchoComponente/2+10));
	}
	private void centrarBotones(ArrayList<JButton> botones,int ancho) {
		for (JButton boton : botones) {
			int anchoBoton = boton.getWidth();
			int altura= boton.getY();
			boton.setLocation(conseguirxCentro(ancho, anchoBoton), altura);
		}
	}
}

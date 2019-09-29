package pr00;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panelPricipal;
	JPanel panelBotonera;
	CocheJuego coche;
	static Hilo hilo;

	public VentanaJuego() {
		this.panelPricipal = new JPanel();
		this.panelBotonera = new JPanel();
		this.panelPricipal.setLayout(null);
		this.panelPricipal.setBackground(Color.white);
		JButton bAcelerar = new JButton("Acelera");
		JButton bFrenar = new JButton("Frena");
		JButton bGiraIzq = new JButton("Gira Izq");
		JButton bGiraDer = new JButton("Gira Der");

		add(this.panelPricipal, BorderLayout.CENTER);
		add(this.panelBotonera, BorderLayout.SOUTH);
		panelBotonera.add(bAcelerar);
		panelBotonera.add(bFrenar);
		panelBotonera.add(bGiraDer);
		panelBotonera.add(bGiraIzq);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(700, 500);

		bAcelerar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(5.0);

			}
		});
		bFrenar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(-5.0);

			}
		});
		bGiraDer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(10.0);

			}
		});
		bGiraIzq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(-10.00);

			}
		});

	}

	public void crearCoche(int posX, int posY) {
		coche = new CocheJuego();
		coche.setPosX(posX);
		coche.setPosY(posY);
		panelPricipal.add(coche.getGraficoCoche());

	}

	public class Hilo implements Runnable {

		@Override
		public void run() {
			coche.mueve(0.04);
			try {
				Thread.sleep((long) 0.04);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		VentanaJuego ventana = new VentanaJuego();
		ventana.crearCoche(150, 100);
		ventana.setVisible(true);
		Thread hilo1 = new Thread(hilo);
		hilo1.start();

	}

}

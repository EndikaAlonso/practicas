package pr00;

public class CocheJuego extends Coche {
	private JLabelCoche graficoCoche;

	public CocheJuego() {
		graficoCoche = new JLabelCoche();

	}

	public JLabelCoche getGraficoCoche() {
		return graficoCoche;
	}

	public void setGraficoCoche(JLabelCoche graficoCoche) {
		this.graficoCoche = graficoCoche;
	}

	@Override
	public void setPosX(double posX) {

		super.setPosX(posX);
		graficoCoche.setLocation((int) this.posX, (int) this.posY);
	}

	@Override
	public void setPosY(double posY) {

		super.setPosX(posY);
		graficoCoche.setLocation((int) this.posX, (int) this.posY);
	}

}

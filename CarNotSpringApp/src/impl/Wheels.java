package impl;

public class Wheels implements cars.Wheels{
	private final int width;
	private final int diameter;
	private final int cloakHeight;
	public Wheels(int width, int atmero, int kopenymagassag) {
		super();
		this.width = width;
		this.diameter = atmero;
		this.cloakHeight = kopenymagassag;
	}
	@Override
	public String toString() {
		return "[width=" + width + "/"+cloakHeight+ " R " + diameter+"]";
	}
}

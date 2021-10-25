package hu.uni.me.iit.SpringConsoleApp.impl;

public class Wheels implements hu.uni.me.iit.SpringConsoleApp.Wheels{
	private final int width;
	private final int diameter;
	private final int cloakHeight;
	public Wheels(int width, int atmero, int kopenymagassag) {
		this.width = width;
		this.diameter = atmero;
		this.cloakHeight = kopenymagassag;
	}
	@Override
	public String toString() {
		return "[width=" + width + "/"+cloakHeight+ " R " + diameter+"]";
	}
}

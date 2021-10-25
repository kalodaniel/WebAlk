package hu.uni.me.iit.SpringConsoleApp.impl;

import hu.uni.me.iit.SpringConsoleApp.Engine;

public class ElectricEngine implements Engine {
	private final int performance;
	private final int tension;
	public ElectricEngine(int performance, int tension) {
		super();
		this.performance = performance;
		this.tension = tension;
	}
	@Override
	public String toString() {
		return "ElectricEngine [performance=" + performance + ", tension=" + tension + "]";
	}
}

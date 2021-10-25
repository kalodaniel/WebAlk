package hu.uni.me.iit.SpringConsoleApp.impl;

import hu.uni.me.iit.SpringConsoleApp.Engine;

public class InsideBurnEngine implements Engine{
	private final int horsePow;
	private final int ccm;
	
	public InsideBurnEngine(int horsePow, int ccm) {
		this.horsePow = horsePow;
		this.ccm = ccm;
	}

	@Override
	public String toString() {
		return "Engine [horsePow=" + horsePow + ", ccm=" + ccm + "]";
	}
	
	
}

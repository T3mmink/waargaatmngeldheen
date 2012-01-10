package nl.arnovanoort.wgmgh.domain;

public enum Bank {

	TRIODOS("TRIODOS"), ABNAMRO("ABNAMRO"), ING("ING");

	String name;
	
	Bank(String name){
		this.name=name;
	}
}

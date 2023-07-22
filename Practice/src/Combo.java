import java.util.Scanner;
import java.util.Arrays;
public class Combo {
	private String cName;
	private static String cType;
	public Combo(String cName, String cType) {
	this.cName = cName;
	Combo.cType = cType;
	}
	public static void main(String[] args) {
	Combo s = new Combo("COMP-248", "Section S");
	Combo t = new Combo("COMP-249", "Section T");
	Combo u = new Combo("COMP-250", "Section U");
	System.out.println("cName: " + t.cName);
	System.out.println("cType: " + Combo.cType);
	}
}

package myproject;

import java.util.Arrays;

public class ChemicalElement {
	private int atomic_no;//make them private in order to disable change of these fields
	private String symbol;
	private String fullname;
	static Integer [] metals;
	static {
		metals= new Integer[]{
				new Integer(13),
				new Integer(49),
				new Integer(50),
				new Integer(81),
				new Integer(82),
				new Integer(83),
				new Integer(113),
				new Integer(114),
				new Integer(115),
				new Integer(116)
		};
	}
	public ChemicalElement(int atno,String sym, String fulln)
	{
		this.atomic_no = atno;
		this.symbol = sym;
		this.fullname = fulln;
	}
	public int getAtomic_no() {
		return atomic_no;
	}
	public String getSymbol() {
		return symbol;
	}
	public String getFullname() {
		return fullname;
	}
	
	public static boolean isAlkaliMetal(ChemicalElement c)
	{
		int tempno = c.atomic_no;
		switch(tempno)
		{
		case 3: return true;
		case 11: return true;
		case 19: return true;
		case 37: return true;
		case 55: return true;
		case 87: return true;
		default: return false;
		}
	}
	public static boolean isTransitionMetal(ChemicalElement c)
	{
		int tempno = c.atomic_no;
		boolean    ret = ((tempno >=21 && tempno <=31) || (tempno >= 39 && tempno <=48) || (tempno >= 72 && tempno <=82) || (tempno >=104 && tempno <=112))? true: false ;
		return ret;
	}
	public static boolean isMetal(ChemicalElement c) {
		int tempno = c.atomic_no;
		boolean test =Arrays.asList(metals).contains(tempno);
		return test;
	}
	public boolean equals(Object o)
	{
		if(o == null || o.getClass() != this.getClass())
			return false;
		ChemicalElement temp = (ChemicalElement) o ;
		return ( temp.atomic_no == this.atomic_no && temp.symbol == this.symbol && temp.fullname == this.fullname);
		
		
	}
	
}

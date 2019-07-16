package myproject;

public class ChemicalElementApp {
	public static void main(String[] args)
	{
		ChemicalElement c= new ChemicalElement(27, "Zn","Zinc");
		ChemicalElement c1= new ChemicalElement(27, "Zn","Zinc");
		if(c == c1) {
			System.out.println("true");
		}
		else
			System.out.println("false");
		if(c.equals(c1))
			System.out.println("true");
		else
			System.out.println("false");
		if(c1.isAlkaliMetal(c1))
			System.out.println("its alkali");
		else if (c1.isMetal(c1))
			System.out.println("its metal");
		else if (c1.isTransitionMetal(c1))
			System.out.println("its tranistion");
	}

		

}

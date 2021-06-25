package rsn170330.lp1;

/**
 * This class is for calculation with large float numbers.
 * @author janne
 *
 */
public class LargeFloat {

	/**
	 * Subtracts two float numbers.
	 * @param nr1
	 * @param nr2
	 * @return result
	 */
	public String subFloat(String nr1, String nr2) {
		String[] arrNr1 = split(nr1);
		String[] arrNr2 = split(nr2);
		// Brings the decimal places to the same length.
		if (!(arrNr1[1].length() == arrNr2[1].length())) {
			if (arrNr1[1].length() < arrNr2[1].length()) {
				while (arrNr1[1].length() <= arrNr2[1].length()) {
					arrNr1[1] = arrNr1[1] + "0";
				}
			} else {
				while (arrNr1[1].length() >= arrNr2[1].length()) {
					arrNr2[1] = arrNr2[1] + "0";
				}
			}
		}//------------------------------------------------
		Num mainNr = Num.subtract(new Num(arrNr1[0]), new Num(arrNr2[0]));
		int len = arrNr1[1].length();
		Num afterPoint = Num.subtract(new Num(arrNr1[1]), new Num(arrNr2[1]));
		if (afterPoint.toString().length() > len) {
			mainNr = Num.subtract(mainNr, new Num("1"));
			afterPoint = fooNextAfterPoint(afterPoint);
		}
		return (mainNr.toString() + "." + afterPoint.toString());
	}
	
	/**
	 * Adds two float numbers.
	 * @param nr1
	 * @param nr2
	 * @return result
	 */
	public String addFloat(String nr1, String nr2) {
		String[] arrNr1 = split(nr1);
		String[] arrNr2 = split(nr2);
		// Brings the decimal places to the same length.
		if (!(arrNr1[1].length() == arrNr2[1].length())) {
			if (arrNr1[1].length() < arrNr2[1].length()) {
				while (arrNr1[1].length() <= arrNr2[1].length()) {
					arrNr1[1] = arrNr1[1] + "0";
				}
			} else {
				while (arrNr1[1].length() >= arrNr2[1].length()) {
					arrNr2[1] = arrNr2[1] + "0";
				}
			}
		}
		//------------------------------------------------
		Num mainNr = Num.add(new Num(arrNr1[0]), new Num(arrNr2[0]));
		int len = arrNr1[1].length();
		Num afterPoint = Num.add(new Num(arrNr1[1]), new Num(arrNr2[1]));
		if (afterPoint.toString().length() > len) {
			mainNr = Num.add(mainNr, new Num("1"));
			afterPoint = fooNextAfterPoint(afterPoint);
		}
		return (mainNr.toString() + "." + afterPoint.toString());
	}
	
	/**
	 * 
	 * @param str 111.222
	 * @return ["111", "222"]
	 */
	private String[] split(String str) {
		char DELIMITER = '.';
		String[] arr = new String[2];
		int d = str.indexOf(DELIMITER);
		char[] vorn = new char[d];
		char[] hint = new char[str.length() - d - 1];
		int co = 0;
		for (int i = 0; i < vorn.length; i++) {
			vorn[i] = str.charAt(co);
			co++;
		}
		co++;
		for (int k = 0; k < hint.length; k++) {
			hint[k] = str.charAt(co);
			co++;
		}
		arr[0] = new String(vorn);
		arr[1] = new String(hint);
		return arr;
	}

	/**
	 * 
	 * @param afterPoint 1234
	 * @return 234
	 */
	private Num fooNextAfterPoint(Num afterPoint) {
		return (new Num(afterPoint.toString().substring(1)));
	}

	/**
	 * 
	 * Test for this class
	 */
	public static void main(String[] args) {
		String float1 = "23456234875623875628376548734.91232452345346573648756348753273589999";
		String float2 = "5234523453222.777346875634765723650000001111111010101476837658375875647534856387487448567468757777777";
		LargeFloat largeFloat = new LargeFloat();
		String result = largeFloat.addFloat(float1, float2);
		System.out.println("add:" + result);
		result = largeFloat.subFloat(float2, float1);
		System.out.println("sub:" + result);
		System.out.println("Is 2 smaller than 5 " + Num.isSmallerThan(new Num(2), new Num(5)));
		System.out.println("Is 777773453452344523465453425234532450000000000000000545435245454343549994579878673985769873965876938476897345897960000000000000000000000000000000000000000000000 \n"
				+ "smaller than 34675687263875672364587647567638472687465897326874658723648756239874658723645876234975628946598236 "
		+ Num.isSmallerThan(new Num("777773453452344523465453425234532450000000000000000545435245454343549994579878673985769873965876938476897345897960000000000000000000000000000000000000000000000"),
				new Num("34675687263875672364587647567638472687465897326874658723648756239874658723645876234975628946598236")));
		Num n = Num.faculty(new Num(8));
		System.out.println("faculty of 8 is: " + n.toString());
	}
}
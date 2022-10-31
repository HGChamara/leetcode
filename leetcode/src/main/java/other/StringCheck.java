package other;

public class StringCheck {

	public static void main(String[] args) {
		String a = "asd";
		
		char[] chars = a.toCharArray();
		char[] chars2 = a.toCharArray();
		String b = new String(chars);
		
		
		if(a.equals(b)) {
			System.out.println("equals");
		}
		
		
		if(chars.equals(chars2)) {
			System.out.println("char[]");
		}

	}

}

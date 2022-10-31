package googleinterview;

public class Overloading{

	public static void main(String[] args) {
		byte a = 25;
		UserOverloading obj = new UserOverloading();
        obj.show(a); // it will go to
        // byte argument
        obj.show("hello"); // String
        obj.show(250); // Int
        obj.show('A'); // Since char is
        // not available, so the datatype
        // higher than char in terms of
        // range is int.
        obj.show("A"); // String
        obj.show(7); // since float datatype
// is not available and so it's higher
// datatype, so at this step their
// will be an error.

	}

}


class UserOverloading{
	public void show(double x)
    {
        System.out.println("In double" + x);
    }
    public void show(String s)
    {
        System.out.println("In String" + s);
    }
    public void show(byte b)
    {
        System.out.println("In byte" + b);
    }
}

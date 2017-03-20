import java.util.*;

abstract class Vehicle {
	int yom;

	public Vehicle () { }

	public Vehicle (int yom )
	{
		this.yom = yom;
	}
	abstract public void getData();

	abstract public void putData();
}

class TwoWheeler extends Vehicle {

	public TwoWheeler(){
	}

	public TwoWheeler( int yom){
		super(yom);
	}
	
	public void getData(){
		System.out.println("Two Wheeler");
		System.out.println("Enter year of Manufacture");
		Scanner sc = new Scanner(System.in);
		yom = sc.nextInt();
	}

	public void putData(){
		System.out.println("Year of Manufacture is " + yom );
	}

}

final class FourWheeler extends Vehicle {

	public void getData(){
		System.out.println("Four Wheeler");
		System.out.println("Enter year of Manufacture");
		Scanner sc = new Scanner(System.in);
		yom = sc.nextInt();
	}

	public void putData(){
		System.out.println("Year of Manufacture is " + yom );
	}

}

class MyTwoWheeler extends TwoWheeler {

	public MyTwoWheeler (int yom )
	{
		super(yom);
	}
}

public class InheritanceClient {

	public static void main ( String args[] ) {

		TwoWheeler tw = new TwoWheeler();
		tw.getData();
		tw.putData();
		FourWheeler fw = new FourWheeler();
		fw.getData();
		fw.putData();
		System.out.println("My Two Wheeler");
		MyTwoWheeler mtw = new MyTwoWheeler(2003);
		mtw.putData();

	}
}
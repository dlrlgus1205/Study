package day03;

public class OopTest {
	public static void main(String[] args) {
		Human hum = new Human();
		System.out.println("x : " + hum.x);
		System.out.println("y : " + hum.y);
		hum.moveX(3);
		hum.moveY(-5);
		System.out.println("x : " + hum.x);
		System.out.println("y : " + hum.y);
	}
}

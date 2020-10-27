package JavaActivity2;

public class Activity2_2 {

	public static void main(String[] args) throws InterruptedException {

		// There is a plane with max 10 passengers
		Plane plane = new Plane(10);
		// Add passengers on the list
		plane.onboard("John");
		plane.onboard("Steve");
		plane.onboard("Anna");
		// Plane takes off
		System.out.println("Plane took off at: " + plane.takeOff());
		// Print list of people on board
		System.out.println("People on the plane: " + plane.getPassengers());
		// Flying.....
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Plane has landed
		plane.land();
		// Plane lands
		System.out.println("Plane landed at: " + plane.getLastTimeLanded());
		System.out.println("People on the plane after landing: " + plane.getPassengers());

	}

}


public class InterfaceExample {
	public interface SelfDrivable {
		void setDestination(String dest);
		void drive();
		void honkHorn();
		
		default void wakeDJUp() {
			for (int i=0; i<10; i++) {
				honkHorn();
			}
		}
	}
}

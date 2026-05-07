package SDET_Day7;

class Order1 implements Runnable{

	@Override
	public void run() {
		try {
			for(int i=1;i<=5;i++) {
				System.out.println("Order is being Processed");
				Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			System.out.print(e.getMessage());
		}
	}
}

class Payment1 implements Runnable{

	@Override
	public void run() {
		System.out.println("Payment to be done");
	}
	
}
class Notification implements Runnable{
	@Override
	public void run(){
		System.out.println("Notification sent");
	}
}
public class Multithreading_Q1 {
	public static void main(String[] args) throws InterruptedException {
		Order1 o = new Order1();
		Payment1 p = new Payment1();
		Notification n = new Notification();
		
		Thread t1 = new Thread(o);
		Thread t2 = new Thread(p);
		Thread t3 = new Thread(n);
		
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
	}
	
}
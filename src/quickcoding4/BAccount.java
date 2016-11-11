package quickcoding4;

public class BAccount{
	private int balance = 100;
	
	public int getBalance() {
		return balance;
	}
	public void withDraw(int amount) {
		if(balance < 0){
			try{
				synchronized(this){
					wait();
				}
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		balance -= amount;
	}
	public synchronized void add(int money) { 
		balance += money;
		System.out.println("총합 : " + balance + " " + money + " 만큼 입금");
	}
	public synchronized void delete(int money) {
		balance -= money;
		System.out.println("총합 : " +balance + " " + money + " 만큼 출금");
	}
}

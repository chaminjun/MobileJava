package quickcoding4;

import quickcoding4.BAccount;

/*	extends Thread 하는 방법과 implements Runnable 하는 방법이 있다.
 * 	단, implements의 경우 start함수를 사용할 수 없는데 start함수는 Thread의 함수이기 때문이다.
 * 	따라서 implements를 한 경우에는 따로 Thread 형식으로 객체를 재생성한 후 start함수를 실행하여야 한다.
 * 
 * 	쓰레드의 스케쥴링이 중요한데 우선순위가 높은 쓰레드의 실행을 우선시하고 동일한 우선순위일 경우 CPU의 할당시간을 분배해서 실행한다.
 * 	CPU의 할당이 불필요한 상황이 올 경우(예를들어, sleep을 이용) 우선순위가 낮은 쓰레드에게 할당된 CPU를 양보하는 상황을 연출할 수 있다.
 * 
 * 	1. new를 통해서 인스턴스화를 시킨다. (쓰레드라 표현)
 *  2. start메소드가 호출되면 Runnable상태가 된것이다. (스케줄러에 의해서 선택되어 실행될 수 있다.)
 *  3. sleep이나, join메소드가 호출될 경우 CPU를 다른 쓰레드에게 양보하고 Blocked상태가 된다. 
 *  4. run메소드의 실행이 완료되어 빠져 나오게 되면 Dead상태가 된다. 
 *  
 *  힙 영역을 공유하는데 이는 동기화문제를 일으킬 수 있다.
 *  1. public synchronized int add(int num1, int num2){
 *  	opCnt++;
 *  	return num1 + num2;
 *  }와 같이 synchronized를 해주게되면 한 순간에 하나의 쓰레드만 호출이 가능하게끔 된다. 
 *  <동기화의 주체는 인스턴스!!>
 *  2. public int add(int num1, int num2){
 *		synchronized(this){
 *			opCnt++;
 *		} return num1 + num2;
 *		} 형식으로도 가능하다.  
 */
public class BATest {

	public static BAccount  account = new BAccount();
	public static void main(String[] args) {
		Thread depositMan = new Thread() { 
			public void run(){
				for(int i = 0; i < 10; i++){
					account.add(10);
					try{
						Thread.sleep(100);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		};
		Thread withdrawMan = new Thread() { 
			public void run(){
				for(int i = 0; i < 10; i++){
					account.delete(5);
					try{
						Thread.sleep(100);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}; 
		depositMan.start(); 
		withdrawMan.start();
		}
}

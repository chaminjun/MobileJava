package quickcoding3;


import java.util.Scanner;

class NumbernException extends Exception
{
	public NumbernException()
	{
		super();
	}
}
public class quickcoding3 {
	public static void main(String[] args)
	{	
		int result = 0;		
		System.out.println("나눗셈을 실시합니다.");
		try{
			int num1 = readNum();
			int num2 = readNum();
			result = num1 / num2;
			System.out.println("result = "+result);
		}catch(ArithmeticException e){
			e.printStackTrace();
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(NumbernException e){
			e.printStackTrace();
			System.out.println("\n유효한 숫자가 아닙니다.");
		}catch(NumberFormatException e){
			e.printStackTrace();
			System.out.println("숫자로 변하지 않습니다.");
		}
	}
	public static int readNum() throws NumbernException
	{
		String s = null;			
		Scanner keyboard = new Scanner(System.in);
		s = keyboard.nextLine();
		int num = Integer.parseInt(s);
		if(num > 999)
		{
			NumbernException excpt = new NumbernException();
			throw excpt;
		}
		return num;
	}	
}


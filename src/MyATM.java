import java.util.ArrayList;

public class MyATM {

	private double balance=0;
	private int cnt=0;
	private ArrayList<String> history = new ArrayList<String>(5);
	private int i=0, pnt=5;

	public void setDeposit(String deposit) {
		balance = balance + Double.parseDouble(deposit);
		cnt++;
		if(i<5) {
			history.add("Deposit: "+deposit);
			i++;
		}
		else
		{
			history.remove(0);
			history.add("Deposit: "+deposit);
		}
	}

	
	public boolean checkWithdraw(String withdraw) {
		if(Double.parseDouble(withdraw)>balance)
			return false;
		else
			return true;
	}
	public void setWithdraw(String withdraw) {
		balance -= Double.parseDouble(withdraw);
		cnt++;
		if(i<5) {
			history.add("Withdraw: "+withdraw);
			i++;
		}
		else
		{
			history.remove(0);
			history.add("Withdraw: "+withdraw);
		}	
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public String next()
	{
		pnt = Math.min(cnt, pnt);
		if(pnt>=4 || pnt>=cnt-1)
			return "You Can't Load Next Transaction";
		else 
			return history.get(++pnt);	
	}
	
	public String previous()
	{
		pnt = Math.min(cnt, pnt);
		if(pnt>0)
			return history.get(--pnt);
		else
			return "You Can't Load Previous Transaction";
	}
	
//	public static void main(String[] args)
//	{
//		MyATM saber = new MyATM();
//		saber.setDeposit("500");
//		saber.setWithdraw("120");
//		saber.setDeposit("541");
//		saber.setDeposit("6100");
//		saber.setWithdraw("210");
//		saber.setDeposit("30");
//		System.out.println("Saber balance is "+saber.getBalance());
//		System.out.println(saber.next());
//		System.out.println(saber.previous());
//		System.out.println(saber.previous());
//		System.out.println(saber.previous());
//		System.out.println(saber.previous());
//		System.out.println(saber.previous());
//		System.out.println(saber.previous());
//		System.out.println(saber.next());
//		System.out.println(saber.next());
//		System.out.println(saber.next());
//		System.out.println(saber.next());
//		System.out.println(saber.next());
//	}
	
}

import java.util.*;
class Account
{
	int accountNum, phoneNum;
	String name;
	float balance;
	
	Account()
	{
		
	}

	public void getInput()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter account num : ");
		accountNum = sc.nextInt();
		System.out.println("\nEnter name : ");
		sc.nextLine();
		name = sc.nextLine();
		System.out.println("\nEnter phone num : ");
		phoneNum = sc.nextInt();
		System.out.println("\nEnter initial balance : ");
		balance = sc.nextFloat();
	}
	
	public void deposit()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter the amount to be deposited : ");
		float amt = sc.nextFloat();
		balance += amt;
		System.out.println("\nUpdated balance : " + balance);
	}

	public void withdraw()
	{
		Scanner sc = new Scanner(System.in);
		if(balance == 0.0)
			System.out.println("Oops! Zero balance");
		else
		{
			System.out.println("\nEnter the amount to be withdrawn : ");
			float amt = sc.nextFloat();
			if(balance < amt)
				System.out.println("\nOops! Not enough balance");
			else
			{	
				balance -= amt;
				System.out.println("\nUpdated balance : " + balance);
			}
		}
	}

	public void display()
	{
		System.out.println("Account num : " + accountNum);
		System.out.println("Name : " + name);
		System.out.println("Phone Num : " + phoneNum);
		System.out.println("Bal : " + balance);
	}

	public static void main(String[] args)
	{
		int ch;
		Scanner sc = new Scanner(System.in);
		Account obj = new Account();
		obj.getInput();
		while(true)
		{
			System.out.println("1)Deposit\n2)Withdraw\n3)Display\n4)Exit");
			ch = sc.nextInt();
			switch(ch)
			{
				case 1:
					obj.deposit();
					break;
				
				case 2:
					obj.withdraw();
					break;			
				
				case 3:
					obj.display();
					break;
				default:
					System.exit(0);
			}
		}
	}
}

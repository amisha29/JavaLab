package StudentPackage;
import java.util.*;


public class RegisteredStudent implements Student
{
    String name, branch;
    int sem;
    ArrayList<Integer> creditList; 
    public RegisteredStudent(String name, String branch)
    {
        this.name = name;
        this.branch = branch;
        creditList = new ArrayList<>();
    }

    public void register()
    {
        System.out.println("Enter num of semesters : ");
        Scanner sc = new Scanner(System.in);
        sem = sc.nextInt();

        for(int i = 0; i < sem; i++)
        {
            try {
                int credit;
                System.out.println("Enter credits for " + (i+1) + " sem : ");
                credit = sc.nextInt();
                if(credit > 30)
                    throw new CreditLimitException();
                else
                    creditList.add(credit);

            } catch (CreditLimitException e) {
                e.print_msg();
            }
        }
    }

    public int getSemCount()
    {
        return sem;
    }
    
    public int getCredit(int n)
    {
        return creditList.get(n);
    }

    public void display()
    {
        System.out.println("Name : " + name );
        System.out.println("Branch : " + branch );
    }

}

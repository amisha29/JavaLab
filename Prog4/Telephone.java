import java.util.*;
import java.text.SimpleDateFormat;

public class IncomingCall{

    String number, name, timestamp;

    IncomingCall(String number)
    {
        this.number = number;
        name = "Private Caller";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        timestamp = sdf.format(date);
    }

    IncomingCall(String number, String name)
    {
        this.number = number;
        this.name = name;
         Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
        timestamp = sdf.format(date);
    }

    public void display()
    {
        System.out.println("Missed Call from " + name + "(" + number + ") at " + timestamp);
    }

    public String getNumber()
    {
        return number;
    }
}

public class CallHistory{

    ArrayList<IncomingCall> callList;

    public CallHistory()
    {
        callList = new ArrayList<>();
    }

    public void add(IncomingCall call)
    {
        if(callList.size() == 10)
            callList.remove(0);
        callList.add(call);
    }

    public void displayDetails(IncomingCall call)
    {
        call.display();
    }

    public int DeleteNum(String num)
    {
        int flag = 0;
        for(IncomingCall call : callList)
        {
            if(call.getNumber().equals(num))
            {
                callList.remove(callList.indexOf(call));
                flag = 1;
                break;
            }
        }
        //If number is not present in list, flag=0 else flag=1
        return flag;
    }


    public void show()
    {
        System.out.println("Missed Calls");
        for(int i = 0; i < callList.size(); i++)
        {
            int ch;
            Scanner sc = new Scanner(System.in);
            IncomingCall call = callList.get(i);
            System.out.println("\nMissed call ");
            System.out.println("Number " + call.getNumber());
            System.out.println("1)Delete the call\n2)GO to next call\n3)Show Details\n4)Delete specific\n5)Exit\nEnter : ");
            ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                    callList.remove(i);
                    System.out.println("Deleted");
                    i--;
                    break;

                case 2:
                    if(i == callList.size()-1)
                        System.out.println("No more calls");
                    break;

                case 3:
                    displayDetails(call);
                    break;

                case 4:
                    System.out.println("Enter number : ");
                    if(DeleteNum(sc.next()) == 1)
                    {
                        System.out.println("Deleted");
                        i--;
                    }
                    else
                        System.out.println("Invalid num");
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }

        System.out.println("Call history\n");
        for(IncomingCall call : callList)
            call.display();
    }

}
public class Telephone{
    
    public static void main(String[] args)
    {
        CallHistory history = new CallHistory();
        String[] names = {"John","Joe","Harry","Potter","William","Gates","Ben","Bob","Margret","Mary","Lupin","Lily"};
        String[] numbers = {"1213","99","8888","656","435332","98989","10101","3243","555","7777","544","454"};
        for(int i = 0; i<12; i++)
        {
            if(i%2==0)
            {
                //System.out.println(numbers.get(i));   
                history.add(new IncomingCall(numbers[i]));
            }
            else
            {
                 history.add(new IncomingCall(numbers[i], names[i]));
            }
        }
       
        history.show();
    }
}
package StudentPackage;
import java.util.*;

class CreditLimitException extends Exception
{
     String err_msg;
    public CreditLimitException()
    {
        err_msg="Cant register for more than 30 creditsr";
    }
    
    public void print_msg()
    {
        System.out.println(err_msg);
    }

}
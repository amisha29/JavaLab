package ResultPackage;
import java.util.*;

class InvalidSgpaException extends Exception
{
     String err_msg;
    public InvalidSgpaException()
    {
        err_msg="SGPA can't be more than 10";
    }
    
    public void print_msg()
    {
        System.out.println(err_msg);
    }

}
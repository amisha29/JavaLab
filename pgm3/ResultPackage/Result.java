package ResultPackage;

import java.util.*;
public class Result{
    private char sub[];
    private float sgpa;
    public Result()
    {
        sub = new char[3];
    }

    public void getGrade()
    {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 3; i++)
        {
            System.out.println("Enter grade for Subject " + (i+1) + " : ");
            sub[i] = sc.next().charAt(0);
        }

        try {
            System.out.println("Enter SGPA : ");
            sgpa = sc.nextFloat();
            if(sgpa > 10)
                throw new InvalidSgpaException();
            else
                System.out.println("SGPA : " + sgpa);
            
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

        catch(InvalidSgpaException e){
            e.print_msg();
        }
        
    }

    public void display()
    {
        System.out.println("Grades : ");
        for(int i = 0; i < 3; i++)
        {
            System.out.println("Subject " + (i+1) + " : " + sub[i] );
        }    
        System.out.println("SGPA : " + sgpa);
    }

    public float getSgpa()
    {
        return sgpa;
    }
}
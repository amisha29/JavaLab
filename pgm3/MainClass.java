import java.util.*;
import StudentPackage.RegisteredStudent;
import ResultPackage.Result;
public class MainClass{

    public static void main(String[] args) {

        int sem, totalCredits = 0;
        float sum = 0;
        RegisteredStudent student = new RegisteredStudent("amis", "ise");
        student.register();
        sem = student.getSemCount();

        ArrayList<Result> finalResult = new ArrayList<>();
        for (int i = 0; i < sem; i++)
        {
            System.out.println("\nSemester " + (i+1));
            Result r = new Result();
            r.getGrade();
            finalResult.add(r);
            totalCredits += student.getCredit(i);
            sum += r.getSgpa() * student.getCredit(i);
        }
        
        System.out.println();
        student.display();
        for (int i = 0; i < sem; i++)
            finalResult.get(i).display();
        System.out.println("CGPA : " + (float)sum/totalCredits);        
    }
}
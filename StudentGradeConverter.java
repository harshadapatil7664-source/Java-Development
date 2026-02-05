//Student Grade Calculator.
import java.util.Scanner;
public class StudentGradeConverter {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int subject;
        System.out.print("Enter the total number of subject:");
        subject=scan.nextInt();

        System.out.println("Enter the Marks.");
        float sum = 0;
        float[] marks=new float[subject];
        for(int i=0;i<subject;i++){
            System.out.print("Marks"+(i+1)+":");
             marks[i]=scan.nextFloat();
            sum = sum + marks[i];
        }
        float average = sum/subject;
        char grade;

        if(average>=90){
            grade = 'A'; 
        }
        else if(average>=75){
            grade= 'B';  
        }
        else if(average>=65){
            grade= 'C';     
        }
        else if(average>=55){
            grade= 'D';  
        }
        else if(average>=45){
            grade= 'E';
        }
        else{
            grade='F';
        }

        System.out.println("-------------RESULT--------------");
         System.out.println("Total Marks: "+sum);
          System.out.println("Percentage: "+average+"%");
           System.out.println("Grade: "+grade);
        if(grade=='A'||grade=='B'||grade=='C'||grade=='D'||grade=='E'){
            System.out.println("PASS!");
        }else
            System.out.println("FAIL!");
           scan.close();
        }
    }
    





        



    



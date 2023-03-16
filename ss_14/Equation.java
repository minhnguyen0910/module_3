package ss_14;

import java.util.Scanner;

public class Equation {
    static void solveTheEquation(double num1, double num2,double num3){
        double delta=num2*num2-4*num1*num3;
        double x1;
        double x2;
        if (delta>0){
            x1 = ((-num2 + Math.sqrt(delta)) / (2*num1));
            x2 = ((-num2 - Math.sqrt(delta)) / (2*num1));
            System.out.println("Phuong trinh co 2 nghiem: " + x1 + "và"  + x2);
        }else if (delta==0){
            x1=x2=-num2/(2*num1);
            System.out.println("Phuong trinh co nghiem kep x1 = x2 = "+x1);
        }else {
            System.out.println("Phuong trinh vo nghiem");
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num1=Integer.parseInt(scanner.nextLine());
        int num2=Integer.parseInt(scanner.nextLine());
        int num3=Integer.parseInt(scanner.nextLine());
        solveTheEquation(num1,num2,num3);
    }

}

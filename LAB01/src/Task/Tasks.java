package Task;

import RunInput.Input;
import RunInput.Los;

public class Tasks {


    Input input = new Input();
   Los los = new Los();

    public String DataUser(){
        return "Jan, 23";

    }
    public void calculator(){
        System.out.println("Podaj pierwsze liczbe:");
        int a= input.InputInt();
        System.out.println("Podaj drugą liczbe:");
        int b= input.InputInt();

        System.out.println("Suma: "+(a+b));
        System.out.println("Roznica: "+(a-b));
        System.out.println("Iloczyn: "+(a*b));

    }
    public boolean even(){
        System.out.println("Podaj liczbe:");
        int a= input.InputInt();
        return a % 2 == 0;
    }
    public boolean divisibility(){
        System.out.println("Podaj liczbe:");
        int a= input.InputInt();
        return a % 3 == 0 && a % 5 == 0;
    }
    public int power(){
        System.out.println("Podaj liczbe:");
        int a=input.InputInt();
        return (int)Math.pow(a,3);
    }
    public int sqrt(){
        System.out.println("Podaj liczbe:");
        int a=input.InputInt();
        return (int)Math.sqrt(a);
    }
    public void triangle(){
        System.out.println("Podaj liczbe:");
        int x=input.InputInt();
        int y=input.InputInt();
        int a,b,c;
        a=los.Losowanie(x,y);
        b=los.Losowanie(x,y);
        c=los.Losowanie(x,y);
        System.out.printf("a wynosi: "+a+"\nb wynosi: "+b+"\nc wynosi: "+c+"\n");
        int temp;
        if (a > b) { temp = a; a = b; b = temp; }
        if (b > c) { temp = b; b = c; c = temp; }
        if (a > b) { temp = a; a = b; b = temp; }
        if (a + b > c) {
            if (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2)) {
                System.out.println("Z podanych boków można zbudować trójkąt prostokątny.");
            } else {
                System.out.println("Trójkąt z podanych boków NIE jest prostokątny.");
            }
        } else {
            System.out.println("Z podanych boków NIE można stworzyć trójkąta.");
        }


    }






}

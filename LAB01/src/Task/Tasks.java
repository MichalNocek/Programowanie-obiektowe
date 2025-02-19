package Task;

import RunInput.Input;

public class Tasks {


    Input input = new Input();

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
    public void even(){
        System.out.println("Podaj liczbe:");
        int a= input.InputInt();
        if(a%2==0){
            System.out.println("Liczba jest parzysta");
        }else{
            System.out.println("Liczba jest nieparzysta");
        }
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

}

package Tasks;

import Input_random.Input;


public class Tasks {

    Input input = new Input();
    public void delta(){
        System.out.println("Podaj po polei a b c   w równaniu ax^2+bx+c=0");
        double a,b,c;

        a=input.Inputint();
        b=input.Inputint();
        c=input.Inputint();
        double delta = (b * b) - 4 * a * c;

        if (delta > 0) {
            double sqrtDelta = Math.sqrt(delta);
            double x1 = (-b - sqrtDelta) / (2 * a);
            double x2 = (-b + sqrtDelta) / (2 * a);
            System.out.println("Dwa pierwiastki: x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0) {
            double x0 = -b / (2 * a);
            System.out.println("Jeden pierwiastek: x0 = " + x0);
        } else {
            System.out.println("Brak rozwiązań w zbiorze liczb rzeczywistych");
        }

    }
    public void funikca_a(){
        int x;
        System.out.println("Podaj argument do funkcji");
        x=input.Inputint();
        if(x>0){
            System.out.println("Wartość funkcji a wynosi"+2*x);
        }
        else if (x==0){
            System.out.println("Wartość funkcji a wynosi "+ 0);
        } else {
            System.out.println("Wartość funkcji a wynosi"+(-3*x));
        }

    }
    public void funikca_b(){
        int x;
        System.out.println("Podaj argument do funkcji");
        x=input.Inputint();
        if(x>=1){
            System.out.println("Wartość funkcji b wynosi"+(x*x));
        }
        else System.out.println("Wartość funkcji b wynosi " + x);
    }
    public void funikca_c(){
        int x;
        System.out.println("Podaj argument do funkcji");
        x=input.Inputint();
        if(x>2){
            System.out.println("Wartość funkcji c wynosi"+(2+x));
        }
        else if (x==2){
            System.out.println("Wartość funkcji c wynosi "+ 8);
        } else {
            System.out.println("Wartość funkcji c wynosi"+(x-4));
        }

    }
    public void pokolei(){
        System.out.println("Podaj 3 lliczby ");
        int a,b,c;
        a=input.Inputint();
        b=input.Inputint();
        c=input.Inputint();
        int temp;
        if (a > b) { temp = a; a = b; b = temp; }
        if (b > c) { temp = b; b = c; c = temp; }
        if (a > b) { temp = a; a = b; b = temp; }
        System.out.println("Po kolei a "+a+" b "+b+" c "+c);

    }



}

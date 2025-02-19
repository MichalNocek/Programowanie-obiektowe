package RunInput;

import Task.Tasks;
public class Run {

    public void RunTask(){
        //obiekt klas
        Tasks tasks = new Tasks();
        Input input = new Input();

        System.out.println("Laboratorium 1\n");
        System.out.println("Zadanie 1");
        System.out.println("Zadanie 2");
        System.out.println("Zadanie 3");
        System.out.println("Zadanie 4");
        System.out.println("Zadanie 5");
        System.out.println("Zadanie 6");
        System.out.println("Zadanie 7");
        System.out.println("Wybierz zadananie:");

        int wybor = input.InputInt();
        switch (wybor){
            case 1:
                System.out.println(tasks.DataUser()); break;
            case 2:
                tasks.calculator(); break;
                case 3:
                    tasks.even(); break;
                case 4:
                    System.out.printf(String.valueOf(tasks.divisibility()));break;
                case 5:
                    System.out.println("Potega 3 stopnia wynosi"+tasks.power()); break;
                case 6:
                    System.out.println("Pierwiastek liczby wynosi"+tasks.sqrt()); break;

            default: System.out.println("Nie ma takiego zadania");

        }
    }

}

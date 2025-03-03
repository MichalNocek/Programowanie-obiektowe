package run_input;


import Tasks.Taksk;

public class Run {

    public void RunTask() {
        //obiekt klas

        Input input = new Input();
        Taksk task = new Taksk();
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
        switch (wybor) {
            case 1:
                    task.zad1();
                break;
            case 2:
                    task.zad2();
                break;
            case 3:
                    task.zad3();
                break;
            case 4:
                    task.zad4();
                break;
            case 5:
                    task.zad5();
                break;
            default:
                System.out.println("Nie ma takiego zadania");

        }
    }

}

package Input_random;


import Tasks.Tasks;

public class Run {
    Input input = new Input();


    public void RunTask() {


        Tasks tasks = new Tasks();
        System.out.println("Laboratorium 1\n");
        System.out.println("Zadanie 1");
        System.out.println("Zadanie 2");
        System.out.println("Zadanie 3");
        System.out.println("Zadanie 4");
        System.out.println("Zadanie 5");
        System.out.println("Zadanie 6");
        System.out.println("Zadanie 7");
        System.out.println("Wybierz zadananie:");

        int wybor = input.Inputint();
        switch (wybor) {
            case 1:
                    tasks.delta();
                break;
            case 2:
                   tasks.funikca_a();
                   tasks.funikca_b();
                   tasks.funikca_c();
                break;
            case 3:
                    tasks.pokolei();
                break;
            case 4:

                break;
            case 5:

                break;
            default:
                System.out.println("Nie ma takiego zadania");

        }
    }

}

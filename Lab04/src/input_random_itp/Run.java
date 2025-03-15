package input_random_itp;



public class Run {

    public void RunTask() {
        //obiekt klas

        Input input = new Input();
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

        int wybor = input.InputInt();
        switch (wybor) {
            case 1:
                tasks.task1();
                break;
            case 2:
                tasks.task2();
                break;
            case 3:
                tasks.task3();
                break;
            case 4:
                tasks.task4();
                break;
            case 5:
                tasks.task5();
                break;
                case 6:
                    tasks.task6();
                    break;
                    case 7:
                        tasks.task7();
                        break;
            default:
                System.out.println("Nie ma takiego zadania");

        }
    }

}

public class Osoba {
    //pola
    String firstName, lastName;
    int age;
    String nr_albumu,kierunek;
    //metody
    public void View(){
        System.out.println("Imie: "+firstName+" Nazwisko "+lastName+"Kierunek studiów: "+kierunek+" Nr Albumu "+nr_albumu);
    }

    public  String PersonData(){
        return "Witaj "+firstName+" "+lastName + "Twój wiek to: "+ age;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNr_albumu() {
        return nr_albumu;
    }

    public void setNr_albumu(String nr_albumu) {
        this.nr_albumu = nr_albumu;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    //konstruktor


    public Osoba (String lastName, String firstName, int age, String kierunek, String nr_albumu) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.kierunek = kierunek;
        this.nr_albumu = nr_albumu;
    }


}

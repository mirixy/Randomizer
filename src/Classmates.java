public class Classmates {
    int count = 0;
    public String[] names = {
            "Antonia",
            "Janick",
            "Jill",
            "Jonas",
            "Julia",
            "Laszlo",
            "Lea",
            "Leon",
            "Marie",
            "Matthias",
            "Miriam",
            "Nadine",
            "Niklas",
            "Sozyar",
            "Svenja",
            "Tobias"
    };
    Classmates() {
        for(String name : names){
            System.out.println(name);
            count ++;
        }


    }

}

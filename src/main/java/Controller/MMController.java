package Controller;

public class MMController {
    public static void main(String[] args) {
        System.out.println(calculate(2, 2, 2, 2));
    }
    // Game nr 1  int resultA = 1, int resultB = 1  Mari123 int quessA = 2, int quessB = 3


    public static int calculate(int resultA, int resultB, int quessA, int quessB) {
        int points = 0;
        if (resultA == quessA && resultB == quessB) {       //kui on täpne skoor
            System.out.println("BINGO! Täpne skoor");
            points = points + 2;
        } else if (resultA > resultB && quessA > quessB) {  //kui kodumeeskond võidab
            points = points + 1;
        } else if (resultA < resultB && quessA < quessB) {  //kui võõrsilmeeskond võidab
            points = points + 1;
        } else if (resultA - resultB == quessA - quessB) {  //kui on viik
            points = points + 1;
        } else {
        }
        return points;
    }
}
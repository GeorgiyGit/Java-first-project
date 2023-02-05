import java.util.Random;

public class NameGenerator {
    private static String[] fNameDataSet=new String[]{
            "William",
            "CharlesJames",
            "George",
            "Frank",
            "Joseph",
            "Thomas",
            "Henry",
            "Robert",
            "Edward",
            "Harry",
            "Walter",
            "Arthur",
            "Fred",
            "Albert",
            "Samuel",
            "David",
            "Louis",
            "Joe",
            "Charlie"
    };
    private static Random random = new Random();
    public static String getRandomName(){
        return fNameDataSet[random.nextInt(fNameDataSet.length)];
    }






}

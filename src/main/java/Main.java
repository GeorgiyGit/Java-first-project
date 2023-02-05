import dto.CategoryInsert;
import services.CategoryItem;
import services.CategoryService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// s - прокрутити меню вниз на один елемент
// w - прокрутити меню вверх на один елемент
// e - ентер, виконати понкт меню
public class Main {
    public static void main(String[] args) throws IOException {
        String con="jdbc:mariadb://localhost:3306/java-app";
        String user="root";
        String password="";
        CategoryService categoryService = new CategoryService(con,user,password);
        //categoryService.insert(new CategoryInsert("Bronze"));
        Scanner input = new Scanner(System.in);
        while(true){
            int n=0;
            while (true) {
                if (n == 0) System.out.print(ConsoleColors.RED);
                else System.out.print(ConsoleColors.WHITE);
                System.out.println("[1]. Get All");

                if (n == 1) System.out.print(ConsoleColors.RED);
                else System.out.print(ConsoleColors.WHITE);
                System.out.println("[2]. Insert");

                if (n == 2) System.out.print(ConsoleColors.RED);
                else System.out.print(ConsoleColors.WHITE);
                System.out.println("[3]. Update");

                if (n == 3) System.out.print(ConsoleColors.RED);
                else System.out.print(ConsoleColors.WHITE);
                System.out.println("[4]. Remove");
                if (n == 3) System.out.print(ConsoleColors.WHITE);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                char symbol= input.next().charAt(0);

                if (symbol == 's') {
                    if (n == 3) n = 0;
                    else n++;
                }
                else if (symbol == 'w') {
                    if (n == 0) n = 3;
                    else n--;
                }
                else if(symbol=='e'){
                    break;
                }
            }
            switch (n){
                case 0:
                    printCategories(categoryService);
                    break;
                case 1:
                    System.out.println("Enter name ==>");
                    String name = input.next();
                    categoryService.insert(new CategoryInsert(name));
                    break;
                case 2:
                    printCategories(categoryService);

                    System.out.println("Enter id ==>");
                    String id = input.next();

                    System.out.println("Enter new Name ==>");
                    String newName = input.next();

                    categoryService.update(new CategoryItem(Integer.parseInt(id),newName));
                    break;
                case 3:
                    printCategories(categoryService);
                    System.out.println("Enter id ==>");
                    String id2 = input.next();
                    categoryService.remove(Integer.parseInt(id2));
                    break;
            }
            System.in.read();
        }


    }
    public static void printCategories(CategoryService categoryService){
        List<CategoryItem> categories = categoryService.getAll();
        for(int i=0;i<categories.size();i++){
            System.out.println(categories.get(i).toString());
        }
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private static void personsAction(){
        Random r = new Random();

        List<Person> persons = new ArrayList<Person>();
        for(int i=0;i<10;i++) {
            persons.add(new Person(NameGenerator.getRandomName(), NameGenerator.getRandomName()));
        }

        printPersons(persons);
        Collections.sort(persons);
        System.out.println();
        printPersons(persons);
    }
    private static void printPersons(List<Person> p){
        for(int i=0;i<p.size();i++)System.out.println(i+" " +p.get(i).toString());
    }

    private static String getRandomStr(int length) {
        return UUID.randomUUID()
                .toString()
                .substring(0, length);
    }
    private static int getRandomNumber(int left, int right) {
        Random r = new Random();
        return r.nextInt(left, right);
    }

    private static int getPlusElementsCount(int[] arr) {
        int plusCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) plusCount++;
        }
        return plusCount;
    }
}

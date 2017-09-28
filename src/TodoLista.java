import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TodoLista {

    public TodoLista() {
    }

    public void listTask() {
        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.nextLine();
        if (input.endsWith("l")) {
            try {
                Path myPath = Paths.get( "/Users/lica/GreenFox/dzlica-todo-app/todolist.txt");
                List<String> lines = Files.readAllLines(myPath);
                int count = 0;
                for (int i = 0; i < lines.size(); i++) {
                    count++;
                    System.out.println(count + " - " + lines.get(i));

                }

            } catch (Exception e) {
                System.out.println("Unable to read the file!");
            }
        }
    }


}

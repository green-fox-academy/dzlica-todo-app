import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoLista {
    Scanner myScanner = new Scanner(System.in);
    String input;
    ArrayList<String> lines;

    public TodoLista() {

        this.input = myScanner.nextLine();
        this.lines = new ArrayList<>();

    }

    public void listTask() {

        if (this.input.endsWith("l")) {
            try {
                Path myPath = Paths.get("/Users/lica/GreenFox/dzlica-todo-app/todolist.txt");
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

    public void newTask() {
        if (this.input.endsWith("-a")) {
            System.out.println("Unable to add: no task provided");
        }
        if (this.input.startsWith("-a")) {
            try {
                Path myPath = Paths.get("/Users/lica/GreenFox/dzlica-todo-app/todolist.txt");
                List<String> lines = Files.readAllLines(myPath);
                lines.add(this.input.substring(3));
                Files.write(myPath, lines);

            } catch (Exception e) {
                //System.out.println("Unable to read the file!");
            }
        }


    }


    public void emptyList() {
        if (input.endsWith("l")) {
            try {
                Path myPath = Paths.get("/Users/lica/GreenFox/dzlica-todo-app/todolist.txt");
                List<String> lines = Files.readAllLines(myPath);
                if (lines.size() == 0) {
                    System.out.println("No todos for today");
                }

            } catch (Exception e) {
                System.out.println("Unable to read the file!");
            }
        }


    }

    public void removeTask() {
        try {
            Path myPath = Paths.get("/Users/lica/GreenFox/dzlica-todo-app/todolist.txt");
            List<String> lines = Files.readAllLines(myPath);
            if (1 <= lines.size() && input.startsWith("-r")) {
                String toNumber = input.substring(3);
                int result = Integer.parseInt(toNumber);
                lines.remove(result - 1);
                Files.write(myPath, lines);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


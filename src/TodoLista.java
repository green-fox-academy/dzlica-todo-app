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

        if (this.input.endsWith("-l")) {
            try {
                Path myPath = Paths.get("/Users/lica/GreenFox/dzlica-todo-app/todolist.txt");
                List<String> lines = Files.readAllLines(myPath);
                if (lines.size() == 0) {
                    System.out.println("No todos for today");
                    return;
                }
                int count = 1;
                for (int i = 0; i < lines.size(); i++) {
                    if ((lines.get(i).charAt(0) == '+')) {
                        System.out.println(count + " - [x] " + lines.get(i).substring(1));
                    }
                    else System.out.println(count + " - [ ] " + lines.get(i).substring(1));
                    count++;
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
                lines.add("-" + this.input.substring(3));
                Files.write(myPath, lines);

            } catch (Exception e) {
                System.out.println("Unable to read the file!");
            }
        }


    }


    public void removeTask() {
        try {
            Path myPath = Paths.get("/Users/lica/GreenFox/dzlica-todo-app/todolist.txt");
            List<String> lines = Files.readAllLines(myPath);
            if (this.input.endsWith("-r")) {
                System.out.println("Unable to remove: no index provided");
            }
            if (1 <= lines.size() && this.input.startsWith("-r")) {
                String toNumber = this.input.substring(3);
                try {
                    int result = Integer.parseInt(toNumber);
                    if (result > lines.size()) {
                        System.out.println("Unable to remove: index is out of bound");
                    }
                    else lines.remove(result - 1);
                    Files.write(myPath, lines);
                }
                catch (NumberFormatException e){
                    System.out.println("Unable to remove: index is not a number");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkTask() {
        try {
            Path myPath = Paths.get("/Users/lica/GreenFox/dzlica-todo-app/todolist.txt");
            List<String> lines = Files.readAllLines(myPath);
            if (1 <= lines.size() && this.input.startsWith("-c")) {
                String toNumber = this.input.substring(3);
                int result = Integer.parseInt(toNumber);
                lines.set(result, "+" + lines.get(result).substring(1));
                Files.write(myPath, lines);
            }

        } catch(Exception e){

             }
        }


    public void argumentError() {
        if (!(input.contains("-r") || input.contains("-a") || input.contains("-l") || input.contains("-c"))) {
            System.out.println("Unsupported argument");
            try {
                Path myPath = Paths.get( "/Users/lica/GreenFox/dzlica-todo-app/printusage.txt");
                List<String> lines = Files.readAllLines(myPath);
                for (int i = 0; i < lines.size(); i++) {
                    System.out.println(lines.get(i));
                }
            } catch (Exception e) {
                System.out.println("Unable to read the file!");
            }
            System.out.println("\n");
        }
    }


}


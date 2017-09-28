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
    String [] args;


    public TodoLista() {

        this.input = myScanner.nextLine();
        this.args = new String[2];
        this.args[0] = this.input.substring(0,2);
        if (this.input.length() > 2) {
            this.args[1] = this.input.substring(3);
        }
        else this.args[1] = "";

        this.lines = new ArrayList<>();

    }

    public TodoLista(String[] args) {
        this.args = args;
        this.lines = new ArrayList<>();
    }

    public void listTask() {

        if (this.args[0].equals("-l")) {
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

        if (this.args[0].equals("-a")) {
            if (this.args[1] == null || this.args[1].equals("")) {
                System.out.println("Unable to add: no task provided");
                return;
            }
            try {
                Path myPath = Paths.get("/Users/lica/GreenFox/dzlica-todo-app/todolist.txt");
                List<String> lines = Files.readAllLines(myPath);
                lines.add("-" + this.args[1]);
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
            if (this.args[0].equals("-r")) {
                if (this.args[1] == null || this.args[1].equals(""))
                    System.out.println("Unable to remove: no index provided");

                if (1 <= lines.size()) {
                    String toNumber = this.args[1];
                    try {
                        int result = Integer.parseInt(toNumber);
                        if (result > lines.size()) {
                            System.out.println("Unable to remove: index is out of bound");
                        } else lines.remove(result - 1);
                        Files.write(myPath, lines);
                    } catch (NumberFormatException e) {
                        System.out.println("Unable to remove: index is not a number");
                    }
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
            if (1 <= lines.size() && this.args[0].equals("-c")) {
                String toNumber = this.args[1];
                int result = Integer.parseInt(toNumber);
                lines.set(result, "+" + lines.get(result).substring(1));
                Files.write(myPath, lines);
            }

        } catch(Exception e){

             }
        }


    public void argumentError() {
        if (!(this.args[0].equals("-r") || this.args[0].equals("-a") || this.args[0].equals("-l") || this.args[0].equals("-c"))) {
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


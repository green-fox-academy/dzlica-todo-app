import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TodoApp {
    public static void main(String [] args) {


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
        TodoLista elsoTodo = new TodoLista();

        elsoTodo.listTask();
        elsoTodo.newTask();
        elsoTodo.emptyList();

    }
}


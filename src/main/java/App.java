import entity.Task;
import entity.TaskBuilder;
import entity.TaskList;
import ui.Homepage;
import ui.ListPage;
import ui.Page;
import ui.TaskPage;

import java.util.ArrayList;
import java.util.List;

/**
 * The entry point of the class
 */
public class App {
    public static void main(String[] args) {
        Page task = new TaskPage(new TaskBuilder().setTitle("Task FuckYourSelf").setDescription("Do someeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeething").createTask());
        task.display();
    }
}


package ui;

import entity.Detail;
import entity.Task;
import entity.TaskList;
import utilities.ConsoleIO;

import java.util.List;

public abstract class Page {
    protected String content;

    public void display() {
        System.out.println(content);
    }

    private void clear() {
        System.out.println(ConsoleColors.CLEAR);
    }

    public String prompt() {
        return ConsoleIO.readLine(">> ");
    }

    protected abstract void configureContent();

    protected abstract void updateContent();

    public void refresh() {
        clear();
        display();
    }

    protected String getContent() {
        return content;
    }

    protected <E> String showMenu(String headline, String empty, List<E> items) {
        StringBuilder menu = new StringBuilder("\t" + empty);
        if (items != null && !items.isEmpty()) {
            menu.setLength(0);
            for (int i = 0, size = items.size(); i < size; i++) {
                E e = items.get(i);
                menu.append("\t");
                if (e instanceof Task task)
                    menu.append(i + 1).append(". ").append(task.getTitle());
                else if (e instanceof TaskList taskList)
                    menu.append(i + 1).append(". ").append(taskList.getTitle());
                else if (e instanceof Detail detail) {
                    menu.append("- ").append(detail.getKey()).append(": ").append(detail.getValue());
                }
                menu.append(System.lineSeparator());
            }
        }
        return """
                %s%s:%s
                %s%s%s
                                           
                                
                """.formatted(ConsoleColors.BLUE_BOLD, headline, ConsoleColors.RESET, ConsoleColors.WHITE_BOLD, menu, ConsoleColors.RESET);
    }

}

package ui;

import entity.Detail;
import entity.Task;
import entity.TaskList;

import java.util.List;

public abstract class Page {
    protected String content;

    public void display() {
        System.out.println(content);
    }

    public void clear() {
        System.out.println(ConsoleColors.CLEAR);
    }

    public abstract String prompt();

    protected abstract void configureContent();

    protected abstract void updateContent();

    public void refresh() {
        clear();
        display();
    }

    protected String getContent() {
        return content;
    }

    protected <E> String showMenu(String headline, String empty, List<E> items, String style) {
        StringBuilder menu = new StringBuilder("\t" + empty);
        if (!items.isEmpty()) {
            menu.setLength(0);
            for (int i = 0, size = items.size(); i < size; i++) {
                E e = items.get(i);
                menu.append("\t");
                if (e instanceof Task)
                    menu.append(i + 1).append(". ").append(((Task) e).getTitle());
                else if (e instanceof TaskList)
                    menu.append(i + 1).append(". ").append(((TaskList) e).getTitle());
                else if (e instanceof Detail)
                    menu.append("- ").append(((Detail) e).getKey()).append(": ").append(((Detail) e).getValue());

            }
        }
        return """
                %s%s:%s
                %s%s%s
                
                
                
                """.formatted(ConsoleColors.BLUE_BOLD, headline, ConsoleColors.RESET, style, menu, ConsoleColors.RESET);
    }

}

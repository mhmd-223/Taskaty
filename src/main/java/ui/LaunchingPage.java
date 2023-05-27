package ui;

public class LaunchingPage extends Page {

    public LaunchingPage() {
        configureContent();
    }


    @Override
    protected void configureContent() {
        content = """
                %sWelcome to Taskaty!%s

                %sTaskaty is a powerful tool designed to help you stay organized, accomplish your goals, and make the most of your time.

                With Taskaty, you can manage your tasks, projects, and deadlines effortlessly. Stay on top of your to-do lists, track your progress, and celebrate your achievements along the way.

                To get started, please choose one of the following options:
                    - To log in, type: login <username>
                    - To register a new account, type: newuser <name> <username>

                Thank you for choosing Taskaty. Let's embark on this productivity journey together and make every day count!
                                              
                - The Taskaty Team%s
                """.formatted(ConsoleColors.BLUE_BOLD, ConsoleColors.RESET, ConsoleColors.CYAN_BOLD, ConsoleColors.RESET);
    }

}

package family_tree.view;

import family_tree.view.commands.*;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    List<Command>commands;

    public MainMenu(ConsoleUI consoleUI) {
       commands = new ArrayList<>();

       commands.add(new AddPerson(consoleUI));
       commands.add(new AddParent(consoleUI));
       commands.add(new AddMarriage(consoleUI));
       commands.add(new SortByName(consoleUI));
       commands.add(new GetList(consoleUI));
       commands.add(new SavingToFile(consoleUI));
       commands.add(new OpenFile(consoleUI));
       commands.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commands.get(choice - 1);
        command.execute();
    }
}

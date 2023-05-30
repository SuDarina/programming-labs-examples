package org.itmo.labs.commandsArchitecture;

import org.itmo.labs.commandsArchitecture.commands.RemoveByIdCommand;
import org.itmo.labs.commandsArchitecture.commands.ShowCommand;
import org.itmo.labs.model.MusicBand;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Invoker {
    private TreeMap<Long, MusicBand> musicBands;
    private Map<String, Command> commands = new HashMap<>();;

    public Invoker(TreeMap<Long, MusicBand> musicBands) {
        this.musicBands = musicBands;
        commands.putAll(getAllCommands().stream().collect(Collectors.toMap(Command::getName, Function.identity())));
    }

    private List<Command> getAllCommands() {
        return List.of(new ShowCommand(),
                new RemoveByIdCommand());
    }

    public String invoke(String name, String param) {
        Command command = commands.get(name);
        if(command.getType() == CommandType.COMMAND_WITH_PARAMS) {
            ((CommandWithParam)command).setParam(param);
        }
        return command.execute(musicBands);
    }
}

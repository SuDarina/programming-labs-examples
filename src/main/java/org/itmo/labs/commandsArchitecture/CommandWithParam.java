package org.itmo.labs.commandsArchitecture;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.labs.model.MusicBand;

import java.util.TreeMap;

@AllArgsConstructor
@NoArgsConstructor
public abstract class CommandWithParam<T> implements Command {

    private T param;

    public abstract void setParam(String param);


    @Override
    public abstract String execute(TreeMap<Long, MusicBand> musicBands);

    @Override
    public CommandType getType() {
        return CommandType.COMMAND_WITH_PARAMS;
    }

    @Override
    public abstract String getName();
}

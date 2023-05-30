package org.itmo.labs.commandsArchitecture.commands;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.itmo.labs.commandsArchitecture.CommandWithParam;
import org.itmo.labs.model.MusicBand;

import java.util.TreeMap;

@NoArgsConstructor
public class RemoveByIdCommand extends CommandWithParam<Long> {

    @Setter
    private Long param;

    public RemoveByIdCommand(String param) {
        super(Long.parseLong(param));
        this.param = Long.parseLong(param);
    }

    @Override
    public void setParam(String param) {
        this.param = Long.parseLong(param);
    }


    @Override
    public String execute(TreeMap<Long, MusicBand> musicBands) {
        musicBands.remove(param);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("element with id = %d removed!\nCollection:\n", param));
        ShowCommand show = new ShowCommand();
        sb.append(show.execute(musicBands));
        return sb.toString();
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }

}

package com.rit.sucy.scoreboard;

import com.rit.sucy.commands.CommandHandler;
import com.rit.sucy.commands.ICommand;
import com.rit.sucy.commands.SenderType;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Makes a player's scoreboard start cycling
 */
public class CycleCommand implements ICommand
{

    /**
     * Executes the command
     *
     * @param handler command handler
     * @param plugin  plugin reference
     * @param sender  sender of the command
     * @param args    command arguments
     */
    @Override
    public void execute(CommandHandler handler, Plugin plugin, CommandSender sender, String[] args)
    {
        if (sender instanceof Player)
        {
            PlayerBoards board = BoardManager.getPlayerBoards(sender.getName());
            if (board.isCycling())
                sender.sendMessage(ChatColor.DARK_RED + "Your scoreboard is already cycling");
            else
            {
                board.startCycling();
                sender.sendMessage(ChatColor.DARK_GREEN + "Your scoreboard is now cycling");
            }
        }
        else handler.displayUsage(sender);
    }

    /**
     * @return permission needed for this command
     */
    @Override
    public String getPermissionNode()
    {
        return ScoreboardNodes.CYCLE.getNode();
    }

    /**
     * @return args string
     */
    @Override
    public String getArgsString()
    {
        return "";
    }

    /**
     * @return description
     */
    @Override
    public String getDescription()
    {
        return "Makes the scoreboard cycle";
    }

    /**
     * Sender required for the command
     */
    @Override
    public SenderType getSenderType()
    {
        return SenderType.PLAYER_ONLY;
    }
}

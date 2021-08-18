package com.github.nearata.examplepaperacf.command;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.nearata.examplepaperacf.ExamplePaperAcf;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.ShowCommandHelp;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Dependency;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.HelpCommand;
import co.aikar.commands.annotation.Optional;
import co.aikar.commands.annotation.Subcommand;
import co.aikar.commands.annotation.Syntax;

@CommandAlias("examplepaperacf")
public final class ExamplePaperAcfCommand extends BaseCommand
{
    @Dependency
    private ExamplePaperAcf plugin;

    @Default
    @HelpCommand
    public void showHelp(CommandSender sender)
    {
        throw new ShowCommandHelp(false);
    }

    @Subcommand("hello")
    @Description("The plugin greets you.")
    @CommandPermission("examplepaperacf.command.hello")
    @CommandCompletion("@players")
    @Syntax("<player>")
    public void helloCommand(CommandSender sender, @Optional String playername)
    {
        if (playername == null)
        {
            sender.sendMessage("Hello " + sender.getName());
        }
        else
        {
            final Player player = this.plugin.getServer().getPlayer(playername);

            if (player == null)
            {
                sender.sendMessage("The player " + playername + " is offline");
                return;
            }

            player.sendMessage("Hello from " + sender.getName());
        }
    }
}

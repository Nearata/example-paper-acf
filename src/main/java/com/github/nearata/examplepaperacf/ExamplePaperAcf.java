package com.github.nearata.examplepaperacf;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.nearata.examplepaperacf.command.ExamplePaperAcfCommand;

import co.aikar.commands.PaperCommandManager;

public final class ExamplePaperAcf extends JavaPlugin
{
    private static ExamplePaperAcf instance;
    private PaperCommandManager commandManager;

    @Override
    public void onEnable()
    {
        instance = this;

        this.commandManager = new PaperCommandManager(this);

        this.commandManager.enableUnstableAPI("brigadier");
        this.commandManager.enableUnstableAPI("help");

        this.commandManager.registerCommand(new ExamplePaperAcfCommand());
    }

    @Override
    public void onDisable()
    {
    }

    public static ExamplePaperAcf getInstance()
    {
        return instance;
    }

    public PaperCommandManager getCommandManager()
    {
        return this.commandManager;
    }
}

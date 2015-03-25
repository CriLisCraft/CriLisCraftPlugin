package com.criliscraft.plugin;

import com.criliscraft.plugin.commands.*;
import com.criliscraft.plugin.listeners.BlockListener;
import com.criliscraft.plugin.listeners.PartyListener;
import com.criliscraft.plugin.listeners.PlayerListener;
import com.criliscraft.plugin.party.Party;
import com.criliscraft.plugin.util.Perms;
import com.rit.sucy.commands.ConfigurableCommand;
import com.rit.sucy.commands.SenderType;
import com.rit.sucy.config.Config;
import com.rit.sucy.config.CustomFilter;
import com.rit.sucy.config.FilterType;
import com.rit.sucy.config.LanguageConfig;
import com.rit.sucy.scoreboard.UpdateTask;
import com.sun.java.swing.plaf.windows.TMSchema;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CriLisCraft extends JavaPlugin {

    private ArrayList<Party> parties = new ArrayList();
    private ArrayList<String> toggled = new ArrayList();
    private LanguageConfig language;
    private UpdateTask task;
    private boolean removeOnDc;
    private boolean newLeaderOnDc;
    private boolean leaderInviteOnly;
    private boolean useScoreboard;
    private boolean levelScoreboard;
    private double memberModifier;
    private double levelModifier;
    private long inviteTimeout;
    private int maxSize;

    @Override
    public void onEnable() {
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            e.printStackTrace();
            getLogger().severe("Failed To Submit Metrics");
        }

        this.task = new UpdateTask(this);

        saveDefaultConfig();
        Config.trim(getConfig());
        Config.setDefaults(getConfig());
        saveConfig();
        this.language = new LanguageConfig(this, "language");

        this.removeOnDc = getConfig().getBoolean("remove-on-dc");
        this.newLeaderOnDc = getConfig().getBoolean("new-leader-on-dc");
        this.leaderInviteOnly = getConfig().getBoolean("only-leader-invites");
        this.useScoreboard = getConfig().getBoolean("use-scoreboard");
        this.levelScoreboard = getConfig().getBoolean("level-scoreboard");
        this.memberModifier = getConfig().getDouble("exp-modifications.members");
        this.levelModifier = getConfig().getDouble("exp-modifications.level");
        this.inviteTimeout = (getConfig().getInt("invite-timeout") * 1000L);
        this.maxSize = getConfig().getInt("max-size");

        new PlayerListener(this);
        new BlockListener(this);
        new PartyListener(this);
        //new EntityListener(this);

        ConfigurableCommand root = new ConfigurableCommand(this, "pt", SenderType.ANYONE);
        root.addSubCommands(new ConfigurableCommand[] { new ConfigurableCommand(this, "accept", SenderType.PLAYER_ONLY, new CmdAccept(), "Accepts a party request", "", "party.general"),
                new ConfigurableCommand(this, "decline", SenderType.PLAYER_ONLY, new CmdDecline(), "Declines a party request", "", "party.general"),
                new ConfigurableCommand(this, "info", SenderType.PLAYER_ONLY, new CmdInfo(), "Views party information", "", "party.general"),
                new ConfigurableCommand(this, "invite", SenderType.PLAYER_ONLY, new CmdInvite(), "Invites a player to a party", "<player>", "party.general"),
                new ConfigurableCommand(this, "leave", SenderType.PLAYER_ONLY, new CmdLeave(), "Leaves your party", "", "party.general"),
                new ConfigurableCommand(this, "message", SenderType.PLAYER_ONLY, new CmdMsg(), "Sends a message to your party", "<message>", "party.general"),
                new ConfigurableCommand(this, "toggle", SenderType.PLAYER_ONLY, new CmdToggle(), "Toggles party chat on/off", "", "party.general") });

        PluginManager pm = getServer().getPluginManager();
        pm.addPermission(Perms.clcHat);
        pm.addPermission(Perms.clcPlaceTnt);
        pm.addPermission(Perms.clcRandom);
        pm.addPermission(Perms.clcCreativeOnJoin);
        pm.addPermission(Perms.clcReload);
        pm.addPermission(Perms.clcWellfare);
        pm.addPermission(Perms.clcHelp);
        pm.addPermission(Perms.clcBuy);
        pm.addPermission(Perms.clcKit);
        pm.addPermission(Perms.clcKitChaka);
        pm.addPermission(Perms.clcKitList);
        pm.addPermission(Perms.clcKitLegeis);
        pm.addPermission(Perms.clcKitStaff);
        pm.addPermission(Perms.clcKitTier1);
        pm.addPermission(Perms.clcKitTier2);
        pm.addPermission(Perms.clcKitTier3);
        pm.addPermission(Perms.clcKitTier4);
        pm.addPermission(Perms.clcKitTier5);
        pm.addPermission(Perms.clcMetaItem);
        pm.addPermission(Perms.clcDie);

        //Commands
        this.getCommand("clc").setExecutor(new CLC(this));
        this.getCommand("hat").setExecutor(new Hat(this));
        this.getCommand("random").setExecutor(new Random(this));
        this.getCommand("kit").setExecutor(new Kit(this));
        this.getCommand("buy").setExecutor(new Buy(this));
        this.getCommand("metaitem").setExecutor(new MetaItem(this));
        this.getCommand("die").setExecutor(new Die(this));
        this.getCommand("titletest").setExecutor(new TitleTest(this));
        this.getCommand("ci").setExecutor(new ClearInv(this));
        this.getCommand("stopannounce").setExecutor(new StopAnnounce(this));

        saveConfig();

        getLogger().info("Enabled");
    }
    @Override
    public void onDisable() {
        saveConfig();
        this.task.cancel();
        if (isUseScoreboard()) {
            PartyBoardManager.clearBoards(this);
        }
        HandlerList.unregisterAll(this);
        this.parties.clear();
        getLogger().info("Disabled");
    }
    public boolean isRemoveOnDc() {
        return this.removeOnDc;
    }
    public boolean isNewLeaderOnDc() {
        return this.newLeaderOnDc;
    }
    public boolean isLeaderInviteOnly() {
        return this.isLeaderInviteOnly();
    }
    public boolean isUseScoreboard() {
        return this.useScoreboard;
    }
    public boolean isLevelScoreboard() {
        return this.levelScoreboard;
    }
    public long getInviteTimeout() {
        return this.inviteTimeout;
    }
    public int getMaxSize() {
        return this.maxSize;
    }
    public double getMemberModifier() {
        return this.memberModifier;
    }
    public double getLevelModifier() {
        return this.levelModifier();
    }
    public Party getParty(Player player) {
        for (Party party : this.parties) {
            if ((party.isMember(player)) || party.isInvited(player)) {
                return party;
            }
        }
        return null;
    }
    public void addParty(Party party) {
        this.parties.add(party);
    }
    public void removeParty(Party party) {
        this.parties.remove(party);
    }
    public void update() {
        for (Party party : this.parties) {
            party.checkInvitations();
        }
    }
    public boolean isToggled(String playerName) {
        return this.toggled.contains(playerName.toLowerCase());
    }
    public void toggle(String playerName) {
        if(isToggled(playerName)) {
            this.toggled.remove(playerName.toLowerCase());
        } else {
            this.toggled.add(playerName.toLowerCase());
        }
    }
    public List<String> getMessage(String key, boolean player, CustomFilter... filters) {
        return this.language.getMessage(key, player, FilterType.COLOR, filters);
    }
    public void sendMessage(Player target, String key, CustomFilter... filters) {
        this.language.sendMessage(key, target, FilterType.COLOR, filters);
    }
}

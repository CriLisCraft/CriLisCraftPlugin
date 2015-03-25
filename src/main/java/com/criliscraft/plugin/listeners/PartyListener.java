package com.criliscraft.plugin.listeners;

import com.criliscraft.plugin.CriLisCraft;
import com.criliscraft.plugin.party.Party;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PartyListener implements Listener {
    private CriLisCraft plugin;
    private boolean shared = false;

    public PartyListener(CriLisCraft plugin)
    {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event)
    {
        if ((event.getEntity() instanceof Player))
        {
            Player target = (Player)event.getEntity();


            Player attacker = null;
            if ((event.getDamager() instanceof Player))
            {
                attacker = (Player)event.getDamager();
            }
            else if ((event.getDamager() instanceof Projectile))
            {
                Projectile projectile = (Projectile)event.getDamager();
                if ((projectile.getShooter() != null) && ((projectile.getShooter() instanceof Player))) {
                    attacker = (Player)projectile.getShooter();
                }
            }
            if (attacker != null)
            {
                Party targetParty = this.plugin.getParty(target);
                Party attackerParty = this.plugin.getParty(attacker);
                if ((targetParty != null) && (targetParty == attackerParty) && (targetParty.isMember(target)) && (attackerParty.isMember(attacker))) {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event)
    {
        if (this.plugin.isToggled(event.getPlayer().getName()))
        {
            Party party = this.plugin.getParty(event.getPlayer());
            if ((party == null) || (party.isEmpty()))
            {
                this.plugin.toggle(event.getPlayer().getName());
                return;
            }
            event.setCancelled(true);
            this.plugin.getParty(event.getPlayer()).sendMessage(event.getPlayer(), event.getMessage());
        }
    }

    @EventHandler
    public void onExpGain(PlayerExperienceGainEvent event)
    {
        if (this.shared) {
            return;
        }
        Party party = this.plugin.getParty(event.getPlayerData().getPlayer());
        if (party != null)
        {
            event.setCancelled(true);
            this.shared = true;
            party.giveExp(event.getPlayerData().getPlayer(), event.getExp(), event.getSource());
            this.shared = false;
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        Party party = this.plugin.getParty(event.getPlayer());
        if ((this.plugin.isUsingScoreboard()) && (party != null) && (!party.isEmpty())) {
            PartyBoardManager.applyBoard(this.plugin, event.getPlayer());
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        Party party = this.plugin.getParty(event.getPlayer());
        if (party != null)
        {
            if (party.isInvited(event.getPlayer())) {
                party.decline(event.getPlayer());
            } else if (this.plugin.isRemoveOnDc()) {
                party.removeMember(event.getPlayer());
            } else if (this.plugin.isNewLeaderOnDc()) {
                party.changeLeader();
            }
            if (party.getOnlinePartySize() == 0) {
                this.plugin.removeParty(party);
            }
        }
    }
}

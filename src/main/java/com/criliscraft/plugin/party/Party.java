package com.criliscraft.plugin.party;

import com.criliscraft.plugin.CriLisCraft;
import com.rit.sucy.config.CustomFilter;
import com.rit.sucy.config.Filter;
import com.rit.sucy.version.VersionPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Party
{
    private ArrayList<String> members = new ArrayList();
    private HashMap<String, Long> invitations = new HashMap();
    private CriLisCraft plugin;
    private VersionPlayer partyLeader;

    public Party(CriLisCraft plugin, Player leader)
    {
        this.plugin = plugin;
        this.partyLeader = new VersionPlayer(leader);
        this.members.add(this.partyLeader.getIdString());
    }

    public boolean isFull()
    {
        checkInvitations();
        return this.invitations.size() + this.members.size() >= this.plugin.getMaxSize();
    }

    public boolean isEmpty()
    {
        checkInvitations();
        return this.invitations.size() + this.members.size() <= 1;
    }

    public VersionPlayer getLeader()
    {
        return this.partyLeader;
    }

    public void checkInvitations()
    {
        String[] members = (String[])this.invitations.keySet().toArray(new String[this.invitations.size()]);
        for (String member : members) {
            if (((Long)this.invitations.get(member)).longValue() < System.currentTimeMillis())
            {
                this.invitations.remove(member);
                Player player = new VersionPlayer(member).getPlayer();
                if (player != null)
                {
                    sendMessages(this.plugin.getMessage("Party.no-response", true, new CustomFilter[] { Filter.PLAYER.setReplacement(player.getName()) }));
                    this.plugin.sendMessage(player, "Individual.no-response", new CustomFilter[0]);
                }
            }
        }
    }

    public int getPartySize()
    {
        return this.members.size();
    }

    public ArrayList<String> getMembers()
    {
        return this.members;
    }

    public int getOnlinePartySize()
    {
        int counter = 0;
        for (String member : this.members) {
            if (new VersionPlayer(member).getPlayer() != null) {
                counter++;
            }
        }
        return counter;
    }

    public boolean isMember(Player player)
    {
        return this.members.contains(new VersionPlayer(player).getIdString());
    }

    public boolean isInvited(Player player)
    {
        checkInvitations();
        return this.invitations.containsKey(new VersionPlayer(player).getIdString());
    }

    public boolean isLeader(Player player)
    {
        return this.partyLeader.equals(new VersionPlayer(player));
    }

    public void invite(Player player)
    {
        VersionPlayer vp = new VersionPlayer(player);
        if ((!this.members.contains(vp.getIdString())) && (!this.invitations.containsKey(vp.getIdString()))) {
            this.invitations.put(vp.getIdString(), Long.valueOf(System.currentTimeMillis() + this.plugin.getInviteTimeout()));
        }
    }

    public void accept(Player player)
    {
        VersionPlayer vp = new VersionPlayer(player);
        if (this.invitations.containsKey(vp.getIdString()))
        {
            this.invitations.remove(vp.getIdString());
            this.members.add(vp.getIdString());
        }
        if (this.plugin.isUsingScoreboard()) {
            PartyBoardManager.applyBoard(this.plugin, player);
        }
    }

    public void decline(Player player)
    {
        VersionPlayer vp = new VersionPlayer(player);
        if (this.invitations.containsKey(vp.getIdString())) {
            this.invitations.remove(vp.getIdString());
        }
    }

    public void removeMember(Player player)
    {
        VersionPlayer vp = new VersionPlayer(player);
        if (this.members.contains(vp.getIdString())) {
            this.members.remove(vp.getIdString());
        }
        if ((isLeader(player)) && (this.members.size() > 0)) {
            this.partyLeader = new VersionPlayer(this.members.get(0));
        }
        if (this.plugin.isUsingScoreboard()) {
            PartyBoardManager.clearBoard(this.plugin, player);
        }
    }

    public void changeLeader()
    {
        for (String member : this.members) {
            if (new VersionPlayer(member).getPlayer() != null)
            {
                this.partyLeader = new VersionPlayer(member);
                sendMessages(this.plugin.getMessage("Party.new-leader", true, new CustomFilter[] { Filter.PLAYER.setReplacement(this.partyLeader.getName()) }));
            }
        }
    }

    public void removeBoards()
    {
        for (String member : this.members)
        {
            Player player = new VersionPlayer(member).getPlayer();
            if (player != null) {
                PartyBoardManager.clearBoard(this.plugin, player);
            }
        }
    }

    public void giveExp(Player source, double amount, ExpSource expSource)
    {
        if (getOnlinePartySize() == 0) {
            return;
        }
        double baseAmount = amount / (1.0D + (getOnlinePartySize() - 1) * this.plugin.getMemberModifier());
        PlayerData data = SkillAPI.getPlayerData(source);
        PlayerClass main = data.getMainClass();
        int level = main == null ? 0 : main.getLevel();
        for (String member : this.members)
        {
            Player player = VersionManager.getPlayer(member);
            if (player != null)
            {
                PlayerData info = SkillAPI.getPlayerData(player);
                main = info.getMainClass();
                int lvl = main == null ? 0 : main.getLevel();
                int exp = (int)Math.ceil(baseAmount);
                if (this.plugin.getLevelModifier() > 0.0D)
                {
                    int dl = lvl - level;
                    exp = (int)Math.ceil(baseAmount * Math.pow(2.0D, -this.plugin.getLevelModifier() * dl * dl));
                }
                data.giveExp(exp, expSource);
            }
        }
    }

    public void sendMessage(String message)
    {
        for (String member : this.members)
        {
            Player player = new VersionPlayer(member).getPlayer();
            if (player != null) {
                player.sendMessage(message);
            }
        }
    }

    public void sendMessages(List<String> messages)
    {
        for (String member : this.members)
        {
            player = new VersionPlayer(member).getPlayer();
            if (player != null) {
                for (String message : messages) {
                    player.sendMessage(message);
                }
            }
        }
        Player player;
    }

    public void sendMessage(Player sender, String message)
    {
        List<String> messages = this.plugin.getMessage("Party.chat-message", true, new CustomFilter[] { Filter.PLAYER.setReplacement(sender.getName()), Filter.MESSAGE.setReplacement(message) });
        for (String member : this.members)
        {
            player = new VersionPlayer(member).getPlayer();
            if (player != null) {
                for (String line : messages) {
                    player.sendMessage(line);
                }
            }
        }
        Player player;
    }

    public void clearBoard(Player player)
    {
        PartyBoardManager.clearBoard(this.plugin, player);
        if (isEmpty()) {
            removeBoards();
        }
    }

    public void updateBoards()
    {
        removeBoards();
        for (String member : this.members) {
            PartyBoardManager.applyBoard(this.plugin, new VersionPlayer(member).getPlayer());
        }
    }
}

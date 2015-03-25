package com.rit.sucy.commands;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public class CommandLog implements CommandSender
{
    public static LogFunction callback;

    @Override
    public void sendMessage(String s)
    {
        callback.execute(s);
    }

    @Override
    public void sendMessage(String[] strings)
    {
        for (String str : strings)
        {
            callback.execute(str);
        }
    }

    @Override
    public Server getServer()
    {
        return Bukkit.getServer();
    }

    @Override
    public String getName()
    {
        return "MCCore Logger";
    }

    @Override
    public boolean isPermissionSet(String s)
    {
        return true;
    }

    @Override
    public boolean isPermissionSet(Permission permission)
    {
        return true;
    }

    @Override
    public boolean hasPermission(String s)
    {
        return true;
    }

    @Override
    public boolean hasPermission(Permission permission)
    {
        return true;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b)
    {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin)
    {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i)
    {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int i)
    {
        return null;
    }

    @Override
    public void removeAttachment(PermissionAttachment permissionAttachment)
    {

    }

    @Override
    public void recalculatePermissions()
    {

    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions()
    {
        return null;
    }

    @Override
    public boolean isOp()
    {
        return true;
    }

    @Override
    public void setOp(boolean b)
    {

    }
}

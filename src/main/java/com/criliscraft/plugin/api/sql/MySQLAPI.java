package com.criliscraft.plugin.api.sql;

import com.criliscraft.plugin.CriLisCraft;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MySQLAPI {

    CriLisCraft plugin;
    static MySQLAPI api;
    private String DBHost = "";
    private String DBPort = "";
    private String DBDatabase = "";
    private String DBUser = "";
    private String DBPass = "";
    private MySQLFunc MySQL = null;
    private Connection c = null;
    private Statement statement = null;
    private Boolean connected = Boolean.valueOf(false);

    public MySQLAPI(CriLisCraft instance) {
        this.plugin = instance;
        api = this;
    }

    public static MySQLAPI getInstance() {
        return api;
    }

    public Boolean Connect(String DBHost, String DBPort, String DBDatabase, String DBUser, String DBPass) {
        this.DBHost = DBHost;
        this.DBPort = DBPort;
        this.DBDatabase = DBDatabase;
        this.DBUser = DBUser;
        this.DBPass = DBPass;

        this.MySQL = new MySQLFunc(this.DBHost, this.DBPort, this.DBDatabase,
                this.DBUser, this.DBPass);
        this.c = this.MySQL.open();
        try
        {
            this.statement = this.c.createStatement();
            this.connected = Boolean.valueOf(true);
            this.plugin.getLogger().info(
                    "The Plugin Successfully Connected To The Database");
        }
        catch (SQLException e)
        {
            this.connected = Boolean.valueOf(false);
            this.plugin.getLogger().warning(
                    "The Plugin Could Not Connect To The Database");
        }
        this.MySQL.closeConnection(this.c);
        return this.connected;
    }

    public void createTable(String TableName, String[] ColumnNames, DataTypes[] dataTypes) {
        if (this.connected.equals(Boolean.valueOf(true)))
        {
            if (ColumnNames.length == dataTypes.length)
            {
                String SQLStatement = "";
                for (int position = 0; position < ColumnNames.length; position++)
                {
                    SQLStatement =
                            SQLStatement + ColumnNames[position] + " " + dataTypes[position];
                    if (position < ColumnNames.length - 1) {
                        SQLStatement = SQLStatement + ", ";
                    }
                }
                this.MySQL = new MySQLFunc(this.DBHost, this.DBPort,
                        this.DBDatabase, this.DBUser, this.DBPass);
                this.c = this.MySQL.open();
                try
                {
                    this.statement = this.c.createStatement();
                    this.statement.executeUpdate("CREATE TABLE IF NOT EXISTS " +
                            TableName + " (" + SQLStatement + ");");
                }
                catch (SQLException e)
                {
                    this.plugin.getLogger().warning(
                            "Error Number - " + e.getErrorCode());
                    e.printStackTrace();
                }
                this.MySQL.closeConnection(this.c);
            }
            else
            {
                this.plugin.getLogger().warning(
                        "DataTypes MUST Be The Same Length As ColumnNames!");
                this.plugin.getLogger().warning(
                        "Create Table Operation Stopped");
            }
        }
        else
        {
            this.plugin.getLogger().warning(
                    "You Have To Connect Before Doing Other Functions!");
            this.plugin.getLogger().warning("Create Table Operation Stopped");
            return;
        }
    }

    public int countEntrys(String TableName) {
        this.MySQL = new MySQLFunc(this.DBHost, this.DBPort, this.DBDatabase,
                this.DBUser, this.DBPass);
        this.c = this.MySQL.open();
        try
        {
            this.statement = this.c.createStatement();
            ResultSet res = this.statement.executeQuery("SELECT COUNT(*) FROM " +
                    TableName + ";");
            res.next();
            return res.findColumn("COUNT(*)");
        }
        catch (SQLException e)
        {
            this.plugin.getLogger().warning(
                    "Error Number - " + e.getErrorCode());
            e.printStackTrace();

            this.MySQL.closeConnection(this.c);
        }
        return -1;
    }

    public void insertEntry(String TableName, String[] ColumnNames, Object[] Values)
    {
        String columndata = "";
        String valuesdata = "";
        for (int position = 0; position < ColumnNames.length; position++)
        {
            columndata = columndata + "`" + ColumnNames[position];
            valuesdata = valuesdata + "'" + Values[position];
            if (position < ColumnNames.length - 1)
            {
                columndata = columndata + "`,";
                valuesdata = valuesdata + "',";
            }
            else
            {
                columndata = columndata + "`";
                valuesdata = valuesdata + "'";
            }
        }
        this.MySQL = new MySQLFunc(this.DBHost, this.DBPort, this.DBDatabase,
                this.DBUser, this.DBPass);
        this.c = this.MySQL.open();
        try
        {
            this.statement = this.c.createStatement();
            this.statement.executeUpdate("INSERT INTO `" + this.DBDatabase +
                    "`.`" + TableName + "` (" + columndata + ") VALUES (" +
                    valuesdata + ");");
        }
        catch (SQLException e)
        {
            this.plugin.getLogger().warning(
                    "Error Number - " + e.getErrorCode());
            e.printStackTrace();
        }
        this.MySQL.closeConnection(this.c);
    }

    public ResultSet getAllEntrys(String TableName)
    {
        this.MySQL = new MySQLFunc(this.DBHost, this.DBPort, this.DBDatabase,
                this.DBUser, this.DBPass);
        this.c = this.MySQL.open();
        try
        {
            this.statement = this.c.createStatement();
            return this.statement.executeQuery("SELECT * FROM " + TableName +
                    ";");
        }
        catch (SQLException e)
        {
            this.plugin.getLogger().warning(
                    "Error Number - " + e.getErrorCode());
            e.printStackTrace();

            this.MySQL.closeConnection(this.c);
        }
        return null;
    }

    public ResultSet getSortedEntrys(String TableName, String ColumnName, Operator operator, String SortValue)
    {
        this.MySQL = new MySQLFunc(this.DBHost, this.DBPort, this.DBDatabase,
                this.DBUser, this.DBPass);
        this.c = this.MySQL.open();
        try
        {
            String op = "";
            if (operator.equals(Operator.Equals)) {
                op = "=";
            }
            if (operator.equals(Operator.GreaterThan)) {
                op = ">";
            }
            if (operator.equals(Operator.GreaterandEqualto)) {
                op = ">=";
            }
            if (operator.equals(Operator.LessThan)) {
                op = "<";
            }
            if (operator.equals(Operator.LessandEqualto)) {
                op = "<=";
            }
            this.statement = this.c.createStatement();
            return this.statement.executeQuery("SELECT * FROM " + TableName +
                    " WHERE `" + ColumnName + "` " + op + "'" + SortValue +
                    "';");
        }
        catch (SQLException e)
        {
            this.plugin.getLogger().warning(
                    "Error Number - " + e.getErrorCode());
            e.printStackTrace();

            this.MySQL.closeConnection(this.c);
        }
        return null;
    }

    public static enum DataTypes
    {
        Text(1),  Char(2),  Int(3),  Decimal(4),  Float(5),  Double(6),  Boolean(7),  Date(
            8),  Time(9);

        private static final Map<Integer, DataTypes> valueList;
        private final int value;

        static
        {
            valueList = new HashMap();
            for (DataTypes result : values()) {
                valueList.put(Integer.valueOf(result.value), result);
            }
        }

        private DataTypes(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return this.value;
        }

        public static DataTypes getResult(int value)
        {
            return (DataTypes)valueList.get(Integer.valueOf(value));
        }
    }

    public static enum Operator
    {
        Equals(1),  GreaterThan(2),  LessThan(3),  GreaterandEqualto(4),  LessandEqualto(
            5);

        private static final Map<Integer, Operator> valueList;
        private final int value;

        static
        {
            valueList = new HashMap();
            for (Operator result : values()) {
                valueList.put(Integer.valueOf(result.value), result);
            }
        }

        private Operator(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return this.value;
        }

        public static Operator getResult(int value)
        {
            return (Operator)valueList.get(Integer.valueOf(value));
        }
    }
}


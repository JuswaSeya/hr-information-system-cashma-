package com.example.hello_world.dbconnection;

import android.content.Context;

import java.sql.Connection;


public class connector {
    private Context context;
private Connection con;


    public connector(Context context) {
        this.context = context;
    }

    public Connection getConnection() {
        database db = new database();
        database config = new database().DB1();
        con = db.connectionClass(config.server, config.password, config.database, config.ip);
        return con;


    }
}

package com.example.carrot;

import android.content.Context;

import androidx.room.Room;


public class Database {

    private static Database database;
    private UserDatabase userDatabase;


    private Database(Context context){

                userDatabase = Room.databaseBuilder(context,
                        UserDatabase.class, "userDB").allowMainThreadQueries().build();

    }

    public static Database getInstance(Context context){
        if(database == null){
            database = new Database(context);
        }
        return database;
    }

    public UserDatabase getDatabase(){

        return userDatabase;
    }
}

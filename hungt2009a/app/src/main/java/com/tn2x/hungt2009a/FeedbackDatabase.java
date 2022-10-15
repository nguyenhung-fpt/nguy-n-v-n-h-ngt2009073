package com.tn2x.hungt2009a;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Feedbacks.class}, version = 1)
public abstract class FeedbackDatabase extends RoomDatabase {

    private static FeedbackDatabase instance;

    public abstract Dao Dao();

    public static synchronized FeedbackDatabase getInstance(Context context) {
        // below line is to check if
        // the instance is null or not.
        if (instance == null) {
            // if the instance is null we
            // are creating a new instance
            instance =
                    // for creating a instance for our database
                    // we are creating a database builder and passing
                    // our database class with our database name.
                    Room.databaseBuilder(context.getApplicationContext(),
                                    FeedbackDatabase.class, "feedback")
                            // below line is use to add fall back to
                            // destructive migration to our database.
                            .fallbackToDestructiveMigration()
                            // below line is to add callback
                            // to our database.
                            .addCallback(roomCallback)
                            // below line is to
                            // build our database.
                            .build();
        }
        // after creating an instance
        // we are returning our instance
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // this method is called when database is created
            // and below line is to populate our data.
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        PopulateDbAsyncTask(FeedbackDatabase instance) {
            Dao dao = instance.Dao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}

package maxson.com.br.maxsonnews.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import maxson.com.br.maxsonnews.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract NewsDao newsDao();
}

package com.forecast.app.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.forecast.app.db.DailyForecast;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DAILY_FORECAST".
*/
public class DailyForecastDao extends AbstractDao<DailyForecast, Long> {

    public static final String TABLENAME = "DAILY_FORECAST";

    /**
     * Properties of entity DailyForecast.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Time = new Property(1, Long.class, "time", false, "TIME");
        public final static Property Summary = new Property(2, String.class, "summary", false, "SUMMARY");
        public final static Property TemperatureMin = new Property(3, Float.class, "temperatureMin", false, "TEMPERATURE_MIN");
        public final static Property TemperatureMax = new Property(4, Float.class, "temperatureMax", false, "TEMPERATURE_MAX");
    };

    private DaoSession daoSession;


    public DailyForecastDao(DaoConfig config) {
        super(config);
    }
    
    public DailyForecastDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DAILY_FORECAST\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TIME\" INTEGER," + // 1: time
                "\"SUMMARY\" TEXT," + // 2: summary
                "\"TEMPERATURE_MIN\" REAL," + // 3: temperatureMin
                "\"TEMPERATURE_MAX\" REAL);"); // 4: temperatureMax
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DAILY_FORECAST\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, DailyForecast entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long time = entity.getTime();
        if (time != null) {
            stmt.bindLong(2, time);
        }
 
        String summary = entity.getSummary();
        if (summary != null) {
            stmt.bindString(3, summary);
        }
 
        Float temperatureMin = entity.getTemperatureMin();
        if (temperatureMin != null) {
            stmt.bindDouble(4, temperatureMin);
        }
 
        Float temperatureMax = entity.getTemperatureMax();
        if (temperatureMax != null) {
            stmt.bindDouble(5, temperatureMax);
        }
    }

    @Override
    protected void attachEntity(DailyForecast entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public DailyForecast readEntity(Cursor cursor, int offset) {
        DailyForecast entity = new DailyForecast( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // time
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // summary
            cursor.isNull(offset + 3) ? null : cursor.getFloat(offset + 3), // temperatureMin
            cursor.isNull(offset + 4) ? null : cursor.getFloat(offset + 4) // temperatureMax
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, DailyForecast entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTime(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setSummary(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTemperatureMin(cursor.isNull(offset + 3) ? null : cursor.getFloat(offset + 3));
        entity.setTemperatureMax(cursor.isNull(offset + 4) ? null : cursor.getFloat(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(DailyForecast entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(DailyForecast entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}

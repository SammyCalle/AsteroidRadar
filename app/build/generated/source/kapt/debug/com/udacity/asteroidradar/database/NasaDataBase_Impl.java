package com.udacity.asteroidradar.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NasaDataBase_Impl extends NasaDataBase {
  private volatile AsteroidsDao _asteroidsDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `asteroids` (`id` INTEGER NOT NULL, `codename` TEXT NOT NULL, `closeApproachDate` TEXT NOT NULL, `absoluteMagnitude` REAL NOT NULL, `estimatedDiameter` REAL NOT NULL, `relativeVelocity` REAL NOT NULL, `distanceFromEarth` REAL NOT NULL, `isPotentiallyHazardous` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `picture` (`url` TEXT NOT NULL, `mediaType` TEXT NOT NULL, `title` TEXT NOT NULL, PRIMARY KEY(`url`, `title`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'f17e32146555eb604b9dbe514aafcbf2')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `asteroids`");
        _db.execSQL("DROP TABLE IF EXISTS `picture`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAsteroids = new HashMap<String, TableInfo.Column>(8);
        _columnsAsteroids.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsteroids.put("codename", new TableInfo.Column("codename", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsteroids.put("closeApproachDate", new TableInfo.Column("closeApproachDate", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsteroids.put("absoluteMagnitude", new TableInfo.Column("absoluteMagnitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsteroids.put("estimatedDiameter", new TableInfo.Column("estimatedDiameter", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsteroids.put("relativeVelocity", new TableInfo.Column("relativeVelocity", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsteroids.put("distanceFromEarth", new TableInfo.Column("distanceFromEarth", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAsteroids.put("isPotentiallyHazardous", new TableInfo.Column("isPotentiallyHazardous", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAsteroids = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAsteroids = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAsteroids = new TableInfo("asteroids", _columnsAsteroids, _foreignKeysAsteroids, _indicesAsteroids);
        final TableInfo _existingAsteroids = TableInfo.read(_db, "asteroids");
        if (! _infoAsteroids.equals(_existingAsteroids)) {
          return new RoomOpenHelper.ValidationResult(false, "asteroids(com.udacity.asteroidradar.database.DatabaseAsteroid).\n"
                  + " Expected:\n" + _infoAsteroids + "\n"
                  + " Found:\n" + _existingAsteroids);
        }
        final HashMap<String, TableInfo.Column> _columnsPicture = new HashMap<String, TableInfo.Column>(3);
        _columnsPicture.put("url", new TableInfo.Column("url", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPicture.put("mediaType", new TableInfo.Column("mediaType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPicture.put("title", new TableInfo.Column("title", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPicture = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPicture = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPicture = new TableInfo("picture", _columnsPicture, _foreignKeysPicture, _indicesPicture);
        final TableInfo _existingPicture = TableInfo.read(_db, "picture");
        if (! _infoPicture.equals(_existingPicture)) {
          return new RoomOpenHelper.ValidationResult(false, "picture(com.udacity.asteroidradar.database.PictureTable).\n"
                  + " Expected:\n" + _infoPicture + "\n"
                  + " Found:\n" + _existingPicture);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "f17e32146555eb604b9dbe514aafcbf2", "3c87375f18d6cb5448f73130d4e8f5d9");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "asteroids","picture");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `asteroids`");
      _db.execSQL("DELETE FROM `picture`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public AsteroidsDao getAsteroidsDao() {
    if (_asteroidsDao != null) {
      return _asteroidsDao;
    } else {
      synchronized(this) {
        if(_asteroidsDao == null) {
          _asteroidsDao = new AsteroidsDao_Impl(this);
        }
        return _asteroidsDao;
      }
    }
  }
}

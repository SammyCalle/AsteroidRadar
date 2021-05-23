package com.udacity.asteroidradar.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AsteroidsDao_Impl implements AsteroidsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DatabaseAsteroid> __insertionAdapterOfDatabaseAsteroid;

  private final EntityInsertionAdapter<PictureTable> __insertionAdapterOfPictureTable;

  public AsteroidsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDatabaseAsteroid = new EntityInsertionAdapter<DatabaseAsteroid>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `asteroids` (`id`,`codename`,`closeApproachDate`,`absoluteMagnitude`,`estimatedDiameter`,`relativeVelocity`,`distanceFromEarth`,`isPotentiallyHazardous`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DatabaseAsteroid value) {
        stmt.bindLong(1, value.getId());
        if (value.getCodename() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCodename());
        }
        if (value.getCloseApproachDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCloseApproachDate());
        }
        stmt.bindDouble(4, value.getAbsoluteMagnitude());
        stmt.bindDouble(5, value.getEstimatedDiameter());
        stmt.bindDouble(6, value.getRelativeVelocity());
        stmt.bindDouble(7, value.getDistanceFromEarth());
        final int _tmp;
        _tmp = value.isPotentiallyHazardous() ? 1 : 0;
        stmt.bindLong(8, _tmp);
      }
    };
    this.__insertionAdapterOfPictureTable = new EntityInsertionAdapter<PictureTable>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `picture` (`url`,`mediaType`,`title`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PictureTable value) {
        if (value.getUrl() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUrl());
        }
        if (value.getMediaType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMediaType());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTitle());
        }
      }
    };
  }

  @Override
  public void insertAll(final List<DatabaseAsteroid> asteroids) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDatabaseAsteroid.insert(asteroids);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertPicture(final PictureTable picture) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPictureTable.insert(picture);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<DatabaseAsteroid>> getAsteroids() {
    final String _sql = "select * from asteroids order by closeApproachDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"asteroids"}, false, new Callable<List<DatabaseAsteroid>>() {
      @Override
      public List<DatabaseAsteroid> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCodename = CursorUtil.getColumnIndexOrThrow(_cursor, "codename");
          final int _cursorIndexOfCloseApproachDate = CursorUtil.getColumnIndexOrThrow(_cursor, "closeApproachDate");
          final int _cursorIndexOfAbsoluteMagnitude = CursorUtil.getColumnIndexOrThrow(_cursor, "absoluteMagnitude");
          final int _cursorIndexOfEstimatedDiameter = CursorUtil.getColumnIndexOrThrow(_cursor, "estimatedDiameter");
          final int _cursorIndexOfRelativeVelocity = CursorUtil.getColumnIndexOrThrow(_cursor, "relativeVelocity");
          final int _cursorIndexOfDistanceFromEarth = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceFromEarth");
          final int _cursorIndexOfIsPotentiallyHazardous = CursorUtil.getColumnIndexOrThrow(_cursor, "isPotentiallyHazardous");
          final List<DatabaseAsteroid> _result = new ArrayList<DatabaseAsteroid>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DatabaseAsteroid _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpCodename;
            _tmpCodename = _cursor.getString(_cursorIndexOfCodename);
            final String _tmpCloseApproachDate;
            _tmpCloseApproachDate = _cursor.getString(_cursorIndexOfCloseApproachDate);
            final double _tmpAbsoluteMagnitude;
            _tmpAbsoluteMagnitude = _cursor.getDouble(_cursorIndexOfAbsoluteMagnitude);
            final double _tmpEstimatedDiameter;
            _tmpEstimatedDiameter = _cursor.getDouble(_cursorIndexOfEstimatedDiameter);
            final double _tmpRelativeVelocity;
            _tmpRelativeVelocity = _cursor.getDouble(_cursorIndexOfRelativeVelocity);
            final double _tmpDistanceFromEarth;
            _tmpDistanceFromEarth = _cursor.getDouble(_cursorIndexOfDistanceFromEarth);
            final boolean _tmpIsPotentiallyHazardous;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPotentiallyHazardous);
            _tmpIsPotentiallyHazardous = _tmp != 0;
            _item = new DatabaseAsteroid(_tmpId,_tmpCodename,_tmpCloseApproachDate,_tmpAbsoluteMagnitude,_tmpEstimatedDiameter,_tmpRelativeVelocity,_tmpDistanceFromEarth,_tmpIsPotentiallyHazardous);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<DatabaseAsteroid>> getAsteroidsFromTodayOnwards(final String currentDate) {
    final String _sql = "select * from asteroids where closeApproachDate >= ? order by closeApproachDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (currentDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, currentDate);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"asteroids"}, false, new Callable<List<DatabaseAsteroid>>() {
      @Override
      public List<DatabaseAsteroid> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCodename = CursorUtil.getColumnIndexOrThrow(_cursor, "codename");
          final int _cursorIndexOfCloseApproachDate = CursorUtil.getColumnIndexOrThrow(_cursor, "closeApproachDate");
          final int _cursorIndexOfAbsoluteMagnitude = CursorUtil.getColumnIndexOrThrow(_cursor, "absoluteMagnitude");
          final int _cursorIndexOfEstimatedDiameter = CursorUtil.getColumnIndexOrThrow(_cursor, "estimatedDiameter");
          final int _cursorIndexOfRelativeVelocity = CursorUtil.getColumnIndexOrThrow(_cursor, "relativeVelocity");
          final int _cursorIndexOfDistanceFromEarth = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceFromEarth");
          final int _cursorIndexOfIsPotentiallyHazardous = CursorUtil.getColumnIndexOrThrow(_cursor, "isPotentiallyHazardous");
          final List<DatabaseAsteroid> _result = new ArrayList<DatabaseAsteroid>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DatabaseAsteroid _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpCodename;
            _tmpCodename = _cursor.getString(_cursorIndexOfCodename);
            final String _tmpCloseApproachDate;
            _tmpCloseApproachDate = _cursor.getString(_cursorIndexOfCloseApproachDate);
            final double _tmpAbsoluteMagnitude;
            _tmpAbsoluteMagnitude = _cursor.getDouble(_cursorIndexOfAbsoluteMagnitude);
            final double _tmpEstimatedDiameter;
            _tmpEstimatedDiameter = _cursor.getDouble(_cursorIndexOfEstimatedDiameter);
            final double _tmpRelativeVelocity;
            _tmpRelativeVelocity = _cursor.getDouble(_cursorIndexOfRelativeVelocity);
            final double _tmpDistanceFromEarth;
            _tmpDistanceFromEarth = _cursor.getDouble(_cursorIndexOfDistanceFromEarth);
            final boolean _tmpIsPotentiallyHazardous;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPotentiallyHazardous);
            _tmpIsPotentiallyHazardous = _tmp != 0;
            _item = new DatabaseAsteroid(_tmpId,_tmpCodename,_tmpCloseApproachDate,_tmpAbsoluteMagnitude,_tmpEstimatedDiameter,_tmpRelativeVelocity,_tmpDistanceFromEarth,_tmpIsPotentiallyHazardous);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<DatabaseAsteroid>> getAsteroidsForThisWeek(final String currentDate,
      final String weekAfterDate) {
    final String _sql = "select * from asteroids where closeApproachDate >= ? and closeApproachDate <= ? order by closeApproachDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (currentDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, currentDate);
    }
    _argIndex = 2;
    if (weekAfterDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, weekAfterDate);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"asteroids"}, false, new Callable<List<DatabaseAsteroid>>() {
      @Override
      public List<DatabaseAsteroid> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCodename = CursorUtil.getColumnIndexOrThrow(_cursor, "codename");
          final int _cursorIndexOfCloseApproachDate = CursorUtil.getColumnIndexOrThrow(_cursor, "closeApproachDate");
          final int _cursorIndexOfAbsoluteMagnitude = CursorUtil.getColumnIndexOrThrow(_cursor, "absoluteMagnitude");
          final int _cursorIndexOfEstimatedDiameter = CursorUtil.getColumnIndexOrThrow(_cursor, "estimatedDiameter");
          final int _cursorIndexOfRelativeVelocity = CursorUtil.getColumnIndexOrThrow(_cursor, "relativeVelocity");
          final int _cursorIndexOfDistanceFromEarth = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceFromEarth");
          final int _cursorIndexOfIsPotentiallyHazardous = CursorUtil.getColumnIndexOrThrow(_cursor, "isPotentiallyHazardous");
          final List<DatabaseAsteroid> _result = new ArrayList<DatabaseAsteroid>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DatabaseAsteroid _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpCodename;
            _tmpCodename = _cursor.getString(_cursorIndexOfCodename);
            final String _tmpCloseApproachDate;
            _tmpCloseApproachDate = _cursor.getString(_cursorIndexOfCloseApproachDate);
            final double _tmpAbsoluteMagnitude;
            _tmpAbsoluteMagnitude = _cursor.getDouble(_cursorIndexOfAbsoluteMagnitude);
            final double _tmpEstimatedDiameter;
            _tmpEstimatedDiameter = _cursor.getDouble(_cursorIndexOfEstimatedDiameter);
            final double _tmpRelativeVelocity;
            _tmpRelativeVelocity = _cursor.getDouble(_cursorIndexOfRelativeVelocity);
            final double _tmpDistanceFromEarth;
            _tmpDistanceFromEarth = _cursor.getDouble(_cursorIndexOfDistanceFromEarth);
            final boolean _tmpIsPotentiallyHazardous;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsPotentiallyHazardous);
            _tmpIsPotentiallyHazardous = _tmp != 0;
            _item = new DatabaseAsteroid(_tmpId,_tmpCodename,_tmpCloseApproachDate,_tmpAbsoluteMagnitude,_tmpEstimatedDiameter,_tmpRelativeVelocity,_tmpDistanceFromEarth,_tmpIsPotentiallyHazardous);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<PictureTable>> getPicture() {
    final String _sql = "select * from picture";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"picture"}, false, new Callable<List<PictureTable>>() {
      @Override
      public List<PictureTable> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfMediaType = CursorUtil.getColumnIndexOrThrow(_cursor, "mediaType");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final List<PictureTable> _result = new ArrayList<PictureTable>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PictureTable _item;
            final String _tmpUrl;
            _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            final String _tmpMediaType;
            _tmpMediaType = _cursor.getString(_cursorIndexOfMediaType);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            _item = new PictureTable(_tmpUrl,_tmpMediaType,_tmpTitle);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}

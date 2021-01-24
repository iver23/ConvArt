package com.abadil.convart.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;

import com.abadil.convart.data.MetricPoint;

import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MetricPointDao_Impl implements MetricPointDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MetricPoint> __insertionAdapterOfMetricPoint;

  private final EntityDeletionOrUpdateAdapter<MetricPoint> __deletionAdapterOfMetricPoint;

  private final EntityDeletionOrUpdateAdapter<MetricPoint> __updateAdapterOfMetricPoint;

  public MetricPointDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMetricPoint = new EntityInsertionAdapter<MetricPoint>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `list_points` (`point_id`,`point_x`,`point_y`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MetricPoint value) {
        if (value.get_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.get_id());
        }
        stmt.bindDouble(2, value.getX());
        stmt.bindDouble(3, value.getY());
      }
    };
    this.__deletionAdapterOfMetricPoint = new EntityDeletionOrUpdateAdapter<MetricPoint>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `list_points` WHERE `point_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MetricPoint value) {
        if (value.get_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.get_id());
        }
      }
    };
    this.__updateAdapterOfMetricPoint = new EntityDeletionOrUpdateAdapter<MetricPoint>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `list_points` SET `point_id` = ?,`point_x` = ?,`point_y` = ? WHERE `point_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MetricPoint value) {
        if (value.get_id() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.get_id());
        }
        stmt.bindDouble(2, value.getX());
        stmt.bindDouble(3, value.getY());
        if (value.get_id() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.get_id());
        }
      }
    };
  }

  @Override
  public Object insertPoint(final MetricPoint point, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMetricPoint.insert(point);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deletePoint(final MetricPoint point, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfMetricPoint.handle(point);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updatePoint(final MetricPoint point, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfMetricPoint.handle(point);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public LiveData<List<MetricPoint>> getAllPoints() {
    final String _sql = "SELECT * FROM list_points";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"list_points"}, false, new Callable<List<MetricPoint>>() {
      @Override
      public List<MetricPoint> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "point_id");
          final int _cursorIndexOfX = CursorUtil.getColumnIndexOrThrow(_cursor, "point_x");
          final int _cursorIndexOfY = CursorUtil.getColumnIndexOrThrow(_cursor, "point_y");
          final List<MetricPoint> _result = new ArrayList<MetricPoint>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final MetricPoint _item;
            final String _tmp_id;
            _tmp_id = _cursor.getString(_cursorIndexOfId);
            final float _tmpX;
            _tmpX = _cursor.getFloat(_cursorIndexOfX);
            final float _tmpY;
            _tmpY = _cursor.getFloat(_cursorIndexOfY);
            _item = new MetricPoint(_tmp_id,_tmpX,_tmpY);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

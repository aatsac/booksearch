package com.example.booksearch.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.booksearch.data.local.entity.FavoriteBookEntity;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class FavoriteBookDao_Impl implements FavoriteBookDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FavoriteBookEntity> __insertionAdapterOfFavoriteBookEntity;

  private final EntityDeletionOrUpdateAdapter<FavoriteBookEntity> __deletionAdapterOfFavoriteBookEntity;

  public FavoriteBookDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavoriteBookEntity = new EntityInsertionAdapter<FavoriteBookEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `favorites` (`key`,`title`,`authors`,`firstPublishYear`,`coverId`,`savedAt`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FavoriteBookEntity entity) {
        statement.bindString(1, entity.getKey());
        statement.bindString(2, entity.getTitle());
        statement.bindString(3, entity.getAuthors());
        if (entity.getFirstPublishYear() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getFirstPublishYear());
        }
        if (entity.getCoverId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindLong(5, entity.getCoverId());
        }
        statement.bindLong(6, entity.getSavedAt());
      }
    };
    this.__deletionAdapterOfFavoriteBookEntity = new EntityDeletionOrUpdateAdapter<FavoriteBookEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `favorites` WHERE `key` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FavoriteBookEntity entity) {
        statement.bindString(1, entity.getKey());
      }
    };
  }

  @Override
  public Object insert(final FavoriteBookEntity book,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFavoriteBookEntity.insert(book);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final FavoriteBookEntity book,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFavoriteBookEntity.handle(book);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<FavoriteBookEntity>> getAllFavorites() {
    final String _sql = "SELECT * FROM favorites ORDER BY savedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"favorites"}, new Callable<List<FavoriteBookEntity>>() {
      @Override
      @NonNull
      public List<FavoriteBookEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthors = CursorUtil.getColumnIndexOrThrow(_cursor, "authors");
          final int _cursorIndexOfFirstPublishYear = CursorUtil.getColumnIndexOrThrow(_cursor, "firstPublishYear");
          final int _cursorIndexOfCoverId = CursorUtil.getColumnIndexOrThrow(_cursor, "coverId");
          final int _cursorIndexOfSavedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "savedAt");
          final List<FavoriteBookEntity> _result = new ArrayList<FavoriteBookEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FavoriteBookEntity _item;
            final String _tmpKey;
            _tmpKey = _cursor.getString(_cursorIndexOfKey);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpAuthors;
            _tmpAuthors = _cursor.getString(_cursorIndexOfAuthors);
            final Integer _tmpFirstPublishYear;
            if (_cursor.isNull(_cursorIndexOfFirstPublishYear)) {
              _tmpFirstPublishYear = null;
            } else {
              _tmpFirstPublishYear = _cursor.getInt(_cursorIndexOfFirstPublishYear);
            }
            final Long _tmpCoverId;
            if (_cursor.isNull(_cursorIndexOfCoverId)) {
              _tmpCoverId = null;
            } else {
              _tmpCoverId = _cursor.getLong(_cursorIndexOfCoverId);
            }
            final long _tmpSavedAt;
            _tmpSavedAt = _cursor.getLong(_cursorIndexOfSavedAt);
            _item = new FavoriteBookEntity(_tmpKey,_tmpTitle,_tmpAuthors,_tmpFirstPublishYear,_tmpCoverId,_tmpSavedAt);
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
  public Flow<Boolean> isFavorite(final String key) {
    final String _sql = "SELECT EXISTS(SELECT 1 FROM favorites WHERE `key` = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, key);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"favorites"}, new Callable<Boolean>() {
      @Override
      @NonNull
      public Boolean call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Boolean _result;
          if (_cursor.moveToFirst()) {
            final int _tmp;
            _tmp = _cursor.getInt(0);
            _result = _tmp != 0;
          } else {
            _result = false;
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

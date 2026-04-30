package com.example.booksearch.di;

import com.example.booksearch.data.local.BookDatabase;
import com.example.booksearch.data.local.dao.FavoriteBookDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class DatabaseModule_ProvideFavoriteBookDaoFactory implements Factory<FavoriteBookDao> {
  private final Provider<BookDatabase> dbProvider;

  public DatabaseModule_ProvideFavoriteBookDaoFactory(Provider<BookDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public FavoriteBookDao get() {
    return provideFavoriteBookDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideFavoriteBookDaoFactory create(
      Provider<BookDatabase> dbProvider) {
    return new DatabaseModule_ProvideFavoriteBookDaoFactory(dbProvider);
  }

  public static FavoriteBookDao provideFavoriteBookDao(BookDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideFavoriteBookDao(db));
  }
}

package com.example.booksearch.di;

import com.example.booksearch.data.local.BookDatabase;
import com.example.booksearch.data.local.dao.ApiLogDao;
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
public final class DatabaseModule_ProvideApiLogDaoFactory implements Factory<ApiLogDao> {
  private final Provider<BookDatabase> dbProvider;

  public DatabaseModule_ProvideApiLogDaoFactory(Provider<BookDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public ApiLogDao get() {
    return provideApiLogDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideApiLogDaoFactory create(Provider<BookDatabase> dbProvider) {
    return new DatabaseModule_ProvideApiLogDaoFactory(dbProvider);
  }

  public static ApiLogDao provideApiLogDao(BookDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideApiLogDao(db));
  }
}

package com.example.booksearch.data;

import com.example.booksearch.data.local.dao.ApiLogDao;
import com.example.booksearch.data.local.dao.FavoriteBookDao;
import com.example.booksearch.data.remote.api.OpenLibraryApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class BookRepositoryImpl_Factory implements Factory<BookRepositoryImpl> {
  private final Provider<OpenLibraryApi> apiProvider;

  private final Provider<ApiLogDao> apiLogDaoProvider;

  private final Provider<FavoriteBookDao> favoriteBookDaoProvider;

  public BookRepositoryImpl_Factory(Provider<OpenLibraryApi> apiProvider,
      Provider<ApiLogDao> apiLogDaoProvider, Provider<FavoriteBookDao> favoriteBookDaoProvider) {
    this.apiProvider = apiProvider;
    this.apiLogDaoProvider = apiLogDaoProvider;
    this.favoriteBookDaoProvider = favoriteBookDaoProvider;
  }

  @Override
  public BookRepositoryImpl get() {
    return newInstance(apiProvider.get(), apiLogDaoProvider.get(), favoriteBookDaoProvider.get());
  }

  public static BookRepositoryImpl_Factory create(Provider<OpenLibraryApi> apiProvider,
      Provider<ApiLogDao> apiLogDaoProvider, Provider<FavoriteBookDao> favoriteBookDaoProvider) {
    return new BookRepositoryImpl_Factory(apiProvider, apiLogDaoProvider, favoriteBookDaoProvider);
  }

  public static BookRepositoryImpl newInstance(OpenLibraryApi api, ApiLogDao apiLogDao,
      FavoriteBookDao favoriteBookDao) {
    return new BookRepositoryImpl(api, apiLogDao, favoriteBookDao);
  }
}

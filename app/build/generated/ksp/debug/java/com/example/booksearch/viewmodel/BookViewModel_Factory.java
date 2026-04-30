package com.example.booksearch.viewmodel;

import com.example.booksearch.domain.repository.BookRepository;
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
public final class BookViewModel_Factory implements Factory<BookViewModel> {
  private final Provider<BookRepository> repositoryProvider;

  public BookViewModel_Factory(Provider<BookRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public BookViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static BookViewModel_Factory create(Provider<BookRepository> repositoryProvider) {
    return new BookViewModel_Factory(repositoryProvider);
  }

  public static BookViewModel newInstance(BookRepository repository) {
    return new BookViewModel(repository);
  }
}

# 📚 BookSearch — Open Library App

App Android com **Jetpack Compose**, **Retrofit** e **Android Room** para buscar livros usando a [Open Library API](https://openlibrary.org/dev/docs/api).

---

## Funcionalidades

### 🔍 Busca de Livros (Retrofit + Open Library API)
- Campo de busca com ação de teclado
- Exibe capa, título, autor(es), ano de publicação, avaliação e número de páginas
- Resultados carregados via `suspend fun` com Coroutines

### 🤍 Favoritos (Room)
- Salva e remove livros favoritos localmente com Room
- Persistido entre sessões
- Tab dedicada com lista de favoritos

### 📋 Logs de API (Room)
- Cada chamada à API é registrada automaticamente no banco local
- Exibe: query, nº de resultados, status (sucesso/erro), mensagem de erro e timestamp
- Botão para limpar todos os logs

---

## Arquitetura

```
data/
  local/
    dao/          → ApiLogDao, FavoriteBookDao
    entity/       → ApiLogEntity, FavoriteBookEntity
    BookDatabase  → Room @Database
  remote/
    api/          → OpenLibraryApi (Retrofit interface)
    model/        → BookDto, SearchResponse
  BookRepositoryImpl
di/
  AppModule       → Hilt: Retrofit, Room, Repository
domain/
  model/          → Book, ApiLog
  repository/     → BookRepository (interface)
ui/
  screens/        → SearchScreen, FavoritesScreen, LogsScreen, MainNavigation
  components/     → BookCard
  theme/          → BookSearchTheme
viewmodel/
  BookViewModel   → HiltViewModel com StateFlow
```

---

## Como rodar

### Pré-requisitos
- Android Studio Hedgehog (2023.1.1) ou superior
- JDK 17
- Android SDK 35

### Passos
1. Abra o projeto no Android Studio: **File > Open > booksearch**
2. Aguarde o Gradle sync
3. Rode em um emulador ou dispositivo físico (API 26+)

> O app não precisa de API key — a Open Library é completamente aberta.

---

## Dependências principais

| Biblioteca | Versão | Uso |
|---|---|---|
| Jetpack Compose BOM | 2024.09.03 | UI |
| Retrofit | 2.11.0 | Chamadas HTTP |
| Gson Converter | 2.11.0 | Deserialização JSON |
| OkHttp Logging | 4.12.0 | Logs de rede |
| Room | 2.6.1 | Banco local |
| Hilt | 2.52 | Injeção de dependência |
| Coil | 2.7.0 | Carregamento de imagens |
| Navigation Compose | 2.8.2 | Navegação entre telas |

---

## Endpoint utilizado

```
GET https://openlibrary.org/search.json?q={query}&limit=20&fields=key,title,author_name,...
```

Documentação: https://openlibrary.org/dev/docs/api

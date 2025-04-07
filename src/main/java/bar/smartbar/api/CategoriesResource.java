package bar.smartbar.api;

import bar.smartbar.api.model.Category;
import jakarta.ws.rs.core.Response;


import java.net.URI;
import java.util.List;

public class CategoriesResource implements CategoriesApi {

  private final Category category = new Category().name("drinks");


  @Override
  public Response categoriesCategoryIdDelete(String categoryId) {
    return Response.ok().build();
  }

  @Override
  public Response categoriesCategoryIdGet(String categoryId) {
    return Response.ok(category).build();
  }

  @Override
  public Response categoriesCategoryIdPut(String categoryId, Category category) {
    return Response.ok().build();
  }

  @Override
  public Response categoriesGet() {
    return Response.ok(List.of(category)).build();
  }

  @Override
  public Response categoriesPost(Category category) {
    return Response.created(URI.create("todo")).build();
  }
}

package bar.smartbar;

import bar.smartbar.api.ArticlesApi;
import bar.smartbar.api.model.Article;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;


@NonBlocking
public class ArticlesResource implements ArticlesApi {

    private final Article article = new Article().name("TestArticle");

    @Override
    public Response articlesArticleIdDelete(String articleId) {
        return Response.ok().build();
    }

    @Override
    public Response articlesArticleIdGet(String articleId) {
        return Response.ok(article).build();
    }

    @Override
    public Response articlesArticleIdPut(String articleId, Article article) {
        return Response.ok().build();
    }

    @Override
    public Response articlesGet() {
        return Response.ok(List.of(article)).build();
    }

    @Override
    public Response articlesPost(Article article) {
        return Response.created(URI.create("todo")).build();
    }
}

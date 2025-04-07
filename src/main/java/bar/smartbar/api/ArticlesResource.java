package bar.smartbar.api;

import bar.smartbar.ArticlesServices;
import bar.smartbar.api.model.Article;
import io.smallrye.common.annotation.NonBlocking;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;


@NonBlocking
public class ArticlesResource implements ArticlesApi {

    // We used constructor based injection instead of injecting it directly into a private member
    //  This is because arc must use reflection when setting private members, since Quarkus uses Graalvm to build native images
    private final ArticlesServices articlesServices;

    public ArticlesResource(ArticlesServices articlesServices) {
        this.articlesServices = articlesServices;
    }

    @Override
    public Response articlesArticleIdDelete(String articleId) {
        return Response.ok().build();
    }

    @Override
    public Response articlesArticleIdGet(String articleId) {
        return Response.ok(articlesServices.get()).build();
    }

    @Override
    public Response articlesArticleIdPut(String articleId, Article article) {
        return Response.ok().build();
    }

    @Override
    public Response articlesGet() {
        return Response.ok(List.of(articlesServices.get())).build();
    }

    @Override
    public Response articlesPost(Article article) {
        return Response.created(URI.create("todo")).build();
    }
}

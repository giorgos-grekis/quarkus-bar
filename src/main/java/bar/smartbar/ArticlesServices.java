package bar.smartbar;

import bar.smartbar.api.model.Article;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArticlesServices {

    public Article get() {
        return new Article().name("TestArticle");
    }
}

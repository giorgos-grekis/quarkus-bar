package bar.smartbar;

import bar.smartbar.api.model.Category;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriesService {

    public Category get() {
        return new Category().name("drinks");
    }

}

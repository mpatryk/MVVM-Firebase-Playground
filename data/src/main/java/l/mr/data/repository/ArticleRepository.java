package l.mr.data.repository;

import l.mr.data.mapper.ArticleMapper;
import l.mr.domain.entities.Article;

public class ArticleRepository extends FirebaseDatabaseRepository<Article> {
    public ArticleRepository() {
        super(new ArticleMapper());
    }

    @Override
    protected String getRootNode() {
        return "articles";
    }
}

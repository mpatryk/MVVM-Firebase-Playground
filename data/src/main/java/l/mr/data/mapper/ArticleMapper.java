package l.mr.data.mapper;

import l.mr.data.entities.ArticleEntity;
import l.mr.domain.entities.Article;

public class ArticleMapper extends FirebaseMapper<ArticleEntity, Article> {

    @Override
    public Article map(ArticleEntity articleEntity) {
        Article article = new Article();
        article.setPrice(articleEntity.getPrice());
        article.setImageUrl(articleEntity.getImageUrl());
        article.setName(articleEntity.getName());
        return article;
    }

}

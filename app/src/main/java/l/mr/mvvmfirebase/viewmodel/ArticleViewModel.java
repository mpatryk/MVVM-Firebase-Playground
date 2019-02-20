package l.mr.mvvmfirebase.viewmodel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import l.mr.data.repository.ArticleRepository;
import l.mr.data.repository.FirebaseDatabaseRepository;
import l.mr.domain.entities.Article;

public class ArticleViewModel extends ViewModel {
    private MutableLiveData<List<Article>> articles;
    private ArticleRepository repository = new ArticleRepository();

    public LiveData<List<Article>> getArticles() {
        if (articles == null) {
            articles = new MutableLiveData<>();
            loadArticles();
        }
        return articles;
    }

    @Override
    protected void onCleared() {
        repository.removeListener();
    }

    private void loadArticles() {
        repository.addListener(new FirebaseDatabaseRepository.FirebaseDatabaseRepositoryCallback<Article>() {
            @Override
            public void onSuccess(List<Article> result) {
                articles.setValue(result);
            }

            @Override
            public void onError(Exception e) {
                articles.setValue(null);
            }
        });
    }
}

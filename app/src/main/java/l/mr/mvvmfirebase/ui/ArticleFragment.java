package l.mr.mvvmfirebase.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import l.mr.domain.entities.Article;
import l.mr.mvvmfirebase.R;
import l.mr.mvvmfirebase.viewmodel.ArticleViewModel;

public class ArticleFragment extends Fragment {
    private RecyclerView recyclerView;

    public static ArticleFragment newInstance() {
        return new ArticleFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArticleViewModel viewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
        viewModel.getArticles().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable List<Article> articles) {
                recyclerView.setAdapter(new ArticleAdapter(articles));
            }
        });
    }
}

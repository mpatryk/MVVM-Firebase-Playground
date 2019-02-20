package l.mr.mvvmfirebase.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import l.mr.domain.entities.Article;
import l.mr.mvvmfirebase.R;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private final List<Article> list;

    public ArticleAdapter(List<Article> list) {
        this.list = list;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView price;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }

        public void bind(Article article) {
            Glide.with(itemView.getContext()).load(article.getImageUrl()).into(image);
            name.setText(article.getName());
            price.setText("$" + article.getPrice());
        }
    }
}

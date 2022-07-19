package maxson.com.br.maxsonnews.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import maxson.com.br.maxsonnews.databinding.HomeItemBinding;
import maxson.com.br.maxsonnews.domain.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> news;

    public NewsAdapter(List<News> news){
        this.news = news;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        HomeItemBinding binding = HomeItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = this.news.get(position);
        holder.binding.tvTitle.setText(news.getTitle());
        holder.binding.tvDescription.setText(news.getDescription());
    }

    @Override
    public int getItemCount() {
        return  this.news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final HomeItemBinding binding;

        public ViewHolder(HomeItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

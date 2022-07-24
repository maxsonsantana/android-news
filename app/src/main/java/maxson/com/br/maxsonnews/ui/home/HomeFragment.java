package maxson.com.br.maxsonnews.ui.home;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.Room;

import maxson.com.br.maxsonnews.data.local.AppDataBase;
import maxson.com.br.maxsonnews.databinding.FragmentHomeBinding;
import maxson.com.br.maxsonnews.ui.adapter.NewsAdapter;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private AppDataBase db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        db = Room.databaseBuilder(getContext(),
                        AppDataBase.class, "soccer-news")
                .allowMainThreadQueries()
                .build();

        binding.rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        homeViewModel.getNews().observe(getViewLifecycleOwner(), news -> {
            binding.rvHome.setAdapter(new NewsAdapter(news, updatedNews -> {
                //AsyncTask execute(() ->{
                    //db.newsDao().insert(updatedNews);
                //});
            }));
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
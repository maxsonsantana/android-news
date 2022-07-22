package maxson.com.br.maxsonnews.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import maxson.com.br.maxsonnews.data.remote.SoccerNewsApi;
import maxson.com.br.maxsonnews.domain.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private final SoccerNewsApi api;

    public HomeViewModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maxsonsantana.github.io/android-news-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       api = retrofit.create(SoccerNewsApi.class);
        this.findNews();
    }

    private void findNews() {
        api.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if(response.isSuccessful()){
                    news.setValue((response.body()));
                }else{
                    //TODO: Tratamento de erros
                }
            }
 
            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                //TODO: Tratamento de erros
            }
        });
    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}
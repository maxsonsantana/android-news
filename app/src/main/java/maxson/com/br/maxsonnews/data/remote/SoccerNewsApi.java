package maxson.com.br.maxsonnews.data.remote;

import java.util.List;

import maxson.com.br.maxsonnews.domain.News;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SoccerNewsApi {
    @GET("news.json")
    Call<List<News>> getNews();
}

package maxson.com.br.maxsonnews.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;
import maxson.com.br.maxsonnews.domain.News;

public class HomeViewModel extends ViewModel {

    public final MutableLiveData<List<News>> news;

    public HomeViewModel() {
        this.news = new MutableLiveData<>();

        //TODO: Remover Mock de Notícias
        List<News> news = new ArrayList<>();
        news.add(new News("Manchester joga com 7 jogadores a menos", "Jogando com 7 jogadores a manos, o Manchester vence Pato Branco fora de casa!!"));
        news.add(new News("Ronaldo Volta para Real Madri", "Por falta de Dinheiro, Real Madri contrata Ronaldo pagando 1 salário mínimo(R$1.200,00)"));
        news.add(new News("Ronaldinho Gaúcho joga pelo Corinthians", "Sem nada pra fazer Ronaldinho gaúcho resolve jogar no Corinthians"));

        this.news.setValue(news);

    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}
package e.aman.moviesapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import e.aman.moviesapp.models.Search
import e.aman.moviesapp.repositories.MovieRepo
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var movieRepo = MovieRepo()
    var movieList = MutableLiveData<Search>()

    /** calling api in background thread to get movies **/
    fun getMovies(title: String){
        viewModelScope.launch(IO) {
            movieList.postValue(movieRepo.getMovies(title))
        }
    }

}
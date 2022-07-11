package e.aman.moviesapp.repositories

import android.util.Log
import e.aman.moviesapp.models.Search
import e.aman.moviesapp.network.ApiInterface
import e.aman.moviesapp.network.RetrofitHelper
import e.aman.moviesapp.utils.Constants

class MovieRepo {

    suspend fun getMovies(title: String) : Search? {
        val api = RetrofitHelper.getInstance().create(ApiInterface::class.java)
        return api.getMovies(Constants.API_KEY , title , Constants.TYPE).body()
    }

}
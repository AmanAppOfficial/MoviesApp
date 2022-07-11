package e.aman.moviesapp.network

import e.aman.moviesapp.models.Search
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/")
    suspend fun getMovies(@Query("apikey") apiKey: String, @Query("s") title: String, @Query("type") type: String) : Response<Search>
}
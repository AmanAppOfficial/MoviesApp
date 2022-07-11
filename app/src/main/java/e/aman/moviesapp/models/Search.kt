package e.aman.moviesapp.models

import com.google.gson.annotations.SerializedName

data class Search(

    @SerializedName("Search")
    var searchResults: ArrayList<Movie>,
    @SerializedName("totalResults")
    var count: String,
    @SerializedName("Response")
    var response: String

)
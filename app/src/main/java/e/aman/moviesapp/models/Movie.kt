package e.aman.moviesapp.models

import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("Title")
    var title: String,
    @SerializedName("Year")
    var year: String,
    @SerializedName("imdbID")
    var id: String,
    @SerializedName("Type")
    var type: String,
    @SerializedName("Poster")
    var image: String

)
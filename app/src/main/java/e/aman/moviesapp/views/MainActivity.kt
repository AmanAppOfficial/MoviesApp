package e.aman.moviesapp.views

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import e.aman.moviesapp.adapters.MoviesAdapter
import e.aman.moviesapp.databinding.ActivityMainBinding
import e.aman.moviesapp.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //register view model
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setUpViewModel()
        setUpListeners()

    }

    private fun setUpListeners() {

        binding.searchBtn.setOnClickListener{
            if(!binding.moviesText.text.isNullOrBlank()){
                //call api
                viewModel.getMovies(binding.moviesText.text.toString().trim())
                binding.progressLayout.visibility = View.VISIBLE
                binding.notFoundTextview.visibility = View.GONE
                binding.moviesRecyclerview.visibility = View.GONE

                //close keyboard
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED , 0);
            }
        }

    }

    private fun setUpViewModel() {

        val gridLayoutManager = GridLayoutManager(applicationContext, 3)
        gridLayoutManager.orientation = LinearLayoutManager.VERTICAL;
        binding.moviesRecyclerview.layoutManager = gridLayoutManager

        //observe view model
        viewModel.movieList.observe(this){
            binding.progressLayout.visibility = View.GONE
            if(it.searchResults!=null && it.searchResults.size > 0){
                val adapter = MoviesAdapter(applicationContext,it.searchResults)
                binding.moviesRecyclerview.adapter = adapter
                binding.moviesRecyclerview.visibility = View.VISIBLE
                binding.notFoundTextview.visibility = View.GONE
                adapter.notifyDataSetChanged()
            }
            else{
                binding.notFoundTextview.visibility = View.VISIBLE
                binding.moviesRecyclerview.visibility = View.GONE
            }

        }
    }
}
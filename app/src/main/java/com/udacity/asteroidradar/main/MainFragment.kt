package com.udacity.asteroidradar.main

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.databinding.FragmentMainBinding
import com.udacity.asteroidradar.domain.Asteroid
import com.udacity.asteroidradar.domain.PictureOfDay

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this,MainViewModelFactory(activity.application)).get(MainViewModel::class.java)
    }

    private var viewModelAdapter : AsteroidAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.asteroidsTodayOnwardsList.observe(viewLifecycleOwner, Observer<List<Asteroid>> { asteroids ->
            asteroids?.apply {
                viewModelAdapter?.asteroids = asteroids
            }
        })

    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding : FragmentMainBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_main, container,false)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        setHasOptionsMenu(true)

        viewModelAdapter = AsteroidAdapter(AsteroidClick {
            val action = MainFragmentDirections.actionShowDetail(it)
            view?.findNavController()?.navigate(action)
        })

        binding.root.findViewById<RecyclerView>(R.id.asteroid_recycler).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = viewModelAdapter
        }

        return binding.root
    }




    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.show_this_week_asteroids->{
                viewModel.asteroidForThisWeek.observe(viewLifecycleOwner, Observer {
                    it?.apply {
                        viewModelAdapter?.asteroids = it
                    }
                })
                return true
            }
            R.id.show_today_onwards_asteroids->{
                viewModel.asteroidsTodayOnwardsList.observe(viewLifecycleOwner, Observer {
                    it?.apply {
                        viewModelAdapter?.asteroids = it
                    }
                })
                return true
            }
            R.id.show_all_asteroids->{
                viewModel.asteroidsList.observe(viewLifecycleOwner, Observer<List<Asteroid>> { asteroids ->
                    asteroids?.apply {
                        viewModelAdapter?.asteroids = asteroids
                    }
                })
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

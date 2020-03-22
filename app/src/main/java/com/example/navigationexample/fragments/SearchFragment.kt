package com.example.navigationexample.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationexample.R
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.fragment_search.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NextFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NextFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* searchButton?.setOnClickListener {
            findNavController().navigate(R.id.)
        }*/
        searchButton.setOnClickListener {
            findNavController().navigate(R.id.searchResultFragment)
        }


        val navView: BottomNavigationView = view.findViewById(R.id.nav_view)


        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {

                    toast("First item click")
                    findNavController().navigate(R.id.searchFragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_settings-> {

                    toast("second item click")
                    findNavController().navigate(R.id.settingFragment)
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)




    /*  val navView: BottomNavigationView = view.findViewById(R.id.nav_view)

      val navController = findNavController(view.findViewById(R.id.nav_view))
      // Passing each menu ID as a set of Ids because each
      // menu should be considered as top level destinations.
      val appBarConfiguration = AppBarConfiguration(setOf(
          R.id.navigation_home, R.id.navigation_notifications))
      setupActionBarWithNavController(navController, appBarConfiguration)
      navView.setupWithNavController(navController)*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NextFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NextFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

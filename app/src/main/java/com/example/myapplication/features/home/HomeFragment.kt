package com.example.myapplication.features.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.transaction
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.features.profile.ProfileFragment
import java.util.logging.Level
import java.util.logging.Logger

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    // try https://developer.android.com/reference/kotlin/androidx/fragment/app/package-summary#extension-functions-summary
    private lateinit var viewModel: HomeViewModel
    lateinit var showListButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        bind()
    }

    private fun bind() {
        viewModel.currentName.observe(this, Observer<String> { updatedName ->
            Logger.getGlobal().log(Level.INFO, "Updated name = ${updatedName}")
        })
        viewModel.currentName.value = "Aymen"

        view?.findViewById<Button>(R.id.showListButton)?.setOnClickListener {
            fragmentManager?.transaction {
                replace(
                    R.id.container,
                    UserListFragment.newInstance()
                )
            }
        }

        view?.findViewById<Button>(R.id.showProfileButton)?.setOnClickListener {
            fragmentManager?.transaction {
                replace(
                    R.id.container,
                    ProfileFragment.newInstance()
                )
            }
        }
    }

}

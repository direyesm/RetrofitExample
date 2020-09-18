package com.example.retrofitexample.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.retrofitexample.R
import com.example.retrofitexample.model.Terrain
import com.example.retrofitexample.viewmodel.MarsViewModel
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), MarsAdapter.Mars {

    lateinit var mViewModel: MarsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(MarsViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mRecyclerView = recyclerView
        val mAdapter = MarsAdapter(this)

        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = GridLayoutManager(context, 2)

       mViewModel.exposeLiveDataFromDatabase().observe(viewLifecycleOwner, Observer {
            mAdapter.updateListMars(it)
       })


        }

    override fun passMars(mTerrain: Terrain) {
        TODO("Not yet implemented")
    }
}

package com.abadil.convart.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.abadil.convart.FragmentListViewModelFactory
import com.abadil.convart.R
import com.abadil.convart.adapters.MyRecyclerViewAdapter
import com.abadil.convart.database.MetricPointDB
import com.abadil.convart.database.MetricPointRepo
import com.abadil.convart.databinding.FragmentListBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentList.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentList : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //Binding object
    private lateinit var binding: FragmentListBinding
    //Reference to the ViewModel
    private lateinit var fragmentListVm: FragmentListViewModel
    // Reference to the Recyclerview adapter
    private lateinit var pointsListRecyclerViewAdapter: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        //Setting up the database
        val metricPointDao = MetricPointDB.getInstance(container!!.context).metricCoordDao
        val repo = MetricPointRepo(metricPointDao)
        val factory = FragmentListViewModelFactory(repo)
        fragmentListVm = ViewModelProvider(this, factory).get(FragmentListViewModel::class.java)
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            listVM = fragmentListVm
        }
        activity?.setTitle(R.string.list_title)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerview()
        watchEmptyFields()
    }

    private fun displayPoints(){
        fragmentListVm.points.observe(viewLifecycleOwner, Observer {
            pointsListRecyclerViewAdapter = MyRecyclerViewAdapter(it)
            binding.pointsRecyclerview.adapter = pointsListRecyclerViewAdapter
        })
    }

    private fun initRecyclerview(){
        binding.pointsRecyclerview.layoutManager = LinearLayoutManager(context)
        binding.pointsRecyclerview.setHasFixedSize(true)
        displayPoints()
        setupSwipeToDelete()
    }

    // Setting up the swipe to delete on the recyclerview
    private fun setupSwipeToDelete(){
        val mIth = ItemTouchHelper(
                object : ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
                    override fun onMove(recyclerView: RecyclerView,
                                        viewHolder: ViewHolder, target: ViewHolder): Boolean {
                        val fromPos = viewHolder.adapterPosition
                        val toPos = target.adapterPosition
                        // move item in `fromPos` to `toPos` in adapter.
                        return true // true if moved, false otherwise
                    }

                    override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
                        // remove from adapter
                        fragmentListVm.delete(pointsListRecyclerViewAdapter.getPointAtPosition(viewHolder.adapterPosition))

                    }
                }).attachToRecyclerView(binding.pointsRecyclerview)
    }

    // Display a toast if the user leaves an empty field
    private fun watchEmptyFields(){
        fragmentListVm.isEmpty.observe(viewLifecycleOwner, { isEmpty ->
            isEmpty?.apply {
                if (this) {
                    Toast.makeText(context, R.string.add_point_error, Toast.LENGTH_SHORT).show()
                    fragmentListVm.resetError()
                }
            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentList.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
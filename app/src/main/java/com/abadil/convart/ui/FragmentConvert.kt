package com.abadil.convart.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.abadil.convart.FragmentListViewModelFactory
import com.abadil.convart.adapters.PointsSpinnerAdapter
import com.abadil.convart.data.MetricPoint
import com.abadil.convart.database.MetricPointDB
import com.abadil.convart.database.MetricPointRepo
import com.abadil.convart.databinding.FragmentConvertBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentConvert.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentConvert : Fragment() {
    //Binding object
    private lateinit var binding: FragmentConvertBinding
    //Reference to the ViewModel
    private lateinit var metricPointVm: FragmentListViewModel

    private lateinit var selectedPointOrigine: MetricPoint
    private lateinit var selectedPointCible: MetricPoint

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val metricPointDao = MetricPointDB.getInstance(container!!.context).metricCoordDao
        val repo = MetricPointRepo(metricPointDao)
        val factory = FragmentListViewModelFactory(repo)
        metricPointVm = ViewModelProvider(this, factory).get(FragmentListViewModel::class.java)

        binding = FragmentConvertBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSpinner()
    }

    private fun initSpinner(){
        metricPointVm.points.observe(viewLifecycleOwner, {
            val pointsSpinnerAdapter = PointsSpinnerAdapter(context!!, it)
            binding.pointOrigine.adapter = pointsSpinnerAdapter
            binding.pointOrigine.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    selectedPointOrigine = parent?.getItemAtPosition(position) as MetricPoint
                }

            }
            binding.pointCible.adapter = pointsSpinnerAdapter
            binding.pointCible.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    selectedPointCible = parent?.getItemAtPosition(position) as MetricPoint

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
         * @return A new instance of fragment FragmentConvert.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentConvert().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
package com.abadil.convart.ui

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.abadil.convart.FragmentListViewModelFactory
import com.abadil.convart.R
import com.abadil.convart.adapters.MyRecyclerViewAdapter
import com.abadil.convart.data.MetricPoint
import com.abadil.convart.database.MetricPointDB
import com.abadil.convart.database.MetricPointRepo
import com.abadil.convart.databinding.FragmentListBinding
import com.google.android.material.snackbar.Snackbar


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

    // snackbar where to display the error for the polar coordinates
    private lateinit var snackbarError: Snackbar

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
    ): View {
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
        setupSnackbar(view)
        initRecyclerview()
        watchEmptyFields()
    }

    private fun initRecyclerview() {
        binding.pointsRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

        displayPoints()
        setupSwipeToDelete()
    }

    private fun displayPoints() {
        fragmentListVm.points.observe(viewLifecycleOwner, {
            pointsListRecyclerViewAdapter = MyRecyclerViewAdapter(it as MutableList<MetricPoint>)
            binding.pointsRecyclerview.adapter = pointsListRecyclerViewAdapter
        })
    }

    // Setting up the swipe to delete on the recyclerview
    private fun setupSwipeToDelete() {
        ItemTouchHelper(
                object : ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT) {
                    override fun onMove(recyclerView: RecyclerView,
                                        viewHolder: ViewHolder, target: ViewHolder): Boolean {
                        return false
                    }

                    override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
                        val swippedPointPosition = viewHolder.adapterPosition
                        val swippedPoint = pointsListRecyclerViewAdapter.getPointAtPosition(swippedPointPosition)
                        val dialogBuilder = setupDeleteDialogConfirmation(swippedPoint)
                        dialogBuilder.apply {
                            setPositiveButton(getString(R.string.alertdialog_confirm_delete)){ _, _ ->
                                fragmentListVm.delete(swippedPoint)
                                pointsListRecyclerViewAdapter.notifyItemRemoved(swippedPointPosition)
                             }
                            dialogBuilder.setNegativeButton(getString(R.string.alertdialog_cancel_delete)){ _, _ ->
                                pointsListRecyclerViewAdapter.apply {
                                    undoDelete(swippedPoint, swippedPointPosition)
                                }
                            }
                            create()
                            show()
                        }
                    }
                }
        ).attachToRecyclerView(binding.pointsRecyclerview)
    }

    // Display a toast if the user leaves an empty field
    private fun watchEmptyFields() {
        fragmentListVm.isEmpty.observe(viewLifecycleOwner, { isEmpty ->
            isEmpty?.apply {
                if (this) {
                    snackbarError.show()
                    fragmentListVm.resetError()
                }
            }
        })
    }

    private fun setupSnackbar(view: View) {
        snackbarError = Snackbar.make(view, R.string.add_point_error, Snackbar.LENGTH_SHORT)
        // get snackbar view
        val mView: View = snackbarError.view
        mView.setBackgroundColor(ContextCompat.getColor(context!!, R.color.snackbar_background))
        // get textview inside snackbar view
        val mTextView = mView.findViewById<View>(com.google.android.material.R.id.snackbar_text) as TextView
        mTextView.setTextColor(ContextCompat.getColor(context!!, R.color.snackbar_text))
        // set text to center
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) mTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER
        else mTextView.gravity = Gravity.CENTER_HORIZONTAL
    }

    private fun setupDeleteDialogConfirmation(point: MetricPoint): AlertDialog.Builder {
        val builder = AlertDialog.Builder(context!!)

        val confirmationMsg = "Supprimer <b>${point._id}</b>?"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            builder.setMessage(Html.fromHtml(confirmationMsg, Html.FROM_HTML_MODE_LEGACY))
        } else {

            builder.setMessage(Html.fromHtml(confirmationMsg))
        }
        builder.apply {
            setTitle(getString(R.string.alertdialog_delete_confirmation_title))
            setIcon(R.drawable.ic_delete_red)
            setCancelable(false)
        }
        return builder
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
package com.example.ecommerce.ui.fragment.chart

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.utils.Fragment
import com.example.ecommerce.viewmodel.PriceProductViewModel
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import kotlinx.android.synthetic.main.fragment_chart.*
import kotlinx.android.synthetic.main.toolbar.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.util.ArrayList

val dates = mutableListOf<String>()

class ChartFragment : Fragment() {
    private val priceProductViewModel: PriceProductViewModel by viewModel { parametersOf(id) }
    private var args: ChartFragmentArgs? = null

    var id: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args = arguments?.let { ChartFragmentArgs.fromBundle(it) }
        id = args?.product?.id

        "Price Chart".also { text_toolbar.text = it }
        image_back.setOnClickListener {
            it.findNavController().popBackStack()
        }
        priceProductViewModel.priceProductLiveData.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                val values: MutableList<Entry> = ArrayList()
                for (i in it.indices) {
                    values.add(Entry(i.toFloat(), it[i].price.toFloat()))
                    dates.add(it[i].create_at)
                }
                val lineDataSet = LineDataSet(values, "Price Chart").apply {
                    color = ContextCompat.getColor(requireContext(), R.color.dark_red)
                    lineWidth = 3f
                    valueTextSize = 11f
                    valueTextColor = ContextCompat.getColor(requireContext(), R.color.black)
                    setCircleColor(ContextCompat.getColor(requireContext(), R.color.black))
                    fillColor = ContextCompat.getColor(requireContext(), R.color.light_black)
                    setDrawFilled(true)
                    fillDrawable = ContextCompat.getDrawable(
                        requireContext(), R.drawable.gradiant_chart
                    )
                }
                val iLineDataSet: MutableList<ILineDataSet> = ArrayList()
                iLineDataSet.add(lineDataSet)
                val lineData = LineData(iLineDataSet)
                chart.data = lineData
                val xAxis = chart.xAxis
                xAxis.labelCount = 4
                xAxis.valueFormatter = MyXAxisFormatter()
                chart.animateX(500)
                chart.invalidate()

            }


        }
        priceProductViewModel.progressbarLiveData.observe(viewLifecycleOwner) {
            progress(it)
        }
    }

    class MyXAxisFormatter : ValueFormatter() {
        override fun getAxisLabel(value: Float, axis: AxisBase?): String {
            return dates.getOrNull(value.toInt()) ?: value.toString()
        }
    }


}
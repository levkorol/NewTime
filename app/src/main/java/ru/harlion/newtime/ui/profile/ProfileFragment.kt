package ru.harlion.newtime.ui.profile

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.databinding.FragmentProfileBinding
import ru.harlion.newtime.ui.profile.premium.PremiumFragment
import ru.harlion.newtime.utils.replaceFragment

class ProfileFragment : BindingFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    var radarData: RadarData? = null
    private lateinit var radarDataSet: RadarDataSet
    var radarEntries = mutableListOf<RadarEntry>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicks()

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#4DD0E1"))

        getEntries()
        radarDataSet = RadarDataSet(radarEntries, "")
        radarData = RadarData(radarDataSet)
        binding.radarChart.data = radarData

        radarDataSet.colors = colors
        radarDataSet.valueTextColor = Color.TRANSPARENT
        radarDataSet.valueTextSize = 0f
        radarDataSet.label = ""


    }

    private fun initClicks() {
        binding.menuPro.setOnClickListener {
            replaceFragment(PremiumFragment(), true)
        }
    }


    private fun getEntries() {

        radarEntries.add(RadarEntry(0f, 0.21f))
        radarEntries.add(RadarEntry(1f, 0.12f))
        radarEntries.add(RadarEntry(2f, 0.20f))
        radarEntries.add(RadarEntry(3f, 0.52f))
        radarEntries.add(RadarEntry(4f, 0.29f))

    }
}
package com.example.newyorktimesapp.ui.mostpopular

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.newyorktimesapp.R
import com.example.newyorktimesapp.entities.mostpopular.MostPopularType
import com.example.newyorktimesapp.entities.mostpopular.TimePeriod
import kotlinx.android.synthetic.main.frg_most_popular.*
import kotlinx.android.synthetic.main.merge_progress.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MostPopularFragment : Fragment() {

    private val mostPopularVM: MostPopularVM by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frg_most_popular, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeData()
        observeLoadingState()
        showSettingsMenu()

        mostPopularVM.type = MostPopularType.EMAILED
    }

    private fun observeLoadingState() {
        mostPopularVM.loadingState.observe(viewLifecycleOwner, {
            frm_progress.isVisible = it
        })
    }

    private fun observeData() {
        mostPopularVM.data.observe(viewLifecycleOwner, {

        })
    }

    private fun showSettingsMenu() {
        iv_settings.setOnClickListener {
            val popup = PopupMenu(requireContext(), it)
            popup.menuInflater.inflate(R.menu.most_popular_settings, popup.menu)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.emailed -> mostPopularVM.type = MostPopularType.EMAILED
                    R.id.viewed -> mostPopularVM.type = MostPopularType.VIEWED
                    R.id.shared -> mostPopularVM.type = MostPopularType.SHARED
                    R.id._1_day -> mostPopularVM.timePeriod = TimePeriod.ONE_DAY
                    R.id._7_day -> mostPopularVM.timePeriod = TimePeriod.SEVEN_DAYS
                    R.id._30_day -> mostPopularVM.timePeriod = TimePeriod.THIRTY_DAYS
                }
                true
            }
            popup.show()
        }
    }
}
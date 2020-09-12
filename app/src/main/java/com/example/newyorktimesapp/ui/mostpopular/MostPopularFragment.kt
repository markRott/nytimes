package com.example.newyorktimesapp.ui.mostpopular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.newyorktimesapp.KEY_URL
import com.example.newyorktimesapp.R
import com.example.newyorktimesapp.entities.mostpopular.MostPopularType
import com.example.newyorktimesapp.entities.mostpopular.TimePeriod
import com.example.newyorktimesapp.ui.mostpopular.adapter.ArticleClickPayload
import com.example.newyorktimesapp.ui.mostpopular.adapter.MostPopularAdapter
import kotlinx.android.synthetic.main.frg_most_popular.*
import kotlinx.android.synthetic.main.merge_progress.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MostPopularFragment : Fragment() {

    private val mostPopularVM: MostPopularVM by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.frg_most_popular, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcv_most_popular.adapter = adapter

        observeArticlesData()
        observeLoadingState()
        observeFavoriteIds()

        showSettingsMenu()
        mostPopularVM.fetchFavoriteIds()
        mostPopularVM.type = MostPopularType.EMAILED
    }

    private fun observeLoadingState() {
        mostPopularVM.loadingState.observe(viewLifecycleOwner) {
            frm_progress.isVisible = it
        }
    }

    private fun observeArticlesData() {
        mostPopularVM.data.observe(viewLifecycleOwner) {
            adapter.setArticleItems(it.results)
        }
    }

    private fun observeFavoriteIds() {
        mostPopularVM.favoriteIds.observe(viewLifecycleOwner) {
            adapter.setFavoriteItems(it)
        }
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

    private val adapter: MostPopularAdapter = MostPopularAdapter { data ->
        when (data) {
            is ArticleClickPayload.ArticleAction -> { }
            is ArticleClickPayload.CommentsAction -> { openCommentsFragment(data) }
            is ArticleClickPayload.FavoriteAction -> { favoriteAction(data) }
        }
    }

    private fun openCommentsFragment(data: ArticleClickPayload.CommentsAction) {
        val bundle = bundleOf(KEY_URL to data.model.url)
        findNavController().navigate(R.id.commentsFragment, bundle)
    }

    private fun favoriteAction(data: ArticleClickPayload.FavoriteAction) {
        mostPopularVM.favoriteAction(data.favoriteState, data.model)
    }
}
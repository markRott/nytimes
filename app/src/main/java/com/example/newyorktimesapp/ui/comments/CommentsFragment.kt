package com.example.newyorktimesapp.ui.comments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.newyorktimesapp.KEY_URL
import com.example.newyorktimesapp.R
import com.example.newyorktimesapp.ui.comments.adapter.CommentsAdapter
import com.example.newyorktimesapp.utils.PaginationStatus
import com.example.newyorktimesapp.utils.showToast
import kotlinx.android.synthetic.main.frg_comments.*
import kotlinx.android.synthetic.main.merge_progress.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CommentsFragment : Fragment() {

    private val commentsVM: CommentsVM by viewModel()
    private val adapter: CommentsAdapter = CommentsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.frg_comments, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcv_comments.adapter = adapter

        setupArticleUrl()
        backAction()

        subscribeToComments()
        subscribeToLoadingState()
    }

    private fun setupArticleUrl() {
        val url = arguments?.getString(KEY_URL) ?: ""
        commentsVM.articleUrl = url
    }

    private fun backAction() {
        iv_back.setOnClickListener { findNavController().popBackStack() }
    }

    private fun subscribeToComments() {
        commentsVM.commentsLD.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun showNoCommentsView() {
        rcv_comments.isVisible = false
        tv_no_comments_label.isVisible = true
    }

    private fun subscribeToLoadingState() {
        commentsVM.paginationStatusLD.observe(viewLifecycleOwner) {
            when (it) {
                is PaginationStatus.Loading -> frm_progress.isVisible = true
                is PaginationStatus.NotEmpty -> frm_progress.isVisible = false
                is PaginationStatus.Empty -> emptyAction()
                is PaginationStatus.Error -> {
                    frm_progress.isVisible = false
                    requireContext().showToast(it.errorMsg)
                }
            }
        }
    }

    private fun emptyAction() {
        frm_progress.isVisible = false
        if (adapter.itemCount == 0) {
            showNoCommentsView()
        }
    }
}
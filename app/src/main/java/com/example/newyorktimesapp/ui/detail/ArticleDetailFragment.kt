package com.example.newyorktimesapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.newyorktimesapp.KEY_TITLE
import com.example.newyorktimesapp.KEY_URL
import com.example.newyorktimesapp.R
import kotlinx.android.synthetic.main.frg_article_detail.*
import kotlinx.android.synthetic.main.frg_article_detail.iv_back

class ArticleDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.frg_article_detail, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        backAction()
        setupTitle()
        loadPage()
    }

    private fun setupTitle() {
        val title = arguments?.getString(KEY_TITLE) ?: ""
        tv_title.text = title
    }

    private fun loadPage() {
        val articleUrl = arguments?.getString(KEY_URL) ?: ""
        if (articleUrl.isNotEmpty()) {
            wv_article_detail.loadUrl(articleUrl)
        }
    }

    private fun backAction() {
        iv_back.setOnClickListener { findNavController().popBackStack() }
    }
}
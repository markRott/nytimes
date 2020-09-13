package com.example.newyorktimesapp.ui.comments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.newyorktimesapp.KEY_URL
import com.example.newyorktimesapp.R
import com.example.newyorktimesapp.ui.comments.adapter.CommentsAdapter
import kotlinx.android.synthetic.main.frg_comments.*
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
        val url = arguments?.getString(KEY_URL) ?: ""
        commentsVM.articleUrl = url
        iv_back_from_comments.setOnClickListener { findNavController().popBackStack() }

        commentsVM.commentsLD.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }
}
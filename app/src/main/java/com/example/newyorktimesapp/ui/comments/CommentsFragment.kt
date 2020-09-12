package com.example.newyorktimesapp.ui.comments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.newyorktimesapp.KEY_URL
import com.example.newyorktimesapp.R
import kotlinx.android.synthetic.main.frg_comments.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CommentsFragment : Fragment() {

    private val commentsVM: CommentsVM by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.frg_comments, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments?.getString(KEY_URL) ?: ""
        println("url = $url")

        iv_back_from_comments.setOnClickListener { findNavController().popBackStack() }
    }
}
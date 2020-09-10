package com.example.newyorktimesapp.ui.mostpopular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newyorktimesapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MostPopularFragment : Fragment() {

    private val mostPopularVM: MostPopularVM by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        mostPopularVM = ViewModelProviders.of(this).get(MostPopularVM::class.java)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        mostPopularVM.text.observe(viewLifecycleOwner, {
//            textView.text = it
//        })

        return inflater.inflate(R.layout.frg_most_popular, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mostPopularVM.testFetch()
    }
}
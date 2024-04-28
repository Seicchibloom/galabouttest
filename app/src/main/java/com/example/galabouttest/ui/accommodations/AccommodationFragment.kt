package com.example.galabouttest.ui.accommodations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.galabouttest.databinding.FragmentAccommodationBinding

class AccommodationFragment : Fragment() {

    private var _binding: FragmentAccommodationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val accommodationViewModel =
            ViewModelProvider(this).get(AccommodationViewModel::class.java)

        _binding = FragmentAccommodationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.AATitle
        accommodationViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
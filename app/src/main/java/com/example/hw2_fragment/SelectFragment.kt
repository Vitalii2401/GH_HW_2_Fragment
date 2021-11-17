package com.example.hw2_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.hw2_fragment.databinding.FragmentSelectBinding

class SelectFragment : Fragment() {
    lateinit var binding: FragmentSelectBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnGermany.setOnClickListener {
            dataModel.message.value = "Germany"
        }

        binding.btnItaly.setOnClickListener {
            dataModel.message.value = "Italy"
        }

        binding.btnFrance.setOnClickListener {
            dataModel.message.value = "France"
        }

        binding.btnAmerica.setOnClickListener {
            dataModel.message.value = "America"
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SelectFragment()
    }
}
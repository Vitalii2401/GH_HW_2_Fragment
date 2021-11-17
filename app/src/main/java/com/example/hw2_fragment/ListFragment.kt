package com.example.hw2_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.hw2_fragment.databinding.FragmentListBinding

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    private val dataModel: DataModel by activityViewModels()
    var name = arrayOf("")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        dataModel.message.observe(activity as LifecycleOwner, {
            name = when(it){
                "Germany" -> resources.getStringArray(R.array.Germany_auto)
                "Italy" -> resources.getStringArray(R.array.Italy_auto)
                "France" -> resources.getStringArray(R.array.France_auto)
                "America" -> resources.getStringArray(R.array.American_auto)
                else -> arrayOf("")
            }
            val adapter = context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, name) }
            binding.listView.adapter = adapter
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}
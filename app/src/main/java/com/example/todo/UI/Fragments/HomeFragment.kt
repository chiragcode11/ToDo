package com.example.todo.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.todo.R
import com.example.todo.UI.Adapter.NotesAdapter
import com.example.todo.databinding.FragmentHomeBinding
import com.example.todo.viewmodel.NotesViewModel

class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding
    val viewmodel : NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewmodel.getnotes().observe(viewLifecycleOwner) { noteslist ->

            binding.rcview.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.rcview.adapter = NotesAdapter(requireContext(), noteslist)

        }

        binding.floatbtn.setOnClickListener(){
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_notesFragment)
        }

        return binding.root
    }
}

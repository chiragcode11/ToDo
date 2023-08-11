package com.example.todo.UI.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todo.Model.Notes
import com.example.todo.R
import com.example.todo.databinding.FragmentNotesBinding
import com.example.todo.viewmodel.NotesViewModel

import java.util.*


class NotesFragment : Fragment() {

    lateinit var binding : FragmentNotesBinding
    var priority : String = "1"
    val viewmodel : NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentNotesBinding.inflate(layoutInflater,container,false)
        binding.red.setImageResource(R.drawable.baseline_done_24)



        binding.red.setOnClickListener(){
            priority = "1"
            binding.red.setImageResource(R.drawable.baseline_done_24)
            binding.yellow.setImageResource(0)
            binding.green.setImageResource(0)
        }
        binding.yellow.setOnClickListener(){
            priority = "2"
            binding.yellow.setImageResource(R.drawable.baseline_done_24)
            binding.red.setImageResource(0)
            binding.green.setImageResource(0)
        }
        binding.green.setOnClickListener(){
            priority = "3"
            binding.green.setImageResource(R.drawable.baseline_done_24)
            binding.yellow.setImageResource(0)
            binding.red.setImageResource(0)

        }

        binding.floatbtn.setOnClickListener()
        {
            createnotes(it)
        }


        return binding.root
    }

    private fun createnotes(it: View?) {
        val title = binding.title.text.toString()
        val subtitle = binding.subtitle.text.toString()
        val description = binding.description .text.toString()

        val d = Date()
        val notesdate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)
        val data = Notes(null,
            title = title,
        subtitle = subtitle,
        notes = description,
        date = notesdate as String,
        priority)
        viewmodel.addnotes(data)

        Toast.makeText(requireContext(), "Created Successfully", Toast.LENGTH_LONG).show()

        Navigation.findNavController(it!!).navigate(R.id.action_notesFragment_to_homeFragment)
    }
}
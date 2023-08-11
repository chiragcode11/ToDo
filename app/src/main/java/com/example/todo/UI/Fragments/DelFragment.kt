package com.example.todo.UI.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.todo.Model.Notes
import com.example.todo.R
import com.example.todo.databinding.FragmentDelBinding
import com.example.todo.viewmodel.NotesViewModel
import java.util.*

class DelFragment : Fragment() {

    val notes by navArgs<DelFragmentArgs>()
    lateinit var binding: FragmentDelBinding
    var priority : String = "1"
    val viewmodel : NotesViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentDelBinding.inflate(layoutInflater, container, false)


        binding.title1.setText(notes.data.title)
        binding.subtitle1.setText(notes.data.subtitle)
        binding.description1.setText(notes.data.notes)

        when (notes.data.priority){
            "1" ->{
                priority = "1"
                binding.red.setImageResource(R.drawable.baseline_done_24)
                binding.yellow.setImageResource(0)
                binding.green.setImageResource(0)            }
            "2" ->{
                priority = "3"
                binding.green.setImageResource(R.drawable.baseline_done_24)
                binding.yellow.setImageResource(0)
                binding.red.setImageResource(0)
            }
            "3" ->{
                priority = "3"
                binding.green.setImageResource(R.drawable.baseline_done_24)
                binding.yellow.setImageResource(0)
                binding.red.setImageResource(0)
            }
        }

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

        binding.floatbtn1.setOnClickListener(){
            updatenotes(it)
        }
        return binding.root
    }

    private fun updatenotes(it : View) {
        val title = binding.title1.text.toString()
        val subtitle = binding.subtitle1.text.toString()
        val description = binding.description1.text.toString()

        val d = Date()
        val notesdate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)
        val data = Notes(
            notes.data.id,
            title = title,
            subtitle = subtitle,
            notes = description,
            date = notesdate as String,
            priority)
        viewmodel.updatenotes(data)

        Toast.makeText(requireContext(), "Updated Successfully", Toast.LENGTH_LONG).show()

        Navigation.findNavController(it!!).navigate(R.id.action_editFragment_to_homeFragment)
    }
}

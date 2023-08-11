package com.example.todo.UI.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.Model.Notes
import com.example.todo.R
import com.example.todo.UI.Fragments.HomeFragment
import com.example.todo.UI.Fragments.HomeFragmentDirections
import com.example.todo.databinding.ItemNotesBinding

class NotesAdapter(val requireContext: Context, val noteslist: List<Notes>) : RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {
    class notesViewHolder(val binding : ItemNotesBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun getItemCount() = noteslist.size



    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {

        val data = noteslist[position]
        holder.binding.tiele2.text = noteslist[position].title
        holder.binding.subtitle2.text = noteslist[position].subtitle
        holder.binding.date.text = noteslist[position].date

        when (noteslist[position].priority){
            "1" ->{
                holder.binding.redot1.setBackgroundResource(R.drawable.red_dot)
            }
            "2" ->{
                holder.binding.redot1.setBackgroundResource(R.drawable.yellow_dot)

            }
            "3" ->{
                holder.binding.redot1.setBackgroundResource(R.drawable.green_dot)

            }
        }

        holder.binding.root.setOnClickListener(){
            val action = HomeFragmentDirections.actionHomeFragmentToEditFragment(data)
            Navigation.findNavController(it).navigate(action)
        }

    }
}
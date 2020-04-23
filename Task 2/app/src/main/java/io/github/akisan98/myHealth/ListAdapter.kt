package io.github.akisan98.myHealth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter (val symtomsList: ArrayList<Symtoms>) : RecyclerView.Adapter<ListAdapter.ViewHolder>()
{
    class ViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView)
    {
        val symtomsDesc = itemView.findViewById(R.id.textView24) as TextView
        val symtomValue = itemView.findViewById(R.id.textView25) as TextView
    }

    override fun onCreateViewHolder(v: ViewGroup, i: Int): ViewHolder {
        val eleView = LayoutInflater.from(v.context).inflate(R.layout.symtoms_card, v, false)
        return ViewHolder(eleView)
    }

    override fun onBindViewHolder(v: ViewHolder, i: Int) {
        val symtoms: Symtoms = symtomsList[i]

        v.symtomsDesc.text = symtoms.symtom
        v.symtomValue.text = symtoms.value.toString()
    }

    override fun getItemCount(): Int {
        return symtomsList.size
    }
}
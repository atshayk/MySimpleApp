package com.example.mysimpleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemberAdapter(private var memberList: MutableList<String>) :
    RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {
    fun addMember(memberName: String){
        memberList.add(memberName)
        notifyItemInserted(memberList.size - 1)
    }

    override fun getItemCount(): Int = memberList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_member, parent, false)
        return MemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        val memberName = memberList[position]
        holder.bind(memberName)
    }

    class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val memberNameText: TextView = itemView.findViewById(R.id.textViewMemberName)
        private val memberImage: ImageView = itemView.findViewById(R.id.imageViewMember)

        fun bind(memberName: String) {
            memberNameText.text = memberName
            memberImage.setImageResource(R.drawable.ic_launcher_foreground)
        }
    }
}




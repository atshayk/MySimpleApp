package com.example.mysimpleapp

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.mysimpleapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var memberList: MutableList<String>
    private lateinit var memberAdapter: MemberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize member list and adapter
        memberList = mutableListOf()
        memberAdapter = MemberAdapter(memberList)

        // Find ListView and set adapter
        val listView = findViewById<ListView>(R.id.memberListView)
        listView.adapter = memberAdapter

        binding.fab.setOnClickListener {
            showAddMemberDialog()
        }
    }

    fun showAddMemberDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_add_member, null)
        val editText = dialogView.findViewById<EditText>(R.id.editTextMemberName)

        builder.setView(dialogView)
            .setTitle("Add Member")
            .setPositiveButton("Add") { _, _ ->
                val name = editText.text.toString().trim()
                if (name.isNotEmpty()) {
                    memberList.add(name)
                    memberAdapter.notifyDataSetChanged()
                }
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }

        builder.create().show()
    }

    inner class MemberAdapter(private val members: List<String>) : BaseAdapter() {
        override fun getCount(): Int = members.size
        override fun getItem(position: Int): String = members[position]
        override fun getItemId(position: Int): Long = position.toLong()
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val view = convertView ?: LayoutInflater.from(parent?.context)
                .inflate(R.layout.item_member, parent, false)
            val memberName = members[position]
            val nameTextView = view.findViewById<TextView>(R.id.textViewMemberName)
            val imageView = view.findViewById<ImageView>(R.id.imageViewMember)

            nameTextView.text = memberName

            Glide.with(this@HomeActivity)
                .load("https://fastly.picsum.photos/id/0/367/267.jpg?hmac=7vvdjNHaShwe3Ul3DAaQIBBz0RnNLfUcEaCV-94NNLE")
                .placeholder(android.R.drawable.presence_invisible)
                .circleCrop()
                .into(imageView)

            return view
        }
    }
}
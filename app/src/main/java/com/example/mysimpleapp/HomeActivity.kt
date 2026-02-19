package com.example.mysimpleapp

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.mysimpleapp.databinding.ActivityHomeBinding
import androidx.recyclerview.widget.LinearLayoutManager

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var memberAdapter: MemberAdapter
    private val memberList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        memberAdapter = MemberAdapter(memberList)
        binding.memberListView.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = memberAdapter
        }

        binding.fab.setOnClickListener{
            showAddMemberDialog()
        }
    }

    private fun showAddMemberDialog(){
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_add_member, null)
        val editText = dialogView.findViewById<EditText>(R.id.editTextMemberName)

        AlertDialog.Builder(this)
            .setTitle("Add Member")
            .setView(dialogView)
            .setPositiveButton("Add") { dialog, _ ->
                val memberName = editText.text.toString()
                if (memberName.isNotEmpty()) {
                    memberAdapter.addMember(memberName)
                }
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
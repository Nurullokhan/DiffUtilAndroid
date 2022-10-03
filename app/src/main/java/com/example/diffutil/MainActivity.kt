package com.example.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diffutil.adapters.MyDiffUtilAdapter
import com.example.diffutil.databinding.ActivityMainBinding
import com.example.diffutil.models.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userList: ArrayList<User>
    private lateinit var adapter: MyDiffUtilAdapter

    private var count: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userList = ArrayList()
        adapter = MyDiffUtilAdapter()
        adapter.submitList(userList)
        binding.recyclerView.adapter = adapter


        binding.save.setOnClickListener {
            val name: String = binding.name.text.toString()
            val password: String = binding.password.text.toString()

            val user = User(count++, name, password)
            userList.add(user)
            adapter.submitList(userList)
            binding.recyclerView.adapter = adapter
        }
    }
}
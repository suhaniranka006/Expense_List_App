package com.example.expense_list_app

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.exp

class MainActivity : AppCompatActivity() {

    private lateinit var expenseAdapter: ExpenseAdapter
    private var expenses = mutableListOf<Expense>()
    private var idCounter = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val btnAdd = findViewById<Button>(R.id.btnAdd)

        expenseAdapter = ExpenseAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter=expenseAdapter

        //initial list
        expenses.add(Expense(idCounter++,"Groceries",1200.0,"28 aug 2025"))
        expenses.add(Expense(idCounter++,"Electricity bill",800.0,"27 aug 2025"))
        expenseAdapter.submitList(expenses.toList())

        //button click - add new expnese
        btnAdd.setOnClickListener {
            expenses.add(Expense(idCounter++,"New Expnese",500.0,"28 aug 2025"))
            expenseAdapter.submitList(expenses.toList())  //diffutil handle krega
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
package com.example.expense_list_app

import androidx.recyclerview.widget.DiffUtil

class ExpenseDiffUtilCallback:DiffUtil.ItemCallback<Expense>() {
    override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean {
        return oldItem.id == newItem.id //id same to item same
    }

    override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean {
        return oldItem == newItem  //purana content match ho to same
    }
}
package com.example.module_2_lesson_6_hw_3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_edit.view.*
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter(val context: Context, val contacts: ArrayList<Contact>,
                     val callback: ContactsListCallback) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.avatar.setImageBitmap(contacts[position].avatar)
        holder.name.text = contacts[position].name
        holder.lastName.text = contacts[position].lastName
        holder.suffix.text = contacts[position].suffix
        holder.email.text = contacts[position].email
        holder.root.setOnClickListener {
            callback.onItemSelected(contacts[position])
        }
        holder.btEditItem.setOnClickListener {
            callback.onEditListSelected(contacts[position])
        }
        holder.btDeleteItem.setOnClickListener {
            callback.onDeleteItem(position, contacts)
        }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}

class ViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView){
    val avatar = itemView.ivAvatarContact
    val name = itemView.tvNameContact
    val lastName = itemView.tvLastNameContact
    val suffix = itemView.tvSuffixContact
    val email = itemView.tvEmailContact
    val root = itemView.clRootContactItem
    val btEditItem = itemView.btEditContactsItemList
    val btDeleteItem = itemView.btDeleteContactsItemList
}

interface ContactsListCallback{
    fun onItemSelected(item: Contact)
    fun onEditListSelected(item: Contact)
    fun onDeleteItem(index: Int, list: ArrayList<Contact>)
}
package com.example.module_2_lesson_6_hw_3

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.time.Duration.Companion.seconds

class MainActivity : AppCompatActivity(), ContactsListCallback{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvContactsList.adapter = ContactAdapter(this, getContacts(), this)
        rvContactsList.layoutManager = LinearLayoutManager(this)

        

    }

    fun getContacts(): ArrayList<Contact>{
        val contacts = ArrayList<Contact>()

        contacts.add(Contact(BitmapFactory.decodeResource(resources, R.drawable.friends_1), "Ivan",
            "Kozak", "Doctor", "ivankozak@mail.com", "+380935699859"))
        contacts.add(Contact(BitmapFactory.decodeResource(resources, R.drawable.friends_2), "Mykola",
            "Kozak", "Chemist", "mykolakozak@mail.com", "+380932555639"))
        contacts.add(Contact(BitmapFactory.decodeResource(resources, R.drawable.friends_3), "Illia",
            "Kozak", "Engineer", "illiakozak@mail.com", "+380937488984"))
        contacts.add(Contact(BitmapFactory.decodeResource(resources, R.drawable.friends_4), "Tima",
            "Kozak", "Lawyer", "timakozak@mail.com", "+380933569522"))
        contacts.add(Contact(BitmapFactory.decodeResource(resources, R.drawable.friends_5), "Mykyta",
            "Kozak", "Scientist", "mykytakozak@mail.com", "+380932555841"))
        return  contacts
    }

    override fun onItemSelected(item: Contact) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.flDetails,DetailsFragment.newInstance(item))
            .addToBackStack(null)
            .commit()
    }

    override fun onEditListSelected(item: Contact) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.flDetails,EditFragment.newInstance(item))
            .addToBackStack(null)
            .commit()

    }

    override fun onDeleteItem(index: Int, list: ArrayList<Contact>) {
        list.removeAt(index)
        rvContactsList.adapter?.notifyItemRemoved(index)
        rvContactsList.adapter?.notifyDataSetChanged()
    }
}
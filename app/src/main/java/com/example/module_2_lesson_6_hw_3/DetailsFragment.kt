package com.example.module_2_lesson_6_hw_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {
    private var contact: Contact? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvName.text = contact?.name
        tvLastName.text = contact?.lastName
        tvSuffix.text = contact?.suffix
        tvPhoneNumber.text = contact?.phoneNumber
        tvEmail.text = contact?.email
        ivAvatar.setImageBitmap(contact?.avatar)
    }

    companion object {
        @JvmStatic
        fun newInstance(contact: Contact) =
            DetailsFragment().apply {
                this.contact = contact
            }
    }
}
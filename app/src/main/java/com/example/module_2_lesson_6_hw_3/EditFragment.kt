package com.example.module_2_lesson_6_hw_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.fragment_edit.*

class EditFragment : Fragment() {

    private var contact: Contact? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivAvatarEdit.setImageBitmap(contact?.avatar)
        etNameEdit.setText(contact?.name)
        etLastNameEdit.setText(contact?.lastName)
        etSuffixEdit.setText(contact?.suffix)
        etPhoneNumberEdit.setText(contact?.phoneNumber)
        etEmailEdit.setText(contact?.email)

        btSaveEdit.setOnClickListener {
            Toast.makeText(requireContext(),"Saved",Toast.LENGTH_SHORT).show()

            contact?.name = etNameEdit.text.toString()
            contact?.lastName = etLastNameEdit.text.toString()
            contact?.suffix = etSuffixEdit.text.toString()
            contact?.phoneNumber = etPhoneNumberEdit.text.toString()
            contact?.email = etEmailEdit.text.toString()

            if (activity != null){
                requireActivity().tvName.text = etNameEdit.text.toString()
                requireActivity().tvLastName.text = etLastNameEdit.text.toString()
                requireActivity().tvSuffix.text = etSuffixEdit.text.toString()
                requireActivity().tvPhoneNumber.text = etPhoneNumberEdit.text.toString()
                requireActivity().tvEmail.text = etEmailEdit.text.toString()

                requireActivity().rvContactsList.adapter?.notifyDataSetChanged()
                requireActivity().supportFragmentManager.popBackStackImmediate()
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(item: Contact?) =
            EditFragment().apply {
                this.contact = item
            }
    }
}

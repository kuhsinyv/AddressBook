package ink.gxy.android.addressbook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import ink.gxy.android.addressbook.databinding.ContactListItemBinding

class ContactAdapter(
    private val context: Context,
    private val contacts: List<Contact>,
) : BaseAdapter() {
    override fun getCount(): Int {
        return contacts.size
    }

    override fun getItem(position: Int): Any {
        return contacts[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding: ContactListItemBinding = if (convertView == null) DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.contact_list_item,
            parent,
            false
        ) else DataBindingUtil.getBinding<ContactListItemBinding>(convertView)!!
        binding.contact = contacts[position]
        return binding.root
    }

}
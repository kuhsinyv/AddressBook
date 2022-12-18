package ink.gxy.android.addressbook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import ink.gxy.android.addressbook.databinding.ContactListItemBinding

/**
 * 自定义 Adapter 类（继承自 BaseAdapter）
 *
 * @property context 应用上下文
 * @property contacts ListView 数据源
 */
class ContactAdapter(
    private val context: Context,
    private val contacts: List<Contact>,
) : BaseAdapter() {
    private val inflater = LayoutInflater.from(context)

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
        // 使用 Data Binding 并且复用 convertView 和 inflater
        // 如果 convertView 不为 null 则复用已创建的 convertView 对象
        val binding: ContactListItemBinding = if (convertView == null) DataBindingUtil.inflate(
            inflater,
            R.layout.contact_list_item,
            parent,
            false
        ) else DataBindingUtil.getBinding(convertView)!!
        // 将数据绑定到 data field
        binding.contact = contacts[position]
        return binding.root
    }

}
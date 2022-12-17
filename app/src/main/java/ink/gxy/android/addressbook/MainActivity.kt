package ink.gxy.android.addressbook

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ink.gxy.android.addressbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter = ContactAdapter(applicationContext, ContactRepository.fetch())
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.adapter = adapter
        binding.listview.let {
            it.setOnItemClickListener { _, _, i, _ ->
                it.setSelector(R.color.purple_200)
                Toast.makeText(applicationContext, "选中了第 ${i + 1} 位联系人", Toast.LENGTH_SHORT).show()
            }
            it.setOnScrollListener(ContactOnScrollListener(applicationContext, adapter))
        }
    }
}
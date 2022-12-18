package ink.gxy.android.addressbook

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ink.gxy.android.addressbook.databinding.ActivityMainBinding

/**
 * 入口 Activity 类
 *
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 实例化 ListView 的 Adapter
        val adapter = ContactAdapter(applicationContext, ContactRepository.fetch())
        // 实例化 Data Binding
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        // 将实例化的 Adapter 绑定到 data field
        binding.adapter = adapter
        binding.listview.let {
            // 监听单击事件
            it.setOnItemClickListener { _, _, i, _ ->
                // 高亮选中的联系人
                it.setSelector(R.color.purple_200)
                // 操作反馈提示
                Toast.makeText(applicationContext, "选中了第 ${i + 1} 位联系人", Toast.LENGTH_SHORT).show()
            }
            // 监听滚动事件
            it.setOnScrollListener(ContactOnScrollListener(applicationContext, adapter))
        }
    }
}
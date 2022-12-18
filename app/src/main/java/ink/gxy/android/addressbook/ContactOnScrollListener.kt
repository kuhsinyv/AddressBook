package ink.gxy.android.addressbook

import android.content.Context
import android.widget.AbsListView
import android.widget.AbsListView.OnScrollListener
import android.widget.Toast

/**
 * 滚动事件监听器
 *
 * @property context 应用上下文
 * @property adapter ListView Adapter
 */
class ContactOnScrollListener(
    private val context: Context,
    private val adapter: ContactAdapter
) : OnScrollListener {
    override fun onScrollStateChanged(view: AbsListView, scrollState: Int) {
        if (scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
            // 滚动到底部时触发事件
            if (view.lastVisiblePosition == view.count - 1) {
                onScrollToBottom()
            }
        }
    }

    override fun onScroll(p0: AbsListView?, p1: Int, p2: Int, p3: Int) = Unit

    private fun onScrollToBottom() {
        // 增加一条数据到 Repository 中
        ContactRepository.add()
        // 通知数据源发生变化
        adapter.notifyDataSetChanged()
        Toast.makeText(context, "已增加一条联系人数据", Toast.LENGTH_SHORT).show()
    }

}
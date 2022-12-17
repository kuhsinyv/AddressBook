package ink.gxy.android.addressbook

import android.content.Context
import android.widget.AbsListView
import android.widget.AbsListView.OnScrollListener
import android.widget.Toast

class ContactOnScrollListener(
    private val context: Context,
    private val adapter: ContactAdapter
) : OnScrollListener {
    override fun onScrollStateChanged(view: AbsListView, scrollState: Int) {
        if (scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
            if (view.lastVisiblePosition == view.count - 1) {
                ContactRepository.add()
                adapter.notifyDataSetChanged()
                Toast.makeText(context, "已增加一条联系人数据", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onScroll(p0: AbsListView?, p1: Int, p2: Int, p3: Int) = Unit

}
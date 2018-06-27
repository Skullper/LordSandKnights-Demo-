package skullper.world.selector.utils.decoration

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import skullper.world.selector.R
import skullper.world.selector.extensions.getDimens

/**
 * Created by pugman on 27.06.18.
 * Contact the developer - sckalper@gmail.com
 * company - A2Lab
 */

class VerticalItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?,
                                state: RecyclerView.State?) {
        parent?.let {
            if (it.getChildAdapterPosition(view) == 0) {
                outRect?.top = getDimens(R.dimen.layout_margin)
            }
        }
        outRect?.bottom = getDimens(R.dimen.half_layout_margin)
    }
}
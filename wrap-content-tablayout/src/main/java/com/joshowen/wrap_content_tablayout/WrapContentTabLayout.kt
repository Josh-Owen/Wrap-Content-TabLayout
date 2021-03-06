package com.joshowen.wrap_content_tablayout

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.allViews
import androidx.core.view.updateLayoutParams
import androidx.databinding.BindingAdapter
import com.google.android.material.tabs.TabLayout

class WrapContentTabLayout(context: Context, attrs: AttributeSet?) : TabLayout(context, attrs) {

    //region Constructor
    init {

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.WrapContentTabLayout)

        val wrappedTabIndexesReference = attributes.getResourceId(R.styleable.WrapContentTabLayout_wrapSelectedTabs, WRAPPED_INDEXES_REFERENCE_NOT_FOUND)

        if (wrappedTabIndexesReference != WRAPPED_INDEXES_REFERENCE_NOT_FOUND) {
            wrappedTabsIndexes = resources.getIntArray(wrappedTabIndexesReference).toTypedArray()
        }

        shouldWrapAllTabs = attributes.getBoolean(R.styleable.WrapContentTabLayout_wrapAllTabs, false)

        attributes.recycle()

    }

    //endregion

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        if (shouldWrapAllTabs) {
            this.wrapAllTabs()
        } else {
            wrappedTabsIndexes?.let {
                this.wrapSelectedTabs(it)
            }
        }
    }

    //region Companion-Object
    companion object {

        //region Variables
        const val WRAPPED_INDEXES_REFERENCE_NOT_FOUND = -1

        private var shouldWrapAllTabs: Boolean = false
        private var wrappedTabsIndexes: Array<Int>? = null
        //endregion

        @JvmStatic
        @BindingAdapter("wrapSelectedTabs")
        fun TabLayout.wrapSelectedTabs(wrappedTabIndexes: Array<Int>) {
            for (index in wrappedTabIndexes) {
                val view = (this.getChildAt(0) as LinearLayout).getChildAt(index)
                val layoutParams = view.layoutParams as LinearLayout.LayoutParams
                layoutParams.weight = 0.0f
                layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT
                view.layoutParams = layoutParams
            }
            this@Companion.wrappedTabsIndexes = wrappedTabIndexes
        }

        @JvmStatic
        @BindingAdapter("wrapAllTabs")
        fun TabLayout.wrapAllTabs(shouldWrapAllTabs: Boolean = true) {
            if (shouldWrapAllTabs) {
                for (item in this.allViews) {
                    item.updateLayoutParams {
                        width = LinearLayout.LayoutParams.WRAP_CONTENT
                    }
                }
            }
            this@Companion.shouldWrapAllTabs = shouldWrapAllTabs
        }
    }
    //endregion
}

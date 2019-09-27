package com.gurcanataman.clickablespannexample

import android.graphics.Color
import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View

class SpecialClickableSpan(
    private val text: String,
    private val listener: IClickSpannableListener,
    private val starts: Int,
    private val ends: Int,
    private val isCumle:Boolean
) : ClickableSpan() {

    override fun onClick(view: View) {
        if(isCumle){
            listener.onClickCumle(text, starts, ends)
        }else{
            listener.onClickKelime(text,starts,ends)
        }

    }

    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.color = Color.rgb(23,36,48)
        ds.isUnderlineText = false
    }
}

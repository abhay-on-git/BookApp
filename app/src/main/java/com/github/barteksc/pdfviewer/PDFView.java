package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class PDFView extends View {
    public PDFView(Context context) {
        this(context, null);
    }

    public PDFView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PDFView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void fromUri(String url) {
    }
}

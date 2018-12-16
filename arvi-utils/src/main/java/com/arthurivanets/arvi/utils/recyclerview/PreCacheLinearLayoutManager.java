/*
 * Copyright 2017 Arthur Ivanets, arthur.ivanets.l@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.arthurivanets.arvi.utils.recyclerview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A {@link LinearLayoutManager} with support for the Item View pre-caching.
 */
public class PreCacheLinearLayoutManager extends LinearLayoutManager implements HasPreCachingSupport {


    private int extraLayoutSpace = -1;




    public PreCacheLinearLayoutManager(Context context) {
        super(context);
    }




    public PreCacheLinearLayoutManager(Context context,
                                       int orientation,
                                       boolean reverseLayout) {
        super(
            context,
            orientation,
            reverseLayout
        );
    }




    public PreCacheLinearLayoutManager(Context context,
                                       AttributeSet attrs,
                                       int defStyleAttr,
                                       int defStyleRes) {
        super(
            context,
            attrs,
            defStyleAttr,
            defStyleRes
        );
    }




    @Override
    public final void setExtraLayoutSpace(int extraLayoutSpace) {
        this.extraLayoutSpace = extraLayoutSpace;
    }




    @Override
    protected final int getExtraLayoutSpace(RecyclerView.State state) {
        return ((this.extraLayoutSpace > 0) ? this.extraLayoutSpace : super.getExtraLayoutSpace(state));
    }




}

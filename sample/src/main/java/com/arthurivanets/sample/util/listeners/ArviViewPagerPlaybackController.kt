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

package com.arthurivanets.sample.util.listeners

import androidx.viewpager.widget.ViewPager
import com.arthurivanets.sample.util.extensions.ifCanManagePlayback
import com.arthurivanets.sample.util.extensions.ifFragmentPagerAdapter

open class ArviViewPagerPlaybackController(private var viewPager : ViewPager?) : OnPageChangeListenerAdapter() {


    override fun onPageScrollStateChanged(state : Int) {
        if((viewPager != null) && (state == ViewPager.SCROLL_STATE_IDLE)) {
            viewPager!!.adapter?.ifFragmentPagerAdapter {
                getItem(viewPager!!.currentItem)?.ifCanManagePlayback {
                    startPlayback()
                }
            }
        }
    }


    fun recycle() {
        viewPager = null
    }


}
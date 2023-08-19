package uz.frodo.paymeclick

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ClickAdapter(var list:ArrayList<Page>,fr:FragmentManager):FragmentPagerAdapter(fr,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return ClickFragment.newInstance(list[position],position)
    }

}
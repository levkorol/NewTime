package ru.harlion.newtime.ui.profile.on_boarding


import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import ru.harlion.newtime.AppActivity
import ru.harlion.newtime.R
import ru.harlion.newtime.base.BindingFragment
import ru.harlion.newtime.base.BindingHolder
import ru.harlion.newtime.databinding.FragmentOnBoardingBinding
import ru.harlion.newtime.databinding.ItemOnBoardingBinding
import ru.harlion.newtime.ui.main.MainFragment
import ru.harlion.newtime.utils.Prefs
import ru.harlion.newtime.utils.replaceFragment

private typealias ItemHolder = BindingHolder<ItemOnBoardingBinding>
class OnBoardingFragment :
    BindingFragment<FragmentOnBoardingBinding>(FragmentOnBoardingBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextButton.setOnClickListener {
            val next = binding.onBoardingViewPager.currentItem + 1
            if (next == binding.onBoardingViewPager.adapter!!.itemCount) {
                parentFragmentManager.popBackStack()
                val prefs = Prefs(requireContext())
                prefs.isShowOnBoarding = true
                replaceFragment(MainFragment(), false)
            } else {
                binding.onBoardingViewPager.setCurrentItem(
                    next,
                    true
                )
            }
        }

        binding.onBoardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, offset: Float, offsetPx: Int) {
                val rv = binding.onBoardingViewPager.getChildAt(0) as RecyclerView

                val center = rv.findViewHolderForAdapterPosition(position) as ItemHolder?
                val right = rv.findViewHolderForAdapterPosition(position + 1) as ItemHolder?

                center?.binding?.titleTv?.translationX = offsetPx / 3f
                right?.binding?.titleTv?.translationX = offsetPx * (1-offset) / -3f
            }
        })

        binding.onBoardingViewPager.adapter = object : RecyclerView.Adapter<ItemHolder>() {
            private val images = intArrayOf(
                R.drawable.image_on_boarding_one,
                R.drawable.image_on_boarding_two,
                R.drawable.image_on_boarding_three,
                R.drawable.image_on_boarding_for,
                R.drawable.image_on_boarding_five
            )

            private val textTitle = intArrayOf(
                R.string.on_boarding_one,
                R.string.on_boarding_two,
                R.string.on_boarding_three,
                R.string.on_boarding_for,
                R.string.on_boarding_five
            )

//            private val textDesc = intArrayOf(
//                R.string.on_boarding_one_description,
//                R.string.on_boarding_two_description,
//                R.string.on_boarding_three_description
//            )


            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder =
                ItemHolder(ItemOnBoardingBinding::inflate, parent).apply {

                }


            override fun onBindViewHolder(holder: ItemHolder, position: Int) {
                holder.binding.apply {
                    imageIv.setImageResource(images[position])
                    titleTv.setText(textTitle[position])
                    // descriptionTv.setText(textDesc[position])
                }
            }

            override fun getItemCount(): Int = images.size
        }

        binding.dotsIndicator.setViewPager2(binding.onBoardingViewPager)
    }

    override fun onStart() {
        super.onStart()
        (activity as AppActivity).setBottomNavigationVisible(false)
    }

    override fun onStop() {
        super.onStop()
        (activity as AppActivity).setBottomNavigationVisible(true)
    }

}
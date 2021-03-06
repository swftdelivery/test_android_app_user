package com.gox.app.ui.onboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.databinding.ViewDataBinding
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.novoda.spritz.Spritz
import com.gox.basemodule.base.BaseActivity
import com.gox.app.R
import com.gox.app.databinding.ActivityOnBoardBinding
import com.gox.app.ui.signin.SignInActivity
import com.gox.app.ui.signup.SignupActivity


class OnBoardActivity : BaseActivity<ActivityOnBoardBinding>()
        , OnBoardNavigator, ViewPager.OnPageChangeListener {
    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float
                                , positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
    }

    private lateinit var mViewDataBinding: ActivityOnBoardBinding
    private lateinit var spritz: Spritz
    private lateinit var viewPager: ViewPager
    private val PAGE_COUNT = 3
    private var dotsCount: Int = 0
    private var dots: Array<ImageView>? = null
    private val onBoardItems = java.util.ArrayList<OnBoardItem>()
    private var mIndicator: CircleIndicator? = null


    override fun getLayoutId(): Int {
        return R.layout.activity_on_board
    }

    override fun initView(mViewDataBinding: ViewDataBinding?) {

        this.mViewDataBinding = mViewDataBinding as ActivityOnBoardBinding
        val onBoardViewModel = OnBoardViewModel()
        onBoardViewModel.navigator = this

        mViewDataBinding.viewModel = onBoardViewModel
        mViewDataBinding!!.executePendingBindings()

        val list = ArrayList<WalkThrough>()
        list.add(WalkThrough(R.drawable.bg_walk_one,
                getString(R.string.walk_1), getString(R.string.walk_1_description)))
        list.add(WalkThrough(R.drawable.bg_walk_two,
                getString(R.string.walk_2), getString(R.string.walk_2_description)))
        list.add(WalkThrough(R.drawable.bg_walk_three,
                getString(R.string.walk_3), getString(R.string.walk_3_description)))
        viewPager = mViewDataBinding.viewpagerOnboard

        viewPager.adapter = MyViewPagerAdapter(this, list)
        viewPager.currentItem = 0
        viewPager.addOnPageChangeListener(this)
//       mViewDataBinding.onboardPageIndicatorView.setViewPager(viewPager)
        mIndicator = findViewById(R.id.indicator)

        loadAdapter();

    }

    fun loadAdapter() {

        val header = intArrayOf(R.string.walk_1, R.string.walk_2
                , R.string.walk_3)
        val desc = intArrayOf(R.string.walk_1_description
                , R.string.walk_2_description, R.string.walk_3_description)
        val imageId = intArrayOf(R.drawable.bg_walk_one
                , R.drawable.bg_walk_two, R.drawable.bg_walk_three)

        for (i in imageId.indices) {
            val item = OnBoardItem()
            item.imageID = imageId[i]
            item.title = (resources.getString(header[i]))
            item.description = (resources.getString(desc[i]))
            onBoardItems.add(item)
        }

        viewPager.adapter = IntroSliderAdapter(this, onBoardItems)
//        viewPager.setPageTransformer(true, IntroSliderTransformation())
        mIndicator!!.setViewPager(viewPager)
        viewPager.setCurrentItem(0)
    }

    private fun lerp(startValue: Float, endValue: Float, f: Float): Float {
        return startValue + f * (endValue - startValue)
    }


    override fun goToSignIn() {
        openNewActivity(this@OnBoardActivity, SignInActivity::class.java, false)
    }

    override fun goToSignUp() {
        openNewActivity(this@OnBoardActivity, SignupActivity::class.java, false)

    }

}

class MyViewPagerAdapter internal constructor(internal var context: Context, internal var list: List<WalkThrough>) : PagerAdapter() {

    override fun getCount(): Int {
        return list.size
    }


    @NonNull
    override fun instantiateItem(@NonNull container: ViewGroup, position: Int): Any {
        val itemView = LayoutInflater.from(container.context).inflate(R.layout.pager_item, container, false)
        val walk = list[position]

        val title = itemView.findViewById<TextView>(R.id.title)
        val description = itemView.findViewById<TextView>(R.id.description)
        val imageView = itemView.findViewById<ImageView>(R.id.img_pager_item)

        title.setText(walk.title)
        description.setText(walk.description)
        Glide.with(context).load(walk.drawable).into(imageView)
        container.addView(itemView)

        return itemView
    }

    override fun isViewFromObject(@NonNull view: View, @NonNull obj: Any): Boolean {
        return view === obj
    }

    override fun destroyItem(@NonNull container: ViewGroup, position: Int, @NonNull `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}

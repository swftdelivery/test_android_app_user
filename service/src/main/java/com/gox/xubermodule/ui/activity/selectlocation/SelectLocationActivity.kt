package com.gox.xubermodule.ui.activity.selectlocation

import android.content.Intent
import android.text.TextUtils
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.gox.basemodule.base.BaseActivity
import com.gox.xubermodule.R
import com.gox.xubermodule.data.model.Addresses
import com.gox.xubermodule.data.model.XuberServiceClass
import com.gox.xubermodule.databinding.ActivitySelectLocationBinding
import com.gox.xubermodule.ui.activity.locationpick.ServiceLocationPickActivity
import com.gox.xubermodule.ui.activity.provierlistactivity.ProvidersActivity
import com.gox.xubermodule.ui.activity.xubersubserviceactivity.XuberSubServiceActivity
import kotlinx.android.synthetic.main.activity_select_location.*
import kotlinx.android.synthetic.main.activity_service_location_pick.rlHomeAddressContainer
import kotlinx.android.synthetic.main.activity_service_location_pick.rlWorkAddressContainer
import kotlinx.android.synthetic.main.activity_service_location_pick.tvHomeAddress
import kotlinx.android.synthetic.main.activity_service_location_pick.tvWorkAddress
import kotlinx.android.synthetic.main.toolbar_service_category.*

class SelectLocationActivity : BaseActivity<ActivitySelectLocationBinding>(), SelectLocationNavigator {

    private lateinit var activitySelectLocationBinding: ActivitySelectLocationBinding
    private lateinit var selectLocationViewModel: SelectLocationViewModel
    private lateinit var mAddressList: ArrayList<Addresses>
    override fun getLayoutId() = R.layout.activity_select_location

    override fun initView(mViewDataBinding: ViewDataBinding?) {
        selectLocationViewModel = SelectLocationViewModel()
        activitySelectLocationBinding = mViewDataBinding as ActivitySelectLocationBinding
        activitySelectLocationBinding.selectLocationViewModel = selectLocationViewModel
        selectLocationViewModel.navigator = this
        ivBack.setOnClickListener { onBackPressed() }
        service_name.text = getString(R.string.select_location)

        mAddressList = ArrayList()
        selectLocationViewModel.getAddressList()
        loadingObservable.value = true

        selectLocationViewModel.getAddressesResponse().observe(this, Observer {
            loadingObservable.value = false
            if (it != null) {
                if (it.statusCode == "200") {
                    mAddressList.addAll(it.responseData)
                    when (it.responseData.size) {
                        0 -> {
                            loc_txt.text = getString(R.string.no_saved_location)
                        }
                        else -> {
                            loc_txt.text = getString(R.string.saved_location)
                            mAddressList.forEach {
                                when (it.address_type) {
                                    "Home" -> {
                                        rlHomeAddressContainer.visibility = View.VISIBLE
                                        tvHomeAddress.text = "${if (TextUtils.isEmpty(it.flat_no)) "" else it.flat_no}" +
                                                " ${if (TextUtils.isEmpty(it.street)) "" else ", " + it.street}" +
                                                " ${if (TextUtils.isEmpty(it.city)) "" else ", " + it.city}" +
                                                " ${if (TextUtils.isEmpty(it.state)) "" else ", " + it.state}" +
                                                " ${if (TextUtils.isEmpty(it.county)) "" else ", " + it.county}"
                                        rlHomeAddressContainer.setTag(it.latitude + "," + it.longitude)
                                    }
                                    "Work" -> {
                                        rlWorkAddressContainer.visibility = View.VISIBLE
                                        tvWorkAddress.text = "${if (TextUtils.isEmpty(it.flat_no)) "" else it.flat_no}" +
                                                " ${if (TextUtils.isEmpty(it.street)) "" else ", " + it.street}" +
                                                " ${if (TextUtils.isEmpty(it.city)) "" else ", " + it.city}" +
                                                " ${if (TextUtils.isEmpty(it.state)) "" else ", " + it.state}" +
                                                " ${if (TextUtils.isEmpty(it.county)) "" else ", " + it.county}"
                                        rlWorkAddressContainer.setTag(it.latitude + "," + it.longitude)
                                    }
                                }
                            }
                        }
                    }
                }
            } else
                loc_txt.text = getString(R.string.no_saved_location)
        })

        rlHomeAddressContainer.setOnClickListener {
            val res = rlHomeAddressContainer.tag.toString().split(",")
            XuberServiceClass.sourceLat = res[0]
            XuberServiceClass.sourceLng = res[1]
            XuberServiceClass.address = tvHomeAddress.text.toString()
            gotoProviderListing()
        }
        rlWorkAddressContainer.setOnClickListener {
            val res = rlWorkAddressContainer.tag.toString().split(",")
            XuberServiceClass.sourceLat = res[0]
            XuberServiceClass.sourceLng = res[1]
            XuberServiceClass.address = tvWorkAddress.text.toString()
            gotoProviderListing()
        }
        loc_lt.setOnClickListener {
            val intent = Intent(this, ServiceLocationPickActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun gotoProviderListing() {
        val intent = Intent(this, ProvidersActivity::class.java)
        startActivity(intent)
        finish()
    }


    override fun onBackPressed() {
        openNewActivity(this, XuberSubServiceActivity::class.java, true)
    }
}

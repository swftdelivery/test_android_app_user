package com.gox.app.ui.myaccount_fragment

import android.content.DialogInterface
import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.gox.basemodule.BaseApplication
import com.gox.basemodule.base.BaseFragment
import com.gox.basemodule.data.PreferenceHelper
import com.gox.basemodule.data.clearAll
import com.gox.basemodule.common.payment.managepayment.ManagePaymentActivity
import com.gox.basemodule.utils.ViewCallBack
import com.gox.basemodule.utils.ViewUtils
import com.gox.basemodule.common.cardlist.ActivityCardList
import com.gox.app.R
import com.gox.app.databinding.FragmentMyaccountBinding
import com.gox.app.ui.invitereferals.InviteReferalsActivity
import com.gox.app.ui.language_setting.LanguageActivity
import com.gox.basemodule.common.manage_address.ManageAddressActivity
import com.gox.app.ui.onboard.OnBoardActivity
import com.gox.app.ui.privacypolicy.PrivacyPolicyActivity
import com.gox.app.ui.profile.ProfileActivity
import com.gox.app.ui.support.SupportActivity
import kotlinx.android.synthetic.main.fragment_myaccount.*

class MyAccountFragment : BaseFragment<FragmentMyaccountBinding>(), MyAccountFragmentNavigator {
    lateinit var mViewDataBinding: FragmentMyaccountBinding
    val preferenceHelper = PreferenceHelper(BaseApplication.baseApplication)
    val myAccountFragmentViewModel = MyAccountFragmentViewModel()
    override fun getLayoutId(): Int = R.layout.fragment_myaccount

    override fun initView(mRootView: View?, mViewDataBinding: ViewDataBinding?) {
        this.mViewDataBinding = mViewDataBinding as FragmentMyaccountBinding

        myAccountFragmentViewModel.navigator = this
        mViewDataBinding.myaccountfragmentviewmodel = myAccountFragmentViewModel
        (baseActivity).setSupportActionBar(mViewDataBinding.profileToolbar)
        setHasOptionsMenu(true)
        myAccountFragmentViewModel.successResponse.observe(this, Observer {
            if (it != null) {
                if (it.statusCode == "200") {
                    ViewUtils.showToast(activity!!, it.message, true)
                    preferenceHelper.clearAll()
                    openNewActivity(activity, OnBoardActivity::class.java, false)
                    baseActivity.finishAffinity()
                }
            }
        })

        toolbar_logo.setOnClickListener {
            logout()
        }
    }

    /*override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.myaccount_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.menu_logout -> {
                logout()
            }
        }
        return super.onOptionsItemSelected(item)
    }*/

    private fun logout() {
        ViewUtils.showAlert(baseActivity, R.string.xjek_logout_alert, object : ViewCallBack.Alert {
            override fun onPositiveButtonClick(dialog: DialogInterface) {
                myAccountFragmentViewModel.Logout()
                dialog.dismiss()
            }

            override fun onNegativeButtonClick(dialog: DialogInterface) {
                dialog.dismiss()
            }
        })
    }

    override fun goToProfile() {
        openNewActivity(activity, ProfileActivity::class.java, false)
    }

    override fun goToManageAddress() {
        //openNewActivity(activity, ManageAddressActivity::class.java, false)
        val intent = Intent(activity, ManageAddressActivity::class.java)
        intent.putExtra("changeAddressFlag", "0")
        startActivity(intent)

    }

    override fun goToPayment() {
        //openNewActivity(activity, ManagePaymentActivity::class.java, false)
        val intent = Intent(activity, ManagePaymentActivity::class.java)
        intent.putExtra("activity_result_flag", "0")
        startActivity(intent)
    }

    override fun goToInviteRefferals() {
        openNewActivity(activity, InviteReferalsActivity::class.java, false)
    }

    override fun gToprivacyPolicy() {
        openNewActivity(activity, PrivacyPolicyActivity::class.java, false)
    }

    override fun goToSupport() {
        openNewActivity(activity, SupportActivity::class.java, false)
    }

    override fun openLanguage() {
        openNewActivity(activity, LanguageActivity::class.java, false)
    }

    override fun goToCardList() {
        //openNewActivity(activity!!, ActivityCardList::class.java, false)

        val intent = Intent(activity, ActivityCardList::class.java)
        intent.putExtra("activity_result_flag", "0")
        startActivity(intent)
    }
}

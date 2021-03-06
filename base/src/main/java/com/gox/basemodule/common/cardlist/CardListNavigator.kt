package com.gox.basemodule.common.cardlist

import android.view.View

interface  CardListNavigator{
    fun addCard()
    fun cardPicked(stripeID: String, cardID: String, position: Int)
    fun removeCard()
    fun deselectCard()
    fun paymentType(type: Int)
    fun showErrorMsg(error: String)
    fun addAmount(view: View)
    fun changePaymentMode(paymentId:Int)
}
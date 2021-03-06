package com.gox.app.utils

import android.content.Context
import android.os.Environment
import android.util.Log
import com.gox.basemodule.data.Constant
import java.io.File
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

class CommanMethods {
    companion object {
        fun getDefaultFileName(context: Context): File {
            var imageFile: File? = null
            val isSDPresent = Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
            if (isSDPresent) { // External storage path
                imageFile = File(Environment.getExternalStorageDirectory().toString() + File.separator + Constant.TEMP_FILE_NAME + System.currentTimeMillis() + ".png")
            } else {  // Internal storage path
                imageFile = File(context.filesDir.toString() + File.separator + Constant.TEMP_FILE_NAME + System.currentTimeMillis() + ".png")
            }
            return imageFile
        }

        fun validateEmail(email: String): Boolean {
            val EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
            val pattern = Pattern.compile(EMAIL_PATTERN)
            val matcher = pattern.matcher(email)
            return email.length > 0 && matcher.matches()
        }

        fun validatePhone(phone: String): Boolean {
            if (phone.length >= 10) {
                Log.e("valid", "---" + phone)
                return true
            } else {
                return false
            }
        }


        fun getLocalTimeStamp(dateStr: String, request: String): String {
            val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            df.timeZone = TimeZone.getTimeZone("UTC")
            var date: Date? = null
            val localTime = ""
            var calendar: Calendar? = null
            var strDate = ""
            try {
                date = df.parse(dateStr)
                calendar = Calendar.getInstance(TimeZone.getDefault())
                calendar!!.time = date!!
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            val dayOfTheWeek = SimpleDateFormat("EEEE").format(date) // Thursday
            val day = SimpleDateFormat("dd").format(date) // 20
            val monthString = SimpleDateFormat("MMM").format(date) // Jun
            val monthNumber = SimpleDateFormat("MM").format(date) // 06
            val yearString = SimpleDateFormat("yy").format(date) // yy
            val fullYearString = SimpleDateFormat("yyyy").format(date) // yy
            val hours = SimpleDateFormat("hh").format(date) // 12
            val mins = SimpleDateFormat("mm").format(date) // 60
            val am_pm = SimpleDateFormat("a").format(date) // 60

            val year = calendar!!.get(Calendar.YEAR)

            Log.d("Date", day + "-" + dayOfTheWeek + "-" + monthString + "-" + monthNumber +
                    "-" + year + "/" + hours + ":" + mins + ":" + am_pm)

            if (request.equals("Req_Date_Month")) return day + " " + monthString
            if (request.equals("Req_Date_Month_year")) return day + " " + monthString + " " + yearString
            if (request.equals("Req_Date_Month_FullYear")) return day + " " + monthString + " " + fullYearString
            if (request.equals("Req_time")) return hours + ":" + mins + " " + am_pm

            val day_month = calendar!!.get(Calendar.DAY_OF_MONTH)
            val strMonth = SimpleDateFormat("MMM").format(calendar.time)

            if (strMonth != null) {
                strDate = Integer.toString(day_month) + "-" + strMonth + "-" + Integer.toString(year)
            }

            return strDate

        }
    }
}
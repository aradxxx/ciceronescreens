package com.github.aradxxx.ciceronescreen

import android.content.Intent
import android.net.Uri
import com.github.terrakok.cicerone.androidx.ActivityScreen

object ExternalApp {
    /**
     * Create screen with [Intent.ACTION_VIEW].
     *
     * @param url Target URL.
     * @param chooserTitle Chooser title if need wrap intent with [Intent.createChooser] or
     * null if you don't need it.
     *
     * @return [ActivityScreen] with [Intent.ACTION_VIEW] action.
     */
    fun browser(
        url: String,
        chooserTitle: String? = null
    ) = ActivityScreen {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        if (chooserTitle == null) {
            intent
        } else {
            Intent.createChooser(intent, chooserTitle)
        }
    }

    /**
     * Create screen with [Intent.ACTION_DIAL].
     *
     * @param phone Phone number.
     * @param chooserTitle Chooser title if need wrap intent with [Intent.createChooser] or
     * null if you don't need it.
     *
     * @return [ActivityScreen] with [Intent.ACTION_DIAL] action.
     */
    fun dialer(
        phone: String,
        chooserTitle: String? = null
    ) = ActivityScreen {
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
        if (chooserTitle == null) {
            intent
        } else {
            Intent.createChooser(intent, chooserTitle)
        }
    }

    /**
     * Create screen with [Intent.ACTION_SENDTO]
     *
     * @param addresses E-mail addresses that should be delivered to.
     * @param subject Subject line of a message.
     * @param text Text of a message.
     * @param chooserTitle Chooser title if need wrap intent with [Intent.createChooser] or
     * null if you don't need it.
     *
     * @return [ActivityScreen] with [Intent.ACTION_SENDTO] action.
     */
    fun email(
        addresses: Array<String>,
        subject: String = "",
        text: String = "",
        chooserTitle: String? = null
    ) = ActivityScreen {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject);
            putExtra(Intent.EXTRA_TEXT, text);
        }
        if (chooserTitle == null) {
            intent
        } else {
            Intent.createChooser(intent, chooserTitle)
        }
    }
}

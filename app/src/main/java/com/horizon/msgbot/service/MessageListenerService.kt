/**
 * Created by naijun on 2021/12/26
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package com.horizon.msgbot.service

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.widget.Toast
import com.caoccao.javet.interop.V8Host
import com.caoccao.javet.interop.V8Runtime
import com.caoccao.javet.values.reference.V8ValueArray
import com.caoccao.javet.values.reference.V8ValueFunction
import com.caoccao.javet.values.reference.V8ValueObject
import com.horizon.msgbot.setting.Constants
import java.util.*

class MessageListenerService : NotificationListenerService() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        if(sbn === null || Constants.allowPackageNames.find { sbn.packageName.startsWith(it) }.isNullOrEmpty()) return
        try {
            val extender: Notification.WearableExtender = Notification.WearableExtender(sbn.notification)
            for (action in extender.actions) {
                if (action.remoteInputs.isEmpty()) return
                if (
                    action.title.toString().lowercase(Locale.getDefault()).contains("reply") ||
                    action.title.toString().lowercase(Locale.getDefault()).contains("답장")
                ) {
                    val runtime: V8Runtime = V8Host.getNodeInstance().createV8Runtime();
//                    val obj: V8ValueObject = runtime.createV8ValueObject();
//                    obj.se
//                    val arr: V8ValueArray = runtime.createV8ValueArray();
//                    arr.push
//                    runtime.globalObject.get<V8ValueFunction>("onMessage").callVoid(null, )
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(applicationContext, e.toString(), Toast.LENGTH_LONG).show()
        }
    }
}
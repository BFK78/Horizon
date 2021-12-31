/**
 * Created by naijun on 2021/12/26
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package com.horizon.msgbot.bot

import com.caoccao.javet.interop.V8Host
import com.caoccao.javet.interop.V8Runtime

internal object RuntimeManager {
    val runtimes: HashMap<Number, V8Runtime> = hashMapOf()

    fun addRuntime() {
        var size: Int = runtimes.count()
        runtimes[++size] = V8Host.getNodeInstance().createV8Runtime()
    }
}
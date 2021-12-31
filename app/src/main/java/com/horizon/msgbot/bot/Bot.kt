package com.horizon.msgbot.bot

import com.caoccao.javet.interop.V8Host
import com.caoccao.javet.interop.V8Runtime
import com.caoccao.javet.values.reference.V8ValueFunction
import com.caoccao.javet.values.reference.V8ValueObject

object Bot {
    fun callJsOnMessage(
        data: V8ValueObject
    ) {
        for (data in RuntimeManager.runtimes) {
            data.value.globalObject.get<V8ValueFunction>("onMessage").callVoid(null, data);
        }
    }
}
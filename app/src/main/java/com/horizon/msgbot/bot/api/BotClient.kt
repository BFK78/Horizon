/**
 * Created by naijun on 2021/12/29
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package com.horizon.msgbot.bot.api

import com.caoccao.javet.annotations.V8Function
import com.caoccao.javet.values.reference.V8ValueArray
import com.caoccao.javet.values.reference.V8ValueFunction

class BotClient() {
    private val eventMap: HashMap<String, V8ValueFunction> = hashMapOf()

    @V8Function(name = "on")
    fun on(event: String, function: V8ValueFunction): BotClient {
        eventMap[event] = function
        return this
    }

    @V8Function(name = "addListener")
    fun addListener(event: String, function: V8ValueFunction): BotClient {
        eventMap[event] = function
        return this
    }

    fun emit(event: String, array: V8ValueArray): Boolean {
        if (!eventMap.containsKey(event)) return false
        val v8Func: V8ValueFunction = eventMap[event] ?: return false
        v8Func.callVoid(null, array)
        return true
    }
}
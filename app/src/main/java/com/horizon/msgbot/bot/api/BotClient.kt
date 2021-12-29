/**
 * Created by naijun on 2021/12/29
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package com.horizon.msgbot.bot.api

import com.caoccao.javet.annotations.V8Function
import com.caoccao.javet.values.reference.V8ValueFunction

class BotClient() {
    @V8Function(name = "on")
    fun on(event: String, function: V8ValueFunction) {

    }
}
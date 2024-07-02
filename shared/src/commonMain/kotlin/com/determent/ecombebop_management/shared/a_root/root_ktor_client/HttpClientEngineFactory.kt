@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.determent.ecombebop_management.shared.a_root.root_ktor_client

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory

expect class HttpClientEngineFactory {
    fun createHttpEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
}
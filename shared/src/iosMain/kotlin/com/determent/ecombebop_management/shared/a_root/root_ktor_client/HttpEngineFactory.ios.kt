@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package com.determent.ecombebop_management.shared.a_root.root_ktor_client

import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin

actual class HttpClientEngineFactory {

    actual fun createHttpEngine(): HttpClientEngineFactory<HttpClientEngineConfig> {
        return Darwin
    }

}
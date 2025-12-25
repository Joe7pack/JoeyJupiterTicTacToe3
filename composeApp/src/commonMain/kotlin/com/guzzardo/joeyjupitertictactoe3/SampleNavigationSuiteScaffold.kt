package com.guzzardo.joeyjupitertictactoe3

/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.window.core.layout.WindowSizeClass.Companion.WIDTH_DP_EXPANDED_LOWER_BOUND
import joeyjupitertictactoe3.composeapp.generated.resources.Res
import joeyjupitertictactoe3.composeapp.generated.resources.homeicon
import joeyjupitertictactoe3.composeapp.generated.resources.shopping
import joeyjupitertictactoe3.composeapp.generated.resources.planets_array
import org.jetbrains.compose.resources.StringArrayResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

/* enum class AppDestinations(
    @StringRes val label: String,
    val icon: ImageVector,
    @StringRes val contentDescription: Int
) {
    //HOME(R.string.home, Icons.Default.Home, R.string.home),
    HOME(stringResource(Res.string.home), Icons.Default.Home, R.string.home),
    FAVORITES(R.string.favorites, Icons.Default.Favorite, R.string.favorites),
    SHOPPING(R.string.shopping, Icons.Default.ShoppingCart, R.string.shopping),
    PROFILE(R.string.profile, Icons.Default.AccountBox, R.string.profile),
}
 */

var planetList = Res.array.planets_array

@Composable
fun Icons() {
    Icon(
        painter = painterResource(Res.drawable.homeicon),
        contentDescription = stringResource( Res.string.shopping)
    )
}

// replace AppDestinations.entries.forEach with planetList.forEach
@Composable
fun planets(): StringArrayResource /* stringArrayResource List<String> */ {
    planetList  = Res.array.planets_array
    return planetList
}

@Composable
fun SampleNavigationSuiteScaffoldParts() {
    // [START android_compose_adaptivelayouts_sample_navigation_suite_scaffold_remember]
    //var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }
    var currentDestination by rememberSaveable { mutableStateOf(planetList) }
    // [END android_compose_adaptivelayouts_sample_navigation_suite_scaffold_remember]

    // [START android_compose_adaptivelayouts_sample_navigation_suite_scaffold_items]
    NavigationSuiteScaffold(
        navigationSuiteItems = {
            //AppDestinations.entries.forEach {
            arrayOf(planetList).forEach {  planet ->
                item(
                    icon = {
                        Icon(
                             painter = painterResource(Res.drawable.homeicon),
                             contentDescription = stringResource( Res.string.shopping)
                        )
                    },
                    label = { Text(stringResource(Res.string.shopping)) },
                    selected = true, //currentDestination,
                    onClick = {currentDestination}
                )
            }
        }
    ) {
        // TODO: Destination content.
    }
    // [END android_compose_adaptivelayouts_sample_navigation_suite_scaffold_items]

    // [START android_compose_adaptivelayouts_sample_navigation_suite_scaffold_content]
    NavigationSuiteScaffold(
        navigationSuiteItems = { /*...*/ }
    ) {
        HomeDestination()
        // Destination content.
        /*
        when (currentDestination) {
            AppDestinations.HOME -> HomeDestination()
            AppDestinations.FAVORITES -> FavoritesDestination()
            AppDestinations.SHOPPING -> ShoppingDestination()
            AppDestinations.PROFILE -> ProfileDestination()
        } */
    }
    // [END android_compose_adaptivelayouts_sample_navigation_suite_scaffold_content]
}


@Composable
fun SampleNavigationSuiteScaffoldCustomType() {
    // [START android_compose_adaptivelayouts_sample_navigation_suite_scaffold_layout_type]
    val adaptiveInfo = currentWindowAdaptiveInfo()
    val customNavSuiteType = with(adaptiveInfo) {
        if (windowSizeClass.isWidthAtLeastBreakpoint(WIDTH_DP_EXPANDED_LOWER_BOUND)) {
            NavigationSuiteType.NavigationDrawer
        } else {
            NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(adaptiveInfo)
        }
    }

    NavigationSuiteScaffold(
        navigationSuiteItems = { /* ... */ },
        layoutType = customNavSuiteType,
    ) {
        // Content...
    }
    // [END android_compose_adaptivelayouts_sample_navigation_suite_scaffold_layout_type]
}

@Composable
fun HomeDestination() {}

@Composable
fun FavoritesDestination() {}

@Composable
fun ShoppingDestination() {}

@Composable
fun ProfileDestination() {}
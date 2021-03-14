/*
 * Copyright 2021 The Android Open Source Project
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
package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class ListItemDto(
    val title: String,
    @DrawableRes val image: Int,
)

object Repository {

    val favoriteCollectionItems: List<ListItemDto> =
        listOf(
            ListItemDto("Short mantras", R.drawable.image_short_mantras),
            ListItemDto("Nature meditations", R.drawable.image_nature_meditations),
            ListItemDto("Stress and anxiety", R.drawable.image_stress_and_anxiety),
            ListItemDto("Self-massage", R.drawable.image_self_massage),
            ListItemDto("Overwhelmed", R.drawable.image_overhelmed),
            ListItemDto("Nightly wind down", R.drawable.image_nightly_wind_down)
        )

    val alignYourBodyListItems: List<ListItemDto> =
        listOf(
            ListItemDto("Inversions", R.drawable.image_inversions),
            ListItemDto("Quick yoga", R.drawable.image_quck_yoga),
            ListItemDto("Stretching", R.drawable.image_stretchings),
            ListItemDto("Tabata", R.drawable.image_tabata),
            ListItemDto("Pre-natal yoga", R.drawable.image_pre_natal_yoga)
        )

    val alignYourMindListItems: List<ListItemDto> =
        listOf(
            ListItemDto("Meditate", R.drawable.image_meditate),
            ListItemDto("With kids", R.drawable.image_with_kids),
            ListItemDto("Aromatherapy", R.drawable.image_aromatherapy),
            ListItemDto("On the go", R.drawable.image_on_the_go),
            ListItemDto("With pets", R.drawable.image_with_pets),
            ListItemDto("High stress", R.drawable.image_high_stress)
        )
}

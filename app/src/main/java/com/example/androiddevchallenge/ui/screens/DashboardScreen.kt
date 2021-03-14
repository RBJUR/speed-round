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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.components.CardItemList
import com.example.androiddevchallenge.components.CircleItemList
import com.example.androiddevchallenge.components.MySootheEditText
import com.example.androiddevchallenge.data.Repository
import com.example.androiddevchallenge.ui.theme.typography
import java.util.Locale

@Composable
fun DashboardScreen() {
    Scaffold(
        modifier = Modifier.padding(top = 24.dp),
        backgroundColor = MaterialTheme.colors.background
    ) { innerPadding ->
        DashboardContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun DashboardContent(modifier: Modifier = Modifier) {
    val scrollableState = rememberScrollState()
    val (searchKey, setSearchKey) = remember { mutableStateOf("") }
    Column(modifier.scrollable(scrollableState, Orientation.Vertical)) {

        MySootheEditText(
            modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp),
            value = searchKey,
            onValueChange = setSearchKey,
            placeholderText = "Search",
            leadingIcon = Icons.Default.Search
        )

        SectionTitle("Favorite")
        Spacer(Modifier.size(8.dp))
        CardItemList(Repository.favoriteCollectionItems)

        SectionTitle("For Body")
        Spacer(Modifier.size(8.dp))
        CircleItemList(Repository.alignYourBodyListItems)

        SectionTitle("For Mind")
        Spacer(Modifier.size(8.dp))
        CircleItemList(Repository.alignYourMindListItems)
    }
}

@Composable
fun SectionTitle(title: String) =
    Text(
        text = title.toUpperCase(Locale.getDefault()),
        modifier = Modifier.paddingFromBaseline(top = 40.dp, bottom = 8.dp).padding(start = 16.dp),
        color = MaterialTheme.colors.onBackground,
        style = typography.h2
    )

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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.components.MySootheBackground
import com.example.androiddevchallenge.components.MySootheButton
import com.example.androiddevchallenge.components.MySootheEditText
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography
import java.util.Locale

@Composable
fun LoginScreen(onLoginButtonClick: () -> Unit) {
    val (emailAddress, setEmailAddress) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }
    MySootheBackground(R.drawable.ic_bg_login) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.paddingFromBaseline(top = 200.dp, bottom = 32.dp),
                text = "Log in".toUpperCase(Locale.getDefault()),
                style = typography.h1
            )
            MySootheEditText(
                value = emailAddress,
                onValueChange = setEmailAddress,
                placeholderText = "E-mail address"
            )
            Spacer(Modifier.size(8.dp))
            MySootheEditText(
                value = password,
                onValueChange = setPassword,
                placeholderText = "Password",
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(Modifier.size(8.dp))
            MySootheButton(
                text = "Log in",
                backgroundColor = colors.primary,
                contentColor = colors.onPrimary,
                onClick = onLoginButtonClick
            )
            Text(
                modifier = Modifier.paddingFromBaseline(top = 32.dp),
                text = buildAnnotatedString {
                    append("Don't have an account?")
                    append(" ")
                    withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("Sign up")
                    }
                },
                color = colors.onBackground,
                style = typography.body1
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    MyTheme {
        LoginScreen(onLoginButtonClick = { })
    }
}

package app.map.harrypotter.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.map.harrypotter.R
import app.map.harrypotter.domain.common.Error

@Composable
fun ErrorScreen(error: Error) {
    val errorMessage = when (error) {
        Error.Connectivity -> stringResource(id = R.string.error_connectivity)
        is Error.Server -> stringResource(id = R.string.error_server, error.code)
        is Error.Unknown -> stringResource(id = R.string.error_unexpected)
    }

    Box(modifier = Modifier.fillMaxSize().testTag("ErrorBox"), contentAlignment = Alignment.TopEnd) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Warning,
                contentDescription = errorMessage,
                modifier = Modifier.size(128.dp),
                tint = MaterialTheme.colorScheme.error
            )
            Text(
                text = errorMessage,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.testTag("ErrorMessage")
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    ErrorScreen(error = Error.Connectivity)
}
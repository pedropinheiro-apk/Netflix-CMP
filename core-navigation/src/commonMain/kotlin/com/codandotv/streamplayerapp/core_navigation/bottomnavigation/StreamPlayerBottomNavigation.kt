package com.codandotv.streamplayerapp.core_navigation.bottomnavigation

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun StreamPlayerBottomNavigation(
    modifier: Modifier = Modifier,
) {
    val backStack = LocalBackStackProvider.current

    var selectedItem by remember { mutableStateOf(BottomNavItem.Home) }

    NavigationBar(
        modifier = modifier.height(72.dp),
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onBackground,
    ) {
        BottomNavItem
            .entries
            .forEach { item ->
                key(item.title) {
                    val isSelected = remember(selectedItem.title) {
                        selectedItem.screenRoute == item.screenRoute
                    }

                    NavigationBarItem(
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.onBackground,
                            unselectedIconColor = MaterialTheme.colorScheme.surfaceVariant,
                            selectedTextColor = MaterialTheme.colorScheme.onBackground,
                            unselectedTextColor = MaterialTheme.colorScheme.surfaceVariant,
                            indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                                LocalAbsoluteTonalElevation.current
                            )
                        ),
                        icon = {
                            NavItemIcon(
                                item = item,
                                isSelected = isSelected,
                            )
                        },
                        label = {
                            Text(
                                text = stringResource(item.title),
                                style = MaterialTheme.typography.bodySmall,
                            )
                        },
                        selected = isSelected,
                        onClick = {
                            selectedItem = item
                            backStack.add(item.screenRoute)
                        }
                    )
                }
            }
    }
}

@Composable
private fun NavItemIcon(
    item: BottomNavItem,
    isSelected: Boolean,
) {
    Icon(
        contentDescription = stringResource(item.title),
        painter = painterResource(if (isSelected) item.iconSelected else item.iconUnselected),
    )
}

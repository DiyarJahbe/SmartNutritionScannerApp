package com.example.smartnutritionscannerapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartnutritionscannerapp.domain.model.Recommendation
import com.example.smartnutritionscannerapp.presentation.theme.BulkingRed
import com.example.smartnutritionscannerapp.presentation.theme.HealthyGreen
import com.example.smartnutritionscannerapp.presentation.theme.NeutralYellow

/**
 * Color-coded recommendation badge.
 * - Green → Cutting / Healthy
 * - Red → Bulking / Energy-dense
 * - Yellow → Neutral
 */
@Composable
fun RecommendationBadge(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {
    val bgColor: Color
    val textColor: Color
    val label: String
    val icon: ImageVector

    when (recommendation) {
        Recommendation.CUTTING -> {
            bgColor = HealthyGreen.copy(alpha = 0.15f)
            textColor = HealthyGreen
            label = "Cutting / Healthy"
            icon = Icons.Default.LocalFireDepartment
        }
        Recommendation.BULKING -> {
            bgColor = BulkingRed.copy(alpha = 0.15f)
            textColor = BulkingRed
            label = "Bulking / Energy-Dense"
            icon = Icons.Default.FitnessCenter
        }
        Recommendation.NEUTRAL -> {
            bgColor = NeutralYellow.copy(alpha = 0.15f)
            textColor = NeutralYellow.copy(alpha = 0.85f)
            label = "Neutral"
            icon = Icons.Default.Balance
        }
    }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .background(bgColor)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = textColor,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = label,
            color = textColor,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
    }
}

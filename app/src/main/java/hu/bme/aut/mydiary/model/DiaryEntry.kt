package hu.bme.aut.mydiary.model

import java.util.*

class DiaryEntry (
    val title: String,
    val text: String,
    val isPersonal: Boolean,
    val place: String,
    val creationDate: Date
) { }
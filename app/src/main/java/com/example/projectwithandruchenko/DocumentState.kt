package com.example.projectwithandruchenko

import java.sql.DriverManager


class Document {
    var defaultState: DocumentState = DocumentState.Empty("opened")

    fun accessDocument(state: DocumentState) {
        DriverManager.println("Document is in start  State = $state")
        defaultState = when (state) {
            is DocumentState.Empty -> DocumentState.Editing("Editing")
            is DocumentState.Editing -> DocumentState.Save("Saving")
            is DocumentState.Save -> DocumentState.Save("Close")
            is DocumentState.Close -> DocumentState.Save("Opened")
        }
        DriverManager.println("Document is in now State = $defaultState")
    }

}

sealed class DocumentState {
    data class Empty(val stateName: String) : DocumentState()
    data class Editing(val stateName: String) : DocumentState()
    data class Save(val stateName: String) : DocumentState()
    data class Close(val stateName: String) : DocumentState()
}

package cd.wayupdev.mzr.ui.screen.addpost.business

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cd.wayupdev.mzr.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.net.URI
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
class AddPostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    private val _addPostState = MutableStateFlow<AddPostState>(AddPostState.Uninitialized)
    val addPostState: StateFlow<AddPostState>
        get() = _addPostState

    fun addPost(title: String, description: String, uri: Uri) = viewModelScope.launch {
        _addPostState.emit(AddPostState.Loading)
        try {
            postRepository.add(title, description, uri)
            _addPostState.emit(AddPostState.Success)
        } catch (t: Throwable) {
            _addPostState.emit(AddPostState.Error(t.message.toString()))
        }
    }

    fun delete(contactUid: String) = viewModelScope.launch {
        //contactRepository.delete(contactUid = contactUid)
    }
}
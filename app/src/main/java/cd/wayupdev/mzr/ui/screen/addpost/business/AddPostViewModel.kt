package cd.wayupdev.mzr.ui.screen.addpost.business

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cd.wayupdev.mzr.data.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
class AddPostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    private val _addPostState = MutableStateFlow<AddPostState>(AddPostState.Uninitialized)
    val addPostState: StateFlow<AddPostState>
        get() = _addPostState

    fun addPost(name: String, phone: String) = viewModelScope.launch {
        _addPostState.emit(AddPostState.Loading)
        try {
            postRepository.add(name, phone)
            _addPostState.emit(AddPostState.Success)
        } catch (t: Throwable) {
            _addPostState.emit(AddPostState.Error(t.message.toString()))
        }
    }

    fun delete(contactUid: String) = viewModelScope.launch {
        //contactRepository.delete(contactUid = contactUid)
    }
}
package cd.wayupdev.mzr.ui.screen.home.business

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cd.wayupdev.mzr.data.model.Post
import cd.wayupdev.mzr.data.repository.PostRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    private val _data = MutableStateFlow<HomeState>(HomeState.Uninitialized)
    val data: StateFlow<HomeState>
        get() = _data

    init {
        getAllPost()
    }

    @ExperimentalCoroutinesApi
    private fun getAllPost() = viewModelScope.launch {
        _data.emit(HomeState.Loading)
        try {
            postRepository.getAll().collect { posts ->
                _data.emit(HomeState.Success(posts = posts as ArrayList<Post>))
            }
        } catch (t: Throwable) {
            _data.emit(HomeState.Error(t.message.toString()))
        }
    }
}
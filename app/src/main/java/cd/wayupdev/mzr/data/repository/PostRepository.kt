package cd.wayupdev.mzr.data.repository

import cd.wayupdev.mzr.data.model.Post
import cd.wayupdev.mzr.data.util.FireBaseConstants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import java.util.*
import javax.inject.Inject

class PostRepository @Inject constructor(private val firebaseAuth: FirebaseAuth, private val firestore: FirebaseFirestore) {

    private val currentUser by lazy {
        firebaseAuth.currentUser
    }

    fun getByUid(uid: String) {
        //TODO
    }

    @ExperimentalCoroutinesApi
    fun getAll() = callbackFlow {
        firestore.collection("${FireBaseConstants.admins}/${currentUser?.uid.toString()}/${FireBaseConstants.posts}").addSnapshotListener { value, error ->
            if (error != null && value == null) {
                close(error)
            }

            value?.toObjects(Post::class.java).let { contacts ->
                if (!isClosedForSend) {
                    trySend(contacts)
                }
            }
        }
        awaitClose()
    }.catch {
        throw it
    }.flowOn(Dispatchers.IO)

    suspend fun add(title: String, imageUrl: String, description: String) {
        val contact = Post(uid = title, title = title, adminUid = currentUser?.uid.toString(), description = description, imageUrl = imageUrl, createdAt = Date(System.currentTimeMillis()))
        val doc = firestore.document("${FireBaseConstants.admins}/${currentUser?.uid.toString()}/${FireBaseConstants.posts}/${contact.uid}")
        doc.set(contact).await()
    }

    suspend fun delete(contactUid: String) {
        firestore.document("${FireBaseConstants.admins}/${currentUser?.uid.toString()}/${FireBaseConstants.posts}/${contactUid}").delete().await()
    }

    suspend fun updated(post: Post) {
        //TODO
    }
}
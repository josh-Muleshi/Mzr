package cd.wayupdev.mzr.data.repository

import cd.wayupdev.mzr.data.model.Admin
import cd.wayupdev.mzr.data.util.FireBaseConstants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.util.*
import javax.inject.Inject

class AdminRepository @Inject constructor(private val firebaseAuth: FirebaseAuth, private val firestore: FirebaseFirestore) {

    private val currentUser by lazy {
        firebaseAuth.currentUser
    }

    suspend fun register(email: String, password: String) {
        firebaseAuth.signInAnonymously().await()
        firestore.document("${FireBaseConstants.admins}/${FireBaseConstants.auth}")
            .set(Admin(uid = currentUser?.uid.toString(), email = email, password = password, createdAt = Date(System.currentTimeMillis()))).await()
    }

    @ExperimentalCoroutinesApi
    suspend fun getCurrentAdmin() = callbackFlow {
        firestore.document("${FireBaseConstants.admins}/${currentUser?.uid.toString()}").addSnapshotListener { value, error ->
            if (error != null && value == null) {
                close(error)
            }

            value?.toObject(Admin::class.java).let { user ->
                if (!isClosedForSend) {
                    trySend(user)
                }
            }
        }
        awaitClose()
    }

    @ExperimentalCoroutinesApi
    suspend fun getAdmin() = callbackFlow {
        firestore.document("${FireBaseConstants.admins}/${FireBaseConstants.auth}").addSnapshotListener { value, error ->
            if (error != null && value == null) {
                close(error)
            }

            value?.toObject(Admin::class.java).let { admin ->
                if (!isClosedForSend) {
                    trySend(admin)
                }
            }
        }
        awaitClose()
    }
}
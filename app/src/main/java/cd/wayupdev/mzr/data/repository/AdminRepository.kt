package cd.wayupdev.mzr.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class AdminRepository @Inject constructor(private val firebaseAuth: FirebaseAuth, private val firebaseFirestore: FirebaseFirestore) {

    private val currentUser by lazy {
        firebaseAuth.currentUser
    }


}
package max.ohm.privatechat.presentation.viewmodel

import android.app.Activity
import android.util.Log
import androidx.browser.trusted.Token
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import max.ohm.privatechat.models.PhoneAuthUser
import javax.inject.Inject


// Hilt make object of class
@HiltViewModel
class PhoneAuthViewModel @Inject constructor(
    private  val firebaseAuth: FirebaseAuth,
    private val database: FirebaseDatabase

): ViewModel() {

      // authentication state private (ideal - nothing)
    private val _authState= MutableStateFlow<AuthState>(AuthState.Ideal)
    // authentication state public
    val authState= _authState.asStateFlow()

  // create data base reference make nodes
    // save user data
    private val userRef = database.reference.child("users")


    fun senderVerificationCode(phoneNumber:String, activity:Activity){
        // ideal to loading state
     _authState.value= AuthState.Loading

        val option= object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(id, token)
                // log detect codesend or not
                Log.d("PhoneAuth", "onCodeSent triggered. verification ID: $id")
                _authState.value= AuthState.CodeSent(verificationId = id)

            }

            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                TODO("Not yet implemented")
            }

            override fun onVerificationFailed(exception: FirebaseException) {
               Log.e("PhoneAuth", "Verification failed : ${exception.message}")
                _authState.value= AuthState.Error(exception.message ?: "Verification failed")

            }

        }

    }

}

//event are fixed thats why we use sealed class

sealed class AuthState{

    object Ideal: AuthState()   // do nothing
    object Loading: AuthState()  // data comes or goes
    data class CodeSent(val verificationId: String): AuthState() // phone number send
    data class Success(val user: PhoneAuthUser): AuthState() // successfully authentication complete
    data class Error(val message:String): AuthState()  // any error issue

}
package com.sahilprojects.sampleproject.network


interface WebService {

    interface CommonResponses {
        fun onInvalidToken(q:String)
        fun onNetworkError(q:String)
        fun onUnknownError(q:String)
        fun onNullResponse(q:String)

    }

    interface FaceInteractor{

        interface  EnrollFace : CommonResponses {

            fun onFaceEnrollSuccess()
        }
        fun enroll_face(token: String,uid: String, embeddings : String,orgId: Int, callback: EnrollFace)


    }
    fun faceInteractor() : FaceInteractor

}
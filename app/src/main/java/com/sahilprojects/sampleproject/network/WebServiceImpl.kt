package com.sahilprojects.sampleproject.network

class WebServiceImpl : WebService {

    private lateinit var mFaceInteractor: WebService.FaceInteractor



    override fun faceInteractor(): WebService.FaceInteractor {
        if (!::mFaceInteractor.isInitialized) mFaceInteractor = createFaceInteractor()
        return mFaceInteractor
    }


    private fun createFaceInteractor(): WebService.FaceInteractor {
        return object  : WebService.FaceInteractor {
            override fun enroll_face(token: String, uid: String, embeddings: String,orgId: Int, callback: WebService.FaceInteractor.EnrollFace) {
//                val request = FaceRecognition.EnrollFace.Request(uid,orgId,embeddings)
//                RetrofitClient.forCore().enrollFace(token,request)
//                        .enqueue(object : Callback<CommonResponse>{
//
//                            override fun onResponse(call: Call<CommonResponse>, response: Response<CommonResponse>) {
//                                if(response.body()==null) callback.onNullResponse(request.q)
//                                else {
//                                    val body = response.body() as CommonResponse
//                                    when(body.resultCode) {
//                                       0 -> callback.onFaceEnrollSuccess()
//                                    }
//                                }
//                            }
//
//                            override fun onFailure(call: Call<CommonResponse>, t: Throwable) {
//                                onCommonResponse(t,request.q+"\n${t.message}",callback)
//                            }
//                        })
            }






         }
    }


 }

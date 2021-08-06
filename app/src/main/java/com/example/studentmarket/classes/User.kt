package com.example.studentmarket.classes

/*this class is for the users
params: a username, an email adress a phone number and a password.
Users can be constructed at the registration page, the initialiser will add the user to the database*/
 class User (var username:String,val email: String, var number: Int, var password:String){
    private var userName : String = username
    private var userPassowrd : String = password
//    var userUniversity : String
    //var UserID
    val savedItems = ArrayList<String>()



    init {
        //TODO add the user to the database here and then initialise the variable UserID here
    }

    //region Login
    /*This function is for verifying and logging in a user. Call it on the login screen using the login button
    @Params: userEmail and userPassword*/
    fun Login(){

    }
    //endregion

    //region AddSave
    /*This functions add a product or a service to a user's saved items*/
    fun AddSave(itemId:String ){
        savedItems.add(itemId)

        //TODO add code to add the saved item to the Database and initalise the saved item Id here
    }
    //endregion

    //region FetchSavedItems
    fun FetchSavedItems(): ArrayList<String> {
        return savedItems
        //TODO return the saved ID's from the database and the relevant table information
    }
    //endregion

    //region RemoveSave
    fun RemoveSave(saveId: String){
        //TODO remove the item from the database but first return the items id and remove that from the savedItems array
    }
    //endregion
}
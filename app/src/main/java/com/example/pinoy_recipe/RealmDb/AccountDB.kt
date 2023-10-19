package com.example.pinoy_recipe.RealmDb

import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


class AccountInfo: RealmObject {
    @PrimaryKey
    var AccountName = ""
    var AccountEmail = ""
    var AccountPassword = ""
}
object AccountDB {
    val configuration = DataBase.configuration
    val realm = Realm.open(configuration)


    fun writeAccount(Aname:String, Aemail:String, Apass:String) {
        val AccInfo = AccountInfo().apply {
            AccountName = Aname
            AccountEmail = Aemail
            AccountPassword = Apass
        }

       realm.writeBlocking {
            copyToRealm(AccInfo)
        }
    }

    fun Emailquery(Email: String, Pass: String): Boolean {
        val all: RealmResults<AccountInfo> = DataBase.realm.query<AccountInfo>().find()
        var isThere = false
        all.forEach(){Unit->
            if(Unit.AccountEmail == Email){
                if(Unit.AccountPassword == Pass){
                    isThere = true
                }
            }
        }
        return isThere
    }

    fun Namequery(Email: String): String {
        val all: RealmResults<AccountInfo> = DataBase.realm.query<AccountInfo>().find()
        var isThere = ""
        all.forEach(){Unit->
            if(Unit.AccountEmail == Email){
                isThere = Unit.AccountName
            }
        }
        return isThere
    }

    fun query(): ArrayList<String> {
        val all: RealmResults<AccountInfo> = DataBase.realm.query<AccountInfo>().find()
        val AccountEmial = arrayListOf("Email")
        val AccountPassword = arrayListOf("Password")
        all.forEach(){Unit->
            AccountEmial.add(Unit.AccountEmail)
            AccountPassword.add(Unit.AccountPassword)
        }
        return AccountPassword
    }
}
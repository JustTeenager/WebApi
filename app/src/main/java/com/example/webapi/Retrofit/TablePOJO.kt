package com.example.webapi.Retrofit

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList
import org.simpleframework.xml.Root

//data class TablePOJO(val Nomer:String,val Date:String,val Comment:String) {}

/*@NamespaceList({
    @Namespace(prefix = "soap", reference = ""),
    @Namespace(prefix = "typ", reference = ""),
    @Namespace(prefix = "ldb", reference = "")
})*/


@Root(name = "row",strict = false)
data class TablePOJO @JvmOverloads constructor(
    @field:Element(name = "Nomer")
    var number: String = "",
    @field:Element(name = "Date")
    var date: String = "",
    @field:Element(name = "Comment")
    var comment: String = "",
)
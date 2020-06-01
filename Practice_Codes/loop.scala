 
val myList = List("Apple","Banana","Orange","Mango")

println("Loop method -1")
var i=0
while(i<myList.length){
	println(myList(i))
	i=i+1
}

println("Loop method-2")
for(i<-0 until myList.length){
	println(myList(i))
}

println("Loop method-3")
for(item<-myList){
        println(item)
}

println("Loop method-4")
myList.foreach(println)


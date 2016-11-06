object Solution extends App {
    val n = readInt()
    if (n % 2 != 0 )
        println("Weird")
    if (n %2 == 0 && (n >= 2 && n <= 5))
        println("Not Weird")
    if (n %2 == 0 && (n >= 6 && n <= 20))    
        println("Weird")
    if (n %2 == 0 && (n > 20))  
        println("Not Weird")        
}

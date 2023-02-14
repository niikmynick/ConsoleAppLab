package Utils.Readers

import BasicClasses.Coordinates

class CoordinatesReader : Reader() {
    companion object {
        fun read() : Coordinates {
            println("Enter value of X: ")
            var x:Double = readln().trim().toDouble()

            while (x.equals(null)) {
                println("You need to enter Double-type value of X .. ")
                x = readln().trim().toDouble()
            }

            println("Enter value of Y: ")
            var y:Long = readln().trim().toLong()

            while (y.equals(null)) {
                println("You need to enter Long-type value of Y: ")
                y = readln().trim().toLong()
            }

            return Coordinates(x, y)
        }
    }
}
package solution.com.graycodes

class GrayCodeUtils {
    companion object {
        fun generate(number: Int): ArrayList<String> {
            val grayCodes = ArrayList<String>()

            if (number <= 0)
                return grayCodes
            grayCodes.add("0")
            grayCodes.add("1")

            var i = 2
            while (i < 1 shl number) {
                for (j in i - 1 downTo 0)
                    grayCodes.add(grayCodes[j])
                for (j in 0 until i)
                    grayCodes[j] = "0${grayCodes[j]}"
                for (j in i until 2 * i)
                    grayCodes[j] = "1${grayCodes[j]}"
                i = i shl 1
            }
            return grayCodes
        }
    }
}
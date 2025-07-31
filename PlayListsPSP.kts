
import java.io.File

main(args)

fun main(args: Array<String>) {
    try {


        if (args.isEmpty()) {
            println("使い方: ./readfile.kts <ファイル名>")
            return
        }
        println("今から処理を始めます")

        if (!(args[0].endsWith(".m3u8") || args[0].endsWith(".txt"))) {
            return
        }


        val playLIst = File(args[0])

        val text: List<String> = playLIst.readLines()
        val outputTextlist = text.map { line ->
            val trimmed = line.trim('"')
    val converted = if (trimmed.startsWith("/MUSIC")) {
        trimmed
    } else {
        val noDrive = trimmed.replace(Regex("^[A-Z]:[\\\\¥]?"), "")
        "/" + noDrive.replace("\\", "/").replace("¥", "/")
    }
    println("処理中だお: $converted")
    converted 
            

        }


        val outputText = outputTextlist.joinToString("\n")
        println("変換は終わったお" + "<" + outputText + ">")




        if (args[0].endsWith(".m3u8")) {


            playLIst.writeText(outputText)
            println("かきこめたお")


        } else if (args[0].endsWith(".txt")) {
            var Fileexistsindex = 0
            var FileexistsindexString = ""


            val Filename = playLIst.nameWithoutExtension
            var newm3u8 = File(Filename + FileexistsindexString + ".m3u8")

            while (newm3u8.exists()) {
                Fileexistsindex += 1
                FileexistsindexString = Fileexistsindex.toString()
            }


            newm3u8.writeText(outputText)
            println("かきこめたお")


        }

        return

    }catch (e: Exception){
        println("エラーだお" + "\n" + e )
        return
    }
}
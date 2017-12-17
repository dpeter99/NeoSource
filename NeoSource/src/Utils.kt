import java.nio.file.Files
import java.nio.file.Paths

fun readFile(file: String): String = String(Files.readAllBytes(Paths.get(file)))
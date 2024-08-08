package repositories

import org.jetbrains.exposed.sql.transactions.TransactionManager
import java.sql.ResultSet

object DBUtils {
    fun <T> String.execAndMap(transform: (ResultSet) -> T): List<T> {
        val result = arrayListOf<T>()
        TransactionManager.current().exec(this) { rs ->
            while (rs.next()) {
                result += transform(rs)
            }
        }


        return result
    }
}
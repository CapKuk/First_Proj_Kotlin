package repository.dataBase

import com.example.server.db.dbQuery
import com.example.server.db.tables.CitiesTemps
import com.example.server.db.tables.toCityTemp
import com.example.common.CityTemp
import com.example.server.repository.dataBase.IDataStore
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class CitiesTempRepository : IDataStore<CityTemp> {

    override suspend fun getAll() = dbQuery {
        CitiesTemps.selectAll().map { it.toCityTemp() }
    }
    override fun get(id: Long): CityTemp? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun add(item: CityTemp) {
        dbQuery {
            CitiesTemps.insert{ insertStatement ->
                insertStatement[city] = item.city
                insertStatement[temp] = item.temp
            }
        }
    }

    override fun get(name: String): CityTemp? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override suspend fun delete(id: Long) {
        dbQuery {
            CitiesTemps.deleteWhere {
                CitiesTemps.id.eq(id)
            }
        }
    }
}
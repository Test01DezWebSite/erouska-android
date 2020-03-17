package cz.covid19cz.app.repository.device

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DeviceDao {

    @Query("SELECT * FROM devices")
    fun findAll(): LiveData<List<Device>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(devices: List<Device>)

    @Query("SELECT * FROM devices WHERE deviceId IN (:deviceIds)")
    fun findAll(deviceIds: IntArray): List<Device>

    @Insert
    fun insertAll(vararg devices: Device)

    @Delete
    fun delete(device: Device)
}
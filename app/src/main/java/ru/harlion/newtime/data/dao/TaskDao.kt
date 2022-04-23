package ru.harlion.newtime.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.harlion.newtime.models.Task


@Dao
interface TaskDao {

    @Update
    fun updateTask(task: Task)

    @Query("SELECT * FROM task WHERE date BETWEEN :start AND :end")
    fun getTasksByTime(start: Long, end: Long) : List<Task>

    @Query("SELECT * FROM task where task.parentId = :parentId")
    fun getTasksByParentId(parentId : Long) : LiveData<List<Task>>

//    @Query("SELECT * FROM task where task.parentId = :parentId")
//    fun getTasksBySprint(parentId : Long) : LiveData<List<Task>>

    @Insert
    fun addTask(task: Task)

    @Query("DELETE FROM task WHERE id = :taskId")
    fun deleteTask(taskId: Long)

}
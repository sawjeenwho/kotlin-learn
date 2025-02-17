package Course.Corporation.Repositories

import Course.Corporation.*
import Course.Corporation.products.Enums.PositionType
import java.io.File

object WorkersRepository {


    private val fileEmployee = File("employee.txt")
    private val _workers = loadAllEmployee()
    val workers
        get() = _workers.toList()

    fun registerNewEmployee(newWorker: Worker) {
        _workers.add(newWorker)
    }

    fun changeSalary(id: Int, newSalary: Int) {
        for (worker in _workers) {
            if (worker.id == id) {
                val newWorker = worker.copy(salary = newSalary)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }

    fun changeAge(id: Int, newAge: Int) {
        for (worker in _workers) {
            if (worker.id == id) {
                val newWorker = worker.copy(age = newAge)
                _workers.remove(worker)
                _workers.add(newWorker)
                break
            }
        }
    }


    fun changeFile() {
        val content = StringBuilder()
        for (worker in _workers) {
            content.append("${worker.id}%${worker.name}%${worker.age}%${worker.salary}%${worker.positionType}\n")
        }
        fileEmployee.writeText(content.toString())
    }

    fun fireAnEmployee(id: Int) {
        for (worker in _workers) {
            if (worker.id == id) {
                _workers.remove(worker)
                break
            }
        }
    }

    fun findAssistant(): Assistant? {
        for (worker in _workers) {
            if (worker is Assistant) {
                return worker
            }
        }
        return null
    }

    fun findDirector(): Director? {
        for (worker in _workers) {
            if (worker is Director) {
                return worker
            }
        }
        return null
    }

    private fun loadAllEmployee(): MutableList<Worker> {
        val employees = mutableListOf<Worker>()
        val employeeAtFile = fileEmployee.readText().trim()
        if (employeeAtFile.isEmpty()) {
            return employees
        }
        val employeesAsString = employeeAtFile.split("\n")
        for (employeeAsString in employeesAsString) {
            val employeeInfo = employeeAsString.split("%")
            val id = employeeInfo[0].toInt()
            val name = employeeInfo[1]
            val age = employeeInfo[2].toInt()
            val salary = employeeInfo[3].toInt()
            val post = employeeInfo.last()
            val positionType = PositionType.valueOf(post)
            val employee = when (positionType) {
                PositionType.DIRECTOR -> Director(id, name, age, salary)
                PositionType.ACCOUNTANT -> Accountant(id, age, name, salary)
                PositionType.ASSISTANT -> Assistant(id, name, age, salary)
                PositionType.CONSULTANT -> Consultant(id, name, age, salary)
            }
            employees.add(employee)
        }
        return employees
    }

}
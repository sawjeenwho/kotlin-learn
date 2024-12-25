package OOP.Corporation.Repositories

import OOP.Corporation.*
import OOP.Corporation.products.Enums.PositionType
import java.io.File

class WorkersRepository {

    private val fileEmployee = File("employee.txt")

    fun registerNewEmployee(worker: Worker) {
        saveNewEmployeeToFile(worker)
    }

    private fun saveNewEmployeeToFile(worker: Worker) {
        fileEmployee.appendText("${worker.id}%${worker.name}%${worker.age}%${worker.getSalary()}%${worker.positionType}\n")
    }

     fun changeSalary(changeSalaryIndex: Int, newSalary: Int) {
        val employees = loadAllEmployee()
        fileEmployee.writeText("")
        for (employee in employees) {
            if (employee.id == changeSalaryIndex) {
                employee.setSalary(newSalary)
            }
            saveNewEmployeeToFile(employee)
        }
    }


    fun fireAnEmployee(id: Int) {
        val employees = loadAllEmployee()
        for (employee in employees) {
            if (employee.id == id) {
                employees.remove(employee)
                break
            }
        }
        fileEmployee.writeText("")
        for (employee in employees) {
            saveNewEmployeeToFile(employee)
        }
    }

    fun loadAllEmployee(): MutableList<Worker> {
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
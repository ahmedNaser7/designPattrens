package behaviouralPatterns

// company
// employee

interface Iterator<T>{
    fun isNext():Boolean
    fun next():T
}

interface Aggregate<T>{
    fun createIterator():Iterator<T>
}

data class Employee(
    val name:String,
    val position: String,
    val salary:Int,
)


class EmployeeIterator(
   private val employees: List<Employee>
):Iterator<Employee>{
    private var index = 0
    override fun isNext(): Boolean {
        return index<employees.size
    }

    override fun next(): Employee {
        return employees[index++]
    }
}

class Company(
    private val employees: List<Employee>
):Aggregate<Employee>{
    override fun createIterator(): Iterator<Employee> {
        return EmployeeIterator(employees)
    }
    fun displayCompanyInfo(){
        employees.forEach {
            println("name : ${it.name} \t position : ${it.position}  \t salary : ${it.salary}")
        }
    }
}

fun main(){
    val employees  = listOf<Employee>(
        Employee("Ahmed","TeamLeader",150000),
        Employee("Kareem","Android developer",12000),
        Employee("Mohammed","Php developer",15000),
        Employee("Yaser",".net developer",3200),
    )
    val company = Company(employees)
    val iterator = company.createIterator()

    // print using iterator
    while(iterator.isNext()){
        println(iterator.next())
    }

    // easy way
    company.displayCompanyInfo()
}


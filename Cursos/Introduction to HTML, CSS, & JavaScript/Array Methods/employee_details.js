const employees = [
      { id: 1, name: 'John Doe', age: 30, department: 'IT', salary: 50000 },
      { id: 2, name: 'Alice Smith', age: 28, department: 'HR', salary: 45000 },
      { id: 3, name: 'Bob Johnson', age: 35, department: 'Finance', salary: 60000 },
      //... Mais registros de funcionários podem ser adicionados aqui
    ];


// Função para exibir todos os funcionários
function displayEmployees() {
    const totalEmployees = employees
        .map(employee => `<p>${employee.id}: ${employee.name} - ${employee.department} - ${employee.salary}</p>`) //Map recriando o array colocando uma String em cada index! 
        .join(''); //Pega o array de Strings e concatena todos os index em uma unica String!
    document.getElementById('c').innerHTML = totalEmployees; //Coloca o resultado na tela atraves do id: employeesDetails
}


function calculateTotalSalaries() {
      const totalSalaries = employees.reduce((acc, employee) => acc + employee.salary, 0); //acc = acumulador! employee = elemento atual. callback termina em employee.salary! acc = 0 na primeira repeticao.
      alert(`Total Salaries: ${totalSalaries}`); //Mostra o resultado como um alerta para o navegador.
    }


function displayHREmployees() {
     const hrEmployees = employees.filter(employee => employee.department === 'HR'); //filter recriando o array apenas com os dados que passam em certa condição.
      const hrEmployeesDisplay = hrEmployees.map((employee, index) => `<p>${employee.id}: ${employee.name}: ${employee.name} - ${employee.department} - ${employee.salary}</p>`).join(''); //Map recriando o array colocando uma String em cada index!
      document.getElementById('employeesDetails').innerHTML = hrEmployeesDisplay; //Coloca o resultado na tela atraves do id: employeesDetails
}


function findEmployeeById(employeeId) {
      const foundEmployee = employees.find(employee => employee.id === employeeId); //Encontra a primeira aparição do dado informado para pesquisa. 
      if (foundEmployee) { //Se tem alguma coisa na variavel mostra na tela!
      document.getElementById('employeesDetails').innerHTML =`<p>${foundEmployee.id}: ${foundEmployee.name}: ${foundEmployee.name} - ${foundEmployee.department} - ${foundEmployee.salary}</p>`;
      }
      else{
        document.getElementById('employeesDetails').innerHTML = 'nenhum funcionário foi encontrado com este ID';
       }
   }

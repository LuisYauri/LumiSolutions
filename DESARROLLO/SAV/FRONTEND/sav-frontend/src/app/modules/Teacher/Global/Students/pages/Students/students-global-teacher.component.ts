import {Component, OnInit} from '@angular/core';
import {StudentsGlobalTeacherModel} from "../../model/students-global-teacher.model";

@Component({
  selector: 'app-students-global-teacher',
  templateUrl: './students-global-teacher.component.html',
  styleUrls: ['./students-global-teacher.component.scss']
})
export class StudentsGlobalTeacherComponent implements OnInit {

  varHeader = {
    title: 'Mis Estudiantes',
    icon: 'profile',
    url: ''
  }

  varTitle = 'Banco de estudiantes'
  varLoading = false

  listStudents: StudentsGlobalTeacherModel[]
  tempListStudents: StudentsGlobalTeacherModel[]
  listOfDisplayData: StudentsGlobalTeacherModel[]

  searchValue = '';
  sortName: string | null = null;
  sortValue: string | null = null;
  listOfFilterAddress = [{text: 'London', value: 'London'}, {text: 'Sidney', value: 'Sidney'}];
  listOfSearchAddress: string[] = [];


  constructor() {
  }

  ngOnInit() {
    this.getListStudents()
  }

  getListStudents() {
    this.varLoading = true
    this.listStudents = [
      {
        "idEstudiante": 1,
        "nombre": "David ",
        "aPaterno": "asxc",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      },
      {
        "idEstudiante": 2,
        "nombre": "Luis",
        "aPaterno": "ertret",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      },
      {
        "idEstudiante": 2,
        "nombre": "Asdffg",
        "aPaterno": "trhg",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      }, {
        "idEstudiante": 2,
        "nombre": "Bxvxcv",
        "aPaterno": "jhjjh",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      }, {
        "idEstudiante": 2,
        "nombre": "Cvcbcvb",
        "aPaterno": "jhhj",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      }, {
        "idEstudiante": 2,
        "nombre": "Drecxkpo",
        "aPaterno": "kjkkj",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      }, {
        "idEstudiante": 2,
        "nombre": "vnpijuE",
        "aPaterno": "hjhjjh",
        "aMaterno": "Martinez",
        "usuario": "LuisYauri"
      }
    ]
    this.tempListStudents = this.generateTempListStudents(this.listStudents)
    this.varLoading = false
  }

  reset(): void {
    this.searchValue = '';
    this.listStudents = [...this.tempListStudents]
  }

  search(): void {
    let le = this
    const filterData = this.tempListStudents.filter(function (item: StudentsGlobalTeacherModel) {
      return item.aPaterno.indexOf(le.searchValue) !== -1
    });
    this.listStudents = [...filterData]
  }

  private generateTempListStudents(listStudents: StudentsGlobalTeacherModel[]) {
    return listStudents;
  }

  openEditStudent(data: any) {
    
  }

  openDeleteStudent(data: any) {
    
  }
}
